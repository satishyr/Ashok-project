package com.tekleads.domain;

import lombok.Data;

@Data
public class CurrencyConversionFormBean {

	private String from;
	private String to;
	private Integer quantity;

}
