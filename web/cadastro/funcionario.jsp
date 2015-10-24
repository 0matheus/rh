<%-- 
    Document   : funcionario
    Created on : 17/10/2015, 08:34:21
    Author     : aluno
--%>

<%@page import="br.com.prog3.rh.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.prog3.rh.Funcionario, br.com.prog3.rh.CargoDAO, br.com.prog3.rh.FuncionarioDAO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <%
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
            
        %>
        
        <div><h2>Cadastro de Funcionarios</h2></div>
        <form action="crud/funcionarioCrud.jsp" method="get" name="form1" >
            <div>Matricula: <input type="text" name="matricula" value="<%=matricula%>"></div><p>
            <div>Nome: <input type="text" name="nome" value="<%=nome%>"></div><p>
                
            <div>Cargo: 
                <select name="cargo">
                    <option value="0"> Selecione </option>
                    <%for (Cargo car: lc){ %>
                    <option value="<%=car.getCodigo()%>"> <%=car.getDescricao()%></option>
                    <% }%>
                </select>
            </div>
                
                
                
            <br>
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
