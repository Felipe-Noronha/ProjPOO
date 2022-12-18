package dominio;

import java.util.ArrayList;

public class Cliente {

	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	
	private ArrayList<Os> listaOs;
	
	
	public Cliente(String cpf) {
		this.cpf = cpf;
		listaOs = new ArrayList<>();
	}
	
	public Cliente(String cpf, String nome, String telefone, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		listaOs = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	
	public void removerOs(int codigo) {
		int i;
		for(i=0; i<listaOs.size(); i++) {
			if(listaOs.get(i).getCodigo()==codigo) {
				listaOs.remove(i);
			}
		}	
	}
	
	public int getTamanhoLista() {
		return listaOs.size();
	}
	
	public Os getOs(int i) {
		return listaOs.get(i);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
