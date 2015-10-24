package org.apache.jsp.cadastro.crud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import br.com.prog3.rh.Funcionario;
import br.com.prog3.rh.FuncionarioDAO;

public final class funcionarioCrud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Crud para Funcionario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            //Pegando Parametro do formulario cargo.jsp
            String matricula = request.getParameter("matricula");
            if (matricula == null) {
                matricula = "0";
            }
            if (matricula.equals("")) {
                matricula = "0";
            }

            String nome = request.getParameter("nome");
            if (nome == null) {
                nome = "";
            }
            if (nome.equals("")) {
                nome = "";
            }
            String cargo = request.getParameter("cargo");
            if (cargo == null) {
                cargo = "0";
            }
            
            String crud = request.getParameter("crud");
        
             //Convertendo dados
            Integer iMatricula=0;
            Integer iCargo=0;
           
           
            iMatricula = Integer.parseInt(matricula);
            iCargo = Integer.parseInt(cargo);
            
            
             //Criando objeto das classes Funcionario e FuncionarioDAO
            Funcionario f = new Funcionario();
            FuncionarioDAO fd = new FuncionarioDAO();
        
             //Atribuindo Valores ao objeto c da Classe Funcionario
            f.setMatricula(iMatricula);         
            f.setNome(nome);
            f.setCargo(iCargo);
            
            
            //Verificando qual botao foi acionado
            if (crud.equals("Inserir")) {
                //Enviando o objeto para o banco
                out.print(fd.inserir(f));
            }

            if (crud.equals("Alterar")) {
                //Enviando o objeto para o banco
                out.print(fd.alterar(f));
            }

            if (crud.equals("Excluir")) {
                //Enviando o objeto para o banco
                out.print(fd.excluir(f));
            }

            if (crud.equals("Pesquisar")) {
                //Enviando o objeto para o banco
                List<Funcionario> lf = fd.listarTodos();
                for (Funcionario func : lf) {
                    out.print("<a href=../funcionario.jsp?"
                            + "matricula=" + func.getMatricula()
                            + "&nome=" + func.getNome()
                            + "&cargo=" + func.getCargo() + ">");
                    out.print(func.getMatricula() + " ");
                    out.print("</a>");
                    out.print(func.getNome() + " ");
                    out.print(func.getCargo() + " ");
                    out.print("<br>");
                }

            }
            
             
        
        
        
        
        
      out.write("\n");
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
