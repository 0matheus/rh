<%-- 
Document   : funcionarioCrud
Created on : 17/10/2015, 08:54:20
Author     : aluno
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.prog3.rh.Funcionario, br.com.prog3.rh.FuncionarioDAO"%>

<!DOCTYPE html>
<html>  
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Crud para Funcionario</title>
</head>
<script>
        function funcVoltar()
        {
            window.location.href="../funcionario.jsp"
        }

    </script>

<body>
    <%
        //Pegando Parametro do formulario cargo.jsp
        
        String matricula = "0";
        String nome = "";
        String cargo = "0";
        String crud = "";
        
        if(request.getParameter("matricula") != null){
            matricula = request.getParameter("matricula");
        }
        
        if(request.getParameter("nome") != null){
            nome = request.getParameter("nome");
        }
        
        if(request.getParameter("cargo") != null){
            cargo = request.getParameter("cargo");
        }
        
        if(request.getParameter("crud") != null){
            crud = request.getParameter("crud");
        }

      
         //Convertendo dados se nao forem vazios
        Integer iMatricula = 0;
        Integer iCargo = 0;
        
        if(!matricula.equals("")){
            iMatricula = Integer.parseInt(matricula);
        }
       
        if(!matricula.equals("")){
            iCargo = Integer.parseInt(cargo);
        } 
        
        
        
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
            %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>
            <% 
        }

        if (crud.equals("Alterar")) {
            //Enviando o objeto para o banco
            out.print(fd.alterar(f));
            %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>
            <% 
        }

        if (crud.equals("Excluir")) {
            //Enviando o objeto para o banco
            %>

            <%
            out.print(fd.excluir(f));
            %>
                <div><input type="button" value="Voltar" onclick="funcVoltar()"></div>

            <% 
        }

        if (crud.equals("Pesquisar")) {
            //Enviando o objeto para o banco
            List<Funcionario> lf = fd.listarTodos();
            for (Funcionario func : lf) {%>

            <a href= "../funcionario.jsp?matricula=<%=func.getMatricula()%>&nome=<%=func.getNome()%>&cargo=<%=func.getCargo()%>">
            <%=func.getMatricula()%></a>
            <%=func.getNome()%>
            <%=func.getCargo()%><br>
            <%}

        }
        %>  
    
    
</body>
</html>
