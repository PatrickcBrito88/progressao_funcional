
package vision;

import control.FuncionarioControl;
import models.FuncionarioModel;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.Relatorios;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


public class TelaImpressaoRelatorios extends javax.swing.JFrame {

     private static String bancoOf;
    ConectaBanco conecta;
   
    public TelaImpressaoRelatorios(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraComboFuncionario();
        setaCampos(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        geraComboAvaliador(Integer.parseInt(jTextFieldMatricula.getText()));
    }
    
     public void ImprimeRelatorio(){
      
         FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
         int matAvaliador=funcionario.getMatFunc(String.valueOf(jComboBoxAvaliador.getSelectedItem()));
         
    
    int matAvaliado = Integer.parseInt(jTextFieldMatricula.getText());
    String nomeAvaliado = String.valueOf(jComboBoxFuncionario.getSelectedItem());
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
       int mat=funcionario.getMatFunc(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
       
        
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
            
     
    public void geraComboFuncionario(){
        conecta.conexao();
        jComboBoxFuncionario.removeAllItems();
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            
            do{
                jComboBoxFuncionario.addItem(conecta.rs.getString("Nome_func"));
                
            }while (conecta.rs.next());
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao montar combo funcionario. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        jComboBoxFuncionario.removeItem("Admin");
        jComboBoxFuncionario.removeItem("Invertida");
     
    }
    
    public void setaCampos(String nome){
        FuncionarioModel funcionarioModelo = new FuncionarioModel();
        FuncionarioControl funcionarioControl = new FuncionarioControl(bancoOf);
        int mat=funcionarioControl.getMatFunc(nome);
        String cargo = funcionarioControl.getCargo(mat);
        jTextFieldCargo.setText(cargo);
        jTextFieldMatricula.setText(String.valueOf(mat));
        
    }
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBoxFuncionario = new javax.swing.JComboBox<>();
        jTextFieldMatricula = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jComboBoxAvaliador = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir Avaliações");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Funcionário Avaliado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setText("Nome:");
        jTextField1.setBorder(null);
        jTextField1.setEnabled(false);

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setText("Matrícula:");
        jTextField2.setBorder(null);
        jTextField2.setEnabled(false);

        jTextField3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField3.setText("Cargo:");
        jTextField3.setBorder(null);
        jTextField3.setEnabled(false);

        jComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxFuncionarioFocusLost(evt);
            }
        });

        jTextFieldMatricula.setEnabled(false);

        jTextFieldCargo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCargo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o Relatório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jTextField4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField4.setText("Relatório:");
        jTextField4.setBorder(null);
        jTextField4.setEnabled(false);

        jComboBoxAvaliador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Print.png"))); // NOI18N
        jButton1.setText("Imprime Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAvaliador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxFuncionarioFocusLost
        setaCampos(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        geraComboAvaliador(Integer.parseInt(jTextFieldMatricula.getText()));
    }//GEN-LAST:event_jComboBoxFuncionarioFocusLost

    public void geraTodososRelatórios(){
        conecta.conexao();
        int avaliado=Integer.parseInt(jTextFieldMatricula.getText());
        conecta.executaPesquisaSQL("Select * from avaliacaov where mat_avaliado="+avaliado);
        try {
            conecta.rs.first();
            do{
                int matAvaliador=conecta.rs.getInt("mat_avaliador");
                int matAvaliado=avaliado;
                String nomeAvaliado=String.valueOf(jComboBoxFuncionario.getSelectedItem());
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
        int mat=funcionario.getMatFunc(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        
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
        int mat=funcionario.getMatFunc(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
       
        
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
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaImpressaoRelatorios(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxAvaliador;
    private javax.swing.JComboBox<String> jComboBoxFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldMatricula;
    // End of variables declaration//GEN-END:variables
}
