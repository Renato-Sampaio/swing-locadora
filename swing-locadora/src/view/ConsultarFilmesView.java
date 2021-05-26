package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FilmeController;
import model.Filme;

/**
 * Classe responsavel por fazer a consulta de filmes
 * 
 * @author Renato Sampaio
 * @since 05/03/2021
 * @version 1.0
 */
public class ConsultarFilmesView {
	// declarando os atributos da tela
	private JFrame janela;

	// declarando a tabela JTable para exibir os dados do filme para locação
	private JTable tabela;
	// declarando o vetor auxiliar para armazenar os nomes das colunas
	private String colunas[] = { "Código", "Nome", "Valor", "Disponível", "Promoção", "Valor Promocional" };

	// declarando o scroll para a tabela
	private JScrollPane scroll;

	// declarando o botão Jbutton para sair
	private JButton btSair;

	// declarando o JPanel para organização
	private JPanel painel;

	public void iniciaGui() {// inicio do método
		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o titulo da tela
		janela.setTitle("CONSULTA DE FILMES");
		// configurando o tamanho da tela - largura/altura
		janela.setSize(580, 400);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configurações do componente JTabble - tabela de dados
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modeloTabela = new DefaultTableModel(null, colunas);
		// instanciando a tabela
		tabela = new JTable(modeloTabela);
		tabela.setBounds(1, 1, 562, 290);
		tabela.setEnabled(true);

		/*
		 * configurações do componente JScrollPane
		 */
		scroll = new JScrollPane(tabela);
		// configurar local de exibição do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posição e o tamanho
		scroll.setBounds(1, 1, 562, 290);

		/*
		 * configurações do componente JButton
		 */
		btSair = new JButton();
		btSair.setText("SAIR");
		btSair.setBounds(200, 305, 150, 30);
		btSair.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mantém o menu aberto
				janela.dispose();
			}
		});
		/*
		 * configurações do painel da janela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(scroll);
		painel.add(btSair);

		
		// configurando a visibilidade da janela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		carregarTabela();
		janela.setVisible(true);
	}// fim do método
	/*
	 * Método para carregar a tabela com os vendedores gravados no arquivo TXT
	 */

	public void carregarTabela() {

		// Obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

		// Laço de repetição para preencher as linhas da tabela
		for (Filme filme : new FilmeController().getFilmes()) {
			String disponivel = "";
			String terPromocao = "";

			// Caso o retorno booleano seja TRUE, exibir SIM na tabela
			if (filme.isDisponivel()) {
				disponivel = "SIM";
			} else { // Caso o retorno booleano seja FALSE, exibir NÃO na tabela
				disponivel = "NÃO";
			}
			// Caso o retorno booleano seja TRUE, exibir SIM na tabela
			if (filme.isPromocao()) {
				terPromocao = "SIM";
			} else { // Caso o retorno booleano seja FALSE, exibir NÃO na tabela
				terPromocao = "NÃO";
			}
			// Adicionando a linha na tabela
			modelo.addRow(new String[] { filme.getCodigo() + "", filme.getNome(), filme.getValor() + "", disponivel,
					terPromocao, filme.getValorPromocao() + "", });
			
			
		}
	}


}// fim da classe
