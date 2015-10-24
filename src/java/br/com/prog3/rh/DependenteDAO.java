package br.com.prog3.rh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DependenteDAO {

    //Metodo Para inserção de dados
    public String inserir(Dependente dependente) {
        String sql = "insert into dependente";
        sql += " values (?,?,?,?) ";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dependente.getNome());
            pst.setInt(2, dependente.getMatricula());
            pst.setInt(3, dependente.getIdade());
            pst.setString(4, dependente.getSexo());

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
    public String alterar(Dependente dependente) {
        String sql = "update dependente set ";
        sql += " nome=?, idade=?, sexo=?";
        sql += " where matricula=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, dependente.getNome());
            pst.setInt(2, dependente.getIdade());
            pst.setString(3, dependente.getSexo());
            pst.setInt(4, dependente.getMatricula());

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
    public String excluir(Dependente dependente) {
        String sql = "delete from dependente";
        sql += " where matricula=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, dependente.getMatricula());
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
    public List<Dependente> listarTodos() {
        String sql = "select * from dependente";
        Connection con = Conexao.abrirConexao();
        List<Dependente> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Dependente d = new Dependente();
                    d.setNome(rs.getString(1));
                    d.setMatricula(rs.getInt(2));
                    d.setIdade(rs.getInt(3));
                    d.setSexo(rs.getString(4));

                    lista.add(d);
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

    //Metodo que retorna um objeto, de acordo com a matricula
    public Dependente buscaPorMatricula(int Mat) {
        String sql = "select * from dependente";
        sql += " where matricula=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Mat);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Dependente d = new Dependente();
                d.setNome(rs.getString(1));
                d.setMatricula(rs.getInt(2));
                d.setIdade(rs.getInt(3));
                d.setSexo(rs.getString(4));
                Conexao.fecharConexao(con);
                return d;

            } else {
                Conexao.fecharConexao(con);
                return null;
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return null;
        }

    }

    //Metodo que retorna um objeto, de acordo com o nome
    public Dependente buscaPorNome(String nome) {
        String sql = "select * from dependente";
        sql += " where nome=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Dependente d = new Dependente();
                d.setNome(rs.getString(1));
                d.setMatricula(rs.getInt(2));
                d.setIdade(rs.getInt(3));
                d.setSexo(rs.getString(4));
                Conexao.fecharConexao(con);
                return d;

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
