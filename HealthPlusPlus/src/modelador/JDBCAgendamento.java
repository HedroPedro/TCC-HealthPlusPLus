package modelador;

import java.sql.*;
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
        String sql = "SELECT COD, DATAHORA, NOME_CLIENTE, PRECO FROM TB_AGENDAMENTO";
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            Statement stat = this.c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Agendamento agenda = new Agendamento(rs.getInt(1), new java.util.Date(rs.getTimestamp(2).getTime()), rs.getString(3), rs.getFloat(4));
                agendamentos.add(agenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agendamentos;
    }
    
    public void inserirAgendamento(Agendamento a){
        String sql = "Select NOME_CLIENTE from tb_cliente where COD_CLIENTE = ?";
        PreparedStatement ps;
        String nome = "";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, a.getCod_cliente());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                nome = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "Insert into Tb_Agendamento(DATAHORA, TIPO_CONSULTA, COD_CLIENTE, NOME_CLIENTE, PRECO) values(?,?,?,?,?)";
        float preco = new JDBCTiposDeConsulta(c).pegarPreco(a.getNome_consulta());
        int tipoDeConsulta = new JDBCTiposDeConsulta(c).pegarCodConsulta(a.getNome_consulta());
        try {
            ps = c.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(a.getDatahora().getTime()));
            ps.setInt(2, tipoDeConsulta);
            ps.setInt(3, a.getCod_cliente());
            ps.setString(4, nome);
            ps.setFloat(5, preco);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);} 
    }
    
    public void deletarAgentademento(int codigo){
        String sql = "Delete FROM TB_AGENDAMENTO WHERE COD = ?";
        try {
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            }catch(SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletarAgendamentoComCodCliente(int codigo){
        String sql = "Delete FROM tb_agendamento where COD_CLIENTE = ?";
        try {
            PreparedStatement ps =this.c.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarAgendamento(Agendamento a){
        String sql = "UPDATE tb_agendamento SET DATAHORA = ?, NOME_CLIENTE = ?, PRECO = ? WHERE COD = ?";
        try {
            PreparedStatement ps = this.c.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(a.getDatahora().getTime()));
            ps.setString(2, a.getNome_cliente());
            ps.setFloat(3, a.getPreco());
            ps.setInt(4, a.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checarDataNoSistema(java.util.Date data){
        String sql = "SELECT COD from TB_AGENDAMENTO where DATAHORA = ?";
        Timestamp tmstamp = new Timestamp(data.getTime());
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setTimestamp(1, tmstamp);
            ResultSet rs = ps.executeQuery();
            
            return !rs.next();
            
            }catch(SQLException ex) {
                Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean checarDataNoSistema(java.util.Date data, int cod){
        String sql = "SELECT COD from TB_AGENDAMENTO where COD <> ? AND DATAHORA = ?";
        Timestamp tmstamp = new Timestamp(data.getTime());
        PreparedStatement pr;
        try {
            pr = c.prepareStatement(sql);
            pr.setInt(1, cod);
            pr.setTimestamp(2, tmstamp);
            ResultSet rs = pr.executeQuery();
            
            return !rs.next();
            
            }catch(SQLException ex) {
                Logger.getLogger(JDBCAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
