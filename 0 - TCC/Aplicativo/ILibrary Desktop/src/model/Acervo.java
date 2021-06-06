package model;

import java.io.InputStream;

public class Acervo {

	private String codigo_acervo, titulo, subtitulo, cod_classificacao, editora, edicao, volume, autor, local, isbn, dimensoes, resumo, material, paginas, ano, idioma;
	private InputStream imagem;
	private Classificacao classificacao;
		
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
		
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getCod_classificacao() {
		return cod_classificacao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public InputStream getImagem() {
		return imagem;
	}

	public void setImagem(InputStream imagem) {
		this.imagem = imagem;
	}

	public void setCod_classificacao(String cod_classificacao) {
		this.cod_classificacao = cod_classificacao;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCodigo_acervo() {
		return codigo_acervo;
	}

	public void setCodigo_acervo(String codigo_acervo) {
		this.codigo_acervo = codigo_acervo;
	}			
}
