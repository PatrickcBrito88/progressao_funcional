package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaDepartamentoModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import model_tables.ListaRemanejamentoModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaRemanejamentoControl {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaRemanejamentoControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaRemanejamentoModel> listaTabelaRemanejamento(String sigla) {

        ArrayList<ListaRemanejamentoModel> lista = new ArrayList();

        if (sigla.equals("Sem Setor")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from todos where sigla_ger is null"
                    + " and sigla_dep is null and sigla_diretoria is null"
                    + " and (matricula_func <> 888) and (matricula_func<>78659) order by nome_func");
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaRemanejamentoModel l = new ListaRemanejamentoModel();
                        l.setNome(conecta.rs.getString("nome_func"));
                        l.setMat(conecta.rs.getInt("matricula_func"));
                        lista.add(l);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "ListaGerenciaControl/ListaTabelaGerencia.\n" + ex);
            } finally {
                conecta.desconecta();
            }
        } else {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from todos where "
                    + "sigla_ger='" + sigla + "' or sigla_dep='" + sigla + "'"
                    + " or (sigla_diretoria='" + sigla + "' and departamento_iddepartamento_func"
                    + " is null and gerencia_idgerencias_func is null) order by nome_func");
            try {
                if (conecta.rs.first()) {
                    do {
                        ListaRemanejamentoModel l = new ListaRemanejamentoModel();
                        l.setNome(conecta.rs.getString("nome_func"));
                        l.setMat(conecta.rs.getInt("matricula_func"));
                        lista.add(l);
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

    public ArrayList<ListaRemanejamentoModel> listaTabelaRemanejamentoNome(String nome) {

        ArrayList<ListaRemanejamentoModel> lista = new ArrayList();

        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from todos where sigla_dep is null "
                + "and sigla_ger is null and sigla_diretoria is null"
                + " and nome_func like '" + nome + "%'");
        try {
            if (conecta.rs.first()) {
                do {
                    ListaRemanejamentoModel l = new ListaRemanejamentoModel();
                    l.setNome(conecta.rs.getString("nome_func"));
                    l.setMat(conecta.rs.getInt("matricula_func"));
                    lista.add(l);
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
