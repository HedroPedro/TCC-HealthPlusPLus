package modelador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.TiposDeConsulta;

public class JDBCTiposDeConsulta {
    Connection con;
    
    public JDBCTiposDeConsulta(Connection con){
        this.con = con;
    }
    
    public TiposDeConsulta pegarTiposdeConsulta(int cod){
        String sql = "Select * from tb_tiposdeconsulta where COD = ?";
        TiposDeConsulta tipos = new TiposDeConsulta();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               tipos = new TiposDeConsulta(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTiposDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }
    
    public float pegarPreco(int cod){
        String sql = "Select preco from Tb_tiposdeconsulta where COD = ?";
        float preco = 0.0f;
        PreparedStatement ps;
        
        try {
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                preco = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTiposDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return preco;
    }
    
    public List<String> pegarNome(){
        String sql = "Select NOMECONSULTA from Tb_tiposdeconsulta";
        List<String> nomes = new ArrayList<>();
        
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sql);             
            while(rs.next()){
                nomes.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTiposDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }
    
    public List<TiposDeConsulta> pegarTiposDeConsulta(){
        List<TiposDeConsulta> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tb_tiposdeconsulta";
        
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                TiposDeConsulta consultaTemp = new TiposDeConsulta(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                tipos.add(consultaTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTiposDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipos;
    }

    public void excluirTipoDeConsulta(int cod) {
        String sql = "DELETE from tb_tiposdeconsulta where COD = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTiposDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
