
package control;

import models.DiretoriaModel;
import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DiretoriaControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public DiretoriaControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    
    public void insereDiretoria (DiretoriaModel diretoria){
       conecta.conexao();
       PreparedStatement pst;
       
        try {
            pst=conecta.conn.prepareStatement("Insert into diretoria (nome_diretoria, sigla_diretoria)"
                    + " VALUES (?,?)");
            pst.setString(1, diretoria.getNome());
            pst.setString(2, diretoria.getSigla());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Diretoria gravada");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao inserir Diretoria. Motivo.: "+ex);
        } finally{
            conecta.desconecta();
        }
    }
    
    public void editaDiretoria(DiretoriaModel diretoria){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update diretoria set nome_diretoria=?, "
                    + "sigla_diretoria=? where idDiretoria=?");
            pst.setString(1, diretoria.getNome());
            pst.setString(2, diretoria.getSigla());
            pst.setInt(3, diretoria.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao editar diretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
    }
    
    public void apagaDiretoria (int id){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Delete from diretoria where idDiretoria=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao apagar diretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    
    }
    
    public int getIdDiretoria(String sigla){
        conecta.conexao();
        int id=0;
        
        conecta.executaPesquisaSQL("Select * from diretoria where sigla_diretoria='"+sigla+"'");
        try {
            conecta.rs.first();
            id=conecta.rs.getInt("idDiretoria");
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao buscar idDiretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
}
