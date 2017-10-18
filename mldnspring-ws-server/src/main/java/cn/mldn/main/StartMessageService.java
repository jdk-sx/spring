package cn.mldn.main;

import javax.xml.ws.Endpoint;

import cn.mldn.remote.service.IMessageService;
import cn.mldn.remote.service.impl.MessageServiceImpl;

public class StartMessageService {
	public static void main(String[] args) {
		IMessageService msgObj = new MessageServiceImpl() ;	// 实例化接口对象
		Endpoint.publish("http://192.168.28.87:7777/message", msgObj) ;
	}
}
