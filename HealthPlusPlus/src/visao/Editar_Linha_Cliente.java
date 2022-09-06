package visao;

import javax.swing.JOptionPane;
import modelador.Conectador;
import modelador.JDBCCliente;
import modelos.Cliente;


public class Editar_Linha_Cliente extends javax.swing.JFrame {
    int cod;
    JDBCCliente modelaCliente = new JDBCCliente(new Conectador().abrirConnection());
    Principal p;
    /**
     * Creates new form Editar_Campo_Cliente
     */

    public Editar_Linha_Cliente(String nome, String endereco, String telefone, String CPF, int cod, Principal p){
        initComponents();
        this.cod = cod;
        edt_nome.setText(nome);
        edt_endereco.setText(endereco);
        edt_telefone.setText(telefone);
        edt_CPF.setText(CPF);
        this.p = p;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_confirmar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        edt_nome = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        lbl_CPF = new javax.swing.JLabel();
        lbl_endereco = new javax.swing.JLabel();
        edt_endereco = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        edt_telefone = new javax.swing.JFormattedTextField();
        edt_CPF = new javax.swing.JFormattedTextField();
        lbl_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 300));

        jPanel1.setLayout(null);

        btn_confirmar.setText("Confirmar");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_confirmar);
        btn_confirmar.setBounds(590, 230, 120, 40);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(450, 230, 120, 40);
        jPanel1.add(edt_nome);
        edt_nome.setBounds(30, 110, 340, 30);

        lbl_telefone.setText("Telefone:");
        jPanel1.add(lbl_telefone);
        lbl_telefone.setBounds(30, 150, 80, 30);

        lbl_CPF.setText("CPF:");
        jPanel1.add(lbl_CPF);
        lbl_CPF.setBounds(440, 150, 50, 30);

        lbl_endereco.setText("Endereço:");
        jPanel1.add(lbl_endereco);
        lbl_endereco.setBounds(390, 80, 90, 30);
        jPanel1.add(edt_endereco);
        edt_endereco.setBounds(390, 110, 320, 30);

        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(30, 80, 50, 30);
        try {
            edt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(edt_telefone);
        edt_telefone.setBounds(30, 180, 340, 30);

        try {
            edt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(edt_CPF);
        edt_CPF.setBounds(440, 180, 270, 30);

        lbl_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Editar Registro.jpg"))); // NOI18N

        lbl_fundo.setMaximumSize(new java.awt.Dimension(750, 300));
        jPanel1.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 750, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        if(edt_nome.getText().equals("") || edt_endereco.getText().equals("") || edt_telefone.getText().equals("") || edt_CPF.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Algumas dos campos está vazio");
        else{
            Cliente cliente = new Cliente(edt_nome.getText(), edt_telefone.getText(), edt_endereco.getText(), edt_CPF.getText());
            if(cliente.estaCertoCPF()){
                modelaCliente.atualizarCliente(cod, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getCPF());
                p.requestFocus();
                dispose();
            }else
                JOptionPane.showMessageDialog(null, "CPF inválido, tente outro");
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JFormattedTextField edt_CPF;
    private javax.swing.JTextField edt_endereco;
    private javax.swing.JTextField edt_nome;
    private javax.swing.JFormattedTextField edt_telefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_CPF;
    private javax.swing.JLabel lbl_endereco;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_telefone;
    // End of variables declaration//GEN-END:variables
}
