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
<title>标准清单</title>
</head>
<body>
	<!-- 搜索表单 -->
	<form id="searchForm" method="post">
		收派标准名称:<input type="text" name="name" /> 最小长度:<input type="text"
			name="minLength" /> 最小重量:<input type="text" name="minWeight" /> <a
			id="searchBtn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">搜索</a>
	</form>
	<!-- 工具条 -->
	<div id="toolbar">
		<a id="savaBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a> 
		<a id="editBtn" href="#"class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a> 
		<a id="removeBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
	</div>
	<!-- 定义表格 -->
	<table id="list"></table>
	<!--编辑窗口 -->
	<div id="editWin" class="easyui-window" title="收派标准编辑"
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
					<td>收派标准名称</td>
					<td>
						<input type="text" name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入名称',validType:['length[4,12]'],invalidMessage:'长度为4-12位'"/>
					</td>
				</tr>
				<tr>
					<td>最小重量</td>
					<td><input type="text" name="minWeight"
						class="easyui-numberbox" data-options="required:true,min:10,max:100,precision:2" /></td>
				</tr>
				<tr>
					<td>最大重量</td>
					<td><input type="text" name="maxWeight"
						class="easyui-numberbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>最小长度</td>
					<td><input type="text" name="minLength"
						class="easyui-numberbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>最大长度</td>
					<td><input type="text" name="maxLength"
						class="easyui-numberbox" data-options="required:true" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var action = "standard";
		var columns = [ [ {
			field : "id",
			title : "编号",
			width : 100
		}, {
			field : "name",
			title : "收派标准名称",
			width : 200
		}, {
			field : "minLength",
			title : "最小长度",
			width : 200
		}, {
			field : "maxLength",
			title : "最大长度",
			width : 200
		}, {
			field : "minWeight",
			title : "最小重量",
			width : 200
		}, {
			field : "maxWeight",
			title : "最大重量",
			width : 200
		} ] ];
		function loadEditForm(row){
		}
	</script>
</body>
</html>