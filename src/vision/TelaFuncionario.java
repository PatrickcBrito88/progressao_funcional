package vision;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control_tables.ListaFuncionarioControl;
import control_tables.ListaGerenciaControl;
import control_tables.ListaMenuRecursosHumanos;
import model_tables.ListaFuncionarioModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import models.FuncionarioModel;
import models.GerenciaModel;
import tables.ImagemTabela;
import tables.TabelaFuncionario;
import tables.TabelaGerencia;
import tables.TabelaResumoGerhum;
import utils.ConectaBanco;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaFuncionario extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;

    public TelaFuncionario(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraComboCargo();
        preencheTabelaResumo();
        geraComboCat();
        geraComboAlocacao();
    }

    public void geraComboCat() {
        jComboBoxCat.removeAllItems();
        jComboBoxCat.addItem("Gerência");
        jComboBoxCat.addItem("Departamento");
        jComboBoxCat.addItem("Diretoria");
        jComboBoxCat.addItem("Gabinete");
    }

    public void geraComboAlocacao() {
        String cat = String.valueOf(jComboBoxCat.getSelectedItem());
        jComboBoxAloc.removeAllItems();
        if (cat.equals("Gerência")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from gerencia");
            try {
                conecta.rs.first();
                do {
                    jComboBoxAloc.addItem(conecta.rs.getString("sigla_ger"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();

            }
        }
        if (cat.equals("Departamento")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from departamento");
            try {
                conecta.rs.first();
                do {
                    jComboBoxAloc.addItem(conecta.rs.getString("sigla_dep"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
                jComboBoxAloc.removeItem("Admin");
            }
        }
        if (cat.equals("Diretoria")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from diretoria");
            try {
                conecta.rs.first();
                do {
                    jComboBoxAloc.addItem(conecta.rs.getString("sigla_diretoria"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null,"Erro ao buscar sigla diretoria, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }
        }
    }

    public void geraCampos(int mat, String cargo) {
        jTextFieldNome.setEnabled(false);
        jComboBoxAloc.setEnabled(false);
        jComboBoxCat.setEnabled(false);
        jButton1.setEnabled(false);

        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario where matricula_func=" + mat);
        try {
            conecta.rs.first();
            jTextFieldNome.setText(conecta.rs.getString("Nome_func"));
            jTextFieldNome.setText(String.valueOf(mat));
            jComboBoxCargo.setSelectedItem(cargo);
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void preencheTabelaResumo() {
        ListaFuncionarioControl resumo = new ListaFuncionarioControl(bancoOf);
        ArrayList<ListaFuncionarioModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela

       
        lista = resumo.listaTabelaFuncionario();

        if (lista != null) {
            TabelaFuncionario tabelaResumoAvaliadores = new TabelaFuncionario(lista);//Montar uma lista com a tabela Resumo

            jTableFuncionario.setDefaultRenderer(Object.class, new ImagemTabela());
            jTableFuncionario.setRowHeight(35);
            ((DefaultTableCellRenderer) jTableFuncionario.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) jTableFuncionario.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            jTableFuncionario.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            jTableFuncionario.getTableHeader().setOpaque(false);
            jTableFuncionario.getTableHeader().setBackground(new Color(0, 0, 0));
            jTableFuncionario.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            jTableFuncionario.setModel(tabelaResumoAvaliadores);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui eventos para esta referência!");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btn_close1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCargo = new javax.swing.JComboBox<>();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JLabel();
        jTextFieldMat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxAloc = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Funcionários");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 460, 40));

        jPanel14.setBackground(new java.awt.Color(160, 116, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel13.setBackground(new java.awt.Color(0, 60, 113));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        jPanel9.setBackground(new java.awt.Color(0, 60, 113));

        btn_close1.setBackground(new java.awt.Color(96, 83, 150));
        btn_close1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close1.setForeground(new java.awt.Color(255, 255, 255));
        btn_close1.setText("X");
        btn_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_close1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(btn_close1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 80, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNome.setBorder(null);
        jTextFieldNome.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Vinculação");

        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCatActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 60, 113));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton3.setText("Apagar");
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(160, 116, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton1.setText("Gravar ");
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(160, 116, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton2.setText("Editar");
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTextFieldMat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldMat.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldMat.setBorder(null);
        jTextFieldMat.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cat:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Alocação:");

        jComboBoxAloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxAloc, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxAloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 130));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 600, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 650, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSiglaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSiglaActionPerformed

    private void txtNomeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeBuscaActionPerformed

    private void txtNomeBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeBuscaKeyPressed

    }//GEN-LAST:event_txtNomeBuscaKeyPressed

    private void btn_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_close1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_close1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int matricula = Integer.parseInt(jTextFieldMat.getText());
        FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
        funcControle.deletaFuncionario(matricula);
        limpaCampos();
        preencheTabelaResumo();
        jButton1.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jComboBoxAloc.setEnabled(true);
        jComboBoxCat.setEnabled(true);
    }//GEN-LAST:event_jButton3MouseClicked

     public void limpaCampos(){
        jTextFieldNome.setText("");
        jTextFieldMat.setText("");
        
    }
     
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        FuncionarioModel funcModelo = new FuncionarioModel();
        funcModelo.setCargo(String.valueOf(jComboBoxCargo.getSelectedItem()));
        funcModelo.setNome(jTextFieldNome.getText());
        funcModelo.setMatricula(Integer.parseInt(jTextFieldMat.getText()));

        String cat = String.valueOf(jComboBoxCat.getSelectedItem());
        GerenciaControl gerencia = new GerenciaControl(bancoOf);
        String sigla = String.valueOf(jComboBoxAloc.getSelectedItem());
        boolean sinal = false;
        sinal = gerencia.verificaGerenciaDiretoria(gerencia.getIdGerencia(sigla));

        if (sinal == false) {

            if (cat.equals("Gerência")) {
                GerenciaControl gerenciaControle = new GerenciaControl(bancoOf);
                funcModelo.setIdGerencia(gerenciaControle.getIdGerencia(String.valueOf(jComboBoxAloc.getSelectedItem())));
                FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                funcControle.gravaFuncionarioGerencia(funcModelo);
                limpaCampos();
                preencheTabelaResumo();

            }
            if (cat.equals("Departamento")) {
                DepartamentoControl dptoControle = new DepartamentoControl(bancoOf);
                if (sigla.equals("DEPCI")) {
                    funcModelo.setIdDepartamento(dptoControle.getIdDpto(String.valueOf(jComboBoxAloc.getSelectedItem())));
                    FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                    funcControle.gravaFuncionarioDepartamento(funcModelo);
                    limpaCampos();
                    preencheTabelaResumo();
                } else {
                    funcModelo.setIdDiretoria(dptoControle.getIdDiretoria(sigla));
                    funcModelo.setIdDepartamento(dptoControle.getIdDpto(String.valueOf(jComboBoxAloc.getSelectedItem())));
                    FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                    funcControle.gravaFuncionarioDepartamento(funcModelo);
                    limpaCampos();
                    preencheTabelaResumo();
                }

            }
            if (cat.equals("Diretoria")) {
                DiretoriaControl diretoriaControle = new DiretoriaControl(bancoOf);
                funcModelo.setIdDiretoria(diretoriaControle.getIdDiretoria(String.valueOf(jComboBoxAloc.getSelectedItem())));
                FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                funcControle.gravaFuncionarioDiretoria(funcModelo);
                limpaCampos();
                preencheTabelaResumo();
            }

        } else {
            funcModelo.setIdDiretoria(gerencia.getidDiretoria(gerencia.getIdGerencia(sigla)));

            if (cat.equals("Gerência")) {
                GerenciaControl gerenciaControle = new GerenciaControl(bancoOf);
                funcModelo.setIdGerencia(gerenciaControle.getIdGerencia(String.valueOf(jComboBoxAloc.getSelectedItem())));
                FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                funcControle.gravaFuncionarioGerenciaCD(funcModelo);
                limpaCampos();
                preencheTabelaResumo();
            }
            if (cat.equals("Departamento")) {
                DepartamentoControl dptoControle = new DepartamentoControl(bancoOf);
                if (sigla.equals("DEPCI")) {
                    funcModelo.setIdDepartamento(dptoControle.getIdDpto(String.valueOf(jComboBoxAloc.getSelectedItem())));
                    FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                    funcControle.gravaFuncionarioDepartamento(funcModelo);
                    limpaCampos();
                    preencheTabelaResumo();
                } else {
                    funcModelo.setIdDiretoria(dptoControle.getIdDiretoria(sigla));
                    funcModelo.setIdDepartamento(dptoControle.getIdDpto(String.valueOf(jComboBoxAloc.getSelectedItem())));
                    FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                    funcControle.gravaFuncionarioDepartamento(funcModelo);
                    limpaCampos();
                    preencheTabelaResumo();
                }
            }
            if (cat.equals("Diretoria") || (cat.equals("Gabinete"))) {
                DiretoriaControl diretoriaControle = new DiretoriaControl(bancoOf);
                funcModelo.setIdDiretoria(diretoriaControle.getIdDiretoria(String.valueOf(jComboBoxAloc.getSelectedItem())));
                FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
                funcControle.gravaFuncionarioDiretoriaCD(funcModelo);
                limpaCampos();
                preencheTabelaResumo();
            }
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        FuncionarioModel funcModel = new FuncionarioModel();
        funcModel.setCargo(String.valueOf(jComboBoxCargo.getSelectedItem()));
        funcModel.setMatricula(Integer.parseInt(jTextFieldMat.getText()));
        funcModel.setNome(jTextFieldNome.getText());

        FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
        funcControle.editaFuncionario(funcModel);
        limpaCampos();
        preencheTabelaResumo();
        jButton1.setEnabled(true);
        jComboBoxCat.setEnabled(true);
        jComboBoxAloc.setEnabled(true);
        jTextFieldNome.setEnabled(true);
    }//GEN-LAST:event_jButton2MouseClicked

    public void geraComboCargo() {
        jComboBoxCargo.removeAllItems();
        jComboBoxCargo.addItem("Funcionário");
        jComboBoxCargo.addItem("Gerente");
        jComboBoxCargo.addItem("Chefe");
        jComboBoxCargo.addItem("Diretor");
        jComboBoxCargo.addItem("Chefe de Gabinete");
        jComboBoxCargo.addItem("Assessor da Presidência");
        jComboBoxCargo.addItem("Assessor de Imprensa");
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jComboBoxCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCatActionPerformed

    }//GEN-LAST:event_jComboBoxCatActionPerformed

    private void jTableFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionarioMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = jTableFuncionario.getSelectedRow();
            String mat = String.valueOf(("" + jTableFuncionario.getValueAt(linha, 0)));
            String nome = String.valueOf(("" + jTableFuncionario.getValueAt(linha, 1)));
            String cargo = String.valueOf(("" + jTableFuncionario.getValueAt(linha, 2)));
            jTextFieldNome.setText(nome);
            jTextFieldMat.setText(mat);
            jComboBoxCargo.setSelectedItem(cargo);

            jTextFieldMat.setEnabled(false);
            jButton1.setEnabled(false);
            jTextFieldNome.setEnabled(true);
            jComboBoxCat.setEnabled(false);
            jComboBoxAloc.setEnabled(false);

        }
    }//GEN-LAST:event_jTableFuncionarioMouseClicked

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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JLabel jButton1;
    private javax.swing.JLabel jButton2;
    private javax.swing.JLabel jButton3;
    private javax.swing.JComboBox<String> jComboBoxAloc;
    private javax.swing.JComboBox<String> jComboBoxCargo;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTextField jTextFieldMat;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
