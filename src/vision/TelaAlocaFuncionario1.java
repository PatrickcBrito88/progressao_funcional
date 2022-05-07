
package vision;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control.RemanejamentoControl;
import control.RemanejamentoCorreto;
import models.FuncionarioModel;
import utils.ConectaBanco;
import utils.ModeloTabela;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class TelaAlocaFuncionario1 extends javax.swing.JFrame {

     private static String bancoOf;
    ConectaBanco conecta;
    
    public TelaAlocaFuncionario1(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraComboDe();
        geraComboPara();
        preencheTabelaDe();
        preencheTabelaPara();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDe = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxDe = new javax.swing.JComboBox<>();
        jTextFieldBusca = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePara = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxPara = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alocação de Funcionários");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableDe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableDe);

        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setText("De:");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setEnabled(false);

        jComboBoxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxDeFocusLost(evt);
            }
        });

        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTablePara.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablePara);

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setText("Para:");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField2.setEnabled(false);

        jComboBoxPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPara.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxParaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(37, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Refresh.png"))); // NOI18N
        jButton1.setText("Transferir");
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxDeFocusLost
        preencheTabelaDe();
    }//GEN-LAST:event_jComboBoxDeFocusLost

    private void jComboBoxParaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxParaFocusLost
        preencheTabelaPara();
    }//GEN-LAST:event_jComboBoxParaFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String destino = String.valueOf(jComboBoxPara.getSelectedItem());
        char letra1=destino.charAt(0);
        char letra2=destino.charAt(1);
        
        
        if ((letra1=='G')&&(letra2=='E')){//gerencia
        GerenciaControl gerenciaControle = new GerenciaControl(bancoOf);
        int idGerencia=gerenciaControle.getIdGerencia(destino);
        int mat = Integer.parseInt((""+jTableDe.getValueAt(jTableDe.getSelectedRow(), 0)));
        FuncionarioControl funcionarioControle = new FuncionarioControl(bancoOf);
        FuncionarioModel funcionario = new FuncionarioModel();
        DepartamentoControl dpto = new DepartamentoControl(bancoOf);
        RemanejamentoCorreto remanejamento = new RemanejamentoCorreto(bancoOf);
         funcionario=remanejamento.destinoGerencia(idGerencia, mat);
              
        funcionarioControle.remanejaFuncionario(funcionario);
        } 
        
        
        if ((letra1=='D')&&(letra2=='E')){
        DepartamentoControl dpto = new DepartamentoControl(bancoOf);
        int idDpto = dpto.getIdDpto(String.valueOf(jComboBoxPara.getSelectedItem()));
        int mat = Integer.parseInt((""+jTableDe.getValueAt(jTableDe.getSelectedRow(), 0)));
        FuncionarioControl funcionarioControle = new FuncionarioControl(bancoOf);
        FuncionarioModel funcionario = new FuncionarioModel();
        
        RemanejamentoCorreto remanejamento = new RemanejamentoCorreto(bancoOf);
         funcionario=remanejamento.destinoDepartamento(idDpto, mat);
         
        funcionarioControle.remanejaFuncionario(funcionario);
        
        }
        
        if (((letra1=='D')&&(letra2=='I'))||((letra1=='G')&&(letra2=='A'))||((letra1=='A')&&(letra2=='S'))){
        DiretoriaControl diretoria = new DiretoriaControl(bancoOf);
        int idDiretoria=diretoria.getIdDiretoria(destino);
        int mat = Integer.parseInt((""+jTableDe.getValueAt(jTableDe.getSelectedRow(), 0)));
        FuncionarioControl funcionarioControle = new FuncionarioControl(bancoOf);
        FuncionarioModel funcionario = new FuncionarioModel();
        RemanejamentoCorreto remanejamento = new RemanejamentoCorreto(bancoOf);
         funcionario=remanejamento.destinoDiretoria(idDiretoria, mat);
        
        funcionarioControle.remanejaFuncionario(funcionario);
       
        }    
        
         if ((letra1=='S')&&(letra2=='e')){//gerencia
         int mat = Integer.parseInt((""+jTableDe.getValueAt(jTableDe.getSelectedRow(), 0)));
         FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
         
         funcionario.RemanejaSemSetor(mat);
             
         }
               

        preencheTabelaDe();
        preencheTabelaPara();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
             String nome = jTextFieldBusca.getText();
             preencherTabelaDe("Select * from todos where sigla_dep is null "
                     + "and sigla_ger is null and sigla_diretoria is null"
                     + " and nome_func like '"+nome+"%'");
         }
    }//GEN-LAST:event_jTextFieldBuscaKeyPressed

    
    public void geraComboDe(){
       jComboBoxDe.removeAllItems();
       conecta.conexao();
       conecta.executaPesquisaSQL("Select * from gerencia");
        try {
            conecta.rs.first();
            do{
                jComboBoxDe.addItem(conecta.rs.getString("Sigla_ger"));
                                
            }while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
           
        }
        
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamento");
        try {
            conecta.rs.first();
        
        do{
           jComboBoxDe.addItem(conecta.rs.getString("sigla_dep"));
        }while(conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from diretoria");
        try {
            conecta.rs.first();
        
        do{
           jComboBoxDe.addItem(conecta.rs.getString("sigla_diretoria"));
        }while(conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        jComboBoxDe.addItem("Sem Setor");
         jComboBoxDe.removeItem("Admin");
       
    }
    
    public void geraComboPara(){
       jComboBoxPara.removeAllItems();
       conecta.conexao();
       conecta.executaPesquisaSQL("Select * from gerencia");
        try {
            conecta.rs.first();
            do{
                jComboBoxPara.addItem(conecta.rs.getString("Sigla_ger"));
                                
            }while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamento");
        try {
            conecta.rs.first();
        
        do{
           jComboBoxPara.addItem(conecta.rs.getString("sigla_dep"));
        }while(conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from diretoria");
        try {
            conecta.rs.first();
        
        do{
           jComboBoxPara.addItem(conecta.rs.getString("sigla_diretoria"));
        }while(conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
         jComboBoxPara.addItem("Sem Setor");
         jComboBoxPara.removeItem("Admin");
       
    }
    
    public void preencheTabelaDe(){
        String sigla = String.valueOf(jComboBoxDe.getSelectedItem());
        
        if (sigla.equals("Sem Setor")){
            preencherTabelaDe("Select * from todos where sigla_ger is null"
                    + " and sigla_dep is null and sigla_diretoria is null"
                    + " and (matricula_func <> 888) and (matricula_func<>78659) order by nome_func");
            jTextFieldBusca.setEnabled(true);
            
        }else{
        
        preencherTabelaDe("Select * from todos where "
                + "sigla_ger='"+sigla+"' or sigla_dep='"+sigla+"'"+
                " or (sigla_diretoria='"+sigla+"' and departamento_iddepartamento_func"
                        + " is null and gerencia_idgerencias_func is null) order by nome_func");
        jTextFieldBusca.setEnabled(false);
        }
    }
    
     public void preencheTabelaPara(){
        String sigla = String.valueOf(jComboBoxPara.getSelectedItem());
        
        if (sigla.equals("Sem Setor")){
            preencherTabelaPara("Select * from todos where sigla_ger is null"
                    + " and sigla_dep is null and sigla_diretoria is null"
                    + " order by nome_func");
        } else {
        
        preencherTabelaPara("Select * from todos where "
                + "sigla_ger='"+sigla+"' or sigla_dep='"+sigla+"'"+
                " or (sigla_diretoria='"+sigla+"' and departamento_iddepartamento_func"
                        + " is null and gerencia_idgerencias_func is null) order by nome_func");
        }
    }
    
    public void preencherTabelaDe(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Mat", "Nome"};
        
        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
        do{
            
            dados.add(new Object[]{conecta.rs.getInt("matricula_func"), 
                conecta.rs.getString("nome_func")});
            
        }while(conecta.rs.next());
        }catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao preencher o Array List!\n"+ex);
        }finally{
            conecta.desconecta();
        }
                        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableDe.setModel(modelo);
        jTableDe.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableDe.getColumnModel().getColumn(0).setResizable(true);
        jTableDe.getColumnModel().getColumn(1).setPreferredWidth(352);
        jTableDe.getColumnModel().getColumn(1).setResizable(true);
        jTableDe.getTableHeader().setReorderingAllowed(false);
        jTableDe.setAutoResizeMode(jTableDe.AUTO_RESIZE_OFF);
        jTableDe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
       }
    
    public void preencherTabelaPara(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Mat", "Nome"};
        
        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
        do{
            
            dados.add(new Object[]{conecta.rs.getInt("matricula_func"), 
                conecta.rs.getString("nome_func")});
            
        }while(conecta.rs.next());
        }catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao preencher o Array List!\n"+ex);
        }finally{
            conecta.desconecta();
        }
                        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePara.setModel(modelo);
        jTablePara.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePara.getColumnModel().getColumn(0).setResizable(true);
        jTablePara.getColumnModel().getColumn(1).setPreferredWidth(335);
        jTablePara.getColumnModel().getColumn(1).setResizable(true);
        jTablePara.getTableHeader().setReorderingAllowed(false);
        jTablePara.setAutoResizeMode(jTablePara.AUTO_RESIZE_OFF);
        jTablePara.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
       }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlocaFuncionario1(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxDe;
    private javax.swing.JComboBox<String> jComboBoxPara;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDe;
    private javax.swing.JTable jTablePara;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
