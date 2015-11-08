<%-- 
    Document   : evento
    Created on : 15/10/2015, 09:13:16
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Enventos</title>
    </head>
    <script>
        function excluir()
        {
            if(confirm("Deseja realmente excluir ?")){
                alert('Excluido');
            }else{
                alert('Operaçao cancelada');
                with()
                window.location.href="../evento.jsp"
            }
        }
    </script>

    <body>
        
        <%
            String dia = request.getParameter("dia");
            if(dia == null || dia.equals("")){
                dia = "00";
            }
            
            String mes = request.getParameter("mes");
            if(mes == null || dia.equals("")){
                mes = "00";
            }
            
            String ano = request.getParameter("ano");
            if(ano == null || dia.equals("")){
                ano = "0000";
            }
            
            String descricao = request.getParameter("descricao");
            if(descricao == null || descricao.equals("")){
                descricao = "";
            }
            
            
        %>
        
        <div><h2>Cadastro de Eventos</h2></div>
        <form action="crud/eventoCrud.jsp" method="get" name="form1" >
            <div>Dia: <input type="text" name="dia" value="<%=dia%>"></div><p>
            <div>Mes: <input type="text" name="mes" value="<%=mes%>"></div><p>
            <div>Ano: <input type="text" name="ano" value="<%=ano%>"></div><p>
            <div>Descrição: <input type="text" name="descricao" value="<%=descricao%>" </div><p>
            
            <div>
                <input type="submit" name="crud" value="Inserir"/>
                <input type="submit" name="crud" value="Alterar"/>
                <input type="submit" name="crud" value="Excluir" onclick="excluir()" />
                <input type="submit" name="crud" value="Pesquisar"/>
                <input type="reset" value="Limpar"/>            
             </div>
        
        

        
        
        
        </form>
        
    </body>
</html>
