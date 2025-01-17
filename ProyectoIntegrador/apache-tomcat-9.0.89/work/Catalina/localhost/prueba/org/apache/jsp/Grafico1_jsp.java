/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.89
 * Generated at: 2024-05-27 11:05:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Ventas;
import dao.Negocio;

public final class Grafico1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("dao.Negocio");
    _jspx_imports_classes.add("modelo.Ventas");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("  <script src=\n");
      out.write("\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.2/Chart.min.js\"></script>\n");
      out.write("  <style>\n");
      out.write("    .container {\n");
      out.write("      width: 70%;\n");
      out.write("      margin: 15px auto;\n");
      out.write("    }\n");
      out.write("    body {\n");
      out.write("      text-align: center;\n");
      out.write("      color: green;\n");
      out.write("    }\n");
      out.write("    h2 {\n");
      out.write("      text-align: center;\n");
      out.write("      font-family: \"Verdana\", sans-serif;\n");
      out.write("      font-size: 30px;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("  <body>\n");

   Negocio  obj=new Negocio();
   int an=Integer.parseInt(request.getParameter("tan"));
   String tipo=request.getParameter("opc");
   String label="",data="";
   for(Ventas x:obj.lisMes(an)){
    label=label+"'"+x.Lmes()+"',";
    data=data+x.getMonto()+",";
    }
    data=data.substring(0, data.length()-1);
 
      out.write("   \n");
      out.write("   \n");
      out.write("    <div class=\"container\">\n");
      out.write("      <h2>ventas del año ");
      out.print(an);
      out.write("</h2>\n");
      out.write("      <div>\n");
      out.write("        <canvas id=\"myChart\"></canvas>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("  <script>\n");
      out.write("    var ctx = document.getElementById(\"myChart\").getContext(\"2d\");\n");
      out.write("    var myChart = new Chart(ctx, {\n");
      out.write("      type: \"");
      out.print(tipo);
      out.write("\",\n");
      out.write("      data: {\n");
      out.write("        labels: [");
      out.print(label);
      out.write(" ],\n");
      out.write("        datasets: [\n");
      out.write("          {\n");
      out.write("            label: \"ventas\",\n");
      out.write("            data: [");
      out.print(data);
      out.write("],\n");
      out.write("            backgroundColor: [\"rgba(153,205,1,0.6)\",\"lightblue\",\n");
      out.write("        \"lightred\",\"peru\",\"yellow\",\"orange\",\"blue\",\"green\"],\n");
      out.write("          },\n");
      out.write("          \n");
      out.write("        ],\n");
      out.write("      },\n");
      out.write("    });\n");
      out.write("  </script>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
