package cn.mldn.mldnspring.goods.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.mldnspring.goods.api.service.IGoodsService;
import cn.mldn.util.action.abs.AbstractAction;
@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsAction extends AbstractAction {
	@Resource
	private IGoodsService goodsService ;
	@RequestMapping("goods_add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("goods.add.page")) ;
		mav.addAllObjects(this.goodsService.preAdd()) ;
		return mav ;
	}
}
