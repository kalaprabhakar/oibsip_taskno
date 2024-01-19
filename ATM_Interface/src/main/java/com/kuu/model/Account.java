package com.kuu.model;

import lombok.Data;
import lombok.Setter;

@Data
public class Account {
	
	
	private int acc_no ;
	private int pin ;
	private String name ;
	private float bal;
	private String acctype;

}
