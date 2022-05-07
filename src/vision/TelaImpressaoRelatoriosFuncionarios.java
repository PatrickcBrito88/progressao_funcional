package vision;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control_tables.ListaGerenciaControl;
import control_tables.ListaMenuRecursosHumanos;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import models.FuncionarioModel;
import models.GerenciaModel;
import tables.ImagemTabela;
import tables.TabelaGerencia;
import tables.TabelaResumoGerhum;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.Relatorios;
import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;


public class TelaImpressaoRelatoriosFuncionarios extends javax.swing.JFrame {

     private static String bancoOf;
    ConectaBanco conecta;
    
    public TelaImpressaoRelatoriosFuncionarios(String banco) {
         this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
    }
    
    public void ImprimeRelatorio(){
      
         FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
         int matAvaliador=funcionario.getMatFunc(String.valueOf(jComboBoxAvaliador.getSelectedItem()));
         
    
    int matAvaliado = Integer.parseInt(jTextFieldMatricula.getText());
    String nomeAvaliado = jTextFieldNomeAvaliado.getText();
    String cargoAvaliado = jTextFieldCargo.getText();
    
    InputStream inputStream = getClass().getResourceAsStream("/Avaliação.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat_avaliador",matAvaliador);
        parametros.put("mat_avaliado",matAvaliado);
        parametros.put("Nome_avaliado",nomeAvaliado);
        parametros.put("cargo_avaliado",cargoAvaliado);
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("Avaliação", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
    }
     
       public void ImprimeRelatorioCParametros(int matAvaliador, int matAvaliado, String nomeAvaliado, String cargo_avaliado){
      
   
    String cargoAvaliado = jTextFieldCargo.getText();
    
    InputStream inputStream = getClass().getResourceAsStream("/Avaliação.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat_avaliador",matAvaliador);
        parametros.put("mat_avaliado",matAvaliado);
        parametros.put("Nome_avaliado",nomeAvaliado);
        parametros.put("cargo_avaliado",cargoAvaliado);
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("Avaliação", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
    }
       
     public void ImprimeRelatorioFinalFuncionario(){
       FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
       int mat=funcionario.getMatFunc(jTextFieldNomeAvaliado.getText());
       
        
    InputStream inputStream = getClass().getResourceAsStream("/RelatorioFinalFuncionario.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat",mat);
      
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("RelatorioFinalFuncionario", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
          
    }
    
    public void geraComboAvaliador(int avaliado){
        jComboBoxAvaliador.removeAllItems();
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from avaliacaov where mat_avaliado="+avaliado);
        try {
            conecta.rs.first();
            do{
            jComboBoxAvaliador.addItem(conecta.rs.getString("nome_func"));
        
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro combo Avaliador. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        jComboBoxAvaliador.removeItem("Admin");
        jComboBoxAvaliador.addItem("Maturidade Profissional");
        jComboBoxAvaliador.addItem("Resultado Final");
        jComboBoxAvaliador.addItem("Todos os Relatórios");
        
    }
            
     
    
    
    public void setaCampos(int mat){
        FuncionarioModel funcionarioModelo = new FuncionarioModel();
        FuncionarioControl funcionarioControl = new FuncionarioControl(bancoOf);
        String nome = funcionarioControl.getNome(mat);
        String cargo = funcionarioControl.getCargo(mat);
        jTextFieldCargo.setText(cargo);
        jTextFieldMatricula.setText(String.valueOf(mat));
        jTextFieldNomeAvaliado.setText(nome);
    }
    
    public void geraTodososRelatórios(){
        conecta.conexao();
        int avaliado=Integer.parseInt(jTextFieldMatricula.getText());
        conecta.executaPesquisaSQL("Select * from avaliacaov where mat_avaliado="+avaliado);
        try {
            conecta.rs.first();
            do{
                int matAvaliador=conecta.rs.getInt("mat_avaliador");
                int matAvaliado=avaliado;
                String nomeAvaliado=jTextFieldNomeAvaliado.getText();
                String cargo_avaliado =jTextFieldCargo.getText();
                ImprimeRelatorioCParametros(matAvaliador, matAvaliado, nomeAvaliado, cargo_avaliado);
                                     
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro todos os relatorios. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        ImprimeMaturidade();
        
        String cargo = jTextFieldCargo.getText();
        
        if (cargo.equals("Funcionário")){
        ImprimeRelatorioFinalFuncionario();
        } else {
            ImprimeRelatorioFinalGestor();
        }
        
    }
    
    public void ImprimeMaturidade(){
        
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        int mat=Integer.parseInt(jTextFieldMatricula.getText());
        
    InputStream inputStream = getClass().getResourceAsStream("/MaturidadeProfissional.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("matricula",mat);
      
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("MaturidadeProfissional", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
          
    }
    
    public void ImprimeRelatorioFinalGestor(){
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        int mat=Integer.parseInt(jTextFieldMatricula.getText());
       
        
    InputStream inputStream = getClass().getResourceAsStream("/RelatorioFinal.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat",mat);
      
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("RelatorioFinal", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
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
        jTextFieldNomeAvaliado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxAvaliador = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

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
        jLabel6.setText("Impressão de Relatórios");
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

        jTextFieldNomeAvaliado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNomeAvaliado.setText("Nome do funcionario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        jTextFieldMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMatricula.setText("Mat. do Funcionário");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cargo:");

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCargo.setText("Cargo do funcionário");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomeAvaliado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeAvaliado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMatricula)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCargo))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 600, 90));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 650, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Selecione o relatório desejado:");

        jComboBoxAvaliador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAvaliador, 0, 245, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 490, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/impressora.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
    }//GEN-LAST:event_formWindowActivated

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        String relatorio = String.valueOf(jComboBoxAvaliador.getSelectedItem());

        if (relatorio.equals("Resultado Final")){
            String cargo=jTextFieldCargo.getText();

            if (cargo.equals("Funcionário")){
                ImprimeRelatorioFinalFuncionario();
            } else {
                ImprimeRelatorioFinalGestor();
            }

        }

        if (relatorio.equals("Todos os Relatórios")){
            geraTodososRelatórios();
        }

        if (relatorio.equals("Maturidade Profissional")){
            ImprimeMaturidade();
        }

        if ((!(relatorio.equals("Resultado Final"))) && (!(relatorio.equals("Todos os Relatórios")))
            && (!(relatorio.equals("Maturidade Profissional")))){
            ImprimeRelatorio();
        }
    }//GEN-LAST:event_jLabel8MouseClicked

     
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
            java.util.logging.Logger.getLogger(TelaImpressaoRelatoriosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaImpressaoRelatoriosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaImpressaoRelatoriosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaImpressaoRelatoriosFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaImpressaoRelatoriosFuncionarios(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JComboBox<String> jComboBoxAvaliador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTextFieldCargo;
    private javax.swing.JLabel jTextFieldMatricula;
    private javax.swing.JLabel jTextFieldNomeAvaliado;
    // End of variables declaration//GEN-END:variables
}
