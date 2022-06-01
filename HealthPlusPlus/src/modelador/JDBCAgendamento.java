package modelador;

import java.sql.*;

public class JDBCAgendamento {
    Connection c;
    JDBCAgendamento(Connection c){
        this.c = c;
    }
}
