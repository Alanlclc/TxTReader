package cn.ksb.minitxt.common.entity;

import java.io.Serializable;

public class DataTransfer<T extends Serializable> implements java.io.Serializable{

	private static final long serialVersionUID = -2084661773114897622L;
	
	private String key;
	
	private T date;
	
	private int result;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public DataTransfer() {
		super();
	}
	
	
}
