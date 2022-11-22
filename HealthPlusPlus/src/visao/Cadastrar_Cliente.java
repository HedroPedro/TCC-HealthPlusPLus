package visao;

import javax.swing.JOptionPane;
import modelador.JDBCCliente;
import modelos.Cliente;

public class Cadastrar_Cliente extends javax.swing.JFrame {

    private JDBCCliente lidaCliente;
    private Principal p;
    
    /**
     * Creates new form Cadastro
     * @param p
     * @param lidaCliente
     */
    public Cadastrar_Cliente(Principal p, JDBCCliente lidaCliente) {
        initComponents();
        this.p = p;
        this.lidaCliente = lidaCliente;
    }
    
    public Cadastrar_Cliente(){
        initComponents();
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
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Edt_Nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(Edt_Nome);
        Edt_Nome.setBounds(200, 180, 510, 30);

        lbl_nome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(140, 180, 60, 30);

        lbl_end.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_end.setText("Endereço:");
        jPanel1.add(lbl_end);
        lbl_end.setBounds(110, 220, 90, 30);

        Edt_Endereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(Edt_Endereco);
        Edt_Endereco.setBounds(200, 220, 510, 30);

        lbl_telefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_telefone.setText("Telefone:");
        jPanel1.add(lbl_telefone);
        lbl_telefone.setBounds(400, 260, 80, 30);

        lbl_CPF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_CPF.setText("CPF:");
        jPanel1.add(lbl_CPF);
        lbl_CPF.setBounds(150, 260, 60, 30);

        try {
            edt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edt_CPF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(edt_CPF);
        edt_CPF.setBounds(200, 260, 180, 30);

        btn_confirmar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_confirmar);
        btn_confirmar.setBounds(620, 390, 130, 52);

        btn_cancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(470, 390, 131, 52);

        try {
            edt_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edt_Telefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_Telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edt_TelefoneKeyPressed(evt);
            }
        });
        jPanel1.add(edt_Telefone);
        edt_Telefone.setBounds(490, 260, 220, 30);

        lbl_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Cadastrar.jpg"))); // NOI18N
        jPanel1.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 800, 500);

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
            
            if(cliente.estaCertoTelefone()){
                if(lidaCliente.clienteNaoExiste(cliente.getCPF())){
                    lidaCliente.adicionarCliente(cliente);
                    p.carregarTabelaCliente();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "CPF já cadastrado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Número de telefone inválido, tente outro");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "CPF inválido, tente outro");
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void edt_TelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_TelefoneKeyPressed

    }//GEN-LAST:event_edt_TelefoneKeyPressed
 
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
