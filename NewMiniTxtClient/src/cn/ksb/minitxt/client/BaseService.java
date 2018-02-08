package cn.ksb.minitxt.client;

import java.io.Serializable;

public abstract class BaseService<T extends Serializable> implements Service<T> {
	private T inputData;
	
	@Override
	public void setInputData(T inputData) {
		// TODO Auto-generated method stub
		this.inputData = inputData;
	}
	public T getInputData(){
		return inputData;
	}
}
