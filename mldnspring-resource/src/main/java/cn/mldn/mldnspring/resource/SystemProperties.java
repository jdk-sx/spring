package cn.mldn.mldnspring.resource;

import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
 
public class SystemProperties {
	public static void main(String[] args) throws Exception {
		System.getProperties().list(System.out);
	}
}
