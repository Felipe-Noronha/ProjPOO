package dominio;

public class Feedback {

	private int codigo;
	private String data;
	private String comentario;
	
	public Feedback() {
		
	}
	
	public Feedback(int codigo,String data, String comentario) {
		this.codigo = codigo;
		this.data = data;
		this.comentario = comentario;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
