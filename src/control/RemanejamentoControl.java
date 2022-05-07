
package control;

import models.FuncionarioModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RemanejamentoControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public RemanejamentoControl (String banco){
        this.bancoOf=banco;
       conecta = new ConectaBanco(bancoOf); 
    }
    
    public FuncionarioModel destinoGerencia (int idGerencia){
       FuncionarioModel funcionario = new FuncionarioModel();
       conecta.conexao();
       conecta.executaPesquisaSQL("Select * from gerencia where idGerencias="+idGerencia);
        try {
            conecta.rs.first();
            funcionario.setIdGerencia(idGerencia);
            GerenciaControl gerencia = new GerenciaControl(bancoOf);
            
            funcionario.setIdDepartamento(0);
            funcionario.setIdDiretoria(conecta.rs.getInt("diretoria_iddiretoria_ger"));
            
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro destino gerencias: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       return funcionario;
    }
    
     public FuncionarioModel destinoDepartamento (int idDpto){
       FuncionarioModel funcionario = new FuncionarioModel();
       conecta.conexao();
       conecta.executaPesquisaSQL("Select * from departamento where idDepartamento="+idDpto);
        try {
            conecta.rs.first();
            funcionario.setIdDepartamento(idDpto);
                   
            funcionario.setIdDiretoria(conecta.rs.getInt("diretoria_iddiretoria_dep"));
             funcionario.setIdGerencia(0);
                       
           
                      
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro destino departamento: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       return funcionario;
    }
     
     public FuncionarioModel destinoDiretoria (int idDiretoria){
       FuncionarioModel funcionario = new FuncionarioModel();
       conecta.conexao();
       conecta.executaPesquisaSQL("Select * from diretoria where idDiretoria="+idDiretoria);
        try {
            conecta.rs.first();
            funcionario.setIdDepartamento(0);
                   
            funcionario.setIdDiretoria(idDiretoria);
             funcionario.setIdGerencia(0);
                       
           
                      
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro destino departamento: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       return funcionario;
    }
}
