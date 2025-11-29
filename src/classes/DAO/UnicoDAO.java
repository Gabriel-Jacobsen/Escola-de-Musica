package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Unico;

public class UnicoDAO {
    final String NOMEDATABELA = "Unico";

    public boolean inserir(Unico unico) {  //colocar sempre o objeto que ta sendo feito
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (CPF,NOME,EMAIL,TELEFONE,NASIMENTO) VALUES (?,?,?,?,?);"; //seta o SQL q vai rodar no banco. Lembrar de sempre mudar os campos no SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getCpf()); //substitui os ? no SQL. o numero fala qual o ? que vai pegar em ordem que aparace no texto
            ps.setString(2, unico.getNome());
            ps.setString(3, unico.getEmail());
            ps.setString(4, unico.getTelefone());
            ps.setDate(5, unico.getNasc());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterar(Unico unico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET NOME = ?, EMAIL = ?, TELEFONE = ?,NASIMENTO = ? WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getNome());
            ps.setString(2, unico.getEmail());
            ps.setString(3, unico.getTelefone());
            ps.setDate(4, unico.getNasc());
            ps.setString(5, unico.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public boolean excluir(Unico unico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Unico procurarPorCodigo(Unico unico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Unico obj = new Unico(rs.getString(1), rs.getString(2), rs.getDate(5));
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
    public Unico procurarPorNome(Unico unico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Unico obj = new Unico(rs.getString(1), rs.getString(2), rs.getDate(5)); //cria um objeto igual ao registro que veio do SQL para poder retornar
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
    public boolean existe(Unico unico) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unico.getCpf());
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
    public List<Unico> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Unico> listObj = montarLista(rs);  //mesma coisa do "procura por nome"  mas retorna uma lista.
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Unico> montarLista(ResultSet rs) {
        List<Unico> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Unico obj = new Unico(rs.getString(1), rs.getString(2), rs.getDate(5));
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
