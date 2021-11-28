package Mercado;

public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;
	private String refrigeracao;

	public String detalhes () {
		String detalhes = "Tipo: Laticinio\n";		//coloca a classificacao do produto
		detalhes += "Temperatura Refrigerado: " + this.refrigeracao + "\n";
		return detalhes;
	}
	public Laticinio(String nome, int preco, int quantidade) {
		super(nome, preco, quantidade);
	}
}
