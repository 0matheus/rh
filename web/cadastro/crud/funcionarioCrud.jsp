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
    <body>
        <%
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
            
        
        
        
        
        
        
        %>
    </body>
</html>
