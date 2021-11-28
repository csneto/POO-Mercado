package Mercado;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nome;
	private   float preco;
	private   int quantidade;
	protected String categoria;
	
	public Produto(String nome, int preco, int quantidade, String categoria, boolean _check, String detalhe) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Preço: R$"    + this.preco    + "\n";
		retorno += "Quantidade: "     + this.quantidade     + " unidade(s)\n";
		retorno += detalhes();
		return retorno;
	}

	public abstract String detalhes();
}
