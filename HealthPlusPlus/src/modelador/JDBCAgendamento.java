package modelador;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Agendamento;

public class JDBCAgendamento {
    Connection c; 
    
    /**
     * Seta o con
     * @param c 
     */
    public JDBCAgendamento(Connection c){
        this.c = c;
    }
    
    /**
     *
     * @return agendamento lista com todos os agendamentos
     */
    public List<Agendamento> listarAgendamentos(){
        String sql = "SELECT * FROM TB_AGENDAMENTO";
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            Statement stat = this.c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Agendamento agenda = new Agendamento(rs.getInt("COD"), LocalDateTime.parse(rs.getDate("DATAHORA").toString()), rs.getFloat("PRECO"), rs.getInt("COD_CLIENTE"));
                agendamentos.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agendamentos;
    }
    
    public void inserirAgendamento(Agendamento a){
        String sql = "Insert into Tb_Agendamento(DATAHORA, PRECO, COD_CLIENTE) values(?,?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setDate(1,Date.valueOf(a.getDatahora().toString()));
            ps.setFloat(2, a.getPreco());
            ps.setInt(3, a.getCod_cliente());
            ps.execute();
            //ps.setDate(0, a.getDatahora());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
