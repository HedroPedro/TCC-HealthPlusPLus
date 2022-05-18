package modelador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conectador {
    private Connection c;
    
    public Connection abrirConnection(){
        String url = "jdbc:mysql://localhost:3306/empresa?useTimeZone=true&serverTimeZone=UTC";
        String username = "root";
        String password = "";
        try {
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conectador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public void fecharConnection(){
        try{
            c.close();
        }catch(SQLException ex){
            Logger.getLogger(Conectador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
