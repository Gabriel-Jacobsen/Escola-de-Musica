package classes.BO;

import java.util.List;
import classes.DAO.AlunoDAO;
import classes.DTO.Aluno;

public class AlunoBO {
    public boolean inserir(Aluno aluno){
        if (existe(aluno) != true) {
        	AlunoDAO marcasDAO = new AlunoDAO();
            return marcasDAO.inserir(aluno);
        }
        return false;
    }
//    public boolean alterar(Aluno aluno){
//    	AlunoDAO marcasDAO = new AlunoDAO();
//        return marcasDAO.alterar(aluno);
//    }
    public boolean excluir(Aluno aluno){
    	AlunoDAO marcasDAO = new AlunoDAO();
        return marcasDAO.excluir(aluno);
    }
    public Aluno procurarPorCodigo(Aluno aluno){
    	AlunoDAO marcasDAO = new AlunoDAO();
        return marcasDAO.procurarPorCodigo(aluno);
    }
    public Aluno procurarPorNome(Aluno aluno){
    	AlunoDAO marcasDAO = new AlunoDAO();
        return marcasDAO.procurarPorNome(aluno);
    }
    public boolean existe(Aluno aluno){
    	AlunoDAO marcasDAO = new AlunoDAO();
        return marcasDAO.existe(aluno);
    }
    public List<Aluno> pesquisarTodos(){
    	AlunoDAO marcasDAO = new AlunoDAO();
        return marcasDAO.pesquisarTodos();
    }
}