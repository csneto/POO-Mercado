package Mercado;

public class Bebida extends Produto {
	private String teorAlcoolico;
	private boolean importado;

	public String detalhes () {
		String detalhes = "Tipo: Bebida\n";		//coloca a classificacao do produto
		if (importado) {						//verifica se eh importado
			detalhes += "Produto importado\n";
		} else {
			detalhes += "Produto nacional\n";
		}
		detalhes += "Teor Alcoolico: " + this.teorAlcoolico + "\n";
		return detalhes;
	}
	 
	public boolean isImportado() {
		return importado;
	}

	public Bebida(String nome, int preco, int quantidade) {
		super(nome, preco, quantidade);
		this.teorAlcoolico = "10%";
	}
}
