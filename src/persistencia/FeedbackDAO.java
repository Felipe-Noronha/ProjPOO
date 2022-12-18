package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Feedback;

public class FeedbackDAO {
	
	private Conexao minhaConexao;
	private final String INCLUIR = "insert into feedback(data,comentario) values (?,?)";
	private final String RELATORIO = "select * from feedback";
	
	public FeedbackDAO() {
		minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/loja2","postgres","123");
	}
	
	
	public void incluir(Feedback f) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(INCLUIR);
			instrucao.setString(1,f.getData());
			instrucao.setString(2,f.getComentario());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro na inclusao: "+e.getMessage());
		}
	}
	
	public ArrayList<Feedback> relatorio(){
		ArrayList<Feedback> lista = new ArrayList<>();
		try {
			minhaConexao.conectar();
			Statement instrucao = minhaConexao.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIO);
			while(rs.next()) {
				Feedback feed = new Feedback(rs.getInt("codigo"), rs.getString("data"), rs.getString("comentario"));
				lista.add(feed);
			}
			minhaConexao.desconectar();
		}catch(Exception e) {
			System.out.println("Erro no relatorio "+e.getMessage());
		}
		return lista;
	}
	
	
	
}


