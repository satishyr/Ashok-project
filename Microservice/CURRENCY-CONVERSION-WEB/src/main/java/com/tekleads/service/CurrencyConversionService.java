package com.tekleads.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.tekleads.domain.CurrencyConversionFormBean;
import com.tekleads.response.CurrencyConversionResponseBean;

@Service
public class CurrencyConversionService {

	private static final String CC_REST_ENDPONT = "http://tekleads-cc-api.cfapps.io/convert/from/{from}/to/{to}/quantity/{quantity}";

	/**
	 * This method is used to inovke CC api
	 * @param formBean
	 * @return CurrencyConversionResponseBean
	 */
	public CurrencyConversionResponseBean convertCurrency(CurrencyConversionFormBean formBean) {
		Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
							  
		CurrencyConversionResponseBean responseBean =
				     webClient.get()
							  .uri(CC_REST_ENDPONT,formBean.getFrom().toUpperCase(),formBean.getTo().toUpperCase(),formBean.getQuantity())
							  .retrieve()
							  .bodyToMono(CurrencyConversionResponseBean.class)
							  .block();
		return responseBean;
	}
}
