package Model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity

public class Professor extends Pessoa implements UsuarioDoSistema, Serializable{
	public Professor (String nomeDoProfessor){
		super(nomeDoProfessor);
	}
	
	public boolean LogarNoSistema(){
		System.out.println("Professor logou no sistema");
		return false;
	}
	
	public String toString(){
		return this.nome + "";
	}
}
