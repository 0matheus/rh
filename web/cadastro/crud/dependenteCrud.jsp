<%-- 
    Document   : dependenteCrud
    Created on : 21/10/2015, 16:53:37
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "br.com.prog3.rh.Dependente, br.com.prog3.rh.DependenteDAO" %>
<%@page import= "java.util.List" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD para Dependente</title>
    </head>

    <script>
        function funcVoltar()
        {
            window.location.href="../dependente.jsp"
        }
    </script>
    
    <body>
        <%
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
        
            if(!crud.equals("Pesquisar")){
                    iMatricula = Integer.parseInt(matricula);
                    iIdade = Integer.parseInt(idade);
            }
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
                %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>
                <%                
            }
            
            if(crud.equals("Alterar")){
                //Enviando objeto para o banco
                out.print(dd.alterar(d));
                %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>
                <%
            }
            
            if(crud.equals("Excluir")){
                //Enviando objeto para o banco
                out.print(dd.excluir(d));
                %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>
                <%
            }
            
            if(crud.equals("Pesquisar")){
                //Enviando objeto para o banco
                List<Dependente> ld = dd.listarTodos();
                for (Dependente dep : ld){
                    out.print("<a href=../dependente.jsp?" 
                            + "nome=" + dep.getNome() 
                            + "&matricula=" + dep.getMatricula()  
                            + "&idade=" + dep.getIdade() 
                            + "&sexo=" + dep.getSexo() + ">");
                    out.print(dep.getNome() + " ");
                    out.print("</a>");
                    out.print(dep.getMatricula() + " ");
                    out.print(dep.getIdade() + " ");
                    out.print(dep.getSexo() + " ");
                    out.print("<br>");
                
                }
            }
        
        %>
    </body>
</html>
