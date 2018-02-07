package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

public interface Communicator<T extends Serializable,S extends Serializable> {
	public void init(String host,int port) throws UnknownHostException,IOException;
	
	public DataTransfer<S> conmunicate1(DataTransfer<T> input) throws IOException,ClassNotFoundException;
	
	public void destory() throws IOException;

}
