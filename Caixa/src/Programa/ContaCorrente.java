package Programa;

public class ContaCorrente extends Contas {

    private double limiteChequeEspecial;

   
    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteChequeEspecial = 1000.0; // 
    }

    

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}
