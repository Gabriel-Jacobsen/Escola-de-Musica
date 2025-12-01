package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Aluno;
import classes.DTO.Aula;
import classes.DTO.Professor;

public class AulaDAO {
	
	 final String NOMEDATABELA = "Matricula";
	    
    public boolean inserir(Aula aula) { 
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (ALUNO_CPF,PROFESSOR_CPF,ID_TIPO,SALA_PREFERENCIAL,HORARIO,HORARIO_FIM) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aula.getAluno().getCpf()); 
            ps.setString(2, aula.getProfessor().getCpf());
            ps.setInt(3, aula.getIdTipo());
            ps.setInt(4, aula.getSalaPreferencial());
            ps.setDate(5, aula.getHorario());
            ps.setDate(6, aula.getHorarioFim());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET SALA_PREFERENCIAL= ?, HORARIO = ?, HORARIO_FIM = ? WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getSalaPreferencial());
            ps.setDate(2, aula.getHorario());
            ps.setDate(3, aula.getHorarioFim());
            ps.setString(4, aula.getAluno().getCpf()); 
            ps.setString(5, aula.getProfessor().getCpf());
            ps.setInt(6, aula.getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean excluir(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aula.getAluno().getCpf()); 
            ps.setString(2, aula.getProfessor().getCpf());
            ps.setInt(3, aula.getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public Aula procurarPorCodigo(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + 
            		" join unico as alu on aluno_cpf = alu.cpf join unico as prof"+
            		" on professor_cpf = prof.cpf join professor on professor_cpf = professor.cpf WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aula.getAluno().getCpf());
            ps.setString(2, aula.getProfessor().getCpf());
            ps.setInt(3, aula.getIdTipo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Aula obj = new Aula(
            			new Aluno(rs.getString(1), rs.getString(11), rs.getDate(14)),
            			new Professor(rs.getString(2), rs.getString(16), rs.getDate(19), rs.getDouble(21),rs.getDate(22)),
            			rs.getInt(3), 
            			rs.getDate(4), rs.getDate(5)
            	);
                obj.setSalaPreferencial(rs.getInt(6));
                obj.setHorarioFim(rs.getDate(5));
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

    public boolean existe(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aula.getAluno().getCpf());
            ps.setString(2, aula.getProfessor().getCpf());
            ps.setInt(3, aula.getIdTipo());
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
    
    public List<Aula> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + 
            		" join unico as alu on aluno_cpf = alu.cpf join unico as prof"+
            		" on professor_cpf = prof.cpf join professor on professor_cpf = professor.cpf ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aula> listObj = montarLista(rs);  
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Aula> montarLista(ResultSet rs) {
        List<Aula> listObj = new ArrayList<Aula>();
        try {
            while (rs.next()) {
            	Aula obj = new Aula(
            			new Aluno(rs.getString(1), rs.getString(11), rs.getDate(14)),
            			new Professor(rs.getString(2), rs.getString(16), rs.getDate(19), rs.getDouble(21),rs.getDate(22)),
            			rs.getInt(3), 
            			rs.getDate(4), rs.getDate(5)
            	);
                obj.setSalaPreferencial(rs.getInt(6));
                obj.setHorarioFim(rs.getDate(5));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
