package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaFuncionarioModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaFuncionarioControl {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaFuncionarioControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaFuncionarioModel> listaTabelaFuncionario() {

        ArrayList<ListaFuncionarioModel> lista = new ArrayList();

        conecta.conexao();

        conecta.executaPesquisaSQL("Select * from funcionario where "
                + "matricula_func<>78659 and matricula_func<>888"
                + " and matricula_func<>999 order by nome_func");
        try {
            if (conecta.rs.first()) {
                do {
                    ListaFuncionarioModel l = new ListaFuncionarioModel();
                    l.setMat(conecta.rs.getInt("matricula_func"));
                    l.setCargo(conecta.rs.getString("cargo_func"));
                    l.setNome(conecta.rs.getString("nome_func"));
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
