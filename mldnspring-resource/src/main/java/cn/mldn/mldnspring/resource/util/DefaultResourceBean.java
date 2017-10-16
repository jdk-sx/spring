package cn.mldn.mldnspring.resource.util;

import org.springframework.core.io.Resource;

public class DefaultResourceBean {
	private Resource resource ;		// 直接定义要使用的Bean对象
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Resource getResource() {
		return resource;
	}
}
