package cn.mldn.mldnspring.di.vo;

public class Message {
	public Message() {
		System.out.println("【Message类构造方法】timestamp = " + System.currentTimeMillis() + "、this = " + this);
	}
	public void initMessage() {
		System.out.println("【Message初始化-initMessage】建立要进行消息发送的连接通道。");
	}
	public void destroyMessage() {
		System.out.println("【Message销毁-destroyMessage】消息发送完毕，关闭发送通道处理。");
	}
}
