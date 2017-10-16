package cn.mldn.mldnspring.resource;

import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
 
public class ClassPathResourceDemo {
	public static void main(String[] args) throws Exception {
		// 创建了一个文件读取的Resource资源对象
		Resource resource = new ClassPathResource("spring/spring-resource.xml") ;
		System.out.println("资源长度：" + resource.contentLength());
		// 读取内容可以使用Resource父接口InputStreamSrouce提供的getInputStream()方法来完成
		Scanner scan = new Scanner(resource.getInputStream()) ;
		scan.useDelimiter("\n") ;
		while (scan.hasNext()) {
			System.out.print(scan.next()); 
		}
		scan.close(); 
	}
}
