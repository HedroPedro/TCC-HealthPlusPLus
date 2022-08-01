package modelos;

public class Cliente {
    private int codigo;
    private String nome;
    private String telefone;
    private String endereco;
    private String CPF;
    
    public Cliente(){}

    public Cliente(int codigo, String nome, String telefone, String endereco, String CPF) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", CPF=" + CPF + '}';
    }
    
    public Cliente(String nome, String telefone, String endereco, String CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.CPF = CPF;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public boolean estaCertoORGCPF(){
            return this.CPF.length() == 11;                
    }
}
