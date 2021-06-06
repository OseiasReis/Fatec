package persist.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Localizacao;
import persist.ConnectionFactory;
import persist.IGenericDAO;
import persist.JDBCDAO;

public class JDBCCliente<E, PK> implements IGenericDAO<E, PK>{

	private Connection conn;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	{
		conn = ConnectionFactory.getConnection();
	}
	
	private Cliente createCliente(ResultSet rsCliente) throws SQLException {
		
		Localizacao local = new JDBCDAO<Localizacao, String>(Localizacao.class).read(rsCliente.getString("cep"));

		Cliente cliente = new Cliente();
		cliente.setRegistro(rsCliente.getString("registro_cliente"));
		cliente.setNome(rsCliente.getString("nome"));
		cliente.setCelular(rsCliente.getString("celular"));
		cliente.setCep(rsCliente.getString("cep"));	           
		cliente.setTipo(rsCliente.getString("tipo"));
		cliente.setComplemento(rsCliente.getString("complemento"));
		cliente.setData_nasc(rsCliente.getDate("data_nasc"));	  
		cliente.setEmail(rsCliente.getString("email"));
		cliente.setNum_residencia(rsCliente.getString("num_residencia"));
		cliente.setResponsavel(rsCliente.getString("responsavel"));
		cliente.setSexo(rsCliente.getString("sexo"));
		cliente.setTelefone(rsCliente.getString("telefone"));
		cliente.setLocalizacao(local);
		cliente.setMulta_pendente(rsCliente.getDouble("multa_pendente"));
		cliente.setAtivo(rsCliente.getBoolean("ativo"));
		
		return cliente;
	}

	@Override
	public void create(E newInstance) {
		
		String query = "insert into cliente (registro_cliente, tipo, nome, sexo, data_nasc, cep, num_residencia, complemento, telefone, celular, email, responsavel, multa_pendente, ativo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0.00, true)";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			Cliente c = (Cliente) newInstance;
			ps.setString(1, c.getRegistro());
			ps.setString(2, c.getTipo());
			ps.setString(3, c.getNome());
			ps.setString(4, c.getSexo());
			ps.setString(5, sdf.format(c.getData_nasc()));
			ps.setString(6, c.getCep());
			ps.setString(7, c.getNum_residencia());
			ps.setString(8, c.getComplemento());
			ps.setString(9, c.getTelefone());
			ps.setString(10, c.getCelular());
			ps.setString(11, c.getEmail());
			ps.setString(12, c.getResponsavel());	
		
			ps.executeUpdate();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E read(PK pk) {
		
		String query = "select * from cliente where registro_cliente='" + pk + "'";
		
		Statement st;
		ResultSet rsCliente;
		 
			try {
				st = conn.createStatement();
				rsCliente = st.executeQuery(query);
		        
		        if (rsCliente.next()) {
		        	Cliente cliente = createCliente(rsCliente);
			        return (E) cliente;
		        }		 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return null;
           
	}

	@Override
	public void update(E transferObject, PK pk) {
		
		String query = "update cliente set registro_cliente=?, tipo=?, nome=?, sexo=?, data_nasc=?, cep=?, num_residencia=?, complemento=?, telefone=?, celular=?, email=?, responsavel=?, multa_pendente=?, ativo=? where registro_cliente=" + pk;
        
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			Cliente c = (Cliente) transferObject;
			ps.setString(1, c.getRegistro());
			ps.setString(2, c.getTipo());
			ps.setString(3, c.getNome());
			ps.setString(4, c.getSexo());
			ps.setString(5, sdf.format(c.getData_nasc()));
			ps.setString(6, c.getCep());
			ps.setString(7, c.getNum_residencia());
			ps.setString(8, c.getComplemento());
			ps.setString(9, c.getTelefone());
			ps.setString(10, c.getCelular());
			ps.setString(11, c.getEmail());
			ps.setString(12, c.getResponsavel());	
			ps.setDouble(13, c.getMulta_pendente());
			ps.setBoolean(14, c.getAtivo());
		
			ps.executeUpdate();
			ps.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(PK pk) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<E> readAll(String sql) {
		ArrayList<Cliente> lista_cliente = new ArrayList<Cliente>();
		PreparedStatement ps;
		ResultSet rsCliente;
		try {
			ps = conn.prepareStatement(sql);
			rsCliente = ps.executeQuery();
			
			if (rsCliente.next()) {
				lista_cliente.add(createCliente(rsCliente));
				
				while(rsCliente.next()) {
					lista_cliente.add(createCliente(rsCliente));
				}
			}
			
			if(!lista_cliente.isEmpty()) {
				return (ArrayList<E>) lista_cliente;
			}										
		} catch (SQLException e) {
			e.printStackTrace();
		}        			
		
		return null;
	}
}


