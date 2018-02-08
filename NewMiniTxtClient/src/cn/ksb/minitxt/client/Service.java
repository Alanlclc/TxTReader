package cn.ksb.minitxt.client;

import java.io.Serializable;

public interface  Service <T extends Serializable> {
	
	public void setInputData(T inputData);
	
	public Service <? extends Serializable> execute();
	
}
