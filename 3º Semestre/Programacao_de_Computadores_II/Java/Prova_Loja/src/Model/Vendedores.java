package Model;

import java.io.Serializable;

public class Vendedores extends Pessoa implements Serializable {
	public Integer registro;
	public Vendedores (String nomeDoVendedor){
		super(nomeDoVendedor);
	}
	
	public String toString(){
		return this.registro+"";
	}
}
