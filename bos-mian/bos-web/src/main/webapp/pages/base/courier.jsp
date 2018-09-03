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
<title>快递员</title>
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
	<!-- 编辑表单 -->
	<div id="editWin" class="easyui-window" data-options="title:'快递员编辑',closed:true" style="width:700px;top:50px;left:200px">
			<!-- 按钮区域 -->
			<div class="datagrid-toolbar">
				<a id="save" class="easyui-linkbutton" href="#" icon="icon-save">保存</a>
			</div>
			<!-- 编辑区域 -->
			<div>
			<form id="editForm" method="post">
			<!--提供隐藏域 装载id -->
			<input type="hidden" name="id" />
			<table class="table-edit" width="80%" align="center">
						<tr>
							<td>快递员工号</td>
							<td>
								<input type="text" name="courierNum" class="easyui-validatebox" required="true" />
							</td>
							<td>姓名</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>手机</td>
							<td>
								<input type="text" name="telephone" class="easyui-validatebox" required="true" />
							</td>
							<td>所属单位</td>
							<td>
								<input type="text" name="company" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>查台密码</td>
							<td>
								<input type="text" name="checkPwd" class="easyui-validatebox" required="true" />
							</td>
							<td>PDA号码</td>
							<td>
								<input type="text" name="pda" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>取派标准</td>
							<td>
								<select id="standardId" class="easyui-combobox" name="standard.id" style="width:150px"
								data-options="valueField:'id',textField:'name',url:'../../standard/list.action'"
								></select>
							</td>
						</tr>
					</table>
		  </form>
		  </div>
	</div>
	<script type="text/javascript">
		var action = "courier";
		//列字段
		var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'courierNum',
				title : '工号',
				width : 80,
				align : 'center'
			},{
				field : 'name',
				title : '姓名',
				width : 80,
				align : 'center'
			}, {
				field : 'telephone',
				title : '手机号',
				width : 120,
				align : 'center'
			}, {
				field : 'checkPwd',
				title : '查台密码',
				width : 120,
				align : 'center'
			}, {
				field : 'pda',
				title : 'PDA号',
				width : 120,
				align : 'center'
			}, {
				field : 'standard',
				title : '取派标准',
				width : 120,
				align : 'center',
				formatter:function(value,row,index){
					if(value!=null){
						return value.name;
					}else{
						return "";
					}
				}
			}, {
				field : 'company',
				title : '所属单位',
				width : 200,
				align : 'center'
			} ] ];
	function loadEditForm(row){
		$("#standardId").combobox("setValue",row.standard.id)
	}
	</script>
</body>
</html>