package modelador;

import java.awt.Toolkit;
import javax.swing.JFrame;



public class InserirIcone {
    
    public void inserirIcone(JFrame Frame){
        try {
            Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("modelador/icone/ICON JAR ARCHIVE.png"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
