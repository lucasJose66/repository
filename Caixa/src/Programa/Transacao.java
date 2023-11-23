package Programa;

import java.util.Date;

public class Transacao {
	
	private Date data;
    private String descricao;
    private double valor;

    
    public Transacao(String descricao, double valor) {
        this.data = new Date();
        this.descricao = descricao;
        this.valor = valor;
    }


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
    
    
}
