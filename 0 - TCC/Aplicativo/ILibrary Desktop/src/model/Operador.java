package model;

import persist.JDBCDAO;

public class Operador {

	private String privilegio, nome, registro, num, cep, telefone, celular, senha;
	private Localizacao localizacao;
	private Boolean ativo;

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegistro() {
		return registro;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public static Operador logonSistema(String registro, String senha) {

		JDBCDAO<Operador, String> jdbc = new JDBCDAO<Operador, String>(Operador.class);

		Operador operador = jdbc.read(registro);

		if (operador != null && operador.getSenha().equals(senha)) {
			return operador;
		}

		return null;
	}
}
