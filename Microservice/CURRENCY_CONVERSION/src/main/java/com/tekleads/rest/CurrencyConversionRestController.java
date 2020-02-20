package com.tekleads.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tekleads.beans.CurrencyCostBean;
import com.tekleads.service.CurrencyConversionService;

@RestController
public class CurrencyConversionRestController {

	@Autowired
	private CurrencyConversionService conversionService;

	@GetMapping(
			value = "/convert/from/{from}/to/{to}/quantity/{quantity}",
			produces="application/json"
	)
	public CurrencyCostBean convertCurrency(
			@PathVariable("from") String from, 
			@PathVariable("to") String to,
			@PathVariable("quantity") Double quantity) {

		CurrencyCostBean currencyCostBean = conversionService.convertCurrency(from, to, quantity);

		return currencyCostBean;

	}

}
