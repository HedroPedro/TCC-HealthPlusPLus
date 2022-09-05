package visao;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelador.Conectador;
import modelador.JDBCAgendamento;
import modelador.JDBCCliente;
import modelos.Agendamento;
import modelos.Cliente;

public class Principal extends javax.swing.JFrame {
    JDBCCliente clientes = new JDBCCliente(new Conectador().abrirConnection());
    JDBCAgendamento agendamentos = new JDBCAgendamento(new Conectador().abrirConnection());
    int cod = 0;
            
    public Principal() {
        initComponents();
        carregarTabelaCliente();
        carregarTabelaConsulta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pn_guia_clientes = new javax.swing.JPanel();
        btn_excluir = new javax.swing.JButton();
        btn_novocadastro = new javax.swing.JButton();
        btn_editarlinha = new javax.swing.JButton();
        btn_novaconsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        lbl_fundo = new javax.swing.JLabel();
        pn_guia_consultas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_consultas = new javax.swing.JTable();
        btn_excluirC = new javax.swing.JButton();
        btn_editarC = new javax.swing.JButton();
        lbl_fundo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        pn_guia_clientes.setBackground(new java.awt.Color(153, 153, 153));
        pn_guia_clientes.setLayout(null);

        btn_excluir.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.setEnabled(false);
        btn_excluir.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        pn_guia_clientes.add(btn_excluir);
        btn_excluir.setBounds(1350, 380, 220, 80);

        btn_novocadastro.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_novocadastro.setText("Novo Cadastro");
        btn_novocadastro.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_novocadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novocadastroActionPerformed(evt);
            }
        });
        pn_guia_clientes.add(btn_novocadastro);
        btn_novocadastro.setBounds(1350, 650, 220, 80);

        btn_editarlinha.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_editarlinha.setText("Editar");
        btn_editarlinha.setEnabled(false);
        btn_editarlinha.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_editarlinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarlinhaActionPerformed(evt);
            }
        });
        pn_guia_clientes.add(btn_editarlinha);
        btn_editarlinha.setBounds(1350, 470, 220, 80);

        btn_novaconsulta.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_novaconsulta.setText("Nova Consulta");
        btn_novaconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novaconsultaActionPerformed(evt);
            }
        });
        pn_guia_clientes.add(btn_novaconsulta);
        btn_novaconsulta.setBounds(1350, 560, 220, 80);

        jScrollPane1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_clientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Telefone", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_clientes.setGridColor(new java.awt.Color(0, 0, 0));
        table_clientes.setShowGrid(true);
        table_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_clientes);
        if (table_clientes.getColumnModel().getColumnCount() > 0) {
            table_clientes.getColumnModel().getColumn(0).setResizable(false);
            table_clientes.getColumnModel().getColumn(1).setResizable(false);
            table_clientes.getColumnModel().getColumn(2).setResizable(false);
            table_clientes.getColumnModel().getColumn(3).setResizable(false);
            table_clientes.getColumnModel().getColumn(4).setResizable(false);
        }

        pn_guia_clientes.add(jScrollPane1);
        jScrollPane1.setBounds(35, 130, 1242, 600);

        lbl_fundo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbl_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Principal Cadastro.jpg"))); // NOI18N
        lbl_fundo.setMaximumSize(new java.awt.Dimension(1600, 805));
        lbl_fundo.setPreferredSize(new java.awt.Dimension(1600, 805));
        pn_guia_clientes.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 1600, 805);

        jTabbedPane1.addTab("Clientes", pn_guia_clientes);

        pn_guia_consultas.setBackground(new java.awt.Color(153, 153, 153));
        pn_guia_consultas.setLayout(null);

        jScrollPane2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_consultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_consultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data & Hora", "Preço", "Nome do Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_consultas.setGridColor(new java.awt.Color(0, 0, 0));
        table_consultas.setShowGrid(true);
        table_consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_consultasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_consultas);
        if (table_consultas.getColumnModel().getColumnCount() > 0) {
            table_consultas.getColumnModel().getColumn(0).setResizable(false);
            table_consultas.getColumnModel().getColumn(1).setResizable(false);
            table_consultas.getColumnModel().getColumn(2).setResizable(false);
            table_consultas.getColumnModel().getColumn(3).setResizable(false);
        }

        pn_guia_consultas.add(jScrollPane2);
        jScrollPane2.setBounds(35, 130, 1242, 600);

        btn_excluirC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirC.setText("Excluir");
        btn_excluirC.setEnabled(false);
        btn_excluirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirCActionPerformed(evt);
            }
        });
        pn_guia_consultas.add(btn_excluirC);
        btn_excluirC.setBounds(1350, 560, 220, 80);

        btn_editarC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_editarC.setText("Editar");
        btn_editarC.setEnabled(false);
        btn_editarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarCActionPerformed(evt);
            }
        });
        pn_guia_consultas.add(btn_editarC);
        btn_editarC.setBounds(1350, 650, 220, 80);

        lbl_fundo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Principal Cadastro.jpg"))); // NOI18N
        pn_guia_consultas.add(lbl_fundo2);
        lbl_fundo2.setBounds(0, 0, 1600, 805);

        jTabbedPane1.addTab("Consultas", pn_guia_consultas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

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

    private void table_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clientesMouseClicked
       int index = table_clientes.getSelectedRow();
       cod = Integer.parseInt(table_clientes.getModel().getValueAt(index, 0).toString());
       btn_excluir.setEnabled(true);
       btn_editarlinha.setEnabled(true);
       btn_novaconsulta.setEnabled(true);
    }//GEN-LAST:event_table_clientesMouseClicked

    private void table_consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_consultasMouseClicked
       int index = table_consultas.getSelectedRow();
       cod = Integer.parseInt(table_consultas.getModel().getValueAt(index, 0).toString());
       btn_excluirC.setEnabled(true);
       btn_editarC.setEnabled(true);
    }//GEN-LAST:event_table_consultasMouseClicked

    private void btn_excluirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirCActionPerformed
       if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este campo?", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            System.out.println(cod);
            agendamentos.deletarAgentademento(cod);
            carregarTabelaConsulta();
        }
    }//GEN-LAST:event_btn_excluirCActionPerformed

    private void btn_novaconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaconsultaActionPerformed
        int index = table_clientes.getSelectedRow();
        String nome = table_clientes.getModel().getValueAt(index, 1).toString();
        Agendar_Consulta consultaNova = new Agendar_Consulta(this, nome);
        consultaNova.setVisible(true);
        pn_guia_consultas.requestFocus();
    }//GEN-LAST:event_btn_novaconsultaActionPerformed

    private void btn_editarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarCActionPerformed
        int index = table_consultas.getSelectedRow();
        String nome = table_consultas.getModel().getValueAt(index, 3).toString();
        Editar_Linha_Consulta editarConsulta = new Editar_Linha_Consulta(cod, nome);
        editarConsulta.setVisible(true);
        carregarTabelaConsulta();
    }//GEN-LAST:event_btn_editarCActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este campo?", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            clientes.deletarCliente(cod);
            carregarTabelaCliente();
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_novocadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novocadastroActionPerformed
        new Cadastrar_Cliente().setVisible(true);
        pn_guia_clientes.requestFocus();
    }//GEN-LAST:event_btn_novocadastroActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        carregarTabelaCliente();
        carregarTabelaConsulta();
    }//GEN-LAST:event_formFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btn_editarlinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarlinhaActionPerformed
        int index = table_clientes.getSelectedRow();
        String nome = table_clientes.getModel().getValueAt(index, 1).toString();
        String endereco = table_clientes.getModel().getValueAt(index, 2).toString();
        String telefone = table_clientes.getModel().getValueAt(index, 3).toString();
        String CPF = table_clientes.getModel().getValueAt(index, 4).toString();
        new Editar_Linha_Cliente(nome, endereco, telefone, CPF, cod).setVisible(true);
        carregarTabelaCliente();
    }//GEN-LAST:event_btn_editarlinhaActionPerformed

      private void carregarTabelaCliente(){
        DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        modelo.setRowCount(0);
        for(Cliente cliente : clientes.listarCliente()){
            Object[] objeto = {cliente.getCodigo(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getCPF()};
            modelo.addRow(objeto);
            }
        }
   
       private void carregarTabelaConsulta(){
           DefaultTableModel model = (DefaultTableModel) table_consultas.getModel();
           model.setRowCount(0);
           SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
           for(Agendamento agendamento : agendamentos.listarAgendamentos()){
               Object[] objeto = {agendamento.getCodigo(), formatador.format(agendamento.getDatahora()), agendamento.getPreco(),  agendamento.getNome_cliente()};
                model.addRow(objeto);
           }
       }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editarC;
    private javax.swing.JButton btn_editarlinha;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirC;
    private javax.swing.JButton btn_novaconsulta;
    private javax.swing.JButton btn_novocadastro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_fundo2;
    private javax.swing.JPanel pn_guia_clientes;
    private javax.swing.JPanel pn_guia_consultas;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTable table_consultas;
    // End of variables declaration//GEN-END:variables

  }