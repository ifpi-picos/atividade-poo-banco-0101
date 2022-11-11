package banco;

import javax.swing.JOptionPane;

import formatacao.Numformata;

public class ContaCorrente extends Conta {
    
    private double chequeEspecial = 1000.0;
    private int counterTransfer;
    private double tax = 0.05;
    
    Sms sms = new Sms();
    Email email = new Email();

    public ContaCorrente(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        this.counterTransfer = 0;  
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public int getCounterTransfer() {
        return counterTransfer;
    }

    public double getValorDisponivel(double chequeEspecial){
        return getSaldo() + getChequeEspecial();
    }
    

    public void contadorTransferencia(ContaCorrente contaDeposito, double valor){
        this.counterTransfer += 1;
        if(this.counterTransfer >2){
            Double tax = (valor * 5)/100;
            setChequeEspecial(getChequeEspecial() - tax);
        }
    }


    @Override
    public void Sacar(Double valor) {
        double limiteSaque = this.getSaldo() + this.getChequeEspecial();
        if ((limiteSaque - valor) >= 0){
            JOptionPane.showMessageDialog(null, "Valor sacado.");
            this.setSaldo(this.getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Valor retirado do cheque especial.");
        String [] answer = {"Email", "Sms"};
        int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
            if(option == 0) {
            email.mandarNotificacao("Foi feito uma transferência ", valor);
            }
            if(option == 1){
                sms.mandarNotificacao("Foi feita uma transferência ", valor);
            }
        }
    }
        

    public void Transferir(Conta contaDeposito, Double valor) {

    if(this.counterTransfer < 2){
        super.Transferir(contaDeposito, valor);
    }else{
        if (this.getSaldo() >= valor) {
            super.setSaldo(super.getSaldo() - valor * tax);
            super.setSaldo(super.getSaldo() - valor);            
            contaDeposito.setSaldo(contaDeposito.getSaldo() + valor);   
        String [] answer = {"Email", "Sms"};
        int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
            if(option == 0) {
                email.mandarNotificacao("Foi feito uma transferência ", valor);
            }
            if(option == 1){
                sms.mandarNotificacao("Foi feita uma transferência ", valor);
            }
        }
    }
}

@Override
    public void Deposito(Double valor) {
        super.Deposito(valor);
    String [] answer = {"Email", "Sms"};
    int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
        if(option == 0) {
            email.mandarNotificacao("Foi feito uma transferência!", valor);
        }
        if(option == 1){
            sms.mandarNotificacao("Foi feita uma transferência!", valor);
        }
}

@Override
public String toString() {
    return 
        "\nNúmero da conta: " + this.getNumeroConta() +
        "\nAgência: " +this.getAgencia() +
        "\nNome: " + this.cliente.getNome() +
        "\nTipo de conta: " + getContaTipo() +
        "\nTelefone: " + this.cliente.getTelefone() +
        "\nEmail: " + this.cliente.getEmail() +
        "\nCPF: " + this.cliente.getCpf() +
        "\nData de Nascimento: " + this.cliente.getDataDeNas() +
        "\nSaldo: " + Numformata.doubletoString(this.getSaldo()) + 
        "\nLogradouro: " + this.cliente.getLogradouro() +
        "\nNúmero da casa: " + this.cliente.getNumeroCasa() +
        "\nBairro: " + this.cliente.getBairro() +
        "\nCidade: " + this.cliente.getCidade() +
        "\nUF : " + this.cliente.getUf() +
        "\n";
}

}
   