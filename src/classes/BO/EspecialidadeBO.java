package classes.BO;

import java.util.List;

import classes.DAO.EspecialidadeDAO;
import classes.DTO.Especialidade;

public class EspecialidadeBO {

    //essa classe serve só de comunicação entre a DAO e o resto do programa

    public boolean inserir(Especialidade especialidade){
        if (!existe(especialidade)) {
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            return especialidadeDAO.inserir(especialidade);
        }
        return false;
    }

//    public boolean alterar(Especialidade especialidade){
//        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
//        return especialidadeDAO.alterar(especialidade);
//    }

    public boolean excluir(Especialidade especialidade){
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        return especialidadeDAO.excluir(especialidade);
    }

    public Especialidade procurarPorCodigo(Especialidade especialidade){
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        return especialidadeDAO.procurarPorCodigo(especialidade);
    }

    public Especialidade procurarPorNome(Especialidade especialidade){
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        return especialidadeDAO.procurarPorNome(especialidade);
    }

    public boolean existe(Especialidade especialidade){
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        return especialidadeDAO.existe(especialidade);
    }

    public List<Especialidade> pesquisarTodos(){
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        return especialidadeDAO.pesquisarTodos();
    }
}
