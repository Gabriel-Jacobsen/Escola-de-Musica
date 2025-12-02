package classes.MENU;

import java.awt.Dimension;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.AlunoBO;
import classes.BO.MatriculaBO;
import classes.BO.TipoInstrumentoBO;
import classes.DTO.Aluno;
import classes.DTO.Cadastros;
import classes.DTO.Matricula;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;

public class SubMenuCriaMatricula extends SubMenu {
	
	private Cadastros cadastro;
	
    JComboBox<String> cbbTipo = new JComboBox<>();

    List<TipoInstrumento> listaTipos = new ArrayList<>();

    JLabel lblHorario = new JLabel("Horario:");

    JTextField txtHorario = new JTextField();

    public SubMenuCriaMatricula(Menu menu, Cadastros cadastro) {
        super(menu);
        this.cadastro = cadastro;

        txtHorario.setMaximumSize(new Dimension(200, 30));

        cbbTipo.setMaximumSize(new Dimension(400, 40));

        JButton btnEnviar = new JButton("Cadastrar");
        btnEnviar.addActionListener(e -> cadastrarMatricula());

        add(new JLabel("Tipo de Instrumento / Matéria:"));
        add(cbbTipo);
        add(Box.createVerticalStrut(20));


        add(lblHorario);
        add(txtHorario);
        add(Box.createVerticalStrut(20));


        add(btnEnviar);
    }

    public void mostrar() {
        carregarTipos();
    }

    private void carregarTipos() {
        cbbTipo.removeAllItems();
        listaTipos.clear();

        TipoInstrumentoBO tipoBO = new TipoInstrumentoBO();
        listaTipos = tipoBO.pesquisarTodos();

        for (TipoInstrumento t : listaTipos) {
            cbbTipo.addItem(t.getNome());
        }
    }

    private void cadastrarMatricula() {
        try {
            Aluno aluno = new Aluno(cadastro.getLogin(),"",new Date(0000,00,00));
            aluno = new AlunoBO().procurarPorCodigo(aluno);
            TipoInstrumento tipo = listaTipos.get(cbbTipo.getSelectedIndex());

            MatriculaBO matriculaBO = new MatriculaBO();
            Professor professorEscolhido =
                    matriculaBO.buscarProfessorComMenosMatriculas(tipo.getIdTipo());

            if (professorEscolhido == null) {
                JOptionPane.showMessageDialog(null,
                        "Nenhum professor disponível para essa matéria.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // montar horários
            Date horario = Date.valueOf(LocalDate.parse(txtHorario.getText()));

            Matricula mat = new Matricula(aluno, professorEscolhido,
                    tipo.getIdTipo(), horario);


            // salvar
            if (matriculaBO.inserir(mat)) {
                JOptionPane.showMessageDialog(null,
                        "Matrícula cadastrada com sucesso!\nProfessor: "
                                + professorEscolhido.getNome());
            } else {
                JOptionPane.showMessageDialog(null,
                        "Erro ao inserir matrícula.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
