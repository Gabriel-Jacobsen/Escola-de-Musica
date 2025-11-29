package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.TipoInstrumento;

public class TipoInstrumentoDAO {
    final String NOMEDATABELA = "TipoInstrumento";

    public boolean inserir(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idTipo,NOME,Descricao) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoInstr.getIdTipo());
            ps.setString(2, tipoInstr.getNome());
            ps.setString(3, tipoInstr.getDescricao());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET NOME = ?, Descricao = ? WHERE idTipo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoInstr.getNome());
            ps.setString(2, tipoInstr.getDescricao());
            ps.setInt(3, tipoInstr.getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idTipo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoInstr.getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public TipoInstrumento procurarPorCodigo(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idTipo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoInstr.getIdTipo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipoInstrumento obj = new TipoInstrumento(rs.getString(2), rs.getInt(1));
                obj.setDescricao(rs.getString(3));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoInstrumento procurarPorNome(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoInstr.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipoInstrumento obj = new TipoInstrumento(rs.getString(2), rs.getInt(1));
                obj.setDescricao(rs.getString(3));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(TipoInstrumento tipoInstr) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idTipo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoInstr.getIdTipo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
        return false;
    }

    public List<TipoInstrumento> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TipoInstrumento> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TipoInstrumento> montarLista(ResultSet rs) {
        List<TipoInstrumento> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                TipoInstrumento obj = new TipoInstrumento(rs.getString(2), rs.getInt(1));
                obj.setDescricao(rs.getString(3));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
