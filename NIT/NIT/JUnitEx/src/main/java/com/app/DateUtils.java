package com.app;

public class DateUtils implements Cloneable {
	
	private static DateUtils instance=null;
	private DateUtils() {
		
	}

	protected Object clone() throws CloneNotSupportedException{
		return null;
	}
	
	public static DateUtils getInstance() {
		if (instance==null) {
			instance=new DateUtils();
		}
		
		return instance;
	}
}
