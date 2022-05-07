
package control;

import models.DepartamentoModel;
import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class DepartamentoControl {
    ConectaBanco conecta;
    private static String bancoOf;
    
    public DepartamentoControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    public int getIdDpto(String sigla){
        conecta.conexao();
        int id=0;
        conecta.executaPesquisaSQL("Select * from departamento where sigla_dep='"+sigla+"'");
        try {
            conecta.rs.first();
            id=conecta.rs.getInt("idDepartamento");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"DepartamentoControl/getIdDpto: "+sigla + ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
    
    public void gravaDpto(DepartamentoModel dptoModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into departamento (Nome_Dep, Sigla_Dep, Diretoria_iddiretoria_dep)"
                    + " VALUES (?,?,?)");
           
            pst.setString(1, dptoModelo.getNome());
            pst.setString(2, dptoModelo.getSigla());
            pst.setInt(3, dptoModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Incluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
    }
    
    public void AlteraDpto (DepartamentoModel dptoModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update departamento set nome_dep=?, sigla_dep=?"
                    + " where idDepartamento=?");
            pst.setString(1, dptoModelo.getNome());
            pst.setString(2, dptoModelo.getSigla());
            pst.setInt(3, dptoModelo.getIdDepartamento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public void deletaDpto(int id){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Delete from departamento where idDepartamento=?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
    }
    
    public int getIdDiretoria (String sigla){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamento where sigla_dep='"+sigla+"'");
        int id=0;
        try {
            conecta.rs.first();
            id=conecta.rs.getInt("diretoria_iddiretoria_dep");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Dep-Diretoria (linha 94), motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
    
    public int getIdDiretoria (int id){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamento where iddepartamento="+id);
        int idDpto=0;
        try {
            conecta.rs.first();
            idDpto=conecta.rs.getInt("diretoria_iddiretoria_dep");
            
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Dep-Diretoria (linha 94), motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       
        return idDpto;
        
    }
    
    public boolean verificaDiretoria(int idDepartamento){
        conecta.conexao();
        boolean sinal=false;
        int idDiretoria=0;
        conecta.executaPesquisaSQL("Select * from Departamento where idDepartamento="+idDepartamento);
        try {
            conecta.rs.first();
            idDiretoria=conecta.rs.getInt("diretoria_iddiretoria_dep");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro buscar idDepartamento, linha 124");
        } finally {
            conecta.desconecta();
        }
        
        if (idDiretoria!=0){
            sinal=true;
        } else {
            sinal=false;
        }
        
        return sinal;
    }
    
    public String getSiglaDpto(int idDpto){
        String sigla="";
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamento where idDepartamento="+idDpto);
        try {
            conecta.rs.first();
            sigla=conecta.rs.getString("Sigla_dep");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar siglaDpto, linha 149");
        } finally {
            conecta.desconecta();
        }
        return sigla;
    }
}
