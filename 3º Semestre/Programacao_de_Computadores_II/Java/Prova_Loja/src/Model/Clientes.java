package Model;

import java.io.Serializable;

public class Clientes extends Pessoa implements Serializable {
	public Integer codigo;
	public Clientes (String nomeDoCliente){
		super(nomeDoCliente);
	}
	
	public String toString(){
		return this.codigo+"";
	}
}
