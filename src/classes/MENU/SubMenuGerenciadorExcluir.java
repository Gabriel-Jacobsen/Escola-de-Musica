package classes.MENU;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import classes.BO.UnicoBO;
import classes.DTO.Unico;


public class SubMenuGerenciadorExcluir extends SubMenu {

	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> lista = new JList<>(model);
	
	List<Unico> listaUnico = new ArrayList<>();


	public SubMenuGerenciadorExcluir(Menu menu) {
		super(menu);
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(e -> {
			UnicoBO unicoBO = new UnicoBO();
			unicoBO.excluir(listaUnico.get(lista.getSelectedIndex()));
			mostrar();
		});
		
		add(new JScrollPane(lista));
		add(btnExcluir);
	}
	
	public void mostrar() {
		model.clear(); // limpa lista
		
		UnicoBO unicoBO = new UnicoBO();
		listaUnico = unicoBO.pesquisarTodos();

		for (Unico p : listaUnico) {
			model.addElement(p.getNome() + " - " + p.getCpf());
		}
	}

}
