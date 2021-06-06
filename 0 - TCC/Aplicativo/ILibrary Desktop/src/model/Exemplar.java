package model;

public class Exemplar {

	private String codigo_Exemplar, detalhe, cod_acervo, disponibilidade, preco_compra;
	private Acervo acervo;
	private Boolean emprestado, ativo;

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setCodigo_Exemplar(String codigo_Exemplar) {
		this.codigo_Exemplar = codigo_Exemplar;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(String preco_compra) {
		this.preco_compra = preco_compra;
	}

	public Acervo getAcervo() {
		return acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}

	public String getCodigo_Exemplar() {
		return codigo_Exemplar;
	}

	public Boolean getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(Boolean emprestado) {
		this.emprestado = emprestado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCod_acervo() {
		return cod_acervo;
	}

	public void setCod_acervo(String cod_acervo) {
		this.cod_acervo = cod_acervo;
	}

}
