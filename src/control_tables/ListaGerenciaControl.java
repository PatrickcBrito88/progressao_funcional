package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaGerenciaControl {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaGerenciaControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaGerenciaModel> listaTabelaGerencia(String categoria, String sigla) {

        ArrayList<ListaGerenciaModel> lista = new ArrayList();

        conecta.conexao();
        if (categoria.equals("Departamento")) {
            DepartamentoControl departamentoControle = new DepartamentoControl(bancoOf);
            int idDpto = departamentoControle.getIdDpto(sigla);
            conecta.executaPesquisaSQL("Select * from gerencia where departamento_iddepartamento_ger=" + idDpto);
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaGerenciaModel gerenciaModelo = new ListaGerenciaModel();
                        gerenciaModelo.setNome(conecta.rs.getString("nome_ger"));
                        gerenciaModelo.setSigla(conecta.rs.getString("sigla_ger"));
                        lista.add(gerenciaModelo);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "ListaGerenciaControl/ListaTabelaGerencia.\n" + ex);
            } finally {
                conecta.desconecta();
            }

        } else {
            DiretoriaControl diretoriaControle = new DiretoriaControl(bancoOf);
            int idDir = diretoriaControle.getIdDiretoria(sigla);
            conecta.executaPesquisaSQL("Select * from gerencia where diretoria_iddiretoria_ger=" + idDir);
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaGerenciaModel gerenciaModelo = new ListaGerenciaModel();
                        gerenciaModelo.setNome(conecta.rs.getString("nome_ger"));
                        gerenciaModelo.setSigla(conecta.rs.getString("sigla_ger"));
                        lista.add(gerenciaModelo);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "ListaGerenciaControl/ListaTabelaGerencia.\n" + ex);
            } finally {
                conecta.desconecta();

            }
        }
        return lista;
    }
}
