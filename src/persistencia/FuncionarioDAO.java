package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Funcionario;




public class FuncionarioDAO {
	
	private Conexao minhaConexao;
	private String BUSCAR = "select * from funcionario where matricula = ? and senha = ?";
	
	public FuncionarioDAO() {
		minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/loja2","postgres","123");
	}
	
	
	public Funcionario buscar(int matriculaAux, String senhaAux) {
		Funcionario f = null;
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao =
					minhaConexao.getConexao().prepareStatement(BUSCAR);
			instrucao.setInt(1,matriculaAux);
			instrucao.setString(2,senhaAux);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				f = new Funcionario(rs.getString("cpf"), rs.getInt("matricula"), 
						rs.getString("nome"), rs.getString("senha"));
			}
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na busca: "+e.getMessage());
		}
		return f;
	}
	
}
