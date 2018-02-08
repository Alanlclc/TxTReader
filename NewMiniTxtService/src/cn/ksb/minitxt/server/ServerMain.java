package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import cn.ksb.minitxt.common.entity.DataTransfer;

public class ServerMain {

	/**
	 * @param 服务器主入口入口
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerMain().startServer();
	}
	@SuppressWarnings("unchecked")
	public <E extends Serializable> void  startServer(){
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Init.getProperty("")) );
			System.out.println("服务器启动成功");
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("客户端："+socket.getInetAddress()+"获取了链接");
				
//				创建获得客户端的IO流        以序列化对象流实现
//				原因是为了以后的需求变化做准备
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				/*
				 * 
				 */
				DataTransfer<E> dataTransfer = (DataTransfer<E>) in.readObject();
				System.out.println("请求："+dataTransfer.getKey());
				
//				通过关键字Key,获得本次请求的相关业务实例
				Servers<E> servers = ServiceFactory.getServers(dataTransfer.getKey());
				servers.init(socket, in, out, dataTransfer.getDate());
//				创建线程执行run方法
				new Thread(servers).start();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
