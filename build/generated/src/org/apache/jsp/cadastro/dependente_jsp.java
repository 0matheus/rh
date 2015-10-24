package org.apache.jsp.cadastro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dependente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro de dependentes</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            String nome = request.getParameter("nome");
            if(nome == null || nome.equals("")){
                nome = "";
            }
            
            String matricula = request.getParameter("matricula");
            if (matricula == null || matricula.equals("")){
                matricula = "";
            }
            
            String idade = request.getParameter("idade");
            if (idade == null || idade.equals(""));{
                idade = "0";
            }
        
            String sexo = request.getParameter("sexo");
            if (sexo == null || sexo.equals("")){
                sexo = "";
            }
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div> <h2>Cadastro de Dependentes</h2></div>\n");
      out.write("        \n");
      out.write("        <form action=\"crud/dependenteCrud.jsp\" method=\"get\" name=\"form1\">\n");
      out.write("            <div> Nome: <input type=\"text\" name=\"nome\" value=\"");
      out.print(nome);
      out.write("\"/></div><p>\n");
      out.write("            <div> Matricula: <input type=\"text\" name=\"matricula\" value=\"");
      out.print(matricula);
      out.write("\"/></div><p>\n");
      out.write("            <div> Idade: <input type=\"text\" name=\"idade\" value=\"");
      out.print(idade);
      out.write("\"/></div><p>\n");
      out.write("            <div> Sexo: <input type=\"text\" name=\"sexo\" value=\"");
      out.print(sexo);
      out.write("\"/></div><p>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Inserir\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Alterar\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Excluir\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Pesquisar\"/>\n");
      out.write("                <input tyoe=\"reset\"  value=\"Limpar\"/>                \n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("    </body>\n");
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
