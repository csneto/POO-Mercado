package Mercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Mercado {
	private ArrayList<Produto> produtos;

	public Mercado() {
		this.produtos = new ArrayList<Produto>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Bebida leBebida (){

		String [] valores = new String [5];
		String [] nomeVal = {"Nome", "Preço", "Quantidade", "Importado [S/N]?", "Teor Alcoolico em %"};
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[1]);
		int quantidade = this.retornaInteiro(valores[2]);
		boolean importado = false;
		if (valores[3].equals("S") || valores[3].equals("s")) importado = true;

		Bebida bebida = new Bebida (valores[0], preco, quantidade, importado, valores[4]);
		return bebida;
	}

	public Laticinio leLaticinio (){

		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Preço", "Quantidade", "Temperatura Armazenagem"};
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[1]);
		int quantidade = this.retornaInteiro(valores[2]);
		
		Laticinio laticinio = new Laticinio(valores[0], preco, quantidade, valores[3]);
		return laticinio;
	}

	public Limpeza leLimpeza (){

		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Preço", "Quantidade", "Toxico [S/N]"};
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[1]);
		int quantidade = this.retornaInteiro(valores[2]);
		boolean toxico = false;
		if (valores[3].equals("S") || valores[3].equals("s")) toxico = true;
		
		Limpeza limpeza = new Limpeza(valores[0], preco, quantidade, toxico);
		return limpeza;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		//int numInt;

		//Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um numero inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaProdutos (ArrayList<Produto> produtos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\mercado.dados"));
			for (int i=0; i < produtos.size(); i++)
				outputStream.writeObject(produtos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Produto> recuperaProdutos (){
		ArrayList<Produto> produtosTemp = new ArrayList<Produto>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\Mercado.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Produto) {
					produtosTemp.add((Produto) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com produtos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return produtosTemp;
		}
	}

	public void menuMercado (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Mercado\n" +
					"Opções:\n" + 
					"1. Entrar Produtos\n" +
					"2. Exibir Produtos\n" +
					"3. Limpar Produtos\n" +
					"4. Gravar Produtos\n" +
					"5. Recuperar Produtos\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Produtos\n" +
						"Opções:\n" + 
						"1. Bebida\n" +
						"2. Laticinio\n"+
						"3. Limpeza\n";
						

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: produtos.add((Produto)leBebida());
				break;
				case 2: produtos.add((Produto)leLaticinio());
				break;
				case 3: produtos.add((Produto)leLimpeza());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Produto para entrada NÃO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com um produto primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < produtos.size(); i++)	{
					dados += produtos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com um produto primeiramente");
					break;
				}
				produtos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com um produto primeiramente");
					break;
				}
				salvaProdutos(produtos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				produtos = recuperaProdutos();
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Mercado");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		Mercado mercado = new Mercado ();
		mercado.menuMercado();

	}

}
