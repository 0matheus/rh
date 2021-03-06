package br.com.prog3.rh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CargoDAO {

    //Metodo para inserção de dados
    public String inserir(Cargo cargo) {
        String sql = "insert into cargo";
        sql += " values (?,?,?)";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cargo.getCodigo());
            pst.setString(2, cargo.getDescricao());
            pst.setDouble(3, cargo.getSalario());

            if ((pst.executeUpdate() > 0)) {
                Conexao.fecharConexao(con);
                return "Registro inserido com sucesso.";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao inserir registro";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }

    }

    //Metodo para alteração de dados
    public String alterar(Cargo cargo) {
        String sql = "update cargo set ";
        sql += " descricao=?, salario=?";
        sql += " where codigo=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cargo.getDescricao());
            pst.setDouble(2, cargo.getSalario());
            pst.setInt(3, cargo.getCodigo());

            if ((pst.executeUpdate() > 0)) {
                Conexao.fecharConexao(con);
                return "Registro alterado com sucesso.";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao alterar registro";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }

    //Metodo para excluir dados
    public String excluir(Cargo cargo) {
        String sql = "delete from cargo";
        sql += " where codigo=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, cargo.getCodigo());
            if (pst.executeUpdate() > 0) {
                Conexao.fecharConexao(con);
                return "Registro excluido com sucesso.";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao excluir registro.";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }

    //Metodo para lista todos os cargos
    public List<Cargo> listarTodos() {
        String sql = "select * from cargo order by descricao";
        Connection con = Conexao.abrirConexao();
        List<Cargo> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Cargo c = new Cargo();
                    c.setCodigo(rs.getInt(1));
                    c.setDescricao(rs.getString(2));
                    c.setSalario(rs.getDouble(3));
                    lista.add(c);
                }

                Conexao.fecharConexao(con);
                return lista;

            } else {
                Conexao.fecharConexao(con);
                return null;
            }
        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return null;
        }
    }

    //Metodo que retorna um objeto, de acordo com o código
    public Cargo buscaPorCodigo(int Cod) {
        String sql = "select * from cargo";
        sql += " where codigo=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Cod);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Cargo c = new Cargo();
                c.setCodigo(rs.getInt(1));
                c.setDescricao(rs.getString(2));
                c.setSalario(rs.getDouble(3));
                Conexao.fecharConexao(con);
                return c;

            } else {
                Conexao.fecharConexao(con);
                return null;
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return null;
        }

    }

    //Metodo que retorna um objeto, de acordo com o código
    public Cargo buscaPorDescricao(String descri) {
        String sql = "select * from cargo";
        sql += " where descricao=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, descri);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Cargo c = new Cargo();
                c.setCodigo(rs.getInt(1));
                c.setDescricao(rs.getString(2));
                c.setSalario(rs.getDouble(3));
                Conexao.fecharConexao(con);
                return c;

            } else {
                Conexao.fecharConexao(con);
                return null;
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return null;
        }

    }

}
