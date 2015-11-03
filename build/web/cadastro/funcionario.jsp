<%-- 
    Document   : funcionario
    Created on : 17/10/2015, 08:34:21
    Author     : aluno
--%>

<%@page import= "br.com.prog3.rh.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "br.com.prog3.rh.Funcionario, br.com.prog3.rh.CargoDAO, br.com.prog3.rh.FuncionarioDAO" %>
<%@page import= "java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionario</title>
    </head>
    <script>
        function limpar(){
            with(document.form1){
                matricula.value = '';
                nome.value = '';
                cargo.value = '';
            }
        }
    </script>
    <body>
        <%
            String matricula = "0";
            String nome = "";
            String cargo = "0";
            String crud = "";
            
            CargoDAO cd= new CargoDAO();
            Cargo c = new Cargo();
            List<Cargo> lc = cd.listarTodos();
            
            if(request.getParameter("matricula") != null){
                matricula = request.getParameter("matricula");
            }
            
            if(request.getParameter("nome") != null){
                nome = request.getParameter("nome");
            }
            
            if(request.getParameter("cargo") != null){
                cargo = request.getParameter("cargo");
            }
            
            
            String descricao = "";
            if(!cargo.equals("") && !cargo.equals("0")){
                c = cd.buscaPorCodigo(Integer.parseInt(cargo));
                descricao = c.getDescricao();
            }
            
            
        %>
        
        <div><h2>Cadastro de Funcionarios</h2></div>
        <form action="crud/funcionarioCrud.jsp" method="get" name="form1" >
            <div>Matricula: <input type="text" name="matricula" value="<%=matricula%>"/></div><p>
            <div>Nome: <input type="text" name="nome" value="<%=nome%>"/></div><p>
                
            <div>Cargo: 
                <select name="cargo">
                    <option value="<%=cargo%>"> <%=descricao%> </option>
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
                <input type="button" value="Limpar" onclick="parent.location.href='funcionario.jsp'" />            
             </div>
        
        
        </form>
        
        
        
    </body>
</html>
