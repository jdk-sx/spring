package cn.mldn.mldnspring.ioc.service.impl;

import cn.mldn.mldnspring.ioc.service.IMessage;

public class MessageImpl implements IMessage {

	@Override
	public String echo(String msg) {
		return "【ECHO】" + msg ; 
	}

}
