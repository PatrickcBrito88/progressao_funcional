package vision;

import control.FuncionarioControl;
import control.GerenciamentoSistemaControl;
import control.ListaBancoControl;
import models.FuncionarioModel;
import utils.ConectaBanco;
import valid_login.FuncionarioLogin;
import valid_login.ValidaLogin;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

     private static String bancoOf;
   
    public TelaLogin() {
        setLF();
        initComponents();
    }

    public void setaBanco(String banco) {
        this.bancoOf = banco;
    }
    
    public void setLF() {

        try {
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Large-Font");
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void SelecaoBanco() {
        ArrayList<String> lista = new ArrayList();
        ListaBancoControl controleBanco = new ListaBancoControl();
        lista = controleBanco.getListaBanco();
        JComboBox jcb = new JComboBox();

        for (int i = 0; i < lista.size(); i++) {
            jcb.addItem(lista.get(i));
        }

        Object[] options = {"Confirmar", "Sair"};
        int i = JOptionPane.showOptionDialog(null, jcb,
                "Selecione a base de dados que deseja operar", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        int j = jcb.getSelectedIndex();
//         if (j == 0) {
//            bancoOf = "AD_22";
//            System.out.println(bancoOf);
//        }        
        if (j == 0) {
            bancoOf = "AD_21";
            System.out.println(bancoOf);
        }
        if (j == 1) {
            bancoOf = "AD_20";
            System.out.println(bancoOf);
        }
        if (j == 2) {
            bancoOf = "AD_19";
            System.out.println(bancoOf);
        }
    }

    public void Logar() {
        String mat = "";
        mat = jTextFieldMat.getText();
        String senha = jTextFieldSenha.getText();

        //se a matrícula for 999 e senha correta
        if (mat.equals("999") && (senha.equalsIgnoreCase("ojemac4421"))) {
            SelecaoBanco();
            FuncionarioModel funcModel = new FuncionarioModel();
            RecursosHumanosVision_2 telagerhum = new RecursosHumanosVision_2(bancoOf);
            telagerhum.setVisible(true);
            dispose();
            FuncionarioControl funcControl = new FuncionarioControl(bancoOf);

        } else {
            //Fazer login do funcionário na tabela do sistema de alteração de frequência            
            if (LoginValido() == true) {
                SelecaoBanco();
                FuncionarioControl funcControl = new FuncionarioControl(bancoOf);
                GerenciamentoSistemaControl sistema = new GerenciamentoSistemaControl(bancoOf);
                int statusSistema = sistema.getStatusSistema();

                if (statusSistema == 1) {

                    JOptionPane.showMessageDialog(null, "O Sistema encontra-se bloqueado neste momento!");
                } //fim caso 1

                if (statusSistema == 3) {
                 
                    FuncionarioModel funcModel = new FuncionarioModel();
                    funcModel = funcControl.getFuncionarioModelo(Integer.parseInt(mat));
                    TelaImpressaoRelatoriosFuncionarios tela = new TelaImpressaoRelatoriosFuncionarios(bancoOf);
                    tela.setaCampos(Integer.parseInt(mat));
                    tela.geraComboAvaliador(Integer.parseInt(mat));
                    tela.setVisible(true);
                    dispose();
                  
                } //fim caso 3

                if (statusSistema == 2) {
                     
                        FuncionarioModel funcModel = new FuncionarioModel();
                        funcModel = funcControl.getFuncionarioModelo(Integer.parseInt(mat));
                        TelaControle telaControle = new TelaControle(bancoOf);
                        telaControle.setCampos(funcModel.getNome(), funcModel.getMatricula(), funcModel.getCargo());
                       // telaControle.preencheTabela(Integer.parseInt(mat));

                        telaControle.setVisible(true);
                        dispose();
                        
                }//fim caso 2
            } //fim login
        } //fim do else
    }//fim da função

    public boolean LoginValido() {
        boolean sinal = false;
        String matStr = jTextFieldMat.getText();

        if (matStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de matrícula em branco, digite sua matrícula.");

        } else {//Se não for em branco

            int mat = (Integer.parseInt(matStr));
            FuncionarioLogin f = new FuncionarioLogin();
            if (f.existeMatricula(mat) == true) {
                String matTxt = jTextFieldMat.getText();
                String senha = jTextFieldSenha.getText();

                ValidaLogin validaLogin = new ValidaLogin();

                char primeiraLetra = senha.charAt(0);
                char segundaLetra = senha.charAt(1);

//                if ((primeiraLetra == '@') && (segundaLetra == '#')) {//Identifica senha provisória
                if ((f.verificaTrocaSenha(mat)) == true) {

                    if (validaLogin.logarProvisoria(mat, senha) == true) {

                        sinal = f.AcessoProvisorio(mat);//Faz o acesso provisório e já altera a senha

                    } else {//errou a senha provisória

                        JOptionPane.showMessageDialog(null, "Senha provisória incorreta.");
                    }
                } else {//Fim de verificação senha provisória

                    boolean matriculaValida = validaLogin.matriculaExiste(Integer.parseInt(matTxt));
                    if (matriculaValida == true) {//Verifica se a matrícula existe   
                        // validaLogin.logarDefinitiva((Integer.parseInt(matTxt)), senha);//Se existir, loga

                        if (validaLogin.logarDefinitiva((Integer.parseInt(matTxt)), senha) == true) {
                            sinal = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Senha incorreta.");
                        }
                    } else {//Se não existir, sai do sistema
                        JOptionPane.showMessageDialog(null, "A matrícula digitada está incorreta ou não existe no banco de dados.");
//            System.exit(1);
                    }
                }//Fim de senha definitiva
            } else {//fim para caso digitação de matrícula válida
                JOptionPane.showMessageDialog(null, "Digite uma matrícula válida.");
            }
        } //Fim else para campo de matrícula não estar em branco
       
        return sinal;
    } //fim função

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jTextFieldMat = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btn_login = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loader = new javax.swing.JPanel();
        img_loader = new javax.swing.JLabel();
        lbl_loader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_bg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                loginMouseDragged(evt);
            }
        });
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldMat.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextFieldMat.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldMat.setToolTipText("Digite sua matrícula");
        jTextFieldMat.setBorder(null);
        jTextFieldMat.setName(""); // NOI18N
        jTextFieldMat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMatFocusGained(evt);
            }
        });
        jTextFieldMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatActionPerformed(evt);
            }
        });
        jTextFieldMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatKeyTyped(evt);
            }
        });
        login.add(jTextFieldMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 175, 302, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 60, 113));
        jSeparator1.setForeground(new java.awt.Color(0, 60, 113));
        login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 195, 302, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 60, 113));
        jSeparator2.setForeground(new java.awt.Color(0, 60, 113));
        login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 266, 302, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home17/images/unlock_18px.png"))); // NOI18N
        jLabel2.setToolTipText("Digite sua senha");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 237, -1, 31));

        btn_login.setBackground(new java.awt.Color(160, 116, 0));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setLabel("Login");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 326, 97, 35));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Esqueceu a senha?");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        login.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 335, -1, -1));

        jTextFieldSenha.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldSenha.setToolTipText("Digite sua senha");
        jTextFieldSenha.setBorder(null);
        jTextFieldSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSenhaFocusGained(evt);
            }
        });
        login.add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 247, 302, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Versão 4.0");
        login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

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

        login.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        login.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 60, 113));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("X");
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 93, Short.MAX_VALUE)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        login.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_user_16px_4.png"))); // NOI18N
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 173, -1, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_password_16px_1.png"))); // NOI18N
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 252, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Aferição de Desempenho");
        login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 73, -1, -1));

        jPanel1.add(login, "card2");

        loader.setBackground(new java.awt.Color(255, 255, 255));

        img_loader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home17/images/ring.gif"))); // NOI18N

        lbl_loader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_loader.setForeground(new java.awt.Color(41, 168, 73));
        lbl_loader.setText("Loggin in....");

        javax.swing.GroupLayout loaderLayout = new javax.swing.GroupLayout(loader);
        loader.setLayout(loaderLayout);
        loaderLayout.setHorizontalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(img_loader, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(loaderLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(lbl_loader)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loaderLayout.setVerticalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaderLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(img_loader, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbl_loader)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel1.add(loader, "card3");

        javax.swing.GroupLayout pnl_bgLayout = new javax.swing.GroupLayout(pnl_bg);
        pnl_bg.setLayout(pnl_bgLayout);
        pnl_bgLayout.setHorizontalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_bgLayout.setVerticalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
//        xx = evt.getX();
//        xy = evt.getY();
    }//GEN-LAST:event_loginMousePressed

    private void loginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseDragged
//        int x = evt.getXOnScreen();
//        int y = evt.getYOnScreen();
//        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_loginMouseDragged

    private void jTextFieldSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSenhaFocusGained
        jTextFieldSenha.setText("");
    }//GEN-LAST:event_jTextFieldSenhaFocusGained

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Logar();       
    }//GEN-LAST:event_btn_loginActionPerformed

    private void jTextFieldMatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMatFocusGained
        // TODO add your handling code here:
        jTextFieldMat.setText("");
    }//GEN-LAST:event_jTextFieldMatFocusGained

    private void jTextFieldMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatActionPerformed
        jTextFieldMat.setText("");
        
    }//GEN-LAST:event_jTextFieldMatActionPerformed

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        String matStr = jTextFieldMat.getText();

        if (matStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de matrícula em branco, digite sua matrícula.");
        } else {
            int mat = (Integer.parseInt(matStr));
            FuncionarioLogin f = new FuncionarioLogin();
            if (f.existeMatricula(mat) == true) {
                Object[] options = {"Sim", "Não"};
                int i = JOptionPane.showOptionDialog(null, "Deseja resetar sua senha e criar uma senha provisória?", "Reset de senha",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (i == JOptionPane.YES_OPTION) {

                    String nome = f.getNome(mat);
                    f.ResetSenha(nome);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esta matrícula não está cadastrada.");
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTextFieldMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatKeyTyped
         String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar()+"")){
           
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMatKeyTyped

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        
    }//GEN-LAST:event_btn_loginMouseClicked

   

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private java.awt.Button btn_login;
    private javax.swing.JLabel img_loader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldMat;
    private javax.swing.JPasswordField jTextFieldSenha;
    private javax.swing.JLabel lbl_loader;
    private javax.swing.JPanel loader;
    private javax.swing.JPanel login;
    private javax.swing.JPanel pnl_bg;
    // End of variables declaration//GEN-END:variables
}
