package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public interface Servers<T extends Serializable> extends Runnable {
//	主线程需要将所得到的请求及流交给该接口  
//	之后将所得到的请求下发给各个业务类进行实现
	public void init(Socket socket,ObjectInputStream in,ObjectOutputStream out,T data);
	
//	提供资源销毁的方法
	public void destory() throws IOException;
}
