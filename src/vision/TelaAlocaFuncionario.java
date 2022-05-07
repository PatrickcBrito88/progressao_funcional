package vision;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control.RemanejamentoCorreto;
import control_tables.ListaGerenciaControl;
import control_tables.ListaMenuRecursosHumanos;
import control_tables.ListaRemanejamentoControl;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import model_tables.ListaRemanejamentoModel;
import models.FuncionarioModel;
import models.GerenciaModel;
import tables.ImagemTabela;
import tables.TabelaGerencia;
import tables.TabelaRemanejamento;
import tables.TabelaResumoGerhum;
import utils.ConectaBanco;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class TelaAlocaFuncionario extends javax.swing.JFrame {

    
     private static String bancoOf;
    ConectaBanco conecta;
     
    public TelaAlocaFuncionario(String banco) {
     this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraComboDe();
        geraComboPara();
        preencheTabelaDe();
        preencheTabelaPara();
        habilitaCampo();
    }
    
    public void preencheTabelaDe() {
        ListaRemanejamentoControl resumo = new ListaRemanejamentoControl(bancoOf);
        ArrayList<ListaRemanejamentoModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela
       String sigla=String.valueOf(jComboBoxDe.getSelectedItem());     
       
        lista = resumo.listaTabelaRemanejamento(sigla);
       
        if (lista != null) {
            TabelaRemanejamento tabelaResumoAvaliadores = new TabelaRemanejamento(lista);//Montar uma lista com a tabela Resumo
            
            jTableDe.setDefaultRenderer(Object.class, new ImagemTabela());
            jTableDe.setRowHeight(35);
            ((DefaultTableCellRenderer) jTableDe.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) jTableDe.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            jTableDe.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            jTableDe.getTableHeader().setOpaque(false);
            jTableDe.getTableHeader().setBackground(new Color(0, 0, 0));
            jTableDe.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            jTableDe.setModel(tabelaResumoAvaliadores);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }

    }
    
    public void habilitaCampo(){
        String opcao=String.valueOf(jComboBoxDe.getSelectedItem());
        if (opcao.equals("Sem Setor")){
            jTextFieldBusca.setEnabled(true);
        } else {
            jTextFieldBusca.setEnabled(false);
        }
    }
    
    public void preencheTabelaNome() {
        ListaRemanejamentoControl resumo = new ListaRemanejamentoControl(bancoOf);
        ArrayList<ListaRemanejamentoModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela
       String nome=jTextFieldBusca.getText();
       
        lista = resumo.listaTabelaRemanejamentoNome(nome);
       
        if (lista != null) {
            TabelaRemanejamento tabelaResumoAvaliadores = new TabelaRemanejamento(lista);//Montar uma lista com a tabela Resumo
            
            jTableDe.setDefaultRenderer(Object.class, new ImagemTabela());
            jTableDe.setRowHeight(35);
            ((DefaultTableCellRenderer) jTableDe.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) jTableDe.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            jTableDe.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            jTableDe.getTableHeader().setOpaque(false);
            jTableDe.getTableHeader().setBackground(new Color(0, 0, 0));
            jTableDe.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            jTableDe.setModel(tabelaResumoAvaliadores);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
        }

    }
    
        public void preencheTabelaPara() {
        ListaRemanejamentoControl resumo = new ListaRemanejamentoControl(bancoOf);
        ArrayList<ListaRemanejamentoModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela
       String sigla=String.valueOf(jComboBoxPara.getSelectedItem());     
       
        lista = resumo.listaTabelaRemanejamento(sigla);
       
        if (lista != null) {
            TabelaRemanejamento tabelaResumoAvaliadores = new TabelaRemanejamento(lista);//Montar uma lista com a tabela Resumo
            
            jTablePara.setDefaultRenderer(Object.class, new ImagemTabela());
            jTablePara.setRowHeight(35);
            ((DefaultTableCellRenderer) jTablePara.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) jTablePara.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            jTablePara.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            jTablePara.getTableHeader().setOpaque(false);
            jTablePara.getTableHeader().setBackground(new Color(0, 0, 0));
            jTablePara.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            jTablePara.setModel(tabelaResumoAvaliadores);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
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
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPara = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePara = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDe = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDe = new javax.swing.JTable();
        jTextFieldBusca = new javax.swing.JTextField();

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
        jLabel6.setText("Remanejamento de Funcionários");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 390, 40));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 80, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 570, 20));

        jButton3.setBackground(new java.awt.Color(0, 60, 113));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton3.setText("Transferir");
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 130, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Para");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jComboBoxPara.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxParaActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBoxPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 275, 30));

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
        jScrollPane1.setViewportView(jTablePara);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 150));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 520, 210));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("De");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jComboBoxDe.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDeActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 11, 275, 30));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 152, 10));

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
        jScrollPane2.setViewportView(jTableDe);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 150));

        jTextFieldBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldBusca.setBorder(null);
        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyPressed(evt);
            }
        });
        jPanel6.add(jTextFieldBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 150, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 520, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
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
    }//GEN-LAST:event_jButton3MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    
    }//GEN-LAST:event_formWindowActivated

    private void jComboBoxDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDeActionPerformed
         preencheTabelaDe();
         habilitaCampo();
    }//GEN-LAST:event_jComboBoxDeActionPerformed

    private void jComboBoxParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxParaActionPerformed
       preencheTabelaPara();
    }//GEN-LAST:event_jComboBoxParaActionPerformed

    private void jTextFieldBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
             String nome = jTextFieldBusca.getText();
             preencheTabelaNome();
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
            java.util.logging.Logger.getLogger(TelaAlocaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlocaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlocaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlocaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlocaFuncionario(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JLabel jButton3;
    private javax.swing.JComboBox<String> jComboBoxDe;
    private javax.swing.JComboBox<String> jComboBoxPara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableDe;
    private javax.swing.JTable jTablePara;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
