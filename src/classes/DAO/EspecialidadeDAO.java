package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Especialidade;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;

public class EspecialidadeDAO {
    final String NOMEDATABELA = "Especialidade";

    public boolean inserir(Especialidade especialidade) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (PROFESSOR_CPF,idTipo) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getProf().getCpf());
            ps.setInt(2, especialidade.getInstrumento().getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean alterar(Especialidade especialidade) {
//        try {
//            Connection conn = Conexao.conectar();
//            String sql = "UPDATE " + NOMEDATABELA + " SET NOME = ?, EMAIL = ?, TELEFONE = ?, NASIMENTO = ? WHERE CPF = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, especialidade.getNome());
//            ps.setString(2, especialidade.getEmail());
//            ps.executeUpdate();
//            ps.close();
//            conn.close();
//            return true;
//        } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//        }
//    }

    public boolean excluir(Especialidade especialidade) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE PROFESSOR_CPF = ? and idTipo= ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getProf().getCpf());
            ps.setInt(1, especialidade.getInstrumento().getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
             return false;
        }
    }

    public Especialidade procurarPorCodigo(Especialidade especialidade) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA +
       		     " join professor on Professor_CPF = CPF join TipoInstrumento using (idTipo) join Unico using (CPF) WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getProf().getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Especialidade obj = new Especialidade(new Professor(rs.getString(1), rs.getString(6), rs.getDate(11), rs.getDouble(4)),
						  new TipoInstrumento(rs.getString(6), rs.getInt(2)));
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

    public Especialidade procurarPorNome(Especialidade especialidade) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA +
            		     " join professor on Professor_CPF = CPF join TipoInstrumento using (idTipo) join Unico using (CPF) WHERE UNICO.NOME = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getProf().getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Especialidade obj = new Especialidade(new Professor(rs.getString(1), rs.getString(6), rs.getDate(11), rs.getDouble(4)),
                									  new TipoInstrumento(rs.getString(6), rs.getInt(2)));
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

    public boolean existe(Especialidade especialidade) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ? AND IDTIPO = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getProf().getCpf());
            ps.setInt(2, especialidade.getInstrumento().getIdTipo());
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

    public List<Especialidade> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Especialidade> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Especialidade> montarLista(ResultSet rs) {
        List<Especialidade> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Especialidade obj = new Especialidade(new Professor(rs.getString(1), rs.getString(6), rs.getDate(11), rs.getDouble(4)),
						  new TipoInstrumento(rs.getString(6), rs.getInt(2)));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
