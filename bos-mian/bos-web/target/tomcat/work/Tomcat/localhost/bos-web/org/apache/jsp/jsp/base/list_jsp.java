/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-07-29 14:42:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<!-- 导入Jquer -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/easyui/jquery.min.js\"></script>\r\n");
      out.write("<!-- 导入easyui核心号 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../../js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<!-- 导入语言包 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../../js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<!-- 导入主题 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../../js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<!-- 导入图标 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../../js/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/form.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>标准清单</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 搜索表单 -->\r\n");
      out.write("\t<form id=\"searchForm\" method=\"post\">\r\n");
      out.write("\t\t收派标准名称:<input type=\"text\" name=\"name\" /> 最小长度:<input type=\"text\"\r\n");
      out.write("\t\t\tname=\"minLength\" /> 最小重量:<input type=\"text\" name=\"minWeight\" /> <a\r\n");
      out.write("\t\t\tid=\"searchBtn\" href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-search'\">搜索</a>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<!-- 工具条 -->\r\n");
      out.write("\t<div id=\"toolbar\">\r\n");
      out.write("\t\t<a id=\"savaBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">添加</a> \r\n");
      out.write("\t\t<a id=\"editBtn\" href=\"#\"class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a> \r\n");
      out.write("\t\t<a id=\"removeBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 定义表格 -->\r\n");
      out.write("\t<table id=\"list\"></table>\r\n");
      out.write("\t<!--编辑窗口 -->\r\n");
      out.write("\t<div id=\"editWin\" class=\"easyui-window\" title=\"收派标准编辑\"\r\n");
      out.write("\t\tstyle=\"width:400px; height: 300px\"\r\n");
      out.write("\t\tdata-options=\"iconCls:'icon-save',modal:true,closed:true\">\r\n");
      out.write("\t\t<!-- 保存按钮 -->\r\n");
      out.write("\t\t<div class=\"easyui-toolbar\">\r\n");
      out.write("\t\t\t<a id=\"save\" class=\"easyui-linkbutton\" href=\"#\" icon=\"icon-save\">保存</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 编辑区域 -->\r\n");
      out.write("\t\t<form id=\"editForm\" method=\"post\">\r\n");
      out.write("\t\t<!-- 添加隐藏Id -->\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t\t\t<table width=\"80%\" align=\"center\" class=\"table-edit\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>收派标准名称</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"name\" class=\"easyui-validatebox\" data-options=\"required:true,missingMessage:'请输入名称',validType:['length[4,12]'],invalidMessage:'长度为4-12位'\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>最小重量</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"minWeight\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-numberbox\" data-options=\"required:true,min:10,max:100,precision:2\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>最大重量</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"maxWeight\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-numberbox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>最小长度</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"minLength\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-numberbox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>最大长度</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"maxLength\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-numberbox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t//页面加载\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t//显示列表\r\n");
      out.write("\t\t\t$(\"#list\").datagrid({\r\n");
      out.write("\t\t\t\t//属性\r\n");
      out.write("\t\t\t\t//url: 数据来源的地址\r\n");
      out.write("\t\t\t\turl : \"../../standard/listByPage.action\",\r\n");
      out.write("\t\t\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\t\t\tfield : \"id\",\r\n");
      out.write("\t\t\t\t\ttitle : \"编号\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"name\",\r\n");
      out.write("\t\t\t\t\ttitle : \"收派标准名称\",\r\n");
      out.write("\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"minLength\",\r\n");
      out.write("\t\t\t\t\ttitle : \"最小长度\",\r\n");
      out.write("\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"maxLength\",\r\n");
      out.write("\t\t\t\t\ttitle : \"最大长度\",\r\n");
      out.write("\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"minWeight\",\r\n");
      out.write("\t\t\t\t\ttitle : \"最小重量\",\r\n");
      out.write("\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"maxWeight\",\r\n");
      out.write("\t\t\t\t\ttitle : \"最大重量\",\r\n");
      out.write("\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t} ] ],\r\n");
      out.write("\t\t\t\t//显示分页\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\ttoolbar : \"#toolbar\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t//搜索\r\n");
      out.write("\t\t\t$(\"#searchBtn\").click(function() {\r\n");
      out.write("\t\t\t\t$(\"#list\").datagrid(\"load\", getFormData(\"searchForm\"));\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//保存\r\n");
      out.write("\t\t\t$(\"#savaBtn\").click(function() {\r\n");
      out.write("\t\t\t\t//打开窗口\r\n");
      out.write("\t\t\t\t$(\"#editWin\").window(\"open\");\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//保存.提交表单\r\n");
      out.write("\t\t\t$(\"#save\").click(function(){\r\n");
      out.write("\t\t\t\t$(\"#editForm\").form(\"submit\",{\r\n");
      out.write("\t\t\t\t\turl:\"../../standard/save.action\",\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tonSubmit:function(){\r\n");
      out.write("\t\t\t\t\t\treturn $(\"#editForm\").form(\"validate\");\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\tdata = eval(\"(\"+data+\")\");\r\n");
      out.write("\t\t\t\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\t\t\t\t//关闭窗口\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#editWin\").window(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t//刷新页面\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#list\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t//清空表单\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#editForm\").form(\"clear\");\r\n");
      out.write("\t\t\t\t\t\t\t//提示成功\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert(\"提示\",\"保存成功!\",'info');\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert('提示','保存失败'+data.msg,'error')\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//修改\r\n");
      out.write("\t\t\t$(\"#editBtn\").click(function(){\r\n");
      out.write("\t\t\t\t//判断只能选择一个\r\n");
      out.write("\t\t\t\tvar rows = $(\"#list\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\t\tif(rows.length!=1){\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示\",\"修改操作只能选择一个\",\"warning\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\t//后台获得数据\r\n");
      out.write("\t\t\t\t$(\"#editForm\").form(\"load\",\"../../standard/findById.action?uuid=\"+rows[0].id);\r\n");
      out.write("\t\t\t\t//打开窗口\r\n");
      out.write("\t\t\t\t$(\"#editWin\").window(\"open\");\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//删除\r\n");
      out.write("\t\t\t$(\"#removeBtn\").click(function(){\r\n");
      out.write("\t\t\t\t//判断至少选择一个\r\n");
      out.write("\t\t\t\tvar rows = $(\"#list\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\t\tif(rows.length==0){\r\n");
      out.write("\t\t\t\t\t$.messager.alert('提示','删除操作最少选择一个','warning');\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//弹出确认框\r\n");
      out.write("\t\t\t\t$.messager.confirm('提示','你确定删除?',function(r){\r\n");
      out.write("\t\t\t\t\tif(r){\r\n");
      out.write("\t\t\t\t\t\t//设计一个数组\r\n");
      out.write("\t\t\t\t\t\tvar idArray = new Array();\r\n");
      out.write("\t\t\t\t\t\t//获得id\r\n");
      out.write("\t\t\t\t\t\t$(rows).each(function(i){\r\n");
      out.write("\t\t\t\t\t\t\tidArray.push(rows[i].id);\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t//冲数组中取出每个元素,使用指定字符串拼接\r\n");
      out.write("\t\t\t\t\t\tvar ids = idArray.join(\",\");\r\n");
      out.write("\t\t\t\t\t\t//把id传到后台\r\n");
      out.write("\t\t\t\t\t\t$.post(\"../../standard/delete.action\",{ids:ids},function(data){\r\n");
      out.write("\t\t\t\t\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\t\t\t\t\t//刷新datagrid\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#list\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t\t//提示\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示','删除成功','info');\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示','删除失败'+data.msg,'error');\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t},\"json\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
