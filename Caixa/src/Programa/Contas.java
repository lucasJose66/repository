package Programa;

import utilitarios.util;

public class Contas {

	private static int ContadorDeContas = 1;
			
	private int numeroconta;
	private Cliente cliente;
	private double saldo = 0.0;
	
	public Contas(Cliente cliente) {
	
		this.numeroconta = numeroconta;
		this.cliente = cliente;
		ContadorDeContas += 1;
		
	}

	public int getNumeroconta() {
		return numeroconta;
	}

	public void setNumeroconta(int numeroconta) {
		this.numeroconta = numeroconta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNumero da conta: " + this.getNumeroconta()+
		 "\nNome: " + this.cliente.getNome()+
		 "\nCpf: " + this.cliente.getCpf()+
		 "\nSaldo: " + util.doubleToString(this.getSaldo()) +
		 "\n";
		 

	}
	
	public void depositar(double valor) {
		if(valor>0) {
			setSaldo(getSaldo()+ saldo);
			System.out.println("Seu deposito foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar o deposito!");
			
		}
	}
	
	public void sacar(double valor) {
		if(valor>0 && this.getSaldo()>= valor) {
		setSaldo(getSaldo()- valor);
		System.out.println("Saque realizado com sucesso!");
	}else {
		System.out.println("Não foi possível realizar o deposito!");
		
		}
	}
	public void transferir(Contas contaParaDeposito, double valor) {
		if(valor > 0 && this.getSaldo()>= valor ) {
			setSaldo(getSaldo()- valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo()+ valor;
			System.out.println("Transferência realizada com sucesso!");
		}else {
			System.out.println("Não foi possível realizar a transferência!");
		}
		
	}
}
