package br.com.prog3.rh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioDAO {

    public String inserir(Funcionario funcionario) {
        String sql = " insert into funcionario";
        sql += " values(?,?,?)";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, funcionario.getMatricula());
            pst.setString(2, funcionario.getNome());
            pst.setInt(3, funcionario.getCargo());

            if (pst.executeUpdate() > 0) {
                Conexao.fecharConexao(con);
                return "Registro inserido com sucesso";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao tentar inserir registro";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }

    //Metodo para alteracao de dados
    public String alterar(Funcionario funcionario) {
        String sql = "update funcionario set";
        sql += " nome=?, cargo=?";
        sql += " where matricula = ?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setInt(2, funcionario.getCargo());
            pst.setInt(3, funcionario.getMatricula());

            if (pst.executeUpdate() > 0) {
                Conexao.fecharConexao(con);
                return "Registro alterado com sucesso.";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao alterar o registro.";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }

    }

    //Metodo para exclusao de um registro
    public String excluir(Funcionario funcionario) {
        String sql = "delete from funcionario";
        sql += " where matricula=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, funcionario.getMatricula());

            if (pst.executeUpdate() > 0) {
                Conexao.fecharConexao(con);
                return "Registro excluido com sucesso";
            } else {
                Conexao.fecharConexao(con);
                return "Erro ao excluir o registro.";
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return e.getMessage();
        }
    }

    //Metodo para Listar todos os registros
    public List<Funcionario> listarTodos() {
        String sql = "select * from funcionario";
        Connection con = Conexao.abrirConexao();
        List<Funcionario> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setMatricula(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setCargo(rs.getInt(3));
                    lista.add(f);
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

    //Metodo que retorna um objeto de acordo com a matricula
    public Funcionario buscaPorMatricula(int Mat) {
        String sql = "select * from funcionario";
        sql += " where matricula = ?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Mat);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Funcionario func = new Funcionario();
                func.setMatricula(rs.getInt(1));
                func.setNome(rs.getString(2));
                func.setCargo(rs.getInt(3));
                return func;

            } else {
                Conexao.fecharConexao(con);
                return null;
            }

        } catch (SQLException e) {
            Conexao.fecharConexao(con);
            return null;
        }

    }

    public Funcionario buscaPeloNome(String Nome) {
        String sql = "select * from funcionario";
        sql += " where nome=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(2, Nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Funcionario func = new Funcionario();
                func.setMatricula(rs.getInt(1));
                func.setNome(rs.getString(2));
                func.setCargo(rs.getInt(3));
                return func;
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
