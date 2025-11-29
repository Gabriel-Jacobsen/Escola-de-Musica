package classes.BO;

import java.util.List;

import classes.DAO.CadastrosDAO;
import classes.DTO.Cadastros;


public class CadastrosBO {

	//essa classe serve só de comunicação entre a DAO e o resto do programa

    public boolean inserir(Cadastros cadastros){
        if (!existe(cadastros)) {
        	CadastrosDAO marcasDAO = new CadastrosDAO();
            return marcasDAO.inserir(cadastros);
        }
        return false;
    }

    public boolean alterar(Cadastros cadastros){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.alterar(cadastros);
    }

    public boolean excluir(Cadastros cadastros){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.excluir(cadastros);
    }

    public Cadastros procurarPorCodigo(Cadastros cadastros){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.procurarPorCodigo(cadastros);
    }

    public Cadastros procurarPorNome(Cadastros cadastros){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.procurarPorNome(cadastros);
    }

    public boolean existe(Cadastros cadastros){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.existe(cadastros);
    }

    public List<Cadastros> pesquisarTodos(){
    	CadastrosDAO marcasDAO = new CadastrosDAO();
        return marcasDAO.pesquisarTodos();
    }
}
