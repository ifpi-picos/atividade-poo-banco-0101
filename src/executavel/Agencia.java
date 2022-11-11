package executavel;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import banco.Endereco;



public class Agencia {
    
    static Scanner Entrada = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    

    
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        menu();
    }

    public static void menu() {

        int operacao = 
                Integer.parseInt(JOptionPane.showInputDialog("Bem-vindo(a) ao nosso Banco! Funções a baixo: \n" +
                    "1. Criar Conta\n" +
                    "2. Depositar\n" +
                    "3. Sacar\n" +
                    "4. Transferir\n" +
                    "5. Extrato\n" + 
                    "6. Sair\n"));


        switch(operacao){
        case 1:
            CriarConta();
        case 2:
            Deposito();      
        case 3:
            Sacar();      
        case 4:
            Transferir();
        case 5:
            Extrato();      
        case 6:
        JOptionPane.showMessageDialog(null,"Obrigado ppr escolher o nosso banco!");
        System.exit(0);
        default:
            JOptionPane.showMessageDialog(null,"Opção Inválida! Por favor, escolha alguma das existentes no menu.");
            menu();
            break;          
        }


    }

    private static void CriarConta()  {

        String [] opcoes = {"Corrente", "Poupança"};
        int contaTipo = JOptionPane.showOptionDialog(null, "Qual tipo de conta você deseja criar? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes);
        
        String nome = JOptionPane.showInputDialog("Qual o seu nome? ");
        
        String cpf = JOptionPane.showInputDialog("Qual o seu CPF? ");
        
        String email = JOptionPane.showInputDialog("Qual o seu e-mail?");

        String telefone = JOptionPane.showInputDialog("Qual o seu é o nuemro do seu telefone?");

        String dataNascimento = JOptionPane.showInputDialog("Qual é a sua data de nascimento? ");
          
        String logradouro = JOptionPane.showInputDialog("Qual o nome da sua rua?  ");
        
        String bairro = JOptionPane.showInputDialog("Qual o seu bairro? ");

        String numeroCasa = JOptionPane.showInputDialog("Qual o número da sua casa? ");

        int numeroCasaDef = Integer.parseInt(numeroCasa);
        
        String cidade = JOptionPane.showInputDialog("Qual é a sua cidade ? ");
        
        String uf = JOptionPane.showInputDialog("Qual é o seu estado? ");
        
        Endereco enderecos = new Endereco(logradouro, numeroCasaDef, bairro, cidade, uf);


        Cliente cliente = new Cliente(nome, cpf, dataNascimento, enderecos, telefone, email);    

        if (contaTipo == 0){
            ContaCorrente conta = new ContaCorrente(cliente, contaTipo);
            contasBancarias.add(conta);
            JOptionPane.showMessageDialog(null, "Sua conta de tipo Corrente foi criada com sucesso!!!");

        }else if(contaTipo == 1){
            ContaPoupanca conta = new ContaPoupanca(cliente, contaTipo);
            contasBancarias.add(conta);
            JOptionPane.showMessageDialog(null, "Sua conta de tipo Poupança foi criada com sucesso!!!");
        };
        menu();
    }
    
    
    
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }    


    public static void Deposito() {

        String numeroConta = (JOptionPane.showInputDialog(null, "Número da conta para depósito: "));
        
        int numeroContaDef = Integer.parseInt(numeroConta);
        
        Conta conta = encontrarConta(numeroContaDef);

        if(conta != null) {
            Double valor = 
                Double.parseDouble((JOptionPane.showInputDialog(null, "Valor do depósito: ")));

                conta.Deposito(valor);
            
        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada, não foi possivel realizar o depósito.");
        }
        menu();
        }
        
    

    public static void Sacar()  {
        String numeroConta = (JOptionPane.showInputDialog("Número da conta para realizar o saque: "));
        int numeroContaDef = Integer.parseInt(numeroConta);
        Conta conta= encontrarConta(numeroContaDef);

        if(conta != null) {
            Double valorSaque = 
                    Double.parseDouble(JOptionPane.showInputDialog("Quanto você deseja sacar? "));
            conta.Sacar(valorSaque);

        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada, não foi possivel realizar o saque.");
        }
        menu();
    }

    public static void Transferir() {
            String numeroContaRemetente = 
                (JOptionPane.showInputDialog("Número da sua conta para realizar a transferencia: "));
            int numeroContaRemetenteDef = 
                Integer.parseInt(numeroContaRemetente);
            Conta contaRemetente = encontrarConta(numeroContaRemetenteDef);

            if(contaRemetente != null) {
                String numeroContaDestino = 
                        (JOptionPane.showInputDialog("Número da conta destino para realizar a transferencia: "));
                int numeroContaDestinoDef = 
                        Integer.parseInt(numeroContaDestino);
                Conta contaDestino = encontrarConta(numeroContaDestinoDef);

                if(contaDestino != null) {
                    String valor = 
                            JOptionPane.showInputDialog("Quanto você deseja transferir? ");
                    double valorDef = Integer.parseInt(valor);
                    contaDestino.Transferir(contaRemetente, valorDef);

                    contaRemetente.Transferir(contaDestino, valorDef);
                }else {
                    JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada.");
                }

            }
            menu();
        
    }    

    public static void Extrato() {
        if(contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                JOptionPane.showMessageDialog(null, conta);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Não existem contas cadastradas!");            
        }
        menu();
    }

 

}
