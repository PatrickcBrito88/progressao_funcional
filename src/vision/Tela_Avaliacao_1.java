package vision;

import control.AnoControl;
import control.AvaliacaoControl;
import control.FuncionarioControl;
import models.AvaliacaoInteiroModel;
import models.AvaliacaoModel;
import utils.ConectaBanco;
import utils.ConnectionFactory;
import utils.Relatorios;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import net.sf.jasperreports.engine.JRException;

public class Tela_Avaliacao_1 extends javax.swing.JFrame {

    private static String bancoOf;
    ConectaBanco conecta;
    
    public Tela_Avaliacao_1(String banco) {
     this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        initComponents();
        AnoControl anoControle = new AnoControl(bancoOf);
        jTextFieldAno.setText(anoControle.getAno());
 }
    
    public void setCamposZerados(){
      jTextFieldConhecimentoTecnico2.setText(null);
      jTextFieldUsoFerramentasTI2.setText("");
      jTextFieldConhecimentoLegislacao2.setText("");
      jTextFieldConhecimentoNormas2.setText("");
      jTextFieldMelhoriaContinua2.setText("");
      jTextFieldSensoUrgencia2.setText("");
      jTextFieldResolucaoProblemas2.setText("");
      jTextFieldResultadoTrabalho2.setText("");
      jTextFieldComprometimento2.setText("");
      jTextFieldFlexibilidade2.setText("");
      jTextFieldProdutividade.setText("");
      jTextFieldGarantiaQualidade.setText("");
      jTextFieldOrganizacao.setText("");
      jTextFieldAnaliseRiscos.setText("");
      jTextFieldSatisfacaoUsuario.setText("");
      jTextFieldEficiênciaComunicacao.setText("");
      jTextFieldCordialidade.setText("");
      jTextFieldEspiritoEquipe.setText("");
      jTextFieldAdministracaoConflito.setText("");
      jTextFieldRespeitoIndividualidade.setText("");
      jTextFieldCoerencia.setText("");
      jTextFieldGerenciaObjetivos.setText("");
      jTextFieldGerenciaParticipativa.setText("");
      jTextFieldDesenvolvimentoPessoas.setText("");
      jTextFieldLideranca.setText("");
      
    }
    
     public void ImprimeViaAvaliador(){
        
    int matAvaliador = Integer.parseInt(jTextFieldMatAdor.getText());
    int matAvaliado = Integer.parseInt(jTextFieldMatAdo.getText());
    String nomeAvaliado = jTextFieldAdo.getText();
    String cargoAvaliado = jTextFieldCargoAdo.getText();
    String seuip = "";
        try {
                seuip=(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
                Logger.getLogger(AvaliacaoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    InputStream inputStream = getClass().getResourceAsStream("/Avaliação.jasper");
        Map<String,Object> parametros = new HashMap<String,Object>();
        
        parametros.put("mat_avaliador",matAvaliador);
        parametros.put("mat_avaliado",matAvaliado);
        parametros.put("Nome_avaliado",nomeAvaliado);
        parametros.put("cargo_avaliado",cargoAvaliado);
        parametros.put("seuip",seuip);
              
        try{
           
            Relatorios relat4 = new Relatorios();
            relat4.openReport("Avaliação", inputStream, parametros, ConnectionFactory.getConnection(bancoOf));
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }catch(JRException exc){
            JOptionPane.showMessageDialog(null,"Erro relatorio, motivo: \n"+exc);
        }
        
        
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
        jTextFieldAdo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldMatAdo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCargoAdor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCargoAdo = new javax.swing.JLabel();
        jTextFieldMatAdor = new javax.swing.JLabel();
        jTextFieldAdor = new javax.swing.JLabel();
        jPanelConhecimentoTecnico = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextFieldConhecimentoTecnico2 = new javax.swing.JTextField();
        jTextFieldUsoFerramentas = new javax.swing.JTextField();
        jTextFieldUsoFerramentasTI2 = new javax.swing.JTextField();
        jTextFieldConhecimentoLegislacao = new javax.swing.JTextField();
        jTextFieldConhecimentoLegislacao2 = new javax.swing.JTextField();
        jTextFieldConhecimentoNormas = new javax.swing.JTextField();
        jTextFieldConhecimentoNormas2 = new javax.swing.JTextField();
        jTextFieldMelhoria = new javax.swing.JTextField();
        jTextFieldMelhoriaContinua2 = new javax.swing.JTextField();
        jPanelConhecimentoTecnico1 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jTextFieldProdutividade = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextFieldGarantiaQualidade = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextFieldOrganizacao = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextFieldAnaliseRiscos = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextFieldSatisfacaoUsuario = new javax.swing.JTextField();
        jPanelConhecimentoTecnico2 = new javax.swing.JPanel();
        jTextFieldSensoUrgencia = new javax.swing.JTextField();
        jTextFieldSensoUrgencia2 = new javax.swing.JTextField();
        jTextFieldResolucaoProblemas = new javax.swing.JTextField();
        jTextFieldResolucaoProblemas2 = new javax.swing.JTextField();
        jTextFieldResultadoTrabalho = new javax.swing.JTextField();
        jTextFieldResultadoTrabalho2 = new javax.swing.JTextField();
        jTextFieldComprometimento = new javax.swing.JTextField();
        jTextFieldComprometimento2 = new javax.swing.JTextField();
        jTextFieldFlexibilidade = new javax.swing.JTextField();
        jTextFieldFlexibilidade2 = new javax.swing.JTextField();
        jPanelConhecimentoTecnico3 = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jTextFieldEficiênciaComunicacao = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextFieldCordialidade = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextFieldEspiritoEquipe = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextFieldAdministracaoConflito = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextFieldRespeitoIndividualidade = new javax.swing.JTextField();
        jPanelGestaoPessoas = new javax.swing.JPanel();
        jTextFieldCoerenciaBox = new javax.swing.JTextField();
        jTextFieldCoerencia = new javax.swing.JTextField();
        jTextFieldGerenciaObjetivoBox = new javax.swing.JTextField();
        jTextFieldGerenciaObjetivos = new javax.swing.JTextField();
        jTextFieldDesenvolvimentoPessoasBox = new javax.swing.JTextField();
        jTextFieldGerenciaParticipativa = new javax.swing.JTextField();
        jTextFieldLiderancaBox = new javax.swing.JTextField();
        jTextFieldDesenvolvimentoPessoas = new javax.swing.JTextField();
        jTextFieldGerenciaParticipativaBo = new javax.swing.JTextField();
        jTextFieldLideranca = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JLabel();

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
        jLabel6.setText("Avaliações");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 40));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 80, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldAdo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldAdo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldAdo.setText("xxxx");
        jPanel2.add(jTextFieldAdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 330, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Avaliado:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 96, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Avaliador:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Matrícula:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Matrícula:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 70, 20));

        jTextFieldMatAdo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMatAdo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldMatAdo.setText("xxxx");
        jPanel2.add(jTextFieldMatAdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 70, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Cargo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 70, -1));

