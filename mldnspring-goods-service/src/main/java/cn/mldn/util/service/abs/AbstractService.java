package cn.mldn.util.service.abs;

public abstract class AbstractService {
	public boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true ;
		}
		return false ;
	}
}
