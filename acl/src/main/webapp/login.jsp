<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>登陆页面</title>
<style type="text/css">
body{
background:rgb(12,163,210);

}
table{
padding: 0 30px;
background: white;
margin: 100px auto;
padding-bottom: 30px;
border-radius: 4px;
}
caption{
background: rgb(244,242,251);
padding: 20px;
}
.in{
padding: 10px;
margin:20px 10px;
border-radius: 4px;
width:300px;
}
.login{
width:80px;
height:40px;
background: white;
border: 1px solid;
border-radius: 4px;
display: inline-block;
text-decoration: none;
line-height: 40px;
color: gray;
float: right;
text-align: center;
}
td{
width:400px;
/* border:1px solid; */
}
.login:hover{
color:white;
background: rgb(12,163,210);
cursor: pointer;
}
</style>
</head>
<body>
	登陆页面
	
	<form action="login">
		
		<table>
		<caption>登陆CRM系统</caption>
			<tr><td><input class="in" type="text" name="username" placeholder="用户名" > </td></tr>
			<tr><td><input class="in" type="password" name="password" placeholder="密码" > </td></tr>
			<tr>
			<td>
				<input type="checkbox" id="remember"  >	<label for="remember" >用户7天内自动登陆</label>  
				<input class="login" type="submit" value="登陆" >
			</td>
	
<!-- 			<td align="center"><a href="#">提交</a>&emsp;<a href="#">重置</a></td> -->
			</tr>
		</table>
	</form>
</body>
</html>