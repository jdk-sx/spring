<%@ page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8") ;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String photo_input_url = basePath + "pages/photo/upload.action" ;
%>
<html>
<head>
	<base href="<%=basePath%>" />
</head> 
<body>
<form action="<%=photo_input_url%>" method="post" enctype="multipart/form-data"> 
	请输入消息：<input type="text" name="msg" id="msg" value="www.mldn.cn"><br>
	选择照片：<input type="file" name="photo" id="photo"><br>
	<br><input type="submit" value="发送">
</form>
</body>
</html>