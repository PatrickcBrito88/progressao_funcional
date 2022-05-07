package vision;

import control.AvaliacaoControl;
import control.DepartamentoControl;
import control.DiretoriaControl;
import control.FuncionarioControl;
import control.GerenciaControl;
import control_tables.ListaDepartamentoControl;
import control_tables.ListaDiretoriaControl;
import control_tables.ListaGerenciaControl;
import control_tables.ListaMenuRecursosHumanos;
import model_tables.ListaDepartamentoModel;
import model_tables.ListaDiretoriaModel;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import models.AvaliacaoModel;
import models.DepartamentoModel;
import models.DiretoriaModel;
import models.GerenciaModel;
import tables.ImagemTabela;
import tables.TabelaDepartamento;
import tables.TabelaDiretoria;
import tables.TabelaGerencia;
import tables.TabelaResumoGerhum;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.Relatorios;
import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.BadLocationException;
import net.sf.jasperreports.engine.JRException;

public class Tela_MaturidadeProfissional extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
    String siglaInicial = "";

    public Tela_MaturidadeProfissional(String banco) {
        this.bancoOf = banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        geraComboFuncionario();
        setCampos(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        geraComboAvaliadores();
    }

    public void ImprimeMaturidade() {
        FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
        int mat = funcionario.getMatFunc(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        InputStream inputStream = getClass().getResourceAsStream("/MaturidadeProfissional.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("matricula", mat);
        try {
            Relatorios relat4 = new Relatorios();
            relat4.openReport("MaturidadeProfissional", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        } catch (JRException exc) {
            JOptionPane.showMessageDialog(null, "Erro relatorio, motivo: \n" + exc);
        }
    }
    
     public void ImprimeRelatorioFinalFuncionario(int mat){
        InputStream inputStream = getClass().getResourceAsStream("/RelatorioFinalFuncionario.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat",mat);
                    
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("RelatorioFinalFuncionario", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
          
    }
     
     public void ImprimeRelatorioFinalGestor(int mat){
        
       
        
    InputStream inputStream = getClass().getResourceAsStream("/RelatorioFinal.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat",mat);
      
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("RelatorioFinal", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
          
    }
    
    public void geraComboAvaliadores(){
        jComboBoxAvaliadores.removeAllItems();
        conecta.conexao();
        String avaliado = String.valueOf(jComboBoxFuncionario.getSelectedItem());
        FuncionarioControl funcionario =  new FuncionarioControl(bancoOf);
        int mat=funcionario.getMatFunc(avaliado);
        conecta.executaPesquisaSQL("Select * from nomeavaliadorv where mat_avaliado="+mat);
        try {
            conecta.rs.first();
            do{
                jComboBoxAvaliadores.addItem(conecta.rs.getString("nome_func"));
            }while (conecta.rs.next());
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao montar combobox avaliadores, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
            
        
       
    }
    
    
    public void setCampos(String ado){
              
        conecta.conexao();
        
        FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
        int mat = funcControle.getMatFunc(ado);
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+mat);
        try {
            conecta.rs.first();
            boolean sinal=conecta.rs.getBoolean("AvaliacaoConcluida");
            
            if(sinal==true){
            jTextFieldAtualizacao.setText(String.valueOf(conecta.rs.getInt("Atualizacao_profissional")));
            jTextFieldCumprimentoNormas.setText(String.valueOf(conecta.rs.getInt("cumprimento_normas")));
            jTextFieldExercicioFuncao.setText(String.valueOf(conecta.rs.getInt("confianca")));
            jTextFieldTempoExperiencia.setText(String.valueOf(conecta.rs.getInt("tempo_experiencia")));
            jTextFieldpontualidade.setText(String.valueOf(conecta.rs.getInt("pontualidade_assiduidade")));
            AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
            jTextFieldNotaFinal.setText(avaliacao.calculaPercentualFinal(mat));
            } else {
            jTextFieldAtualizacao.setText("");
            jTextFieldCumprimentoNormas.setText("");
            jTextFieldExercicioFuncao.setText("");
            jTextFieldTempoExperiencia.setText("");
            jTextFieldpontualidade.setText("");
            AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
            jTextFieldNotaFinal.setText(avaliacao.calculaPercentualFinal(mat));
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        String funcao = funcControle.getCargo(mat);
        jTextFieldFuncao.setText(funcao);
    }

    public void geraComboFuncionario(){
        jComboBoxFuncionario.removeAllItems();
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario order by nome_func");
        try {
            conecta.rs.first();
            do{
                jComboBoxFuncionario.addItem(conecta.rs.getString("Nome_func"));
            }while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        jComboBoxFuncionario.removeItem("Admin");
        jComboBoxFuncionario.removeItem("Invertida");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btn_close1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDiretoria = new javax.swing.JTextField();
        jTextFieldSigla = new javax.swing.JTextField();
        jComboBoxFuncionario = new javax.swing.JComboBox<>();
        jTextFieldFuncao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxAvaliadores = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JLabel();
        jButton4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextFieldpontualidade = new javax.swing.JTextField();
        jTextFieldTempoExperiencia = new javax.swing.JTextField();
        jTextFieldAtualizacao = new javax.swing.JTextField();
        jTextFieldExercicioFuncao = new javax.swing.JTextField();
        jTextFieldCumprimentoNormas = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldNotaFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Maturidade Profissional");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 0, 600, 40));

        jPanel14.setBackground(new java.awt.Color(160, 116, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel13.setBackground(new java.awt.Color(0, 60, 113));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        jPanel9.setBackground(new java.awt.Color(0, 60, 113));

        btn_close1.setBackground(new java.awt.Color(96, 83, 150));
        btn_close1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close1.setForeground(new java.awt.Color(255, 255, 255));
        btn_close1.setText("X");
        btn_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_close1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(btn_close1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 80, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Funcionário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Função:");

        jTextFieldDiretoria.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldDiretoria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldDiretoria.setBorder(null);
        jTextFieldDiretoria.setOpaque(false);

        jTextFieldSigla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextFieldSigla.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSigla.setBorder(null);
        jTextFieldSigla.setOpaque(false);
        jTextFieldSigla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSiglaActionPerformed(evt);
            }
        });

        jComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxFuncionarioFocusLost(evt);
            }
        });
        jComboBoxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFuncionarioActionPerformed(evt);
            }
        });

        jTextFieldFuncao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldFuncao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldFuncao.setText("xxxxx");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Avaliações Recebidas:");

        jComboBoxAvaliadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setBackground(new java.awt.Color(0, 60, 113));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton3.setText("Vis. Avaliações");
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(160, 116, 0));
        jButtonSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonSalvar.setText("Gravar ");
        jButtonSalvar.setOpaque(true);
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 60, 113));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton4.setText("Imprimir");
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 60, 113));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton5.setText("Relatório Final");
        jButton5.setOpaque(true);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxAvaliadores, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDiretoria, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldDiretoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFuncao)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxAvaliadores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 730, 140));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 780, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maturidade Profissional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setText("Pontualidade e Assiduidade:");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField2.setEnabled(false);
        jTextField2.setOpaque(false);
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 47, -1, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.setText("Tempo de experiência Profissional");
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField3.setEnabled(false);
        jTextField3.setOpaque(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 87, -1, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setText("Atualização profissional nos últimos 12 meses");
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField4.setEnabled(false);
        jTextField4.setOpaque(false);
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 127, -1, -1));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField5.setText("Exercício de função de confiança");
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField5.setEnabled(false);
        jTextField5.setOpaque(false);
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 167, -1, -1));

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField6.setText("Cumprimento de normas e procedimentos");
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField6.setEnabled(false);
        jTextField6.setOpaque(false);
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 207, -1, -1));

        jTextFieldpontualidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldpontualidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldpontualidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldpontualidadeKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldpontualidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 30, -1));

        jTextFieldTempoExperiencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTempoExperiencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTempoExperienciaFocusLost(evt);
            }
        });
        jTextFieldTempoExperiencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTempoExperienciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTempoExperienciaKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldTempoExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 30, -1));

        jTextFieldAtualizacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAtualizacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAtualizacaoFocusLost(evt);
            }
        });
        jTextFieldAtualizacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAtualizacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAtualizacaoKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldAtualizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 30, -1));

        jTextFieldExercicioFuncao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldExercicioFuncao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldExercicioFuncaoFocusLost(evt);
            }
        });
        jTextFieldExercicioFuncao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldExercicioFuncaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldExercicioFuncaoKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldExercicioFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 30, -1));

        jTextFieldCumprimentoNormas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCumprimentoNormas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCumprimentoNormasFocusLost(evt);
            }
        });
        jTextFieldCumprimentoNormas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCumprimentoNormasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCumprimentoNormasKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldCumprimentoNormas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 30, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 440, 280));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nota Final", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNotaFinal.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jTextFieldNotaFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNotaFinal.setText("%");
        jTextFieldNotaFinal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldNotaFinal.setEnabled(false);
        jTextFieldNotaFinal.setOpaque(false);
        jPanel4.add(jTextFieldNotaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 110));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 330, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
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

    private void btn_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_close1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_close1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        String avaliado = String.valueOf(jComboBoxFuncionario.getSelectedItem());
        String avaliador = String.valueOf(jComboBoxAvaliadores.getSelectedItem());
        FuncionarioControl funcionarioControle = new FuncionarioControl(bancoOf);
        int matAdo = funcionarioControle.getMatFunc(avaliado);
        int matAdor= funcionarioControle.getMatFunc(avaliador);
        String cargoAdo = funcionarioControle.getCargo(matAdo);
        String cargoAdor = funcionarioControle.getCargo(matAdor);
        
     
        Tela_Visao_Avaliacao tela = new Tela_Visao_Avaliacao(bancoOf);
        tela.setCampos(matAdor, matAdo, avaliador, avaliado, cargoAdo, cargoAdor);
        tela.setAvaliacao(matAdo, matAdor);
        tela.setDisableCampos();
        tela.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseClicked
         AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
        avaliacaoModelo.setPontualidadeAssiduidade(Integer.parseInt(jTextFieldpontualidade.getText()));
        avaliacaoModelo.setTempoExperiencia(Integer.parseInt(jTextFieldTempoExperiencia.getText()));
        avaliacaoModelo.setAtualizacaoProfissional(Integer.parseInt(jTextFieldAtualizacao.getText()));
        avaliacaoModelo.setConfianca(Integer.parseInt(jTextFieldExercicioFuncao.getText()));
        avaliacaoModelo.setCumprimentoNormas(Integer.parseInt(jTextFieldCumprimentoNormas.getText()));
        
        int pontualidade = Integer.parseInt(jTextFieldpontualidade.getText());
        int tempoExperiencia = Integer.parseInt(jTextFieldTempoExperiencia.getText());
        int atualizacao = Integer.parseInt(jTextFieldAtualizacao.getText());
        int confianca = Integer.parseInt(jTextFieldExercicioFuncao.getText());
        int cumprimentoNormas = Integer.parseInt(jTextFieldCumprimentoNormas.getText());
        
             
        AvaliacaoControl avaliacaoControl = new AvaliacaoControl(bancoOf);
        String nome = String.valueOf(jComboBoxFuncionario.getSelectedItem());
        FuncionarioControl funcControle = new FuncionarioControl(bancoOf);
        int mat=funcControle.getMatFunc(nome);
        avaliacaoControl.editaMaturidade(avaliacaoModelo, mat);
        String cargo = jTextFieldFuncao.getText();
        
        if (cargo.equals("Funcionário")){
        avaliacaoControl.calculaNotaCorrigidaMaturidadeFunc(avaliacaoModelo, mat);
        } else {
            if (mat==165 || mat==318 || mat==308 || mat==249 || mat==222){
//configurado para dar um peso na maturidade de 30% a fátima, candida, gabrielaa, Peccini, Érika
                
                avaliacaoControl.calculaNotaCorrigidaMaturidadeDEPLAN_ASPRE(avaliacaoModelo, mat);
//                JOptionPane.showMessageDialog(null,"Entrou na Maturidade Deplan");
            } else{
                
           avaliacaoControl.calculaNotaCorrigidaMaturidadeGestor(avaliacaoModelo, mat); 
//           JOptionPane.showMessageDialog(null,"Entrou na maturidade geral");
            }
        }
        
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
         if ((pontualidade !=0) && (tempoExperiencia!=0) && (atualizacao!=0) &&
                (confianca!=0) && (cumprimentoNormas!=0)){
            
            avaliacao.alteraBoolAvaliacaoMaturidade(mat);
            jTextFieldNotaFinal.setText(avaliacao.calculaPercentualFinal(mat));
        } else {
             jTextFieldNotaFinal.setText(avaliacao.calculaPercentualFinal(mat));
         }
         
         int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
             ImprimeMaturidade();
         } else {}
    }//GEN-LAST:event_jButtonSalvarMouseClicked

    private void jTextFieldSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSiglaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSiglaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
            ImprimeMaturidade();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
         String funcStr = String.valueOf(jComboBoxFuncionario.getSelectedItem());
       FuncionarioControl funcControl = new FuncionarioControl(bancoOf);
       int mat=funcControl.getMatFunc(funcStr);
       String cargo = funcControl.getCargo(mat);
       
       if (cargo.equals("Funcionário")){
           ImprimeRelatorioFinalFuncionario(mat);
       } else {
           ImprimeRelatorioFinalGestor(mat);
       }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextFieldpontualidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpontualidadeKeyPressed
        String numNota = jTextFieldpontualidade.getText();
        String primeiroDigito = "";
        try {
            primeiroDigito = jTextFieldpontualidade.getText(0, 0);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "Erro TextFieldPontualidade");
        }
        int quantCaracteres = numNota.length();
        if (quantCaracteres == 0) {

        } else {
            jTextFieldpontualidade.setText(primeiroDigito);
        }
    }//GEN-LAST:event_jTextFieldpontualidadeKeyPressed

    private void jTextFieldpontualidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpontualidadeKeyTyped
        String caracteres = "12345";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldpontualidadeKeyTyped

    private void jTextFieldTempoExperienciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTempoExperienciaFocusLost

    }//GEN-LAST:event_jTextFieldTempoExperienciaFocusLost

    private void jTextFieldTempoExperienciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTempoExperienciaKeyPressed
        String numNota = jTextFieldTempoExperiencia.getText();
        String primeiroDigito = "";
        try {
            primeiroDigito = jTextFieldTempoExperiencia.getText(0, 0);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "Erro TextFieldPontualidade");
        }
        int quantCaracteres = numNota.length();
        if (quantCaracteres == 0) {

        } else {
            jTextFieldTempoExperiencia.setText(primeiroDigito);
        }
    }//GEN-LAST:event_jTextFieldTempoExperienciaKeyPressed

    private void jTextFieldTempoExperienciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTempoExperienciaKeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldTempoExperienciaKeyTyped

    private void jTextFieldAtualizacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAtualizacaoFocusLost

    }//GEN-LAST:event_jTextFieldAtualizacaoFocusLost

    private void jTextFieldAtualizacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAtualizacaoKeyPressed
        String numNota = jTextFieldAtualizacao.getText();
        String primeiroDigito = "";
        try {
            primeiroDigito = jTextFieldAtualizacao.getText(0, 0);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "Erro TextFieldPontualidade");
        }
        int quantCaracteres = numNota.length();
        if (quantCaracteres == 0) {

        } else {
            jTextFieldAtualizacao.setText(primeiroDigito);
        }
    }//GEN-LAST:event_jTextFieldAtualizacaoKeyPressed

    private void jTextFieldAtualizacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAtualizacaoKeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAtualizacaoKeyTyped

    private void jTextFieldExercicioFuncaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldExercicioFuncaoFocusLost

    }//GEN-LAST:event_jTextFieldExercicioFuncaoFocusLost

    private void jTextFieldExercicioFuncaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldExercicioFuncaoKeyPressed
        String numNota = jTextFieldExercicioFuncao.getText();
        String primeiroDigito = "";
        try {
            primeiroDigito = jTextFieldExercicioFuncao.getText(0, 0);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "Erro TextFieldPontualidade");
        }
        int quantCaracteres = numNota.length();
        if (quantCaracteres == 0) {

        } else {
            jTextFieldExercicioFuncao.setText(primeiroDigito);
        }
    }//GEN-LAST:event_jTextFieldExercicioFuncaoKeyPressed

    private void jTextFieldExercicioFuncaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldExercicioFuncaoKeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldExercicioFuncaoKeyTyped

    private void jTextFieldCumprimentoNormasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCumprimentoNormasFocusLost

    }//GEN-LAST:event_jTextFieldCumprimentoNormasFocusLost

    private void jTextFieldCumprimentoNormasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCumprimentoNormasKeyPressed
        String numNota = jTextFieldCumprimentoNormas.getText();
        String primeiroDigito = "";
        try {
            primeiroDigito = jTextFieldCumprimentoNormas.getText(0, 0);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "Erro TextFieldPontualidade");
        }
        int quantCaracteres = numNota.length();
        if (quantCaracteres == 0) {

        } else {
            jTextFieldCumprimentoNormas.setText(primeiroDigito);
        }
    }//GEN-LAST:event_jTextFieldCumprimentoNormasKeyPressed

    private void jTextFieldCumprimentoNormasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCumprimentoNormasKeyTyped
        String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCumprimentoNormasKeyTyped

    private void jComboBoxFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxFuncionarioFocusLost
         setCampos(String.valueOf(jComboBoxFuncionario.getSelectedItem()));
        geraComboAvaliadores();
    }//GEN-LAST:event_jComboBoxFuncionarioFocusLost

    private void jComboBoxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFuncionarioActionPerformed
        
    }//GEN-LAST:event_jComboBoxFuncionarioActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_MaturidadeProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_MaturidadeProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_MaturidadeProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_MaturidadeProfissional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_MaturidadeProfissional(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JLabel jButton3;
    private javax.swing.JLabel jButton4;
    private javax.swing.JLabel jButton5;
    private javax.swing.JLabel jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxAvaliadores;
    private javax.swing.JComboBox<String> jComboBoxFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextFieldAtualizacao;
    private javax.swing.JTextField jTextFieldCumprimentoNormas;
    private javax.swing.JTextField jTextFieldDiretoria;
    private javax.swing.JTextField jTextFieldExercicioFuncao;
    private javax.swing.JLabel jTextFieldFuncao;
    private javax.swing.JTextField jTextFieldNotaFinal;
    private javax.swing.JTextField jTextFieldSigla;
    private javax.swing.JTextField jTextFieldTempoExperiencia;
    private javax.swing.JTextField jTextFieldpontualidade;
    // End of variables declaration//GEN-END:variables
}
