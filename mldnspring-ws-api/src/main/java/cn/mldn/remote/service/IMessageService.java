package cn.mldn.remote.service;

import javax.jws.WebService;

@WebService	// 必须将此接口标注为WebService接口 
public interface IMessageService {
	public String echo(String msg);
}
