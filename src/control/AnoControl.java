
package control;

import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AnoControl {
    
    private static String bancoOf;
   ConectaBanco conecta;
   
   public AnoControl(String banco){
       this.bancoOf=banco;
       conecta = new ConectaBanco(bancoOf);
   }
   
   public void AlteraAno (String ano){
       PreparedStatement pst;
       conecta.conexao();
       try {
           pst=conecta.conn.prepareStatement("Update ano set descricao = ? where idAno=1");
           pst.setString(1, ano);
           pst.executeUpdate();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao alterar o ano, motivo: "+ex);
       } finally {
           conecta.desconecta();
       }
   }
   
   public String getAno (){
       conecta.conexao();
       String ano="";
       conecta.executaPesquisaSQL("Select * from ano");
       try {
           conecta.rs.first();
           ano=conecta.rs.getString("descricao");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Erro, ao buscar descricao ano, motivo: "+ex);
       } finally {
           conecta.desconecta();
       }
       return ano;
   }
}
