
package control;

import models.FuncionarioModel;
import utils.ConectaBanco;
import utils.SendMailTLS;
import valid_login.ConectaBancoValidacao;
import valid_login.EnvioEmailValidacao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FuncionarioControl {
    private static String bancoOf;
    ConectaBanco conecta;
    
    public FuncionarioControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }    
    
    public boolean validaLogin(String matricula, String senhalogin){
        conecta.conexao();
        String senha="";
        
        conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+matricula);
        
        try {
            conecta.rs.first();
            senha=conecta.rs.getString("senha_func");
        } catch (SQLException ex) {
            System.out.println("Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
       
        if (senhalogin.equals(senha)){//retorna true porque buscou o usuario e a senha bateu
//           JOptionPane.showMessageDialog(null,"Suecesso");
            return true;
            
        }else{            
           JOptionPane.showMessageDialog(null,"Senha incorreta");
            return false;
      
        }
    }
    
    
    public FuncionarioModel getFuncionarioModelo(int mat){
    FuncionarioModel funcModel = new FuncionarioModel();
    conecta.conexao();
    
    conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
        try {
            conecta.rs.first();
            funcModel.setCargo(conecta.rs.getString("cargo_func"));
            funcModel.setMatricula(conecta.rs.getInt("matricula_func"));
            funcModel.setNome(conecta.rs.getString("nome_func"));
            funcModel.setIdDepartamento(conecta.rs.getInt("departamento_iddepartamento_func"));
            funcModel.setIdGerencia(conecta.rs.getInt("gerencia_idgerencias_func"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
        return funcModel; 
    }
    
    public void gravaFuncionarioDepartamento(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        int idDiretoria=funcModelo.getIdDiretoria();
        
        if (idDiretoria!=0){
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, departamento_iddepartamento_func,"
                    + " senha_func, diretoria_iddiretoria_func) VALUES (?,?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDepartamento());
            
            pst.setString(5, "");
            pst.setInt(6, funcModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
        
        } else {
         try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, departamento_iddepartamento_func,"
                    + " senha_func) VALUES (?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDepartamento());
            
            pst.setString(5, "");
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }   
        }
    }
    
    public void gravaFuncionarioGerencia(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, gerencia_idgerencias_func,"
                    + " senha_func) VALUES (?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdGerencia());
            pst.setString(5, "");
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
    }
    
    public void gravaFuncionarioDiretoria(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, diretoria_iddiretoria_func,"
                    + " senha_func) VALUES (?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDiretoria());
            pst.setString(5, "");
           
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
    }
    
    public void gravaFuncionarioDepartamentoCD(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        int idDiretoria=funcModelo.getIdDiretoria();
        
        if (idDiretoria!=0){
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, departamento_iddepartamento_func,"
                    + " senha_func, diretoria_iddiretoria_func) VALUES (?,?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDepartamento());
            
            pst.setString(5, "");
            pst.setInt(6, funcModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir 1, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
      } else {
         try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, departamento_iddepartamento_func,"
                    + " senha_func) VALUES (?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDepartamento());
            
            pst.setString(5, "");
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }            
            
    }
        
        
    }
    
    public void gravaFuncionarioGerenciaCD(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, gerencia_idgerencias_func,"
                    + " senha_func, diretoria_iddiretoria_func) VALUES (?,?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdGerencia());
            pst.setString(5, "");
            pst.setInt(6, funcModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
    }
    
    public void gravaFuncionarioDiretoriaCD(FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into funcionario (nome_func, "
                    + "cargo_func, matricula_func, diretoria_iddiretoria_func,"
                    + " senha_func, diretoria_iddiretoria_func) VALUES (?,?,?,?,?,?)");
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.setInt(4, funcModelo.getIdDiretoria());
            pst.setString(5, "");
            pst.setInt(6, funcModelo.getIdDiretoria());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
    } finally {
            conecta.desconecta();
        }
    }
    
    public void editaFuncionario (FuncionarioModel funcModelo){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set nome_func=?, cargo_func=?"
                    + " where matricula_func=?");
            
            pst.setString(1, funcModelo.getNome());
            pst.setString(2, funcModelo.getCargo());
            pst.setInt(3, funcModelo.getMatricula());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
        
        public void deletaFuncionario (int mat){
            conecta.conexao();
            PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Delete from funcionario where matricula_func=?");
            pst.setInt(1, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
        
        public void remanejaFuncionarioDpto (int mat, int destino){
            conecta.conexao();
            PreparedStatement pst;
            DepartamentoControl dpto = new DepartamentoControl(bancoOf);
            
            int idDiretoria = dpto.getIdDiretoria(destino);
            JOptionPane.showMessageDialog(null,idDiretoria);
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set "
                    + "gerencia_idgerencias_func=null, departamento_iddepartamento_func=?,"
                    + " diretoria_iddiretoria_func=? where matricula_func=?");
            pst.setInt(1, destino);
            pst.setInt(2, idDiretoria);
            pst.setInt(3, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Funcionário Remanejado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao remanejar funcionário, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
        }
        
        public void remanejaFuncionario (FuncionarioModel funcionario){
            conecta.conexao();
            PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set "
                    +" departamento_iddepartamento_func=null, gerencia_idgerencias_func=null,"
                    + " diretoria_iddiretoria_func=null where matricula_func=?");
            pst.setInt(1, funcionario.getMatricula());
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao remanejar funcionário, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
        
        int idDiretoria=funcionario.getIdDiretoria();
        int idDepartamento=funcionario.getIdDepartamento();
        int idGerencia=funcionario.getIdGerencia();
        int matricula=funcionario.getMatricula();
        
        
        if (idDiretoria!=0){
            conecta.conexao();
                try {
                    pst=conecta.conn.prepareStatement("Update funcionario set diretoria_iddiretoria_func=?"
                            + " where matricula_func=?");
                   
                    pst.setInt(1, idDiretoria);
                    pst.setInt(2, matricula);
                    pst.executeUpdate();
                     
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao editar diretoria. \n"+ex);
                } finally {
                    conecta.desconecta();
                }
        }
        if (idDepartamento!=0){
            conecta.conexao();
                try {
                    pst=conecta.conn.prepareStatement("Update funcionario set departamento_iddepartamento_func=?"
                            + " where matricula_func=?");
                    pst.setInt(1, idDepartamento);
                    pst.setInt(2, matricula);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao editar dpto. \n"+ex);
                } finally {
                    conecta.desconecta();
                }
        }
                if (idGerencia!=0){
            conecta.conexao();
                try {
                    pst=conecta.conn.prepareStatement("Update funcionario set gerencia_idgerencias_func=?"
                            + " where matricula_func=?");
                    pst.setInt(1, idGerencia);
                    pst.setInt(2, matricula);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao editar gerencia. \n"+ex);
                } finally {
                    conecta.desconecta();
                }
        
            }
        
        
        }
        
    
        public int getMatFunc (String nome){
            conecta.conexao();
            int mat=0;
            conecta.executaPesquisaSQL("Select * from funcionario where nome_func='"+nome+"'");
        try {
            conecta.rs.first();
            mat=conecta.rs.getInt("matricula_func");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return mat;
        }
    
    
        public String getCargo (int mat){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
            String cargo="";
        try {
            conecta.rs.first();
            cargo=conecta.rs.getString("cargo_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        return cargo;
        }
    
        public String getFuncao(int mat){
            conecta.conexao();
            String funcao="";
            conecta.executaPesquisaSQL("Select * from funcionario where mat_func="+mat);
        try {
            conecta.rs.first();
            funcao=conecta.rs.getString("cargo_func");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar função."+ex);
        } finally {
          conecta.desconecta();
        }
        return funcao;
            
        }
        
        public int getIdDpto (int ado){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+ado);
            int idDpto=0;
            try {
            conecta.rs.first();
            idDpto=conecta.rs.getInt("Departamento_iddepartamento_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro getIdDpto, motivo:  \n"+ex);
        } finally {
                conecta.desconecta();
            }
          return idDpto;  
                    
        }
        
        public int getIdGerecia (int ado){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+ado);
            int idGerencia=0;
            try {
            conecta.rs.first();
            idGerencia=conecta.rs.getInt("gerencia_idgerencias_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro getIdDpto, motivo:  \n"+ex);
        } finally {
                conecta.desconecta();
            }
          return idGerencia;  
                    
        }
        
        public int getIdDiretoria(int ado){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+ado);
            int idDiretoria=0;
        try {
            conecta.rs.first();
            idDiretoria=conecta.rs.getInt("diretoria_iddiretoria_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro getIdDiretoria, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
           return idDiretoria; 
        }
        
        public void removeIndesejados(){
           conecta.conexao();
           PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Delete from avaliacao where mat_avaliado=786259 "
                    + "or mat_avaliado=888");
            
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from maturidadeprofissional where mat_avaliado=78659 "
                    + "or mat_avaliado=888");
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from media where mat_avaliado=78659 "
                    + "or mat_avaliado=888");
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from nota_corrigida where mat_avaliado=78659 "
                    + "or mat_avaliado=888");
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from nota_corrigida_total "
                    + "where funcionario_matricula_func_nc=78659 "
                    + "or funcionario_matricula_func_nc=888");
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from nota_percentual_total"
                    + " where funcionario_matricula_func_pt=78659 "
                    + "or funcionario_matricula_func_pt=888");
            pst.executeUpdate();
            
            pst=conecta.conn.prepareStatement("Delete from percentual where mat_avaliado=78659 "
                    + "or mat_avaliado=888");
            pst.executeUpdate();
                  
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, ao processar delete 78659 e 888. \n"+ex); 
        } finally {
            conecta.desconecta();
        }
           
        }
        
        public boolean ehInteiro(String senha){
            char [] c = senha.toCharArray();
            boolean d=true;
            
            for (int i=0; i < senha.length(); i++) {
                if (!Character.isDigit ( c [ i ] ) ){
                    d=false;
                    break;
                }
            }
            return d;
        }
        
        
        
        
        public boolean PrimeiroAcesso(int mat){
            conecta.conexao();
            boolean alterou=false;
            boolean continua=false;
            boolean continua2=false;
            String senha="";
            PreparedStatement pst=null;
           
            do{
           
            do{
                  senha = JOptionPane.showInputDialog(null,"É o seu primeiro acesso, você precisa definir uma senha.\n"
                    + "Por favor digite uma senha NUMÉRICA:");
                
                if (ehInteiro(senha)==false || (senha.equals(""))){
                    JOptionPane.showMessageDialog(null,"Por favor digite uma senha numérica");
                    continua=false;
                }else{
                    continua=true;
                }
                
            }while (continua==false); 
            
            String senha2 = JOptionPane.showInputDialog(null,"Por favor digite novamente:");
            
            if (senha.equals(senha2)){
                continua2=true;
            } else {
                JOptionPane.showMessageDialog(null,"As senhas não coincidem");
            }
            }while (continua2==false); //se continua2 for true, significa que alterou a senha
            
            if (continua2==true){
                                          
                //pegar email
                                
                boolean continua3=false;
            do {
            String email1 = JOptionPane.showInputDialog(null,"Digite seu email:");
            String email2 = JOptionPane.showInputDialog(null,"Digite novamente seu email:");
            
            if (email1.equals(email2)){
                continua3=true;
                InsereSenha(mat, senha);
                InsereEmail(email2, mat); 
                alterou=true;
                                
            } else {
                JOptionPane.showMessageDialog(null,"Os emails não coincidem, por favor digite novamente");
                continua3=false;
            }
            
            }while(continua3==false);
          
                
            }
            
            return alterou; 
        }
       
        
        public String getSenha (int mat){
            conecta.conexao();
            String senha="Sem senha";
            
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
        try {
            conecta.rs.first();
            senha=conecta.rs.getString("senha_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar senha.\n");
        } finally {
            conecta.desconecta();
        }
        
        return senha;
        }
        
        public String getNome(int mat){
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
            String nome="";
        try {
            conecta.rs.first();
            nome=conecta.rs.getString("nome_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no getNome.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        return nome;
                    
        }
        
        public void InsereEmail (String email, int mat){
            PreparedStatement pst;
            conecta.conexao();
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set email=? where "
                    + "matricula_func=?");
            pst.setString(1, email);
            pst.setInt(2, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Email cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
          
        }
        
        public void InsereSenha (int mat, String senha){
            PreparedStatement pst;
            conecta.conexao();
        try {
            pst = conecta.conn.prepareStatement("Update funcionario"
                    + " set senha_func=? where matricula_func=?");
            pst.setString(1,senha);
            pst.setInt(2, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Senhas alteradas com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao alterar senha, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
                     
        }
        
        public void CriaSenhaRandom (int mat){
            Random gerador = new Random();
            String senhaRandom="";
            
            for (int i=0; i<4; i++){
                int n=gerador.nextInt(9);
                String n1=String.valueOf(n);
                senhaRandom+=n1;
            }
            
            //gravar a senha random
            PreparedStatement pst;
            conecta.conexao();
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set senha_func=? where matricula_func=?");
            pst.setString(1, senhaRandom);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        String emailcadastrado="";
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
        try {
            conecta.rs.first();
            emailcadastrado=conecta.rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        
        SendMailTLS email = new SendMailTLS();
        String mensagem = "Sua nova senha temporária é: "+senhaRandom+".";
        String assunto = "Nova senha temporária";
        email.MandaEmail(emailcadastrado,assunto, mensagem);
        JOptionPane.showMessageDialog(null,"Senha temporária enviada para o email cadastrado!");    
        }
        
        public void AlteraSenha (int mat, String senha){
            PreparedStatement pst;
            conecta.conexao();
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set senha_func=? where matricula_func=?");
            pst.setString(1, senha);
            pst.setInt(2, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar senha. "+ex);
        } finally{
            conecta.desconecta();
        }
        
        }
        
        public boolean PossuiEmail(int mat){
            boolean existe=false;
            String email="";
            conecta.conexao();
            conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
        try {
            conecta.rs.first();
            email=conecta.rs.getString("email");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, Mét. Possui email: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        if (email.equals("")){
            existe=false;
        } else {
            existe=true;
        }
                    return existe;
        }
        
       public void TransfereTodosSemSetor(){
           conecta.conexao();
           PreparedStatement pst;
           conecta.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta.rs.first();
            
           do {
            int mat=conecta.rs.getInt("matricula_func");
            
            if ((mat!=888) && (mat!=78659)){
            pst=conecta.conn.prepareStatement("Update funcionario set gerencia_idgerencias_func=null,"
                    + " departamento_iddepartamento_func=null, diretoria_iddiretoria_func=null "
                    + "where matricula_func=?");
            pst.setInt(1, mat);
            pst.executeUpdate();
                        
                    }   
           }while(conecta.rs.next());
           JOptionPane.showMessageDialog(null,"Concluído com sucesso");
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro linha: 767 \n"+ex);
        } finally {
            conecta.desconecta();
        }
           
       }
       
       public void RemanejaSemSetor(int mat){
           conecta.conexao();
           PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set gerencia_idgerencias_func=null,"
                    + " departamento_iddepartamento_func=null, diretoria_iddiretoria_func=null "
                    + "where matricula_func=?");
            pst.setInt(1, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro FuncControl linha 786");
        } finally {
            conecta.desconecta();
        }
       }
       
       public void ResetaSenha (String nome){
          conecta.conexao();
          PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set senha_func='' "
                    + "where nome_func=?");
            pst.setString(1, nome);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Senha resetada com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao resetar senha");
        } finally {
            conecta.desconecta();
        }
       }
       
       public boolean verificaSePossuiSenha (int mat){
           conecta.conexao();
           conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
           String senha="";
           boolean sinal = false;
        try {
            conecta.rs.first();
            senha=conecta.rs.getString("senha_func");
        } catch (SQLException ex) {
            
        } finally {
            conecta.desconecta();
        }
        
        if (senha.equals("")){
            sinal=false;
        } else {
            sinal = true;
        }
        return sinal;
           
       }
       
       public void InsereEmail2(int mat, String email){
           conecta.conexao();
           String nome="";
           conecta.executaPesquisaSQL("Select * from funcionario where matricula_func="+mat);
        try {
            conecta.rs.first();
            nome=conecta.rs.getString("nome_func");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar o nome do funcionário. \n"
                    + "Alteração de e-mail.\n"+ex);
        } finally {
            conecta.desconecta();
        }
          
        conecta.conexao();
           PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update funcionario set email=? where"
                    + " matricula_func=?");
            pst.setString(1, email);
            pst.setInt(2, mat);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"E-mail de "+nome+" alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir e-mail.\n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        
       }
       
       public void TrocaSenha (int mat, boolean sinal){
           ConectaBancoValidacao conectaValidacao = new ConectaBancoValidacao();
           conectaValidacao.conexao();
        PreparedStatement pst;
        try {
            pst=(PreparedStatement) conectaValidacao.conn.prepareStatement("Update funcionario set trocasenha_f=? where matfunc_f=?");
            pst.setBoolean(1, sinal);
            pst.setInt(2, mat);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"FuncionarioControl/TrocaSenha.\n"+ex);
        } finally {
            conectaValidacao.desconecta();
        }
        
    }
       
       public void ResetSenha(String nome) {
        ConectaBancoValidacao conectaValidacao = new ConectaBancoValidacao();
        conectaValidacao.conexao();
        ResetaSenhaControl resetSenha = new ResetaSenhaControl();
        String novaSenha = resetSenha.geraSenha();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conectaValidacao.conn.prepareStatement("Update funcionario set senha_f=? where nome_f=?");
            pst.setString(1, novaSenha);
            pst.setString(2, nome);
            pst.executeUpdate();
            TrocaSenha(getMatFunc(nome), true);//ALtera o troca senha para true
            EnvioEmailValidacao email = new EnvioEmailValidacao();
            email.ResetaSenha(nome, novaSenha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "FuncionárioControl/ResetSenha.\n" + ex);
        } finally {
            conectaValidacao.desconecta();
        }

    }
}
