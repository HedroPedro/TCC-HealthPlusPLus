package visao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    
    BufferedImage backImage;
    javax.swing.ImageIcon icon;
    
    public Principal(int nivelAcesso, Connection con) {
        try {
            this.backImage = ImageIO.read(getClass().getResource("/visao/imgs/Tela Principal Cadastro.jpg"));
            this.icon = new javax.swing.ImageIcon(getClass().getResource("/visao/imgs/ICON JAR ARCHIVE.png"));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientes = new JDBCCliente(con);
        agendamentos = new JDBCAgendamento(con);
        funcionario = new JDBCUsuario(con);
        tiposDeConsulta = new JDBCTiposDeConsulta(con);
        
        
        setVisible(true);
        initComponents();
        
        carregarTabelaCliente();
        carregarTabelaConsulta();
        
        pack();
        
        int largura = jTabbedPane1.getWidth();
        int altura = pn_guia_clientes.getHeight();
        
         
        if(nivelAcesso == 0){
            jTabbedPane1.remove(pn_guia_funcionarios);
            jTabbedPane1.remove(pn_guia_tipos_de_consulta);
        }else{
            carregarTabelaTipoDeConsulta();
            carregarTabelaFuncionarios();
            pn_guia_funcionarios.formatarImagem(largura, altura);
            pn_guia_tipos_de_consulta.formatarImagem(largura, altura);
        }
        
        pn_guia_clientes.formatarImagem(largura, altura);
        pn_guia_consultas.formatarImagem(largura, altura);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pn_guia_clientes = new visao.JBackgroundPanel(backImage);
        btn_excluir = new javax.swing.JButton();
        btn_novocadastro = new javax.swing.JButton();
        btn_editarlinha = new javax.swing.JButton();
        btn_novaconsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        pn_guia_consultas = new visao.JBackgroundPanel(backImage);
        jScrollPane2 = new javax.swing.JScrollPane();
        table_consultas = new javax.swing.JTable();
        btn_excluirC = new javax.swing.JButton();
        btn_editarC = new javax.swing.JButton();
        pn_guia_funcionarios = new visao.JBackgroundPanel(backImage);
        jScrollPane3 = new javax.swing.JScrollPane();
        table_funcionarios = new javax.swing.JTable();
        btn_editarF = new javax.swing.JButton();
        btn_cadastrarF = new javax.swing.JButton();
        btn_excluirF = new javax.swing.JButton();
        pn_guia_tipos_de_consulta = new visao.JBackgroundPanel(backImage);
        jScrollPane4 = new javax.swing.JScrollPane();
        table_tipos_de_consulta = new javax.swing.JTable();
        btn_editarTC = new javax.swing.JButton();
        btn_adicionarTC = new javax.swing.JButton();
        btn_excluirTC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Health++");
        setExtendedState(MAXIMIZED_BOTH);
        setFocusTraversalPolicyProvider(true);
        setIconImage(icon.getImage());
        setName("Menu Principal"); // NOI18N
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(getSize());

        pn_guia_clientes.setToolTipText("");
        pn_guia_clientes.setAlignmentX(0.0F);
        pn_guia_clientes.setAlignmentY(0.0F);
        pn_guia_clientes.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        pn_guia_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_guia_clientesMousePressed(evt);
            }
        });

        btn_excluir.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.setEnabled(false);
        btn_excluir.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_novocadastro.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_novocadastro.setText("Novo Cadastro");
        btn_novocadastro.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_novocadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novocadastroActionPerformed(evt);
            }
        });

        btn_editarlinha.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_editarlinha.setText("Editar");
        btn_editarlinha.setEnabled(false);
        btn_editarlinha.setPreferredSize(new java.awt.Dimension(220, 80));
        btn_editarlinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarlinhaActionPerformed(evt);
            }
        });

        btn_novaconsulta.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_novaconsulta.setText("Nova Consulta");
        btn_novaconsulta.setEnabled(false);
        btn_novaconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novaconsultaActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N

        table_clientes.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        table_clientes.getTableHeader().setFont(new java.awt.Font("Arial Black", 0, 16));
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
        table_clientes.setToolTipText("");
        table_clientes.setAlignmentX(0.0F);
        table_clientes.setAlignmentY(0.0F);
        table_clientes.setGridColor(new java.awt.Color(0, 0, 0));
        table_clientes.setName(""); // NOI18N
        table_clientes.setRowHeight(40);
        table_clientes.setShowGrid(true);
        table_clientes.getTableHeader().setReorderingAllowed(false);
        table_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_clientes);
        if (table_clientes.getColumnModel().getColumnCount() > 0) {
            table_clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
            table_clientes.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        javax.swing.GroupLayout pn_guia_clientesLayout = new javax.swing.GroupLayout(pn_guia_clientes);
        pn_guia_clientes.setLayout(pn_guia_clientesLayout);
        pn_guia_clientesLayout.setHorizontalGroup(
            pn_guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_guia_clientesLayout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(pn_guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_novocadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_novaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editarlinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        pn_guia_clientesLayout.setVerticalGroup(
            pn_guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_guia_clientesLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(pn_guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_guia_clientesLayout.createSequentialGroup()
                        .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editarlinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_novaconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_novocadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1069, 1069, 1069))
        );

        jTabbedPane1.addTab("Clientes", null, pn_guia_clientes, "");

        pn_guia_consultas.setAlignmentX(0.0F);
        pn_guia_consultas.setAlignmentY(0.0F);
        pn_guia_consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_guia_consultasMouseClicked(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_consultas.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        table_consultas.getTableHeader().setFont(new java.awt.Font("Arial Black", 0, 16));
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
        table_consultas.setAlignmentX(0.0F);
        table_consultas.setAlignmentY(0.0F);
        table_consultas.setGridColor(new java.awt.Color(0, 0, 0));
        table_consultas.setRowHeight(40);
        table_consultas.setRowMargin(10);
        table_consultas.setShowGrid(true);
        table_consultas.getTableHeader().setReorderingAllowed(false);
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

        btn_excluirC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirC.setText("Excluir");
        btn_excluirC.setEnabled(false);
        btn_excluirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirCActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pn_guia_consultasLayout = new javax.swing.GroupLayout(pn_guia_consultas);
        pn_guia_consultas.setLayout(pn_guia_consultasLayout);
        pn_guia_consultasLayout.setHorizontalGroup(
            pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1624, Short.MAX_VALUE)
            .addGroup(pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_consultasLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(73, 73, 73)
                    .addGroup(pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_excluirC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_editarC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 82, Short.MAX_VALUE)))
        );
        pn_guia_consultasLayout.setVerticalGroup(
            pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1766, Short.MAX_VALUE)
            .addGroup(pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_consultasLayout.createSequentialGroup()
                    .addGap(130, 600, Short.MAX_VALUE)
                    .addGroup(pn_guia_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_guia_consultasLayout.createSequentialGroup()
                            .addComponent(btn_excluirC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btn_editarC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 566, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Consultas", pn_guia_consultas);

        pn_guia_funcionarios.setAlignmentX(0.0F);
        pn_guia_funcionarios.setAlignmentY(0.0F);
        pn_guia_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_guia_funcionariosMouseClicked(evt);
            }
        });

        jScrollPane3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_funcionarios.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        table_funcionarios.getTableHeader().setFont(new java.awt.Font("Arial Black", 0, 16));
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
        table_funcionarios.setAlignmentX(0.0F);
        table_funcionarios.setAlignmentY(0.0F);
        table_funcionarios.setGridColor(new java.awt.Color(0, 0, 0));
        table_funcionarios.setRowHeight(40);
        table_funcionarios.setRowMargin(10);
        table_funcionarios.setShowGrid(true);
        table_funcionarios.getTableHeader().setReorderingAllowed(false);
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

        btn_excluirF.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirF.setText("Excluir");
        btn_excluirF.setEnabled(false);
        btn_excluirF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_guia_funcionariosLayout = new javax.swing.GroupLayout(pn_guia_funcionarios);
        pn_guia_funcionarios.setLayout(pn_guia_funcionariosLayout);
        pn_guia_funcionariosLayout.setHorizontalGroup(
            pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1624, Short.MAX_VALUE)
            .addGroup(pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_funcionariosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addGroup(pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_excluirF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_editarF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cadastrarF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pn_guia_funcionariosLayout.setVerticalGroup(
            pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1766, Short.MAX_VALUE)
            .addGroup(pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_funcionariosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pn_guia_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_guia_funcionariosLayout.createSequentialGroup()
                            .addGap(340, 340, 340)
                            .addComponent(btn_excluirF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btn_editarF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btn_cadastrarF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Funcionários", pn_guia_funcionarios);

        pn_guia_tipos_de_consulta.setAlignmentX(0.0F);
        pn_guia_tipos_de_consulta.setAlignmentY(0.0F);
        pn_guia_tipos_de_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_guia_tipos_de_consultaMouseClicked(evt);
            }
        });

        jScrollPane4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        table_tipos_de_consulta.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        table_tipos_de_consulta.getTableHeader().setFont(new java.awt.Font("Arial Black", 0, 16) {
        });
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
        table_tipos_de_consulta.setRowHeight(40);
        table_tipos_de_consulta.setRowMargin(15);
        table_tipos_de_consulta.setShowGrid(true);
        table_tipos_de_consulta.getTableHeader().setReorderingAllowed(false);
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

        btn_adicionarTC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_adicionarTC.setText("Adicionar");
        btn_adicionarTC.setMaximumSize(new java.awt.Dimension(87, 30));
        btn_adicionarTC.setMinimumSize(new java.awt.Dimension(87, 30));
        btn_adicionarTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarTCActionPerformed(evt);
            }
        });

        btn_excluirTC.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btn_excluirTC.setText("Excluir");
        btn_excluirTC.setEnabled(false);
        btn_excluirTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirTCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_guia_tipos_de_consultaLayout = new javax.swing.GroupLayout(pn_guia_tipos_de_consulta);
        pn_guia_tipos_de_consulta.setLayout(pn_guia_tipos_de_consultaLayout);
        pn_guia_tipos_de_consultaLayout.setHorizontalGroup(
            pn_guia_tipos_de_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_guia_tipos_de_consultaLayout.createSequentialGroup()
                .addContainerGap(1372, Short.MAX_VALUE)
                .addGroup(pn_guia_tipos_de_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_excluirTC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editarTC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_adicionarTC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(pn_guia_tipos_de_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_tipos_de_consultaLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 350, Short.MAX_VALUE)))
        );
        pn_guia_tipos_de_consultaLayout.setVerticalGroup(
            pn_guia_tipos_de_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_guia_tipos_de_consultaLayout.createSequentialGroup()
                .addContainerGap(1279, Short.MAX_VALUE)
                .addComponent(btn_excluirTC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_editarTC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_adicionarTC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(pn_guia_tipos_de_consultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_guia_tipos_de_consultaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Tipos de Consulta", pn_guia_tipos_de_consulta);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
        jTabbedPane1.setPreferredSize(getSize());
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
        btn_novaconsulta.setEnabled(true);
        btn_excluir.setEnabled(true);
        btn_editarlinha.setEnabled(true);
        btn_novaconsulta.setEnabled(true);
    }//GEN-LAST:event_table_clientesMouseClicked

    private void btn_novaconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaconsultaActionPerformed
        index = table_clientes.getSelectedRow();
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

    private void pn_guia_consultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_guia_consultasMouseClicked
        table_consultas.clearSelection();
        btn_editarC.setEnabled(false);
        btn_excluirC.setEnabled(false);
    }//GEN-LAST:event_pn_guia_consultasMouseClicked

    private void pn_guia_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_guia_funcionariosMouseClicked
        table_funcionarios.clearSelection();
        btn_editarF.setEnabled(false);
        btn_excluirF.setEnabled(false);
    }//GEN-LAST:event_pn_guia_funcionariosMouseClicked

    private void pn_guia_tipos_de_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_guia_tipos_de_consultaMouseClicked
        table_tipos_de_consulta.clearSelection();
        btn_excluirTC.setEnabled(false);
        btn_editarTC.setEnabled(false);
    }//GEN-LAST:event_pn_guia_tipos_de_consultaMouseClicked

    private void pn_guia_clientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_guia_clientesMousePressed
        table_clientes.clearSelection();
        btn_novaconsulta.setEnabled(false);
        btn_excluir.setEnabled(false);
        btn_editarlinha.setEnabled(false);
    }//GEN-LAST:event_pn_guia_clientesMousePressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private visao.JBackgroundPanel pn_guia_clientes;
    private visao.JBackgroundPanel pn_guia_consultas;
    private visao.JBackgroundPanel pn_guia_funcionarios;
    private visao.JBackgroundPanel pn_guia_tipos_de_consulta;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTable table_consultas;
    private javax.swing.JTable table_funcionarios;
    private javax.swing.JTable table_tipos_de_consulta;
    // End of variables declaration//GEN-END:variables

  }