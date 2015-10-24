<%-- 
    Document   : dependente
    Created on : 21/10/2015, 16:23:18
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "br.com.prog3.rh.FuncionarioDAO, br.com.prog3.rh.Funcionario" %>
<%@page import= "br.com.prog3.rh.Dependente, br.com.prog3.rh.DependenteDAO"%>
<%@page import= "java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de dependentes</title>
    </head>
    
    <body>
        
        <%
            String nome = request.getParameter("nome");
            if(nome == null || nome.equals("")){
               nome = "";
           }
            
            String matricula = request.getParameter("matricula");
             if (matricula == null || matricula.equals("")){
                matricula = "";
           }
            
            String idade = request.getParameter("idade");
             if (idade == null || idade.equals("")){
               idade = "0";
            }
        
            String sexo = request.getParameter("sexo");
             if (sexo == null || sexo.equals("")){
                sexo = "";
            }
        
            FuncionarioDAO fd= new FuncionarioDAO();
            List<Funcionario> lf = fd.listarTodos();
        %>
        
        
        <div> <h2>Cadastro de Dependentes</h2></div>
        
        <form action="crud/dependenteCrud.jsp" method="get" name="form1">
            <div> Nome: <input type="text" name="nome" value="<%=nome%>"/></div><p>
            <div> Funcionario: 
                <select name="matricula">
                    <option value="0"> Selecione </option>
                    <%for (Funcionario func : lf){ %>
                    <option value="<%=func.getMatricula()%>"> <%=func.getNome()%></option>
                    <% }%>
                </select>
            </div><p>
            <div> Idade: <input type="text" name="idade" value="<%=idade%>"/></div><p>
            <div> Sexo: 
                <select name="sexo">
                    <option value="-"> Selecione </option>
                    <option value="M"> Masculino</option>
                    <option value="F"> Feminino</option>
                </select> </div><p>
            
            <div>
                <input type="submit" name="crud" value="Inserir"/>
                <input type="submit" name="crud" value="Alterar"/>
                <input type="submit" name="crud" value="Excluir"/>
                <input type="submit" name="crud" value="Pesquisar"/>
                <input type="reset"  value="Limpar"/>       
            </div>
            </form>
            
    </body>
</html>
