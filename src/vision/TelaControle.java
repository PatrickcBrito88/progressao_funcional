package vision;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control_tables.ListaGerenciaControl;
import control_tables.ListaMenuRecursosHumanos;
import control_tables.ListaTabelaControleControl;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import model_tables.TabelaControleModel;
import models.GerenciaModel;
import tables.ImagemTabela;
import tables.TabelaGerencia;
import tables.TabelaResumoGerhum;
import tables.TabelaTelaControle;
import utils.ConectaBanco;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaControle extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;

    public TelaControle(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
       // jTextField7.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
    }

    public boolean verificaSenha() {
        int matricula = Integer.parseInt(jTextFieldMat.getText());

        boolean continua = false;
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        String senha = funcionario.getSenha(matricula);

        if (senha.equals("")) {
            continua = funcionario.PrimeiroAcesso(matricula);
        } else {

        }
        return continua;
    }

    public void setCampos(String nome, int matricula, String cargo) {
        jTextFieldNomeFunc.setText(nome);
        jTextFieldMat.setText(String.valueOf(matricula));
        jTextFieldCargo.setText(cargo);
    }

    public void preencheTabelaResumo() {
        ListaTabelaControleControl resumo = new ListaTabelaControleControl(bancoOf);
        ArrayList<TabelaControleModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela

        lista = resumo.listaTabelaControle(Integer.parseInt(jTextFieldMat.getText()));

        if (lista != null) {
            TabelaTelaControle tabelaControle = new TabelaTelaControle(lista);//Montar uma lista com a tabela Resumo

            jTableTelaControle.setDefaultRenderer(Object.class, new ImagemTabela());
            jTableTelaControle.setRowHeight(35);
            ((DefaultTableCellRenderer) jTableTelaControle.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) jTableTelaControle.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            jTableTelaControle.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            jTableTelaControle.getTableHeader().setOpaque(false);
            jTableTelaControle.getTableHeader().setBackground(new Color(0, 0, 0));
            jTableTelaControle.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            jTableTelaControle.setModel(tabelaControle);
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
        jTextFieldNomeGerencia = new javax.swing.JTextField();
        jTextFieldSigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeFunc = new javax.swing.JLabel();
        jTextFieldMat = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTelaControle = new javax.swing.JTable();

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
        jLabel6.setText("Gestão de Desempenho");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 450, 40));

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
        jLabel1.setText("Funcionário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        jTextFieldNomeGerencia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldNomeGerencia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNomeGerencia.setBorder(null);
        jTextFieldNomeGerencia.setOpaque(false);

        jTextFieldSigla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldSigla.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSigla.setBorder(null);
        jTextFieldSigla.setOpaque(false);
        jTextFieldSigla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSiglaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cargo:");

        jTextFieldNomeFunc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNomeFunc.setText("Funcionário");
        jTextFieldNomeFunc.setEnabled(false);

        jTextFieldMat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMat.setText("Matrícula");
        jTextFieldMat.setEnabled(false);

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCargo.setText("Cargo");
        jTextFieldCargo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeGerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeGerencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCargo))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 110));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 600, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableTelaControle.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTelaControle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTelaControleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTelaControle);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 650, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jTextFieldSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSiglaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSiglaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        preencheTabelaResumo();
    }//GEN-LAST:event_formWindowActivated

    private void jTableTelaControleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTelaControleMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = jTableTelaControle.getSelectedRow();

            int matAdo = Integer.parseInt(("" + jTableTelaControle.getValueAt(linha, 0)));
            int matAdor = Integer.parseInt(jTextFieldMat.getText());
            String ado = String.valueOf(("" + jTableTelaControle.getValueAt(linha, 1)));
            String ador = jTextFieldNomeFunc.getText();
            String cargoAdo = String.valueOf(("" + jTableTelaControle.getValueAt(linha, 2)));
            String avaliado = String.valueOf(("" + jTableTelaControle.getValueAt(linha, 3)));
            String cargoAdor = jTextFieldCargo.getText();
            Tela_Avaliacao_1 telaAvaliacao = new Tela_Avaliacao_1(bancoOf);
            telaAvaliacao.setCampos(matAdor, matAdo, ador, ado, cargoAdo, cargoAdor);
            telaAvaliacao.setAvaliacao(matAdo, matAdor);
            if (avaliado.equals("Não avaliado")) {
                telaAvaliacao.setCamposZerados();

            } else {

            }

            telaAvaliacao.setVisible(true);
        }

    }//GEN-LAST:event_jTableTelaControleMouseClicked

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
            java.util.logging.Logger.getLogger(TelaControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaControle(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableTelaControle;
    private javax.swing.JLabel jTextFieldCargo;
    private javax.swing.JLabel jTextFieldMat;
    private javax.swing.JLabel jTextFieldNomeFunc;
    private javax.swing.JTextField jTextFieldNomeGerencia;
    private javax.swing.JTextField jTextFieldSigla;
    // End of variables declaration//GEN-END:variables
}
