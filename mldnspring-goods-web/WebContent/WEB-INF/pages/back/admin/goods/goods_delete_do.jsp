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
	String msg = "商品信息删除失败！" ;
	String url = "pages/back/admin/goods/goods_list.jsp" ;
	Set<Long> gids = DataTypeConverter.converterStringSplit(request.getParameter("ids")) ;
	IGoodsServiceBack goodsServiceBack = Factory.getServiceInstance("goods.service.back") ;
	if (goodsServiceBack.remove(gids)) {	// 保存成功
		msg = "商品信息删除成功！" ;
	}
	request.setAttribute("msg", msg) ;
	request.setAttribute("url", url) ;
	pageContext.forward("/pages/plugins/forward.jsp") ;
%>
</body>
</html>