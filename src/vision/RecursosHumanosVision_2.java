package vision;

import control.AnoControl;
import control.AvaliacaoControl;
import control.FuncionarioControl;
import control.GerenciamentoSistemaControl;
import control.PendenciaControl;
import control.TabelaFinalControl;
import control_tables.ListaMenuRecursosHumanos;
import model_tables.ListaMenuGerhumModel;
import tables.ImagemTabela;
import tables.TabelaResumoGerhum;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.Relatorios;
import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;

public class RecursosHumanosVision_2 extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
    ConectaBanco conecta2;
    ConectaBanco conecta3;

    public RecursosHumanosVision_2(String banco) {
        setLF();
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
        conecta2 = new ConectaBanco(bancoOf);
        conecta3 = new ConectaBanco(bancoOf);
        initComponents();
        geraComboNivel();
        geraComboSigla();
        preencheTabelaResumo();
        identificaBanco();
    }

    public void setLF() {

        try {
            Properties props = new Properties();
            props.put("controlColorLight", "194 204 216");
            props.put("menuOpaque", "on");
            props.put("windowInactiveBorderColor", "172 186 202");
            props.put("windowTitleColorDark", "170 185 202");
            props.put("rolloverColorDark", "220 220 172");
            props.put("windowBorderColor", "150 168 188");
            props.put("logoString", "SJ Look And Feel");
            props.put("windowInactiveTitleForegroundColor", "67 84 103");
            props.put("backgroundPattern", "off");
            props.put("windowTitleForegroundColor", "0 0 0");
            props.put("rolloverColor", "208 208 145");
            props.put("windowInactiveTitleColorLight", "218 224 231");
            props.put("windowTitleColorLight", "200 215 232");
            props.put("menuForegroundColor", "0 0 0");
            props.put("backgroundColor", "220 226 233");
            props.put("windowInactiveTitleColorDark", "194 205 216");
            props.put("windowTitleFont", "Dialog bold 14");
            props.put("frameColor", "170 185 202");
            props.put("userTextFont", "Dialog PLAIN 12");
            props.put("menuColorDark", "220 226 233");
            props.put("controlColorDark", "160 177 197");
            props.put("menuColorLight", "242 244 247");
            props.put("menuSelectionForegroundColor", "0 0 0");
            props.put("menuTextFont", "Dialog 14");
            props.put("brightMode", "on");
            props.put("selectionBackgroundColor", "170 185 202");
            props.put("menuSelectionBackgroundColor", "160 177 197");
            props.put("rolloverColorLight", "250 250 202");
            props.put("drawSquareButtons", "on");
            props.put("systemTextFont", "Dialog 14");
            props.put("toolbarBackgroundColor", "220 226 233");
            props.put("controlTextFont", "Dialog 14");
            props.put("menuBackgroundColor", "170 185 202");
            props.put("subTextFont", "Dialog 12");

            props.put("windowTitleForegroundColor", "160 177 197");
            props.put("windowTitleForegroundColor", "54 68 84");
            props.put("windowTitleForegroundColor", "0 0 0");
            props.put("windowTitleColorDark", "220 220 172");
            props.put("windowTitleColorLight", "250 250 202");
            props.put("windowTitleColorDark", "220 226 233");
            props.put("windowTitleColorLight", "250 255 255");
            props.put("windowTitleColorDark", "170 185 202");
            props.put("windowTitleColorLight", "200 215 232");
            props.put("rolloverColorDark", "0 0 0");
            props.put("rolloverColorLight", "30 30 30");
            props.put("rolloverColorDark", "220 220 172");
            props.put("rolloverColorLight", "250 250 202");
            props.put("controlColorDark", "170 185 202");
            props.put("controlColorLight", "200 215 232");

            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setCurrentTheme(props);
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    
    public void preencheTabelaResumo() {
        ListaMenuRecursosHumanos resumo = new ListaMenuRecursosHumanos(bancoOf);
        ArrayList<ListaMenuGerhumModel> lista = new ArrayList();//Lista de objetos que será exibido na tabela
       
        String nivel=String.valueOf(jComboBoxNivel.getSelectedItem());
        String sigla=String.valueOf(jComboBoxSigla.getSelectedItem());
       
        lista = resumo.listaTabelaGerhum(nivel, sigla);
       

        if (lista != null) {
            TabelaResumoGerhum tabelaResumoAvaliadores = new TabelaResumoGerhum(lista);//Montar uma lista com a tabela Resumo
            
            tableResumo.setDefaultRenderer(Object.class, new ImagemTabela());
            tableResumo.setRowHeight(35);
            ((DefaultTableCellRenderer) tableResumo.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((DefaultTableCellRenderer) tableResumo.getDefaultRenderer(getClass())).setHorizontalAlignment(SwingConstants.CENTER);
            tableResumo.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tableResumo.getTableHeader().setOpaque(false);
            tableResumo.getTableHeader().setBackground(new Color(0, 0, 0));
            tableResumo.getTableHeader().setForeground(new Color(255, 255, 255));
            ImagemTabela img = new ImagemTabela();
            tableResumo.setModel(tabelaResumoAvaliadores);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui eventos para esta referência!");
        }

    }

    public void identificaBanco (){
        if (bancoOf.equals("AD_19")){
            jLabelBanco.setText("Banco de dados selecionado: Avaliações realizadas em 2019 (Referência 2018)");
        }
        if (bancoOf.equals("AD_20")){
            jLabelBanco.setText("Banco de dados selecionado: Avaliações realizadas em 2020 (Referência 2019)");
        }
        if (bancoOf.equals("AD_21")){
            jLabelBanco.setText("Banco de dados selecionado: Avaliações realizadas em 2021 (Referência 2020)");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabelBanco = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxNivel = new javax.swing.JComboBox<>();
        jComboBoxSigla = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResumo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(160, 116, 0));

        jLabelBanco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelBanco.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBanco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBanco.setText("Banco de dados selecionado: xxxxxxxxxxxxxxxx");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabelBanco)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 830, 40));

        jPanel2.setBackground(new java.awt.Color(0, 60, 113));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nível:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sigla:");

        jComboBoxNivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxNivelFocusLost(evt);
            }
        });
        jComboBoxNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNivelActionPerformed(evt);
            }
        });

        jComboBoxSigla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxSigla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Versão 4.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSigla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxNivel, 0, 288, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxNivel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxSigla, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableResumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResumoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableResumo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 830, 350));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Configuracoes.png"))); // NOI18N
        jMenu1.setText("Gerenciar");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Gerências");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Departamentos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Diretorias");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Sistema");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Funcionarios.png"))); // NOI18N
        jMenu6.setText("Funcionários");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem5.setText("Gerenciar Funcionários");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Alocar Funcionários");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuItem7.setText("Transferir todos p/ sem setor");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("Alterar E-mail de Funcionário");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuItem9.setText("Resetar a senha do funcionário");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Verificar funcionários s/ primeiro acesso");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Avaliacoes.png"))); // NOI18N
        jMenu3.setText("Avaliações");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem11.setText("Visualizar Avaliações");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Maturidade Profissional");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Zerar Avaliações");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem14.setText("Criar Tabelas de Avaliações");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setText("Cobrar Pendências");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Log de Avaliações");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Relatorios.png"))); // NOI18N
        jMenu4.setText("Relatórios");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem17.setText("Resultado Final");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuItem18.setText("Pendências");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenu2.setText("Lista de Funcionários");

        jMenuItem19.setText("Vinculados às Diretorias");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuItem20.setText("Vinculados aos Departamentos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);

        jMenuItem21.setText("Vinculados às Gerências");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem21);

        jMenu4.add(jMenu2);

        jMenuItem22.setText("Relatório Geral");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        jMenu5.setText("Sair");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSiglaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSiglaActionPerformed

    private void txtNomeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeBuscaActionPerformed

    private void txtNomeBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeBuscaKeyPressed

    }//GEN-LAST:event_txtNomeBuscaKeyPressed

    private void jComboBoxNivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxNivelFocusLost
        
    }//GEN-LAST:event_jComboBoxNivelFocusLost

    private void jComboBoxSiglaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxSiglaFocusLost
       
    }//GEN-LAST:event_jComboBoxSiglaFocusLost

    private void jComboBoxNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNivelActionPerformed
        geraComboSigla();
        preencheTabelaResumo();
    }//GEN-LAST:event_jComboBoxNivelActionPerformed

    private void jComboBoxSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSiglaActionPerformed
        preencheTabelaResumo();
    }//GEN-LAST:event_jComboBoxSiglaActionPerformed

    private void tableResumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResumoMouseClicked
         if (evt.getClickCount() == 2) {
            int linha = tableResumo.getSelectedRow();

            int matricula = Integer.parseInt(("" + tableResumo.getValueAt(linha, 0)));
            String cargo = String.valueOf(("" + tableResumo.getValueAt(linha, 2)));
            TelaFuncionario telaFunc = new TelaFuncionario(bancoOf);
            telaFunc.geraCampos(matricula, cargo);
            telaFunc.setVisible(true);
        }
    }//GEN-LAST:event_tableResumoMouseClicked

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       TelaAlocaFuncionario aloca = new TelaAlocaFuncionario(bancoOf);
        aloca.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        TelaDepartamento telaGerencia = new TelaDepartamento(bancoOf);
        telaGerencia.preencheTabelaResumo();
        telaGerencia.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaDepartamento telaDpto = new TelaDepartamento(bancoOf);
        telaDpto.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       TelaDiretoria tela = new TelaDiretoria(bancoOf);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        GerenciamentoSistema gerenciamento = new GerenciamentoSistema(bancoOf);
        gerenciamento.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaFuncionario telaFunc = new TelaFuncionario(bancoOf);
        telaFunc.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Tem certeza que deseja fazer isto ?\n"
                + "Esta ação irá retirar todos os funcionários dos setores! \n"
                + "1. Sim \n"
                + "2. Não"));

        if (op == 1) {
            FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
            funcionario.TransfereTodosSemSetor();
        } else {
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ResetarSenha reset = new ResetarSenha(bancoOf);
        reset.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        TabelaFuncionariosSemAcesso tabela = new TabelaFuncionariosSemAcesso(bancoOf);
        tabela.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
         Insere_email email = new Insere_email(bancoOf);
        email.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();
        
        if (sinal == true) {
            Tela_Visao_Avaliacao_MenuPrincipal tela = new Tela_Visao_Avaliacao_MenuPrincipal(bancoOf);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {

            Tela_MaturidadeProfissional maturidade = new Tela_MaturidadeProfissional(bancoOf);
            maturidade.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        int op = 0;
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "Este procedimento deletará todas as tabelas de avaliações.\n"
                + "Tem certeza que deseja continuar ?\n"
                + "1. Sim\n"
                + "2. Não"));

        if (op == 1) {
            zeraAvaliacoes();
        } else {
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
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
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
         TelaEnvioEmailPendenciaAutomatico pendencia = new TelaEnvioEmailPendenciaAutomatico(bancoOf);
        pendencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        LogAvaliacao log = new LogAvaliacao(bancoOf);
        log.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
       GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
        boolean sinal = sistema.verificaAvaliacoes();

        if (sinal == true) {

            TelaImpressaoRelatorios tela = new TelaImpressaoRelatorios(bancoOf);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, crie as tabelas de avaliações primeiro.");
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
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
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        RelatorioFuncionariosDiretorias();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        RelatorioFuncionariosDepartamentos();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
      RelatorioFuncionariosGerencias();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       TelaDepartamento telaGerencia = new TelaDepartamento(bancoOf);
        telaGerencia.preencheTabelaResumo();
        telaGerencia.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        RelatorioGeral();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanosVision_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanosVision_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanosVision_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecursosHumanosVision_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecursosHumanosVision_2(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxNivel;
    private javax.swing.JComboBox<String> jComboBoxSigla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBanco;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
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
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResumo;
    // End of variables declaration//GEN-END:variables
}
