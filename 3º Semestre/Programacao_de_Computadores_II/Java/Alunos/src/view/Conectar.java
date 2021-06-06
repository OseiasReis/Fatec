package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Aluno;
import Model.Escola;
import Model.Professor;
import persistencia.IGenericDAO;
import persistencia.JDBCDAO;

public class Conectar {
public static void main (String args[]) throws Exception{
		
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitMysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Aluno a1 = new Aluno("Oséias");
		a1.setMatricula(11111111);
		//a1.setid_escola(12345678);
		Aluno a2 = new Aluno("Lucas");
		a2.setMatricula(22222222);
		Aluno a3 = new Aluno("Sara");
		a3.setMatricula(33333333);
		Aluno a4 = new Aluno("Isabella");
		a4.setMatricula(44444444);
		Aluno a5 = new Aluno("Julia");
		a5.setMatricula(55555555);
		Aluno a6 = new Aluno("Jessica");
		a6.setMatricula(66666666);
		Aluno a7 = new Aluno("Ingrid");
		a7.setMatricula(77777777);
		
		Professor p1 = new Professor("Wagner");
		Professor p2 = new Professor("Valdeir");
		Professor p3 = new Professor("Carlos");
		Professor p4 = new Professor("Pimba");
		Professor p5 = new Professor("Upa Lelê");
		Professor p6 = new Professor("Jeferson");
		Professor p7 = new Professor("Emilia");
		Professor p8 = new Professor("Bianca");
		
		Escola e1 = new Escola();
		e1.setRegistro(12345678);
		e1.setNome("Etec Zona Leste");
		e1.matriculaAluno(a1);
		
		Escola e2 = new Escola();
		e2.setRegistro(23456789);
		e2.setNome("Adelaide Ferraz de Oliveira");		
		e2.matriculaAluno(a2);
		
		Escola e3 = new Escola();
		e3.setRegistro(34567891);
		e3.setNome("Revendo Urbando de Oliveira P.");
		e3.matriculaAluno(a3);
		
		Escola e4 = new Escola();
		e4.setRegistro(45678910);
		e4.setNome("Prof. Maestro Alex Martins Costa");
		e4.matriculaAluno(a4);
		
		//escola
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(e3);
		entityManager.persist(e4);
		
		//alunos
		entityManager.persist(a1);
		entityManager.persist(a2);
		entityManager.persist(a3);
		entityManager.persist(a4);
		entityManager.persist(a5);
		entityManager.persist(a6);
		entityManager.persist(a7);
		
		//professor
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.persist(p4);
		entityManager.persist(p5);
		entityManager.persist(p6);
		entityManager.persist(p7);
		entityManager.persist(p8);
		
	
		transaction.commit();
		entityManager.clear();*/
	
		IGenericDAO<Aluno, Integer> dao = new JDBCDAO<Aluno, Integer>(Aluno.class);
		
		Aluno a1 = new Aluno("Oséias");
		a1.setMatricula(1111);
		//a1.setid_escola(12345678);
		Aluno a2 = new Aluno("Lucas");
		a2.setMatricula(2222);
		Aluno a3 = new Aluno("Sara");
		a3.setMatricula(3333);
		Aluno a4 = new Aluno("Isabella");
		a4.setMatricula(4444);
		Aluno a5 = new Aluno("Julia");
		a5.setMatricula(5555);
		Aluno a6 = new Aluno("Jessica");
		a6.setMatricula(6666);
		Aluno a7 = new Aluno("Ingrid");
		a7.setMatricula(7777);
		
		dao.create(a1);
		dao.create(a2);
		dao.create(a3);
		dao.create(a4);
		dao.create(a5);
		dao.create(a6);
		dao.create(a7);
	}
}
