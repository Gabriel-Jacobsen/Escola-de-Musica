package classes.BO;

import java.util.List;

import classes.DAO.ProfessorDAO;
import classes.DTO.Professor;

public class ProfessorBO {

    public boolean inserir(Professor professor){
        if (!existe(professor)) {
            ProfessorDAO profDAO = new ProfessorDAO();
            return profDAO.inserir(professor);
        }
        return false;
    }
    public boolean alterar(Professor professor){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.alterar(professor);
    }
    public boolean excluir(Professor professor){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.excluir(professor);
    }
    public Professor procurarPorCodigo(String cpf){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.procurarPorCodigo(cpf);
    }
    public Professor procurarPorNome(Professor professor){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.procurarPorNome(professor);
    }
    public boolean existe(Professor professor){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.existe(professor);
    }
    public List<Professor> pesquisarTodos(){
        ProfessorDAO profDAO = new ProfessorDAO();
        return profDAO.pesquisarTodos();
    }
}
