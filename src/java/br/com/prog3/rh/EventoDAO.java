
package br.com.prog3.rh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class EventoDAO {
    
    //Metodo Para inserção de dados
    public String inserir(Evento evento) {
        String sql = "insert into evento";
        sql += " values (?,?,?,?) ";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, evento.getDia());
            pst.setInt(2, evento.getMes());
            pst.setInt(3, evento.getAno());
            pst.setString(4, evento.getDescricao());

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
    public String alterar(Evento evento) {
        String sql = "update evento set ";
        sql += " descricao=?";
        sql += " where dia=? and mes=? and ano=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, evento.getDescricao());
            pst.setInt(2, evento.getDia());
            pst.setInt(3, evento.getMes());
            pst.setInt(4, evento.getAno());

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
    public String excluir(Evento evento) {
        String sql = "delete from evento";
        sql += " where dia=? and mes=? and ano=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, evento.getDia());
            pst.setInt(2, evento.getMes());
            pst.setInt(3, evento.getAno());
            
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
    public List<Evento> listarTodos() {
        String sql = "select * from evento";
        Connection con = Conexao.abrirConexao();
        List<Evento> lista = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Evento e = new Evento();
                    e.setDia(rs.getInt(1));
                    e.setMes(rs.getInt(2));
                    e.setAno(rs.getInt(3));
                    e.setDescricao(rs.getString(4));

                    lista.add(e);
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
    
   //Metodo que retorna um objeto, de acordo com o nome
    public Evento buscaPorDescricao(String descricao) {
        String sql = "select * from evento";
        sql += " where descricao=?";
        Connection con = Conexao.abrirConexao();

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, descricao);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Evento e = new Evento();
                e.setDia(rs.getInt(1));
                e.setMes(rs.getInt(2));
                e.setAno(rs.getInt(3));
                e.setDescricao(rs.getString(4));
                Conexao.fecharConexao(con);
                return e;

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
