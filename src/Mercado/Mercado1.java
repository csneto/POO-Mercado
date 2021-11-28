package Mercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mercado1 {

	private ArrayList<Produto> produtos;


	public Mercado1( ) {
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionaProduto(Produto mani) {
		this.produtos.add(mani);
	}

	public void listarProdutos() {
		for(Produto mani:produtos) {
			System.out.println(mani.toString());
		}
		System.out.println("Total = " + this.produtos.size() + " produtos listados com sucesso!\n");
	}
	
	public void excluirProduto(Produto mani) {
		if (this.produtos.contains(mani)) {
			this.produtos.remove(mani);
			System.out.println("[Produto " + mani.toString() + "excluido com sucesso!]\n");
		}
		else
			System.out.println("Produto inexistente!\n");
	}

	public void excluirProdutos() {
		produtos.clear();
		System.out.println("Produtos excluidos com sucesso!\n");
	}
	public void gravarProdutos()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\produto.dat"));
			for(Produto mani:produtos) {
				outputStream.writeObject(mani);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void recuperarProdutos() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\produto.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Bebida)  
					this.produtos.add((Bebida)obj);
				else if (obj instanceof Laticinio)  
					this.produtos.add((Laticinio)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Produtos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
