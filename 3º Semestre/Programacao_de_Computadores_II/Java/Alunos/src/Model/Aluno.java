package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa implements UsuarioDoSistema, Serializable{
	
	
	private Integer matricula;
	public Aluno (String nomeDoAluno){		
		super(nomeDoAluno);
		nome=nomeDoAluno;
	}
	
	@ManyToOne
	private Escola escola;
	
	/*private Escola escola;
	
	public Escola getEscola(){
		return escola;
	}
	
	public void setEscola(Escola escola){
		this.escola = escola;
	}*/
	
	public void setAluno(String nomeDoAluno) {
		this.nome = nomeDoAluno;
	}
	
	public boolean LogarNoSistema(){
		System.out.println("Aluno logou no sistema");
		return false;
	}
	
	public String toString(){
		return this.matricula+"";
	}

	public int hashCode() {
		return  2;
	}

	public boolean equals(Object obj) {		
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula) {
			return false;
		}
		return true;
	}
	
	public boolean equals1(Object nom) {		
		Aluno other = (Aluno) nom;
		if (nome != other.nome) {
			return false;
		}
		return true;
	}
	
	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}
	
	
	
//	public Integer getid_escola() {
//		return id_escola;
//	}
//
//	public void setid_escola(Integer id_escola) {
//		this.id_escola = id_escola;
//	}
}