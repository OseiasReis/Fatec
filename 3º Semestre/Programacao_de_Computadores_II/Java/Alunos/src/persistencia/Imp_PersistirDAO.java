package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Model.Aluno;
import Model.Escola;
import Model.Pessoa;
import Model.Professor;

public class Imp_PersistirDAO <T, PK extends Serializable> implements IGenericDAO<T,PK>{
	
	public void create(T newInstance) throws Exception{
	
		FileOutputStream fileOupStream = null;
		File arquivo = new File(newInstance.toString()+".ser");
		fileOupStream = new FileOutputStream(arquivo);
		ObjectOutputStream outputStream = null;
		outputStream = new ObjectOutputStream(fileOupStream);
		outputStream.writeObject(newInstance);
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(arquivo));
	}

	public T read(PK pk) throws Exception {		 
//			Aluno AlunoProvenienteDoArquivo = (Aluno) objectInputStream.readObject();
//			System.out.println(AlunoProvenienteDoArquivo.getAlunosMatriculados().size());
			return null;
	   } 

	public void updat(Object transferObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object persistent) {
		// TODO Auto-generated method stub
		
	}
}