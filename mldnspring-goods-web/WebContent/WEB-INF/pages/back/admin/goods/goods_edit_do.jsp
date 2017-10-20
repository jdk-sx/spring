<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.util.*" %>
<%@ page import="cn.mldn.util.factory.*" %>
<%@ page import="cn.mldn.service.back.*"%>
<%	request.setCharacterEncoding("UTF-8") ;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
</head>
<body>
<%
	String msg = "商品信息修改失败！" ;
	String url = "pages/back/admin/goods/goods_list.jsp" ;
	ParameterUtil paramUtil = new ParameterUtil(request,"/tmp") ;
	Goods vo = new Goods() ;
	vo.setGid(Long.parseLong(paramUtil.getParameter("gid"))) ;
	vo.setName(paramUtil.getParameter("name")) ;
	vo.setPrice(Double.parseDouble(paramUtil.getParameter("price"))) ;
	vo.setIid(Long.parseLong(paramUtil.getParameter("item"))) ;
	Set<Long> tids = DataTypeConverter.converterStringToLong(paramUtil.getParameterValues("tag")) ;
	String oldPhoto = paramUtil.getParameter("oldPhoto") ;
	vo.setPhoto(oldPhoto) ;	// 使用原始图片名称
	if (paramUtil.isUpload("photo")) {	// 现在有文件上传
		if ("nophoto.jpg".equals(oldPhoto)) {	// 原始没有上传图片，需要生成新的图片名称
			vo.setPhoto(paramUtil.createUploadFileName("photo").get(0)) ;	// 保存上传的新文件名称
		} 
	} 
	IGoodsServiceBack goodsServiceBack = Factory.getServiceInstance("goods.service.back") ;
	if (goodsServiceBack.edit(vo, tids)) {	// 保存成功
		if (paramUtil.isUpload("photo")) {	// 又有文件上传了
			String filePath = this.getServletContext().getRealPath("/upload/goods/") + vo.getPhoto() ;
			paramUtil.saveUploadFile("photo", filePath) ;
		}
		msg = "商品信息修改成功！" ;
	}
	request.setAttribute("msg", msg) ;
	request.setAttribute("url", url) ;
	pageContext.forward("/pages/plugins/forward.jsp") ;
%>
</body>
</html>