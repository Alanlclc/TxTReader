package cn.ksb.minitxt.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ServiceFactory {
//	path�Ǵ洢���й�����   �Ĵ洢�ļ�·����
	private static final String path = Init.getProperty("");
	private static Map<String, String> services = new HashMap<String, String>();
	static{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {
			db = dbf.newDocumentBuilder();
//			��ȡ�ļ���Ϣ
//			��ȡ�洢��ĵ�ַ�͹��ܵļ�ֵ�ԣ�
//			��һ��Property�ļ�,�洢���������ļ���·��
//			���ļ���·���ֿ����Ա㽫����·����������µ���Ŀ����Ӱ��
			doc = db.parse(new FileInputStream(path));
			NodeList servicenNodes = doc.getElementsByTagName("service");
			for (int i = 0; i < servicenNodes.getLength() ; i++) {
				Node node = servicenNodes.item(i);
				services.put(node.getAttributes().getNamedItem("key").
						getNodeValue().trim()
						, node.getFirstChild().getNodeValue().trim());
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//		���÷��ͷ����涨��������   ��Ϊ��ǰ����֪����˭��Ҫ���ù���
//		��Ҫ���صĶ����������δ֪��
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> Service<T> getServers(String key){
		String classname = services.get(key);
		if(classname==null)
//			���ļ�·��Ϊ�����׳��쳣
		throw new RuntimeException("��Ч�Ĺؼ���");
		try {
			return (Service<T>) Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
