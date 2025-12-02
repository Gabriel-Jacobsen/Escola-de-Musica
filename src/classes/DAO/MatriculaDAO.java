package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Aluno;
import classes.DTO.Cadastros;
import classes.DTO.Matricula;
import classes.DTO.Professor;
import classes.DTO.Unico;

public class MatriculaDAO {
	
	 final String NOMEDATABELA = "Matricula";
	    
	    public boolean inserir(Matricula matricula) { 
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (ALUNO_CPF,PROFESSOR_CPF,IDTIPO,SALA_PREFERENCIAL,HORARIO,HORARIOFIM) VALUES (?,?,?,?,?,?);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, matricula.getAluno().getCpf()); 
	            ps.setString(2, matricula.getProfessor().getCpf());
	            ps.setInt(3, matricula.getIdTipo());
	            if (matricula.getSalaPreferencial() == 0) {
	                ps.setNull(4, java.sql.Types.INTEGER);
	            } else {
	                ps.setInt(4, matricula.getSalaPreferencial());
	            }
	            ps.setDate(5, matricula.getHorario());
	            ps.setDate(6, matricula.getHorarioFim());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterar(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET SALA_PREFERENCIAL= ?, HORARIO = ?, HORARIO_FIM = ? WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, matricula.getSalaPreferencial());
	            ps.setDate(2, matricula.getHorario());
	            ps.setDate(3, matricula.getHorarioFim());
	            ps.setString(4, matricula.getAluno().getCpf()); 
	            ps.setString(5, matricula.getProfessor().getCpf());
	            ps.setInt(6, matricula.getIdTipo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, matricula.getAluno().getCpf()); 
	            ps.setString(2, matricula.getProfessor().getCpf());
	            ps.setInt(3, matricula.getIdTipo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public List<Matricula> procurarPorAluno(Cadastros cadastro) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + 
	            		" join unico as alu on aluno_cpf = alu.cpf join unico as prof"+
	            		" on professor_cpf = prof.cpf join professor on professor_cpf = professor.cpf WHERE ALUNO_CPF = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, cadastro.getLogin()); 
	            ResultSet rs = ps.executeQuery();
	            List<Matricula> listObj = montarLista(rs);  
	            return listObj;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return null;
	        }
	    }
	    public List<Matricula> procurarPorProfessor(Cadastros cadastro) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + 
	            		" join unico as alu on aluno_cpf = alu.cpf join unico as prof"+
	            		" on professor_cpf = prof.cpf join professor on professor_cpf = professor.cpf WHERE Professor_CPF = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, cadastro.getLogin()); 
	            ResultSet rs = ps.executeQuery();
	            List<Matricula> listObj = montarLista(rs);  
	            return listObj;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return null;
	        }
	    }
	    
	    public int contarPorProfessorETipo(Professor p, int idTipo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT COUNT(*) FROM " + NOMEDATABELA +"  WHERE professor_cpf = ? AND idtipo = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, p.getCpf());
	            ps.setInt(2, idTipo);
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            return rs.getInt(1);
	        } catch (Exception e) {
	            return Integer.MAX_VALUE;
	        }
	    }
//	    public Matricula procurarPorNome(Matricula matricula) {
//	        try {
//	            Connection conn = Conexao.conectar();
//	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
//	            PreparedStatement ps = conn.prepareStatement(sql);
//	            ps.setString(1, unico.getNome());
//	            ResultSet rs = ps.executeQuery();
//	            if (rs.next()) {
//	                Unico obj = new Unico(rs.getString(1), rs.getString(2), rs.getDate(5));
//	                obj.setTelefone(rs.getString(3));
//	                obj.setEmail(rs.getString(4));
//	                ps.close();
//	                rs.close();
//	                conn.close();
//	                return obj;
//	            } else {
//	                ps.close();
//	                rs.close();
//	                conn.close();
//	                return null;
//	            }
//	        } catch (Exception e) {
//	        	 e.printStackTrace();
//	             return null;
//	        }
//	    }
	    public boolean existe(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND IDTIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, matricula.getAluno().getCpf()); 
	            ps.setString(2, matricula.getProfessor().getCpf());
	            ps.setInt(3, matricula.getIdTipo());
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
	    public List<Matricula> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + 
	            		" join unico as alu on aluno_cpf = alu.cpf join unico as prof"+
	            		" on professor_cpf = prof.cpf join professor on professor_cpf = professor.cpf ;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Matricula> listObj = montarLista(rs);  
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Matricula> montarLista(ResultSet rs) {
	        List<Matricula> listObj = new ArrayList<Matricula>();
	        try {
	            while (rs.next()) {
	            	Matricula obj = new Matricula(new Aluno(rs.getString(1), rs.getString(8), rs.getDate(11)),
	            			new Professor(rs.getString(2), rs.getString(13), rs.getDate(16), rs.getDouble(18),rs.getDate(19)),
	            			rs.getInt(3), rs.getDate(4));
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