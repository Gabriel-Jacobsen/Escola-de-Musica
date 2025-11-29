package classes.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	final static String NOME_DO_BANCO = "escolamusica";
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO+
            		"?useTimezone=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}
