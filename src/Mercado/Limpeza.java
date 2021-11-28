package Mercado;

public class Limpeza extends Produto {

	private boolean toxico;

	public String detalhes () {
		String detalhes = "Categoria: " + super.categoria + "\n";		//coloca a categoria do produto
		detalhes += isToxico();
		return detalhes;
	}
	 
	public String isToxico() {
		String detalhes;
		if (toxico) {						//verifica se eh importado
			detalhes = "Produto Toxico\n";
		} else {
			detalhes = "Produto Atoxico\n";
		}
		return detalhes;
	}

	public Limpeza(String nome, int preco, int quantidade, boolean _toxico) {
		super(nome, preco, quantidade, "Limpeza",_toxico, "");
		this.toxico = _toxico;
	}
}
