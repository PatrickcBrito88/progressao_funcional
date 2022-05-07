package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaDepartamentoModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaDepartamentoControl {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaDepartamentoControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaDepartamentoModel> listaTabelaDepartamento(String sigla) {

        ArrayList<ListaDepartamentoModel> lista = new ArrayList();

        conecta.conexao();
         
      DiretoriaControl diretoria = new DiretoriaControl(bancoOf);
      int id=diretoria.getIdDiretoria(sigla);
            
            conecta.executaPesquisaSQL("Select * from departamento where diretoria_iddiretoria_dep="+id);
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaDepartamentoModel gerenciaModelo = new ListaDepartamentoModel();
                        gerenciaModelo.setNome(conecta.rs.getString("nome_dep"));
                        gerenciaModelo.setSigla(conecta.rs.getString("sigla_dep"));
                        lista.add(gerenciaModelo);
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
