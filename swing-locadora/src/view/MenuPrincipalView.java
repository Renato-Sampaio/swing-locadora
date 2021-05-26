package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe utilizando o menu, para exibir paginas
 * 
 * @author Renato Duarte Sampaio
 * @since 05/03/2021
 * @version 1.0
 */
public class MenuPrincipalView {
	// declarando os atributos da tela
	private JFrame janela;
	// declarando o componente para a barra de menu
	private JMenuBar barraMenu;

	// declarando os menus de menu1, menu2 e menu3
	private JMenu menuCadastro;
	private JMenu menuConsulta;
	private JMenu menuSair;

	// declarando os itens de menu
	private JMenuItem itemCadastrarFilme;
	private JMenuItem itemCadastrarLocacao;
	private JMenuItem itemCadastrarVendedor;
	private JMenuItem itemCadastrarCliente;
	private JMenuItem itemConsultarFilme;
	private JMenuItem itemConsultarVendedor;
	private JMenuItem itemConsultarCliente;
	private JMenuItem itemSair;

	/*
	 * método para criar a tela
	 */
	public void iniciaGui() {
		/*
		 * criando as instancias dos objetos
		 */
		janela = new JFrame();
		barraMenu = new JMenuBar();
		menuCadastro = new JMenu();
		menuConsulta = new JMenu();
		menuSair = new JMenu();

		itemCadastrarFilme = new JMenuItem();
		itemCadastrarLocacao = new JMenuItem();
		itemCadastrarVendedor = new JMenuItem();
		itemCadastrarCliente = new JMenuItem();
		itemConsultarFilme = new JMenuItem();
		itemConsultarVendedor = new JMenuItem();
		itemConsultarCliente = new JMenuItem();
		itemSair = new JMenuItem();

		/*
		 * configurações de texto do menu
		 */
		menuCadastro.setText("CADASTRO");
		menuConsulta.setText("CONSULTAR");
		menuSair.setText("SAIR");

		/*
		 * configurações do texto do item menu
		 */
		itemCadastrarFilme.setText("Cadastrar Filme");
		itemCadastrarLocacao.setText("Cadastrar Locação");
		itemCadastrarVendedor.setText("Cadastrar Vendedor");
		itemCadastrarCliente.setText("Cadastrar Cliente");
		itemConsultarFilme.setText("Consultar Filme");
		itemConsultarVendedor.setText("Consultar Vendedor");
		itemConsultarCliente.setText("Consultar Cliente");
		itemSair.setText("Sair");

		/*
		 * adicionando o menu na barra de menu
		 */
		barraMenu.add(menuCadastro);
		barraMenu.add(menuConsulta);
		barraMenu.add(menuSair);

		/*
		 * adicionando os itens de menu no menu 1
		 */
		menuCadastro.add(itemCadastrarFilme);
		menuCadastro.add(itemCadastrarLocacao);
		menuCadastro.add(itemCadastrarVendedor);
		menuCadastro.add(itemCadastrarCliente);
		menuConsulta.add(itemConsultarFilme);
		menuConsulta.add(itemConsultarVendedor);
		menuConsulta.add(itemConsultarCliente);
		menuSair.add(itemSair);

		itemCadastrarFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarFilmeView().iniciaGui();
			}

		});
		itemCadastrarLocacao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastrarLocacaoView().iniciaGui();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		});
		itemCadastrarVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarVendedorView().iniciaGui();
			}

		});
		itemCadastrarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroClienteView().iniciaGui();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		});
		itemConsultarFilme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarFilmesView().iniciaGui();;
			}

		});
		itemConsultarVendedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarVendedorView().iniciaGui();
			}

		});
		
		itemConsultarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarClienteView().iniciaGui();
				
			}
		});
		itemSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o Sistema", "Atenção", JOptionPane.YES_OPTION,
						JOptionPane.CANCEL_OPTION);
				// se confirmar que quer sair então ativa função para sair do sistema
				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

		});
		/*
		 * configuraçãos do JFrame - janela
		 */
		janela.setJMenuBar(barraMenu);
		janela.setTitle("LOCADORA");
		// configurando a ação do X do Jframe
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/*
		 * configurando o tamanho maximizado
		 */
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// configurando a visibilidade da tela
		janela.setVisible(true);
	} // fim do método
}// fim da classe
