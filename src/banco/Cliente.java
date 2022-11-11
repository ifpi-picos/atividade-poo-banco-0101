package banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente {


    private String nome;
    private String cpf;
    private String dataDeNas;
    private Endereco endereco;
    private String telefone;
    private String email;


    private List<Conta> contas = new ArrayList<>();
    private List<ContaCorrente> contaCorrentes = new ArrayList<>();
    private List<ContaPoupanca> contaPoupancas = new ArrayList<>();
    

    public Cliente(String nome, String cpf, String dataDeNas, Endereco endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNas = dataDeNas;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email= email;
        
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }   

    public String getEmail() {
        return email;
    }

    public String getDataDeNas() {
        return dataDeNas;
    }
    
    public Endereco getEndereco() {
        return getEndereco();
    }

    public String getTelefone() {
        return telefone;
    }
    
    public String getLogradouro() {
        return this.endereco.getLogradouro();
    }
    
    public int getNumeroCasa() {
        return this.endereco.getNumeroCasa();
    }
    
    public String getBairro() {
        return this.endereco.getBairro();
    }
    
    public String getCidade() {
        return this.endereco.getCidade();
    }
    
    public String getUf() {
        return this.endereco.getUf();
    }

    public List<Conta> getConta() {
        return contas;
    }
    
    public List<ContaCorrente> getContaCorrentes() {
        return contaCorrentes;
    }
    
    public List<ContaPoupanca> getContaPoupancas() {
        return contaPoupancas;
    }
}
