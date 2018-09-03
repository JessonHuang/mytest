<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 导入Jquer -->
<script type="text/javascript" src="../../js/easyui/jquery.min.js"></script>
<!-- 导入easyui核心号 -->
<script type="text/javascript"
	src="../../js/easyui/jquery.easyui.min.js"></script>
<!-- 导入语言包 -->
<script type="text/javascript"
	src="../../js/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 导入主题 -->
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/default/easyui.css">
<!-- 导入图标 -->
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/icon.css">
<script type="text/javascript" src="../../js/form.js"></script>
<script type="text/javascript" src="../../js/curd.js"></script>
<!-- 导入ajaxfileupload.js -->
<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>
<title>区域</title>
</head>
<body>
	<!-- 搜索表单 -->
	<form id="searchForm" method="post">
		省份:<input type="text" name="province" /> 
		城市:<input type="text" name="city" />
		区(县):<input type="text" name="district" /> 
		<a id="searchBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">搜索</a>
	</form>
	<!-- 工具条 -->
	<div id="toolbar">
		<a id="savaBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a> 
		<a id="editBtn" href="#"class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a> 
		<a id="removeBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
		<a id="excelImportBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">一键导入</a>
	</div>
	<!-- 定义表格 -->
	<table id="list"></table>
	<!--编辑窗口 -->
	<div id="editWin" class="easyui-window" title="区域添加修改"
		style="width:400px; height: 300px"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		<!-- 保存按钮 -->
		<div class="easyui-toolbar">
			<a id="save" class="easyui-linkbutton" href="#" icon="icon-save">保存</a>
		</div>
		<!-- 编辑区域 -->
		<form id="editForm" method="post">
		<!-- 添加隐藏Id -->
		<input type="hidden" name="id">
			<table width="80%" align="center" class="table-edit">
				<tr>
					<td>省</td>
					<td>
						<input type="text" name="province" class="easyui-validatebox" data-options="required:true"/>
					</td>
				</tr>
				<tr>
					<td>市</td>
					<td><input type="text" name="city"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>区</td>
					<td><input type="text" name="district"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>邮编</td>
					<td><input type="text" name="postcode"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>简码</td>
					<td><input type="text" name="shortcode"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>城市编码</td>
					<td><input type="text" name="citycode"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 一键导入窗口 -->
	<div id="importWin" class="easyui-window"
		data-options="title:'区域信息导入',closed:true,closed:true"
		style="width: 400px; top: 50px; left: 200px">
		<table class="table-edit" width="80%" align="center">
			<tr class="title">
				<td colspan="2">区域信息导入</td>
			</tr>
			<tr>
				<td>选择文件</td>
				<td><input id="fileID" type="file" name="upload"
					class="easyui-validatebox" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><a id="startImport" href="#"
					class="easyui-linkbutton">开始导入</a></td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
		var action = "area";
		var columns = [ [ {
			field : 'id',
			checkbox : true,
		},{
			field : 'province',
			title : '省',
			width : 120,
			align : 'center'
		}, {
			field : 'city',
			title : '市',
			width : 120,
			align : 'center'
		}, {
			field : 'district',
			title : '区',
			width : 120,
			align : 'center'
		}, {
			field : 'postcode',
			title : '邮编',
			width : 120,
			align : 'center'
		}, {
			field : 'shortcode',
			title : '简码',
			width : 120,
			align : 'center'
		}, {
			field : 'citycode',
			title : '城市编码',
			width : 200,
			align : 'center'
		} ] ];
		function loadEditForm(row){
		}
		$(function(){
			//一键导入
			$("#excelImportBtn").click(function(){
				//打开窗口
				$("#importWin").window("open");
			});
			
			//开始导入
			$("#startImport").click(function(){
			//1.判断文件是否是xls|xlsx
				//获得文件名
				var filename = $("#fileID").val();
				//正则表达式
				var reg = /^.+\.(xls|xlsx)$/;
				if(!reg.test(filename)){
					$.messager.alert("提示","文件后缀必须为xsl或xslx","warning");
					return;
				}else{
					//进度条
					$.messager.progress({
						title:"进度",
						text:"导入中。。。",
					}); 
					//使用Jquery ajaxFileUpload上传文件到服务器
					$.ajaxFileUpload({
						url:"../../area/excelImport.action",
						fileElementId:"fileID",
						dataType:"json",
						success:function(data){
							//关闭进度条
							$.messager.progress("close");
							//关闭一键导入窗口
							$("#importWin").window("close");
							//刷新页面
							$("#list").datagrid("reload");
							if(data.success){
								$.messager.alert("提示","导入成功","info");
							}else{
								$.messager.alert("提示","导入失败",data.msg,"error");
							}
							
						},
						error:function(){
							
						}
					});
				}
			});
			
		});
		
	</script>
</body>
</html>