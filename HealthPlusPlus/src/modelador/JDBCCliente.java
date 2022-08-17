package modelador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cliente;

public class JDBCCliente {
    Connection con;
    
    /**
     * Seta o con
     * @param con Conection usada para executar todas as funções 
     */
    
    public JDBCCliente(Connection con){
        this.con = con;
    }
    
    /**
    * Metodo usado para adicionar cliente
    * @param cliente cliente a ser adicionado
    */
    public void adicionarCliente(Cliente cliente){
        String sql = "insert into Tb_CLiente(NOME, END_CLIENTE, TEL_CLIENTE, CPF_CLIENTE) values(?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = this.con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getCPF());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> listarCliente(){
        /**
         * @return clientes lista com todos os clientes
         */
        String sql = "Select * from tb_cliente";
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String telefone = rs.getString(4);
                String CPF = rs.getString(5);
                Cliente c = new Cliente(codigo, nome, telefone, endereco, CPF);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    /**
     * Deleta tudo da TB_CLIENTE
     */
    public void deletarCliente(){
        String sql = "Delete * from tb_cliente";
        try{
            Statement stat = this.con.createStatement();
            stat.execute(sql);
        }catch(SQLException ex){
            Logger.getLogger(JDBCCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void deletarCliente(int codigo){
        String sql = "Delete * from tb_cliente where CODIGO_CLIENTE = ?";
        try{
            PreparedStatement rs = this.con.prepareStatement(sql);
            rs.setInt(1, codigo);
            rs.execute(sql);
        }catch(SQLException ex){
            Logger.getLogger(JDBCCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
