package com.tekleads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tekleads.domain.CurrencyConversionFormBean;
import com.tekleads.response.CurrencyConversionResponseBean;
import com.tekleads.service.CurrencyConversionService;

@Controller
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService service;

	@RequestMapping(value = "/")
	public String displayForm(Model model) {
		CurrencyConversionFormBean formBean = new CurrencyConversionFormBean();

		// sending data from controller to UI
		model.addAttribute("currencyFormBean", formBean);

		// returning Logical View Name
		return "conversionForm";
	}

	@RequestMapping(value = "/convertCurrency", method = RequestMethod.POST)
	public String handleConvertBtn(@ModelAttribute("currencyFormBean") CurrencyConversionFormBean formBean,
			Model model) {
		CurrencyConversionResponseBean responseBean = service.convertCurrency(formBean);
		model.addAttribute("responseBean", responseBean);
		return "conversionForm";
	}
}
