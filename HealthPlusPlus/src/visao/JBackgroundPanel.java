package visao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class JBackgroundPanel extends javax.swing.JPanel {

    private BufferedImage img;
    
    
    public JBackgroundPanel() {
        initComponents();
    }
    
    public JBackgroundPanel(BufferedImage img) {
        
       this.img = img;
       initComponents();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(img != null){
            g.drawImage(img, 0, 0, null);
        }
    }

    protected void formatarImagem(int width, int height){
        Image imagemResultado = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage imagemFormatada = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        imagemFormatada.createGraphics().drawImage(imagemResultado, 0, 0, this);
        img = imagemFormatada;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
