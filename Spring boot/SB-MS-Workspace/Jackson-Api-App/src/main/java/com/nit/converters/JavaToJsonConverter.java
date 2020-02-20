package com.nit.converters;

import org.codehaus.jackson.map.ObjectMapper;

import com.nit.domain.Person;

public class JavaToJsonConverter {

	public static void main(String[] args) throws Exception {

		Person p = new Person();
		p.setPersonId(101);
		p.setPersonName("John");
		p.setPersonEmail("john@gmail.com");

		ObjectMapper mapper = new ObjectMapper();
		String personJson = mapper.writeValueAsString(p);
		System.out.println(personJson);
		// =======================================//
		Person p1 = mapper.readValue(personJson, Person.class);
		System.out.println(p1);

	}

}
