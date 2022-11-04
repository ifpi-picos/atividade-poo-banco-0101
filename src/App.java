


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

import banco.Cliente;
import banco.Conta;
import banco.Endereco;
import notificacoesConta.Email;
import notificacoesConta.Notificacao;

import java.time.LocalDate;

public class App {

    /**
     *
     */
    static Scanner Entrada = new Scanner(System.in);
   
     static ArrayList<Conta> c;
     public static void main(String[] args){
   
           c = new  ArrayList<>();
           menu();
           }
           
           /**
            * 
            */
           private static void menu() {
           
           System.out.println("------------------------------------------------------");
           System.out.println("-------------Bem-vindo(a) a nossa Agência virtual-------------");
           System.out.println("***** Escolha uma funcionalidade ***** \n");
           System.out.println("1.Criar Conta ");
           System.out.println("2.Saldo ");
           System.out.println("3.Deposito ");
           System.out.println("4.Saque ");
           System.out.println("5.Transferencia");
           System.out.println("6.Lista ");
           System.out.println("7.Sair \n");
   
           System.out.println("Operação escolhida!\n");
          
           int menu = Entrada.nextInt();
   
           switch (menu){
           case 1:
           CriarConta(conta);
           break;
   
           case 2:
           Saldo();
           break;
   
           case 3:
           Depositar();       
           break;
   
           case 4:
           Sacar();
           break;
   
           case 5:
           Transferir();
           break;
   
           case 6:
           ListarContas();
           break;
   
           case 7:
           System.out.println("Operação Finalizada!");
           System.exit(0); // para o sistema
   
           default:
           System.exit(0);
               break;
          
       } 
              
       }
   
   
        /**
        * @param valor
        */
       private static Conta encontrarConta(int Numero){
         Conta conta = null;
         if (c.size() > 0 ){
           for (Conta ct : c){
            if (ct.getNumerodaconta() == Numero){
             conta = ct ;
            }
           }
         }
         
         return conta;
   
       }
        
       private static void Saldo(){
         System.out.println("Digite o numero da conta");
         int numero = Entrada.nextInt(); 
         Conta conta = encontrarConta(numero);
   
         if (conta != null){
           System.out.println(conta.getSaldo());
         }
   
         menu();
       } 
   
       private static void Depositar(){
          System.out.println("");
          System.out.println("-- Realizar Deposito --");
          System.out.println("Numero da Conta:" );
          int numero = Entrada.nextInt();
   
          Conta conta = encontrarConta(numero);
          
        
           if(conta != null) {
               System.out.println("Qual valor deseja depositar? ");
               double valor = Entrada.nextDouble();
   
               conta.Depositar(valor);
           }
           else {
               System.out.println("Conta não encontrada!");
           }
   
           menu();
   
       }
        
        /**
        * @param valor
        */
       private static void Sacar(){
         
          System.out.println("");
          System.out.println("-- Realizar Saque --");
          System.out.println("Numero da Conta:" );
          int numero = Entrada.nextInt();
   
          Conta conta = encontrarConta(numero);
   
   
          if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
               double valor = Entrada.nextDouble();
   
               conta.Sacar(valor);
               System.out.println("Saque realizado!");
           }
           else {
               System.out.println("Conta não encontrada!");
           }
   
           menu();
   
       }
   
        public static void Transferir() {
        System.out.println("Numero da Conta do remetente:" );
        int numContaRemetente = Entrada.nextInt();
   
        Conta contaRemetente = encontrarConta(numContaRemetente);
        
        if(contaRemetente != null) {
        System.out.println("Numero da Conta do destinatario:" ); 
        int numContaDestinatario = Entrada.nextInt();
        
        Conta contaDestinatario = encontrarConta(numContaDestinatario);
   
        if(contaDestinatario != null) {
        System.out.println("Valor da transferencia:" );
        double valor = Entrada.nextDouble();
   
       contaRemetente.Transferir(contaDestinatario, valor);
       }
       }
          menu();
       }
       
       /**
     * @param contaPoupanca TODO
       * @param <Endereco>
        * 
        */
       private static void CriarConta(ContaPoupanca contaPoupanca){
        System.out.println("Qual tipo de conta?");
        String tipo = Entrada.next();


         System.out.println("Informe o nome do usuario:");
         String nome = Entrada.next();
   
         System.out.println( "Informe o cpf:");
         String cpf = Entrada.next();
   
         System.out.println( "Informe a cidade:");
         String cidade = Entrada.next();

         System.out.println( "Informe o bairro:");
         String bairro = Entrada.next();

         System.out.println( "Informe o logradouro:");
         String logradouro = Entrada.next();
   
         System.out.println( "Informe numero da casa:");
         int numerodacasa = Entrada.nextInt();
   
         System.out.println( "Informe o uf:");
         String uf = Entrada.next();
   
         System.out.println( "Informe a data de nascimento use / para separa os numeros:");
         System.out.println( "ps: use / para separa os numeros:");
         String dataString = Entrada.next();

        

         String [] dataSeparada = dataString.split("/");
         LocalDate datadenas = LocalDate.of(Integer.parseInt(dataSeparada[2]),Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
   
        Endereco endereco = new Endereco(logradouro, bairro, cidade, uf, numerodacasa);
        Cliente cliente = new Cliente(nome, cpf, datadenas, endereco);
        Notificacao notificacao = new Email(); 

         if ( tipo.equalsIgnoreCase("Poupança")){
          ContaPoupanca conta = new ContaPoupanca(cliente, tipo, notificacao);
         c.add();
        
        }
        else if ( tipo.equalsIgnoreCase("Corrente")) {

          
          Collection<? extends Conta> conta = (Collection<? extends Conta>) new ContaCorrente(cliente, tipo);
         c.addAll(conta);
      
        }
        menu();
      }
   

    public static void ListarContas() {
           if(c.size() > 0) {
               for(Conta ct : c) {
                   System.out.println(c);
               }
           }
           else {
               System.out.println("Não há contas cadastradas!");
           }
   
           menu();
       }
   }
  
   