package vision;

import control.AnoControl;
import control.AvaliacaoControl;
import control.DepartamentoControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control.GerenciamentoSistemaControl;
import control.PendenciaControl;
import control.TabelaFinalControl;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.ModeloTabela;
import utils.Relatorios;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JRException;

public class RecursosHumanosVision extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
    ConectaBanco conecta2;
    ConectaBanco conecta3;

    public RecursosHumanosVision(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
        conecta2 = new ConectaBanco(bancoOf);
        conecta3 = new ConectaBanco(bancoOf);
        initComponents();
        geraComboNivel();
        geraComboSigla();
        geraTabela();

    }

    public void RelatorioPendencias() {

        InputStream inputStream = getClass().getResourceAsStream("/Pendencias.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        try {

            Relatorios relat4 = new Relatorios();
            relat4.openReport("Pendencias", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }

    }

    public void RelatorioFuncionariosDiretorias() {

        InputStream inputStream = getClass().getResourceAsStream("/FuncionariosLocalizacaoDir.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        try {

            Relatorios relat4 = new Relatorios();
            relat4.openReport("FuncionariosLocalizacaoDir", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }

    }

    public void RemoveIndesejados() {
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        funcionario.removeIndesejados();
    }

    public void RelatorioFuncionariosDepartamentos() {

        InputStream inputStream = getClass().getResourceAsStream("/FuncionariosLocalizacaoDep.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        try {

            Relatorios relat4 = new Relatorios();
            relat4.openReport("FuncionariosLocalizacaoDep", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }

    }

    public void RelatorioGeral() {

        InputStream inputStream = getClass().getResourceAsStream("/RelatorioGeral.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        try {

            Relatorios relat4 = new Relatorios();
            relat4.openReport("RelatorioGeral", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }

    }

    public void RelatorioFuncionariosGerencias() {

        InputStream inputStream = getClass().getResourceAsStream("/FuncionariosLocalizacaoGerencia.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        try {

            Relatorios relat4 = new Relatorios();
            relat4.openReport("FuncionariosLocalizacaoGerencia", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }

    }

    public void zeraAvaliacoes() {

        conecta.conexao();
        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("truncate table avaliacao;");
            pst.execute();

            pst = conecta.conn.prepareStatement("truncate table maturidadeprofissional;");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate table nota_corrigida;");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate table nota_corrigida_total;");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate table percentual;");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate nota_percentual_total;");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate table media");
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("truncate table tabelafinal");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, " Tabelas zeradas com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, zera avaliaçoes. \n" + ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void geraComboNivel() {

        jComboBoxNivel.removeAllItems();
        jComboBoxNivel.addItem("Departamentos");
        jComboBoxNivel.addItem("Gerências");
        jComboBoxNivel.addItem("Diretorias");
    }

    public void geraComboSigla() {
        jComboBoxSigla.removeAllItems();

        String combo = String.valueOf(jComboBoxNivel.getSelectedItem());

        if (combo.equals("Departamentos")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from departamento");
            try {
                conecta.rs.first();
                do {
                    jComboBoxSigla.addItem(conecta.rs.getString("Sigla_dep"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
                jComboBoxSigla.removeItem("Admin");
            }

        }
        if (combo.equals("Gerências")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from gerencia");
            try {
                conecta.rs.first();
                do {
                    jComboBoxSigla.addItem(conecta.rs.getString("Sigla_ger"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null,"Erro combo gerencia. Motivo:"+ex);
            } finally {
                conecta.desconecta();
            }
        }
        if (combo.equals("Diretorias")) {
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from diretoria");
            try {
                conecta.rs.first();
                do {
                    jComboBoxSigla.addItem(conecta.rs.getString("sigla_diretoria"));
                } while (conecta.rs.next());
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null,"Erro combo gerencia. Motivo:"+ex);
            } finally {
                conecta.desconecta();
            }
        }
    }

    public void geraTabela() {
        String nivel = String.valueOf(jComboBoxNivel.getSelectedItem());

        if (nivel.equals("Departamentos")) {
            int codDep = 0;
            String sigla = String.valueOf(jComboBoxSigla.getSelectedItem());
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from Departamento "
                    + "where sigla_dep='" + sigla + "'");

            try {
                conecta.rs.first();
                codDep = conecta.rs.getInt("idDepartamento");
                preencherTabela("Select * from funcionario"
                        + " where departamento_iddepartamento_func=" + codDep);
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }

        }
        if (nivel.equals("Gerências")) {
            int codGer = 0;
            String sigla = String.valueOf(jComboBoxSigla.getSelectedItem());
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from Gerencia "
                    + "where sigla_ger='" + sigla + "'");

            try {
                conecta.rs.first();
                codGer = conecta.rs.getInt("idGerencias");
                preencherTabela("Select * from funcionario"
                        + " where gerencia_idgerencias_func=" + codGer);
            } catch (SQLException ex) {
//               JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
            } finally {
                conecta.desconecta();
            }
        }
        if (nivel.equals("Diretorias")) {
            int codDir = 0;
            String sigla = String.valueOf(jComboBoxSigla.getSelectedItem());
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from diretoria where sigla_diretoria='" + sigla + "'");

            try {
                conecta.rs.first();
                codDir = conecta.rs.getInt("idDiretoria");
                preencherTabela("Select * from funcionario where "
                        + "diretoria_iddiretoria_func=" + codDir + " and (cargo_func='Diretor'"
                        + " or cargo_func='funcionário' or cargo_func='Chefe de Gabinete'"
                        + " or cargo_func='Assessor da Presidência' or cargo_func='Assessor de Imprensa') and departamento_iddepartamento_func is null"
                        + " and gerencia_idgerencias_func is null");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao montar Combo Diretoria, motivo: " + ex);
            } finally {
                conecta.desconecta();
            }
        }
    }

    public void preencherTabela(String sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Matrícula", "Funcionário", "Cargo"};

        conecta.conexao();
        conecta.executaPesquisaSQL(sql);
        try {
            conecta.rs.first();
            do {

                dados.add(new Object[]{conecta.rs.getString("Matricula_func"), conecta.rs.getString("Nome_func"), conecta.rs.getString("Cargo_func")});

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao preencher o Array List!\n"+ex);
        } finally {
            conecta.desconecta();
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableFuncionarios.setModel(modelo);

        jTableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTableFuncionarios.getColumnModel().getColumn(0).setResizable(true);
        jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(537);
        jTableFuncionarios.getColumnModel().getColumn(1).setResizable(true);
        jTableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(210);
        jTableFuncionarios.getColumnModel().getColumn(2).setResizable(true);
        jTableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTableFuncionarios.setAutoResizeMode(jTableFuncionarios.AUTO_RESIZE_OFF);
        jTableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void insereMaturidade() {
        AvaliacaoControl avaliacaoControle = new AvaliacaoControl(bancoOf);
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                int mat = conecta.rs.getInt("matricula_func");
                avaliacaoControle.insereMaturidade(mat);
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, ao inserir, motivo: " + ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void inserePercentualFinal() {
        AvaliacaoControl avaliacaoControle = new AvaliacaoControl(bancoOf);
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                int mat = conecta.rs.getInt("matricula_func");

                avaliacaoControle.InsereTabelaPercentualFinal(mat);
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro ao inserir em Percentual Final, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void insereIdGestorNota_Corrigida() {
        conecta.conexao();
        String cargo = "";
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                cargo = conecta.rs.getString("cargo_func");

                if (!(cargo.equals("Funcionário"))) {
                    AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
                    int mat = conecta.rs.getInt("Matricula_func");
                    avaliacao.insereNotaCorrigida(888, mat);
                } else {
                }

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro ao pegar o cargo "+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void insereIdGestorPercentual() {
        conecta.conexao();
        String cargo = "";
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                cargo = conecta.rs.getString("cargo_func");

                if (!(cargo.equals("Funcionário"))) {
                    AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
                    int mat = conecta.rs.getInt("Matricula_func");
                    avaliacao.inserePercentual(888, mat);
                } else {
                }

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro ao pegar o cargo "+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void FuncionarioFuncionario() {//vai fazer tudo relacionado a funcionario - funcionario
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='funcionário'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Funcionário - Funcionário: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void FuncionarioGerente() {//vai fazer tudo relacionado a funcionario - gerente
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where cargo_func='funcionário'"
                + " and gerencia_idgerencias_func is not null");
        int idAdor = 0;
        int idAdo = 0;
        int idGerencia = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idGerencia = conecta.rs.getInt("idGerencias");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where gerencia_idgerencias_func="
                        + idGerencia + " and cargo_func='gerente'");
                conecta2.rs.first();
                idAdo = conecta2.rs.getInt("matricula_func");
                conecta2.desconecta();

                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Funcionario - Gerente, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void GerenteGerente() {//vai fazer tudo relacionado a gerente - gerente
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='gerente'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Gerente - Gerente: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void GerenteFuncionario() {//vai fazer tudo relacionado a gerente - funcionário
        conecta.conexao();
        int idAdor = 0;
        int idGerencia = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='gerente'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idGerencia = conecta.rs.getInt("gerencia_idgerencias_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where gerencia_idgerencias_func="
                        + idGerencia + " and cargo_func='funcionário'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do func - gerente - "
//                      + "funcionario, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Gerente - Funcionário, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void GerenteChefe() {//faz tudo relacionado a gerente - chefe
        conecta.conexao();
        int idAdor = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idDepartamento = 0;

        conecta.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where cargo_func='gerente'"
                + " and departamento_iddepartamento_ger is not null");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("matricula_func");
                idDepartamento = conecta.rs.getInt("departamento_iddepartamento_ger");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where "
                        + "departamento_iddepartamento_func=" + idDepartamento + " and cargo_func='chefe'");
                conecta2.rs.first();

                idAdo = conecta2.rs.getInt("matricula_func");
                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);

                conecta2.desconecta();
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Gerente chefe, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void FuncionarioChefe() {//faz tudo relacionado a funcionário - chefe
        conecta.conexao();//trata casos como DEPINF onde não há gerência
        int idAdor = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idDepartamento = 0;

        conecta.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav "
                + "where cargo_func='funcionário' and departamento_iddepartamento_func<>0");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("matricula_func");
                idDepartamento = conecta.rs.getInt("departamento_iddepartamento_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where "
                        + "departamento_iddepartamento_func=" + idDepartamento + " and cargo_func='chefe'");
                conecta2.rs.first();

                idAdo = conecta2.rs.getInt("matricula_func");
                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);

                conecta2.desconecta();
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Funcionario - chefe, motivo: \n" + ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void ChefeChefe() {//vai fazer tudo relacionado a chefe-chefe
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='chefe'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Chefe-Chefe: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void ChefeDiretor() {//faz tudo relacionado a chefe - Diretor
        conecta.conexao();
        int idAdor = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idDiretoria = 0;

        conecta.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where cargo_func='chefe'"
                + " and diretoria_iddiretoria_dep is not null");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_dep");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where "
                        + "diretoria_iddiretoria_func=" + idDiretoria + " and cargo_func='Diretor'");
                conecta2.rs.first();

                idAdo = conecta2.rs.getInt("matricula_func");
                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);

                conecta2.desconecta();
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Gerente chefe, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void GerenteDiretor() {//faz tudo relacionado a gerente - Diretor
        conecta.conexao();
        int idAdor = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idDiretoria = 0;

        conecta.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav "
                + "where cargo_func='gerente' and Diretoria_idDiretoria_func<>0");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where "
                        + "diretoria_iddiretoria_func=" + idDiretoria + " and (cargo_func='Diretor' "
                        + "or cargo_func='Chefe de Gabinete')");
                conecta2.rs.first();

                idAdo = conecta2.rs.getInt("matricula_func");
                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);

                conecta2.desconecta();
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Gerente chefe, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void ChefeGerente() {//vai fazer tudo relacionado a chefe - gerente
        conecta.conexao();
        int idAdor = 0;
        int idDepartamento = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='chefe'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDepartamento = conecta.rs.getInt("departamento_iddepartamento_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where departamento_iddepartamento_ger="
                        + idDepartamento + " and cargo_func='gerente'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - gerente  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Gerente, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void ChefeFuncionario() {//vai fazer tudo relacionado a chefe - funcionario
        conecta.conexao();//trata dos casos igual ao DEPINF onde não há gerência
        int idAdor = 0;
        int idDepartamento = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='chefe'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDepartamento = conecta.rs.getInt("departamento_iddepartamento_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where departamento_iddepartamento_func="
                        + idDepartamento + " and cargo_func='funcionário'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - funcionário  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Funcionário, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void FuncionarioDiretor() {//faz tudo relacionado a funcionario - diretor, funcionario gabin e funcionário aspre
        conecta.conexao();
        int idAdor = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idDiretoria = 0;

        conecta.executaPesquisaSQL("Select * from funcionario"
                + " where cargo_func='funcionário' and Diretoria_idDiretoria_func<>0"
                + " and departamento_iddepartamento_func is null and gerencia_idgerencias_func is null");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where "
                        + "diretoria_iddiretoria_func=" + idDiretoria + " and (cargo_func='Diretor'"
                        + " or cargo_func='Chefe de Gabinete')"); // or cargo_func='Assessor da Presidência')"); (Retirado para o joão não ser avaliado pela alice
                conecta2.rs.first();

                idAdo = conecta2.rs.getInt("matricula_func");

                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);

                conecta2.desconecta();
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Gerente chefe, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void DiretorFuncionario() {//vai fazer tudo relacionado a chefe - funcionario
        conecta.conexao();//trata dos casos igual ao DEPINF onde não há gerência
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='diretor'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where departamento_iddepartamento_func is null"
                        + " and gerencia_idgerencias_func is null and cargo_func='funcionário' and diretoria_iddiretoria_func="
                        + +idDiretoria);
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");

                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - funcionário  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Funcionário, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void PresidenteFuncionarioAspre() {//Foi utilizado para o Presidente avaliar Alice
        conecta.conexao();
        conecta2.conexao();
        int idAdor = 92975;
        int idAdo = 0;
        int iddiretoria = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);

        conecta2.executaPesquisaSQL("Select * from diretoria where sigla_diretoria='ASPRE'");
        try {
            conecta2.rs.first();
            iddiretoria = conecta2.rs.getInt("idDiretoria");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar iddiretoria Presidente_Func-Aspre");
        } finally {
            conecta2.desconecta();
        }

        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='funcionário' and"
                + " diretoria_iddiretoria_func=" + iddiretoria);
        try {
            conecta.rs.first();

            do {
                idAdo = conecta.rs.getInt("matricula_func");
                avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                avaliacao.inserePercentual(idAdor, idAdo);
                avaliacao.insereNotaCorrigida(idAdor, idAdo);
            } while (conecta.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar matrícula funcionário Aspre");
            JOptionPane.showMessageDialog(null, "Avaliador" + idAdor);
        } finally {
            conecta.desconecta();
        }
    }

    public void ChefeGabinFuncionario() {//vai fazer tudo relacionado a chefe Gabin - funcionario
        conecta.conexao();//trata dos casos igual ao DEPINF onde não há gerência
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where "
                + "cargo_func='Chefe de Gabinete'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where departamento_iddepartamento_func is null"
                        + " and gerencia_idgerencias_func is null and cargo_func='funcionário' and diretoria_iddiretoria_func="
                        + +idDiretoria);
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - funcionário  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Funcionário, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void AspreFuncionario() {//vai fazer tudo relacionado a chefe Gabin - funcionario
        conecta.conexao();//trata dos casos igual ao DEPINF onde não há gerência
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where "
                + "cargo_func='Assessor da Presidência'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionario where departamento_iddepartamento_func is null"
                        + " and gerencia_idgerencias_func is null and cargo_func='funcionário' and diretoria_iddiretoria_func="
                        + +idDiretoria);
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - funcionário  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Funcionário, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void DiretorDiretor() {//vai fazer tudo relacionado a Diretor-Diretor
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='diretor'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Chefe-Chefe: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void ChefeGabinChefeGabin() {//vai fazer tudo relacionado a Diretor-Diretor
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='Chefe de Gabinete'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Chefe-Chefe: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void AspreAspre() {//vai fazer tudo relacionado a Diretor-Diretor
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='Assessor da Presidência'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Chefe-Chefe: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void AsimpAsimp() {//vai fazer tudo relacionado a Diretor-Diretor
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        int idFuncionario = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='Assessor de Imprensa'");
        try {
            conecta.rs.first();
            do {
                idFuncionario = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(idFuncionario, idFuncionario);
                avaliacao.inserePercentual(idFuncionario, idFuncionario);
                avaliacao.insereNotaCorrigida(idFuncionario, idFuncionario);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro função Chefe-Chefe: \n"+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void DiretorChefe() {//vai fazer tudo relacionado a Diretor_Chefe
        conecta.conexao();
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='diretor'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where diretoria_iddiretoria_dep="
                        + idDiretoria + " and cargo_func='chefe'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - gerente  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Chefe - Gerente, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void DiretorGerente() {//vai fazer tudo relacionado a Diretor_Gerente
        conecta.conexao();
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='diretor'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where diretoria_iddiretoria_func="
                        + idDiretoria + " and cargo_func='gerente'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - gerente  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Diretor - Gerente, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void ChefeGabinGerente() {//vai fazer tudo relacionado a chefeGabinete_Gerente
        conecta.conexao();
        int idAdor = 0;
        int idDiretoria = 0;
        int idAdo = 0;
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='chefe de gabinete'");
        try {
            conecta.rs.first();
            do {
                idAdor = conecta.rs.getInt("Matricula_func");
                idDiretoria = conecta.rs.getInt("diretoria_iddiretoria_func");

                conecta2.conexao();
                conecta2.executaPesquisaSQL("Select * from funcionariogerenciadptoalocav where diretoria_iddiretoria_func="
                        + idDiretoria + " and cargo_func='gerente'");
                try {
                    conecta2.rs.first();
                    do {
                        idAdo = conecta2.rs.getInt("matricula_func");
                        avaliacao.GeraTabelaAvaliacao(idAdor, idAdo);
                        avaliacao.inserePercentual(idAdor, idAdo);
                        avaliacao.insereNotaCorrigida(idAdor, idAdo);

                    } while (conecta2.rs.next());
                } catch (SQLException ex2) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - gerente  "
//                      + "gerente, motivo:  \n"+ex2); 
                } finally {
                    conecta2.desconecta();
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro Diretor - Gerente, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    public void PresidenteDiretor() {//vai fazer tudo relacionado a Presidente - Diretor - Chefe de Gabinete e Aspre
        conecta.conexao();
        int idAdo = 0;
        int idDiretoria = 0;

        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        conecta.executaPesquisaSQL("Select * from funcionario where cargo_func='diretor'"
                + " or cargo_func='Chefe de Gabinete' or cargo_func='Assessor da Presidência' or cargo_func='Assessor "
                + "de Imprensa';");
        try {
            conecta.rs.first();
            do {
                idAdo = conecta.rs.getInt("Matricula_func");
                avaliacao.GeraTabelaAvaliacao(92975, idAdo);
                avaliacao.inserePercentual(92975, idAdo);
                avaliacao.insereNotaCorrigida(92975, idAdo);

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//              JOptionPane.showMessageDialog(null,"Erro ao buscar a matrícula do chefe - gerente  "
//                      + "gerente, motivo:  \n"+ex2); 

        } finally {
            conecta.desconecta();
        }
    }

    public void PresidenteDEPCI() {
        conecta.conexao();
        int idDpto = 0;
        conecta.executaPesquisaSQL("Select * from departamento where sigla_dep='DEPCI'");
        try {
            conecta.rs.first();
            idDpto = conecta.rs.getInt("idDepartamento");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, presidente-depci. \n" + ex);
        } finally {
            conecta.desconecta();
        }

        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario where departamento_iddepartamento_func="
                + "" + idDpto + " and cargo_func='chefe'");
        try {
            conecta.rs.first();
            AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
            int idAdo = conecta.rs.getInt("matricula_func");
            avaliacao.GeraTabelaAvaliacao(92975, idAdo);
            avaliacao.inserePercentual(92975, idAdo);
            avaliacao.insereNotaCorrigida(92975, idAdo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar mat funcionario - Presidente DEPCI. \n" + ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void insereIdMediaGestorAvaliacao() {
        conecta.conexao();
        String cargo = "";
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                cargo = conecta.rs.getString("cargo_func");

                if (!(cargo.equals("Funcionário"))) {
                    AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
                    int mat = conecta.rs.getInt("Matricula_func");
                    avaliacao.GeraTabelaMedia(mat);
                    avaliacao.GeraTabelaAvaliacao(888, mat);
                    avaliacao.InsereMedias(mat);
                    avaliacao.insereNotaCorrigida(888, mat);
                } else {
                }

            } while (conecta.rs.next());
        } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,"Erro ao pegar o cargo "+ex);
        } finally {
            conecta.desconecta();
        }

    }

    public void InsereChavesUnicas() {
        conecta.conexao();
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        int mat = 0;
        conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            do {
                mat = conecta.rs.getInt("matricula_func");
                avaliacao.insereMaturidade(mat);
                avaliacao.InsereTabelaPercentualFinal(mat);
                avaliacao.InsereCorrigidaTotal(mat);
                tabelaFinal.insereTabelaFinal(mat);
//           avaliacao.insereNotaCorrigida(888, mat);
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"Erro chaves únicas, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxNivel = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxSigla = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento do RH");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setText("Nível:");
        jTextField1.setBorder(null);
        jTextField1.setEnabled(false);

        jComboBoxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxNivelFocusLost(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField2.setText("Sigla:");
        jTextField2.setBorder(null);
        jTextField2.setEnabled(false);

        jComboBoxSigla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSigla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSiglaItemStateChanged(evt);
            }
        });
        jComboBoxSigla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxSiglaFocusLost(evt);
            }
        });
        jComboBoxSigla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSiglaActionPerformed(evt);
            }
        });

        jLabel1.setText("Versão 4.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pinion.png"))); // NOI18N
        jMenu1.setText("Gerenciar");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icona_folder_legno.png"))); // NOI18N
        jMenuItem1.setText("Gerenciar Gerências");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/folder open.png"))); // NOI18N
        jMenuItem2.setText("Gerenciar Departamentos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Folder2.png"))); // NOI18N
        jMenuItem7.setText("Gerenciar Diretorias");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseClicked(evt);
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Tools.png"))); // NOI18N
        jMenuItem9.setText("Gerenciar Sistema");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Boss.png"))); // NOI18N
        jMenu5.setText("Funcionários");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/People.png"))); // NOI18N
        jMenuItem3.setText("Gerenciar Funcionários");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Redo.png"))); // NOI18N
        jMenuItem4.setText("Alocar Funcionários");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Script.png"))); // NOI18N
        jMenuItem16.setText("Transferir Todos p/ sem Setor");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pinion.png"))); // NOI18N
        jMenu8.setText("Configuração de Funcionários");

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Registration.png"))); // NOI18N
        jMenuItem17.setText("Reset de Senha");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/List.png"))); // NOI18N
        jMenuItem19.setText("Funcionários Sem Primeiro Acesso");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem19);

        jMenu5.add(jMenu8);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/E-mail png.png"))); // NOI18N
        jMenuItem21.setText("Alterar e-mail de funcionário");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem21);

        jMenuBar1.add(jMenu5);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clipboard.png"))); // NOI18N
        jMenu3.setText("Avaliações");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Monitor.png"))); // NOI18N
        jMenuItem5.setText("Visualizar Avaliações");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Folder.png"))); // NOI18N
        jMenuItem6.setText("Maturidade Profissional");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Revert.png"))); // NOI18N
        jMenuItem8.setText("Zerar Avaliações");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Properties.png"))); // NOI18N
        jMenu2.setText("Criar Tabela de Avaliação");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenu2);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Attach.png"))); // NOI18N
        jMenuItem18.setText("Cobrar Pendências");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem20.setText("Log de Avaliação");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenuBar1.add(jMenu3);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Form.png"))); // NOI18N
        jMenu6.setText("Relatórios");
        jMenu6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Scenario.png"))); // NOI18N
        jMenuItem11.setText("Resultado Final Avaliação");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Attach.png"))); // NOI18N
        jMenuItem12.setText("Pendências");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/list bullets.png"))); // NOI18N
        jMenu7.setText("Lista de Funcionários");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Folder2.png"))); // NOI18N
        jMenuItem13.setText("Vinculados às Diretorias");
        jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem13MouseClicked(evt);
            }
        });
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/folder open.png"))); // NOI18N
        jMenuItem14.setText("Vinculados aos Dptos");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem14MouseClicked(evt);
            }
        });
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icona_folder_legno.png"))); // NOI18N
        jMenuItem10.setText("Vinculado às Gerências");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem10MouseClicked(evt);
            }
        });
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenu6.add(jMenu7);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/3d bar chart.png"))); // NOI18N
        jMenuItem15.setText("Relatório Geral");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Exit.png"))); // NOI18N
        jMenu4.setText("Sair");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jComboBoxNivelFocusLost(java.awt.event.FocusEvent evt) {                                         
        geraComboSigla();
        geraTabela();
    }                                        

    private void jComboBoxSiglaFocusLost(java.awt.event.FocusEvent evt) {                                         
        geraTabela();
    }                                        

    private void jComboBoxSiglaItemStateChanged(java.awt.event.ItemEvent evt) {                                                

    }                                               

    private void jComboBoxSiglaActionPerformed(java.awt.event.ActionEvent evt) {                                               

    }                                              


    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {                                                
        if (evt.getClickCount() == 2) {
            int linha = jTableFuncionarios.getSelectedRow();

            int matricula = Integer.parseInt(("" + jTableFuncionarios.getValueAt(linha, 0)));
            String cargo = String.valueOf(("" + jTableFuncionarios.getValueAt(linha, 2)));
            TelaFuncionario telaFunc = new TelaFuncionario(bancoOf);
            telaFunc.geraCampos(matricula, cargo);
            telaFunc.setVisible(true);
        }

    }                                               

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        dispose();
    }                                      

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {                                    
        dispose();
    }                                   

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        RelatorioGeral();
    }                                           

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        RelatorioFuncionariosGerencias();
    }                                           

    private void jMenuItem10MouseClicked(java.awt.event.MouseEvent evt) {                                         
        RelatorioFuncionariosGerencias();
    }                                        

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        RelatorioFuncionariosDepartamentos();
    }                                           

    private void jMenuItem14MouseClicked(java.awt.event.MouseEvent evt) {                                         
        RelatorioFuncionariosDepartamentos();
    }                                        

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        RelatorioFuncionariosDiretorias();
    }                                           

    private void jMenuItem13MouseClicked(java.awt.event.MouseEvent evt) {                                         
        RelatorioFuncionariosDiretorias();
    }                                        

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {

            PendenciaControl pendenciaControle = new PendenciaControl(bancoOf);
            pendenciaControle.truncaPendencia();
            pendenciaControle.geraPendencia();
            RelatorioPendencias();

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }                                           

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {

            TelaImpressaoRelatorios tela = new TelaImpressaoRelatorios(bancoOf);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }                                           

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        TelaEnvioEmailPendenciaAutomatico pendencia = new TelaEnvioEmailPendenciaAutomatico(bancoOf);
        pendencia.setVisible(true);
    }                                           

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                       

    }                                      

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {                                    
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();
        AnoControl anoControle = new AnoControl(bancoOf);

        if (sinal == false) {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja realmente "
                    + "criar a lista de avaliações?\n 1. Sim \n 2. Não"));

            if (id == 1) {
                String ano = JOptionPane.showInputDialog(null, "Informe o ano correspondente às avaliações:");
                anoControle.AlteraAno(ano);
                FuncionarioFuncionario();
                FuncionarioGerente();

                FuncionarioDiretor();//aparentemente este método também funciona para func - chefe de gabin
                FuncionarioChefe();

                GerenteFuncionario();
                GerenteGerente();
                GerenteChefe();
                GerenteDiretor();

                ChefeChefe();
                ChefeDiretor();
                ChefeGerente();
                ChefeFuncionario();

                DiretorDiretor();
                DiretorChefe();
                DiretorGerente();
                DiretorFuncionario();

                PresidenteDiretor();//cria a relação pres-diretor, pres-assessor e pres-chefegabin

                PresidenteDEPCI();

////            PresidenteFuncionarioAspre();//Foi utilizado quando o presidente avaliava a Alice
                ChefeGabinChefeGabin();
                ChefeGabinFuncionario();
                ChefeGabinGerente();

                
                AspreAspre();
                AsimpAsimp();

                InsereChavesUnicas();
                insereIdMediaGestorAvaliacao();//insere na tabela avaliacao com avaliador 888
                //e tambem na tabela média
                RemoveIndesejados();//remove indesejados
                //
                JOptionPane.showMessageDialog(null, "Tabela de Avaliações criada com sucesso");
            } else {
            }

        } else {
            JOptionPane.showMessageDialog(null, " As tabelas já foram criadas!");
        }

    }                                   

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int op = 0;
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Este procedimento deletará todas as tabelas de avaliações.\n"
                + "Tem certeza que deseja continuar ?\n"
                + "1. Sim\n"
                + "2. Não"));

        if (op == 1) {
            zeraAvaliacoes();
        } else {
        }
    }                                          

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {

            Tela_MaturidadeProfissional maturidade = new Tela_MaturidadeProfissional(bancoOf);
            maturidade.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {
            Tela_Visao_Avaliacao_MenuPrincipal tela = new Tela_Visao_Avaliacao_MenuPrincipal(bancoOf);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }                                          

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {                                        
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {
            Tela_Visao_Avaliacao_MenuPrincipal tela = new Tela_Visao_Avaliacao_MenuPrincipal(bancoOf);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }                                       

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GerenciamentoSistema gerenciamento = new GerenciamentoSistema(bancoOf);
        gerenciamento.setVisible(true);
    }                                          

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TelaDiretoria tela = new TelaDiretoria(bancoOf);
        tela.setVisible(true);
    }                                          

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {                                        
        TelaDiretoria tela = new TelaDiretoria(bancoOf);
        tela.setVisible(true);
    }                                       

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TelaDepartamento telaDpto = new TelaDepartamento(bancoOf);
        telaDpto.setVisible(true);
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TelaDepartamento telaGerencia = new TelaDepartamento(bancoOf);
        telaGerencia.preencheTabelaResumo();
        telaGerencia.setVisible(true);
    }                                          

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Tem certeza que deseja fazer isto ?\n"
                + "Esta ação irá retirar todos os funcionários dos setores! \n"
                + "1. Sim \n"
                + "2. Não"));

        if (op == 1) {
            FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
            funcionario.TransfereTodosSemSetor();
        } else {
        }
    }                                           

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TelaAlocaFuncionario aloca = new TelaAlocaFuncionario(bancoOf);
        aloca.setVisible(true);
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TelaFuncionario telaFunc = new TelaFuncionario(bancoOf);
        telaFunc.setVisible(true);
    }                                          

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ResetarSenha reset = new ResetarSenha(bancoOf);
        reset.setVisible(true);
    }                                           

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        TabelaFuncionariosSemAcesso tabela = new TabelaFuncionariosSemAcesso(bancoOf);
        tabela.setVisible(true);
    }                                           

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        LogAvaliacao log = new LogAvaliacao(bancoOf);
        log.setVisible(true);
    }                                           

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Insere_email email = new Insere_email(bancoOf);
        email.setVisible(true);
    }                                           

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecursosHumanosVision(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> jComboBoxNivel;
    private javax.swing.JComboBox<String> jComboBoxSigla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}
