<%@ page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8") ;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String message_input_url = basePath + "pages/message/echo.action" ;
%>
<html>
<head>
	<base href="<%=basePath%>" />
	<script type="text/javascript" src="mvcjs/pages/message/message_input.js"></script>
	<link rel="stylesheet" type="text/css" href="mvccss/style.css">
</head> 
<body>
${errors}
<form action="<%=message_input_url%>" method="post" enctype="multipart/form-data">
	<span class="txt">请输入消息：</span>
	<input type="text" name="msg" id="msg" value="www.mldn.cn"><br>
	<span class="txt">消息标签：</span>
		<input type="checkbox" name="tags" id="tags" value="政治">政治
		<input type="checkbox" name="tags" id="tags" value="经济">经济
		<input type="checkbox" name="tags" id="tags" value="文化">文化<br>
	照片:<input type="file" name="photo" id="photo">
	<br><input type="submit" value="发送">
</form>
</body>
</html>