<%-- 
    Document   : cargo
    Created on : 01/10/2015, 08:55:23
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cargos</title>
    </head>
    
    <body>
        <%
            String codigo = request.getParameter("codigo");
            if(codigo == null || codigo.equals("")){
                codigo = "0";
            }
            String descricao = request.getParameter("descricao");
            if(descricao == null || descricao.equals("")){
                descricao = "";
            }
            String salario = request.getParameter("salario");
            if(salario == null || salario.equals("")){
                salario = "0.0";
            }
            
        %>
        <div><h2>Cadastro de Cargos</h2></div>
        <form action="crud/cargoCrud.jsp" method="get" name="form1" >
            <div>Codigo: <input type="text" name="codigo" value="<%=codigo%>"></div><p>
            <div>Descrição: <input type="text" name="descricao" value="<%=descricao%>"></div><p>
            <div>Salario: <input type="text" name="salario" value="<%=salario%>"></div><p>
                
            <div>
                <input type="submit" name="crud" value="Inserir"/>
                <input type="submit" name="crud" value="Alterar"/>
                <input type="submit" name="crud" value="Excluir"/>
                <input type="submit" name="crud" value="Pesquisar"/>
                <input type="reset" value="Limpar"/>            
             </div>
        </form>

            
            
    </body>
</html>
