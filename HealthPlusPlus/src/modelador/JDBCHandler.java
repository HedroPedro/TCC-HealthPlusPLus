package modelador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cliente;

public class JDBCHandler {
    Connection con;
    
    public JDBCHandler(Connection con){
        this.con = con;
    }
    
    public void adicionarCliente(Cliente cliente){
        String sql = "insert into Tb_CLiente(nome,telefone,endereco,rg,cpf) values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = this.con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getRG());
            ps.setString(5, cliente.getCPF());
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirAgendamento(){}
    
    public List<Cliente> listarCliente(){
        String sql = "Select * from tb_cliente";
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                int codigo = rs.getInt(1);
                String telefone = rs.getString(2);
                String endereco = rs.getString(3);
                String nome = rs.getString(4);
                String RG = rs.getString(5);
                String CPF = rs.getString(6);
                Cliente c = new Cliente(codigo, nome, telefone, endereco, RG, CPF);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public void deletarCliente(){
        String sql = "Delete * from tb_cliente";
        try{
            Statement stat = con.createStatement();
            stat.execute(sql);
        }catch(SQLException ex){
            Logger.getLogger(JDBCHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
