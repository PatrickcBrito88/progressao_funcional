
package vision;

import utils.ConectaBanco;
import utils.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class CobrançaPendencias extends javax.swing.JFrame {

     private static String bancoOf;
   ConectaBanco conecta;
   ConectaBanco conecta2;
   
    public CobrançaPendencias(String banco) {
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        conecta2 = new ConectaBanco(bancoOf);
        initComponents();
        
    }
    
    public void iniciaTela(String nome){
        preencherTabela("Select * from pendencias where nome_avaliadorpen='"+nome+"' "
                + "order by nome_avaliadopen");
    }

    public void preencherTabela(String sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Mat","Funcionário"};
        
        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
        do{
           
            
            
            dados.add(new Object[]{conecta.rs.getInt("Mat_avaliadoPen"), conecta.rs.getString("nome_avaliadoPen")});
            
        }while(conecta.rs.next());
        }catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao preencher o Array List!\n"+ex);
        }finally{
            conecta.desconecta();
        }
                        
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTablePendencia.setModel(modelo);
        jTablePendencia.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePendencia.getColumnModel().getColumn(0).setResizable(true);
        jTablePendencia.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTablePendencia.getColumnModel().getColumn(1).setResizable(true);
 
        jTablePendencia.getTableHeader().setReorderingAllowed(false);
        jTablePendencia.setAutoResizeMode(jTablePendencia.AUTO_RESIZE_OFF);
        jTablePendencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
       }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePendencia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avaliações Pendentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTablePendencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePendencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePendenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePendencia);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePendenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePendenciaMouseClicked
        
    }//GEN-LAST:event_jTablePendenciaMouseClicked

    
   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobrançaPendencias(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePendencia;
    // End of variables declaration//GEN-END:variables
}
