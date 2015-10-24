<%-- 
    Document   : treinamento
    Created on : 01/10/2015, 09:39:51
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Treinamento</title>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String msg = "JSP é fácil!";
            for (int i = 0; i < 5; i++) {
                out.print(msg);%>


        <br>
        <%
            }

                %>
    </body>
</html>
