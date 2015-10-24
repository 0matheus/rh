package org.apache.jsp.cadastro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.prog3.rh.Cargo;
import br.com.prog3.rh.Funcionario;
import br.com.prog3.rh.CargoDAO;
import br.com.prog3.rh.FuncionarioDAO;
import java.util.List;

public final class funcionario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro de Funcionario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String matricula = request.getParameter("matricula");
            if(matricula == null || matricula.equals("")){
                matricula = "0";
            }
            String nome = request.getParameter("nome");
            if(nome == null || nome.equals("")){
                nome = "";
            }
            String cargo = request.getParameter("cargo");
            if(cargo == null || cargo.equals("")){
                cargo = "Nenhum";
            }
            
            CargoDAO cd= new CargoDAO();
            List<Cargo> lc = cd.listarTodos();
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div><h2>Cadastro de Funcionarios</h2></div>\n");
      out.write("        <form action=\"crud/funcionarioCrud.jsp\" method=\"get\" name=\"form1\" >\n");
      out.write("            <div>Matricula: <input type=\"text\" name=\"matricula\" value=\"");
      out.print(matricula);
      out.write("\"></div><p>\n");
      out.write("            <div>Nome: <input type=\"text\" name=\"nome\" value=\"");
      out.print(nome);
      out.write("\"></div><p>\n");
      out.write("                \n");
      out.write("            <div>Cargo: \n");
      out.write("                <select name=\"cargo\"> \n");
      out.write("                    ");
for (Cargo car: lc){ 
      out.write("\n");
      out.write("                    <option value=\"0\"> Selecione </option>>\n");
      out.write("                    <option value=\"");
      out.print(car.getCodigo());
      out.write("\"> ");
      out.print(car.getDescricao());
      out.write("</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </select>    \n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            <br>\n");
      out.write("            <div>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Inserir\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Alterar\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Excluir\"/>\n");
      out.write("                <input type=\"submit\" name=\"crud\" value=\"Pesquisar\"/>\n");
      out.write("                <input type=\"reset\" value=\"Limpar\"/>            \n");
      out.write("             </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
