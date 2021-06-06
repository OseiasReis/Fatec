package BDLojaVirtual;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

public class Produto {
	private long id;
	private String nome;
	private String descricao;
	private String categoria;
	private double preco;
	private Date validade;
	private Date dataFabricacao;
	private float peso;
	private List<String> dimensoes;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public List<String> getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(List<String> dimensoes) {
		this.dimensoes = dimensoes;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BufferedImage getPhoto() {
		return photo;
	}
	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
	}
	public double getPosicaoGeoLatitude() {
		return posicaoGeoLatitude;
	}
	public void setPosicaoGeoLatitude(double posicaoGeoLatitude) {
		this.posicaoGeoLatitude = posicaoGeoLatitude;
	}
	public double getPosicaoGeoLongitude() {
		return posicaoGeoLongitude;
	}
	public void setPosicaoGeoLongitude(double posicaoGeoLongitude) {
		this.posicaoGeoLongitude = posicaoGeoLongitude;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	private String unidadeMedida;
	private String fabricante;
	private String modelo;
	private BufferedImage photo;
	private double posicaoGeoLatitude;
	private double posicaoGeoLongitude;
	private double custo;
}
