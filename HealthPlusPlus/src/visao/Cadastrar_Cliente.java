package visao;

import javax.swing.JOptionPane;
import modelador.Conectador;
import modelador.JDBCCliente;
import modelos.Cliente;

public class Cadastrar_Cliente extends javax.swing.JFrame {

    JDBCCliente lidaCliente = new JDBCCliente(new Conectador().abrirConnection());
    private Principal p;
    
    public Cadastrar_Cliente() {
        initComponents();
    }
    
    /**
     * Creates new form Cadastro
     * @param p
     */
    public Cadastrar_Cliente(Principal p) {
        initComponents();
        this.p = p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Edt_Nome = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_end = new javax.swing.JLabel();
        Edt_Endereco = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        lbl_CPF = new javax.swing.JLabel();
        edt_CPF = new javax.swing.JFormattedTextField();
        btn_confirmar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        edt_Telefone = new javax.swing.JFormattedTextField();
        lbl_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 155, 243));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);
        jPanel1.add(Edt_Nome);
        Edt_Nome.setBounds(181, 176, 508, 24);

        lbl_nome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(121, 174, 48, 21);

        lbl_end.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lbl_end.setText("Endereço");
        jPanel1.add(lbl_end);
        lbl_end.setBounds(110, 206, 68, 24);
        jPanel1.add(Edt_Endereco);
        Edt_Endereco.setBounds(190, 208, 499, 24);

        lbl_telefone.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lbl_telefone.setText("Telefone:");
        jPanel1.add(lbl_telefone);
        lbl_telefone.setBounds(396, 238, 68, 24);

        lbl_CPF.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lbl_CPF.setText("CPF:");
        jPanel1.add(lbl_CPF);
        lbl_CPF.setBounds(95, 238, 37, 24);

        try {
            edt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(edt_CPF);
        edt_CPF.setBounds(138, 241, 252, 22);

        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_confirmar);
        btn_confirmar.setBounds(640, 390, 130, 52);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(490, 390, 131, 52);

        try {
            edt_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(edt_Telefone);
        edt_Telefone.setBounds(470, 241, 252, 22);
        jPanel1.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 800, 600);

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        Cliente cliente = new Cliente(Edt_Nome.getText(),edt_Telefone.getText(), Edt_Endereco.getText(), edt_CPF.getText());
        if(cliente.estaCertoCPF()){
            lidaCliente.adicionarCliente(cliente);
            p.requestFocus();
            dispose();
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Digite um CPF válido");
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Edt_Endereco;
    private javax.swing.JTextField Edt_Nome;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JFormattedTextField edt_CPF;
    private javax.swing.JFormattedTextField edt_Telefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_CPF;
    private javax.swing.JLabel lbl_end;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_telefone;
    // End of variables declaration//GEN-END:variables
}
