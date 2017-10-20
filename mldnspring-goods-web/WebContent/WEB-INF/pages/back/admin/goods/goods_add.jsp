<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	String goods_list_url = basePath + "pages/back/admin/goods/goods_list.action" ;
	String goods_add_url = basePath + "pages/back/admin/goods/goods_add.action" ;
%>
<base href="<%=basePath%>"/>
<title>商品管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/back/admin/goods/goods_add.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="<%=goods_add_url%>" method="post" class="form-horizontal" id="goodsForm" enctype="multipart/form-data">
					<fieldset>
						<legend>
							<label>增加商品</label>
						</legend>
						<div class="form-group" id="nameDiv">
							<label class="col-md-2 control-label" for="name">商品名称：</label>
							<div class="col-md-5">
								<input type="text" id="name" name="name" class="form-control" placeholder="请填写商品名称">
							</div>
							<span class="col-md-5" id="nameSpan">*</span>
						</div>
						<div class="form-group" id="priceDiv">
							<label class="col-md-2 control-label" for="price">商品价格：</label>
							<div class="col-md-5">
								<input type="text" id="price" name="price" class="form-control" placeholder="请填写商品单价">
							</div>
							<span class="col-md-5" id="priceSpan">*</span>
						</div>
						<div class="form-group" id="iidDiv">
							<label class="col-md-2 control-label" for="iid">商品分类：</label>
							<div class="col-md-5">
								<select id="iid" name="iid" class="form-control"> 
									<option value="">========= 请选择商品所属分类 =========</option>
									<c:forEach items="${allItems}" var="item">
										<option value="${item.iid}">${item.title}</option>
									</c:forEach>
								</select>
							</div>
							<span class="col-md-5" id="iidSpan">*</span>
						</div>
						<div class="form-group" id="tagDiv">
							<label class="col-md-2 control-label" for="tag">商品标签：</label>
							<div class="col-md-5">
								<c:forEach items="${allTags}" var="tag">
									<div class="col-md-3">
										<div class="checkbox">
											<label><input type="checkbox" id="tid" name="tid" value="${tag.tid}">${tag.title}</label>
										</div>
									</div>
								</c:forEach>
							</div>
							<span class="col-md-5" id="tidSpan">*</span>
						</div>
						<div class="form-group" id="picDiv">
							<label class="col-md-2 control-label" for="pic">商品图片：</label>
							<div class="col-md-5">
								<input type="file" id="pic" name="pic" class="form-control" placeholder="请选择商品宣传图">
							</div>
							<span class="col-md-5" id="picSpan">*</span>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<input type="submit" value="提交" class="btn btn-primary">
								<input type="reset" value="重置" class="btn btn-warning">
								<a href="<%=goods_list_url%>" class="btn btn-link">商品列表</a> 
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>