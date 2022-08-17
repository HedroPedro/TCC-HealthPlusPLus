package modelos;

import java.time.LocalDateTime;

public class Agendamento {
    private int codigo;
    private LocalDateTime datahora;
    private int cod_cliente;
    private int tipo_consulta;
    
    public Agendamento(){}

    public Agendamento(int codigo, LocalDateTime datahora, int cod_cliente, int tipo_consulta) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.cod_cliente = cod_cliente;
        this.tipo_consulta = tipo_consulta;
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

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    
    public int getTipo_consulta(){
        return tipo_consulta;
    }
    
    public void setTipo_consulta(int tipo_consulta){
        this.tipo_consulta = tipo_consulta;
    } 
}
