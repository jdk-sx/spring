package cn.mldn.mldnspring.goods.action;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.mldnspring.goods.api.service.IGoodsService;
import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.mldnspring.goods.api.vo.Item;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;
@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsAction extends AbstractAction {
	private static final String TITLE = "商品" ; 
	@Resource
	private IGoodsService goodsService ;
	
	@RequestMapping("goods_delete")
	public ModelAndView delete(String ids) throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if (this.goodsService.remove(super.stringToLong(ids))) {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.delete.success", TITLE);
		}  else {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.delete.failure", TITLE);
		}
		return mav ;
	}  
	
	@RequestMapping("goods_edit_pre")
	public ModelAndView editPre(long gid) {
		ModelAndView mav = new ModelAndView(super.getPage("goods.edit.page")) ;
		mav.addAllObjects(this.goodsService.preEdit(gid)) ;
		return mav ;
	}
	
	@RequestMapping("goods_list") 
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getPage("goods.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil("商品名称:name", super.getPage("goods.list.action")) ;
		Map<String,Object> map = this.goodsService.list(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()) ;
		mav.addAllObjects(map) ;
		Map<Long,String> itemMap = new HashMap<Long,String>() ;
		Iterator<Item> iter = ((List<Item>) map.get("allItems")).iterator() ;
		while (iter.hasNext()) {
			Item item = iter.next() ;
			itemMap.put(item.getIid(), item.getTitle()) ;
		}
		mav.addObject("allItems", itemMap) ;
		return mav ;
	}
	
	@RequestMapping("goods_edit")
	public ModelAndView edit(Goods goods,String tid[],MultipartFile pic) throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if (!pic.isEmpty()) {	// 有新的文件上传
			if ("nophoto.png".equals(goods.getPhoto())) {
				goods.setPhoto(super.getNewFileName(pic)); 
			}
		}
		if (this.goodsService.edit(goods, super.stringToLong(tid))) {
			if (!pic.isEmpty()) {	// 现在有上传了
				String filePath = ContextLoader.getCurrentWebApplicationContext().getServletContext()
						.getRealPath("/WEB-INF/upload/") + goods.getPhoto();
				pic.transferTo(new File(filePath));
			}
			super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.success", TITLE);
		}  else {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.failure", TITLE);
		}
		return mav ;
	}  
	
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
