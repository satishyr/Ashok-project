package com.tekleads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekleads.beans.CurrencyCostBean;
import com.tekleads.beans.CurrencyExchangeBean;
import com.tekleads.feign.CurrencyExchangeClient;

@Service
public class CurrencyConversionService {

	//private static final String CURRENCY_EXCHANGE_URL = "https://tekleads-ce-api.cfapps.io/getCurrencyExchangeCost/from/{from}/to/{to}";

	@Autowired
	private CurrencyExchangeClient ceClient;
	
	public CurrencyCostBean convertCurrency(String from, String to, Double quantity) {
		CurrencyCostBean bean = new CurrencyCostBean();

		/*Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		CurrencyExchangeBean currencyExchangeBean = webClient.get()
				.uri(CURRENCY_EXCHANGE_URL, from, to)
				.retrieve()
				.bodyToMono(CurrencyExchangeBean.class)
				.block();*/
		
		CurrencyExchangeBean currencyExchangeBean =
							ceClient.invokeCeApi(from, to);

		Double currencyCost = currencyExchangeBean.getCurrencyValue();

		Double currencyTotalAmt = quantity * currencyCost;

		bean.setCurrencyFrom(from);
		bean.setCurrencyTo(to);
		bean.setTotalCurrencyAmt(currencyTotalAmt);

		return bean;
	}

}
