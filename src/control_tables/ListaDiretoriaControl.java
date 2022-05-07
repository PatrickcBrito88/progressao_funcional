package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaDepartamentoModel;
import model_tables.ListaDiretoriaModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaDiretoriaControl {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaDiretoriaControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaDiretoriaModel> listaTabelaDiretoria() {

        ArrayList<ListaDiretoriaModel> lista = new ArrayList();

        conecta.conexao();
     
            conecta.executaPesquisaSQL("Select * from diretoria order by nome_diretoria");
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaDiretoriaModel gerenciaModelo = new ListaDiretoriaModel();
                        gerenciaModelo.setNome(conecta.rs.getString("nome_diretoria"));
                        gerenciaModelo.setSigla(conecta.rs.getString("sigla_diretoria"));
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
