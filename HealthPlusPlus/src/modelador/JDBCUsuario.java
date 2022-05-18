package modelador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsuario {
    private Connection c;

    public JDBCUsuario(Connection c) {
        this.c = c;
    }
    
    public void checarUsuario(String nome, String senha){
        String sql = "if(select COD_USUARIO from tb_usuario where NOME like ? and SENHA like ?) then TRUE "
                + "endif";
        PreparedStatement ps;
        try {
            ps = this.c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(JDBCUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
