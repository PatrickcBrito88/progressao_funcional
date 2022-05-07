
package control;

import models.FuncionarioModel;
import utils.ConectaBanco;
import javax.swing.JOptionPane;


public class RemanejamentoCorreto {
    private static String bancoOf;
    ConectaBanco conecta;
        
    public RemanejamentoCorreto(String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
    }
    
    public FuncionarioModel destinoGerencia(int idGerencia, int matricula){
        
        int idDepartamento=0;
        int idDiretoria=0;
        boolean sinal=false;
              
        FuncionarioModel funcionario = new FuncionarioModel();
        
        GerenciaControl gerencia = new GerenciaControl(bancoOf);
        
        funcionario.setMatricula(matricula);
        funcionario.setIdGerencia(idGerencia);
        
        sinal=gerencia.verificaGerenciaDiretoria(idGerencia);
        
        if (sinal==true){//se a gerencia possui valor de diretoria, ele atribui no objeto
            funcionario.setIdDiretoria(gerencia.getidDiretoria(idGerencia));
        }
        
       String siglaGerencia=gerencia.getSigla(idGerencia);
        
        if (siglaGerencia.equals("GERCOM")){//verifica se a gerencia possui valor de dpto, ele atribui no objeto
            funcionario.setIdDiretoria(gerencia.getidDiretoria(idGerencia));
        }
        return funcionario;      
    }
    
    
    public FuncionarioModel destinoDepartamento(int idDepartamento, int matricula){
        
      
        int idDiretoria=0;
        boolean sinal=false;
              
        FuncionarioModel funcionario = new FuncionarioModel();
        DepartamentoControl dpto = new DepartamentoControl(bancoOf);
        
        funcionario.setMatricula(matricula);
        funcionario.setIdDepartamento(idDepartamento);
        
        String siglaDepartamento = dpto.getSiglaDpto(idDepartamento);
        
        if (!(siglaDepartamento.equals("DEPCI"))){//se a gerencia possui valor de diretoria, ele atribui no objeto
            funcionario.setIdDiretoria(dpto.getIdDiretoria(idDepartamento));
          
        }
        
        
        return funcionario;      
    }
    
    public FuncionarioModel destinoDiretoria(int idDiretoria, int matricula){
                      
        FuncionarioModel funcionario = new FuncionarioModel();
       
        
        funcionario.setMatricula(matricula);
        funcionario.setIdDiretoria(idDiretoria);
       
           
        return funcionario;      
    }
    
    
}
