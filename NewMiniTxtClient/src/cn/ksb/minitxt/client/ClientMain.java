package cn.ksb.minitxt.client;

import java.io.Serializable;

import cn.ksb.minitxt.common.constants.Constains;

public class ClientMain {
	/*
	 * �ͻ��˳������
	 */
	public static void main(String[] args) {
		new ClientMain().startClient();
	}
	
	/*
	 * �ͻ������п�ʼ����
	 */
	public void startClient(){
		Service<? extends Serializable> service=ServiceFactory.getServers(Constains.COMMAND_START);
		while(true){
			if(service==null){
				System.out.println("�˳�Ӧ��");
				break;
			}
//			ͨ����������ѭ������ҵ���ܴ���
			service = service.execute();
		}
	}
}