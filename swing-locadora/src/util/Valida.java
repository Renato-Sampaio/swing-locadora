package util;

/**
 * Classe responsável por armazenar os métodos de validação do projeto
 * 
 * @author Renato Sampaio
 * @since 08/03/2021
 * @version 1.0
 */
public class Valida {
	/*
	 * método para verificar se o campo é diferente de vazio ou nulo
	 */
	public static boolean isEmptyOrNull(String args) {
		// verificando se o argumento está preenchido
		return (args.trim().equals("") || args == null);
	}
	
	/*
	 * método para verificar se o campo é um inteiro
	 */
	public static boolean isInteger(String args) {
		try {
			Integer.parseInt(args);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	/*
	 * método para verificar se o campo é um double
	 */
	public static boolean isDouble(String args) {
		try {
			Double.parseDouble(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
