package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Penalidade implements Serializable {

	private Double valor_multa;
	private Boolean suspensao_manual, suspensao_automatica, multa, emprestar_suspenso, emprestar_multado;
	private String dias_suspensao;

	public String getDias_suspensao() {
		return dias_suspensao;
	}

	public Boolean getEmprestar_suspenso() {
		return emprestar_suspenso;
	}

	public void setEmprestar_suspenso(Boolean emprestar_suspenso) {
		this.emprestar_suspenso = emprestar_suspenso;
	}

	public Boolean getEmprestar_multado() {
		return emprestar_multado;
	}

	public void setEmprestar_multado(Boolean emprestar_multado) {
		this.emprestar_multado = emprestar_multado;
	}

	public void setDias_suspensao(String dias_suspensao) {
		this.dias_suspensao = dias_suspensao;
	}

	public Boolean getSuspensao_manual() {
		return suspensao_manual;
	}

	public void setSuspensao_manual(Boolean suspensao_manual) {
		this.suspensao_manual = suspensao_manual;
	}

	public Double getValor_multa() {
		return valor_multa;
	}

	public void setValor_multa(Double valor_multa) {
		this.valor_multa = valor_multa;
	}

	public Boolean getSuspensao_automatica() {
		return suspensao_automatica;
	}

	public void setSuspensao_automatica(Boolean suspensao_automatica) {
		this.suspensao_automatica = suspensao_automatica;
	}

	public Boolean getMulta() {
		return multa;
	}

	public void setMulta(Boolean multa) {
		this.multa = multa;
	}

}
