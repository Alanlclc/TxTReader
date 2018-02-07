package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public interface Servers<T extends Serializable> extends Runnable {
//	���߳���Ҫ�����õ��������������ýӿ�  
//	֮�����õ��������·�������ҵ�������ʵ��
	public void init(Socket socket,ObjectInputStream in,ObjectOutputStream out,T data);
	
//	�ṩ��Դ���ٵķ���
	public void destory() throws IOException;
}
