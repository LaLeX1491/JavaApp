package de.lalex.tutorial.util;

import java.io.Serializable;

public class UserInfos implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7291468802487279898L;
	
	public String name;
	public String password;
	
	public UserInfos(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
}
