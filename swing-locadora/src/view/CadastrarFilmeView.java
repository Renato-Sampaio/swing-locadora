package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por exibir a janela de cadastro de filme
 * 
 * @author Renato Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastrarFilmeView {
	// declarando os atributos da tela
	private JFrame janela;

	// declarando as JLabels para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorPromocao;
	private JLabel lbGenero;

	// declarando os JTextFields para receber as informações
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;

	// declarando os JRadioButtons para selecionar uma opção
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;

	// componente ButtonGroup responsável por gerenciar os componentes radio button
	private ButtonGroup grpRadioDisponivel;
	private ButtonGroup grpRadioPromocao;

	// declarando os JCheckBox para selecionar os generos
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;

	// declarando os JButtons para salvar ou cancelar ações
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;

	// declarando o JPanel para organização
	private JPanel painel;

	public void iniciaGui() {// inicio do método
		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o titulo da tela
		janela.setTitle("CADASTRO DE FILME");
		// configurando o tamanho da tela - largura/altura
		janela.setSize(581, 349);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configurações do JLabel
		 */
		lbCodigo = new JLabel();
		lbCodigo.setText("Código:");
		lbCodigo.setBounds(20, 23, 100, 15);

		lbNome = new JLabel();
		lbNome.setText("Nome:");
		lbNome.setBounds(20, 53, 100, 15);

		lbValor = new JLabel();
		lbValor.setText("Valor:");
		lbValor.setBounds(20, 83, 100, 15);

		lbDisponivel = new JLabel();
		lbDisponivel.setText("Disponível:");
		lbDisponivel.setBounds(20, 113, 100, 15);

		lbPromocao = new JLabel();
		lbPromocao.setText("Promoção:");
		lbPromocao.setBounds(20, 143, 100, 15);

		lbValorPromocao = new JLabel();
		lbValorPromocao.setText("Valor Promoção:");
		lbValorPromocao.setBounds(20, 173, 100, 15);

		lbGenero = new JLabel();
		lbGenero.setText("Gênero:");
		lbGenero.setBounds(20, 203, 100, 15);

		/*
		 * configurações do JTextField
		 */
		tfCodigo = new JTextField();
		tfCodigo.setBounds(130, 18, 405, 26);

		tfNome = new JTextField();
		tfNome.setBounds(130, 48, 405, 26);

		tfValor = new JTextField();
		tfValor.setBounds(130, 78, 405, 26);

		tfValorPromocao = new JTextField();
		tfValorPromocao.setBounds(130, 168, 405, 26);

		/*
		 * configurações do JRadioButtons
		 */
		rbDisponivelSim = new JRadioButton();
		rbDisponivelSim.setText("Sim");
		rbDisponivelSim.setBounds(130, 110, 50, 20);

		rbDisponivelNao = new JRadioButton();
		rbDisponivelNao.setText("Não");
		rbDisponivelNao.setBounds(180, 110, 50, 20);

		rbPromocaoSim = new JRadioButton();
		rbPromocaoSim.setText("Sim");
		rbPromocaoSim.setBounds(130, 140, 50, 20);

		rbPromocaoNao = new JRadioButton();
		rbPromocaoNao.setText("Não");
		rbPromocaoNao.setBounds(180, 140, 50, 20);

		/*
		 * configurando o agrupador de botões
		 */
		grpRadioDisponivel = new ButtonGroup();
		grpRadioDisponivel.add(rbDisponivelSim);
		grpRadioDisponivel.add(rbDisponivelNao);

		grpRadioPromocao = new ButtonGroup();
		grpRadioPromocao.add(rbPromocaoSim);
		grpRadioPromocao.add(rbPromocaoNao);

		/*
		 * configurações do JCheckBox
		 */
		cbAcao = new JCheckBox();
		cbAcao.setText("Ação");
		cbAcao.setBounds(130, 203, 54, 20);

		cbFiccao = new JCheckBox();
		cbFiccao.setText("Ficção");
		cbFiccao.setBounds(184, 203, 62, 20);

		cbTerror = new JCheckBox();
		cbTerror.setText("Terror");
		cbTerror.setBounds(246, 203, 62, 20);

		cbComedia = new JCheckBox();
		cbComedia.setText("Comédia");
		cbComedia.setBounds(308, 203, 75, 20);

		cbOutro = new JCheckBox();
		cbOutro.setText("Outros");
		cbOutro.setBounds(383, 203, 60, 20);

		/*
		 * configurações dos botões Salvar e Cancelar
		 */
		btSalvar = new JButton();
		btSalvar.setText("SALVAR");
		btSalvar.setBounds(130, 250, 100, 30);
		btSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
				
			}
		});

		btCancelar = new JButton();
		btCancelar.setText("CANCELAR");
		btCancelar.setBounds(270, 250, 100, 30);
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// método para limpar os campos da tela
				limparTela();
				// método para bloquear os campos da tela
				bloquearTela();
			}

		});

		btNovo = new JButton();
		btNovo.setText("NOVO");
		btNovo.setBounds(130, 250, 100, 30);
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// método para desbloquear a tela
				liberarTela();
			}
		});
		btSair = new JButton();
		btSair.setText("SAIR");
		btSair.setBounds(270, 250, 100, 30);
		btSair.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mantém o menu aberto
				janela.dispose();
			}
		});

		/*
		 * configurações do painel principal da tela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(lbCodigo);
		painel.add(lbNome);
		painel.add(lbValor);
		painel.add(lbDisponivel);
		painel.add(lbPromocao);
		painel.add(lbValorPromocao);
		painel.add(lbGenero);
		painel.add(tfCodigo);
		painel.add(tfNome);
		painel.add(tfValor);
		painel.add(tfValorPromocao);
		painel.add(rbDisponivelSim);
		painel.add(rbDisponivelNao);
		painel.add(rbPromocaoSim);
		painel.add(rbPromocaoNao);
		painel.add(cbAcao);
		painel.add(cbFiccao);
		painel.add(cbTerror);
		painel.add(cbComedia);
		painel.add(cbOutro);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		bloquearTela();
		
		// configurando a visibilidade da tela
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);

	}// fim do método

	private void bloquearTela() {
		tfCodigo.setEnabled(false);
		tfNome.setEnabled(false);
		tfValor.setEnabled(false);
		tfValorPromocao.setEnabled(false);
		rbDisponivelNao.setEnabled(false);
		rbDisponivelSim.setEnabled(false);
		rbPromocaoNao.setEnabled(false);
		rbPromocaoSim.setEnabled(false);
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbOutro.setSelected(false);
		cbTerror.setSelected(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbOutro.setEnabled(false);
		cbTerror.setEnabled(false);
		grpRadioDisponivel.clearSelection();
		grpRadioPromocao.clearSelection();
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	private void liberarTela() {// inicio método
		tfCodigo.setEnabled(true);
		tfNome.setEnabled(true);
		tfValor.setEnabled(true);
		tfValorPromocao.setEnabled(true);
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbOutro.setEnabled(true);
		cbTerror.setEnabled(true);
		rbDisponivelNao.setEnabled(true);
		rbDisponivelSim.setEnabled(true);
		rbPromocaoNao.setEnabled(true);
		rbPromocaoSim.setEnabled(true);
		grpRadioDisponivel.clearSelection();
		grpRadioPromocao.clearSelection();
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}// fim do método

	private void limparTela() {// inicio método
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfValor.setText(null);
		tfValorPromocao.setText(null);
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbOutro.setSelected(false);
		cbTerror.setSelected(false);
		grpRadioDisponivel.clearSelection();
		grpRadioPromocao.clearSelection();
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
	}// fim do método
	
	/*
	 * Método para receber a ação do clique salvar
	 */
	public void salvar() {

		// Salvar o vendedor apenas se estiver válido todos os dados
		if (validar()) {

			/*
			 * Procedimentos de gravação do objeto vendedor no arquivo txt
			 */
			Filme filme = getFilme();
			
			// Chamando o método responsável por gravar o arquivo txt
			new FilmeController().gravarTxtFilme(filme);
			
			// Limpar a tela
			limparTela();

			// Bloquear a tela
			bloquearTela();

			// Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null, Mensagem.filmeGravado, Titulo.cadastroFilme, 1);

		}
	}
	
	/*
	 * Método para validar os campos da tela
	 */
	private boolean validar() {

		// Validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// Informando ao usuário que o código não esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// Retornar falso para o método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// Informando ao usuário que o código é inválido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroFilme, 0);
			// Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// Retornando false para o método
			return false;
		}

		// Validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// Informando ao usuário que o nome não esta preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// Retornar falso para o método
			return false;
		}

		// Validação do campo área de venda
		if (Valida.isEmptyOrNull(tfValor.getText())) {
			// Informando ao usuário que a área de venda não esta preenchida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValor.grabFocus();
			// Retornar falso para o método
			return false;
		}
		
		// Validação do radio button de sexo
		if (!rbDisponivelSim.isSelected()) {
			if (!rbDisponivelNao.isSelected()) {
				// Informando o usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroFilme, 0);
				// Retornar falso para o método
				return false;
			}
		}
		
		// Validação do radio button de sexo
		if (!rbPromocaoSim.isSelected()) {
			if (!rbPromocaoNao.isSelected()) {
				// Informando o usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroFilme, 0);
				// Retornar falso para o método
				return false;
			}
		}

		// Validação do campo cidade
		if (Valida.isEmptyOrNull(tfValorPromocao.getText())) {
			// Informando ao usuário que a cidade não esta preenchida
			JOptionPane.showMessageDialog(null, Mensagem.valorPromoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			// Retornar falso para o método
			return false;
		}
		// Validação do campo gênero
		if (!cbAcao.isSelected() && !cbComedia.isSelected() && !cbFiccao.isSelected() && !cbOutro.isSelected()
				&& !cbTerror.isSelected()) {
				JOptionPane.showMessageDialog(null, Mensagem.generosVazio, Titulo.cadastroFilme, 0);
				return false;
				}


		// Devolvendo true caso esteja tudo válido
		return true;
	} // Fim do método valida
	
	/*
	 * Método para valorizar um objeto vendedor utilizando os campos da tela
	 */
	private Filme getFilme() {
		
		// Instanciando o objeto vendedor para retorno do método
		Filme filme = new Filme();
		
		// Valorizando o objeto filme
		filme.setCodigo(Util.getInt(tfCodigo.getText()));
		filme.setNome(tfNome.getText());
		filme.setValor(Util.getDouble(tfValor.getText()));
		filme.setDisponivel((rbDisponivelSim.isSelected()) ? true : false);
		filme.setPromocao((rbPromocaoSim.isSelected()) ? true : false);
		filme.setValorPromocao(Util.getDouble(tfValorPromocao.getText()));
		filme.setGenero(getGenero());
		
		// retornando o objeto valorizado
		return filme;
		
	} // Fim do método getVendedor
	
	private String getGenero() {
		String mensagem = "";
		if (cbAcao.isSelected()) {
			mensagem += "Ação;";
		}
		if (cbFiccao.isSelected()) {
			mensagem += "Ficção;";
		}
		if (cbTerror.isSelected()) {
			mensagem += "Terror;";
		}
		if (cbComedia.isSelected()) {
			mensagem += "Comédia;";
		}
		if (cbOutro.isSelected()) {
			mensagem += "Outro;";
		}
		
		return mensagem;
	}// fim so metodo

}//fim da classe
