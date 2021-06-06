import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Exemplo1Serializacao {
	
	public static void main(String args[]) throws IOException,ClassNotFoundException{
		Escola etec = new Escola();
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		aluno1.setNome("Aluno1");
		aluno2.setNome("Aluno2");
		aluno3.setNome("Aluno3");
		
		etec.matriculaAluno(aluno1);
		etec.matriculaAluno(aluno2);
		etec.matriculaAluno(aluno3);
		
		String fileName = "escolaserializa.ser";
		
		FileOutputStream fileOupStream = null;
		
		File arquivo = new File(fileName);
		
		fileOupStream = new FileOutputStream(arquivo);
		
		ObjectOutputStream outputStream = null;
		
		outputStream = new ObjectOutputStream(fileOupStream);
		
		outputStream.writeObject(etec);
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(arquivo));
		Escola escolaEtecProvenienteDoArquivo = (Escola) objectInputStream.readObject();
		System.out.println(escolaEtecProvenienteDoArquivo.getAlunosMatriculados().size());
		for(Aluno alunoMatriculado : escolaEtecProvenienteDoArquivo.getAlunosMatriculados()){
			System.out.println(alunoMatriculado.getNome());
		}
	}

}
