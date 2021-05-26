package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import util.Mensagem;
import util.Titulo;
import util.Valida;

/**
 * Classe responsável por exibir a janela para cadastrar um vendedor
 * 
 * @author Renato Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastrarLocacaoView {
	// declarando os atributos da tela
	private JFrame janela;

	// declarando as JLabels para exibir os rótulos na tela
	private JLabel lbNomeVendedor;
	private JLabel lbNomeDoFilme;
	private JLabel lbFormaDePagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	
	// declarando o JTextField 
	private JTextField tfValorPago;

	// declarando os ocampos formatados
	private JFormattedTextField tfValorTotal;
	private JFormattedTextField tfTroco;

	// declarando os atributos de formatação
	private MaskFormatter fmtDinheiro;

	// declarando os JRadioButtons para selecionar o sexo
	private JRadioButton rbPagamentoDinheiro;
	private JRadioButton rbPagamentoCheque;
	private JRadioButton rbPagamentoDebito;
	private JRadioButton rbPagamentoCredito;

	// componente ButtonGroup responsável por gerenciar os componentes radio button
	private ButtonGroup grpRadio;

	// declarando os JComboBox para listar os filmes e vendedores e poder fazer a
	// seleção
	private JComboBox<String> cbFilmes;
	private JComboBox<String> cbVendedores;

	// declarando a tabela JTable para exibir os dados do filme para locação
	private JTable tabela;
	// declarando o vetor auxiliar para armazenar os nomes das colunas
	private String colunas[] = { "Código", "Nome", "Valor", "Disponível", "Promoção", "Valor Promocional" };

	// matriz auxiliar para armazenar os dados exibidos na tabela
	private String linhas[][];

	// declarando o scroll para a tabela
	private JScrollPane scroll;

	// criando um vetor para armazenar os vendedores e filmes
	private String vendedores[] = { "-Selecione um Vendedor-",};
	private String filmes[] = { "-Selecione um Filme-",};

	// declarando os JButtons para salvar, cancelar e incluir
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	private JButton btIncluir;

	// declarando o JPanel para organização
	private JPanel painel;

	public void iniciaGui() throws ParseException {// inicio do método
		/*
		 * configurações dos campos de formatação
		 */
		fmtDinheiro = new MaskFormatter("R$0,00");

		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o titulo da tela
		janela.setTitle("LOCAÇÃO DE FILME");
		// configurando o tamanho da tela - largura/altura
		janela.setSize(610, 420);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configurações do JLabel
		 */
		lbNomeVendedor = new JLabel();
		lbNomeVendedor.setText("Nome do Vendedor:");
		lbNomeVendedor.setBounds(25, 15, 120, 20);

		lbNomeDoFilme = new JLabel();
		lbNomeDoFilme.setText("Nome do Filme:");
		lbNomeDoFilme.setBounds(25, 45, 120, 20);

		lbFormaDePagamento = new JLabel();
		lbFormaDePagamento.setText("Forma de pagamento:");
		lbFormaDePagamento.setBounds(20, 214, 130, 20);

		lbValorTotal = new JLabel();
		lbValorTotal.setText("Valor Total:");
		lbValorTotal.setBounds(316, 214, 70, 20);

		lbValorPago = new JLabel();
		lbValorPago.setText("Valor Pago:");
		lbValorPago.setBounds(316, 240, 70, 20);

		lbTroco = new JLabel();
		lbTroco.setText("Troco:");
		lbTroco.setBounds(316, 266, 70, 20);

		/*
		 * configurações dos JTextFields
		 */
		

		tfValorTotal = new JFormattedTextField(fmtDinheiro);
		tfValorTotal.setBounds(386, 214, 100, 26);
		
		tfValorPago = new JTextField();
		tfValorPago.setBounds(386, 240, 100, 26);

		tfTroco = new JFormattedTextField(fmtDinheiro);
		tfTroco.setBounds(386, 266, 100, 26);

		/*
		 * configuração dos JRadioButton do sexo
		 */
		rbPagamentoDinheiro = new JRadioButton();
		rbPagamentoDinheiro.setText("Dinheiro");
		rbPagamentoDinheiro.setBounds(150, 214, 83, 20);

		rbPagamentoCheque = new JRadioButton();
		rbPagamentoCheque.setText("Cheque");
		rbPagamentoCheque.setBounds(150, 235, 83, 20);

		rbPagamentoDebito = new JRadioButton();
		rbPagamentoDebito.setText("Débito");
		rbPagamentoDebito.setBounds(150, 255, 83, 20);

		rbPagamentoCredito = new JRadioButton();
		rbPagamentoCredito.setText("Crédito");
		rbPagamentoCredito.setBounds(150, 275, 83, 20);

		/*
		 * configurando o agrupador de botões
		 */
		grpRadio = new ButtonGroup();
		grpRadio.add(rbPagamentoDinheiro);
		grpRadio.add(rbPagamentoCheque);
		grpRadio.add(rbPagamentoDebito);
		grpRadio.add(rbPagamentoCredito);

		/*
		 * configuração dos JComboBox
		 */
		cbVendedores = new JComboBox<String>(vendedores);
		cbVendedores.setBounds(150, 14, 430, 26);

		cbFilmes = new JComboBox<String>(filmes);
		cbFilmes.setBounds(150, 44, 300, 26);

		/*
		 * configurações do componente JTabble - tabela de dados
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modeloTabela = new DefaultTableModel(linhas, colunas);
		// instanciando a tabela
		tabela = new JTable(modeloTabela);
		tabela.setBounds(1, 85, 593, 120);
		tabela.setEnabled(true);

		/*
		 * configurações do componente JScrollPane
		 */
		scroll = new JScrollPane(tabela);
		// configurar local de exibição do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posição e o tamanho
		scroll.setBounds(1, 85, 593, 120);

		/*
		 * configurações do JButtons
		 */
		btSalvar = new JButton();
		btSalvar.setText("SALVAR");
		btSalvar.setBounds(130, 340, 130, 26);

		btCancelar = new JButton();
		btCancelar.setText("CANCELAR");
		btCancelar.setBounds(280, 340, 130, 26);
		
		/*
		 * configurações do JButtons
		 */
		btNovo = new JButton();
		btNovo.setText("NOVO");
		btNovo.setBounds(130, 340, 130, 26);

		btSair = new JButton();
		btSair.setText("SAIR");
		btSair.setBounds(280, 340, 130, 26);
		
		//ação dos bt
		btNovo.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// metodo para desbloquear tela
				liberarTela();
			}
		});
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mantem menu aberto
				janela.dispose();
			}
		});
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				salvar();
			}
		});
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// metodo para limpar os campos da tela e bloquear
				limparTela();
				bloquearTela();
			}
		});

		btIncluir = new JButton();
		btIncluir.setText("INCLUIR");
		btIncluir.setBounds(460, 44, 90, 26);

		/*
		 * configurações do painel da janela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(lbNomeVendedor);
		painel.add(lbNomeDoFilme);
		painel.add(lbFormaDePagamento);
		painel.add(lbValorTotal);
		painel.add(lbValorPago);
		painel.add(lbTroco);
		painel.add(rbPagamentoDinheiro);
		painel.add(rbPagamentoCheque);
		painel.add(rbPagamentoDebito);
		painel.add(rbPagamentoCredito);
		painel.add(tfValorPago);
		painel.add(tfValorTotal);
		painel.add(tfTroco);
		painel.add(cbFilmes);
		painel.add(cbVendedores);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btIncluir);
		painel.add(scroll);

		bloquearTela();
		// configurando a visibilidade da tela
		
		// bloqueando a tela ao iniciar
		bloquearTela();
		
		// configurar a visibiliadade da tela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
	}// fim do método
	
	/*
	 * metodo bloquear tela de cadastro
	 */

	private void bloquearTela() {

		tfValorTotal.setEnabled(false);
		tfValorPago.setEnabled(false);
		tfTroco.setEnabled(false);
		cbVendedores.setEnabled(false);
		cbFilmes.setEnabled(false);
		rbPagamentoDinheiro.setEnabled(false);
		rbPagamentoCheque.setEnabled(false);
		rbPagamentoDebito.setEnabled(false);
		rbPagamentoCredito.setEnabled(false);
		tabela.setEnabled(false);
		btIncluir.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btSair.setVisible(true);
		btNovo.setVisible(true);

	}

	/*
	 * metodo pra liberar tela de cadastro
	 */

	private void liberarTela() {

		tfValorTotal.setEnabled(true);
		tfValorPago.setEnabled(true);
		tfTroco.setEnabled(true);
		cbVendedores.setEnabled(true);
		cbFilmes.setEnabled(true);
		rbPagamentoDinheiro.setEnabled(true);
		rbPagamentoCheque.setEnabled(true);
		rbPagamentoDebito.setEnabled(true);
		rbPagamentoCredito.setEnabled(true);
		tabela.setEnabled(true);
		btIncluir.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btSair.setVisible(false);
		btNovo.setVisible(false);

	}

	/*
	 * metodo para limpar campos da tela de cadastro
	 */
	private void limparTela() {

		tfValorTotal.setText(null);
		tfValorPago.setText(null);
		tfTroco.setText(null);
		tabela.clearSelection();
		grpRadio.clearSelection();
		cbFilmes.setSelectedIndex(0);
		cbVendedores.setSelectedIndex(0);

	}
	
	public void salvar() {
		// salvar o vendedor se estiver validos os dados
		if (validar()) {

			/*
			 * procedimentos de gravação do objeto vendedor no arquivo txt.
			 */

			// limpar tela
			limparTela();

			// bloquear tela
			bloquearTela();

			// exibindo mensagem de sucesso de gravação do vendedor
			JOptionPane.showMessageDialog(null, Mensagem.locacaoGravado, Titulo.cadastroLocacao, 1);

		}

	}

	/*
	 * metodo pra validar os campos da tela
	 * 
	 */
	private boolean validar() {

		// validaçao do campo Valor Total
		if (Valida.isEmptyOrNull(tfValorTotal.getText())) {
			// Valor Total nao preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorTotalVazio, Titulo.cadastroLocacao, 0);
			// colocando o foco no campo com erro
			tfValorTotal.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao do campo Valor Pago
				if (Valida.isEmptyOrNull(tfValorPago.getText())) {
					// Valor pago nao preenchido
					JOptionPane.showMessageDialog(null, Mensagem.valorPagoVazio, Titulo.cadastroLocacao, 0);
					// colocando o foco no campo com erro
					tfValorPago.grabFocus();
					// retornar false para o metodo
					return false;
				}
				// validaçao do campo Forma de pagamento
				if (!rbPagamentoDinheiro.isSelected()) {
					if (!rbPagamentoCheque.isSelected()) {
						if (!rbPagamentoDebito.isSelected()) {
							if (!rbPagamentoCredito.isSelected()) {
								// Forma de pagamento nao selecionada
								JOptionPane.showMessageDialog(null, Mensagem.formaPagamentoVazio, Titulo.cadastroLocacao, 0);
								// retornar false para o metodo
								return false;
								
							}
							
						}
						
					}
					
					
				}
		
		
		return true;
	}
		
}// fim da do CadastrarFilmeView

