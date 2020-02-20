package com.nit.converters;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.nit.bindings.Customer;

public class Converter {

	public static void convertXmlToObj() throws Exception {
		File f = new File("Customer.xml");

		JAXBContext ctxt = JAXBContext.newInstance(Customer.class);

		Unmarshaller unmarshaller = ctxt.createUnmarshaller();

		// Converting xml to java object
		Customer c = (Customer) unmarshaller.unmarshal(f);

		System.out.println(c);

	}

	public static void convertObjToXml() throws Exception {

		Customer c = new Customer();// binding object
		c.setCustomerId(101);
		c.setCustomerName("John");
		c.setCustomerEmail("john@gmail.com");
		c.setCustomerType("old");

		JAXBContext ctxt = JAXBContext.newInstance(Customer.class);

		Marshaller marshaller = ctxt.createMarshaller();

		// converting java obj to xml
		marshaller.marshal(c, System.out);

	}

	public static void main(String[] args) throws Exception {
		convertObjToXml();
		//convertXmlToObj();
	}
}
