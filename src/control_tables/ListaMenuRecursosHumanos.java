package control_tables;

import control.DepartamentoControl;
import control.DiretoriaControl;
import control.GerenciaControl;
import model_tables.ListaMenuGerhumModel;
import utils.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaMenuRecursosHumanos {

    private static String bancoOf;
    ConectaBanco conecta;

    public ListaMenuRecursosHumanos(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
    }

    public ArrayList<ListaMenuGerhumModel> listaTabelaGerhum(String nivel, String sigla) {
       
        ArrayList<ListaMenuGerhumModel> lista = new ArrayList();

        if (nivel.equals("Departamentos")) {
            DepartamentoControl d = new DepartamentoControl(bancoOf);
            int codDep = d.getIdDpto(sigla);
            
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario "
                    + "where departamento_iddepartamento_func=" + codDep);

            try {
                if (conecta.rs.first()) {
                    do {
                         ListaMenuGerhumModel listaModelo = new ListaMenuGerhumModel();
                        listaModelo.setMat(conecta.rs.getInt("Matricula_func"));
                        listaModelo.setCargo(conecta.rs.getString("cargo_func"));
                        listaModelo.setNome(conecta.rs.getString("nome_func"));
                        lista.add(listaModelo);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }

        }
        
         if (nivel.equals("Gerências")) {
            GerenciaControl g = new GerenciaControl(bancoOf);
            int codGer = g.getIdGerencia(sigla);

            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario "
                    + "where gerencia_idgerencias_func=" + codGer);

            try {
                if (conecta.rs.first()) {
                    do {
                         ListaMenuGerhumModel listaModelo = new ListaMenuGerhumModel();
                        listaModelo.setMat(conecta.rs.getInt("Matricula_func"));
                        listaModelo.setCargo(conecta.rs.getString("cargo_func"));
                        listaModelo.setNome(conecta.rs.getString("nome_func"));
                        lista.add(listaModelo);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }

        }
         
         if (nivel.equals("Diretorias")) {
            DiretoriaControl d = new DiretoriaControl(bancoOf);
            int codDir = d.getIdDiretoria(sigla);

            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where "
                        + "diretoria_iddiretoria_func=" + codDir + " and (cargo_func='Diretor'"
                        + " or cargo_func='funcionário' or cargo_func='Chefe de Gabinete'"
                        + " or cargo_func='Assessor da Presidência' or cargo_func='Assessor de Imprensa')"
                                + " and departamento_iddepartamento_func is null"
                        + " and gerencia_idgerencias_func is null");

            try {
                if (conecta.rs.first()) {
                    do {
                         ListaMenuGerhumModel listaModelo = new ListaMenuGerhumModel();
                        listaModelo.setMat(conecta.rs.getInt("Matricula_func"));
                        listaModelo.setCargo(conecta.rs.getString("cargo_func"));
                        listaModelo.setNome(conecta.rs.getString("nome_func"));
                        lista.add(listaModelo);
                    } while (conecta.rs.next());
                }
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }

        }
         
        return lista;
    }

}
