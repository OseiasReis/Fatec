import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Escola implements Serializable{
	private List<Aluno> alunosMatriculados = new ArrayList<Aluno>();
	
	public List<Aluno> getAlunosMatriculados(){
		return alunosMatriculados;
	}
	public void setAlunosMatriculados(List<Aluno> alunosMatriculados){
		this.alunosMatriculados = alunosMatriculados;
	}
	
	public Integer matriculaAluno(Aluno a){
		this.alunosMatriculados.add(a);
		return this.alunosMatriculados.indexOf(a);
	}
}
