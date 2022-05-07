
package control;

import models.GerenciaModel;
import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class GerenciaControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public GerenciaControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    
    public void gravaGerenciaDepartamento(GerenciaModel gerenciaModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into gerencia (Nome_ger, Sigla_ger,"
                    + "Departamento_idDepartamento_ger) VALUES (?,?,?)");
            pst.setString(1, gerenciaModelo.getNomeGerencia());
            pst.setString(2, gerenciaModelo.getSigla());
            pst.setInt(3, gerenciaModelo.getIdDepartamento());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Incluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public void gravaGerenciaDiretoria(GerenciaModel gerenciaModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into gerencia (Nome_ger, Sigla_ger,"
                    + "Diretoria_iddiretoria_ger) VALUES (?,?,?)");
            pst.setString(1, gerenciaModelo.getNomeGerencia());
            pst.setString(2, gerenciaModelo.getSigla());
            pst.setInt(3, gerenciaModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Incluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public String getDpto(String sigla){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from departamentogerv where sigla_ger='"+sigla+"'");
        String dpto="";
        try {
            conecta.rs.first();
            dpto=conecta.rs.getString("sigla_dep");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return dpto;
        
    }
    
     public String getDir(String sigla){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from diretoriagerv where sigla_diretoria='"+sigla+"'");
        String dir="";
        try {
            conecta.rs.first();
            dir=conecta.rs.getString("sigla_diretoria");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return dir;
        
    }
     
     public int getIdDpto(String sigla){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from dptogerdirv where sigla_ger='"+sigla+"'");
        int dpto=0;
        try {
            conecta.rs.first();
           dpto=conecta.rs.getInt("departamento_iddepartamento_ger");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return dpto;
        
    }
    
          
    public void excluiGerencia(int idGerencia){
        conecta.conexao();
        PreparedStatement pst;
        
        try {
            pst=conecta.conn.prepareStatement("Delete from gerencia where idGerencias=?");
            pst.setInt(1, idGerencia);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Gerência Excluída com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir, motivo: "+ex);
        } finally { 
            conecta.desconecta();
        }
    }
    
    public int getIdGerencia(String siglaGerencia) {
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from gerencia where sigla_ger='"+siglaGerencia+"'");
        int id=0;
        try {
            conecta.rs.first();
            id=conecta.rs.getInt("idGerencias");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
    
    public void editaGerencia (GerenciaModel gerenciaModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update gerencia set Nome_ger=?, Sigla_ger=?,"
                    + " departamento_iddepartamento_ger=? where idGerencias=?");
            
            pst.setString(1, gerenciaModelo.getNomeGerencia());
            pst.setString(2, gerenciaModelo.getSigla());
            pst.setInt(3, gerenciaModelo.getIdDepartamento());
            pst.setInt(4, gerenciaModelo.getIdGerencia());
                    
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public boolean verificaGerenciaDiretoria(int id){//serve apenas para verificar se a gerencia pertence a uma diretoria
        boolean sinal=false;
        int idDiretoria=0;
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from gerencia where idGerencias="+id);
        try {
            conecta.rs.first();
            idDiretoria=conecta.rs.getInt("Diretoria_iddiretoria_ger");
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro ao verificar Gerencia Diretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (idDiretoria==0){
            sinal=false;
        } else {
            sinal=true;
        }
        return sinal;
    }
    
    public boolean verificaGerenciaDpto(int id){//serve apenas para verificar se a gerencia pertence a uma diretoria
        boolean sinal=false;
        int idDepartamento=0;
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from gerencia where idGerencias="+id);
        try {
            conecta.rs.first();
            idDepartamento=conecta.rs.getInt("departamento_iddepartamento_ger");
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro ao verificar Gerencia Diretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (idDepartamento==0){
            sinal=false;
        } else {
            sinal=true;
        }
        return sinal;
    }
    
    public int getidDiretoria(int idGerencia){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from gerencia where idgerencias="+idGerencia);
        int id=0;
        
        try {
            conecta.rs.first();
            id=conecta.rs.getInt("Diretoria_iddiretoria_ger");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Erro getIdDiretoria, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
  
    public int getIdDepartamento(int idGerencia){
        conecta.conexao();
        int idDpto=0;
        conecta.executaPesquisaSQL("Select * from gerencia where idgerencias="+idGerencia);
        try {
            conecta.rs.first();
            idDpto=conecta.rs.getInt("Departamento_idDepartamento_ger");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar idDepartamento. linha 222");
        } finally {
            conecta.desconecta();
        }
        
        return idDpto;
    }
    
    public String getSigla (int id){
        conecta.conexao();
        String sigla="";
        conecta.executaPesquisaSQL("Select * from gerencia where idgerencias="+id);
        try {
            conecta.rs.first();
            sigla=conecta.rs.getString("Sigla_ger");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, getSigla, linha 240");
        } finally {
            conecta.desconecta();
        }
        return sigla;
    }
  
}
