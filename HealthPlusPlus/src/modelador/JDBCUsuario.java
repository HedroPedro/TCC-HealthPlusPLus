package modelador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

public class JDBCUsuario {
    private Connection con;

    /**
     * Seta o con
     * @param con Conection usada para executar todas as funções 
     */
    public JDBCUsuario(Connection con) {
        this.con = con;
    }
    
    /**
     * @param nome Nome do usuario               
     * @param senha Senha do usuario 
     * @return boolean Caso exista usuario da veradeiro se der erro ou falso caso n ache ou dê erro
     */
    public boolean existeUsuario(String nome, String senha){ 
        String sql = "SELECT COD_USUARIO from `tb_usuario` where NOME like ? AND SENHA LIKE ?";
        PreparedStatement ps;
        try {
            ps = this.con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rs.getInt(1);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Usuario> pegarFuncionarios(){
        List<Usuario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM `tb_usuario`";
        
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Usuario funcionario = new Usuario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionarios;
    }
        
    public int pegarNivelDeAcesso(String nome, String senha){
        String sql = "SELECT NIVELDEACESSO from `tb_usuario` where NOME like ? AND SENHA LIKE ?";
        int nivel = 0;
        
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
                return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nivel;
    }

    public void excluirUsuario(int cod){
        String sql = "Delete from tb_usuario where COD_USUARIO = ?";
        
        try {
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cadastrarUsuario(int nivelDeAcesso,String nome, String senha){
        String sql = "INSERT INTO tb_usuario(NIVELDEACESSO, NOME, SENHA) values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nivelDeAcesso);
            ps.setString(2, nome);
            ps.setString(3, senha);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
