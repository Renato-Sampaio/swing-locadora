package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Estado
 * 
 * @author Renato Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class Estado {

	// construtor da classe Estado
	public Estado() {

	}

	public Estado(String uf, String estado) {

		this.uf = uf;
		this.estado = estado;
	}

	// declarando atributos
	private String uf;
	private String estado;

	// métodos para acessar os atributos
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	
}
