package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Biblioteca implements Serializable{

	private String nome, telefone, endereco, numero, bairro, cidade, estado;
		
	public Biblioteca(String nome, String endereco, String numero, String bairro, String cidade, String estado) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;		
	}

	public String getNome() {
		return nome;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}


	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}


}
