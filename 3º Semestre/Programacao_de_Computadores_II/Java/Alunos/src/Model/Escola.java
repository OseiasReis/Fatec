package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Escola {
	
	@Id
	public Integer registro;
	public String nome;

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(mappedBy="escola")
	Set<Aluno> ListaDeAlunosMatriculados = new HashSet<Aluno>();
	
//	@OneToMany(mappedBy="escola")
//	List<Aluno> ListaDeAlunosMatriculados = new ArrayList<Aluno>();
	
	
	public void matriculaAluno(Aluno a){
		//System.out.println("|Aluno Matriculado | " + a.getNome());
		this.ListaDeAlunosMatriculados.add(a);
	}
	
	public void ContrataProfessor(Professor p){
		//System.out.println("|Professor Contratado | " + p.getNome());
	}
	

	
	
	public Set<Aluno> getListaDeAlunosMatriculados() {
		return ListaDeAlunosMatriculados;
	}

	public void setListaDeAlunosMatriculados(Set<Aluno> listaDeAlunosMatriculados) {
		ListaDeAlunosMatriculados = listaDeAlunosMatriculados;
	}

	public Set<Aluno> ListaMatriculados(){
		return  this.ListaDeAlunosMatriculados;
	}
	
	
	
	public Integer obtemQtdeAlunosMatriculados(){
		return this.ListaDeAlunosMatriculados.size();
	}
}
