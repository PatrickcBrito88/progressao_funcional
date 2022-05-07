
package control;

import models.PendenciaModel;
import utils.ConectaBanco;
import vision.RecursosHumanosVision;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PendenciaControl {
    private static String bancoOf;
   ConectaBanco conecta;
   ConectaBanco conecta2;
   
   public PendenciaControl (String banco){
       this.bancoOf=banco;
       conecta = new ConectaBanco(bancoOf);
       conecta2 = new ConectaBanco(bancoOf);
   }
   
   public void truncaPendencia(){
   
       conecta.conexao();
       PreparedStatement pst;
        try {
           pst=conecta.conn.prepareStatement("truncate table pendencias");
           pst.executeUpdate();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao truncar tabela pendencia.\n"+ex);
       } finally {
         conecta.desconecta();
     }
     
   }
   
   public void gravaPendencia(PendenciaModel pendencia){
     conecta.conexao();
     PreparedStatement pst;
    
     
       try {
          
           pst=conecta.conn.prepareStatement("Insert into pendencias (mat_avaliadorpen, nome_avaliadorpen,"
                   + " mat_avaliadopen, nome_avaliadopen) VALUES (?,?,?,?)");
           pst.setInt(1, pendencia.getIdAvaliador());
           pst.setString(2, pendencia.getNomeAvaliador());
           pst.setInt(3, pendencia.getIdAvaliado());
           pst.setString(4, pendencia.getNomeAvaliado());
           pst.execute();
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Erro ao gravar pendencia.\n"+ex);
       } finally {
           conecta.desconecta();
       }
   }
   
   public void geraPendencia(){
        conecta.conexao();
        conecta2.conexao();
        int avaliador=0;
        String nomeavaliador="";
        int avaliado=0;
        String nomeavaliado="";
        
        conecta.executaPesquisaSQL("Select * from avaliacao where AvaliacaoConcluida=false");
       try {
           conecta.rs.first();
           do {
             avaliador=conecta.rs.getInt("mat_avaliador");
             avaliado=conecta.rs.getInt("mat_avaliado");
             
             conecta2.conexao();
             conecta2.executaPesquisaSQL("Select * from funcionario where matricula_func="+avaliador);
             conecta2.rs.first();
             nomeavaliador=conecta2.rs.getString("nome_func");
             conecta2.desconecta();
             
             conecta2.conexao();
             conecta2.executaPesquisaSQL("Select * from funcionario where matricula_func="+avaliado);
             conecta2.rs.first();
             nomeavaliado=conecta2.rs.getString("nome_func");
             conecta2.desconecta();
             
             PendenciaModel pendencia = new PendenciaModel();
             pendencia.setIdAvaliado(avaliado);
             pendencia.setIdAvaliador(avaliador);
             pendencia.setNomeAvaliado(nomeavaliado);
             pendencia.setNomeAvaliador(nomeavaliador);
             
             if ((avaliador!=78659)&&(avaliador!=888)){
               gravaPendencia(pendencia);
             }
           }while (conecta.rs.next());
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro no gera Pendencia. \n"+ex);
       } finally {
           conecta.desconecta();
       }
        
    }
}
