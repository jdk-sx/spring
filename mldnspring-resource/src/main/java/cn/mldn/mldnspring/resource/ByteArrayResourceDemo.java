package cn.mldn.mldnspring.resource;

import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ByteArrayResourceDemo {
	public static void main(String[] args) throws Exception {
		// 创建了一个内存读取的Resource资源对象
		Resource resource = new ByteArrayResource("helloworld".getBytes()) ;
		System.out.println("资源长度：" + resource.contentLength());
		// 读取内容可以使用Resource父接口InputStreamSrouce提供的getInputStream()方法来完成
		Scanner scan = new Scanner(resource.getInputStream()) ;
		while (scan.hasNext()) {
			System.out.print(scan.next()); 
		}
		scan.close(); 
	}
}
