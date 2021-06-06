package model;

public class Devolucao {

	private String cod_emprestimo, data_entrega, hora_entrega, termino_suspensao, registro_operador;
	private Double preco_multa;
	private Emprestimo emprestimo;

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getCod_emprestimo() {
		return cod_emprestimo;
	}

	public void setCod_emprestimo(String cod_emprestimo) {
		this.cod_emprestimo = cod_emprestimo;
	}

	public String getRegistro_operador() {
		return registro_operador;
	}

	public void setRegistro_operador(String registro_operador) {
		this.registro_operador = registro_operador;
	}

	public String getTermino_suspensao() {
		return termino_suspensao;
	}

	public void setTermino_suspensao(String termino_suspensao) {
		this.termino_suspensao = termino_suspensao;
	}

	public String getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(String data_entrega) {
		this.data_entrega = data_entrega;
	}

	public String getHora_entrega() {
		return hora_entrega;
	}

	public void setHora_entrega(String hora_entrega) {
		this.hora_entrega = hora_entrega;
	}

	public Double getPreco_multa() {
		return preco_multa;
	}

	public void setPreco_multa(Double preco_multa) {
		this.preco_multa = preco_multa;
	}
}
