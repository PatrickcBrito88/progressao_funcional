
package vision;

import control.PendenciaControl;
import utils.ConectaBanco;
import utils.SendMailTLSPendenciaBuilder;
import utils.SendMailTLSPendenciaSemMensagem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TelaEnvioEmailPendenciaAutomatico extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
    
    public TelaEnvioEmailPendenciaAutomatico(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraPendencia();
        geraComboPendentes();
    }
    
     public void geraPendencia(){
         PendenciaControl pendenciaControle = new PendenciaControl(bancoOf);
        pendenciaControle.truncaPendencia();
        pendenciaControle.geraPendencia();
    }

   public void geraComboPendentes(){
        jComboBoxPendente.removeAllItems();
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from pendencias group by mat_avaliadorpen order by nome_avaliadorpen");
        try {
            conecta.rs.first();
            do {
                jComboBoxPendente.addItem(conecta.rs.getString("nome_avaliadorpen"));
                                
            }while (conecta.rs.next());
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao criar jCombobox. "+ex);
        } finally {
            conecta.desconecta();
        }
        
        jTextFieldNumeroPendencia.setText(String.valueOf(setaNumeroPendencias(String.valueOf(jComboBoxPendente.getSelectedItem()))));
        jComboBoxPendente.addItem("Todos");
   }
    
    public int setaNumeroPendencias(String nome){
         conecta.conexao();
            conecta.executaPesquisaSQL("Select * from pendencias where nome_avaliadorpen='"
                    + nome+"'");
            
         int cont=0;    
        try {
            conecta.rs.first();
            cont=0;
            do{
                          
                cont+=1;
            }while (conecta.rs.next());
             } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao gerar numero de pendencias, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (nome.equals("Todos")){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from pendencias");
             try {
                 conecta.rs.first();
                 do{
                   cont++;
                 }while (conecta.rs.next());
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Erro ao somar todas as pendencias, motivo: "+ex);
             } finally {
                 conecta.desconecta();
             }
        }
        
        return cont;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxPendente = new javax.swing.JComboBox<>();
        jTextFieldNumeroPendencia = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Envio de Email - Cobrança de Pendências", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField1.setText("Enviando email para:");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField2.setText("Número de pendências:");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jComboBoxPendente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPendente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxPendenteFocusLost(evt);
            }
        });

        jTextFieldNumeroPendencia.setEditable(false);
        jTextFieldNumeroPendencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldNumeroPendencia.setText("xx");
        jTextFieldNumeroPendencia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Monitor.png"))); // NOI18N
        jButton2.setText("Visualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Apply.png"))); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPendente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNumeroPendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeroPendencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CobrançaPendencias pendencias = new CobrançaPendencias(bancoOf);
        String nome = String.valueOf(jComboBoxPendente.getSelectedItem());
        pendencias.iniciaTela(nome);
        pendencias.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void EnviaEmailAutomatico(){//busca o nome no combobox
        conecta.conexao();
        String nome = String.valueOf(jComboBoxPendente.getSelectedItem());
        conecta.executaPesquisaSQL("Select * from funcionario where nome_func='"+nome+"'");
        String email="";
        try {
            conecta.rs.first();
            email=conecta.rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar email do funcionário.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (email.equals("")){
            JOptionPane.showMessageDialog(null,"O funcionário "+nome+" ainda não cadastrou um email válido!");
        } else {

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Prezado(a) "+nome+",\n\n"
            + "Notamos que você possui pendência na realização da avaliaçao de desempenho"
            + " referente ao(s) seguinte(s) funcionário(s):\n\n");
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from pendencias where nome_avaliadorpen='"+nome+"' "
            + "order by nome_avaliadopen");
        try {
            conecta.rs.first();
            do{
                mensagem.append("-"+conecta.rs.getString("nome_avaliadoPen")+";\n");

            }while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao montar email. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        mensagem.append("\nSolicitamos que realize as avaliações mencionadas o mais rápido possível!\n\n"
            + "Att \n"
            + "Gerência de Recursos Humanos");

        SendMailTLSPendenciaBuilder mail = new SendMailTLSPendenciaBuilder();
        String email="";
        mail.MandaEmail(email, "Pendência Aferição de Desempenho: "+nome, mensagem);

        //       
        }
    }
    
    public void EnviaEmailParametro(String nome){//passa como parametro
        conecta.conexao();
        
        conecta.executaPesquisaSQL("Select * from funcionario where nome_func='"+nome+"'");
        String email="";
        try {
            conecta.rs.first();
            email=conecta.rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar email do funcionário.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (email.equals("")){
            JOptionPane.showMessageDialog(null,"O funcionário "+nome+" ainda não cadastrou um email válido!");
        } else {

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Prezado Funcionário,\n\n"
            + "Notamos que você possui pendência na realização da avaliaçao de desempenho"
            + " referente ao(s) seguinte(s) funcionário(s):\n\n");
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from pendencias where nome_avaliadorpen='"+nome+"' "
            + "order by nome_avaliadopen");
        try {
            conecta.rs.first();
            do{
                mensagem.append("-"+conecta.rs.getString("nome_avaliadoPen")+";\n");

            }while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao montar email. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        mensagem.append("\nSolicitamos que realize a(s) avaliação(ões) mencionada(s) o mais rápido possível!\n\n"
            + "Att \n"
            + "Gerência de Recursos Humanos");

        SendMailTLSPendenciaSemMensagem mail = new SendMailTLSPendenciaSemMensagem();
        String email;
        mail.MandaEmail(email, "Pendência Aferição de Desempenho: "+nome, mensagem);

        //       
        }
    }
    
    public void EnviaEmailMassa(){//falta testar com internet
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from pendencias");
        try {
            conecta.rs.first();
            do{
                EnviaEmailParametro(conecta.rs.getString("nome_avaliadorpen"));
                
            }while(conecta.rs.next());
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar destinatários para envio de email.");
        } finally {
            conecta.desconecta();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String destinatario = String.valueOf(jComboBoxPendente.getSelectedItem());
        if (!destinatario.equals("Todos")){
            EnviaEmailAutomatico();
        } else {
            EnviaEmailMassa();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxPendenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxPendenteFocusLost
       jTextFieldNumeroPendencia.setText(String.valueOf(setaNumeroPendencias(String.valueOf(jComboBoxPendente.getSelectedItem()))));
       String nome = String.valueOf(jComboBoxPendente.getSelectedItem());
       if (nome.equals("Todos")){
           jButton2.setEnabled(false);
       } else {
           jButton2.setEnabled(true);
       }
    }//GEN-LAST:event_jComboBoxPendenteFocusLost

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
            java.util.logging.Logger.getLogger(TelaEnvioEmailPendenciaAutomatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEnvioEmailPendenciaAutomatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEnvioEmailPendenciaAutomatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEnvioEmailPendenciaAutomatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEnvioEmailPendenciaAutomatico(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxPendente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldNumeroPendencia;
    // End of variables declaration//GEN-END:variables
}
