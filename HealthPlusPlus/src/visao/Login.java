package visao;

import javax.swing.JOptionPane;
import modelador.Conectador;
import modelador.JDBCUsuario;
import modelos.Usuario;


public class Login extends javax.swing.JFrame {

    JDBCUsuario checadorDeUsuario = new JDBCUsuario(new Conectador().abrirConnection());
    public static Usuario usuario;
    
    public Login() {       
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_imagem = new javax.swing.JLabel();
        Pn_telaLogin = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btn_cancelar = new javax.swing.JButton();
        btn_programadores = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 255));
        setLocation(new java.awt.Point(1600, 900));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 800));
        getContentPane().setLayout(null);

        Pn_telaLogin.setBackground(new java.awt.Color(204, 204, 255));
        Pn_telaLogin.setMaximumSize(new java.awt.Dimension(600, 800));
        Pn_telaLogin.setName(""); // NOI18N
        Pn_telaLogin.setLayout(null);

        btn_login.setBackground(new java.awt.Color(204, 204, 204));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_login.setText("Login");
        btn_login.setToolTipText("");
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        Pn_telaLogin.add(btn_login);
        btn_login.setBounds(170, 630, 280, 90);
        Pn_telaLogin.add(txtUsuario);
        txtUsuario.setBounds(140, 480, 330, 38);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        Pn_telaLogin.add(txtSenha);
        txtSenha.setBounds(140, 570, 330, 41);

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        Pn_telaLogin.add(btn_cancelar);
        btn_cancelar.setBounds(260, 730, 110, 50);

        btn_programadores.setText("only for programers");
        btn_programadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_programadoresActionPerformed(evt);
            }
        });
        Pn_telaLogin.add(btn_programadores);
        btn_programadores.setBounds(430, 40, 135, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon("H:\\TCC SURPREENDENTE\\Design\\Tela Login - X.jpg")); // NOI18N
        Pn_telaLogin.add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 800);

        getContentPane().add(Pn_telaLogin);
        Pn_telaLogin.setBounds(0, 0, 600, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String nome = txtUsuario.getText();
        String senha = String.copyValueOf(txtSenha.getPassword());
        if(checadorDeUsuario.existeUsuario(nome,senha)){
            Principal p = new Principal();
            p.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "TA ERRADO PIA");
        }
        
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_programadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_programadoresActionPerformed
        Principal adm = new Principal();
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_programadoresActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    /**.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_telaLogin;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_programadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_imagem;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
