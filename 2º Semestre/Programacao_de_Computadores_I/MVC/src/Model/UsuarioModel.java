package Model;

public class UsuarioModel {
	private String Nome;
	private String Endereco;
	private String Bairro;
	private int Cep;
	private String Cidade;
	private String Estado;
	
	public void setNome(String nome){
		this.Nome = nome;
	}
	public String getNome(){
		return Nome;
	}
	
	
	public void setEndereco(String endereco){
		this.Endereco = endereco;
	}
	public String getEndereco(){
		return Endereco;
	}
	
	
	public void setBairro(String bairro){
		this.Bairro = bairro;
	}
	public String getBairro(){
		return Bairro;
	}
	
	
	public void setCep(int cep){
		this.Cep = cep;
	}
	public int getCep(){
		return Cep;
	}
	
	
	public void setCidade(String cidade){
		this.Cidade = cidade;
	}
	public String getCidade(){
		return Cidade;
	}
	
	
	public void setEstado(String estado){
		this.Estado = estado;
	}
	public String getEstado(){
		return Estado;
	}
}
