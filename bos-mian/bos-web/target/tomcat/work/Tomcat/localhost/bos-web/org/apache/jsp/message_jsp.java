/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-07-30 09:50:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>消息中心</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"js/easyui/themes/icon.css\">\r\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\" href=\"js/easyui/themes/default/easyui.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- portal扩展 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\" href=\"js/easyui/ext/portal.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 1.设计一个div -->\r\n");
      out.write("<div id=\"pp\" style=\"width:1000px;height:500px;\">   \r\n");
      out.write("    <div style=\"width:50%\"></div>   \r\n");
      out.write("    <div style=\"width:50%\"></div>   \r\n");
      out.write("</div> \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//2.加载portal\r\n");
      out.write("\t\t$(\"#pp\").portal({\r\n");
      out.write("\t\t\t//去掉边框\r\n");
      out.write("\t\t\tborder:false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//定义四个面板内容对象\r\n");
      out.write("\t\tvar panels = [\r\n");
      out.write("\t\t\t\t{    \r\n");
      out.write("\t\t\t\t    title: '公告栏',    \r\n");
      out.write("\t\t\t\t    height:200,    \r\n");
      out.write("\t\t\t\t    closable: true,    \r\n");
      out.write("\t\t\t\t    collapsible: true,\r\n");
      out.write("\t\t\t\t    href:\"pages/portal/gonggao.html\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t{    \r\n");
      out.write("\t\t\t\t    title: '代办事宜',    \r\n");
      out.write("\t\t\t\t    height:200,    \r\n");
      out.write("\t\t\t\t    closable: true,    \r\n");
      out.write("\t\t\t\t    collapsible: true  ,\r\n");
      out.write("\t\t\t\t    href:\"pages/portal/daiban.html\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t{    \r\n");
      out.write("\t\t\t\t    title: '预警信息',    \r\n");
      out.write("\t\t\t\t    height:200,    \r\n");
      out.write("\t\t\t\t    closable: true,    \r\n");
      out.write("\t\t\t\t    collapsible: true ,\r\n");
      out.write("\t\t\t\t    href:\"pages/portal/yujing.html\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t{    \r\n");
      out.write("\t\t\t\t    title: '系统BUG反馈',    \r\n");
      out.write("\t\t\t\t    height:200,    \r\n");
      out.write("\t\t\t\t    closable: true,    \r\n");
      out.write("\t\t\t\t    collapsible: true,\r\n");
      out.write("\t\t\t\t    href:\"pages/portal/bug.html\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//3.往portal添加面板\r\n");
      out.write("\t\t//3.1 创建一个新的面板\r\n");
      out.write("\t\tfor(var i=0;i<panels.length;i++){\r\n");
      out.write("\t\t\tvar p = $('<div></div>').appendTo('body');    \r\n");
      out.write("\t\t\tp.panel(panels[i]);    \r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t//3.2 把面板追加到portal \r\n");
      out.write("\t\t\t$('#pp').portal('add', {    \r\n");
      out.write("\t\t\t    panel: p,   \r\n");
      out.write("\t\t\t    //列索引\r\n");
      out.write("\t\t\t    columnIndex:i%2     \r\n");
      out.write("\t\t\t});  \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
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
