package modelos;

import java.util.Date;

public class Agendamento {
    private int codigo;
    private Date datahora;
    private int cod_cliente;
    private int tipo_consulta;
    private String nome_cliente;

    public Agendamento(int codigo, Date datahora, String nome_cliente) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.nome_cliente = nome_cliente;
    }
    private float preco;
    
    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Agendamento(int codigo, Date datahora, int cod_cliente, int tipo_consulta, String nome_cliente, float preco) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.cod_cliente = cod_cliente;
        this.tipo_consulta = tipo_consulta;
        this.nome_cliente = nome_cliente;
        this.preco = preco;
    }

    public Agendamento(int codigo, Date datahora, String nome_cliente, float preco) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.nome_cliente = nome_cliente;
        this.preco = preco;
    }
    
    public Agendamento(){}

    public Agendamento(int codigo, Date datahora, int cod_cliente, int tipo_consulta, float preco) {
        this.codigo = codigo;
        this.datahora = datahora;
        this.cod_cliente = cod_cliente;
        this.tipo_consulta = tipo_consulta;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public Agendamento(Date datahora, int cod_cliente, int tipo_consulta) {
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

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
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
    
    static public boolean verificarData(Date date){
        return date.before(new Date());
    }
}
