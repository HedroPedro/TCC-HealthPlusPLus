package modelos;

import java.time.LocalDate;

public class Agendamento {
    private int codigo;
    private LocalDate datahora;
    private int cod_usuario;
    private float preco;
    private int cod_cliente;
    
    public Agendamento(){}

    public Agendamento(int codigo, LocalDate datahora, int cod_usuario, float preco, int cod_cliente) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.cod_usuario = cod_usuario;
        this.preco = preco;
        this.cod_cliente = cod_cliente;
    }
    
    
}
