package Programa;

import java.util.ArrayList;
import java.util.Scanner;

import utilitarios.util;


public class caixa {

	static Scanner teclar = new Scanner(System.in);
	static ArrayList<Contas> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Contas>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("-------------------------------------------");
		System.out.println("-----------Seja bem-vindo a Caixa----------");
		System.out.println("-------------------------------------------");
		System.out.println("-------Como posso ajudar você hoje?--------");
		System.out.println("-------------------------------------------");
		System.out.println("|          Opcão 1 -Criar conta           |");
		System.out.println("|          Opcão 2 -Consultar conta       |");
		System.out.println("|          Opcão 3 -Criar conta associada |");
		System.out.println("|          Opcão 4 -Depositar             |");
		System.out.println("|          Opcão 5 -Sacar                 |");
		System.out.println("|          Opcão 6 -Transferir            |");
		System.out.println("|          Opcão 7 -Consultar Balanço     |");
		System.out.println("|          Opcão 8 -Listar contas         |");
		System.out.println("|          Opcão 9 -Remover conta         |");
		System.out.println("|          Opcão 10 -Sair                 |");
		System.out.println("-------------------------------------------");
		
		int operacao = teclar.nextInt();
		
		switch (operacao){
			case 1:
				criarConta();
				break;
			case 2:
				consultarConta();
				break;
			case 3:
				criarContaEAssociarCliente();
				break;
			case 4:
				depositar();
				break;
			case 5:
				sacar();
				break;
			case 6:
				transferir();
				break;
			//case 7:
				//consultarBalanco
				//break;
			case 8:
				listarContas();
				break;
			case 9:	
				removerConta();
				break;
			case 10:
				System.out.println(" Obrigado por escolher nossa agencia. A Caixa agradece! ");
				System.exit(0);	
				
				default:
					System.out.println("Opção inálida");
					operacoes();
					break;
		}
		
	}
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = teclar.next();
		System.out.println("\nCpf: ");
		String cpf = teclar.next();
		
		Cliente cliente = new Cliente (nome, cpf);
		
		Contas contas = new Contas(cliente);
		
		contasBancarias.add(contas);
		System.out.println("Sua conta foi cadastrada com sucesso!");
		
		operacoes();
	}
	
	public static void consultarConta() {
        System.out.println("Digite o número da conta: ");
        int numeroContaConsulta = teclar.nextInt();

        Contas contaConsultada = encontrarConta(numeroContaConsulta);

        if (contaConsultada != null) {       
            System.out.println("Número da Conta: " + contaConsultada.getNumeroconta());
            System.out.println("Nome do Cliente: " + contaConsultada.getCliente().getNome());
            System.out.println("CPF do Cliente: " + contaConsultada.getCliente().getCpf());
            System.out.println("Saldo: " + contaConsultada.getSaldo());
        } else {
            System.out.println(" Conta não encontrada ");
        }

        operacoes();
    }
	
	 public static void criarContaEAssociarCliente() {
		 
	        System.out.println("\nNome do Cliente: ");
	        String nome = teclar.next();

	        System.out.println("\nCPF do Cliente: ");
	        String cpf = teclar.next();

	        Cliente cliente = new Cliente(nome, cpf);

	        System.out.println("Tipo de Conta (1 - Corrente, 2 - Poupança): ");
	        int tipoConta = teclar.nextInt();

	        Contas conta;
	        
	        if (tipoConta == 1) {
	            conta = new ContaCorrente(cliente);
	        } else if (tipoConta == 2) {
	            conta = new ContaPoupanca(cliente);
	        } else {
	            System.out.println("Tipo de conta inválido!");
	            operacoes();
	            return;
	        }

	        contasBancarias.add(conta);
	        System.out.println(" Conta criada e associada ao cliente com sucesso! ");

	        operacoes();
	    }
	
	private static Contas encontrarConta(int numeroConta) {
		Contas contas = null;
		if(contasBancarias.size()> 0) {
			for(Contas conta: contasBancarias) {
				if(conta.getNumeroconta()== numeroConta);
				contas = conta;
			}
		}
		return contas;
	}
	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = teclar.nextInt();
		
		Contas conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor que o usuario dejesa depositar?");
			double valorDeposito = teclar.nextInt();
			conta.depositar(valorDeposito);
			System.out.println("valor foi depositado com sucesso!");
		}else {
			System.out.println("conta não encontrada!");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = teclar.nextInt();
		
		Contas conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual o valor que o usuario dejesa sacar?");
			double valorSaque = teclar.nextInt();
			conta.sacar(valorSaque);
			System.out.println("valor foi sacado com sucesso!");
		}else {
			System.out.println("conta não encontrada!");
		}
		operacoes();
	}
	public static void transferir() {
		System.out.println("Número da conta do remetente: ");
		int numeroContaRementente = teclar.nextInt();
		
		Contas contaRementente = encontrarConta(numeroContaRementente);

		if(contaRementente != null) {
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = teclar.nextInt();
			
			Contas contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferência: ");
				double valor = teclar.nextDouble();
				
				contaRementente.transferir(contaDestinatario, valor);

			}else {
	            System.out.println(" Conta para transferência não encontrada ");
	            }
		}
		operacoes();
		
	}
	
	public static void consultarBalanco() {

        System.out.println("Digite o CPF do cliente que deseja consultar: ");
        String cpfCliente = teclar.next();

        double balancoTotal = 0.0;

        for (Contas conta : contasBancarias) {
            if (conta.getCliente().getCpf().equals(cpfCliente)) {
                balancoTotal += conta.getSaldo();
            }
        }

        if (balancoTotal > 0.0) {
            System.out.println("Balanço total das contas do cliente " + cpfCliente + ": " + util.doubleToString(balancoTotal));
        } else {
            System.out.println(" Cliente não encontrado ");
        }

        operacoes();
    }
	
	public static void listarContas() {
		if(contasBancarias.size()> 0) {
			for(Contas conta: contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	}
	 public static void removerConta() {

	        System.out.println("Digite o número da conta para ser removida: ");
	        int numeroContaRemover = teclar.nextInt();

	        Contas contaRemover = encontrarConta(numeroContaRemover);

	        if (contaRemover != null) {
	            contasBancarias.remove(contaRemover);
	            System.out.println(" Conta removida com sucesso! ");
	        } else {
	            System.out.println(" Conta não encontrada ");
	        }

	        operacoes();
	    }
	    
}