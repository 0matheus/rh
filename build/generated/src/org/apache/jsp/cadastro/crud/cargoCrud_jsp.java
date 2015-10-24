package org.apache.jsp.cadastro.crud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.prog3.rh.Cargo;
import br.com.prog3.rh.CargoDAO;
import java.util.List;

public final class cargoCrud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>CRUD para cargo</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            //Pegando Parametro do formulario cargo.jsp
            String codigo = request.getParameter("codigo");
            if (codigo == null) {
                codigo = "0";
            }
            if (codigo.equals("")) {
                codigo = "0";
            }

            String descricao = request.getParameter("descricao");
            if (descricao == null) {
                descricao = "";
            }
            if (descricao.equals("")) {
                descricao = "";
            }
            String salario = request.getParameter("salario");
            if (salario == null) {
                salario = "0.0";
            }
            if (salario.equals("")) {
                salario = "0.0";
            }
            String crud = request.getParameter("crud");

            //Convertendo dados
            Integer iCodigo=0;
            Double dSalario=0.0;
            if (!crud.equals("Pesquisar")) {
                iCodigo = Integer.parseInt(codigo);
                dSalario = Double.parseDouble(salario);
            }

            //Criando objeto das classes Cargo e CargoDAO
            Cargo c = new Cargo();
            CargoDAO cd = new CargoDAO();

            //Atribuindo Valores ao objeto c da Classe cargo
            c.setCodigo(iCodigo);
            c.setDescricao(descricao);
            c.setSalario(dSalario);

            //Verificando qual botao foi acionado
            if (crud.equals("Inserir")) {
                //Enviando o objeto para o banco
                out.print(cd.inserir(c));
            }

            if (crud.equals("Alterar")) {
                //Enviando o objeto para o banco
                out.print(cd.alterar(c));
            }

            if (crud.equals("Excluir")) {
                //Enviando o objeto para o banco
                out.print(cd.excluir(c));
            }

            if (crud.equals("Pesquisar")) {
                //Enviando o objeto para o banco
                List<Cargo> lc = cd.listarTodos();
                for (Cargo car : lc) {
                    out.print("<a href=../cargo.jsp?" + "codigo=" + car.getCodigo() + "&descricao=" + car.getDescricao() + "&salario=" + car.getSalario() + ">");
                    out.print(car.getCodigo() + " ");
                    out.print("</a>");
                    out.print(car.getDescricao() + " ");
                    out.print(car.getSalario() + " ");
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
