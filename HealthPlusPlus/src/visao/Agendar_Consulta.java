package visao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelador.JDBCAgendamento;
import modelador.Conectador;
import modelos.Agendamento;
public class Agendar_Consulta extends javax.swing.JFrame {

    public JDBCAgendamento modelaAgendamento = new JDBCAgendamento(new Conectador().abrirConnection());
    private Principal p;
    
    public Agendar_Consulta() {
        initComponents();
    }
    
    public Agendar_Consulta(Principal p) {
        initComponents();
        this.p = p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        edt_nome = new javax.swing.JTextField();
        edt_data = new javax.swing.JFormattedTextField();
        edt_hora = new javax.swing.JFormattedTextField();
        lbl_nome = new javax.swing.JLabel();
        btn_agendar = new javax.swing.JButton();
        lbl_hora = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        lbl_fundo = new javax.swing.JLabel();
        ComboBox_Consultas = new javax.swing.JComboBox<>();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);
        setMaximumSize(new java.awt.Dimension(505, 345));
        setMinimumSize(new java.awt.Dimension(505, 345));

        jPanel1.setLayout(null);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(340, 280, 130, 40);
        jPanel1.add(edt_nome);
        edt_nome.setBounds(121, 112, 326, 22);

        try {
            edt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(edt_data);
        edt_data.setBounds(144, 146, 100, 22);

        try {
            edt_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edt_hora.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(edt_hora);
        edt_hora.setBounds(305, 146, 100, 22);

        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(79, 115, 36, 16);

        btn_agendar.setText("Agendar");
        btn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agendar);
        btn_agendar.setBounds(204, 280, 130, 40);

        lbl_hora.setText("Horário:");
        jPanel1.add(lbl_hora);
        lbl_hora.setBounds(256, 149, 43, 16);

        lbl_data.setText("Data:");
        jPanel1.add(lbl_data);
        lbl_data.setBounds(111, 149, 27, 16);
        jPanel1.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 505, 345);

        ComboBox_Consultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Consulta", "2- Plano" }));
        jPanel1.add(ComboBox_Consultas);
        ComboBox_Consultas.setBounds(300, 220, 110, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    DateTimeFormatter formartador = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
    private void btn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendarActionPerformed
        if(!edt_data.getText().equals("") && !edt_hora.getText().equals("")){
            LocalDateTime parsedDate = LocalDateTime.parse(edt_data.getText() + " " + edt_hora.getText(), formartador);
            if(verificarData(parsedDate))
                JOptionPane.showMessageDialog(null, "Digite uma data e hora válida");
            else{
               modelaAgendamento.inserirAgendamento(new Agendamento(parsedDate, p.cod, ComboBox_Consultas.getSelectedIndex()+1));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Umas das caixas está vazia está vazio, digite novamente");
        }
    }//GEN-LAST:event_btn_agendarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(Agendar_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendar_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendar_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendar_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendar_Consulta().setVisible(true);
            }
        });
    }
    private boolean verificarData(LocalDateTime date){
        return date.isBefore(LocalDateTime.now());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Consultas;
    private javax.swing.JButton btn_agendar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JFormattedTextField edt_data;
    private javax.swing.JFormattedTextField edt_hora;
    private javax.swing.JTextField edt_nome;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nome;
    // End of variables declaration//GEN-END:variables
}
