package org.apache.jsp.cadastro.crud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.prog3.rh.Dependente;
import br.com.prog3.rh.DependenteDAO;
import java.util.List;

public final class dependenteCrud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>CRUD para Dependente</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");

            //Pegando Parametro do formulario dependente.jsp
            String nome = request.getParameter("nome");
            if (nome == null ){
                nome = "";
            }
            if (nome.equals("")){
                nome = "";
            }
            
            String matricula = request.getParameter("matricula");
            if (matricula == null){
                matricula = "0";
            }
            if (matricula.equals("")){
                matricula = "0";
            }
        
            String idade = request.getParameter("idade");
            if (idade == null){
                idade = "0";
            }
            if (idade.equals("")){
                idade = "0";
            }
        
            String sexo = request.getParameter("sexo");
            if (sexo == null){
                sexo = "-";
            }
            if (sexo.equals("")){
                sexo = "-";
            }
        
            String crud = request.getParameter("crud");
            
            //Convertendo Dados
            
            Integer iMatricula = 0;
            Integer iIdade = 0;
        
            iMatricula = Integer.parseInt("matricula");
            iIdade = Integer.parseInt("idade");
        
            //Criando Objeto da classe Dependete e DependenteDAO
            
            Dependente d = new Dependente();
            DependenteDAO dd = new DependenteDAO();
        
            //Atribuindo valores para os objtos da classe Dependente
            
            d.setNome(nome);
            d.setMatricula(iMatricula);
            d.setIdade(iIdade);
            d.setSexo(sexo);
            
            //Verificando qual botao foi acionado
            
            if (crud.equals("Inserir")){
                //Enviando objeto para o banco
                out.print(dd.inserir(d));                
            }
            
            if(crud.equals("Alterar")){
                //Enviando objeto para o banco
                out.print(dd.alterar(d));
            }
            
            if(crud.equals("Excluir")){
                //Enviando objeto para o banco
                out.print(dd.excluir(d));
            }
            
            if(crud.equals("Pesquisar")){
                //Enviando objeto para o banco
                List<Dependente> ld = dd.listarTodos();
                for (Dependente dep : ld){
                    out.print("<a href=../dependente.jsp?" + "nome=" + dep.getNome() + "&matricula=" + dep.getMatricula()  + "&idade=" + dep.getIdade() + "&sexo=" + dep.getSexo() ">");
                    out.print(dep.getNome());
                
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
