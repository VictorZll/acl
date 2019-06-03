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
<title>Insert title here</title>
<style type="text/css">
.red{
color:red;
}
</style>
<link rel="stylesheet" type="text/css" href="static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">
<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#ul").tree({
		url:"data_tree",
		onClick:function(node){
			if(node.attributes && node.attributes.url){
				console.log("node="+node);
				
// 				var treeNode = node;
// 				var newCls = 'red';
// 				treeNode.attributes.iconCls = newCls;
// 				var iconEl = treeNode.getUI().rendered ? Ext.get(treeNode.getUI().getIconEl()) : null;
// 				if (iconEl) {
// 					iconEl.removeClass(newCls);
// 					iconEl.addClass(newCls);
// 				}
				
	    		alert(node.attributes.url);
	    	}
		},
		onLoadSuccess:function(node,data){
			if(data.length==0&&node==null){
				$.messager.alert("警告","您没有权限信息！","info");
			}
			console.log(node);
			console.log(data);
		}
	});	
});

</script>
</head>
<body>
hello world!
<ul id="ul"></ul>
</body>
</html>