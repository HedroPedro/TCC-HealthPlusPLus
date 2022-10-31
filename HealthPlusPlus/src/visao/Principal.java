package visao;

import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelador.JDBCAgendamento;
import modelador.JDBCCliente;
import modelador.JDBCTiposDeConsulta;
import modelador.JDBCUsuario;
import modelos.Agendamento;
import modelos.Cliente;
import modelos.TiposDeConsulta;
import modelos.Usuario;

public class Principal extends javax.swing.JFrame {
    JDBCCliente clientes;
    JDBCAgendamento agendamentos;
    JDBCUsuario funcionario;
    JDBCTiposDeConsulta tiposDeConsulta;
    
    int cod = 0;
    int index = 0;
    final int X, Y;
    
    public Principal(int nivelAcesso, Connection con) {
        clientes = new JDBCCliente(con);
        agendamentos = new JDBCAgendamento(con);
        funcionario = new JDBCUsuario(con);
        tiposDeConsulta = new JDBCTiposDeConsulta(con);
        
        Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        
        X = d.width;
        Y = d.height;
        
        initComponents();
        carregarTabelaCliente();
        carregarTabelaConsulta();
        if(nivelAcesso == 0){
            jTabbedPane1.remove(pn_guia_funcionarios);
            jTabbedPane1.remove(pn_guia_tipos_de_consulta);
        }else{
            carregarTabelaTipoDeConsulta();
            carregarTabelaFuncionarios();
        }
        setImageIcon();
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
        pn_guia_funcionarios = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_funcionarios = new javax.swing.JTable();
        btn_editarF = new javax.swing.JButton();
        btn_cadastrarF = new javax.swing.JButton();
        btn_excluirF = new javax.swing.JButton();
        lbl_fundo3 = new javax.swing.JLabel();
        pn_guia_tipos_de_consulta = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_tipos_de_consulta = new javax.swing.JTable();
        btn_editarTC = new javax.swing.JButton();
        btn_adicionarTC = new javax.swing.JButton();
        btn_excluirTC = new javax.swing.JButton();
        lbl_fundo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Health++");
        setExtendedState(MAXIMIZED_BOTH);
        setName("Menu Principal"); // NOI18N

        jPanel1.setMinimumSize(getPreferredSize());
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTabbedPane1.setMaximumSize(getSize());
        jTabbedPane1.setMinimumSize(getSize());
        jTabbedPane1.setPreferredSize(null);
        jTabbedPane1.setSize(getSize());

        pn_guia_clientes.setBackground(new java.awt.Color(153, 153, 153));
        pn_guia_clientes.setPreferredSize(new java.awt.Dimension(1000, 1000));
        pn_guia_clientes.setSize(getSize());
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
        lbl_fundo.setIcon(SetBackground());
        lbl_fundo.setMaximumSize(new java.awt.Dimension(1600, 805));
        lbl_fundo.setPreferredSize(new java.awt.Dimension(1600, 805));
        lbl_fundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_fundoMouseClicked(evt);
            }
        });
        pn_guia_clientes.add(lbl_fundo);
        lbl_fundo.setBounds(0, 0, 1600, 970);

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
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        btn_editarC.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_editarC.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_editarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarCActionPerformed(evt);
            }
        });
        pn_guia_consultas.add(btn_editarC);
        btn_editarC.setBounds(1350, 650, 220, 80);

        lbl_fundo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_fundo2MouseClicked(evt);
            }
        });
        pn_guia_consultas.add(lbl_fundo2);
        lbl_fundo2.setBounds(0, 0, 1600, 805);

        jTabbedPane1.addTab("Consultas", pn_guia_consultas);

        pn_guia_funcionarios.setBackground(new java.awt.Color(153, 153, 153));
        pn_guia_funcionarios.setAlignmentX(0.0F);
        pn_guia_funcionarios.setAlignmentY(0.0F);
        pn_guia_funcionarios.setPreferredSize(pn_guia_clientes.getPreferredSize());
        pn_guia_funcionarios.setLayout(null);

        jScrollPane3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_funcionarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nível de Acesso", "Nome", "Senha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        table_funcionarios.setGridColor(new java.awt.Color(0, 0, 0));
        table_funcionarios.setShowGrid(true);
        table_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_funcionarios);
        if (table_funcionarios.getColumnModel().getColumnCount() > 0) {
            table_funcionarios.getColumnModel().getColumn(0).setResizable(false);
            table_funcionarios.getColumnModel().getColumn(1).setResizable(false);
            table_funcionarios.getColumnModel().getColumn(2).setResizable(false);
            table_funcionarios.getColumnModel().getColumn(3).setResizable(false);
        }

        pn_guia_funcionarios.add(jScrollPane3);
        jScrollPane3.setBounds(35, 130, 1242, 600);

        btn_editarF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_editarF.setText("Editar");
        btn_editarF.setEnabled(false);
        btn_editarF.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_editarF.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_editarF.setPreferredSize(new java.awt.Dimension(87, 30));
        btn_editarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarFActionPerformed(evt);
            }
        });
        pn_guia_funcionarios.add(btn_editarF);
        btn_editarF.setBounds(1330, 560, 220, 80);

        btn_cadastrarF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_cadastrarF.setLabel("Cadastrar");
        btn_cadastrarF.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_cadastrarF.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_cadastrarF.setPreferredSize(new java.awt.Dimension(87, 30));
        btn_cadastrarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarFActionPerformed(evt);
            }
        });
        pn_guia_funcionarios.add(btn_cadastrarF);
        btn_cadastrarF.setBounds(1330, 650, 220, 80);

        btn_excluirF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirF.setText("Excluir");
        btn_excluirF.setEnabled(false);
        btn_excluirF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirFActionPerformed(evt);
            }
        });
        pn_guia_funcionarios.add(btn_excluirF);
        btn_excluirF.setBounds(1330, 470, 220, 80);

        lbl_fundo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_fundo3MouseClicked(evt);
            }
        });
        pn_guia_funcionarios.add(lbl_fundo3);
        lbl_fundo3.setBounds(0, 0, 1600, 805);

        jTabbedPane1.addTab("Funcionários", pn_guia_funcionarios);

        pn_guia_tipos_de_consulta.setBackground(new java.awt.Color(153, 153, 153));
        pn_guia_tipos_de_consulta.setAlignmentX(0.0F);
        pn_guia_tipos_de_consulta.setAlignmentY(0.0F);
        pn_guia_tipos_de_consulta.setLayout(null);

        jScrollPane4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_tipos_de_consulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_tipos_de_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_tipos_de_consulta.setGridColor(new java.awt.Color(0, 0, 0));
        table_tipos_de_consulta.setShowGrid(true);
        table_tipos_de_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_tipos_de_consultaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_tipos_de_consulta);
        if (table_tipos_de_consulta.getColumnModel().getColumnCount() > 0) {
            table_tipos_de_consulta.getColumnModel().getColumn(0).setResizable(false);
            table_tipos_de_consulta.getColumnModel().getColumn(1).setResizable(false);
            table_tipos_de_consulta.getColumnModel().getColumn(2).setResizable(false);
        }

        pn_guia_tipos_de_consulta.add(jScrollPane4);
        jScrollPane4.setBounds(35, 130, 1242, 600);

        btn_editarTC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_editarTC.setText("Editar");
        btn_editarTC.setEnabled(false);
        btn_editarTC.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_editarTC.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_editarTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarTCActionPerformed(evt);
            }
        });
        pn_guia_tipos_de_consulta.add(btn_editarTC);
        btn_editarTC.setBounds(1350, 550, 220, 80);

        btn_adicionarTC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_adicionarTC.setText("Adicionar");
        btn_adicionarTC.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_adicionarTC.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_adicionarTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarTCActionPerformed(evt);
            }
        });
        pn_guia_tipos_de_consulta.add(btn_adicionarTC);
        btn_adicionarTC.setBounds(1350, 650, 220, 80);

        btn_excluirTC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirTC.setText("Excluir");
        btn_excluirTC.setEnabled(false);
        btn_excluirTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirTCActionPerformed(evt);
            }
        });
        pn_guia_tipos_de_consulta.add(btn_excluirTC);
        btn_excluirTC.setBounds(1350, 450, 220, 80);

        lbl_fundo4.setAlignmentY(0.0F);
        lbl_fundo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_fundo4MouseClicked(evt);
            }
        });
        pn_guia_tipos_de_consulta.add(lbl_fundo4);
        lbl_fundo4.setBounds(0, 0, 1600, 805);

        jTabbedPane1.addTab("Tipos de Consulta", pn_guia_tipos_de_consulta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void btn_editarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarCActionPerformed
        index = table_consultas.getSelectedRow();
        String nome = table_consultas.getModel().getValueAt(index, 3).toString();
        new Editar_Linha_Consulta(cod, nome, this).setVisible(true);
        pn_guia_consultas.requestFocus();
    }//GEN-LAST:event_btn_editarCActionPerformed

    private void btn_excluirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirCActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este campo?", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            agendamentos.deletarAgentademento(cod);
            carregarTabelaConsulta();
        }
    }//GEN-LAST:event_btn_excluirCActionPerformed

    private void table_consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_consultasMouseClicked
        index = table_consultas.getSelectedRow();
        cod = Integer.parseInt(table_consultas.getModel().getValueAt(index, 0).toString());
        btn_excluirC.setEnabled(true);
        btn_editarC.setEnabled(true);
    }//GEN-LAST:event_table_consultasMouseClicked

    private void table_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clientesMouseClicked
        index = table_clientes.getSelectedRow();
        cod = Integer.parseInt(table_clientes.getModel().getValueAt(index, 0).toString());
        btn_excluir.setEnabled(true);
        btn_editarlinha.setEnabled(true);
        btn_novaconsulta.setEnabled(true);
    }//GEN-LAST:event_table_clientesMouseClicked

    private void btn_novaconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaconsultaActionPerformed
        int index = table_clientes.getSelectedRow();
        String nome = table_clientes.getModel().getValueAt(index, 1).toString();
        Agendar_Consulta consultaNova = new Agendar_Consulta(cod, nome, this);
        consultaNova.setVisible(true);
        pn_guia_consultas.requestFocus();
        carregarTabelaConsulta();
    }//GEN-LAST:event_btn_novaconsultaActionPerformed

    private void btn_editarlinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarlinhaActionPerformed
        index = table_clientes.getSelectedRow();
        String nome = table_clientes.getModel().getValueAt(index, 1).toString();
        String endereco = table_clientes.getModel().getValueAt(index, 2).toString();
        String telefone = table_clientes.getModel().getValueAt(index, 3).toString();
        String CPF = table_clientes.getModel().getValueAt(index, 4).toString();
        new Editar_Linha_Cliente(nome, endereco, telefone, CPF, cod, this).setVisible(true);
    }//GEN-LAST:event_btn_editarlinhaActionPerformed

    private void btn_novocadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novocadastroActionPerformed
        new Cadastrar_Cliente(this, clientes).setVisible(true);
    }//GEN-LAST:event_btn_novocadastroActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este campo?", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            clientes.deletarCliente(cod);
            carregarTabelaCliente();
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void table_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_funcionariosMouseClicked
        btn_editarF.setEnabled(true);
        btn_excluirF.setEnabled(true);
        index = table_funcionarios.getSelectedRow();
        cod = (int) table_funcionarios.getModel().getValueAt(index, 0);
        
    }//GEN-LAST:event_table_funcionariosMouseClicked

    private void table_tipos_de_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_tipos_de_consultaMouseClicked
        btn_excluirTC.setEnabled(true);
        btn_editarTC.setEnabled(true);
        index = table_tipos_de_consulta.getSelectedRow();
        cod = (int) table_tipos_de_consulta.getModel().getValueAt(index, 0);
    }//GEN-LAST:event_table_tipos_de_consultaMouseClicked

    private void btn_cadastrarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarFActionPerformed
        new Cadastrar_Funcionario(funcionario, this).setVisible(true);
    }//GEN-LAST:event_btn_cadastrarFActionPerformed

    private void btn_editarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarFActionPerformed
        new Editar_Linha_Funcionário(cod, this, funcionario).setVisible(true);
    }//GEN-LAST:event_btn_editarFActionPerformed

    private void btn_excluirFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirFActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este funcionário", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            funcionario.excluirUsuario(cod);
            carregarTabelaFuncionarios();
        }
    }//GEN-LAST:event_btn_excluirFActionPerformed

    private void btn_editarTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarTCActionPerformed
        String nome = table_tipos_de_consulta.getModel().getValueAt(index, 1).toString();
        String preco = table_tipos_de_consulta.getModel().getValueAt(index, 2).toString();
        new EditarECadastrar_Linha_TipoDeConsulta(cod, tiposDeConsulta, this, nome, preco).setVisible(true);
    }//GEN-LAST:event_btn_editarTCActionPerformed

    private void btn_adicionarTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarTCActionPerformed
       new EditarECadastrar_Linha_TipoDeConsulta(tiposDeConsulta, this).setVisible(true);
    }//GEN-LAST:event_btn_adicionarTCActionPerformed

    private void btn_excluirTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirTCActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja excluir este tipo de consulta?", "Aviso", JOptionPane.YES_NO_OPTION) == 0){
            tiposDeConsulta.excluirTipoDeConsulta(cod);
            carregarTabelaTipoDeConsulta();
            carregarTabelaConsulta();
        }
    }//GEN-LAST:event_btn_excluirTCActionPerformed

    private void lbl_fundoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fundoMouseClicked
        btn_novaconsulta.setEnabled(false);
        btn_editarlinha.setEnabled(false);
        btn_excluir.setEnabled(false);
        table_clientes.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lbl_fundoMouseClicked

    private void lbl_fundo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fundo2MouseClicked
        btn_editarC.setEnabled(false);
        btn_excluirC.setEnabled(false);
        table_consultas.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lbl_fundo2MouseClicked

    private void lbl_fundo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fundo4MouseClicked
        btn_editarTC.setEnabled(false);
        btn_excluirTC.setEnabled(false);
        table_tipos_de_consulta.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lbl_fundo4MouseClicked

    private void lbl_fundo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fundo3MouseClicked
        btn_editarF.setEnabled(false);
        btn_excluirF.setEnabled(false);
        table_funcionarios.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lbl_fundo3MouseClicked

      final void carregarTabelaCliente(){
        DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        modelo.setRowCount(0);
        for(Cliente cliente : clientes.listarCliente()){
            Object[] objeto = {cliente.getCodigo(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getCPF()};
            modelo.addRow(objeto);
            }
        }
   
       final void carregarTabelaConsulta(){
           DefaultTableModel model = (DefaultTableModel) table_consultas.getModel();
           model.setRowCount(0);
           SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
           for(Agendamento agendamento : agendamentos.listarAgendamentos()){
               Object[] objeto = {agendamento.getCodigo(), formatador.format(agendamento.getDatahora()),  String.format("%.2f", agendamento.getPreco()),  agendamento.getNome_cliente()};
                model.addRow(objeto);
           }
       }
       
       final void carregarTabelaFuncionarios(){
           DefaultTableModel model = (DefaultTableModel) table_funcionarios.getModel();
           model.setRowCount(0);
           for(Usuario usuario : funcionario.pegarFuncionarios()){
               Object[] objeto = {usuario.getCod(), usuario.getNivelDeAcesso(), usuario.getNome(), usuario.getSenha()};
               model.addRow(objeto);
           }
       }
       final void carregarTabelaTipoDeConsulta(){
           DefaultTableModel model = (DefaultTableModel) table_tipos_de_consulta.getModel();
           model.setRowCount(0);
           for(TiposDeConsulta tipoDeConsulta : tiposDeConsulta.pegarTiposDeConsulta()){
               Object[] objeto = {tipoDeConsulta.getCodigo(), tipoDeConsulta.getNomeConsulta(), String.format("%.2f", tipoDeConsulta.getPreco())};
               model.addRow(objeto);
           }
       }
       
    private void setImageIcon(){
        javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/ICON JAR ARCHIVE.png"));
        this.setIconImage(imageIcon.getImage());
       }
    
    private javax.swing.ImageIcon SetBackground(){
        javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/Tela Principal Cadastro - X.jpg"));
        System.out.println(getToolkit().getScreenSize());
        Image img = imageIcon.getImage().getScaledInstance(pn_guia_clientes.getDebugGraphicsOptions(), lbl_fundo.getHeight(), java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(img);
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionarTC;
    private javax.swing.JButton btn_cadastrarF;
    private javax.swing.JButton btn_editarC;
    private javax.swing.JButton btn_editarF;
    private javax.swing.JButton btn_editarTC;
    private javax.swing.JButton btn_editarlinha;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirC;
    private javax.swing.JButton btn_excluirF;
    private javax.swing.JButton btn_excluirTC;
    private javax.swing.JButton btn_novaconsulta;
    private javax.swing.JButton btn_novocadastro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_fundo2;
    private javax.swing.JLabel lbl_fundo3;
    private javax.swing.JLabel lbl_fundo4;
    private javax.swing.JPanel pn_guia_clientes;
    private javax.swing.JPanel pn_guia_consultas;
    private javax.swing.JPanel pn_guia_funcionarios;
    private javax.swing.JPanel pn_guia_tipos_de_consulta;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTable table_consultas;
    private javax.swing.JTable table_funcionarios;
    private javax.swing.JTable table_tipos_de_consulta;
    // End of variables declaration//GEN-END:variables

  }