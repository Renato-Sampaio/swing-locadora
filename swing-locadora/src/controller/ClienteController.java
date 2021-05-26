/**
 * 
 */

package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Data;
import model.Endereco;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsavel por controlar os métodos do objeto Cliente
 * 
 * @author Renato Duarte Sampaio
 * @since 09/03/2021
 * @version 1.0
 */
public class ClienteController {

	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "cliente.txt";

	/*
	 * Método para gravar registros no arquivo TXT
	 */
	public void gravarTxtCliente(Cliente cliente) {

		// classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file = new File(arquivo);

		try {
			// classe auxiliar para gerar um objeto de memória para gravação do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file, true);

			// classe auxiliar para gerar o arquivo e seu conteúdo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// gravando o conteúdo do arquivo
			gravador.print(cliente.getCodigo());
			gravador.print(";");
			gravador.print(cliente.getNome());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCodigo());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getEndereco());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCidade());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getEstado());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCep());
			gravador.print(";");
			gravador.print(cliente.getCpf());
			gravador.print(";");
			gravador.print(cliente.getRg());
			gravador.print(";");
			gravador.print(cliente.getDataNascimento().getDia());
			gravador.print(";");
			gravador.print(cliente.getDataNascimento().getMes());
			gravador.print(";");
			gravador.print(cliente.getDataNascimento().getAno());
			gravador.print(";");
			gravador.print(cliente.getIdade());
			gravador.print(";");
			gravador.print(cliente.getSexo());
			gravador.print(";");
			gravador.print(cliente.getTelefone());
			gravador.print(";");
			gravador.print(cliente.getCelular());
			gravador.print(";");
			gravador.print(cliente.getEmail());
			gravador.print("\n");

			// fechando o processo de gravação
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoCliente, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoCliente, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		}
	}// fim do método

	/*
	 * Método para retornar uma lista de vendedores
	 */
	public ArrayList<Cliente> getClientes() {
		// objeto de lista para retornar no método
		ArrayList<Cliente> clientes = buscarTodos();
		return clientes;
	}

	/*
	 * Método para ler o arquivo TXT de vendedor
	 */
	private ArrayList<Cliente> buscarTodos() {

		// lista auxiliar para retornar no método
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {
			// classe Scanner auxiliar para ler o arquivo de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no método
				Cliente cliente = getCliente(leitor.nextLine());
				// atribuindo o objeto vendedor na lista de retorno
				clientes.add(cliente);

			} // fim do while

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// retornando a lista de vendedores
		return clientes;

	} // fim do método

	/*
	 * método para retornar um objeto do tipo vendedor
	 */
	private Cliente getCliente(String args) {
		// objeto auxiliar para retornar no método
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Data data = new Data();
		// variavel auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto vendedor
		cliente.setCodigo(Util.getInt(aux[0]));
		cliente.setNome(aux[1]);
		endereco.setCodigo(Util.getInt(aux[2]));
		endereco.setLogradouro(aux[3]);
		endereco.setEndereco(aux[4]);
		endereco.setNumero(Util.getInt(aux[5]));
		endereco.setComplemento(aux[6]);
		endereco.setBairro(aux[7]);
		endereco.setCidade(aux[8]);
		endereco.setEstado(aux[9]);
		endereco.setCep(aux[10]);
		cliente.setEndereco(endereco);
		cliente.setCpf(aux[11]);
		cliente.setRg(aux[12]);
		data.setDia(Util.getInt(aux[13]));
		data.setMes(Util.getInt(aux[14]));
		data.setAno(Util.getInt(aux[15]));
		cliente.setDataNascimento(data);
		cliente.setIdade(Util.getInt(aux[16]));
		cliente.setSexo(aux[17].charAt(0));
		cliente.setTelefone(aux[18]);
		cliente.setCelular(aux[19]);
		cliente.setEmail(aux[20]);

		// retornando o objeto valorizado
		return cliente;
	}
}
