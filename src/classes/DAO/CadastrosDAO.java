package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Cadastros;
import classes.DTO.Unico;

public class CadastrosDAO {

    final String NOMEDATABELA = "Cadastros";

    public boolean inserir(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA +
                         " (CPF,senha, idTipo) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cadastros.getLogin());
            ps.setString(2, cadastros.getSenha());
            ps.setInt(3, cadastros.getIdTipo());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA +
                         " SET senha = ?, idTipo = ? WHERE CPF = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cadastros.getSenha());
            ps.setInt(2, cadastros.getIdTipo());
            ps.setString(3, cadastros.getLogin());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE CPF = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cadastros.getLogin());

            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cadastros procurarPorCodigo(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " join Unico using (cpf) WHERE CPF = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cadastros.getLogin());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cadastros obj = new Cadastros(new Unico(rs.getString(1),rs.getString(4), rs.getDate(7)), rs.getString(3));
                obj.setIdTipo(rs.getInt(2));
                obj.getUnico().setEmail(rs.getString(6));
                obj.getUnico().setTelefone(rs.getString(5));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            }

            ps.close();
            rs.close();
            conn.close();
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cadastros procurarPorNome(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " join Unico using (cpf)  WHERE NOME = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cadastros.getLogin());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cadastros obj = new Cadastros(new Unico(rs.getString(1),rs.getString(4), rs.getDate(7)), rs.getString(3));
                obj.setIdTipo(rs.getInt(2));
                obj.getUnico().setEmail(rs.getString(6));
                obj.getUnico().setTelefone(rs.getString(5));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            }

            ps.close();
            rs.close();
            conn.close();
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(Cadastros cadastros) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE CPF = ? AND SENHA = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cadastros.getLogin());
            ps.setString(2, cadastros.getSenha());
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

    public List<Cadastros> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " join Unico using (cpf);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<Cadastros> listObj = montarLista(rs);
            return listObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cadastros> montarLista(ResultSet rs) {
        List<Cadastros> listObj = new ArrayList<>();

        try {
            while (rs.next()){
                Cadastros obj = new Cadastros(new Unico(rs.getString(1),rs.getString(4), rs.getDate(7)), rs.getString(3));
                obj.setIdTipo(rs.getInt(2));
                obj.getUnico().setEmail(rs.getString(6));
                obj.getUnico().setTelefone(rs.getString(5));

                listObj.add(obj);
            }

            return listObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
