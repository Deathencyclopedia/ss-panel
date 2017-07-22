package com.dep.sspanel.util.type;

/**
* @author Maclaine E-mail:deathencyclopedia@gmail.com
* 
*/
public enum CodeType {

	bandwidth(1,"流量"),
	time(2,"时间")
	;
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private CodeType(){}
	
	private CodeType(int id,String name){
		this.id=id;
		this.name=name;
	}
}
