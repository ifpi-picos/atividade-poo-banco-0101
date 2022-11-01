package banco;

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private int numerodacasa;

    public Endereco(String logradouro, String bairro, String cidade, String uf, int numerodacasa){
        this.logradouro = logradouro  ;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf; 
        this.numerodacasa = numerodacasa;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public int getNumerodacasa() {
        return numerodacasa;
    }
    public String getUf() {
        return uf;
    }
}
