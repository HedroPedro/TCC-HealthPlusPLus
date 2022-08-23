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
                Agendamento agenda = new Agendamento(rs.getInt("COD"), LocalDateTime.parse(rs.getDate("DATAHORA").toString()), rs.getInt("COD_CLIENTE"), rs.getInt("TIPO_CONSULTA"));
                agendamentos.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agendamentos;
    }
    
    public void inserirAgendamento(Agendamento a){
        String sql = "Select preco from Tb_Tipodeconsulta where COD = ?";
        float preco = 0.0f;
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = this.c.prepareStatement(sql);
            ps.setInt(1, a.getTipo_consulta());
            rs = ps.executeQuery();
            while(rs.next()){
                preco = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "Insert into Tb_Agendamento(DATAHORA, TIPO_CONSULTA, COD_CLIENTE, PRECO) values(?,?,?,?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setDate(1,Date.valueOf(a.getDatahora().toString()));
            ps.setFloat(2, a.getTipo_consulta());
            ps.setInt(3, a.getCod_cliente());
            ps.setFloat(4, preco);
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);} 
    }
    
    public void deletarAgentademento(int codigo){
        String sql = "Delete * FROM TB_AGENDAMENTO WHERE COD = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            }catch(SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
