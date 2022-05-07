package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaDepartamentoModel;
import model_tables.ListaFuncionarioSemAcessoModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import model_tables.ListaRemanejamentoModel;
import utils.ConectaBanco;
import valid_login.ConectaBancoValidacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaFuncionarioSemAcessoControl {

    private static String bancoOf;
    ConectaBancoValidacao conecta;

    public ListaFuncionarioSemAcessoControl(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBancoValidacao();
    }

    public ArrayList<ListaFuncionarioSemAcessoModel> listaSemAcesso(String sigla) {

        ArrayList<ListaFuncionarioSemAcessoModel> lista = new ArrayList();
     
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where senha_f='' order by nome_f");
          
            try{
                if (conecta.rs.first()) {
                    do {
                        ListaFuncionarioSemAcessoModel l = new ListaFuncionarioSemAcessoModel();
                        l.setNome(conecta.rs.getString("nome_f"));
                        l.setMat(conecta.rs.getInt("matfunc_f"));
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
