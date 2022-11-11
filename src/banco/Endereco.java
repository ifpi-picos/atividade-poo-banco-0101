package banco;

public class Endereco {
    
    private String logradouro;
    private int numeroCasa;
    private String bairro;
    private String cidade;
    private String uf;
    
    
    public Endereco(String logradouro, int numeroCasa, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumeroCasa() {
        return numeroCasa;}

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }    
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }    
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}