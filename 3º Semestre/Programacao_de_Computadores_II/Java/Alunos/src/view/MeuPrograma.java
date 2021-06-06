package view;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import persistencia.Imp_PersistirDAO;
import Model.Aluno;
import Model.Escola;
import Model.Professor;
import Model.UsuarioDoSistema;

public class MeuPrograma {
	public static void main (String args[]) throws Exception{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitMysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Aluno a1 = new Aluno("Oséias");
		//a1.setMatricula(1);
		Aluno a2 = new Aluno("Lucas");
		//a2.setMatricula(2);
		Aluno a3 = new Aluno("Sara");
		//a3.setMatricula(3);
		Aluno a4 = new Aluno("Sara");
		Aluno a5 = new Aluno("Julia");
		Aluno a6 = new Aluno("Jessica");
		Aluno a7 = new Aluno("Ingrid");
		
		Professor p1 = new Professor("Wagner");
		Professor p2 = new Professor("Valdeir");
		
		entityManager.persist(a1);
		entityManager.persist(a2);
		entityManager.persist(a3);
		entityManager.persist(a4);
		entityManager.persist(a5);
		entityManager.persist(a6);
		entityManager.persist(a7);
		
		entityManager.persist(p1);
		entityManager.persist(p2);
		
		
		transaction.commit();
		entityManager.clear();
		
		

//		Escola eteczl = new Escola();
//		eteczl.matriculaAluno(a1);
//		eteczl.matriculaAluno(a2);
//		eteczl.matriculaAluno(a3);
//		
//		eteczl.ContrataProfessor(p1);
//		eteczl.ContrataProfessor(p2);
//		
//		a1.andar();
//		a2.andar();
//		p1.andar();
//		p2.andar();
//		Set<Aluno> l = eteczl.ListaMatriculados();
//			for (Aluno a : l){
//				System.out.println(a.getNome());
//			}
//			System.out.println(eteczl.obtemQtdeAlunosMatriculados());
//			
//		MeuPrograma mp = new MeuPrograma();
//		mp.LogarUsuario(a1);
//		
//		Imp_PersistirDAO<Aluno, Aluno> ip = new Imp_PersistirDAO<Aluno, Aluno>();
//		ip.create(a1);
//		ip.read(a1);
//		ip.updat(a1);
//		ip.delete(a1);
//		
//		
	}
	
	public void LogarUsuario(UsuarioDoSistema u){
		u.LogarNoSistema();
	}
}