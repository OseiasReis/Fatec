package Control;

import java.util.List;

import Model.Produto;

public interface Controller {
	public Produto addProduto(Produto produto);

	public Produto attrProduto(long id, Produto produto);

	public long removProduto(long id);

	public List<Produto> pesqNome(String nome);
}
