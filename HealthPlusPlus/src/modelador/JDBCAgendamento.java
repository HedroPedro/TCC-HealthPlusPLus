package modelador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Agendamento;

public class JDBCAgendamento {
    Connection c;
    JDBCAgendamento(Connection c){
        this.c = c;
    }
    /*COD
DATAHORA
COD_USUARIO
PREÇO
COD_CLIENTE

*/
    public List<Agendamento> listarAgendamentos(){
        String sql = "SELECT * FROM TB_AGENDAMENTO";
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            Statement stat = this.c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Agendamento agenda = new Agendamento(rs.getInt("COD"), rs.getDate("DATAHORA"), rs.getInt("COD_USUARIO"), rs.getFloat("PRECO"), rs.getInt("COD_CLIENTE"));
                agendamentos.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agendamentos;
    } 
}
