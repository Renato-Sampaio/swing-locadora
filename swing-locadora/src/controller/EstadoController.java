package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Estado;
import util.Mensagem;
import util.Titulo;

/**
 * Classe responsavel por controlar os métodos do objeto Estado
 * 
 * @author Renato Duarte Sampaio
 * @since 08/03/2021
 * @version 1.0
 */

public class EstadoController {
	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "estados.txt";
	
	/*
	 * método responsavel por retornar uma lista de estados
	 */
	public ArrayList<Estado> getEstados() {
		// objeto lista para retornar no método
		ArrayList<Estado> estados = buscarTodos();
		return estados;
	}
	
	/*
	 * método para ler o arquivo de estados
	 */
	private ArrayList<Estado> buscarTodos() {
		
		// lista auxiliar para retornar no método
		ArrayList<Estado> estados = new ArrayList<Estado>();
		try {
			// classe scanner auxiliar para ler o arquivo de estados
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no método
				Estado estado = getEstado(leitor.nextLine());
				//atribuindo o objeto estado na lista de retorno
				estados.add(estado);
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		}
		// retornando a lista de estados
		return estados;
	}
	/*
	 * método para retornar um objeto do tipo estado
	 */
	private Estado getEstado(String linha) {
		//variavel auxiliar para converter a linha em objeto
		String aux[] = linha.split(";");
		// retornando o objeto estado
		return new Estado(aux[1], aux[0]);
	}
}
