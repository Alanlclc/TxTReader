package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cn.ksb.minitxt.common.entity.DataTransfer;

public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerMain().startServer();
	}
	public void startServer(){
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Init.getProperty("")) );
			System.out.println("�����������ɹ�");
			
			Socket socket = serverSocket.accept();
			System.out.println("�ͻ��ˣ�"+socket.getInetAddress()+"��ȡ������");
			
//			������ÿͻ��˵�io������  �Զ�����Ϊ����
//			ԭ����Ϊ���Ժ������仯��׼��
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			
			DataTransfer<?> dataTransfer = (DataTransfer<?>) in.readObject();
			System.out.println("����"+dataTransfer.getKey());
			
//			
			
			
			
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