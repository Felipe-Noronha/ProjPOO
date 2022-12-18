package dominio;

import java.util.ArrayList;

public class Funcionario {

	private String cpf;
	private int matricula;
	private String nome;
	private String senha;
	
	private ArrayList<Os> listaOs;
	
	public Funcionario(String cpf, int matricula, String senha) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.senha = senha;
		listaOs = new ArrayList<>();
	}
	
	public Funcionario(String cpf, int matricula, String nome, String senha) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		listaOs = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Os> getListaOs() {
		return listaOs;
	}

	public void setListaOs(ArrayList<Os> listaOs) {
		this.listaOs = listaOs;
	}
	
	public Os consultarOs(int codigo) {
		int i;
		for(i=0; i<listaOs.size(); i++) {
			if(listaOs.get(i).getCodigo()==codigo) {
				return listaOs.get(i);
			}
		}
		return null;
	}
	
	public int getTamanhoLista() {
		return listaOs.size();
	}
	
	public Os getOs(int i) {
		return listaOs.get(i);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
