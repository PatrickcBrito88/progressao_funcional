package valid_login;

import utils.ConectaBanco;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class FuncionarioLogin {

ConectaBancoValidacao conecta = new ConectaBancoValidacao();

   public String getEmail(int mat) {
        conecta.conexao();
        String email = "";
        conecta.executaPesquisaSQL("Select * from funcionario where matfunc_f=" + mat);
        try {
            conecta.rs.first();
            email = conecta.rs.getString("email_f");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionarioControl/getEmail.\n" + ex);
        } finally {
            conecta.desconecta();
        }
        return email;
    }

   public void ResetSenha(String nome) {
        conecta.conexao();
        ResetaSenhaControl resetSenha = new ResetaSenhaControl();
        String novaSenha = resetSenha.geraSenha();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conecta.conn.prepareStatement("Update funcionario set senha_f=? where nome_f=?");
            pst.setString(1, novaSenha);
            pst.setString(2, nome);
            pst.executeUpdate();
            TrocaSenha(getMat(nome), true);//ALtera o troca senha para true
            EnvioEmailValidacao email = new EnvioEmailValidacao();
            email.ResetaSenha(nome, novaSenha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionárioControl/ResetSenha.\n" + ex);
        } finally {
            conecta.desconecta();
        }

    }

    public boolean AlteraSenha(int mat, String senha) {
        conecta.conexao();
        boolean sinal = false;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conecta.conn.prepareStatement("Update funcionario set senha_f=?, "
                    + "trocasenha_f=false where matfunc_f=?");
            pst.setString(1, senha);
            pst.setInt(2, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Senha definitiva alterada com sucesso!");
            sinal = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionárioControl/AlteraSenha.\n" + ex);
        } finally {
            conecta.desconecta();
        }
        return sinal;
    }

    public boolean AcessoProvisorio(int mat) {
        conecta.conexao();
        boolean coincide = false;
        boolean continua = false;
        boolean continua2 = false;
        //String senha = "";
        char[] password1 = null;
        char[] password2 = null;
        String senha1 = "";
        String senha2 = "";

        java.sql.PreparedStatement pst = null;

        do {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Por favor digite uma senha definitiva:");

            JPasswordField pass = new JPasswordField(10);
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"Confirma", "Cancela"};
            int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de nova senha",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            if (option == 0) // Botão Confirma
            {
                password1 = pass.getPassword();

            }
            if (option == 1) // Botão Cancela
            {
                System.exit(1);

            }

            JPanel panel2 = new JPanel();
            JLabel label2 = new JLabel("Por favor repita a senha");
            JPasswordField pass2 = new JPasswordField(10);
            panel2.add(label2);
            panel2.add(pass2);
            String[] options2 = new String[]{"Confirma", "Cancela"};
            int option2 = JOptionPane.showOptionDialog(null, panel2, "Cadastro de nova senha",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            if (option2 == 0) // Botão Confirma
            {
                password2 = pass2.getPassword();

            }
            senha1 = new String(password1);
            senha2 = new String(password2);

            if (senha1.equals(senha2)) {
                continua2 = true;
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
            }
        } while (continua2 == false); //se continua2 for true, significa que alterou a senha

        FuncionarioLogin f = new FuncionarioLogin();
        coincide = f.AlteraSenha(mat, String.valueOf(password1));

        return coincide;
    }

    public boolean existeMatricula(int mat) {
        boolean existe = false;
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario where matfunc_f=" + mat);
        try {
            if (conecta.rs.first()) {
                existe = true;
            }
        } catch (SQLException ex) {
//           JOptionPane.showMessageDialog(null,"FuncionarioControl/ExisteMatricula.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        return existe;
    }

    public void TrocaSenha (int mat, boolean sinal){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=(PreparedStatement) conecta.conn.prepareStatement("Update funcionario set trocasenha_f=? where matfunc_f=?");
            pst.setBoolean(1, sinal);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"FuncionarioControl/TrocaSenha.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        
    }
    
    public boolean verificaTrocaSenha(int mat){
        boolean sinal=false;
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario where matfunc_f="+mat);
        try {
            conecta.rs.first();
            sinal=conecta.rs.getBoolean("trocasenha_f");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"FuncionarioControl/VerificaTrocaSenha.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        return sinal;
    }

     public int getMat(String nome) {
        conecta.conexao();
        int id = 0;
        conecta.executaPesquisaSQL("Select * from funcionario where nome_F='" + nome + "'");
        try {
            conecta.rs.first();
            id = conecta.rs.getInt("matfunc_f");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionárioControl/getMat.\n" + ex);
        } finally {
            conecta.desconecta();
        }
        return id;
    }
     
     public String getNome(int mat) {
        conecta.conexao();
        String nome = "";
        conecta.executaPesquisaSQL("Select * from funcionario where matfunc_f=" + mat);
        try {
            conecta.rs.first();
            nome = conecta.rs.getString("nome_f");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionarioControl/getNome.\n" + ex);
        } finally {
            conecta.desconecta();
        }
        return nome;
    }
     
}
