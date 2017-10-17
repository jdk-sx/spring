package cn.mldn.mldnspring.aop.service.impl;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.aop.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Override
	public String echo(String str) {
		if (str == null || "mldn".equals(str) || "".equals(str)) {
			throw new RuntimeException("用户输入了非法的数据信息，无法进行正确的消息回应处理。") ;
		}
		System.out.println("【MessageServiceImpl业务层实现】接收到消息内容：" + str);
		return "【ECHO】msg = " + str;
	}

}
