
package control;

import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class GerenciamentoSistemaControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public GerenciamentoSistemaControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    public int getStatusSistema(){
        conecta.conexao();
        int status=0;
        conecta.executaPesquisaSQL("Select * from gerenciamentosistema");
        try {
            conecta.rs.first();
            status =conecta.rs.getInt("idsistema");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, getStatusSistema.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        return status;
    }
    
    public int getStatusAvaliacao(){
        conecta.conexao();
        int status=0;
        conecta.executaPesquisaSQL("Select * from gerenciamentosistema");
        try {
            conecta.rs.first();
            status =conecta.rs.getInt("idtabelaavaliacao");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, getStatusSistema.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        return status;
    }
    
    public void AlteraSistema(String status){
        conecta.conexao();
        PreparedStatement pst;
        SistemaControl sistema = new SistemaControl(bancoOf);
        int id=sistema.getStatusSistema(status);
       
        try {
            pst=conecta.conn.prepareStatement("Update gerenciamentosistema set idSistema=? where "
                    + "idGerenciamentoSistema=?");
             pst.setInt(1, id);
             pst.setInt(2, 1);
             pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar sistema. \n"+ex);
        } finally {
            conecta.desconecta();
        }
       
    }
    
    public boolean verificaAvaliacoes(){
        conecta.conexao();
        boolean existe=false;
        int avaliacao=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador=92975");
       try {
           conecta.rs.first();
           avaliacao=conecta.rs.getInt("mat_avaliado");
           existe=true;
       } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao verificar se existe avaliação. \n"+ex);
       } finally {
           conecta.desconecta();
       }
       
       return existe;
    }
    
    public void AlteraStatusAvaliacao(){
        boolean verifica = verificaAvaliacoes();
        
        if (verifica==true){
           PreparedStatement pst;
           conecta.conexao();
            try {
                pst=conecta.conn.prepareStatement("Update gerenciamentosistema set idtabelaavaliacao=? "
                        + "where idgerenciamentosistema=? ");
            
           pst.setInt(1, 1);
           pst.setInt(2, 1);
           pst.executeUpdate();
           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro, ao alterar tabela avaliação. \n"+ex);
            } finally {
                conecta.desconecta();
            }
        } else {
            PreparedStatement pst;
           conecta.conexao();
            try {
                pst=conecta.conn.prepareStatement("Update gerenciamentosistema set idtabelaavaliacao=? "
                        + "where idgerenciamentosistema=? ");
            
           pst.setInt(1, 2);
           pst.setInt(2, 1);
           pst.executeUpdate();
           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro, ao alterar tabela avaliação. \n"+ex);
            } finally {
                conecta.desconecta();
            }
        }
    }
    
}
