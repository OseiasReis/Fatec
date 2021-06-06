package BDLojaVirtual;

import java.util.List;

public class Pedido {
	private long id;
	private Contato contato;
	private List<Produto> produtos;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
