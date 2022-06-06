package modelador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * @return boolean Caso exista usuario da veradeiro se der erro ou não ache da falso
     */
    public boolean existeUsuario(String nome, String senha){ 
        String sql = "SELECT COD_USUARIO from tb_usuario WHERE NOME = ? and SENHA = ?";
        PreparedStatement ps;
        try {
            ps = this.con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