        jTextFieldCargoAdor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCargoAdor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldCargoAdor.setText("xxxx");
        jPanel2.add(jTextFieldCargoAdor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 160, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Cargo:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 70, 20));

        jTextFieldCargoAdo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCargoAdo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldCargoAdo.setText("xxxx");
        jPanel2.add(jTextFieldCargoAdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 160, -1));

        jTextFieldMatAdor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMatAdor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldMatAdor.setText("xxxx");
        jPanel2.add(jTextFieldMatAdor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 70, -1));

        jTextFieldAdor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldAdor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jTextFieldAdor.setText("xxxx");
        jPanel2.add(jTextFieldAdor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 330, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 850, 90));

        jPanelConhecimentoTecnico.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConhecimentoTecnico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conhecimento Técnico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanelConhecimentoTecnico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField3.setText("Conhecimento Técnico");
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField3.setEnabled(false);
        jTextField3.setOpaque(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 339, -1));

        jTextFieldConhecimentoTecnico2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldConhecimentoTecnico2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldConhecimentoTecnico2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoTecnico2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoTecnico2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldConhecimentoTecnico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 31, -1));

        jTextFieldUsoFerramentas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldUsoFerramentas.setText("Uso de Ferramentas de Tec. Informação");
        jTextFieldUsoFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldUsoFerramentas.setEnabled(false);
        jTextFieldUsoFerramentas.setOpaque(false);
        jTextFieldUsoFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsoFerramentasActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldUsoFerramentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 339, -1));

        jTextFieldUsoFerramentasTI2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldUsoFerramentasTI2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsoFerramentasTI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsoFerramentasTI2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsoFerramentasTI2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldUsoFerramentasTI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 31, -1));

        jTextFieldConhecimentoLegislacao.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldConhecimentoLegislacao.setText("Conhecimento da Legislação");
        jTextFieldConhecimentoLegislacao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldConhecimentoLegislacao.setEnabled(false);
        jTextFieldConhecimentoLegislacao.setOpaque(false);
        jTextFieldConhecimentoLegislacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConhecimentoLegislacaoActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldConhecimentoLegislacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 339, -1));

        jTextFieldConhecimentoLegislacao2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldConhecimentoLegislacao2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldConhecimentoLegislacao2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoLegislacao2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoLegislacao2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldConhecimentoLegislacao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 31, -1));

        jTextFieldConhecimentoNormas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldConhecimentoNormas.setText("Conhecimento das normas");
        jTextFieldConhecimentoNormas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldConhecimentoNormas.setEnabled(false);
        jTextFieldConhecimentoNormas.setOpaque(false);
        jTextFieldConhecimentoNormas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConhecimentoNormasActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldConhecimentoNormas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 339, -1));

        jTextFieldConhecimentoNormas2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldConhecimentoNormas2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldConhecimentoNormas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoNormas2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldConhecimentoNormas2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldConhecimentoNormas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 31, -1));

        jTextFieldMelhoria.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldMelhoria.setText("Melhoria contínua");
        jTextFieldMelhoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldMelhoria.setEnabled(false);
        jTextFieldMelhoria.setOpaque(false);
        jTextFieldMelhoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMelhoriaActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldMelhoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 339, 20));

        jTextFieldMelhoriaContinua2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMelhoriaContinua2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMelhoriaContinua2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMelhoriaContinua2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMelhoriaContinua2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico.add(jTextFieldMelhoriaContinua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 31, -1));

        jPanel1.add(jPanelConhecimentoTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 410, 180));

        jPanelConhecimentoTecnico1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConhecimentoTecnico1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qualidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanelConhecimentoTecnico1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField17.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField17.setText("Produtividade");
        jTextField17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField17.setEnabled(false);
        jTextField17.setOpaque(false);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 304, -1));

        jTextFieldProdutividade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldProdutividade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldProdutividade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldProdutividadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldProdutividadeKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextFieldProdutividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 31, -1));

        jTextField19.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField19.setText("Garantia de Qualidade");
        jTextField19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField19.setEnabled(false);
        jTextField19.setOpaque(false);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 304, -1));

        jTextFieldGarantiaQualidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldGarantiaQualidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldGarantiaQualidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldGarantiaQualidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGarantiaQualidadeKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextFieldGarantiaQualidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 31, -1));

        jTextField21.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField21.setText("Organização");
        jTextField21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField21.setEnabled(false);
        jTextField21.setOpaque(false);
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 304, -1));

        jTextFieldOrganizacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldOrganizacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldOrganizacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldOrganizacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldOrganizacaoKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextFieldOrganizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 31, -1));

        jTextField23.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField23.setText("Análise de riscos e oportunidades");
        jTextField23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField23.setEnabled(false);
        jTextField23.setOpaque(false);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 304, -1));

        jTextFieldAnaliseRiscos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAnaliseRiscos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAnaliseRiscos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAnaliseRiscosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAnaliseRiscosKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextFieldAnaliseRiscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 31, -1));

        jTextField25.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField25.setText("Satisfação do usuário");
        jTextField25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField25.setEnabled(false);
        jTextField25.setOpaque(false);
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 149, 304, -1));

        jTextFieldSatisfacaoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldSatisfacaoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSatisfacaoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSatisfacaoUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSatisfacaoUsuarioKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico1.add(jTextFieldSatisfacaoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 31, -1));

        jPanel1.add(jPanelConhecimentoTecnico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 410, 180));

        jPanelConhecimentoTecnico2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConhecimentoTecnico2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compromisso e Iniciativa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanelConhecimentoTecnico2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSensoUrgencia.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldSensoUrgencia.setText("Senso de Urgência");
        jTextFieldSensoUrgencia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldSensoUrgencia.setEnabled(false);
        jTextFieldSensoUrgencia.setOpaque(false);
        jTextFieldSensoUrgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSensoUrgenciaActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldSensoUrgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 339, -1));

        jTextFieldSensoUrgencia2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldSensoUrgencia2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSensoUrgencia2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSensoUrgencia2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSensoUrgencia2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldSensoUrgencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 31, -1));

        jTextFieldResolucaoProblemas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldResolucaoProblemas.setText("Resolução de problemas");
        jTextFieldResolucaoProblemas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldResolucaoProblemas.setEnabled(false);
        jTextFieldResolucaoProblemas.setOpaque(false);
        jTextFieldResolucaoProblemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldResolucaoProblemasActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldResolucaoProblemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 339, -1));

        jTextFieldResolucaoProblemas2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldResolucaoProblemas2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResolucaoProblemas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldResolucaoProblemas2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldResolucaoProblemas2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldResolucaoProblemas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 31, -1));

        jTextFieldResultadoTrabalho.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldResultadoTrabalho.setText("Resultado do trabalho");
        jTextFieldResultadoTrabalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldResultadoTrabalho.setEnabled(false);
        jTextFieldResultadoTrabalho.setOpaque(false);
        jTextFieldResultadoTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldResultadoTrabalhoActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldResultadoTrabalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 339, -1));

        jTextFieldResultadoTrabalho2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldResultadoTrabalho2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultadoTrabalho2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldResultadoTrabalho2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldResultadoTrabalho2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldResultadoTrabalho2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 31, -1));

        jTextFieldComprometimento.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldComprometimento.setText("Comprometimento");
        jTextFieldComprometimento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldComprometimento.setEnabled(false);
        jTextFieldComprometimento.setOpaque(false);
        jTextFieldComprometimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComprometimentoActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldComprometimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 339, -1));

        jTextFieldComprometimento2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldComprometimento2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldComprometimento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldComprometimento2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldComprometimento2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldComprometimento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 31, -1));

        jTextFieldFlexibilidade.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldFlexibilidade.setText("Flexibilidade");
        jTextFieldFlexibilidade.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldFlexibilidade.setEnabled(false);
        jTextFieldFlexibilidade.setOpaque(false);
        jTextFieldFlexibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFlexibilidadeActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldFlexibilidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 339, -1));

        jTextFieldFlexibilidade2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldFlexibilidade2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFlexibilidade2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFlexibilidade2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFlexibilidade2KeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico2.add(jTextFieldFlexibilidade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 31, -1));

        jPanel1.add(jPanelConhecimentoTecnico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 410, 180));

        jPanelConhecimentoTecnico3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelConhecimentoTecnico3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relacionamento Interpessoal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanelConhecimentoTecnico3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField37.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField37.setText("Eficiência na comunicação");
        jTextField37.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField37.setEnabled(false);
        jTextField37.setOpaque(false);
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTextFieldEficiênciaComunicacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldEficiênciaComunicacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEficiênciaComunicacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEficiênciaComunicacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEficiênciaComunicacaoKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextFieldEficiênciaComunicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 31, -1));

        jTextField39.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField39.setText("Cordialidade e Respeito");
        jTextField39.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField39.setEnabled(false);
        jTextField39.setOpaque(false);
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 174, -1));

        jTextFieldCordialidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldCordialidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCordialidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCordialidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCordialidadeKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextFieldCordialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 31, -1));

        jTextField41.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField41.setText("Espírito de equipe");
        jTextField41.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField41.setEnabled(false);
        jTextField41.setOpaque(false);
        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField41ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 174, -1));

        jTextFieldEspiritoEquipe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldEspiritoEquipe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEspiritoEquipe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEspiritoEquipeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEspiritoEquipeKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextFieldEspiritoEquipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 31, -1));

        jTextField43.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField43.setText("Administração de conflitos");
        jTextField43.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField43.setEnabled(false);
        jTextField43.setOpaque(false);
        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField43ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 174, -1));

        jTextFieldAdministracaoConflito.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAdministracaoConflito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAdministracaoConflito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdministracaoConflitoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAdministracaoConflitoKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextFieldAdministracaoConflito, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 31, -1));

        jTextField45.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField45.setText("Respeito à individualidade");
        jTextField45.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField45.setEnabled(false);
        jTextField45.setOpaque(false);
        jTextField45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField45ActionPerformed(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 174, -1));

        jTextFieldRespeitoIndividualidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldRespeitoIndividualidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRespeitoIndividualidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRespeitoIndividualidadeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRespeitoIndividualidadeKeyTyped(evt);
            }
        });
        jPanelConhecimentoTecnico3.add(jTextFieldRespeitoIndividualidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 31, -1));

        jPanel1.add(jPanelConhecimentoTecnico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 410, 180));

        jPanelGestaoPessoas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestaoPessoas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestão de Pessoas - Exclusivo para avaliação de gestores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanelGestaoPessoas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldCoerenciaBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldCoerenciaBox.setText("Coerencia");
        jTextFieldCoerenciaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldCoerenciaBox.setEnabled(false);
        jTextFieldCoerenciaBox.setOpaque(false);
        jTextFieldCoerenciaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCoerenciaBoxActionPerformed(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldCoerenciaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 339, -1));

        jTextFieldCoerencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldCoerencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCoerencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCoerenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCoerenciaKeyTyped(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldCoerencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 31, -1));

        jTextFieldGerenciaObjetivoBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldGerenciaObjetivoBox.setText("Gerência por objetivos");
        jTextFieldGerenciaObjetivoBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldGerenciaObjetivoBox.setEnabled(false);
        jTextFieldGerenciaObjetivoBox.setOpaque(false);
        jTextFieldGerenciaObjetivoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGerenciaObjetivoBoxActionPerformed(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldGerenciaObjetivoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 339, -1));

        jTextFieldGerenciaObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldGerenciaObjetivos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldGerenciaObjetivos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldGerenciaObjetivosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGerenciaObjetivosKeyTyped(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldGerenciaObjetivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 31, -1));

        jTextFieldDesenvolvimentoPessoasBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldDesenvolvimentoPessoasBox.setText("Desenvolvimento de Pessoas");
        jTextFieldDesenvolvimentoPessoasBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldDesenvolvimentoPessoasBox.setEnabled(false);
        jTextFieldDesenvolvimentoPessoasBox.setOpaque(false);
        jTextFieldDesenvolvimentoPessoasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDesenvolvimentoPessoasBoxActionPerformed(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldDesenvolvimentoPessoasBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 339, -1));

        jTextFieldGerenciaParticipativa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldGerenciaParticipativa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldGerenciaParticipativa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldGerenciaParticipativaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGerenciaParticipativaKeyTyped(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldGerenciaParticipativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 31, -1));

        jTextFieldLiderancaBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldLiderancaBox.setText("Liderança");
        jTextFieldLiderancaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldLiderancaBox.setEnabled(false);
        jTextFieldLiderancaBox.setOpaque(false);
        jTextFieldLiderancaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLiderancaBoxActionPerformed(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldLiderancaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 339, -1));

        jTextFieldDesenvolvimentoPessoas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldDesenvolvimentoPessoas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDesenvolvimentoPessoas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDesenvolvimentoPessoasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDesenvolvimentoPessoasKeyTyped(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldDesenvolvimentoPessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 31, -1));

        jTextFieldGerenciaParticipativaBo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextFieldGerenciaParticipativaBo.setText("Gerencia Participativa");
        jTextFieldGerenciaParticipativaBo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldGerenciaParticipativaBo.setEnabled(false);
        jTextFieldGerenciaParticipativaBo.setOpaque(false);
        jTextFieldGerenciaParticipativaBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGerenciaParticipativaBoActionPerformed(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldGerenciaParticipativaBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 187, -1));

        jTextFieldLideranca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldLideranca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldLideranca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLiderancaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLiderancaKeyTyped(evt);
            }
        });
        jPanelGestaoPessoas.add(jTextFieldLideranca, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 31, -1));

        jPanel1.add(jPanelGestaoPessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 410, 180));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/impressora.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar 50px.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Avaliações referente ao exercício de ");

        jTextFieldAno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldAno.setText("Ano");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldAno)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 400, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
    }//GEN-LAST:event_formWindowActivated

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextFieldUsoFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsoFerramentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsoFerramentasActionPerformed

    private void jTextFieldConhecimentoLegislacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoLegislacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoLegislacaoActionPerformed

    private void jTextFieldConhecimentoNormasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoNormasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoNormasActionPerformed

    private void jTextFieldMelhoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMelhoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMelhoriaActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextFieldSensoUrgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSensoUrgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSensoUrgenciaActionPerformed

    private void jTextFieldResolucaoProblemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldResolucaoProblemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResolucaoProblemasActionPerformed

    private void jTextFieldResultadoTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldResultadoTrabalhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResultadoTrabalhoActionPerformed

    private void jTextFieldComprometimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComprometimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComprometimentoActionPerformed

    private void jTextFieldFlexibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFlexibilidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFlexibilidadeActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

    private void jTextField41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField41ActionPerformed

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField43ActionPerformed

    private void jTextField45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField45ActionPerformed

    private void jTextFieldCoerenciaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCoerenciaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCoerenciaBoxActionPerformed

    private void jTextFieldGerenciaObjetivoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaObjetivoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGerenciaObjetivoBoxActionPerformed

    private void jTextFieldDesenvolvimentoPessoasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDesenvolvimentoPessoasBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesenvolvimentoPessoasBoxActionPerformed

    private void jTextFieldLiderancaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLiderancaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLiderancaBoxActionPerformed

    private void jTextFieldGerenciaParticipativaBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaParticipativaBoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGerenciaParticipativaBoActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
       String cargoAvaliador = jTextFieldCargoAdor.getText();
       String cargoAvaliado = jTextFieldCargoAdo.getText();
       
         if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Gerente"))){//ok
       
             try{
                
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
             
             } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
               
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaFuncionarioGerente(ado);//ok
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
          
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
       
       
    }
       
       if (cargoAvaliador.equals("Gerente")&&(cargoAvaliado.equals("Chefe"))){//ok
            
           try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
       } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaGerenteChefe(ado);//ok
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
               
      if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
        if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Chefe"))){//ok
        
            try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
       } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaFuncionarioChefe(ado);//ok
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
          
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
       
    }
        
        
       if (cargoAvaliador.equals("Gerente")&&(cargoAvaliado.equals("Funcionário"))){//ok
             
           try{ 
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       

        } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       double valor =avaliacaoControle.calculaNotaCorrigidaGerFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida = avaliacao.getNotaCorrigidaTotalDouble(ado);
      
        avaliacao.getNotaCorrigidaTotal(ado);
         avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
        avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
       avaliacaoControle.calculaPercentualFinal(ado);
     
        
         
         boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
         
              
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
       
       if (cargoAvaliador.equals("Diretor")&&(cargoAvaliado.equals("Funcionário"))){//ok
          
           try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       
        } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       double valor =avaliacaoControle.calculaNotaCorrigidaGerFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida = avaliacao.getNotaCorrigidaTotalDouble(ado);
      
        avaliacao.getNotaCorrigidaTotal(ado);
         avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
        avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
       avaliacaoControle.calculaPercentualFinal(ado);
     
        
         
         boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
         
             
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
     
         if (cargoAvaliador.equals("Chefe de Gabinete")&&(cargoAvaliado.equals("Funcionário"))){//ok
              
             try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       

        } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       double valor =avaliacaoControle.calculaNotaCorrigidaGerFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida = avaliacao.getNotaCorrigidaTotalDouble(ado);
      
        avaliacao.getNotaCorrigidaTotal(ado);
         avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
        avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
       avaliacaoControle.calculaPercentualFinal(ado);
     
        
         
         boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
         
              
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
            if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Funcionário"))){//ok
              
             try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       

        } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       double valor =avaliacaoControle.calculaNotaCorrigidaGerFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida = avaliacao.getNotaCorrigidaTotalDouble(ado);
      
        avaliacao.getNotaCorrigidaTotal(ado);
         avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
        avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
       avaliacaoControle.calculaPercentualFinal(ado);
     
        
         
         boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
         
              
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
            
       if (cargoAvaliador.equals("Chefe")&&(cargoAvaliado.equals("Funcionário"))){//ok
          try{    
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       

        } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       double valor =avaliacaoControle.calculaNotaCorrigidaGerFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida = avaliacao.getNotaCorrigidaTotalDouble(ado);
      
        avaliacao.getNotaCorrigidaTotal(ado);
         avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
        avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
       avaliacaoControle.calculaPercentualFinal(ado);
     
        
         
         boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
         
               
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
         
         if (cargoAvaliador.equals("Chefe")&&(cargoAvaliado.equals("Chefe"))){//ok
             
             try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
       
       } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
            
      
      
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
         
         if (cargoAvaliador.equals("Diretor")&&(cargoAvaliado.equals("Diretor"))){//ok
             try{ 
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
                   
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
            if (cargoAvaliador.equals("Chefe de Gabinete")&&(cargoAvaliado.equals("Chefe de Gabinete"))){//ok
              
                try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
                
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
       
    }
     
        if (cargoAvaliador.equals("Assessor da Presidência")&&(cargoAvaliado.equals("Assessor da Presidência"))){//ok
              
                try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
                
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
       
    }
        
        if (cargoAvaliador.equals("Assessor de Imprensa")&&(cargoAvaliado.equals("Assessor de Imprensa"))){//ok
              
                try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
                
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
       
    }
                   
            if (cargoAvaliador.equals("Gerente")&&(cargoAvaliado.equals("Gerente"))){//ok
              
                try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaAutoGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
                   
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
            
         if (cargoAvaliador.equals("Chefe")&&(cargoAvaliado.equals("Gerente"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
            
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
       if (cargoAvaliador.equals("Diretor")&&(cargoAvaliado.equals("Chefe"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
            
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
            
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
     
       if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Diretor"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
       
      
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
     
       if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Chefe"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
      
      
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
       
      if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Chefe de Gabinete"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
                
              } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
            
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
      if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Assessor da Presidência"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
                
              } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
            
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
      if (cargoAvaliador.equals("Presidente")&&(cargoAvaliado.equals("Assessor de Imprensa"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
                
              } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
            
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
            if (cargoAvaliador.equals("Chefe")&&(cargoAvaliado.equals("Diretor"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
               } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
      
      
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
            
       if (cargoAvaliador.equals("Gerente")&&(cargoAvaliado.equals("Diretor"))){//utilizado para a gerencia que avalia direto a diretoria
              try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
      
        if (cargoAvaliador.equals("Gerente")&&(cargoAvaliado.equals("Chefe de Gabinete"))){//utilizado para a gerencia que avalia direto a diretoria
              
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
        
       if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Diretor"))){//utilizado para a gerencia que avalia direto a diretoria
                try{
           avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
      
    }
     
        if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Chefe de Gabinete"))){//utilizado para a gerencia que avalia direto a diretoria
              try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
                } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
       
         if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Assessor da Presidência"))){//utilizado para a gerencia que avalia direto a diretoria
              try{
       avaliacaoModelo.setConhecimentoTecnico(Double.parseDouble(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Double.parseDouble(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Double.parseDouble(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Double.parseDouble(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Double.parseDouble(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Double.parseDouble(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Double.parseDouble(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Double.parseDouble(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Double.parseDouble(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Double.parseDouble(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Double.parseDouble(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Double.parseDouble(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Double.parseDouble(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Double.parseDouble(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Double.parseDouble(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Double.parseDouble(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Double.parseDouble(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Double.parseDouble(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Double.parseDouble(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Double.parseDouble(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Double.parseDouble(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Double.parseDouble(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Double.parseDouble(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Double.parseDouble(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Double.parseDouble(jTextFieldLideranca.getText()));
       
                } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);//ok
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado);//ok
       avaliacaoControle.calculaMediaChefeDiretor(ado);//ok 
       avaliacaoControle.calculaNotaCorrigidaGestorInvertido(avaliacaoModelo, 888, ado);
       
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, 888);
      avaliacaoControle.calculaPercentualFinal(ado);
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
         
         if (cargoAvaliador.equals("Funcionário")&&(cargoAvaliado.equals("Funcionário"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
//       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
//       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
//       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
//       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldLideranca.getText()));
//       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
//       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
       AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado);
       avaliacaoControle.calculaNotaCorrigidaFuncFunc(avaliacaoModelo, ador, ado);
       avaliacaoControle.getTotalAtual(ador, ado);
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado);
       avaliacao.getNotaCorrigidaTotal(ado);
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//esse método vem sempre depois do método acima
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador);
      avaliacaoControle.calculaPercentualFinal(ado);
   
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMenor(ador, ado);
//        jTextFieldNota_Percentual.setText(getPercentual(ado, ador));
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
         
          if (cargoAvaliador.equals("Diretor")&&(cargoAvaliado.equals("Gerente"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
                } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
       
       int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }
     
       if (cargoAvaliador.equals("Chefe de Gabinete")&&(cargoAvaliado.equals("Gerente"))){//ok
              try{
       avaliacaoModelo.setConhecimentoTecnico(Integer.parseInt(jTextFieldConhecimentoTecnico2.getText()));
       avaliacaoModelo.setUsoFerrantentasTI(Integer.parseInt(jTextFieldUsoFerramentasTI2.getText()));
       avaliacaoModelo.setConhecimentoLegislacao(Integer.parseInt(jTextFieldConhecimentoLegislacao2.getText()));
       avaliacaoModelo.setConhecimentoNormas(Integer.parseInt(jTextFieldConhecimentoNormas2.getText()));
       avaliacaoModelo.setMelhoriaContinua(Integer.parseInt(jTextFieldMelhoriaContinua2.getText()));
       avaliacaoModelo.setProdutividade(Integer.parseInt(jTextFieldProdutividade.getText()));
       avaliacaoModelo.setGarantiaQualidade(Integer.parseInt(jTextFieldGarantiaQualidade.getText()));
       avaliacaoModelo.setOrganizacao(Integer.parseInt(jTextFieldOrganizacao.getText()));
       avaliacaoModelo.setAnaliseRiscos(Integer.parseInt(jTextFieldAnaliseRiscos.getText()));
       avaliacaoModelo.setSatisfacaoUsuario(Integer.parseInt(jTextFieldSatisfacaoUsuario.getText()));
       avaliacaoModelo.setSensoUrgencia(Integer.parseInt(jTextFieldSensoUrgencia2.getText()));
       avaliacaoModelo.setResolucaoProblema(Integer.parseInt(jTextFieldResolucaoProblemas2.getText()));
       avaliacaoModelo.setResultadoTrabalho(Integer.parseInt(jTextFieldResultadoTrabalho2.getText()));
       avaliacaoModelo.setCompromentimento(Integer.parseInt(jTextFieldComprometimento2.getText()));
       avaliacaoModelo.setFlexibilidade(Integer.parseInt(jTextFieldFlexibilidade2.getText()));
       avaliacaoModelo.setEficienciaComunicacao(Integer.parseInt(jTextFieldEficiênciaComunicacao.getText()));
       avaliacaoModelo.setCordialidadeRespeito(Integer.parseInt(jTextFieldCordialidade.getText()));
       avaliacaoModelo.setEspiritoEquipe(Integer.parseInt(jTextFieldEspiritoEquipe.getText()));
       avaliacaoModelo.setAdministracaoConflitos(Integer.parseInt(jTextFieldAdministracaoConflito.getText()));
       avaliacaoModelo.setRespeitoIndividualidade(Integer.parseInt(jTextFieldRespeitoIndividualidade.getText()));
       avaliacaoModelo.setCoerencia(Integer.parseInt(jTextFieldCoerencia.getText()));
       avaliacaoModelo.setGerenciaObjetivos(Integer.parseInt(jTextFieldGerenciaObjetivos.getText()));
       avaliacaoModelo.setDesenvolvimentoPessoas(Integer.parseInt(jTextFieldGerenciaParticipativa.getText()));
       avaliacaoModelo.setLideranca(Integer.parseInt(jTextFieldDesenvolvimentoPessoas.getText()));
       avaliacaoModelo.setGerenciaParticipativa(Integer.parseInt(jTextFieldLideranca.getText()));
       
       
            } catch (NumberFormatException e){
                 JOptionPane.showMessageDialog(null,"Você precisa atribuir valor a todos os campos!");
                 return;
             }
             
      AvaliacaoControl  avaliacaoControle = new AvaliacaoControl(bancoOf);
       int ado = Integer.parseInt(jTextFieldMatAdo.getText());
       int ador = Integer.parseInt(jTextFieldMatAdor.getText());
       avaliacaoControle.gravaEditaAvaliacao(avaliacaoModelo, ador, ado); // LANÇA EM AVALIAÇÃO
       boolean sinal = avaliacaoControle.verificaAvaliadoGrauMaior(ador, ado); 
    avaliacaoControle.calculaNotaCorrigidaGestorGestor(avaliacaoModelo, ador, ado);//CALCULA NOTA CORRIGIDA AUTO AVALIAÇÃO GESTOR
       //teste  FEITO EM 31/05/2018
       avaliacaoControle.getTotalAtual(ador, ado); //NAO LEMBRO PARA QUE SERVE
       AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       double totalCorrigida=avaliacao.getNotaCorrigidaTotalDouble(ado); //PEGA A NOTA CORRIGIDA TOTAL
       avaliacao.getNotaCorrigidaTotal(ado); // NAO LEMBRO
        avaliacao.atualizaCorrigidaTotal(ado, totalCorrigida);//eATUALIZA A NOTA CORRIGIDA TOTAL
       avaliacao.calculaGravaPercentual(avaliacaoModelo, ado, ador); //CALCULA E GRAVA O PERCENTUAL
      avaliacaoControle.calculaPercentualFinal(ado);//CALCULA PERCENTUAL FINAL
       
       
       if (sinal==true){
           avaliacaoControle.alteraBoolAvaliacao(ado, ador);
       }
    
       
      int op=JOptionPane.showConfirmDialog(null,"Deseja imprimir sua via?",null, JOptionPane.YES_NO_OPTION);
              
       
       if (op==JOptionPane.YES_OPTION){
           ImprimeViaAvaliador();
       } else {}
    }  
       
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jTextFieldConhecimentoTecnico2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoTecnico2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoTecnico2KeyTyped

    private void jTextFieldUsoFerramentasTI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsoFerramentasTI2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsoFerramentasTI2KeyTyped

    private void jTextFieldConhecimentoLegislacao2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoLegislacao2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoLegislacao2KeyTyped

    private void jTextFieldConhecimentoNormas2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoNormas2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoNormas2KeyTyped

    private void jTextFieldMelhoriaContinua2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMelhoriaContinua2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMelhoriaContinua2KeyTyped

    private void jTextFieldSensoUrgencia2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSensoUrgencia2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSensoUrgencia2KeyTyped

    private void jTextFieldResolucaoProblemas2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldResolucaoProblemas2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResolucaoProblemas2KeyTyped

    private void jTextFieldResultadoTrabalho2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldResultadoTrabalho2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResultadoTrabalho2KeyTyped

    private void jTextFieldComprometimento2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldComprometimento2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComprometimento2KeyTyped

    private void jTextFieldFlexibilidade2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFlexibilidade2KeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFlexibilidade2KeyTyped

    private void jTextFieldCoerenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCoerenciaKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCoerenciaKeyTyped

    private void jTextFieldGerenciaObjetivosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaObjetivosKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGerenciaObjetivosKeyTyped

    private void jTextFieldGerenciaParticipativaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaParticipativaKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGerenciaParticipativaKeyTyped

    private void jTextFieldDesenvolvimentoPessoasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesenvolvimentoPessoasKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDesenvolvimentoPessoasKeyTyped

    private void jTextFieldLiderancaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLiderancaKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLiderancaKeyTyped

    private void jTextFieldProdutividadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutividadeKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdutividadeKeyTyped

    private void jTextFieldGarantiaQualidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGarantiaQualidadeKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGarantiaQualidadeKeyTyped

    private void jTextFieldOrganizacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldOrganizacaoKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrganizacaoKeyTyped

    private void jTextFieldAnaliseRiscosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnaliseRiscosKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnaliseRiscosKeyTyped

    private void jTextFieldSatisfacaoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSatisfacaoUsuarioKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSatisfacaoUsuarioKeyTyped

    private void jTextFieldEficiênciaComunicacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEficiênciaComunicacaoKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEficiênciaComunicacaoKeyTyped

    private void jTextFieldCordialidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCordialidadeKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCordialidadeKeyTyped

    private void jTextFieldEspiritoEquipeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEspiritoEquipeKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEspiritoEquipeKeyTyped

    private void jTextFieldAdministracaoConflitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdministracaoConflitoKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdministracaoConflitoKeyTyped

    private void jTextFieldRespeitoIndividualidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRespeitoIndividualidadeKeyTyped
String caracteres = "54321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRespeitoIndividualidadeKeyTyped

    private void jTextFieldConhecimentoTecnico2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoTecnico2KeyPressed
  String numNota = jTextFieldConhecimentoTecnico2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldConhecimentoTecnico2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldConhecimentoTecnico2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoTecnico2KeyPressed

    private void jTextFieldUsoFerramentasTI2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsoFerramentasTI2KeyPressed
String numNota = jTextFieldUsoFerramentasTI2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldUsoFerramentasTI2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldUsoFerramentasTI2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsoFerramentasTI2KeyPressed

    private void jTextFieldConhecimentoLegislacao2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoLegislacao2KeyPressed
 String numNota = jTextFieldConhecimentoLegislacao2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldConhecimentoLegislacao2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldConhecimentoLegislacao2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoLegislacao2KeyPressed

    private void jTextFieldConhecimentoNormas2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConhecimentoNormas2KeyPressed
 String numNota = jTextFieldConhecimentoNormas2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldConhecimentoNormas2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldConhecimentoNormas2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConhecimentoNormas2KeyPressed

    private void jTextFieldMelhoriaContinua2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMelhoriaContinua2KeyPressed
 String numNota = jTextFieldMelhoriaContinua2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldMelhoriaContinua2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldMelhoriaContinua2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMelhoriaContinua2KeyPressed

    private void jTextFieldProdutividadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutividadeKeyPressed
 String numNota = jTextFieldProdutividade.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldProdutividade.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldProdutividade.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdutividadeKeyPressed

    private void jTextFieldGarantiaQualidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGarantiaQualidadeKeyPressed
 String numNota = jTextFieldGarantiaQualidade.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldGarantiaQualidade.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldGarantiaQualidade.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGarantiaQualidadeKeyPressed

    private void jTextFieldOrganizacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldOrganizacaoKeyPressed
String numNota = jTextFieldOrganizacao.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldOrganizacao.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldOrganizacao.setText(primeiroDigito);
       }       
    }//GEN-LAST:event_jTextFieldOrganizacaoKeyPressed

    private void jTextFieldAnaliseRiscosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnaliseRiscosKeyPressed
         String numNota = jTextFieldAnaliseRiscos.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldAnaliseRiscos.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldAnaliseRiscos.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldAnaliseRiscosKeyPressed

    private void jTextFieldSatisfacaoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSatisfacaoUsuarioKeyPressed
        String numNota = jTextFieldSatisfacaoUsuario.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldSatisfacaoUsuario.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldSatisfacaoUsuario.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldSatisfacaoUsuarioKeyPressed

    private void jTextFieldSensoUrgencia2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSensoUrgencia2KeyPressed
 String numNota = jTextFieldSensoUrgencia2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldSensoUrgencia2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldSensoUrgencia2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSensoUrgencia2KeyPressed

    private void jTextFieldResolucaoProblemas2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldResolucaoProblemas2KeyPressed
 String numNota = jTextFieldResolucaoProblemas2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldResolucaoProblemas2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldResolucaoProblemas2.setText(primeiroDigito);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResolucaoProblemas2KeyPressed

    private void jTextFieldResultadoTrabalho2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldResultadoTrabalho2KeyPressed
         String numNota = jTextFieldResultadoTrabalho2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldResultadoTrabalho2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldResultadoTrabalho2.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldResultadoTrabalho2KeyPressed

    private void jTextFieldComprometimento2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldComprometimento2KeyPressed
        String numNota = jTextFieldComprometimento2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldComprometimento2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldComprometimento2.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldComprometimento2KeyPressed

    private void jTextFieldFlexibilidade2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFlexibilidade2KeyPressed
        String numNota = jTextFieldFlexibilidade2.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldFlexibilidade2.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldFlexibilidade2.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldFlexibilidade2KeyPressed

    private void jTextFieldEficiênciaComunicacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEficiênciaComunicacaoKeyPressed
          String numNota = jTextFieldEficiênciaComunicacao.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldEficiênciaComunicacao.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldEficiênciaComunicacao.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldEficiênciaComunicacaoKeyPressed

    private void jTextFieldCordialidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCordialidadeKeyPressed
        String numNota = jTextFieldCordialidade.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldCordialidade.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldCordialidade.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldCordialidadeKeyPressed

    private void jTextFieldEspiritoEquipeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEspiritoEquipeKeyPressed
       String numNota = jTextFieldEspiritoEquipe.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldEspiritoEquipe.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldEspiritoEquipe.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldEspiritoEquipeKeyPressed

    private void jTextFieldAdministracaoConflitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdministracaoConflitoKeyPressed
         String numNota = jTextFieldAdministracaoConflito.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldAdministracaoConflito.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldAdministracaoConflito.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldAdministracaoConflitoKeyPressed

    private void jTextFieldRespeitoIndividualidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRespeitoIndividualidadeKeyPressed
        String numNota = jTextFieldRespeitoIndividualidade.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldRespeitoIndividualidade.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldRespeitoIndividualidade.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldRespeitoIndividualidadeKeyPressed

    private void jTextFieldCoerenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCoerenciaKeyPressed
        String numNota = jTextFieldCoerencia.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldCoerencia.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldCoerencia.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldCoerenciaKeyPressed

    private void jTextFieldGerenciaObjetivosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaObjetivosKeyPressed
        String numNota = jTextFieldGerenciaObjetivos.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldGerenciaObjetivos.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldGerenciaObjetivos.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldGerenciaObjetivosKeyPressed

    private void jTextFieldDesenvolvimentoPessoasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDesenvolvimentoPessoasKeyPressed
         String numNota = jTextFieldDesenvolvimentoPessoas.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldDesenvolvimentoPessoas.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldDesenvolvimentoPessoas.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldDesenvolvimentoPessoasKeyPressed

    private void jTextFieldGerenciaParticipativaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGerenciaParticipativaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGerenciaParticipativaKeyPressed

    private void jTextFieldLiderancaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLiderancaKeyPressed
      String numNota = jTextFieldLideranca.getText();
       String primeiroDigito="";
        try {
            primeiroDigito = jTextFieldLideranca.getText(0,0);
        } catch (BadLocationException ex) {
            Logger.getLogger(Tela_Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int quantCaracteres = numNota.length();
       if (quantCaracteres==0){
           
       } else {
          jTextFieldLideranca.setText(primeiroDigito);
       }
    }//GEN-LAST:event_jTextFieldLiderancaKeyPressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         ImprimeViaAvaliador();
    }//GEN-LAST:event_jLabel3MouseClicked

     public void setCampos(int matAdor, int matAdo, String ador, String ado, 
            String cargoAdo, String cargoAdor ){
        jTextFieldAdo.setText(ado);
        jTextFieldAdor.setText(ador);
        jTextFieldCargoAdo.setText(cargoAdo);
        jTextFieldCargoAdor.setText(cargoAdor);
        jTextFieldMatAdo.setText(String.valueOf(matAdo));
        jTextFieldMatAdor.setText(String.valueOf(matAdor));
        
        String cargoAvaliador = jTextFieldCargoAdor.getText();
        String cargoAvaliado = jTextFieldCargoAdo.getText();
        FuncionarioControl funcionario  = new FuncionarioControl(bancoOf);
        int mat=funcionario.getMatFunc(ado);
        AvaliacaoControl avaliacao = new AvaliacaoControl(bancoOf);
       
        
        
        if (cargoAvaliador.equals("Gerente") && cargoAvaliado.equals("Funcionário")){
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
        
//        if (cargoAvaliador.equals("Chefe") && cargoAvaliado.equals("Gerente")){
//           
//            
//            jTextFieldCoerencia.setEnabled(false);
//            jTextFieldGerenciaObjetivos.setEnabled(false);
//            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
//            jTextFieldLideranca.setEnabled(false);
//            jTextFieldGerenciaParticipativa.setEnabled(false);
//            
//        }
//        
//        if (cargoAvaliador.equals("Chefe") && cargoAvaliado.equals("Chefe")){
//           
//            
//            jTextFieldCoerencia.setEnabled(false);
//            jTextFieldGerenciaObjetivos.setEnabled(false);
//            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
//            jTextFieldLideranca.setEnabled(false);
//            jTextFieldGerenciaParticipativa.setEnabled(false);
//            
//        }
        
//        if (cargoAvaliador.equals("Gerente") && cargoAvaliado.equals("Gerente")){
//           
//            
//            jTextFieldCoerencia.setEnabled(false);
//            jTextFieldGerenciaObjetivos.setEnabled(false);
//            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
//            jTextFieldLideranca.setEnabled(false);
//            jTextFieldGerenciaParticipativa.setEnabled(false);
//            
//        }
        
        if (cargoAvaliador.equals("Funcionário") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
        
        if (cargoAvaliador.equals("Diretor") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
        
         if (cargoAvaliador.equals("Chefe") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
        
          if (cargoAvaliador.equals("Chefe de Gabinete") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
         
          if (cargoAvaliador.equals("Assessor da Presidência") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
          
          if (cargoAvaliador.equals("Presidente") && cargoAvaliado.equals("Funcionário")){
           
            
            jTextFieldCoerencia.setEnabled(false);
            jTextFieldGerenciaObjetivos.setEnabled(false);
            jTextFieldDesenvolvimentoPessoas.setEnabled(false);
            jTextFieldLideranca.setEnabled(false);
            jTextFieldGerenciaParticipativa.setEnabled(false);
            
        }
          
        AvaliacaoControl avaliacaoControle = new AvaliacaoControl(bancoOf);
        String total=(avaliacaoControle.getTotalAtual(matAdor, matAdo));
        String resultado2=avaliacao.getTotal(matAdo);
        
    }
    
    public void setAvaliacao(int ado, int ador){
      AvaliacaoInteiroModel avaliacaoModelo = new AvaliacaoInteiroModel();
      AvaliacaoControl avaliacaoControle = new AvaliacaoControl(bancoOf);
      avaliacaoModelo=avaliacaoControle.getAvaliacaoDadosInteiros(ado, ador);
      
      //atribuição
      
      jTextFieldConhecimentoTecnico2.setText(String.valueOf(avaliacaoModelo.getConhecimentoTecnico()));
      jTextFieldUsoFerramentasTI2.setText(String.valueOf(avaliacaoModelo.getUsoFerrantentasTI()));
      jTextFieldConhecimentoLegislacao2.setText(String.valueOf(avaliacaoModelo.getConhecimentoLegislacao()));
      jTextFieldConhecimentoNormas2.setText(String.valueOf(avaliacaoModelo.getConhecimentoNormas()));
      jTextFieldMelhoriaContinua2.setText(String.valueOf(avaliacaoModelo.getMelhoriaContinua()));
      jTextFieldSensoUrgencia2.setText(String.valueOf(avaliacaoModelo.getSensoUrgencia()));
      jTextFieldResolucaoProblemas2.setText(String.valueOf(avaliacaoModelo.getResolucaoProblema()));
      jTextFieldResultadoTrabalho2.setText(String.valueOf(avaliacaoModelo.getResultadoTrabalho()));
      jTextFieldComprometimento2.setText(String.valueOf(avaliacaoModelo.getCompromentimento()));
      jTextFieldFlexibilidade2.setText(String.valueOf(avaliacaoModelo.getFlexibilidade()));
      jTextFieldProdutividade.setText(String.valueOf(avaliacaoModelo.getProdutividade()));
      jTextFieldGarantiaQualidade.setText((String.valueOf(avaliacaoModelo.getGarantiaQualidade())));
      jTextFieldOrganizacao.setText(String.valueOf(avaliacaoModelo.getOrganizacao()));
      jTextFieldAnaliseRiscos.setText((String.valueOf(avaliacaoModelo.getAnaliseRiscos())));
      jTextFieldSatisfacaoUsuario.setText(String.valueOf(avaliacaoModelo.getSatisfacaoUsuario()));
      jTextFieldEficiênciaComunicacao.setText(String.valueOf(avaliacaoModelo.getEficienciaComunicacao()));
      jTextFieldCordialidade.setText(String.valueOf(avaliacaoModelo.getCordialidadeRespeito()));
      jTextFieldEspiritoEquipe.setText(String.valueOf(avaliacaoModelo.getEspiritoEquipe()));
      jTextFieldAdministracaoConflito.setText(String.valueOf(avaliacaoModelo.getAdministracaoConflitos()));
      jTextFieldRespeitoIndividualidade.setText(String.valueOf(avaliacaoModelo.getRespeitoIndividualidade()));
      jTextFieldCoerencia.setText(String.valueOf(avaliacaoModelo.getCoerencia()));
      jTextFieldGerenciaObjetivos.setText(String.valueOf(avaliacaoModelo.getGerenciaObjetivos()));
      jTextFieldDesenvolvimentoPessoas.setText(String.valueOf(avaliacaoModelo.getDesenvolvimentoPessoas()));
      jTextFieldLideranca.setText(String.valueOf(avaliacaoModelo.getLideranca()));
      jTextFieldGerenciaParticipativa.setText(String.valueOf(avaliacaoModelo.getGerenciaParticipativa()));
   }
    
    
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
            java.util.logging.Logger.getLogger(Tela_Avaliacao_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Avaliacao_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Avaliacao_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Avaliacao_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Avaliacao_1(bancoOf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelConhecimentoTecnico;
    private javax.swing.JPanel jPanelConhecimentoTecnico1;
    private javax.swing.JPanel jPanelConhecimentoTecnico2;
    private javax.swing.JPanel jPanelConhecimentoTecnico3;
    private javax.swing.JPanel jPanelGestaoPessoas;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextFieldAdministracaoConflito;
    private javax.swing.JLabel jTextFieldAdo;
    private javax.swing.JLabel jTextFieldAdor;
    private javax.swing.JTextField jTextFieldAnaliseRiscos;
    private javax.swing.JLabel jTextFieldAno;
    private javax.swing.JLabel jTextFieldCargoAdo;
    private javax.swing.JLabel jTextFieldCargoAdor;
    private javax.swing.JTextField jTextFieldCoerencia;
    private javax.swing.JTextField jTextFieldCoerenciaBox;
    private javax.swing.JTextField jTextFieldComprometimento;
    private javax.swing.JTextField jTextFieldComprometimento2;
    private javax.swing.JTextField jTextFieldConhecimentoLegislacao;
    private javax.swing.JTextField jTextFieldConhecimentoLegislacao2;
    private javax.swing.JTextField jTextFieldConhecimentoNormas;
    private javax.swing.JTextField jTextFieldConhecimentoNormas2;
    private javax.swing.JTextField jTextFieldConhecimentoTecnico2;
    private javax.swing.JTextField jTextFieldCordialidade;
    private javax.swing.JTextField jTextFieldDesenvolvimentoPessoas;
    private javax.swing.JTextField jTextFieldDesenvolvimentoPessoasBox;
    private javax.swing.JTextField jTextFieldEficiênciaComunicacao;
    private javax.swing.JTextField jTextFieldEspiritoEquipe;
    private javax.swing.JTextField jTextFieldFlexibilidade;
    private javax.swing.JTextField jTextFieldFlexibilidade2;
    private javax.swing.JTextField jTextFieldGarantiaQualidade;
    private javax.swing.JTextField jTextFieldGerenciaObjetivoBox;
    private javax.swing.JTextField jTextFieldGerenciaObjetivos;
    private javax.swing.JTextField jTextFieldGerenciaParticipativa;
    private javax.swing.JTextField jTextFieldGerenciaParticipativaBo;
    private javax.swing.JTextField jTextFieldLideranca;
    private javax.swing.JTextField jTextFieldLiderancaBox;
    private javax.swing.JLabel jTextFieldMatAdo;
    private javax.swing.JLabel jTextFieldMatAdor;
    private javax.swing.JTextField jTextFieldMelhoria;
    private javax.swing.JTextField jTextFieldMelhoriaContinua2;
    private javax.swing.JTextField jTextFieldOrganizacao;
    private javax.swing.JTextField jTextFieldProdutividade;
    private javax.swing.JTextField jTextFieldResolucaoProblemas;
    private javax.swing.JTextField jTextFieldResolucaoProblemas2;
    private javax.swing.JTextField jTextFieldRespeitoIndividualidade;
    private javax.swing.JTextField jTextFieldResultadoTrabalho;
    private javax.swing.JTextField jTextFieldResultadoTrabalho2;
    private javax.swing.JTextField jTextFieldSatisfacaoUsuario;
    private javax.swing.JTextField jTextFieldSensoUrgencia;
    private javax.swing.JTextField jTextFieldSensoUrgencia2;
    private javax.swing.JTextField jTextFieldUsoFerramentas;
    private javax.swing.JTextField jTextFieldUsoFerramentasTI2;
    // End of variables declaration//GEN-END:variables
}
