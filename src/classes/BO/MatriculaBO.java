package classes.BO;

import java.util.List;

import classes.DAO.MatriculaDAO;
import classes.DTO.Matricula;

public class MatriculaBO {

    public boolean inserir(Matricula matricula){
        if (existe(matricula) != true) {
        	MatriculaDAO marcasDAO = new MatriculaDAO();
            return marcasDAO.inserir(matricula);
        }
        return false;
    }
    public boolean alterar(Matricula matricula){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.alterar(matricula);
    }
    public boolean excluir(Matricula matricula){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.excluir(matricula);
    }
    public Matricula procurarPorCodigo(Matricula matricula){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.procurarPorCodigo(matricula);
    }
//    public Matricula procurarPorNome(Matricula matricula){
//    	MatriculaDAO marcasDAO = new MatriculaDAO();
//        return marcasDAO.procurarPorNome(matricula);
//    }
    public boolean existe(Matricula matricula){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.existe(matricula);
    }
    public List<Matricula> pesquisarTodos(){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.pesquisarTodos();
    }
}