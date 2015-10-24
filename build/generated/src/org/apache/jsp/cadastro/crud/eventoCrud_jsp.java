package org.apache.jsp.cadastro.crud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.prog3.rh.Evento;
import br.com.prog3.rh.EventoDAO;
import java.util.List;

public final class eventoCrud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>CRUD para evento</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            //Pegando Parametro do formulario evento.jsp
            String dia = request.getParameter("dia");
            if (dia == null) {
                dia = "0";
            }
            if (dia.equals("")) {
                dia = "0";
            }

            String mes = request.getParameter("mes");
            if (mes == null) {
                mes = "0";
            }
            if (mes.equals("")) {
                mes = "0";
            }
            
            String ano = request.getParameter("ano");
            if (ano == null) {
                ano = "0";
            }
            if (ano.equals("")) {
                ano = "0";
            }
            
            
            String descricao = request.getParameter("descricao");
            if (descricao == null) {
                descricao = "";
            }
            if (descricao.equals("")) {
                descricao = "";
            }
            
            
            String crud = request.getParameter("crud");
            
            
            //Convertendo dados
            Integer iDia=00;
            Integer iMes=00;
            Integer iAno=00;
           
            iDia = Integer.parseInt(dia);
            iMes = Integer.parseInt(mes);
            iAno = Integer.parseInt(ano);
                
        
            //Criando objeto das classes Evento e EventoDAO
            Evento e = new Evento();
            EventoDAO ed = new EventoDAO();

            //Atribuindo Valores ao objeto c da Classe Evento
            e.setDia(iDia);
            e.setMes(iMes);
            e.setAno(iAno);            
            e.setDescricao(descricao);
            
            //Verificando qual botao foi acionado
            if (crud.equals("Inserir")) {
                //Enviando o objeto para o banco
                out.print(ed.inserir(e));
            }

            if (crud.equals("Alterar")) {
                //Enviando o objeto para o banco
                out.print(ed.alterar(e));
            }

            if (crud.equals("Excluir")) {
                //Enviando o objeto para o banco
                out.print(ed.excluir(e));
            }

            if (crud.equals("Pesquisar")) {
                //Enviando o objeto para o banco
                List<Evento> le = ed.listarTodos();
                for (Evento eve : le) {
                    out.print("<a href=../evento.jsp?" +"dia=" + eve.getDia() +"&mes=" + eve.getMes() +"&ano=" + eve.getAno() +"&descricao=" + eve.getDescricao() + ">");
                    out.print(eve.getDia() + " ");
                    out.print("</a>");
                    out.print(eve.getMes() + " ");
                    out.print(eve.getAno() + " ");
                    out.print(eve.getDescricao() + " ");
                    out.print("<br>");
                }

            }
            
               
        
      out.write("\n");
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
