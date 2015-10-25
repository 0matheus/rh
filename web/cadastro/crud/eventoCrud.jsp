<%-- 
    Document   : eventoCrud
    Created on : 15/10/2015, 09:27:10
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "br.com.prog3.rh.Evento, br.com.prog3.rh.EventoDAO"%>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD para evento</title>
    </head>
    <body>
        
        <%
            //Pegando Parametro do formulario evento.jsp
            String dia = request.getParameter("dia");
            if (dia == null) {
                dia = "00";
            }
            if (dia.equals("")) {
                dia = "00";
            }

            String mes = request.getParameter("mes");
            if (mes == null) {
                mes = "00";
            }
            if (mes.equals("")) {
                mes = "00";
            }
            
            String ano = request.getParameter("ano");
            if (ano == null) {
                ano = "00";
            }
            if (ano.equals("")) {
                ano = "00";
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
                    out.print("<a href=../evento.jsp?" + 
                            "dia=" + eve.getDia() +
                            "&mes=" + eve.getMes() +
                            "&ano=" + eve.getAno() + 
                            "&descricao=" + eve.getDescricao() + ">");
                    out.print(eve.getDia() + "/");
                    out.print(eve.getMes() + "/");
                    out.print(eve.getAno());
                    out.print("</a>  -  ");
                    out.print(eve.getDescricao() + " ");
                    out.print("<br>");
                }

            }
            
               
        %>
        
    </body>
</html>
