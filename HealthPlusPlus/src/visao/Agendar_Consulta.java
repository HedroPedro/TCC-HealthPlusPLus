package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelador.JDBCAgendamento;
import modelador.JDBCTiposDeConsulta;
import modelos.Agendamento;

public class Agendar_Consulta extends javax.swing.JFrame {

    private JDBCAgendamento modelaAgendamento;
    private JDBCTiposDeConsulta nomesConsulta;
    private int cod;
    private Principal p;
    
    public Agendar_Consulta(int cod, String nome, Principal p) {
        this.nomesConsulta = p.tiposDeConsulta;
        this.modelaAgendamento = p.agendamentos;
        initComponents();
        edt_nome.setText(nome);
        this.cod = cod;
        this.p = p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        edt_nome = new javax.swing.JTextField();
        edt_data = new javax.swing.JFormattedTextField();
        edt_hora = new javax.swing.JFormattedTextField();
        lbl_nome = new javax.swing.JLabel();
        btn_agendar = new javax.swing.JButton();
        lbl_hora = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        ComboBox_Consultas = new javax.swing.JComboBox<>();
        lbl_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(550, 400));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(null);

        btn_cancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(380, 320, 130, 50);

        edt_nome.setEditable(false);
        edt_nome.setBackground(new java.awt.Color(255, 255, 255));
        edt_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(edt_nome);
        edt_nome.setBounds(140, 130, 350, 30);

        try {
            edt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edt_data.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(edt_data);
        edt_data.setBounds(140, 170, 110, 30);

        try {
            edt_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edt_hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_hora.setPreferredSize(new java.awt.Dimension(100, 22));
        edt_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_horaActionPerformed(evt);
            }
        });
        jPanel1.add(edt_hora);
        edt_hora.setBounds(330, 170, 160, 30);

        lbl_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(70, 130, 52, 30);

        btn_agendar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_agendar.setText("Agendar");
        btn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agendar);
        btn_agendar.setBounds(240, 320, 130, 50);

        lbl_hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_hora.setText("Horário:");
        jPanel1.add(lbl_hora);
        lbl_hora.setBounds(260, 170, 64, 30);

        lbl_data.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_data.setText("Data:");
        jPanel1.add(lbl_data);
        lbl_data.setBounds(80, 170, 60, 30);

        int i = 1;
        for(String tipo : nomesConsulta.pegarNome()){
            ComboBox_Consultas.addItem(i+"- "+tipo);
            i++;
        }
        ComboBox_Consultas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ComboBox_Consultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_ConsultasActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBox_Consultas);
        ComboBox_Consultas.setBounds(320, 220, 170, 30);

        lbl_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Agendar Consulta.jpg"))); // NOI18N
        jPanel1.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 550, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendarActionPerformed
        SimpleDateFormat formartador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if(!edt_data.getText().equals("") && !edt_hora.getText().equals("") && !edt_nome.getText().equals("") && ComboBox_Consultas.getSelectedIndex() != -1){
            Date parsedDate = new Date();
            try {
                parsedDate = formartador.parse(edt_data.getText() + " " + edt_hora.getText());
            } catch (ParseException ex) {
                Logger.getLogger(Agendar_Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(Agendamento.verificarData(parsedDate)){
                JOptionPane.showMessageDialog(null, "Digite uma data e hora válida");
            } else{
               if(modelaAgendamento.checarDataNoSistema(parsedDate)){
                   JOptionPane.showMessageDialog(null, "Data e hora já preenchida no sistema");
               }else{
                   modelaAgendamento.inserirAgendamento(new Agendamento(parsedDate, cod, ComboBox_Consultas.getSelectedIndex()+1));
                   p.carregarTabelaConsulta();
                   dispose();
               }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Umas das caixas está vazio, digite novamente");
        }
    }//GEN-LAST:event_btn_agendarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void ComboBox_ConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_ConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_ConsultasActionPerformed

    private void edt_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_horaActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Consultas;
    private javax.swing.JButton btn_agendar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JFormattedTextField edt_data;
    private javax.swing.JFormattedTextField edt_hora;
    private javax.swing.JTextField edt_nome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nome;
    // End of variables declaration//GEN-END:variables
}
