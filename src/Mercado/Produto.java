package Mercado;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nome;
	private   float preco;
	private   int quantidade;
	protected String tipo;
	
	public Produto(String nome, int preco, int quantidade, String tipo) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Preço: R$"    + this.preco    + " anos\n";
		retorno += "Quantidade: "     + this.quantidade     + " unidades\n";
		retorno += "Tipo: "  + this.tipo  + "\n";
		return retorno;
	}
}
