package Entidade;

import java.util.Date;

public class Curso {
	private long id;
	private String nome;
	private String descricao;
	private boolean ativo;
	private Date horarioInicio;
	private Date horarioTermino;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Date getHoraInicio() {
		return horarioInicio;
	}
	public void setHoraInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Date getHoraTermino() {
		return horarioTermino;
	}
	public void setHoraTermino(Date horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
}
