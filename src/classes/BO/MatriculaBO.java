package classes.BO;

import java.util.List;

import classes.DAO.MatriculaDAO;
import classes.DAO.ProfessorDAO;
import classes.DTO.Aluno;
import classes.DTO.Cadastros;
import classes.DTO.Matricula;
import classes.DTO.Professor;
import classes.DTO.Unico;

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
    public List<Matricula> procurarPorAluno(Cadastros cadastro){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.procurarPorAluno(cadastro);
    }
    public List<Matricula> procurarPorProfessor(Cadastros cadastro){
    	MatriculaDAO marcasDAO = new MatriculaDAO();
        return marcasDAO.procurarPorProfessor(cadastro);
    }
    public Professor buscarProfessorComMenosMatriculas(int idTipo) {
        MatriculaDAO dao = new MatriculaDAO();
        ProfessorDAO profDAO = new ProfessorDAO();

        List<Professor> professores = profDAO.procurarPorTipo(idTipo);
        Professor menor = null;
        int menorQtd = Integer.MAX_VALUE;

        for (Professor p : professores) {
            int qtd = dao.contarPorProfessorETipo(p, idTipo);
            if (qtd < menorQtd) {
                menorQtd = qtd;
                menor = p;
            }
        }
        return menor;
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