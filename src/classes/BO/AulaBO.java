package classes.BO;

import java.util.List;

import classes.DAO.AulaDAO;
import classes.DAO.MatriculaDAO;
import classes.DAO.ProfessorDAO;
import classes.DTO.Aula;
import classes.DTO.Matricula;
import classes.DTO.Professor;

public class AulaBO {

    public boolean inserir(Aula aula){
        if (!existe(aula)) {
            AulaDAO aulaDAO = new AulaDAO();
            return aulaDAO.inserir(aula);
        }
        return false;
    }

    public boolean alterar(Aula aula){
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.alterar(aula);
    }

    public boolean excluir(Aula aula){
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.excluir(aula);
    }

    public List<Aula> procurarPorCodigo(Matricula aula){
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.procurarPorCodigo(aula);
    }


//    public Aula procurarPorNome(Aula aula){
//        AulaDAO aulaDAO = new AulaDAO();
//        return aulaDAO.procurarPorNome(aula);
//    }

    public boolean existe(Aula aula){
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.existe(aula);
    }

    public List<Aula> pesquisarTodos(){
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.pesquisarTodos();
    }
}
