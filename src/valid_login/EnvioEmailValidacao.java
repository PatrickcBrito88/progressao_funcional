package valid_login;


import utils.ConectaBanco;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EnvioEmailValidacao {

    ConectaBancoValidacao conecta = new ConectaBancoValidacao();

       public void ResetaSenha(String nome, String novaSenha) {
        StringBuilder mensagem = new StringBuilder();
        FuncionarioLogin f = new FuncionarioLogin();
        int mat = f.getMat(nome);
        String emailDestinatario = f.getEmail(mat);
        if ((emailDestinatario == null) || (emailDestinatario.equals(""))) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar senha provisória, pois não há e-mail cadastrado"
                    + " para esta matrícula.");
        } else {
            mensagem.append("Prezado(a) " + nome + ",\n\n"
                    + "Sua senha foi resetada.\n"
                    + "Sua senha provisória é " + novaSenha + ".\n"
                    + "Esta senha servirá apenas para o seu próximo acesso, ocasião em que será necessário cadastrar uma nova senha definitiva.\n\n"
                    );

            SendMailTLSPendenciaBuilderValidacao mail = new SendMailTLSPendenciaBuilderValidacao();

            mail.MandaEmail(emailDestinatario, "Criação de senha provisória", mensagem);
            JOptionPane.showMessageDialog(null, "Senha provisória encaminhada por e-mail para " + nome + "!");
        }
    }

}
