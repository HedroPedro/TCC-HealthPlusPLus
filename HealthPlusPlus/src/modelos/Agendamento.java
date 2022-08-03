package modelos;

import java.time.LocalDateTime;

public class Agendamento {
    private int codigo;
    private LocalDateTime datahora;
    private int cod_usuario;
    private float preco;
    private int cod_cliente;
    
    public Agendamento(){}

    public Agendamento(int codigo, LocalDateTime datahora, int cod_usuario, float preco, int cod_cliente) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.cod_usuario = cod_usuario;
        this.preco = preco;
        this.cod_cliente = cod_cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    
}
