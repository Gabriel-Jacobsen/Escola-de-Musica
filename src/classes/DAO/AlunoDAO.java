package classes.DAO;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import classes.Conexao.Conexao;
	import classes.DTO.Aluno;

	public class AlunoDAO {
	    final String NOMEDATABELA = "Aluno";
	    
	    public boolean inserir(Aluno aluno) {  //colocar sempre o objeto que ta sendo feito
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (CPF) VALUES (?);"; //seta o SQL q vai rodar no banco. Lembrar de sempre mudar os campos no SQL
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, aluno.getCpf()); //substitui os ? no SQL. o numero fala qual o ? que vai pegar em ordem que aparace no texto
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
//	    public boolean alterar(Aluno aluno) {
//	        try {
//	            Connection conn = Conexao.conectar();
//	            String sql = "UPDATE " + NOMEDATABELA + "SET NOME = ?, EMAIL = ?, TELEFONE = ?,NASIMENTO = ? WHERE CPF = ?;";
//	            PreparedStatement ps = conn.prepareStatement(sql);
//	            ps.setString(1, aluno.getCpf());
//	            ps.setString(2, unico.aluno.getEmail());
//	            ps.setString(3, unico.getTelefone());
//	            ps.setDate(4, unico.getNasc());
//	            ps.setString(5, unico.getCpf());
//	            ps.executeUpdate();
//	            ps.close();
//	            conn.close();
//	            return true;
//	        } catch (Exception e) {
//	        	 e.printStackTrace();
//	             return false;
//	        }
//	    }
	    public boolean excluir(Aluno aluno) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, aluno.getCpf());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Aluno procurarPorCodigo(Aluno aluno ) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " join unico (cpf) WHERE CPF = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, aluno.getCpf());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Aluno obj = new Aluno(rs.getString(1), rs.getString(2), rs.getDate(5));
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
	    public Aluno procurarPorNome(Aluno aluno) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " join unico using (cpf) WHERE nome = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, aluno.getNome());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Aluno obj = new Aluno(rs.getString(1), rs.getString(2), rs.getDate(5)); //cria um objeto igual ao registro que veio do SQL para poder retornar
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
	    public boolean existe(Aluno aluno) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, aluno.getCpf());
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
	    public List<Aluno> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " join unico using(cpf);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Aluno> listObj = montarLista(rs);  //mesma coisa do "procura por nome"  mas retorna uma lista. 
	            return listObj;			
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Aluno> montarLista(ResultSet rs) {
	        List<Aluno> listObj = new ArrayList<Aluno>();
	        try {
	            while (rs.next()) {
	            	Aluno obj = new Aluno(rs.getString(1), rs.getString(2), rs.getDate(5));
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


