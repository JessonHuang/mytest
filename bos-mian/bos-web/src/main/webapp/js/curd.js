//页面加载
		$(function() {
			//显示列表
			$("#list").datagrid({
				//属性
				//url: 数据来源的地址
				url : "../../"+action+"/listByPage.action",
				columns:columns,
				//显示分页
				pagination : true,
				toolbar : "#toolbar"
			});

			//搜索
			$("#searchBtn").click(function() {
				$("#list").datagrid("load", getFormData("searchForm"));
			});
			//保存
			$("#savaBtn").click(function() {
				//清空表单
				$("#editForm").form("clear");
				//打开窗口
				$("#editWin").window("open");
			})
			//保存.提交表单
			$("#save").click(function(){
				$("#editForm").form("submit",{
					url:"../../"+action+"/save.action",
					
					onSubmit:function(){
						return $("#editForm").form("validate");
					},
					
					success:function(data){
						data = eval("("+data+")");
						if(data.success){
							
							//关闭窗口
							$("#editWin").window("close");
							//刷新页面
							$("#list").datagrid("reload");
							//清空表单
							$("#editForm").form("clear");
							//提示成功
							$.messager.alert("提示","保存成功!",'info');
						}else{
							$.messager.alert('提示','保存失败'+data.msg,'error')
						}
						
					}
					
				})
			})
			//修改
			$("#editBtn").click(function(){
				//判断只能选择一个
				var rows = $("#list").datagrid("getSelections");
				if(rows.length!=1){
					$.messager.alert("提示","修改操作只能选择一个","warning");
					return;
				};
				//后台获得数据
				$("#editForm").form("load","../../"+action+"/findById.action?uuid="+rows[0].id);
				loadEditForm(rows[0]);
				//打开窗口
				$("#editWin").window("open");
			})
			
			//删除
			$("#removeBtn").click(function(){
				//判断至少选择一个
				var rows = $("#list").datagrid("getSelections");
				if(rows.length==0){
					$.messager.alert('提示','删除操作最少选择一个','warning');
					return;
				}
				//弹出确认框
				$.messager.confirm('提示','你确定删除?',function(r){
					if(r){
						//设计一个数组
						var idArray = new Array();
						//获得id
						$(rows).each(function(i){
							idArray.push(rows[i].id);
						});
						//冲数组中取出每个元素,使用指定字符串拼接
						var ids = idArray.join(",");
						//把id传到后台
						$.post("../../"+action+"/delete.action",{ids:ids},function(data){
							if(data.success){
								//刷新datagrid
								$("#list").datagrid("reload");
								//提示
								$.messager.alert('提示','删除成功','info');
							}else{
								$.messager.alert('提示','删除失败'+data.msg,'error');
							}
						},"json");
					}
				});
				
			});
		});