package Formulario;

public class Livro {
	private String Cod_acervo;
	private String Editora;
	private String Titulo;
	private String Isbn;
	public String getCod_acervo() {
		return Cod_acervo;
	}
	public void setCod_acervo(String cod_acervo) {
		Cod_acervo = cod_acervo;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	@Override
	public String toString() {
		return "Livro [Cod_acervo=" + Cod_acervo + ", Editora=" + Editora + ", Titulo=" + Titulo + ", Isbn=" + Isbn
				+ "]";
	}
	
	
}
