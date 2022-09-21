package modelos;

public class Usuario {
    int cod;
    int nivelDeAcesso;
    String nome;

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
    
    public void setCod(int cod){
    this.cod = cod;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
