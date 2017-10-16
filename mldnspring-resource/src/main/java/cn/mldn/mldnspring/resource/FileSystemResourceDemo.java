package cn.mldn.mldnspring.resource;

import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class FileSystemResourceDemo {
	public static void main(String[] args) throws Exception {
		ResourceLoader resourceLoader = new DefaultResourceLoader() ;
		// 创建了一个文件读取的Resource资源对象
		Resource resource = resourceLoader.getResource("file:d:/mldn.txt") ; 
		// 下面的读取操作保持原始状态
		System.out.println("资源长度：" + resource.contentLength());
		// 读取内容可以使用Resource父接口InputStreamSrouce提供的getInputStream()方法来完成
		Scanner scan = new Scanner(resource.getInputStream()) ;
		while (scan.hasNext()) {
			System.out.print(scan.next()); 
		}
		scan.close(); 
	}
}
