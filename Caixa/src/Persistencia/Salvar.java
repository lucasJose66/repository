package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Programa.Cliente;

public class Salvar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Programa.Cliente> cadastroClientes = new ArrayList<>();

	private static Salvar instance;
	
	private Salvar() {
		carregarDadosDeArquivo();
	}
	
	public static Salvar getInstance() {
		if(instance!=null)
			return instance;
		else
			return new Salvar();
	}

	public void salvarCliente(Programa.Cliente c) {
		if (!cadastroClientes.contains(c)) {
			cadastroClientes.add(c);
			salvarDadosEmArquivo();
			System.out.println("Cliente cadastrados com sucesso!");
		} else
			System.err.println("Cliente ja cadastrado no sistema!");

	}
	
	public Programa.Cliente localizarClientePorCPF(String cpf) {
		Programa.Cliente c = new Programa.Cliente(cpf, cpf);
		c.setCpf(cpf);
		if(cadastroClientes.contains(c)) {
			int index = cadastroClientes.indexOf(c);
			c = cadastroClientes.get(index);
			return c;
		}else
			return null;
	}
	
	public void atualizarClienteCadastro(Programa.Cliente c) {
		if(cadastroClientes.contains(c)) {
			int index = cadastroClientes.indexOf(c);
			cadastroClientes.set(index, c);
			salvarDadosEmArquivo();
		}else
			System.err.println("Cliente não encontrado!");
	}

	public void salvarDadosEmArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("dados");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cadastroClientes);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void carregarDadosDeArquivo() {

		try {
			FileInputStream fis = new FileInputStream("dados");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cadastroClientes = (ArrayList<Cliente>)ois.readObject();
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
