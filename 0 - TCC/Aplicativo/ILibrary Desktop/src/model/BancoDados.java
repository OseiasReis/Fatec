package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BancoDados implements Serializable {

	private String usuario, senha, serverName, bancoDados;
	
	public BancoDados(String serverName, String bancoDados, String usuario, String senha) {
		this.serverName = serverName;
		this.bancoDados = bancoDados;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getServerName() {
		return serverName;
	}

	public String getBancoDados() {
		return bancoDados;
	}
}
