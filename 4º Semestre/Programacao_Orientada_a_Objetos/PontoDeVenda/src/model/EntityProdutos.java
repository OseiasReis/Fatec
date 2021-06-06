package model;

public class EntityProdutos {
	private int tcCodProd;
	private int qtd;
	private String tcDescricao;
	private double tcVUnit;
	private double total;

	public EntityProdutos() {	}
	
	public EntityProdutos(int tcCodProd, String tcDescricao, double tcVUnit) {
		this.tcCodProd = tcCodProd;
		this.tcDescricao = tcDescricao;
		this.tcVUnit = tcVUnit;
	}
	
	public int getTcCodProd() {
		return tcCodProd;
	}
	public void setTcCodProd(int tcCodProd) {
		this.tcCodProd = tcCodProd;
	}
	public String getTcDescricao() {
		return tcDescricao;
	}
	public void setTcDescricao(String tcDescricao) {
		this.tcDescricao = tcDescricao;
	}
	public double getTcVUnit() {
		return tcVUnit;
	}
	public void setTcVUnit(double tcVUnit) {
		this.tcVUnit = tcVUnit;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
