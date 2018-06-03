package negocio;

public class Apartamento {
	
	private int numero;
	private int capacidadeMaxima;
	private double valor;
	private String categoria, descricao;
	
	public Apartamento(int numero, int capacidadeMaxima, double valor, String categoria, String descricao) {
		this.numero = numero;
		this.capacidadeMaxima = capacidadeMaxima;
		this.valor = valor;
		this.categoria = categoria;
		this.descricao = descricao;
	}
	
	public Apartamento() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
		

}
