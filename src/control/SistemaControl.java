
package control;

import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SistemaControl {
    private static String bancoOf;
   ConectaBanco conecta;
   
   public SistemaControl (String banco){
       this.bancoOf=banco;
       conecta = new ConectaBanco(bancoOf);
   }
   
   public int getStatusSistema (String status){
       conecta.conexao();
       int id=0;
       conecta.executaPesquisaSQL("Select * from Statussistema where Statussistemass='"+status+"'");
       try {
           conecta.rs.first();
           id=conecta.rs.getInt("idStatusSistemaSS");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar idStatusSistema. \n"+ex);
       } finally {
           conecta.desconecta();
       }
       return id;
   }
}
