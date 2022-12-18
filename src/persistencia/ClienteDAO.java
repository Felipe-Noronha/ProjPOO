package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dominio.Cliente;

public class ClienteDAO {

	private Conexao minhaConexao;
	private final String BUSCAR = "select * from cliente where cpf =?";
	private final String INCLUIR = "insert into cliente (cpf,nome,email,telefone) values (?,?,?,?)";
	private final String EXCLUIR = "delete from cliente where cpf = ?";
	private final String ALTERAR = "update cliente set cpf =?, nome =?, email =?, telefone =? where cpf =?";
	
	public ClienteDAO() {
		minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/loja2","postgres","123");
	}
	
	
	
	public Cliente buscar(String cpf) {
		Cliente c = null;
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao =
					minhaConexao.getConexao().prepareStatement(BUSCAR);
			instrucao.setString(1,cpf);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				c = new Cliente(rs.getString("cpf"), rs.getString("nome"), 
						rs.getString("telefone"), rs.getString("email"));
			}
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na busca: "+e.getMessage());
		}
		return c;
	}
	
	public void incluir(Cliente c) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(INCLUIR);
			instrucao.setString(1,c.getCpf());
			instrucao.setString(2,c.getNome());
			instrucao.setString(3,c.getEmail());
			instrucao.setString(4,c.getTelefone());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na inclusao: "+e.getMessage());
		}
	}
	
	public void excluir(String cpf) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(EXCLUIR);
			instrucao.setString(1,cpf);
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na exclusao "+e.getMessage());
		}
	}
	
	public void alterar(Cliente c, String cpfAntigo) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(ALTERAR);
			instrucao.setString(1,c.getCpf());
			instrucao.setString(2,c.getNome());
			instrucao.setString(3,c.getEmail());
			instrucao.setString(4,c.getTelefone());
			instrucao.setString(5,cpfAntigo);
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na alteracao: "+e.getMessage());
		}
	}
	
}
