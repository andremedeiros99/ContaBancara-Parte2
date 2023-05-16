public class ContaBancaria {
    
    private double saldo;
    private double limite;
    private Cliente cliente;
    private int id;
    private static int ultima = 100;

    public ContaBancaria(double saldo, Cliente cliente){
        this.saldo = saldo;
        limite = 500;
        this.cliente = cliente;
        ultima--;
        id = ultima;
    }

    public ContaBancaria(Cliente cliente){
        saldo = 0;
        limite = 500;
        this.cliente = cliente;
        ultima--;
        id = ultima;
    }

    public int getId(){
        return id;
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public double getLimite(){
        return limite;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void sacar(double valorSaque){
        double novoSaque = saldo - valorSaque;
        if((-limite) <= (novoSaque)){
            saldo = novoSaque;
        } else{
            System.out.println("Impossível sacar");
        }
    }

    public void depositar(double valorDeposito){
        saldo += valorDeposito;
    }

    public void transferencia(double valorTransferencia, ContaBancaria contaDestino){
        if(valorTransferencia <= saldo + limite){
            sacar(valorTransferencia);
            contaDestino.depositar(valorTransferencia);
        } else{
            System.out.println("Saldo e limite insuficientes");
        }
    }
}
