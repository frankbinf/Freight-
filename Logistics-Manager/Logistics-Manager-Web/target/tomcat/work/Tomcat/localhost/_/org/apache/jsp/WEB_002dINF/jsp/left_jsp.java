/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-07-14 03:10:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>无标题文档</title>\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <script language=\"JavaScript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function(){\r\n");
      out.write("            //导航切换\r\n");
      out.write("            $(\".menuson li\").click(function(){\r\n");
      out.write("                $(\".menuson li.active\").removeClass(\"active\")\r\n");
      out.write("                $(this).addClass(\"active\");\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $('.title').click(function(){\r\n");
      out.write("                var $ul = $(this).next('ul');\r\n");
      out.write("                $('dd').find('ul').slideUp();\r\n");
      out.write("                if($ul.is(':visible')){\r\n");
      out.write("                    $(this).next('ul').slideUp();\r\n");
      out.write("                }else{\r\n");
      out.write("                    $(this).next('ul').slideDown();\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"background:#f0f9fd;\">\r\n");
      out.write("<div class=\"lefttop\"><span></span>通讯录</div>\r\n");
      out.write("\r\n");
      out.write("<dl class=\"leftmenu\">\r\n");
      out.write("\r\n");
      out.write("    <dd>\r\n");
      out.write("        <div class=\"title\">\r\n");
      out.write("            <span><img src=\"images/leftico01.png\" /></span>管理信息\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"menuson\">\r\n");
      out.write("            <li><cite></cite><a href=\"index.html\" target=\"rightFrame\">首页模版</a><i></i></li>\r\n");
      out.write("            <li class=\"active\"><cite></cite><a href=\"user/query\" target=\"rightFrame\">用户管理</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"role/query\" target=\"rightFrame\">角色管理</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"form.html\" target=\"rightFrame\">添加编辑</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"imglist.html\" target=\"rightFrame\">图片列表</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"imglist1.html\" target=\"rightFrame\">自定义</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"tools.html\" target=\"rightFrame\">常用工具</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"filelist.html\" target=\"rightFrame\">信息管理</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"tab.html\" target=\"rightFrame\">Tab页</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"error.html\" target=\"rightFrame\">404页面</a><i></i></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </dd>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <dd>\r\n");
      out.write("        <div class=\"title\">\r\n");
      out.write("            <span><img src=\"images/leftico02.png\" /></span>其他设置\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"menuson\">\r\n");
      out.write("            <li><cite></cite><a href=\"#\">编辑内容</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">发布信息</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">档案列表显示</a><i></i></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </dd>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <dd><div class=\"title\"><span><img src=\"images/leftico03.png\" /></span>编辑器</div>\r\n");
      out.write("        <ul class=\"menuson\">\r\n");
      out.write("            <li><cite></cite><a href=\"#\">自定义</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">常用资料</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">信息列表</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">其他</a><i></i></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </dd>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <dd><div class=\"title\"><span><img src=\"images/leftico04.png\" /></span>日期管理</div>\r\n");
      out.write("        <ul class=\"menuson\">\r\n");
      out.write("            <li><cite></cite><a href=\"#\">自定义</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">常用资料</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">信息列表</a><i></i></li>\r\n");
      out.write("            <li><cite></cite><a href=\"#\">其他</a><i></i></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("    </dd>\r\n");
      out.write("\r\n");
      out.write("</dl>\r\n");
      out.write("\r\n");
      out.write("<div style=\"display:none\"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
