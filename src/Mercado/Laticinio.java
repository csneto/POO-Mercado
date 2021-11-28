package Mercado;

public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz Miados";
	}
	public Laticinio(String nome, int preco, int quantidade) {
		super(nome, preco, quantidade, "Laticinio");
		this.tipo = "Laticinio";
	}
}
