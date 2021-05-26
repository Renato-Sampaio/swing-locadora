
package controller;

import javax.swing.UIManager;

import view.MenuPrincipalView;

/**
 * Classe Principal para executar o Projeto.
 * 
 * @author Renato Duarte Sampaio
 * @since 08/03/2021
 * @version 1.0
 */
public class Main {
	/*
	 * Metodo principal para executar a classe.
	 */
	public static void main(String[] args) {
		/*
		 * Configurando o estilo inicial do projeto.
		 */
		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		// iniciando o menu principal
		new MenuPrincipalView().iniciaGui();
	}

}
