package banco;

import banco.Conta;
import notificacoesConta.Notificacao;

import java.time.LocalDate;


public class Conta { 

    private int numerodaagencia = 0001;

    private int numerodaconta;
    private Double saldo; 
    protected String tipo;
    private   String senha;
    private Cliente cliente;
    Notificacao notificacao;

    private static int qtdconntas = 0;

/**
     * @param cliente
     */
    public Conta( Cliente cliente){
    this.cliente = cliente;
    qtdconntas++;
    this.numerodaconta = qtdconntas;
    this.saldo = (double) 0;
}

    public Conta(String senha,String tipo,  Notificacao notificacao ) {
    this.senha = senha;
    this.tipo = tipo;
    this.notificacao = notificacao;
}


   public void Sacar(double valor){

    if (valor > 0  && this.getSaldo() >= 0 ){
        setSaldo(getSaldo()-valor);
        System.out.println("Saque realizado! ");
        this.enviaNotificacao("Saque valor de", valor);
    }
    else {
        System.out.println("Saque negado!");
    } 
}

   public void Depositar(double valor){

    if (valor > 0){
       setSaldo(getSaldo() + valor);
       System.out.println(" Deposito realizado! ");
       this.enviaNotificacao("Deposito valor de", valor);
    }
    else {
       System.out.println("Deposito negado! ");
    }


} 

    public void Transferencia(Conta ContaParaDeposito, double valor){

    if (valor > 0 && this.getSaldo() > 0){
        setSaldo(getSaldo() - valor );
        ContaParaDeposito.saldo = ContaParaDeposito.getSaldo() + valor;
        System.out.println("Transferencia realizado!");
        this.enviaNotificacao("Transferencia valor de", valor);
    }
    
     else{
        System.out.println("Transferencia negada!");
    } 

} 

    protected String enviaNotificacao(String menu, double valor) {

      this.notificacao.enviaNotificacao(menu, valor);
      return menu;

    }
 
    public int getNumerodaconta() {
        return numerodaconta;
    }
    
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getNumerodaagencia() {
        return numerodaagencia;
    }
    /**
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

  public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
  public String getTipo() {
        return tipo;
    }

    

//this get


    public String getNomecliente() {
        return this.cliente.getNome();
    }
    public LocalDate getDatadenascliente() {
        return this.cliente.getDatadenas();
    }
    public String getCpfcliente() {
        return this.cliente.getCpf();
    }
    public String getClienteEnderecocidade() {
        return this.cliente.getCidadeEndereco();
    }
    public String getClienteEnderecoUf() {
        return this.cliente.getUfEndereco();
    }
    public String getClienteLogradouroEndereco() {
        return this.cliente.getLogradouroEndereco();
    }
    public int getClienteNumerodacasaEndereco(){
        return this.cliente.getNumerodacasaEndereco();
    }
    public String getClienteBairroEndereco(){
        return this.cliente.getBairroEndereco();
    }

    public String toString() {
        return " Nome Do Usuario: " + getNomecliente() + "\n"
                + "Tipo da conta: " + getTipo() + "\n"
                +" Saldo: " + getSaldo() + "\n" 
                +" Numero da conta: " + getNumerodaconta() + "\n" 
                +" Data Nascimento: " + getDatadenascliente() + "\n" 
                +" Cpf: " + getCpfcliente() + "\n"  
                +" Endereço: " + "\n-Cidade: " +getClienteEnderecocidade()
                +"\n-Logradouro: " +getClienteLogradouroEndereco() +"\n-Número: "+getClienteNumerodacasaEndereco()
                +"\n-Bairro: "+getClienteBairroEndereco()
                + "\n-Uf: " + getClienteEnderecoUf();
    }

    public void Transferir(Conta contaDestinatario, double valor) {
    }

    public void statusConta() {
    }


}