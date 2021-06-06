package model;

public class Emprestimo {
	private String cod_emprestimo, registro_cliente, cod_exemplar, data_retirada, hora_retirada, data_devolucao,
			registro_operador;
	private Operador operador;
	private Exemplar exemplar;
	private Cliente cliente;
	private Boolean devolvido;

	public String getCod_emprestimo() {
		return cod_emprestimo;
	}

	public String getRegistro_operador() {
		return registro_operador;
	}

	public void setRegistro_operador(String registro_operador) {
		this.registro_operador = registro_operador;
	}

	public void setCod_emprestimo(String cod_emprestimo) {
		this.cod_emprestimo = cod_emprestimo;
	}

	public String getRegistro_cliente() {
		return registro_cliente;
	}

	public void setRegistro_cliente(String registro_cliente) {
		this.registro_cliente = registro_cliente;
	}

	public String getCod_exemplar() {
		return cod_exemplar;
	}

	public void setCod_exemplar(String cod_exemplar) {
		this.cod_exemplar = cod_exemplar;
	}

	public String getData_retirada() {
		return data_retirada;
	}

	public void setData_retirada(String data_retirada) {
		this.data_retirada = data_retirada;
	}

	public String getHora_retirada() {
		return hora_retirada;
	}

	public void setHora_retirada(String hora_retirada) {
		this.hora_retirada = hora_retirada;
	}

	public String getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getDevolvido() {
		return devolvido;
	}

	public void setDevolvido(Boolean devolvido) {
		this.devolvido = devolvido;
	}
}
