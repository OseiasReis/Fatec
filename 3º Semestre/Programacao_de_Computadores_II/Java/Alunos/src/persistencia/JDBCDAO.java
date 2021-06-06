package persistencia;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import Model.Aluno;
import Model.Professor;

public class JDBCDAO <T, PK extends Serializable> implements IGenericDAO<T,PK>{
	private Connection conn;
	
	{
		this.conn = ConnectionFactory.getConnection();
	}
	
	@SuppressWarnings("rawtypes")
	private Class classe;
	
	@SuppressWarnings("rawtypes")
	public JDBCDAO(Class classe) {
		this.classe = classe;
	}

	public void create(T newInstance) throws Exception {
		if(this.classe.getSimpleName().equals("Aluno")){
			Aluno a = (Aluno) newInstance;
			
			String sql = "Insert into Aluno (matricula,nome) " +
			"values (" + a.getMatricula() + ",'" + a.getNome()+"')";
			
			//Armazena no banco
			PreparedStatement pst = this.conn.prepareStatement(sql);
			pst.executeUpdate();
			
		}
		
		if(this.classe.getSimpleName().equals("Professor")){
			Professor p = (Professor) newInstance;
			
			String sql = "Insert into Professor (nome) " +
			"values ('" + p.getNome() + "')";
			
			PreparedStatement pst = this.conn.prepareStatement(sql);
			pst.executeUpdate();
		}
		
	}

	@Override
	public T read(PK pk) throws Exception {
		if(this.classe.getSimpleName().equals("Aluno")){
			Aluno a = (Aluno) pk;
			String sql="select * from Aluno where matricula ='"+a.getMatricula()+"';";
			try{
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String nome = rs.getString("nome");
					Integer matricula =	rs.getInt("matricula");
					String dados = nome+" : "+matricula;
					return (T) dados;
					}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(this.classe.getSimpleName().equals("Professor")){
			Professor p = (Professor) pk;
			String sql="select * from professor where nome ='"+p.nome+"';";
			try{
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String nome = rs.getString("nome");
					
					return (T) nome;
					}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void updat(T transferObject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T persistent) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
