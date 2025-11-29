package classes.BO;

import java.util.List;

import classes.DAO.UnicoDAO;
import classes.DTO.Unico;

public class UnicoBO {

	//essa classe serve só de comunicação entre a DAO e o resto do programa

    public boolean inserir(Unico unico){
        if (!existe(unico)) {
            UnicoDAO unicoDAO = new UnicoDAO();
            return unicoDAO.inserir(unico);
        }
        return false;
    }
    public boolean alterar(Unico unico){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.alterar(unico);
    }
    public boolean excluir(Unico unico){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.excluir(unico);
    }
    public Unico procurarPorCodigo(Unico unico){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.procurarPorCodigo(unico);
    }
    public Unico procurarPorNome(Unico unico){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.procurarPorNome(unico);
    }
    public boolean existe(Unico unico){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.existe(unico);
    }
    public List<Unico> pesquisarTodos(){
    	UnicoDAO unicoDAO = new UnicoDAO();
        return unicoDAO.pesquisarTodos();
    }
}
