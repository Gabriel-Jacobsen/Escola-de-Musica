package classes.BO;

import java.util.List;

import classes.DAO.TipoInstrumentoDAO;
import classes.DTO.TipoInstrumento;

public class TipoInstrumentoBO {

    //essa classe serve só de comunicação entre a DAO e o resto do programa

    public boolean inserir(TipoInstrumento tipoInstr){
        if (!existe(tipoInstr)) {
            TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
            return tiposDAO.inserir(tipoInstr);
        }
        return false;
    }

    public boolean alterar(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.alterar(tipoInstr);
    }

    public boolean excluir(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.excluir(tipoInstr);
    }

    public TipoInstrumento procurarPorCodigo(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.procurarPorCodigo(tipoInstr);
    }

    public TipoInstrumento procurarPorNome(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.procurarPorNome(tipoInstr);
    }

    public boolean existe(TipoInstrumento tipoInstr){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.existe(tipoInstr);
    }

    public List<TipoInstrumento> pesquisarTodos(){
        TipoInstrumentoDAO tiposDAO = new TipoInstrumentoDAO();
        return tiposDAO.pesquisarTodos();
    }
}
