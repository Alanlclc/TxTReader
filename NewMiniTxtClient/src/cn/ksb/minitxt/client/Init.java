package cn.ksb.minitxt.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * 工具类   读取Property中的键值字符串
 * 拿到端口号等一系列信息
 */
public class Init {
	//	创建一个Pro集合  
	private static Properties props = new Properties();
	
	static{
		InputStream is = null;
		try {
			is = new FileInputStream("");
			props.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
