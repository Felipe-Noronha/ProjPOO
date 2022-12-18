package dominio;

import java.util.ArrayList;

public class Os {
	
	private int codigo;
	private String data;
	private float valor;
	private String descricao;
	private int fk_equipamento;
	private String fk_cliente;
	private String fk_funcionario;

	
	public Os(int codigo) {
		this.codigo = codigo;
	}
	
	public Os(int codigo, String data, float valor, String descricao,int fk_equipamento, String fk_cliente, String fk_funcionario) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		this.fk_equipamento = fk_equipamento;
		this.fk_cliente = fk_cliente;
		this.fk_funcionario = fk_funcionario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFk_equipamento() {
		return fk_equipamento;
	}

	public void setFk_equipamento(int fk_equipamento) {
		this.fk_equipamento = fk_equipamento;
	}

	public String getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(String fk_cliente) {
		this.fk_cliente = fk_cliente;
	}

	public String getFk_funcionario() {
		return fk_funcionario;
	}

	public void setFk_funcionario(String fk_funcionario) {
		this.fk_funcionario = fk_funcionario;
	}

	
}
