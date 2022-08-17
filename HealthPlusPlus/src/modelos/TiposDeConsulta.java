package modelos;

public class TiposDeConsulta {
    private int codigo;
    private String nomeConsulta;
    private float preco;

    public TiposDeConsulta(int codigo, String nomeConsulta, float preco) {
        this.codigo = codigo;
        this.nomeConsulta = nomeConsulta;
        this.preco = preco;
    }

    public TiposDeConsulta() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeConsulta() {
        return nomeConsulta;
    }

    public void setNomeConsulta(String nomeConsulta) {
        this.nomeConsulta = nomeConsulta;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
