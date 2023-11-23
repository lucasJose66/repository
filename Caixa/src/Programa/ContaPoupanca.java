package Programa;

public class ContaPoupanca extends Contas {

    private double taxaRendimento;

    
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.taxaRendimento = 0.02; 
    }

    

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    
}