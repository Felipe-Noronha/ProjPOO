package visao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.Cliente;
import dominio.Feedback;
import dominio.Funcionario;
import dominio.Os;
import persistencia.ClienteDAO;
import persistencia.FeedbackDAO;
import persistencia.FuncionarioDAO;
import persistencia.OsDAO;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int op,op2,op3,i,codigoAux,matriculaAux;
		String cpfAux,mensagem,data,senhaAux;
		ArrayList<Feedback> listaFeed = new ArrayList<>();
		Cliente c;
		ClienteDAO cDAO = new ClienteDAO();
		Os o;
		OsDAO oDAO = new OsDAO();
		Feedback feed;
		FeedbackDAO feedDAO = new FeedbackDAO();
		Funcionario f;
		FuncionarioDAO fDAO = new FuncionarioDAO();
		
		
		do {
			System.out.println("----MENU PRINCIPAL----");
			System.out.println("1 - CLIENTE");
			System.out.println("2 - FUNCIONARIO");
			System.out.println("3 - SAIR");
			System.out.println("-----------------------");
			op = teclado.nextInt();
			teclado.nextLine();
			
			switch(op) {
			case 1:
					System.out.println("Digite seu CPF:");
					cpfAux = teclado.nextLine();
					c = cDAO.buscar(cpfAux);
					if(c==null) {
						System.out.println("Cliente nao existe!");
					}else {
						System.out.println("Cliente localizado!");
						System.out.println("----MENU CLIENTE----");
						System.out.println("1 - CONSULTAR ORDEM DE SERVICO");
						System.out.println("2 - DEIXAR FEEDBACK");
						System.out.println("3 - VOLTAR AO MENU PRINCIPAL");
						System.out.println("-------------------");
						op2 = teclado.nextInt();
						teclado.nextLine();
						c.setListaOs(oDAO.buscarOsPorCliente(c.getCpf()));
						switch(op2) {
						case 1:
								System.out.println("Buscando ordem de servico...");
								for(i=0; i<c.getTamanhoLista();i++) {
									System.out.println("-------------------------------------");
									System.out.println("Data: "+c.getOs(i).getCodigo());
									System.out.println("Data: "+c.getOs(i).getValor());
									System.out.println("Data: "+c.getOs(i).getDescricao());
									System.out.println("Data: "+c.getOs(i).getFk_equipamento());
									System.out.println("Data: "+c.getOs(i).getFk_funcionario());
									System.out.println("-------------------------------------");
								}
								System.out.println("Fim da lista de ordens de servico...");	
							break;
						case 2:
								System.out.println("Deixando Feedback...");
								feed = new Feedback();
								
								System.out.println("Digite a mensagem desejada:");
								mensagem = teclado.nextLine();
								feed.setComentario(mensagem);
								System.out.println("Digite a data:");
								data = teclado.nextLine();
								feed.setData(data);
								feedDAO.incluir(feed);
								System.out.println("Mensagem Enviada com Sucesso!");
							break;
						}
					}
				
				
				break;
			case 2:
					System.out.println("Digite a matricula:");
					matriculaAux = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Digite a senha:");
					senhaAux = teclado.nextLine();
					f = fDAO.buscar(matriculaAux,senhaAux);
					try {
						if(senhaAux.equalsIgnoreCase(f.getSenha())) {
							System.out.println("Bem vindo "+f.getNome()+"!");
							System.out.println("----MENU FUNCIONARIO----");
							System.out.println("1 - INCLUIR CLIENTE");
							System.out.println("2 - ALTERAR CLIENTE");
							System.out.println("3 - EXCLUIR CLIENTE");
							System.out.println("4 - BUSCAR CLIENTE");
							System.out.println("5 - INCLUIR ORDEM DE SERVICO");
							System.out.println("6 - ALTERAR ORDEM DE SERVICO");
							System.out.println("7 - EXCLUIR ORDEM DE SERVICO");
							System.out.println("8 - BUSCAR ORDEM DE SERVICO");
							System.out.println("9 - RELATORIO DE FEEDBACK");
							System.out.println("10 - VOLTAR AO MENU PRINCIPAL");
							System.out.println("------------------------");
							op2 = teclado.nextInt();
							teclado.nextLine();
							switch(op2) {
							case 1:
									System.out.println("Incluindo Cliente...");
									System.out.println("Digite o CPF do cliente:");
									cpfAux = teclado.nextLine();
									c = cDAO.buscar(cpfAux);
									if(c==null) {
										c = new Cliente(cpfAux);
										System.out.println("Digite o nome do cliente:");
										c.setNome(teclado.nextLine());
										System.out.println("Digite o email do cliente:");
										c.setEmail(teclado.nextLine());
										System.out.println("Digite o telefone do cliente:");
										c.setTelefone(teclado.nextLine());
										cDAO.incluir(c);
										System.out.println("Cliente incluido com sucesso!");
									}else {
										System.out.println("Cliente ja cadastrado!");
									}
								
								break;
								
							case 2:
									System.out.println("Alterando cliente...");
									System.out.println("Digite o CPF do Cliente desejado:");
									cpfAux = teclado.nextLine();
									c = cDAO.buscar(cpfAux);
									if(c==null) {
										System.out.println("Cliente nao cadastrado!");
									}else {
										System.out.println("Cliente localizado!");
										System.out.println("Nome: "+c.getNome());
										System.out.println("E-mail: "+c.getEmail());
										System.out.println("Telefone: "+c.getTelefone());
										System.out.println("Digite o novo CPF:");
										c.setCpf(teclado.nextLine());
										System.out.println("Digite o novo nome:");
										c.setNome(teclado.nextLine());
										System.out.println("Digite o novo e-mail:");
										c.setEmail(teclado.nextLine());
										System.out.println("Digite o novo telefone:");
										c.setTelefone(teclado.nextLine());
										cDAO.alterar(c,cpfAux);
										System.out.println("Alteracao realizada com sucesso!");
									}
								
								break;
								
							case 3:
									System.out.println("Excluindo cliente...");
									System.out.println("Digite o CPF do cliente:");
									cpfAux = teclado.nextLine();
									c = cDAO.buscar(cpfAux);
									if(c==null) {
										System.out.println("Cliente nao existe!");
									}else {
										System.out.println("Cliente localizado!");
										System.out.println("Nome: "+c.getNome());
										System.out.println("E-mail:"+c.getEmail());
										System.out.println("Telefone:"+c.getTelefone());
										
										c.setListaOs(oDAO.buscarOsPorCliente(c.getCpf()));
										if(c.getListaOs().size()!=0) {
											System.out.println("Este cliente possui ordens de servico");
										}
										System.out.println("Deseja proseguir com a exclusao 1- SIM 2 - NAO?");
										
										if(teclado.nextInt()==1) {
											if(c.getListaOs()!=null) {
												oDAO.exclusaoEmCascata(c.getCpf());
												c.setListaOs(null);
											}
											
											cDAO.excluir(c.getCpf());
											c = null;
											System.out.println("Exclusao efetuada com sucesso!");
										}else {
											System.out.println("Exclusao cancelada!");
										}
									}
								break;
								
							case 4:
									System.out.println("Buscando Cliente...");
									System.out.println("Digite o CPF do cliente:");
									cpfAux = teclado.nextLine();
									c = cDAO.buscar(cpfAux);
									if(c==null) {
										System.out.println("Cliente nao cadastrado!");
									}else {
										System.out.println("Cliente localizado!");
										System.out.println("Nome: "+c.getNome());
										System.out.println("Telefone: "+c.getTelefone());
										System.out.println("E-mail: "+c.getEmail());
										System.out.println("Numero de Os: "+c.getTamanhoLista());
									}
								
								break;
								
							case 5:
								   System.out.println("Incluindo Ordem de servico...");
								   System.out.println("Digite o codigo da ordem de servico:");
								   codigoAux = teclado.nextInt();
								   teclado.nextLine();
								   o = oDAO.buscar(codigoAux);
								   if(o==null) {
										o = new Os(codigoAux);
										System.out.println("Digite a data:");
										o.setData(teclado.nextLine());
										System.out.println("Digite o valor:");
										o.setValor(teclado.nextFloat());
										teclado.nextLine();
										System.out.println("Digite a descricao:");
										o.setDescricao(teclado.nextLine());
										System.out.println("Digite qual o codigo do equipamento:");
										o.setFk_equipamento(teclado.nextInt());
										teclado.nextLine();
										System.out.println("Digite o CPF do Cliente:");
										o.setFk_cliente(teclado.nextLine());
										System.out.println("Digite o CPF do Funcionario:");
										o.setFk_funcionario(teclado.nextLine());
										oDAO.incluir(o, o.getFk_cliente());
										System.out.println("Ordem de servico incluida com sucesso!");
										
									}else {
										System.out.println("Ordem de servico ja cadastrada!");
									}
								   
								break;
							case 6:
								 System.out.println("Alterando ordem de servico...");
								 System.out.println("Digite o codigo da ordem de servico desejada:");
								 codigoAux = teclado.nextInt();
								 teclado.nextLine();
								 o = oDAO.buscar(codigoAux);
								 if(o==null) {
									 System.out.println("Ordem de servico nao existe!");
								 }else {
									 System.out.println("Ordem de servico localizada!");
									 System.out.println("Ordem localizada!");
									 System.out.println("Data: "+o.getData());
									 System.out.println("Valor: "+o.getValor());
									 System.out.println("Descricao: "+o.getDescricao());
									 System.out.println("Codigo do equipamento: "+o.getFk_equipamento());
									 System.out.println("CPF do cliente: "+o.getFk_cliente());
									 System.out.println("CPF do funcionario: "+o.getFk_funcionario());
									 
									 System.out.println("Digite o novo codigo da ordem de servico:");
									 o.setCodigo(teclado.nextInt());
									 teclado.nextLine();
									 System.out.println("Digite a nova data:");
									 o.setData(teclado.nextLine());
									 System.out.println("Digite o novo valor:");
									 o.setValor(teclado.nextFloat());
									 teclado.nextLine();
									 System.out.println("Digite a nova descricao:");
									 o.setDescricao(teclado.nextLine());
									 System.out.println("Digite o novo codigo do equipamento:");
									 o.setFk_equipamento(teclado.nextInt());
									 teclado.nextLine();
									 System.out.println("Digite o novo CPF do cliente:");
									 o.setFk_cliente(teclado.nextLine());
									 System.out.println("Digite o novo CPF do funcionario");
									 o.setFk_funcionario(teclado.nextLine());
									 oDAO.alterar(o, codigoAux);
									 System.out.println("Alteracao realizada com sucesso!");
								 }	 		
								break;
								
							case 7:
								System.out.println("Excluindo ordem de servico...");
								System.out.println("Digite o codigo da ordem de servico:");
								codigoAux = teclado.nextInt();
								teclado.nextLine();
								o = oDAO.buscar(codigoAux);
								if(o==null) {
									System.out.println("Ordem de servico nao existe!");
								}else{
									System.out.println("Ordem localizada!");
									System.out.println("Data: "+o.getData());
									System.out.println("Valor: "+o.getValor());
									System.out.println("Descricao: "+o.getDescricao());
									System.out.println("Codigo do equipamento: "+o.getFk_equipamento());
									System.out.println("CPF do cliente: "+o.getFk_cliente());
									System.out.println("CPF do funcionario: "+o.getFk_funcionario());
								}
								System.out.println("1 - EXCLUIR 2 - CANCELAR");
								if(teclado.nextInt()==1) {
									c = cDAO.buscar(o.getFk_cliente());
									c.removerOs(codigoAux);
									oDAO.excluir(o);
									System.out.println("Ordem de servico excluida com sucesso!");
									
								}else {
									System.out.println("Exclusao cancelada!");
								}	
								break;
								
							case 8:
								System.out.println("Buscando ordem de servico...");
								System.out.println("Digite o codigo da ordem de servico desejada:");
								codigoAux = teclado.nextInt();
								o = oDAO.buscar(codigoAux);
								if(o==null) {
									System.out.println("Ordem de servico nao existe!");
								}else {
									System.out.println("Ordem localizada!");
									System.out.println("Data: "+o.getData());
									System.out.println("Valor: "+o.getValor());
									System.out.println("Descricao: "+o.getDescricao());
									System.out.println("Codigo do equipamento: "+o.getFk_equipamento());
									System.out.println("CPF do cliente: "+o.getFk_cliente());
									System.out.println("CPF do funcionario: "+o.getFk_funcionario());
								}
								
								break;
							case 9:
								System.out.println("Relatorio de feedback...");
								listaFeed = feedDAO.relatorio();
								for(i=0; i<listaFeed.size();i++) {
									System.out.println("-------------------------------");
									System.out.println("Data: "+listaFeed.get(i).getData());
									System.out.println("Comentario: "+listaFeed.get(i).getComentario());
								}
								System.out.println("Fim do relatorio...");
								break;
							case 10:
								System.out.println("Voltando ao menu principal...");
								break;
							}
							
						}else{
							System.out.println("Informacoes incorretas!");
						}
					}catch(Exception e) {
						System.out.println("Informacoes incorretas!");
					}
							break;
			}
			
		}while(op!=3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
