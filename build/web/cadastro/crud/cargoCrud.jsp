<%--
    Document   : cargoCrud
    Created on : 01/10/2015, 09:16:54
    Author     : aluno
--%>
<%@page import= "br.com.prog3.rh.Cargo, br.com.prog3.rh.CargoDAO"%>
<%@page import = "java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD para cargo</title>
    </head>
    <body>
        <%
            //Pegando Parametro do formulario cargo.jsp
            String codigo = request.getParameter("codigo");
            if (codigo == null) {
                codigo = "0";
            }
            if (codigo.equals("")) {
                codigo = "0";
            }

            String descricao = request.getParameter("descricao");
            if (descricao == null) {
                descricao = "";
            }
            if (descricao.equals("")) {
                descricao = "";
            }
            String salario = request.getParameter("salario");
            if (salario == null) {
                salario = "0.0";
            }
            if (salario.equals("")) {
                salario = "0.0";
            }
            String crud = request.getParameter("crud");

            //Convertendo dados
            Integer iCodigo=0;
            Double dSalario=0.0;
            if (!crud.equals("Pesquisar")) {
                iCodigo = Integer.parseInt(codigo);
                dSalario = Double.parseDouble(salario);
            }

            //Criando objeto das classes Cargo e CargoDAO
            Cargo c = new Cargo();
            CargoDAO cd = new CargoDAO();

            //Atribuindo Valores ao objeto c da Classe cargo
            c.setCodigo(iCodigo);
            c.setDescricao(descricao);
            c.setSalario(dSalario);

            //Verificando qual botao foi acionado
            if (crud.equals("Inserir")) {
                //Enviando o objeto para o banco
                out.print(cd.inserir(c));
            }

            if (crud.equals("Alterar")) {
                //Enviando o objeto para o banco
                out.print(cd.alterar(c));
            }

            if (crud.equals("Excluir")) {
                //Enviando o objeto para o banco
                out.print(cd.excluir(c));
            }

            if (crud.equals("Pesquisar")) {
                //Enviando o objeto para o banco
                List<Cargo> lc = cd.listarTodos();
                for (Cargo car : lc) {
                    out.print("<a href=../cargo.jsp?" + "codigo=" + car.getCodigo() + "&descricao=" + car.getDescricao() + "&salario=" + car.getSalario() + ">");
                    out.print(car.getCodigo() + " ");
                    out.print("</a>");
                    out.print(car.getDescricao() + " ");
                    out.print(car.getSalario() + " ");
                    out.print("<br>");
                }

            }
        %>
    </body>
</html>
