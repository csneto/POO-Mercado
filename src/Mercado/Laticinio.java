package Mercado;

public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;
	private String refrigeracao;

	public String detalhes () {
		String detalhes = "Categoria: " + super.categoria + "\n";		//coloca a categoria do produto
		detalhes += "Temperatura Refrigerado: " + this.refrigeracao + "C\n";
		return detalhes;
	}
	public Laticinio(String nome, int preco, int quantidade, String _refrigeracao) {
		super(nome, preco, quantidade, "Laticinio", false, _refrigeracao);
		this.refrigeracao = _refrigeracao;
	}
}
