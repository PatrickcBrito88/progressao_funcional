
package vision;

import control.FuncionarioControl;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.ModeloTabela;
import utils.Relatorios;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;


public class LogAvaliacao extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
   
    public LogAvaliacao(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        PreencheTabela();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLog = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextFieldAvaliador = new javax.swing.JTextField();
        jTextFieldAvaliado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableLog.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableLog);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setText("Filtrar por Matrícula de Avaliador:");
        jTextField1.setBorder(null);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField2.setText("Filtrar por Matrícula de Avaliado:");
        jTextField2.setBorder(null);

        jTextFieldAvaliador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAvaliadorKeyPressed(evt);
            }
        });

        jTextFieldAvaliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAvaliadoKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Print.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAvaliado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAvaliador, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAvaliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAvaliadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAvaliadorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            
             String ador = (jTextFieldAvaliador.getText());
             if (ador.equals("")){
                 PreencheTabela();
                 
             } else {
                 int adorInt=Integer.parseInt(ador);
                 preencherTabela("Select * from logavaliacao where log_idavaliador="+ador);
                                 
             }
         }
    }//GEN-LAST:event_jTextFieldAvaliadorKeyPressed

    private void jTextFieldAvaliadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAvaliadoKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            
             String ado = (jTextFieldAvaliado.getText());
             if (ado.equals("")){
                 PreencheTabela();
                 
             } else {
                 int adoInt=Integer.parseInt(ado);
                 preencherTabela("Select * from logavaliacao where log_idavaliado="+ado);
                                 
             }
         }
    }//GEN-LAST:event_jTextFieldAvaliadoKeyPressed

     public void ImprimeLog(){
        
        
        
    InputStream inputStream = getClass().getResourceAsStream("/Log.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
      
      
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("Log", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
          
    }
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImprimeLog();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void PreencheTabela(){
        preencherTabela("Select * from logavaliacao order by idlogavaliacao");
    }
   
    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Id","Avaliador","Avaliado","Data","IP"};
        
        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
        do{
            
            dados.add(new Object[]{conecta.rs.getInt("idlogavaliacao"), conecta.rs.getInt("log_idavaliador"),
            conecta.rs.getInt("log_idavaliado"), conecta.rs.getTimestamp("log_data"), conecta.rs.getString("log_ip")});
            
        }while(conecta.rs.next());
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Lista Vazia!");
        }finally{
            conecta.desconecta();
        }
                        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableLog.setModel(modelo);
        jTableLog.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableLog.getColumnModel().getColumn(0).setResizable(true);
        jTableLog.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableLog.getColumnModel().getColumn(1).setResizable(true);
        jTableLog.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableLog.getColumnModel().getColumn(2).setResizable(true);
        jTableLog.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableLog.getColumnModel().getColumn(3).setResizable(true);
        jTableLog.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTableLog.getColumnModel().getColumn(4).setResizable(true);
        jTableLog.getTableHeader().setReorderingAllowed(false);
        jTableLog.setAutoResizeMode(jTableLog.AUTO_RESIZE_OFF);
        jTableLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
       }
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogAvaliacao(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLog;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldAvaliado;
    private javax.swing.JTextField jTextFieldAvaliador;
    // End of variables declaration//GEN-END:variables
}
