package classes.BO;

import java.util.List;

import classes.DAO.ProfessorDAO;
import classes.DTO.Professor;

public class ProfessorBO {
    
    public boolean inserir(Professor professor){
        if (existe(professor) != true) {
            ProfessorDAO marcasDAO = new ProfessorDAO();
            return marcasDAO.inserir(professor);
        }
        return false;
    }
    public boolean alterar(Professor professor){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.alterar(professor);
    }
    public boolean excluir(Professor professor){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.excluir(professor);
    }
    public Professor procurarPorCodigo(Professor professor){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.procurarPorCodigo(professor);
    }
    public Professor procurarPorNome(Professor professor){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.procurarPorNome(professor);
    }
    public boolean existe(Professor professor){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.existe(professor);
    }
    public List<Professor> pesquisarTodos(){
        ProfessorDAO marcasDAO = new ProfessorDAO();
        return marcasDAO.pesquisarTodos();
    }
}
