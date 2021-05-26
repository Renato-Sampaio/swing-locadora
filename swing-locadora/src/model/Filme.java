package model;

/**
 * Classe responsavel por armazenar atributos e métodos do objet filme
 * 
 * @author Renato Sampaio
 * @since 04/03/2021
 * @version 1.0
 */
public class Filme {

	// Método construtor da classe
	public Filme() {

	}

	// Declarando os atributos
	private int codigo;
	private String nome;
	private double valor;
	private boolean disponivel;
	private boolean promocao;
	private double valorPromocao;
	private String genero;
	
	// Métodos getter e setter para acesso aos atributos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	public double getValorPromocao() {
		return valorPromocao;
	}
	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}

