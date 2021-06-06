package Model;

import java.io.Serializable;

public class Produtos implements Serializable {
	public String nome;
	public Integer cod_barras;
	
	public Produtos (String nomeDoProduto){
		this.nome = nomeDoProduto;
	}
	
	public String toString(){
		return this.cod_barras+"";
	}
}
