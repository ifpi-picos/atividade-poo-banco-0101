package banco;

import javax.swing.JOptionPane;



import formatacao.Numformata;

public class ContaPoupanca extends Conta {
    
    private double rendimento;
    private double tax = 0.05;
    
    Sms sms = new Sms();
    Email email = new Email();

    public ContaPoupanca(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        this.rendimento = 1.10;
    }

    public double getRendimento(){
        return rendimento;
    }
    
    public void setRendimento(Double rendimento){
        this.rendimento = rendimento;
    }

    @Override
    public void Deposito(Double valor) {
        valor += (valor * 10) /100;
        super.Deposito(valor);
        String [] answer = {"Email", "Sms"};
        int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
        if(option == 0) {
            email.mandarNotificacao("Foi feito uma transferência ", valor);
        }
    }

    @Override
    public void sacar (Double valor) {
        if (this.getSaldo() > 0) {
            setSaldo(getSaldo() - valor);
        String [] answer = {"Email", "Sms"};
        int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
            if(option == 0) {
            email.mandarNotificacao("Foi feito um saque ", valor);
            }
            if(option == 1){
                sms.mandarNotificacao("Foi feito um saque ", valor);
            }
        }
    }

    @Override
    public void Transferir(Conta contaDeposito, Double valor) {
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
