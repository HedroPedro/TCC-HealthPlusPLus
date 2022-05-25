package modelador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsuario {
    private Connection c;

    public JDBCUsuario(Connection c) {
        this.c = c;
    }
    
    public boolean existeUsuario(String nome, String senha){ //Checa se existe usuario
        String sql = "SELECT COD_USUARIO from tb_usuario WHERE NOME = ? and SENHA = ?";
        PreparedStatement ps;
        try {
            ps = this.c.prepareStatement(sql);
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
