package classes.BO;

import java.util.List;

import classes.DAO.TipoInstrumentoDAO;
import classes.DTO.TipoInstrumento;

public class TipoInstrumentoBO {
    
    //essa classe serve só de comunicação entre a DAO e o resto do programa
    
    public boolean inserir(TipoInstrumento tipoInstr){
        if (existe(tipoInstr) != true) {
            TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
            return marcasDAO.inserir(tipoInstr);
        }
        return false;
    }

    public boolean alterar(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.alterar(tipoInstr);
    }

    public boolean excluir(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.excluir(tipoInstr);
    }

    public TipoInstrumento procurarPorCodigo(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.procurarPorCodigo(tipoInstr);
    }

    public TipoInstrumento procurarPorNome(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.procurarPorNome(tipoInstr);
    }

    public boolean existe(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.existe(tipoInstr);
    }

    public List<TipoInstrumento> pesquisarTodos(){
        TipoInstrumentoDAO marcasDAO = new TipoInstrumentoDAO();
        return marcasDAO.pesquisarTodos();
    }
}
