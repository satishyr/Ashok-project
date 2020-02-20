package com.tekleads.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tekleads.beans.CurrencyExchangeBean;
import com.tekleads.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeRestController {

	@Autowired
	private CurrencyExchangeService exchangeService;

	@GetMapping(value = "/getCurrencyExchangeCost/from/{from}/to/{to}", produces = "application/json")
	public CurrencyExchangeBean getCurrencyCostDtls(@PathVariable("from") String from, @PathVariable("to") String to) {
		CurrencyExchangeBean currencyCostBean = exchangeService.findCurrencyValue(from, to);
		return currencyCostBean;
	}

}
