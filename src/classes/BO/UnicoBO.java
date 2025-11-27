package classes.BO;

import java.util.List;

import classes.DAO.UnicoDAO;
import classes.DTO.Unico;

public class UnicoBO {
	
	//essa classe serve só de comunicação entre a DAO e o resto do programa
	
    public boolean inserir(Unico unico){
        if (existe(unico) != true) {
            UnicoDAO marcasDAO = new UnicoDAO();
            return marcasDAO.inserir(unico);
        }
        return false;
    }
    public boolean alterar(Unico unico){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.alterar(unico);
    }
    public boolean excluir(Unico unico){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.excluir(unico);
    }
    public Unico procurarPorCodigo(Unico unico){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.procurarPorCodigo(unico);
    }
    public Unico procurarPorNome(Unico unico){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.procurarPorNome(unico);
    }
    public boolean existe(Unico unico){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.existe(unico);
    }
    public List<Unico> pesquisarTodos(){
    	UnicoDAO marcasDAO = new UnicoDAO();
        return marcasDAO.pesquisarTodos();
    }
}
