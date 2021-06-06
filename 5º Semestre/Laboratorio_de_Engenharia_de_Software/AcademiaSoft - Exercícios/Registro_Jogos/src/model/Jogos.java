package model;

import java.io.Serializable;

public class Jogos implements Serializable {
	private static final long serialVersionUID = 2918408012096031721L;
	
	private long id;
	private String nome;
	private String dif;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDif() {
		return dif;
	}
	public void setDif(String dif) {
		this.dif = dif;
	}
}
