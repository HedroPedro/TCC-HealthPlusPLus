package modelador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsuario {
    private Connection c;

    public JDBCUsuario(Connection c) {
        this.c = c;
    }
    
    public int checarUsuario(String nome, String senha){
        String sql = "SELECT IF (NOME LIKE ? and SENHA LIKE ?, 1 , 0) from tb_usuario ";
        PreparedStatement ps;
        try {
            ps = this.c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }
}
