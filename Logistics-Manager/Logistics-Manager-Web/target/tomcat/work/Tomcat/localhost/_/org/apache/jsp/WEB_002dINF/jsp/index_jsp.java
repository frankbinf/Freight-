/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-07-17 05:07:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fauthenticated;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fauthenticated = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.release();
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>???????????????</title>\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"place\">\r\n");
      out.write("    <span>?????????</span>\r\n");
      out.write("    <ul class=\"placeul\">\r\n");
      out.write("        <li><a href=\"#\">??????</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"mainindex\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"welinfo\">\r\n");
      out.write("        <span><img src=\"images/sun.png\" alt=\"??????\" /></span>\r\n");
      out.write("        <b><span style=\"font-size: 13px\" >");
      if (_jspx_meth_shiro_005fauthenticated_005f0(_jspx_page_context))
        return;
      out.write("</font>?????????????????????\r\n");
      out.write("        </span >\r\n");
      out.write("        </b>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"welinfo\">\r\n");
      out.write("        <span ><img src=\"images/time.png\" alt=\"???????????????\" /></span><label id=\"lb1\"></label>\r\n");
      out.write("        <script>setInterval(\r\n");
      out.write("            function (){\r\n");
      out.write("                var date = new Date();\r\n");
      out.write("                year = date.getFullYear()+'???';\r\n");
      out.write("                month = date.getMonth()+1+'???';\r\n");
      out.write("                day = date.getDate()+'???';\r\n");
      out.write("                hours = date.getHours();\r\n");
      out.write("                minutes = date.getMinutes();\r\n");
      out.write("                seconds = date.getSeconds();\r\n");
      out.write("                document.getElementById(\"lb1\").innerHTML=year+month+day+\"&nbsp;\"+\"&nbsp;\"+hours\r\n");
      out.write("                    +\":\"+minutes+\":\"+seconds},\r\n");
      out.write("            1000)\r\n");
      out.write("        </script>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"xline\"></div>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"iconlist\">\r\n");
      out.write("\r\n");
      out.write("        <li><img src=\"images/ico01.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("        <li><img src=\"images/ico02.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("        <li><img src=\"images/ico03.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("        <li><img src=\"images/ico04.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("        <li><img src=\"images/ico05.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("        <li><img src=\"images/ico06.png\" /><p><a href=\"#\">????????????</a></p></li>\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"ibox\"><a class=\"ibtn\"><img src=\"images/iadd.png\" />????????????????????????</a></div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"xline\"></div>\r\n");
      out.write("    <div class=\"box\"></div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"welinfo\">\r\n");
      out.write("        <span><img src=\"images/dp.png\" alt=\"??????\" /></span>\r\n");
      out.write("        <b>??????????????????</b>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"infolist\">\r\n");
      out.write("        <li><span>???????????????????????????????????????</span><a class=\"ibtn\"style=\"margin-left: 69px\">???????????????????????????</a></li>\r\n");
      out.write("        <li><span>???????????????????????????????????????</span><a class=\"ibtn\"style=\"margin-left: 69px\">?????????????????????</a></li>\r\n");
      out.write("        <li><span>??????????????????????????????????????????????????????</span><a class=\"ibtn\"style=\"margin-left: 13px\">????????????</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"xline\"></div>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"umlist\">\r\n");
      out.write("        <li><a href=\"#\">??????????????????</a></li>\r\n");
      out.write("        <li><a href=\"#\">??????????????????</a></li>\r\n");
      out.write("        <li><a href=\"#\">??????????????????</a></li>\r\n");
      out.write("        <li><a href=\"#\">??????????????????(??????)</a></li>\r\n");
      out.write("        <li><a href=\"#\">????????????</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_shiro_005fauthenticated_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:authenticated
    org.apache.shiro.web.tags.AuthenticatedTag _jspx_th_shiro_005fauthenticated_005f0 = (org.apache.shiro.web.tags.AuthenticatedTag) _005fjspx_005ftagPool_005fshiro_005fauthenticated.get(org.apache.shiro.web.tags.AuthenticatedTag.class);
    _jspx_th_shiro_005fauthenticated_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fauthenticated_005f0.setParent(null);
    int _jspx_eval_shiro_005fauthenticated_005f0 = _jspx_th_shiro_005fauthenticated_005f0.doStartTag();
    if (_jspx_eval_shiro_005fauthenticated_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ?????????<font style=\"color: #1c77ac;font-size: 13px\">");
        if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_th_shiro_005fauthenticated_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_shiro_005fauthenticated_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fauthenticated_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fprincipal_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_005fauthenticated_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_005fauthenticated_005f0);
    // /WEB-INF/jsp/index.jsp(30,60) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("realName");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }
}
