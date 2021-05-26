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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * /** Classe responsavel pela criação da tela Cadastrar Cliente.
 * @author Renato Duarte Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastroClienteView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbSexo;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	private JLabel lbidade;
	private JLabel lbLogradouro;
	private JLabel lbNumero;
	private JLabel lbEndereco;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbBairro;
	private JLabel lbCep;
	private JLabel lbComplemento;

	// declarando os campos formatados.
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	private JFormattedTextField tfCep;

	// declarando os atributos de formatação.
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;

	// componente ComboBox que permite a seleção de uma opção já pré-definida
	private JComboBox<String> cbEstado;
	private JComboBox<String> cbLogradouro;
	// declarando os campos textos para o usuário digitar as informações
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfidade;
	private JTextField tfEmail;
	
	private JTextField tfNumero;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JTextField tfBairro;
	private JTextField tfComplemento;
	// declarando o componente radio button
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// componente ButtonGroup responsável por gerenciar os radios buttons
	private ButtonGroup grpRadio;
	// declarando os botões SALVAR e CANCELAR
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o painel para organizar os componentes da tela
	private JPanel painel5;
	private JPanel painel3;
	private JPanel painel2;
	private JPanel painel4;
	private JPanel painel;
	// vetor auxiliar para armazenar os estados
	private String estados[] = {};
	// vetor auxiliar para armazenar os Logradouro,
	private String logradouro[] = { "-Selecione-", "Alameda", " Avenida", " Chácara", " Distrito", " Estrada", "Favela",
			"Fazenda", "Ladeira", " Largo", "Rua", "Viela", " Viaduto", "Travessa" };

	/*
	 * Método para criar a tela
	 */
	public void iniciaGui() throws ParseException {

		/*
		 * configurações dos campos de formatação
		 */
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##) # ####-####");
		fmtCep = new MaskFormatter("#####-###");

		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// Atribuindo o título da tela
		janela.setTitle("CADASTRO DE CLIENTE");
		// Configurando o tamanho da tela - largura/altura
		janela.setSize(640, 470);
		// Configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configurações da JLabel Codigo
		 */
		lbCodigo = new JLabel();
		// Atribuindo o texto inicial
		lbCodigo.setText("CÓDIGO:");
		// Configurando o tamanho e posição
		lbCodigo.setBounds(15, 25, 60, 25);
		/*
		 * Configurações do componente JTextField Código
		 */
		tfCodigo = new JTextField();
		// Configurar a posição e tamanho
		tfCodigo.setBounds(70, 25, 70, 25);

		/*
		 * Configurações da JLabel Nome
		 */
		lbNome = new JLabel();
		// Atribuindo o texto inicial
		lbNome.setText("NOME :");
		// Configurando o tamanho e posição
		lbNome.setBounds(15, 30, 90, 30);
		/*
		 * Configurações do componente JTextField Nome
		 */
		tfNome = new JTextField();
		// Configurar a posição e tamanho
		tfNome.setBounds(60, 30, 360, 25);

		/*
		 * Configurações da JLabel area de venda
		 */
		/*
		 * Configuração da Jlabel CPF
		 */
		lbCpf = new JLabel();
		lbCpf.setText("CPF: ");
		lbCpf.setBounds(15, 60, 80, 25);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbRg = new JLabel();
		lbRg.setText("RG: ");
		lbRg.setBounds(200, 60, 80, 25);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbDataNascimento = new JLabel();
		lbDataNascimento.setText("DATA NASCIMENTO: ");
		lbDataNascimento.setBounds(360, 60, 120, 20);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbTelefone = new JLabel();
		lbTelefone.setText("TELEFONE: ");
		lbTelefone.setBounds(15, 25, 110, 20);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbCelular = new JLabel();
		lbCelular.setText("CELULAR: ");
		lbCelular.setBounds(15, 50, 110, 20);
		/*
		 * Configuração da Jlabel CPF
		 */
		lbEmail = new JLabel();
		lbEmail.setText("EMAIL: ");
		lbEmail.setBounds(15, 75, 110, 20);

		/*
		 * configurando o formato do cpf
		 */

		tfCpf = new JFormattedTextField(fmtCpf);
		// posição e tamanho.
		tfCpf.setBounds(60, 60, 100, 25);

		/*
		 * configurando o formato do rg
		 */

		tfRg = new JFormattedTextField(fmtRg);
		// posição e tamanho.
		tfRg.setBounds(240, 60, 100, 25);

		/*
		 * configurando o formato do Data de Nascimento
		 */

		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);
		// posição e tamanho.
		tfDataNascimento.setBounds(480, 60, 100, 25);

		/*
		 * configurações do componente JTextField Cidade
		 */
		tfTelefone = new JFormattedTextField(fmtTelefone);
		// configurar a posição e tamanho
		tfTelefone.setBounds(85, 25, 100, 25);

		/*
		 * configurações do componente JTextField Cidade
		 */
		tfCelular = new JFormattedTextField(fmtCelular);
		// configurar a posição e tamanho
		tfCelular.setBounds(85, 50, 100, 25);

		/*
		 * configurações do componente JTextField Cidade
		 */
		tfEmail = new JTextField();
		// configurar a posição e tamanho
		tfEmail.setBounds(85, 75, 290, 25);
		/*
		 * Configurações da JLabel Nome
		 */
		lbidade = new JLabel();
		// Atribuindo o texto inicial
		lbidade.setText("IDADE :");
		// Configurando o tamanho e posição
		lbidade.setBounds(430, 30, 90, 30);
		/*
		 * Configurações do componente JTextField Nome
		 */
		tfidade = new JTextField();
		// Configurar a posição e tamanho
		tfidade.setBounds(480, 30, 100, 25);

		/*
		 * configurações da JLabel SEXO
		 */
		lbSexo = new JLabel();
		// Atribuindo o texto inicial
		lbSexo.setText("Sexo :");
		// Configurando o tamanho e posição
		lbSexo.setBounds(15, 90, 40, 25);

		/*
		 * Configurações dos rádios buttons
		 */
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// Configurando o texto do componente
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		// Configurando a posição e tamanho
		rbMasculino.setBounds(60, 90, 85, 25);
		rbFeminino.setBounds(140, 90, 85, 25);

		/*
		 * Configurações da JLabel Nome
		 */
		lbEndereco = new JLabel();
		// Atribuindo o texto inicial
		lbEndereco.setText("ENDEREÇO: ");
		// Configurando o tamanho e posição
		lbEndereco.setBounds(15, 25, 90, 25);
		/*
		 * Configurações do componente JTextField Nome
		 */
		tfEndereco = new JTextField();
		// Configurar a posição e tamanho
		tfEndereco.setBounds(90, 25, 310, 25);
		/*
		 * Configurações da JLabel Nome
		 */
		lbNumero = new JLabel();
		// Atribuindo o texto inicial
		lbNumero.setText("Nº: ");
		// Configurando o tamanho e posição
		lbNumero.setBounds(450, 25, 100, 25);
		/*
		 * Configurações do componente JTextField Nome
		 */
		tfNumero = new JTextField();
		// Configurar a posição e tamanho
		tfNumero.setBounds(480, 25, 100, 25);

		/*
		 * Configurações da JLabel area de venda
		 */
		/*
		 * Configuração da Jlabel CPF
		 */
		lbLogradouro = new JLabel();
		lbLogradouro.setText("LOGRADOURO: ");
		lbLogradouro.setBounds(15, 55, 100, 25);
		/*
		 * Configurações do JComboBox
		 */
		cbLogradouro = new JComboBox<String>(logradouro);
		cbLogradouro.setBounds(110, 55, 80, 20);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbComplemento = new JLabel();
		lbComplemento.setText("COMPLEMENTO: ");
		lbComplemento.setBounds(200, 55, 100, 25);
		/*
		 * configurações do componente JTextField Cidade
		 */
		tfComplemento = new JTextField();
		// configurar a posição e tamanho
		tfComplemento.setBounds(300, 55, 100, 25);

		/*
		 * configurações da JLabel Estado
		 */
		lbEstado = new JLabel();
		// Atribuindo o texto inicial
		lbEstado.setText("ESTADO: ");
		// Configurando o tamanho e posição
		lbEstado.setBounds(420, 80, 100, 25);
		/*
		 * Configurações do JComboBox
		 */
		cbEstado = new JComboBox(estados);
		cbEstado.setBounds(480, 80, 100, 20);
		/*
		 * Configuração da Jlabel CPF
		 */
		lbBairro = new JLabel();
		lbBairro.setText("BAIRRO: ");
		lbBairro.setBounds(420, 55, 110, 20);

		/*
		 * configurando o formato do Data de Nascimento
		 */

		tfBairro = new JFormattedTextField();
		// posição e tamanho.
		tfBairro.setBounds(480, 55, 100, 25);

		/*
		 * Configuração da Jlabel CPF
		 */
		lbCidade = new JLabel();
		lbCidade.setText("CIDADE: ");
		lbCidade.setBounds(200, 80, 100, 20);
		/*
		 * configurando o formato do rg
		 */

		tfCidade = new JTextField();
		// posição e tamanho.
		tfCidade.setBounds(260, 80, 140, 25);

		/*
		 * Configuração da Jlabel Cep
		 */
		lbCep = new JLabel();
		lbCep.setText("CEP: ");
		lbCep.setBounds(15, 80, 100, 20);

		/*
		 * configurações do componente JTextField Cidade
		 */
		tfCep = new JFormattedTextField(fmtCep);
		// configurar a posição e tamanho
		tfCep.setBounds(50, 80, 100, 25);

		/*
		 * Configuração do ButtonGroup1 - para utilização no componente disponivel
		 */
		grpRadio = new ButtonGroup();
		grpRadio.add(rbMasculino);
		grpRadio.add(rbFeminino);

		/*
		 * Configuração do JButton SALVAR
		 */
		btSalvar = new JButton();
		// Atribuindo o texto
		btSalvar.setText("SALVAR");
		// Configurando o tamanho
		btSalvar.setBounds(480, 325, 130, 25);

		/*
		 * configuração do JButton CANCELAR
		 */
		btCancelar = new JButton();
		// Atribuindo o texto
		btCancelar.setText("CANCELAR");
		// Configurando o tamanho
		btCancelar.setBounds(480, 360, 130, 25);
		/*
		 * Configuração do JButton Novo
		 */
		btNovo = new JButton();
		// Atribuindo o texto
		btNovo.setText("NOVO");
		// Configurando o tamanho
		btNovo.setBounds(480, 325, 130, 25);
		
		/*
		 * configuração do JButton CANCELAR
		 */
		btSair = new JButton();
		// Atribuindo o texto
		btSair.setText("SAIR");
		// Configurando o tamanho
		btSair.setBounds(480, 360, 130, 25);
		/*
		 * Açoes dos botões
		 */

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
		
		
		/*
		 * configurano o Contato painel.
		 */
		painel2 = new JPanel();
		// configurando a posição e tamanho do painel.
		painel2.setBounds(15, 300, 400, 120);
		// layout do painel
		painel2.setLayout(null);
		// borda do painel.
		painel2.setBorder(new TitledBorder("Contatos"));
		painel2.add(lbTelefone);
		painel2.add(tfTelefone);
		painel2.add(lbCelular);
		painel2.add(tfCelular);
		painel2.add(lbEmail);
		painel2.add(tfEmail);

		/*
		 * configurano o Contato painel.
		 */
		painel3 = new JPanel();
		// configurando a posição e tamanho do painel.
		painel3.setBounds(15, 70, 600, 120);
		// layout do painel
		painel3.setLayout(null);
		// borda do painel.
		painel3.setBorder(new TitledBorder("Dados Pessoais"));
		painel3.add(lbNome);
		painel3.add(tfNome);
		painel3.add(lbRg);
		painel3.add(tfRg);
		painel3.add(lbCpf);
		painel3.add(tfCpf);
		painel3.add(lbSexo);
		painel3.add(lbDataNascimento);
		painel3.add(tfDataNascimento);
		painel3.add(lbidade);
		painel3.add(tfidade);
		painel3.add(lbSexo);
		painel3.add(rbMasculino);
		painel3.add(rbFeminino);

		/*
		 * configurano o Contato painel.
		 */
		painel5 = new JPanel();
		// configurando a posição e tamanho do painel.
		painel5.setBounds(15, 187, 600, 120);
		// layout do painel
		painel5.setLayout(null);
		// borda do painel.
		painel5.setBorder(new TitledBorder("Endereço"));
		painel5.add(lbEndereco);
		painel5.add(tfEndereco);
		painel5.add(tfComplemento);
		painel5.add(lbComplemento);
		painel5.add(lbLogradouro);
		painel5.add(cbLogradouro);
		painel5.add(lbEstado);
		painel5.add(cbEstado);
		painel5.add(lbCidade);
		painel5.add(tfCidade);
		painel5.add(lbBairro);
		painel5.add(tfBairro);
		painel5.add(lbCep);
		painel5.add(tfCep);
		painel5.add(tfNumero);
		painel5.add(lbNumero);

		/*
		 * configurano o painel - Codigo
		 */
		painel4 = new JPanel();
		// configurando a posição e tamanho do painel.
		painel4.setBounds(15, 10, 150, 65);
		// layout do painel
		painel4.setLayout(null);
		// borda do painel.
		painel4.setBorder(new TitledBorder("Código"));
		painel4.add(lbCodigo);
		painel4.add(tfCodigo);


		/*
		 * Configurações do painel principal da tela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(painel3);
		painel.add(painel4);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btSair);
		painel.add(btNovo);
		painel.add(painel2);
		painel.add(painel5);

		// carregando o metodo para carregar a combo de estados
		carregarComboEstados();
		
		// bloqueando a tela ao iniciar
		bloquearTela();
		
	    
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// configurar a visibiliadade da tela
		janela.setVisible(true);

	}// fim do iniciaGui

	/*
	 * metodo bloquear tela de cadastro
	 */

	private void bloquearTela() {

		tfCodigo.setEditable(false);
		tfComplemento.setEditable(false);
		tfDataNascimento.setEditable(false);
		tfNome.setEditable(false);
		tfRg.setEditable(false);
		tfCpf.setEditable(false);
		tfCep.setEditable(false);
		tfCidade.setEditable(false);
		tfBairro.setEditable(false);
		tfEndereco.setEditable(false);
		tfTelefone.setEditable(false);
		tfEmail.setEditable(false);
		tfEndereco.setEditable(false);
		tfCelular.setEditable(false);
		cbEstado.setEnabled(false);
		tfidade.setEditable(false);
		cbLogradouro.setEnabled(false);
		rbFeminino.setEnabled(false);
		rbMasculino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btSair.setVisible(true);
		btNovo.setVisible(true);
		tfCodigo.grabFocus();// força o cursor nesse campo primeiro
	
	}

	/*
	 * metodo pra liberar tela de cadastro
	 */

	private void liberarTela() {
		
		tfCodigo.setEditable(true);
		tfComplemento.setEditable(true);
		tfDataNascimento.setEditable(true);
		tfNome.setEditable(true);
		tfRg.setEditable(true);
		tfCpf.setEditable(true);
		tfCep.setEditable(true);
		tfCidade.setEditable(true);
		tfBairro.setEditable(true);
		tfEndereco.setEditable(true);
		tfTelefone.setEditable(true);
		tfEmail.setEditable(true);
		tfEndereco.setEditable(true);
		tfCelular.setEditable(true);
		cbEstado.setEnabled(true);
		tfidade.setEditable(true);
		cbLogradouro.setEnabled(true);
		rbFeminino.setEnabled(true);
		rbMasculino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btSair.setVisible(false);
		btNovo.setVisible(false);
		tfCodigo.grabFocus();// força o cursor nesse campo primeiro

	}

	/*
	 * metodo para limpar campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfComplemento.setText(null);
		tfDataNascimento.setText(null);
		tfNome.setText(null);
		tfRg.setText(null);
		tfCpf.setText(null);
		tfCep.setText(null);
		tfCidade.setText(null);
		tfBairro.setText(null);
		tfEndereco.setText(null);
		tfTelefone.setText(null);
		tfEmail.setText(null);
		tfEndereco.setText(null);
		tfCelular.setText(null);
		tfidade.setText(null);
		cbLogradouro.setSelectedIndex(0);
		rbFeminino.setText(null);
		rbMasculino.setText(null);
		grpRadio.clearSelection();
		cbEstado.setSelectedIndex(0);

	}

	/*
	 * metodo para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbEstado.addItem("-Selecione Estado-");

		// laço de repeticao para carregar a combo de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbEstado.addItem(estado.getEstado());
		}
	}

	
	
	public void salvar() {
		// salvar o vendedor se estiver validos os dados
		if (validar()) {
			
			/*
			 * procedimentos de gravação do objeto vendedor no arquivo txt.
			 */
			Cliente cliente = getCliente();
			new ClienteController().gravarTxtCliente(cliente);
			//limpar tela
			limparTela();
			
			//bloquear tela
			bloquearTela();
			
			//exibindo mensagem de sucesso de gravação do cliente
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Titulo.cadastroVendedor,1);

		}

	}
	/*
	 * metodo pra validar os campos da tela
	 * 
	 */
	private boolean validar() {

		// validaçao do campo codigo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// codigo nao preenchido o codigo nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroCliente, 0);
			// retornar false para o metodo

			// colocando o foco no capmpo com erro
			tfCodigo.grabFocus();
			return false;
		}
		// validaçao do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// nao preenchido o nome nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no capmpo com erro
			tfNome.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao do CPF
		if (Valida.isEmptyOrNull(tfCpf.getText())) {
			// o CPF nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.CpfVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no capmpo com erro
			tfCpf.grabFocus();
			// retornar false para o metodo
			return false;
		}

		// validaçao doRG
		if (Valida.isEmptyOrNull(tfRg.getText())) {
			// o RG nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.RgVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfRg.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao da Data de nascimento
		if (Valida.isEmptyOrNull(tfDataNascimento.getText())) {
			// a Data nao esta preenchida
			JOptionPane.showMessageDialog(null, Mensagem.NascimentoVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao da Idade
		if (Valida.isEmptyOrNull(tfidade.getText())) {
			// a IDADE nao esta preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfidade.grabFocus();
			// retornar false para o metodo
			return false;
		}

		// validaçaõ do Radio Button de sexo
		if (!rbFeminino.isSelected()) {
			if (!rbMasculino.isSelected()) {

				JOptionPane.showMessageDialog(null, Mensagem.generosVazio, Titulo.cadastroCliente, 0);
				return false;
			}
		}
		// validaçao do numero de telefone
		if (Valida.isEmptyOrNull(tfTelefone.getText())) {
			// O numero de a nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfTelefone.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao do numero de Celular
		if (Valida.isEmptyOrNull(tfCelular.getText())) {
			// O numero de Celular nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfCelular.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao de e-mail
		if (Valida.isEmptyOrNull(tfEmail.getText())) {
			// O numero de Celular nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfEmail.grabFocus();
			// retornar false para o metodo
			return false;
		}
		
		// validação da combo de estado
 		if (cbEstado.getSelectedIndex() == 0) {

 			// informando que o Estado nao foi selecionado
 			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
 			// colocando foco no campo com erro
 			cbEstado.grabFocus();
 			return false;
 		}

		// validaçao Nome de Logradouro
		if (cbLogradouro.getSelectedIndex() == 0) {
			// O Nome de Logradouro nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeLogradouroVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			cbLogradouro.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao Numero de Logradouro
		if (Valida.isEmptyOrNull(tfNumero.getText())) {
			// O Numero de Logradouro nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroLogradouroVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao Complemento de Logradouro
		if (Valida.isEmptyOrNull(tfComplemento.getText())) {
			// O Numero de Logradouro nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.complementoVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfComplemento.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao de Bairro
		if (Valida.isEmptyOrNull(tfBairro.getText())) {
			// O Bairro nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfBairro.grabFocus();
			// retornar false para o metodo
			return false;
		}
		// validaçao de Cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// A Cidade nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o metodo
			return false;
		}

		// validaçao de ESTADOS
		if (cbEstado.getSelectedIndex() == 0) {

			// informando que o Estado nao foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// colocando foco no campo com erro
			cbEstado.grabFocus();
			return false;
		}
		// validaçao de CEP
		if (Valida.isEmptyOrNull(tfCep.getText())) {
			// O CEP nao esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.CepVazio, Titulo.cadastroCliente, 0);

			// colocando o foco no campo com erro
			tfCep.grabFocus();
			// retornar false para o metodo
			return false;
		}

		return true;
	}
		
		/*
		 * Método para valorizar um objeto Cliente utilizando os campos da tela
		 */
		private Cliente getCliente () {

			// instanciando o objeto vendedor para retorno do método
			Cliente cliente = new Cliente();
			Endereco endereco = new Endereco();
			Data data = new Data();
			String dataNascimento[] = tfDataNascimento.getText().split("/");
			String dia, mes, ano;
			dia = dataNascimento[0];
			mes = dataNascimento[1];
			ano = dataNascimento[2];

			// valorizando o objeto Cliente
			cliente.setCodigo(Util.getInt(tfCodigo.getText()));
			cliente.setNome(tfNome.getText());
			endereco.setCodigo(Util.getInt(tfCodigo.getText()));
			endereco.setLogradouro(cbLogradouro.getSelectedItem()+ "");
			endereco.setEndereco(tfEndereco.getText());
			endereco.setNumero(Util.getInt(tfNumero.getText()));
			endereco.setComplemento(tfComplemento.getText());
			endereco.setBairro(tfBairro.getText());
			endereco.setCidade(tfCidade.getText());
			endereco.setEstado(cbEstado.getSelectedItem() + "");
			endereco.setCep(tfCep.getText());
			cliente.setEndereco(endereco);
			cliente.setCpf(tfCpf.getText());
			cliente.setRg(tfRg.getText());
			data.setDia(Integer.parseInt(dia));
			data.setMes(Integer.parseInt(mes));
			data.setAno(Integer.parseInt(ano));
			cliente.setDataNascimento(data);
			cliente.setIdade(Util.getInt(tfidade.getText()));
			// condicional ternária - if em uma linha - ? se / : senão
			cliente.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
			cliente.setTelefone(tfTelefone.getText());
			cliente.setCelular(tfCelular.getText());
			cliente.setEmail(tfEmail.getText());

			// retornando o objeto valorizado
			return cliente;

	}
}// fim do metodo