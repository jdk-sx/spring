package cn.mldn.mldnspring.goods.action;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.mldnspring.goods.api.service.IGoodsService;
import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.util.action.abs.AbstractAction;
@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsAction extends AbstractAction {
	private static final String TITLE = "商品" ;
	@Resource
	private IGoodsService goodsService ;
	@RequestMapping("goods_add")
	public ModelAndView add(Goods goods,String tid[],MultipartFile pic) throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if (pic==null && pic.isEmpty()) {
			goods.setPhoto("nophoto.png");	// 默认的图片
		} else {	// 创建新的图片名称
			goods.setPhoto(super.getNewFileName(pic)); ;
		}
		if (this.goodsService.add(goods, super.stringToLong(tid))) {
			if (!pic.isEmpty()) {	// 现在有上传了
				String filePath = ContextLoader.getCurrentWebApplicationContext().getServletContext()
						.getRealPath("/WEB-INF/upload/") + goods.getPhoto();
				pic.transferTo(new File(filePath));
			}
			super.setMsgAndUrl(mav, "goods.add.action", "vo.add.success", TITLE);
		}  else {
			super.setMsgAndUrl(mav, "goods.add.action", "vo.add.failure", TITLE);
		}
		return mav ;
	} 
	@RequestMapping("goods_add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("goods.add.page")) ;
		mav.addAllObjects(this.goodsService.preAdd()) ;
		return mav ;
	}
}
