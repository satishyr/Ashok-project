package com.sai.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(value="Accounts",description="Accounts resource representation")
public class Accounts implements  Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -8157746641856487030L;

@Id
@ApiModelProperty(notes="accountid for account")
private Integer accountid;
@ApiModelProperty(notes="account holder name")
private String name;
@ApiModelProperty(notes="account type(savings or current)")
private String type;

public Integer getAccountid() {
	return accountid;
}
public void setAccountid(Integer accountid) {
	this.accountid = accountid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


}
