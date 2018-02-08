package cn.ksb.minitxt.services;

import java.io.Serializable;
import java.util.Scanner;

import cn.ksb.minitxt.client.BaseService;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.common.constants.Constains;
import cn.ksb.minitxt.server.ServiceFactory;

public class StartService extends BaseService<Serializable> {
	private String OUTPUT_SIGN_LINE = "----------------------";
	private String OUTPUT_TEXT_INVALIDINPUT = "你的输入无效：请重新输入";
	private String OUTPUT_TEXT_SELECT = "请选择:";
	private String OUTPUT_TEXT_TITLE = "欢迎使用 看书吧 在线TXT小说阅读器";
	private String OUTPUT_TEXT_LOGIN = "1.登录\n";
	private String OUTPUT_TEXT_REGISTER = "2.注册\n";
	private String OUTPUT_TEXT_LOGOUT = "3.退出\n";
	private String OUTPUT_TEXT_THANK = "谢谢使用";
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
