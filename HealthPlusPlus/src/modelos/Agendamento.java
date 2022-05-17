package modelos;

import java.util.Date;

public class Agendamento {
    private int cod;
    private Date datahora;
    private float preco;
    private int cod_cliente;
    
    public Agendamento(){}

    public Agendamento(int cod, Date datahora, float preco, int cod_cliente) {
        this.cod = cod;
        this.datahora = datahora;
        this.preco = preco;
        this.cod_cliente = cod_cliente;
    }
    
    
}
