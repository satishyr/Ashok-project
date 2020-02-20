package com.tekleads.response;

import lombok.Data;

@Data
public class CurrencyConversionResponseBean {

	private String currencyFrom;
	private String currencyTo;
	private Double totalCurrencyAmt;

}
