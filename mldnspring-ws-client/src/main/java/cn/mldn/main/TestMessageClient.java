package cn.mldn.main;

import cn.mldn.remote.service.IMessageService;
import cn.mldn.remote.service.impl.MessageServiceLocator;

public class TestMessageClient {
	public static void main(String[] args) throws Exception {
		IMessageService messageService = new MessageServiceLocator().getMessageServiceImplPort();
		System.out.println(messageService.echo("www.mldn.cn"));
	}
}
