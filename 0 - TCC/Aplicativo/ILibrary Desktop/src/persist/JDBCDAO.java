package persist;

import java.io.Serializable;
import java.util.ArrayList;
import model.Acervo;
import model.Classificacao;
import model.Cliente;
import model.Devolucao;
import model.Emprestimo;
import model.Exemplar;
import model.Localizacao;
import model.Operador;
import persist.jdbc.JDBCAcervo;
import persist.jdbc.JDBCClassificacao;
import persist.jdbc.JDBCCliente;
import persist.jdbc.JDBCDevolucao;
import persist.jdbc.JDBCEmprestimo;
import persist.jdbc.JDBCExemplar;
import persist.jdbc.JDBCLocalizacao;
import persist.jdbc.JDBCOperador;

public class JDBCDAO<E, PK extends Serializable> implements IGenericDAO<E, PK> {

	@SuppressWarnings("rawtypes")
	private Class classe;

	@SuppressWarnings("rawtypes")
	public JDBCDAO(Class classe) {
		this.classe = classe;
	}

	@Override
	public void create(E newInstance) {

		if (newInstance instanceof Cliente) {
			(new JDBCCliente<Cliente, String>()).create((Cliente) newInstance);
		}

		else if (newInstance instanceof Acervo) {
			(new JDBCAcervo<Acervo, String>()).create((Acervo) newInstance);
		}

		else if (newInstance instanceof Operador) {
			(new JDBCOperador<Operador, String>()).create((Operador) newInstance);
		}

		else if (newInstance instanceof Localizacao) {
			(new JDBCLocalizacao<Localizacao, String>()).create((Localizacao) newInstance);
		}

		else if (newInstance instanceof Classificacao) {
			(new JDBCClassificacao<Classificacao, String>()).create((Classificacao) newInstance);
		}

		else if (newInstance instanceof Exemplar) {
			(new JDBCExemplar<Exemplar, String>()).create((Exemplar) newInstance);
		}

		else if (newInstance instanceof Emprestimo) {
			(new JDBCEmprestimo<Emprestimo, String>()).create((Emprestimo) newInstance);
		}

		else if (newInstance instanceof Devolucao) {
			(new JDBCDevolucao<Devolucao, String>()).create((Devolucao) newInstance);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {

		if (classe.getSimpleName().equals("Cliente")) {
			return (E) ((new JDBCCliente<Cliente, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Acervo")) {
			return (E) ((new JDBCAcervo<Acervo, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Operador")) {
			return (E) ((new JDBCOperador<Operador, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Localizacao")) {
			return (E) ((new JDBCLocalizacao<Localizacao, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Classificacao")) {
			return (E) ((new JDBCClassificacao<Classificacao, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Exemplar")) {
			return (E) ((new JDBCExemplar<Exemplar, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Emprestimo")) {
			return (E) ((new JDBCEmprestimo<Emprestimo, String>()).read((String) pk));
		}

		if (classe.getSimpleName().equals("Devolucao")) {
			return (E) ((new JDBCDevolucao<Devolucao, String>()).read((String) pk));
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public E read(PK pk, PK pk2) {

		if (classe.getSimpleName().equals("Emprestimo")) {
			return (E) ((new JDBCEmprestimo<Emprestimo, String>()).read((String) pk, (String) pk2));
		}

		return null;
	}

	@Override
	public void update(E transferObject, PK pk) {

		if (classe.getSimpleName().equals("Cliente")) {
			(new JDBCCliente<Cliente, String>()).update((Cliente) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Acervo")) {
			(new JDBCAcervo<Acervo, String>()).update((Acervo) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Operador")) {
			(new JDBCOperador<Operador, String>()).update((Operador) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Localizacao")) {
			(new JDBCLocalizacao<Localizacao, String>()).update((Localizacao) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Classificacao")) {
			(new JDBCClassificacao<Classificacao, String>()).update((Classificacao) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Exemplar")) {
			(new JDBCExemplar<Exemplar, String>()).update((Exemplar) transferObject, (String) pk);
		}

		if (classe.getSimpleName().equals("Emprestimo")) {
			(new JDBCEmprestimo<Emprestimo, String>()).update((Emprestimo) transferObject, (String) pk);
		}

	}

	@Override
	public void delete(PK pk) {
		if (classe.getSimpleName().equals("Cliente")) {
			(new JDBCCliente<Cliente, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Acervo")) {
			(new JDBCAcervo<Acervo, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Operador")) {
			(new JDBCOperador<Operador, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Localizacao")) {
			(new JDBCLocalizacao<Localizacao, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Classificacao")) {
			(new JDBCClassificacao<Classificacao, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Exemplar")) {
			(new JDBCExemplar<Exemplar, String>()).delete((String) pk);
		}

		if (classe.getSimpleName().equals("Emprestimo")) {
			(new JDBCEmprestimo<Emprestimo, String>()).delete((String) pk);
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<E> readAll(String sql) {

		if (classe.getSimpleName().equals("Exemplar")) {
			return (ArrayList<E>) (new JDBCExemplar<Exemplar, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Acervo")) {
			return (ArrayList<E>) (new JDBCAcervo<Acervo, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Cliente")) {
			return (ArrayList<E>) (new JDBCCliente<Acervo, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Operador")) {
			return (ArrayList<E>) (new JDBCOperador<Operador, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Emprestimo")) {
			return (ArrayList<E>) (new JDBCEmprestimo<Emprestimo, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Devolucao")) {
			return (ArrayList<E>) (new JDBCDevolucao<Devolucao, String>()).readAll(sql);
		}

		if (classe.getSimpleName().equals("Classificacao")) {
			return (ArrayList<E>) (new JDBCClassificacao<Classificacao, String>()).readAll(sql);
		}

		return null;
	}
}