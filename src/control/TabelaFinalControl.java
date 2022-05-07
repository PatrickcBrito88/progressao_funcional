
package control;

import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TabelaFinalControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public TabelaFinalControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    public void insereTabelaFinal(int mat){
        conecta.conexao();
        PreparedStatement pst;
        
        try {
            pst=conecta.conn.prepareStatement("Insert into tabelafinal (matriculaTf, notacorrigidagestor_nf,"
                    + " notacorrigidaauto_nf, notacorrigidainvertida_nf, notacorrigidamaturidade_nf,"
                    + " notafinal_nf) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, mat);
            pst.setDouble(2, 0);
            pst.setDouble(3, 0);
            pst.setDouble(4, 0);
            pst.setDouble(5, 0);
            pst.setDouble(6, 0);
            pst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao incluir Tabela Final. \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public void editaNotaCorrigidaGestorTF(int mat, double nota){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set notacorrigidagestor_nf=?"
                    + " where matriculatf=?");
            pst.setDouble(1, nota);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao editar notaCorrigidaGestorTabelaFinal. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        editaSituacao(mat);
      
    }
    
    public void editaNotaCorrigidaAutoTF(int mat, double nota){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set notacorrigidaauto_nf=?"
                    + " where matriculatf=?");
            pst.setDouble(1, nota);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao editar notaCorrigidaAutoTabelaFinal. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
         editaSituacao(mat);
    }
    
    public void editaNotaCorrigidaInvertidaTF(int mat, double nota){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set notacorrigidainvertida_nf=?"
                    + " where matriculatf=?");
            pst.setDouble(1, nota);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao editar notaCorrigidaInvTabelaFinal. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
         editaSituacao(mat);
    }
    
    public void editaNotaCorrigidaMaturidadeTF(int mat, double nota){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set notacorrigidamaturidade_nf=?"
                    + " where matriculatf=?");
            pst.setDouble(1, nota);
            pst.setInt(2, mat);
            pst.executeLargeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao editar notaCorrigidaMaturidadeTabelaFinal. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
         editaSituacao(mat);
    }
    
    public void editaNotaFinalTF(int mat, String nota){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set notafinal_nf=?"
                    + " where matriculatf=?");
            pst.setString(1, nota);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao editar NotaFinalTF. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
         editaSituacao(mat);
    }
    
    public void editaSituacao (int mat){
        conecta.conexao();
        double notaFinal=0;
        conecta.executaPesquisaSQL("Select * from nota_percentual_total where "
                + "funcionario_matricula_func_pt="+mat);
        try {
            conecta.rs.first();
            notaFinal=conecta.rs.getDouble("percentual_total");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Erro ao buscar NotaFinal Edita Situação. \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        conecta.conexao();
        
        PreparedStatement pst;
        String situacao="";
        if (notaFinal>=0.7){
            situacao="Promovido";
        } else {
            situacao="Não Promovido";
        }
        
        try {
            pst=conecta.conn.prepareStatement("Update tabelafinal set situacaofinal_nf=?"
                    + " where matriculatf=?");
            pst.setString(1, situacao);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao alterar situação. \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }
}
