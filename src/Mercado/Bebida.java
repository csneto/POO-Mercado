package Mercado;

public class Bebida extends Produto {
	private String teorAlcoolico;
	private boolean importado;

	public String detalhes () {
		String detalhes = "Categoria: " + super.categoria + "\n";		//coloca a categoria do produto
		detalhes += "Teor Alcoolico: " + this.teorAlcoolico + "\n";
		detalhes += isImportado();
		return detalhes;
	}
	 
	public String isImportado() {
		String detalhes;
		if (importado) {						//verifica se eh importado
			detalhes = "Produto importado\n";
		} else {
			detalhes = "Produto nacional\n";
		}
		return detalhes;
	}

	public Bebida(String nome, int preco, int quantidade, boolean _importado, String _teorAlcoolico) {
		super(nome, preco, quantidade, "Bebida", _importado, _teorAlcoolico);
		this.teorAlcoolico = _teorAlcoolico;
		this.importado = _importado;
	}
}
