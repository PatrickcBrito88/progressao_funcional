
package control;

import models.LogModel;
import utils.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LogControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public LogControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    public void GravaLog (LogModel log){
       conecta.conexao();
       PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into logavaliacao (log_idavaliador,"
                    + "log_idavaliado, log_data, log_ip) VALUES (?,?, now(), ?)");
            pst.setInt(1, log.getAvaliador());
            pst.setInt(2, log.getAvaliado());
            pst.setString(3, log.getIp());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro inserção log, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    
    
}
