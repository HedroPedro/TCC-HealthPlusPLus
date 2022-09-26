package modelos;

public class Usuario {
    private int cod;
    private int nivelDeAcesso;
    private String nome;
    
    public Usuario(){}
    
    public Usuario(int cod, int nivelDeAcesso, String nome, String senha) {
        this.cod = cod;
        this.nivelDeAcesso = nivelDeAcesso;
        this.nome = nome;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String senha;

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }
    
    public void setCod(int cod){
    this.cod = cod;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
