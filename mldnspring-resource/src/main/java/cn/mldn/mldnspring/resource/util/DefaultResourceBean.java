package cn.mldn.mldnspring.resource.util;

import java.util.List; 

import org.springframework.core.io.Resource;

public class DefaultResourceBean {
	private List<Resource> resources ;		// 直接定义要使用的Bean对象
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public List<Resource> getResources() {
		return resources;
	}
}
