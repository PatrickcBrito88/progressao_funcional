
package control_tables;

import model_tables.ListaDiretoriaModel;
import model_tables.TabelaControleModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListaTabelaControleControl {
    
     private static String bancoOf;
    ConectaBanco conecta;
    
    public ListaTabelaControleControl (String banco){
         this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
     public ArrayList<TabelaControleModel> listaTabelaControle(int mat) {

        ArrayList<TabelaControleModel> lista = new ArrayList();

        conecta.conexao();
     
            conecta.executaPesquisaSQL("Select * from avaliadov where mat_avaliador="+mat);
            try {
                if (conecta.rs.first()) {
                    do {
                       TabelaControleModel t = new TabelaControleModel();
                       t.setCargo(conecta.rs.getString("cargo_func"));
                       t.setMat(conecta.rs.getInt("mat_avaliado"));
                       t.setNome(conecta.rs.getString("Nome_func"));
                       boolean situacao=conecta.rs.getBoolean("AvaliacaoConcluida");
                       if (situacao==true){
                           t.setStatus("Avaliado");
                       } else {
                           t.setStatus("Não avaliado");
                       }
                       lista.add(t);
                       
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "ListaGerenciaControl/ListaTabelaGerencia.\n" + ex);
            } finally {
                conecta.desconecta();
            }
        
        return lista;
    }
     
}
