package visao;

import java.util.Random;
import javax.swing.JOptionPane;
import bibliotecas.GeradorSenha;
import modelador.JDBCUsuario;

/**
 *
 * @author Etec
 */
public class Editar_Linha_Funcionário extends javax.swing.JFrame {

    /**
     * Creates new form Editar_Linha_Funcionário
     */
    
    int cod;
    Principal p;
    JDBCUsuario usuarioEditado;
    
    public Editar_Linha_Funcionário(int cod, Principal p, JDBCUsuario usuarioEditado) {
        initComponents();
        this.cod = cod;
        this.p = p;
        this.usuarioEditado = usuarioEditado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_nome = new javax.swing.JLabel();
        edt_nome = new javax.swing.JTextField();
        lbl_nivelDeAcesso = new javax.swing.JLabel();
        Combo_NivelDeAcesso = new javax.swing.JComboBox<>();
        lbl_nome1 = new javax.swing.JLabel();
        edt_senha = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_gerarSenha = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 300));
        setMinimumSize(new java.awt.Dimension(750, 300));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(750, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 300));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 300));
        jPanel1.setLayout(null);

        lbl_nome.setText("Nome:");
        jPanel1.add(lbl_nome);
        lbl_nome.setBounds(30, 80, 50, 30);
        jPanel1.add(edt_nome);
        edt_nome.setBounds(30, 110, 340, 30);

        lbl_nivelDeAcesso.setText("Nível de acesso:");
        jPanel1.add(lbl_nivelDeAcesso);
        lbl_nivelDeAcesso.setBounds(440, 80, 190, 30);

        Combo_NivelDeAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Administrador" }));
        Combo_NivelDeAcesso.setSelectedIndex(-1);
        jPanel1.add(Combo_NivelDeAcesso);
        Combo_NivelDeAcesso.setBounds(440, 110, 250, 30);

        lbl_nome1.setText("Senha");
        jPanel1.add(lbl_nome1);
        lbl_nome1.setBounds(30, 160, 50, 30);
        jPanel1.add(edt_senha);
        edt_senha.setBounds(30, 192, 210, 30);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(440, 190, 120, 40);

        btn_gerarSenha.setText("Gerar senha");
        btn_gerarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerarSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_gerarSenha);
        btn_gerarSenha.setBounds(250, 190, 120, 30);

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_atualizar);
        btn_atualizar.setBounds(570, 190, 120, 40);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Editar Registro.jpg"))); // NOI18N
        jPanel1.add(lbl_background);
        lbl_background.setBounds(0, 0, 750, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_gerarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerarSenhaActionPerformed
        String senha = GeradorSenha.gerarSenha(new Random().nextInt(5, 8));
        edt_senha.setText(senha);
    }//GEN-LAST:event_btn_gerarSenhaActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        if(edt_nome.getText().equals("") || edt_senha.getText().equals("") || Combo_NivelDeAcesso.getSelectedIndex() == -1)
            JOptionPane.showMessageDialog(null, "Verifique os campos novamentes");
        else{
            usuarioEditado.editarUsuario(cod, edt_nome.getText(), edt_senha.getText(), Combo_NivelDeAcesso.getSelectedIndex());
            p.carregarTabelaFuncionarios();
            dispose();
        }
    }//GEN-LAST:event_btn_atualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_NivelDeAcesso;
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_gerarSenha;
    private javax.swing.JTextField edt_nome;
    private javax.swing.JTextField edt_senha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_nivelDeAcesso;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_nome1;
    // End of variables declaration//GEN-END:variables
}
