package Model;

import java.util.HashSet;
import java.util.Set;

public class Dominio {
	String nome;
	Set<Vendedores> ListaDeVendedoresRegistrados = new HashSet<Vendedores>();
	
	public void registroVendedor(Vendedores v){
		System.out.println("|Vendedores Registrados | " + v.nome);
		this.ListaDeVendedoresRegistrados.add(v);
	}
	
	public Set<Vendedores> ListaRegistrados(){
		return  this.ListaDeVendedoresRegistrados;
	}
	
	public Integer obtemQtdeVendedoresRegistrados(){
		return this.ListaDeVendedoresRegistrados.size();
	}
	
	Set<Clientes> ListaDeClientes = new HashSet<Clientes>();
	
	public void codigoCliente(Clientes c){
		System.out.println("|Clientes | " + c.nome);
		this.ListaDeClientes.add(c);
	}
}
