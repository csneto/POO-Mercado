package Mercado;

public class Bebida extends Produto {
	private String teorAlcoolico;
	private boolean importado;
	 
	public boolean isImportado() {
		return importado;
	}

	public Bebida(String nome, int preco, int quantidade) {
		super(nome, preco, quantidade, "Bebida");
		this.teorAlcoolico = "10%";
	}
}
