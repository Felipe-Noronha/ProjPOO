package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.Os;

public class OsDAO {
	
	private Conexao minhaConexao;
	
	private final String BUSCAR = "select * from os where codigo = ?";
	private final String RELATORIO = "select * from os where fk_cliente = ?";
	private final String EXCLUIRCASCATA = "delete from os where  fk_cliente = ?";
	private final String INCLUIR = "insert into os (codigo,data,valor,descricao,fk_equipamento,fk_cliente,fk_funcionario) values (?,?,?,?,?,?,?)";
	private final String ALTERAR = "update os set codigo = ?, data =?, valor = ?, descricao = ?, fk_equipamento = ?, fk_cliente = ?, fk_funcionario = ? where codigo = ?";
	private final String EXCLUIR = "delete from os where codigo = ?";
	
	public OsDAO() {
		minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/loja2","postgres","123");
	}
	
	
	
	public Os buscar(int codigo) {
		Os o = null;
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(BUSCAR);
			instrucao.setInt(1,codigo);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				o = new Os(rs.getInt("codigo"), rs.getString("data"), rs.getFloat("valor"), rs.getString("descricao"), rs.getInt("fk_equipamento"), rs.getString("fk_cliente"), rs.getString("fk_funcionario"));
			}
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na busca: "+e.getMessage());
		}
		return o;
	}
	
	public ArrayList<Os> buscarOsPorCliente(String cpf){
		ArrayList<Os> lista = new ArrayList<>();
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(RELATORIO);
			instrucao.setString(1,cpf);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Os o = new Os(rs.getInt("codigo"), rs.getString("data"), rs.getFloat("valor"), rs.getString("descricao"), rs.getInt("fk_equipamento"), rs.getString("fk_cliente"), rs.getString("fk_funcionario"));
			lista.add(o);
			}
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na busca: "+e.getMessage());
		}
		return lista;
	}
	
	public void exclusaoEmCascata(String cpf) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(EXCLUIRCASCATA);
			instrucao.setString(1,cpf);
			instrucao.execute();
			minhaConexao.desconectar();
			
		}catch(Exception e) {
			System.out.println("Erro na exclusao "+e.getMessage());
		}
	}
	
	public void incluir(Os o, String cpf) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(INCLUIR);
			instrucao.setInt(1, o.getCodigo());
			instrucao.setString(2,o.getData());
			instrucao.setFloat(3,o.getValor());
			instrucao.setString(4,o.getDescricao());
			instrucao.setInt(5,o.getFk_equipamento());
			instrucao.setString(6,o.getFk_cliente());
			instrucao.setString(7,o.getFk_funcionario());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na inclusao"+e.getMessage());
		}
	}
	
	public void alterar(Os o, int codigoAntigo) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(ALTERAR);
			instrucao.setInt(1, o.getCodigo());
			instrucao.setString(2,o.getData());
			instrucao.setFloat(3,o.getValor());
			instrucao.setString(4,o.getDescricao());
			instrucao.setInt(5,o.getFk_equipamento());
			instrucao.setString(6,o.getFk_cliente());
			instrucao.setString(7,o.getFk_funcionario());
			instrucao.setInt(8,codigoAntigo);
			instrucao.execute();
			minhaConexao.desconectar();		
		}catch(Exception e) {
			System.out.println("Erro na alteracao: "+e.getMessage());
		}
	}
	
	public void excluir(Os o) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(EXCLUIR);
			instrucao.setInt(1,o.getCodigo());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na exclusao: "+e.getMessage());
		}
	}
	
}
