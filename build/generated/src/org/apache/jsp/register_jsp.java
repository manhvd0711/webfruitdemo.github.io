package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Register</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!--===============================================================================================-->\t\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/iconic/css/material-design-iconic-font.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\n");
      out.write("        <!--===============================================================================================-->\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\n");
      out.write("        <!--===============================================================================================-->\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"limiter\">\n");
      out.write("            <div class=\"container-login100\" style=\"background-image: url('images/bg-01.jpg');\">\n");
      out.write("                <div class=\"wrap-login100\">\n");
      out.write("                    <form class=\"login100-form validate-form\" action=\"RegisterServlet\" method=\"post\">\n");
      out.write("\n");
      out.write("                        <span class=\"login100-form-title p-b-34 p-t-27\">\n");
      out.write("                            Sign Up \n");
      out.write("                        </span>\n");
      out.write("\n");
      out.write("                        <div class=\" validate-input\" data-validate = \"Full Name\">\n");
      out.write("                            <input class=\"input100\" type=\"text\" name=\"FullName\" placeholder=\"Full Name\"\n");
      out.write("                                   ");
 if (request.getAttribute("fullname") != null) {
      out.write("\n");
      out.write("                                   value=\"");
      out.print( request.getAttribute("fullname"));
      out.write("\" \n");
      out.write("                                   ");
}
      out.write(" \n");
      out.write("                                   >\n");
      out.write("                            <span class=\"focus-input100\" data-placeholder=\"&#xf207;\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate = \"Email\">\n");
      out.write("                            <input class=\"input100\" type=\"email\" name=\"Email\" placeholder=\"Email\"\n");
      out.write("                                   ");
 if (request.getAttribute("email") != null) {
      out.write("\n");
      out.write("                                   value=\"");
      out.print( request.getAttribute("email"));
      out.write('"');
      out.write(' ');
}
      out.write(">\n");
      out.write("                            <span class=\"focus-input100\" data-placeholder=\"&#xf207;\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate = \"Enter username\">\n");
      out.write("                            <input class=\"input100\" type=\"text\" name=\"username\" placeholder=\"Username\"\n");
      out.write("                                   ");
 if (request.getAttribute("username") != null) {
      out.write("\n");
      out.write("                                   value=\"");
      out.print( request.getAttribute("username"));
      out.write('"');
      out.write(' ');
}
      out.write(" \n");
      out.write("                                   >\n");
      out.write("                            <span class=\"focus-input100\" data-placeholder=\"&#xf207;\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate=\"Enter password\">\n");
      out.write("                            <input class=\"input100\" type=\"password\" name=\"password\" placeholder=\"Password\">\n");
      out.write("                            <span class=\"focus-input100\" data-placeholder=\"&#xf191;\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate=\"Repeat password\">\n");
      out.write("                            <input class=\"input100\" type=\"password\" name=\"repassword\" placeholder=\"Repeat Password\">\n");
      out.write("                            <span class=\"focus-input100\" data-placeholder=\"&#xf191;\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"contact100-form-checkbox\">\n");
      out.write("                            <input class=\"input-checkbox100\" id=\"ckb1\" type=\"checkbox\" name=\"agree\">\n");
      out.write("                            <label class=\"label-checkbox100\" for=\"ckb1\">\n");
      out.write("                                I agree to <b>the terms of user</b> \n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <center >\n");
      out.write("                            ");
 if (request.getAttribute("userName_error") != null) { 
      out.write("\n");
      out.write("                            <p style=\"color: yellow; font-size: 20px\" >Username already used !</p>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                            ");
 if (request.getAttribute("email_error") != null) { 
      out.write("\n");
      out.write("                            <p style=\"color: yellow; font-size: 20px\" >Email already used !</p>\n");
      out.write("                            ");
 }
      out.write("                            \n");
      out.write("                            ");
 if (request.getAttribute("rePass_error") != null) { 
      out.write("\n");
      out.write("                            <p style=\"color: yellow; font-size: 20px\" >Password Retyped is not correct !</p>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                            ");
 if (request.getAttribute("agree_error") != null) { 
      out.write("\n");
      out.write("                            <p style=\"color: yellow; font-size: 20px\" >You must agree to the terms of user !</p>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            ");
 if (request.getAttribute("success") != null) { 
      out.write("\n");
      out.write("                            <p style=\"color: orange; font-size: 40px\" ><b>Success</b></p>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </center>\n");
      out.write("                        <div class=\"container-login100-form-btn\">\n");
      out.write("                            <button class=\"login100-form-btn\">\n");
      out.write("                                Sign Up\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <center><a  href=\"login.jsp\" class=\"text-center p-t-90\" style=\"font-size: 20px;color: white\">\n");
      out.write("                                -> Login <-\n");
      out.write("                            </a></center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div id=\"dropDownSelect1\"></div>\n");
      out.write("\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/animsition/js/animsition.min.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/bootstrap/js/popper.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/select2/select2.min.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/daterangepicker/moment.min.js\"></script>\n");
      out.write("    <script src=\"vendor/daterangepicker/daterangepicker.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"vendor/countdowntime/countdowntime.js\"></script>\n");
      out.write("    <!--===============================================================================================-->\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
