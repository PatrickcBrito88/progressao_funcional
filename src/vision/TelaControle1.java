
package vision;

import control.FuncionarioControl;
import utils.ConectaBanco;
import utils.ModeloTabela;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class TelaControle1 extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
 
    public TelaControle1(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        jTextField7.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
    }
    
    public boolean verificaSenha(){
        int matricula = Integer.parseInt(jTextFieldMat.getText());
       
        boolean continua = false;
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        String senha=funcionario.getSenha(matricula);
        
        
         if(senha.equals("")){
           continua=funcionario.PrimeiroAcesso(matricula);
         } else {
             
         }
         return continua;
    }
    
    public void setCampos(String nome, int matricula, String cargo){
        jTextFieldNomeFunc.setText(nome);
        jTextFieldMat.setText(String.valueOf(matricula));
        jTextFieldCargo.setText(cargo);
    }

    public void preencheTabela (int mat){
        preencherTabela("Select * from avaliadov where mat_avaliador="+mat);
    }
    
   public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Matrícula","Nome", "Cargo","Status"};
        
        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
        do{
            Boolean avaliado=conecta.rs.getBoolean("AvaliacaoConcluida");
            String avaliadostr = "";
            if (avaliado==true){
                avaliadostr="Avaliado";
            }else{
                avaliadostr="Não avaliado";
            }
            
            dados.add(new Object[]{conecta.rs.getInt("mat_avaliado"), conecta.rs.getString("Nome_func"),
                conecta.rs.getString("cargo_func"),avaliadostr});
            
        }while(conecta.rs.next());
        }catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao preencher o Array List!\n"+ex);
        }finally{
            conecta.desconecta();
        }
                        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableAvaliacoes.setModel(modelo);
        jTableAvaliacoes.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTableAvaliacoes.getColumnModel().getColumn(0).setResizable(true);
        jTableAvaliacoes.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableAvaliacoes.getColumnModel().getColumn(1).setResizable(true);
        jTableAvaliacoes.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTableAvaliacoes.getColumnModel().getColumn(2).setResizable(true);
        jTableAvaliacoes.getColumnModel().getColumn(3).setPreferredWidth(125);
        jTableAvaliacoes.getColumnModel().getColumn(3).setResizable(true);
        
        jTableAvaliacoes.getTableHeader().setReorderingAllowed(false);
        jTableAvaliacoes.setAutoResizeMode(jTableAvaliacoes.AUTO_RESIZE_OFF);
        jTableAvaliacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
       }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextFieldMat = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldNomeFunc = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAvaliacoes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Avaliação");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jTextField3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField3.setText("MATRÍCULA:");
        jTextField3.setBorder(null);
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextFieldMat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldMat.setText("MATRICULA");
        jTextFieldMat.setBorder(null);
        jTextFieldMat.setEnabled(false);
        jTextFieldMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField1.setForeground(java.awt.SystemColor.controlLtHighlight);
        jTextField1.setText("FUNCIONÁRIO:");
        jTextField1.setBorder(null);
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextFieldNomeFunc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldNomeFunc.setText("NOME FUNCIONÁRIO");
        jTextFieldNomeFunc.setBorder(null);
        jTextFieldNomeFunc.setEnabled(false);
        jTextFieldNomeFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeFuncActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField5.setText("CARGO:");
        jTextField5.setBorder(null);
        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextFieldCargo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldCargo.setText("MATRICULA");
        jTextFieldCargo.setBorder(null);
        jTextFieldCargo.setEnabled(false);
        jTextFieldCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeFunc, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCargo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMat)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField7.setBackground(new java.awt.Color(240, 240, 240));
        jTextField7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("GESTÃO DE DESEMPENHO");
        jTextField7.setBorder(null);
        jTextField7.setEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avaliações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jTableAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAvaliacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAvaliacoesMouseClicked(evt);
            }
        });
        jTableAvaliacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableAvaliacoesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAvaliacoes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pencil.png"))); // NOI18N
        jButton1.setText("Avaliar Selecionado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextFieldNomeFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeFuncActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextFieldMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMatActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextFieldCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCargoActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int matAdo =Integer.parseInt((""+jTableAvaliacoes.getValueAt(jTableAvaliacoes.getSelectedRow(), 0)));
        int matAdor = Integer.parseInt(jTextFieldMat.getText());
        String ado=String.valueOf((""+jTableAvaliacoes.getValueAt(jTableAvaliacoes.getSelectedRow(), 1)));
        String ador = jTextFieldNomeFunc.getText();
        String cargoAdo=String.valueOf((""+jTableAvaliacoes.getValueAt(jTableAvaliacoes.getSelectedRow(), 2)));
        String avaliado =String.valueOf((""+jTableAvaliacoes.getValueAt(jTableAvaliacoes.getSelectedRow(), 3)));
        String cargoAdor=jTextFieldCargo.getText();
        Tela_Avaliacao telaAvaliacao = new Tela_Avaliacao(bancoOf);
        telaAvaliacao.setCampos(matAdor, matAdo, ador, ado, cargoAdo, cargoAdor);
        telaAvaliacao.setAvaliacao(matAdo, matAdor);
        if (avaliado.equals("Não avaliado")){
            telaAvaliacao.setCamposZerados();
            
        } else {
            
        }
        
        
        telaAvaliacao.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableAvaliacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAvaliacoesMouseClicked
          if (evt.getClickCount() == 2) {
                                int linha = jTableAvaliacoes.getSelectedRow();
      
       
       int matAdo =Integer.parseInt((""+jTableAvaliacoes.getValueAt(linha, 0)));
        int matAdor = Integer.parseInt(jTextFieldMat.getText());
        String ado=String.valueOf((""+jTableAvaliacoes.getValueAt(linha, 1)));
        String ador = jTextFieldNomeFunc.getText();
        String cargoAdo=String.valueOf((""+jTableAvaliacoes.getValueAt(linha, 2)));
        String avaliado =String.valueOf((""+jTableAvaliacoes.getValueAt(linha, 3)));
        String cargoAdor=jTextFieldCargo.getText();
        Tela_Avaliacao telaAvaliacao = new Tela_Avaliacao(bancoOf);
        telaAvaliacao.setCampos(matAdor, matAdo, ador, ado, cargoAdo, cargoAdor);
        telaAvaliacao.setAvaliacao(matAdo, matAdor);
        if (avaliado.equals("Não avaliado")){
            telaAvaliacao.setCamposZerados();
            
        } else {
            
        }
        
        
        telaAvaliacao.setVisible(true);
        
    }   
    }//GEN-LAST:event_jTableAvaliacoesMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       int key = evt.getKeyCode();
       if (key==9){
            preencheTabela(Integer.parseInt(jTextFieldMat.getText()));
       }
    }//GEN-LAST:event_formKeyPressed

    private void jTableAvaliacoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAvaliacoesKeyPressed
      int key = evt.getKeyCode();
       if (key==9){
            preencheTabela(Integer.parseInt(jTextFieldMat.getText()));
       }
    }//GEN-LAST:event_jTableAvaliacoesKeyPressed

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
            java.util.logging.Logger.getLogger(TelaControle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaControle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaControle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaControle1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaControle1(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableAvaliacoes;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldMat;
    private javax.swing.JTextField jTextFieldNomeFunc;
    // End of variables declaration//GEN-END:variables
}
