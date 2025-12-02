package classes.MENU;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.BO.ProfessorBO;
import classes.BO.TipoInstrumentoBO;
import classes.BO.UnicoBO;
import classes.DAO.EspecialidadeDAO;
import classes.DTO.Especialidade;
import classes.DTO.Professor;
import classes.DTO.TipoInstrumento;
import classes.DTO.Unico;

public class SubMenuGerenciadorAdicionarEspecialidade extends SubMenu {

	JComboBox<String> cbbListaProfessores = new JComboBox<>();
	JComboBox<String> cbbListaInstrumentos = new JComboBox<>();
	
	List<Professor> listaProfessores = new ArrayList<>();
	List<TipoInstrumento> listaInstrumentos = new ArrayList<>();
	
	public SubMenuGerenciadorAdicionarEspecialidade(Menu menu) {
		super(menu);
		
		JLabel lbl1 = new JLabel("Professor: ");
		JLabel lbl2 = new JLabel("Instrumento: ");
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(e -> {
			try {
				Especialidade esp = new Especialidade(listaProfessores.get(cbbListaProfessores.getSelectedIndex()), listaInstrumentos.get(cbbListaInstrumentos.getSelectedIndex()));
				EspecialidadeDAO espDAO = new EspecialidadeDAO();
				espDAO.inserir(esp);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso", "Inserido", JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception erro){
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		cbbListaProfessores.setMaximumSize((new Dimension(450, 40)));
		cbbListaInstrumentos.setMaximumSize((new Dimension(450, 40)));
		
		add(Box.createVerticalStrut(50));
		add(lbl1);
		add(cbbListaProfessores);
		add(Box.createVerticalStrut(30));
		add(lbl2);
		add(cbbListaInstrumentos);
		add(Box.createVerticalGlue());
		add(btnEnviar);
		add(Box.createVerticalStrut(30));
	}

	public void mostrar() {
		cbbListaProfessores.removeAllItems();
		cbbListaInstrumentos.removeAllItems();
		
		ProfessorBO professorBO = new ProfessorBO();
		listaProfessores = professorBO.pesquisarTodos();

		for (Professor p : listaProfessores) {
			cbbListaProfessores.addItem(p.getCpf());
		}
		
		TipoInstrumentoBO instrumentoBO = new TipoInstrumentoBO();
		listaInstrumentos = instrumentoBO.pesquisarTodos();

		for (TipoInstrumento p : listaInstrumentos) {
			cbbListaInstrumentos.addItem(p.getNome());
		}
	}
}
