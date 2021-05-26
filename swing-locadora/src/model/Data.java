package model;

/**
 * Classe para armazenar os atributos e métodos do objeto Data
 * 
 * @author Renato Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class Data {

	// construtor da classe data
	public Data() {
		// TODO Auto-generated constructor stub
	}

	// declarando atributos
	private int dia;
	private int mes;
	private int ano;

	// método para acessar os atributos
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
