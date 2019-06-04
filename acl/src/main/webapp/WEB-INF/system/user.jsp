<%@taglib uri="http://www.newroad.com/taglib/acl" prefix="acl" %>
<%@page import="com.newroad.acl.system.entity.Function"%>
<%@page import="java.util.Map"%>
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
<link rel="stylesheet" type="text/css" href="static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">
<style type="text/css">
#toolbar{
height: 40px;}
button{
background: silver;
}
button:hover{
background: aqua;
color:green;
}
</style>
<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function loadData(){
	$("#dg").datagrid({
		url:"system/user/list",
	 	toolbar:"#toolbar",//设置工具条
	    striped:true,//将行的展示条纹化
	    nowrap:false,//设置内容过多时是否换行，false是换行，true是不换行
	    loadMsg:"正在加载，请稍等.....",//设置加载数据时的提示信息
	    pagination:true,//设置显示分页工具条
	    rownumbers:true,//设置是否显示行号
	    singleSelect:true,//设置是否只能选中一行
	    pageNumber:1,//设置起始页码
	    pageSize:12,//设置每页展示的条数
	    pageList:[4,8,12],//设置每页展示展示的条数的下拉列表
	columns:[[
		//字段名。标题名。宽
		{field:"userId",title:"用户ID",width:60},
		{field:"userName",title:"用户名",width:160},
		{field:"phone",title:"年龄",width:100},
  		{field:"email",title:"邮箱",width:200},
  		{field:"status",title:"账号状态",width:100},
		{field:"note",title:"备注",width:100},
		{field:"createTime",title:"创建时间",width:160,formatter:function(value,row,index){
			return dateFormate(value);
		}},
  		{field:"updateTime",title:"修改时间",width:160},
		{field:"operation",title:"操作",width:160,
			formatter: function(value,row,index){
				return "<acl:hasPermission funcCode='system:user:delete'><button>删除用户</button></acl:hasPermission>"+
				"<acl:hasPermission funcCode='system:user:edit'><button>修改用户</button></acl:hasPermission>"+
				"<acl:hasPermission funcCode='system:user:grant'><button>授权用户</button></acl:hasPermission>"+
				"<acl:hasPermission funcCode='system:user:detail'><button>详细信息</button></acl:hasPermission>";	
		}}
	]]	
	});
}
$(function(){
	loadData();
});
function dateFormate(dateStr){
	var year=new Date(dateStr).getFullYear();
	var month=new Date(dateStr).getMonth()+1;
	var day=new Date(dateStr).getDate();
	var hour=new Date(dateStr).getHours();
	var min=new Date(dateStr).getMinutes();
	var s=new Date(dateStr).getSeconds();
	return year+"-"+month+"-"+day+" "+hour+":"+min+":"+s;
}
function addZero(){
	
}
</script>
</head>
<body>
用户管理
<div id="toolbar">
<acl:hasPermission funcCode="system:user:create">
			<button>添加用户</button>
</acl:hasPermission>




</div>
<table id="dg" ></table>

</body>
</html>