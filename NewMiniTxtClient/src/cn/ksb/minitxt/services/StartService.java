package cn.ksb.minitxt.services;

import java.io.Serializable;
import java.util.Scanner;

import cn.ksb.minitxt.client.BaseService;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.common.constants.Constains;
import cn.ksb.minitxt.server.ServiceFactory;

public class StartService extends BaseService<Serializable> {
	private String OUTPUT_SIGN_LINE = "----------------------";
	private String OUTPUT_TEXT_INVALIDINPUT = "���������Ч������������";
	private String OUTPUT_TEXT_SELECT = "��ѡ��:";
	private String OUTPUT_TEXT_TITLE = "��ӭʹ�� ����� ����TXTС˵�Ķ���";
	private String OUTPUT_TEXT_LOGIN = "1.��¼\n";
	private String OUTPUT_TEXT_REGISTER = "2.ע��\n";
	private String OUTPUT_TEXT_LOGOUT = "3.�˳�\n";
	private String OUTPUT_TEXT_THANK = "ллʹ��";
	private StringBuilder MENU_START = new StringBuilder(OUTPUT_TEXT_TITLE)
										.append(OUTPUT_SIGN_LINE)
										.append(OUTPUT_TEXT_LOGIN)
										.append(OUTPUT_TEXT_REGISTER)
										.append(OUTPUT_TEXT_LOGOUT)
										.append(OUTPUT_SIGN_LINE)
										.append(OUTPUT_TEXT_SELECT);
	
	@SuppressWarnings("unchecked")
	@Override
	public Service<? extends Serializable> execute() {
		System.out.println(MENU_START);
		Scanner scanner = new Scanner(System.in);
		String choice = null;
		while(true){
			choice = scanner.next().trim();
			if(choice.equals("1")){
				return (Service<? extends Serializable>) ServiceFactory.getServers(Constains.COMMAND_START);
			}else if(choice.equals("2")){
				return (Service<? extends Serializable>) ServiceFactory.getServers(Constains.COMMAND_REGISTER);
			}else if(choice.equals("3")){
				System.out.println(OUTPUT_TEXT_THANK);
				System.exit(0);
			}else{
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
			}
		}
	}
	
}
