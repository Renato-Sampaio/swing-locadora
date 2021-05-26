package util;

/**
 * Classe auxiliar para armazenar métodos de conversão de dados
 * @author Renato Sampaio
 * @since 09/03/2021
 * @version 1.0
 */
public class Util {
	
	/*
	 * Método para converter uma String em inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}
	
	/*
	 * Método para converter uma String em double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}
	
	/*
	 * Método para converter uma String em boolean
	 */
	public static Boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}

}