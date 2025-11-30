
package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Professor;

public class ProfessorDAO {

    final String NOMEDATABELA = "Professor";

    public boolean inserir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (CPF,SALARIO,DATACONTRATACAO) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getCpf());
            ps.setDouble(2, professor.getSalario());
            ps.setDate(3, professor.getDataContratacao());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET SALARIO = ?, DATACONTRATACAO = ? WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, professor.getSalario());
            ps.setDate(2, professor.getDataContratacao());
            ps.setString(3, professor.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Professor procurarPorCodigo(String cpf) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " JOIN UNICO ON UNICO.CPF = PROFESSOR.CPF WHERE Professor.cpf = \""+cpf+"\";"; //PESQUISAS COM FK PRECISAM DE JOIN
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Professor obj = new Professor(rs.getString(1), rs.getString(5), rs.getDate(8), rs.getDouble(2), rs.getDate(3));
                obj.setTelefone(rs.getString(3));
                obj.setEmail(rs.getString(4));
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

    public Professor procurarPorNome(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + "JOIN UNICO ON UNICO.CPF = PROFESSOR.CPF WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	Professor obj = new Professor(rs.getString(1), rs.getString(5), rs.getDate(8), rs.getDouble(2), rs.getDate(3));
                obj.setTelefone(rs.getString(3));
                obj.setEmail(rs.getString(4));
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

    public boolean existe(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getCpf());
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

    public List<Professor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " JOIN UNICO ON UNICO.CPF = PROFESSOR.CPF;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Professor> montarLista(ResultSet rs) {
        List<Professor> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
            	Professor obj = new Professor(rs.getString(1), rs.getString(5), rs.getDate(8), rs.getDouble(2), rs.getDate(3));
                obj.setTelefone(rs.getString(3));
                obj.setEmail(rs.getString(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}