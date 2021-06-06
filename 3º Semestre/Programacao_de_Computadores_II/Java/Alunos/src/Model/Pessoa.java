package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	@Id
	@GeneratedValue
	public Integer Id;
	public String nome;
	
	Pessoa(String nomeDaPessoa){
		this.nome = nomeDaPessoa;
	}
	
	public void andar(){
		System.out.println("Pessoa " + this.nome + " est� andando");	
	}
	
	public String getNome() {
		return nome;
	}
}
