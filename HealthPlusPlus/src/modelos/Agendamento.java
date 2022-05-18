package modelos;

import java.sql.Date;

public class Agendamento {
    private int codigo;
    private Date datahora;
    private float preco;
    private int cod_cliente;
    
    public Agendamento(){}

    public Agendamento(int codigo, Date datahora, float preco, int cod_cliente) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.preco = preco;
        this.cod_cliente = cod_cliente;
    }
    
    
}
