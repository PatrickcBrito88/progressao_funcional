
package control;

import models.AvaliacaoInteiroModel;
import models.AvaliacaoModel;
import models.LogModel;
import utils.ConectaBanco;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AvaliacaoControl {
    
    private static String bancoOf;
    ConectaBanco conecta;
    ConectaBanco conecta2;
    
    public AvaliacaoControl (String banco){
        this.bancoOf=banco;
        conecta = new ConectaBanco(bancoOf);
        conecta2 = new ConectaBanco(bancoOf);
    }
    
    public void GeraTabelaAvaliacao (int avaliador, int avaliado){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into avaliacao (Mat_avaliador, Mat_avaliado) "
                    + "VALUES (?,?)");
            pst.setInt(1, avaliador);
            pst.setInt(2, avaliado);
            pst.execute();
//            JOptionPane.showMessageDialog(null,"Sucesso");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao inserior na tabela de avaliação,"
//                    + " motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
    }
    
    public void GeraTabelaMedia (int avaliado){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into media (Mat_avaliado) "
                    + "VALUES (?)");
            pst.setInt(1, avaliado);
            
            pst.execute();
//            JOptionPane.showMessageDialog(null,"Sucesso");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao inserior na tabela de avaliação,"
//                    + " motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
    }
       
    public AvaliacaoModel getAvaliacaoDados (int ado, int ador){
        AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from avaliacaov where mat_avaliador="+ador+" and "
                + "mat_avaliado="+ado);
//        JOptionPane.showMessageDialog(null,"ado"+ado+" ador"+ador);
        try {
            conecta.rs.first();
            avaliacaoModelo.setAdministracaoConflitos(conecta.rs.getDouble("Administracao_conflitos"));
            avaliacaoModelo.setAnaliseRiscos(conecta.rs.getDouble("Analise_Riscos"));
            avaliacaoModelo.setCompromentimento(conecta.rs.getDouble("Comprometimento"));
            avaliacaoModelo.setConhecimentoLegislacao(conecta.rs.getDouble("conhecimento_legislacao"));
            avaliacaoModelo.setConhecimentoNormas(conecta.rs.getDouble("conhecimentos_normas"));
            avaliacaoModelo.setConhecimentoTecnico(conecta.rs.getDouble("conhecimento_tecnico"));
            avaliacaoModelo.setCordialidadeRespeito(conecta.rs.getDouble("cordialidade_respeito"));
            avaliacaoModelo.setEficienciaComunicacao(conecta.rs.getDouble("eficiencia_comunicacao"));
            avaliacaoModelo.setEspiritoEquipe(conecta.rs.getDouble("Espirito_Equipe"));
            avaliacaoModelo.setFlexibilidade(conecta.rs.getDouble("Flexibilidade"));
            avaliacaoModelo.setGarantiaQualidade(conecta.rs.getDouble("garantia_qualidade"));
            avaliacaoModelo.setMelhoriaContinua(conecta.rs.getDouble("melhoria_continua"));
            avaliacaoModelo.setOrganizacao(conecta.rs.getDouble("Organizacao"));
            avaliacaoModelo.setProdutividade(conecta.rs.getDouble("Produtividade"));
            avaliacaoModelo.setResolucaoProblema(conecta.rs.getDouble("Resolucao_problemas"));
            avaliacaoModelo.setRespeitoIndividualidade(conecta.rs.getDouble("Respeito_individualidade"));
            avaliacaoModelo.setResultadoTrabalho(conecta.rs.getDouble("Resultado_trabalho"));
            avaliacaoModelo.setSatisfacaoUsuario(conecta.rs.getDouble("satisfacao_usuario"));
            avaliacaoModelo.setSensoUrgencia(conecta.rs.getDouble("senso_urgencia"));
            avaliacaoModelo.setUsoFerrantentasTI(conecta.rs.getDouble("uso_ferramentas"));
            avaliacaoModelo.setCoerencia(conecta.rs.getDouble("coerencia"));
            avaliacaoModelo.setGerenciaObjetivos(conecta.rs.getDouble("Gerencia_Objetivos"));
            avaliacaoModelo.setDesenvolvimentoPessoas(conecta.rs.getDouble("Desenvolvimento_Pessoas"));
            avaliacaoModelo.setLideranca(conecta.rs.getDouble("Lideranca"));
            avaliacaoModelo.setGerenciaParticipativa(conecta.rs.getDouble("gerencia_participativa"));
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
          
        return avaliacaoModelo;
    }
    
    public AvaliacaoInteiroModel getAvaliacaoDadosInteiros (int ado, int ador){
        AvaliacaoInteiroModel avaliacaoModelo = new AvaliacaoInteiroModel();
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from avaliacaov where mat_avaliador="+ador+" and "
                + "mat_avaliado="+ado);
//        JOptionPane.showMessageDialog(null,"ado"+ado+" ador"+ador);
        try {
            conecta.rs.first();
            avaliacaoModelo.setAdministracaoConflitos(conecta.rs.getInt("Administracao_conflitos"));
            avaliacaoModelo.setAnaliseRiscos(conecta.rs.getInt("Analise_Riscos"));
            avaliacaoModelo.setCompromentimento(conecta.rs.getInt("Comprometimento"));
            avaliacaoModelo.setConhecimentoLegislacao(conecta.rs.getInt("conhecimento_legislacao"));
            avaliacaoModelo.setConhecimentoNormas(conecta.rs.getInt("conhecimentos_normas"));
            avaliacaoModelo.setConhecimentoTecnico(conecta.rs.getInt("conhecimento_tecnico"));
            avaliacaoModelo.setCordialidadeRespeito(conecta.rs.getInt("cordialidade_respeito"));
            avaliacaoModelo.setEficienciaComunicacao(conecta.rs.getInt("eficiencia_comunicacao"));
            avaliacaoModelo.setEspiritoEquipe(conecta.rs.getInt("Espirito_Equipe"));
            avaliacaoModelo.setFlexibilidade(conecta.rs.getInt("Flexibilidade"));
            avaliacaoModelo.setGarantiaQualidade(conecta.rs.getInt("garantia_qualidade"));
            avaliacaoModelo.setMelhoriaContinua(conecta.rs.getInt("melhoria_continua"));
            avaliacaoModelo.setOrganizacao(conecta.rs.getInt("Organizacao"));
            avaliacaoModelo.setProdutividade(conecta.rs.getInt("Produtividade"));
            avaliacaoModelo.setResolucaoProblema(conecta.rs.getInt("Resolucao_problemas"));
            avaliacaoModelo.setRespeitoIndividualidade(conecta.rs.getInt("Respeito_individualidade"));
            avaliacaoModelo.setResultadoTrabalho(conecta.rs.getInt("Resultado_trabalho"));
            avaliacaoModelo.setSatisfacaoUsuario(conecta.rs.getInt("satisfacao_usuario"));
            avaliacaoModelo.setSensoUrgencia(conecta.rs.getInt("senso_urgencia"));
            avaliacaoModelo.setUsoFerrantentasTI(conecta.rs.getInt("uso_ferramentas"));
            avaliacaoModelo.setCoerencia(conecta.rs.getInt("coerencia"));
            avaliacaoModelo.setGerenciaObjetivos(conecta.rs.getInt("Gerencia_Objetivos"));
            avaliacaoModelo.setDesenvolvimentoPessoas(conecta.rs.getInt("Desenvolvimento_Pessoas"));
            avaliacaoModelo.setLideranca(conecta.rs.getInt("Lideranca"));
            avaliacaoModelo.setGerenciaParticipativa(conecta.rs.getInt("gerencia_participativa"));
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
          
        return avaliacaoModelo;
    }
 
    public void gravaEditaAvaliacao(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update avaliacao set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, coerencia=?, gerencia_objetivos=?,"
                    + " desenvolvimento_pessoas=?, lideranca=?, gerencia_participativa=?"
                    + " WHERE avaliacao.Mat_Avaliador = ? "
                    + "AND avaliacao.Mat_Avaliado = ?");
            pst.setDouble(1, avaliacaoModelo.getConhecimentoTecnico());
            pst.setDouble(2, avaliacaoModelo.getUsoFerrantentasTI());
            pst.setDouble(3, avaliacaoModelo.getConhecimentoNormas());
            pst.setDouble(4, avaliacaoModelo.getMelhoriaContinua());
            pst.setDouble(5, avaliacaoModelo.getProdutividade());
            pst.setDouble(6, avaliacaoModelo.getGarantiaQualidade());
            pst.setDouble(7, avaliacaoModelo.getOrganizacao());
            pst.setDouble(8, avaliacaoModelo.getAnaliseRiscos());
            pst.setDouble(9, avaliacaoModelo.getSatisfacaoUsuario());
            pst.setDouble(10, avaliacaoModelo.getSensoUrgencia());
            pst.setDouble(11, avaliacaoModelo.getResolucaoProblema());
            pst.setDouble(12, avaliacaoModelo.getResultadoTrabalho());
            pst.setDouble(13, avaliacaoModelo.getCompromentimento());
            pst.setDouble(14, avaliacaoModelo.getFlexibilidade());
            pst.setDouble(15, avaliacaoModelo.getEficienciaComunicacao());
            pst.setDouble(16, avaliacaoModelo.getCordialidadeRespeito());
            pst.setDouble(17, avaliacaoModelo.getEspiritoEquipe());
            pst.setDouble(18, avaliacaoModelo.getAdministracaoConflitos());
            pst.setDouble(19, avaliacaoModelo.getRespeitoIndividualidade());
            pst.setDouble(20, avaliacaoModelo.getConhecimentoLegislacao());
            pst.setDouble(21, avaliacaoModelo.getCoerencia());
            pst.setDouble(22, avaliacaoModelo.getGerenciaObjetivos());
            pst.setDouble(23, avaliacaoModelo.getDesenvolvimentoPessoas());
            pst.setDouble(24, avaliacaoModelo.getLideranca());
            pst.setDouble(25, avaliacaoModelo.getGerenciaParticipativa());
            pst.setInt(26, ador);
            pst.setInt(27, ado);
            pst.executeUpdate();
            
            LogModel log = new LogModel();
            log.setAvaliado(ado);
            log.setAvaliador(ador);
            try {
                log.setIp(InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException ex) {
                Logger.getLogger(AvaliacaoControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            LogControl logControle = new LogControl(bancoOf);
            logControle.GravaLog(log);
            
            if (ador!=888){
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
            }
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
    }
        
    public boolean verificaAvaliadoGrauMaior (int ador, int ado){
        conecta.conexao();
        boolean retorno=false;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
            
        try {
            conecta.rs.first();
            double admConf=(conecta.rs.getDouble("Administracao_conflitos"));
           double analiseRiscos=(conecta.rs.getDouble("Analise_Riscos"));
            double comprometimento=(conecta.rs.getDouble("Comprometimento"));
            double conhecimentoLegislacao=(conecta.rs.getDouble("conhecimento_legislacao"));
            double conhecimentoNormas=(conecta.rs.getDouble("conhecimentos_normas"));
           double conhecimentoTecnico=(conecta.rs.getDouble("conhecimento_tecnico"));
            double cordialidade=(conecta.rs.getDouble("cordialidade_respeito"));
            double eficienciaComunicao=(conecta.rs.getDouble("eficiencia_comunicacao"));
            double espiritoEquipe=(conecta.rs.getDouble("Espirito_Equipe"));
            double flexibilidade=(conecta.rs.getDouble("Flexibilidade"));
            double garantiaQualidade=(conecta.rs.getDouble("garantia_qualidade"));
            double melhoriaContinua=(conecta.rs.getDouble("melhoria_continua"));
            double organizacao=(conecta.rs.getDouble("Organizacao"));
            double produtividade=(conecta.rs.getDouble("Produtividade"));
            double resolucaoProblema=(conecta.rs.getDouble("Resolucao_problemas"));
            double respeitoIndividualidade=(conecta.rs.getDouble("Respeito_individualidade"));
            double resultadoTrabalho=(conecta.rs.getDouble("Resultado_trabalho"));
            double satisfacaoUsuario=(conecta.rs.getDouble("satisfacao_usuario"));
            double sensoUrgencia=(conecta.rs.getDouble("senso_urgencia"));
            double usoFerrantentasTI=(conecta.rs.getDouble("uso_ferramentas"));
            double coerencia=(conecta.rs.getDouble("coerencia"));
            double gerenciaObjetivos=(conecta.rs.getDouble("Gerencia_Objetivos"));
            double desenvolvimentoPessoas=(conecta.rs.getDouble("Desenvolvimento_Pessoas"));
            double lideranca=(conecta.rs.getDouble("Lideranca"));
            double gerenciaParticipativa=(conecta.rs.getDouble("gerencia_participativa"));
            
            
            
            
            
           if ( (admConf!=0) && (analiseRiscos!=0) && (comprometimento!=0) && (conhecimentoLegislacao!=0)
                   && (conhecimentoNormas!=0) && (conhecimentoTecnico!=0) && (cordialidade!=0) && 
                   (eficienciaComunicao!=0) && (espiritoEquipe!=0) && (flexibilidade!=0) && (garantiaQualidade!=0)
                   && (melhoriaContinua!=0) && (organizacao!=0) && (produtividade!=0) && (resolucaoProblema!=0) 
                   && (respeitoIndividualidade!=0) && (resultadoTrabalho!=0) && (satisfacaoUsuario!=0) && (sensoUrgencia!=0)
                   && (usoFerrantentasTI!=0) && (coerencia!=0) && (gerenciaObjetivos!=0) && (desenvolvimentoPessoas!=0)
                   && (lideranca!=0) && (gerenciaParticipativa!=0)){
               retorno=true;
              
           } else {
               
               retorno=false;
           }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na validação, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        return retorno;       
        
    }
    
    public boolean verificaAvaliadoGrauMenor (int ador, int ado){
        conecta.conexao();
        boolean retorno=false;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
            
        try {
            conecta.rs.first();
            int admConf=(conecta.rs.getInt("Administracao_conflitos"));
           int analiseRiscos=(conecta.rs.getInt("Analise_Riscos"));
            int comprometimento=(conecta.rs.getInt("Comprometimento"));
            int conhecimentoLegislacao=(conecta.rs.getInt("conhecimento_legislacao"));
            int conhecimentoNormas=(conecta.rs.getInt("conhecimentos_normas"));
           int conhecimentoTecnico=(conecta.rs.getInt("conhecimento_tecnico"));
            int cordialidade=(conecta.rs.getInt("cordialidade_respeito"));
            int eficienciaComunicao=(conecta.rs.getInt("eficiencia_comunicacao"));
            int espiritoEquipe=(conecta.rs.getInt("Espirito_Equipe"));
            int flexibilidade=(conecta.rs.getInt("Flexibilidade"));
            int garantiaQualidade=(conecta.rs.getInt("garantia_qualidade"));
            int melhoriaContinua=(conecta.rs.getInt("melhoria_continua"));
            int organizacao=(conecta.rs.getInt("Organizacao"));
            int produtividade=(conecta.rs.getInt("Produtividade"));
            int resolucaoProblema=(conecta.rs.getInt("Resolucao_problemas"));
            int respeitoIndividualidade=(conecta.rs.getInt("Respeito_individualidade"));
            int resultadoTrabalho=(conecta.rs.getInt("Resultado_trabalho"));
            int satisfacaoUsuario=(conecta.rs.getInt("satisfacao_usuario"));
            int sensoUrgencia=(conecta.rs.getInt("senso_urgencia"));
            int usoFerrantentasTI=(conecta.rs.getInt("uso_ferramentas"));
            
           
            
            
            
           if ( (admConf!=0) && (analiseRiscos!=0) && (comprometimento!=0) && (conhecimentoLegislacao!=0)
                   && (conhecimentoNormas!=0) && (conhecimentoTecnico!=0) && (cordialidade!=0) && 
                   (eficienciaComunicao!=0) && (espiritoEquipe!=0) && (flexibilidade!=0) && (garantiaQualidade!=0)
                   && (melhoriaContinua!=0) && (organizacao!=0) && (produtividade!=0) && (resolucaoProblema!=0) 
                   && (respeitoIndividualidade!=0) && (resultadoTrabalho!=0) && (satisfacaoUsuario!=0) && (sensoUrgencia!=0)
                   && (usoFerrantentasTI!=0)){
               retorno=true;
               
           } else {
               
               retorno=false;
           }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na validação, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        return retorno;       
        
    }
    
    public void alteraBoolAvaliacao(int ado, int ador){
      conecta.conexao();
      PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update avaliacao set avaliacaoconcluida=? where "
                    + "mat_avaliador=? and mat_avaliado=?");
            pst.setBoolean(1, true);
            pst.setInt(2, ador);
            pst.setInt(3, ado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo altera bool: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public double calculaNotaCorrigidaGerFunc(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
        try {
            conecta.rs.first();
            conhecTec=(conecta.rs.getInt("conhecimento_tecnico")*0.03);
            usoFerramenta=(conecta.rs.getInt("uso_ferramentas")*0.03);
            conhecLegisl=(conecta.rs.getInt("conhecimento_legislacao")*0.03);
            conhecNormas=(conecta.rs.getInt("conhecimentos_normas")*0.03);
            melhoriaContinua=(conecta.rs.getInt("melhoria_continua")*0.03);
            produtividade=(conecta.rs.getInt("produtividade")*0.03);
            garantiaQualidade=(conecta.rs.getInt("garantia_qualidade")*0.03);
            organizacao=(conecta.rs.getInt("organizacao")*0.03);
            analiseRiscos=(conecta.rs.getInt("analise_riscos")*0.03);
            satisfacaoUsuario=(conecta.rs.getInt("satisfacao_usuario")*0.03);
            sensoUrgencia=(conecta.rs.getInt("senso_urgencia")*0.03);
            resolucaoProblemas=(conecta.rs.getInt("resolucao_problemas")*0.03);
            resultadoTrabalho=(conecta.rs.getInt("resultado_trabalho")*0.03);
            comprometimento=(conecta.rs.getInt("comprometimento")*0.03);
            flexibilidade=(conecta.rs.getInt("flexibilidade")*0.03);
            eficienciaComunicao=(conecta.rs.getInt("eficiencia_comunicacao")*0.03);
            cordialidadeRespeito=(conecta.rs.getInt("cordialidade_respeito")*0.03);
            espiritoEquipe=(conecta.rs.getInt("espirito_equipe")*0.03);
            admConflito=(conecta.rs.getInt("administracao_conflitos")*0.03);
            respeitoIndividualidade=(conecta.rs.getInt("respeito_individualidade")*0.03);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=conhecTec+usoFerramenta+conhecLegisl+conhecNormas+melhoriaContinua+
                produtividade+ garantiaQualidade+ organizacao+ analiseRiscos+ satisfacaoUsuario+
                sensoUrgencia+ resolucaoProblemas+ resultadoTrabalho+ comprometimento+ flexibilidade+
                 eficienciaComunicao+ cordialidadeRespeito+ espiritoEquipe+ admConflito+ respeitoIndividualidade;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update nota_corrigida set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, total_corrigida=? WHERE nota_corrigida.Mat_Avaliador = ? "
                    + "AND nota_corrigida.Mat_Avaliado = ?");
            pst.setDouble(1, conhecTec);
            pst.setDouble(2, usoFerramenta);
            pst.setDouble(3, conhecNormas);
            pst.setDouble(4, melhoriaContinua);
            pst.setDouble(5, produtividade);
            pst.setDouble(6, garantiaQualidade);
            pst.setDouble(7, organizacao);
            pst.setDouble(8, analiseRiscos);
            pst.setDouble(9, satisfacaoUsuario);
            pst.setDouble(10, sensoUrgencia);
            pst.setDouble(11, resolucaoProblemas);
            pst.setDouble(12, resultadoTrabalho);
            pst.setDouble(13, comprometimento);
            pst.setDouble(14, flexibilidade);
            pst.setDouble(15, eficienciaComunicao);
            pst.setDouble(16, cordialidadeRespeito);
            pst.setDouble(17, espiritoEquipe);
            pst.setDouble(18, admConflito);
            pst.setDouble(19, respeitoIndividualidade);
            pst.setDouble(20, conhecLegisl);
            pst.setDouble(21, total);
            pst.setDouble(22, ador);
            pst.setDouble(23, ado);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
     
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaGestorTF(ado, total);
        
        return total;
        
    
    }
           
     public double calculaNotaCorrigidaFuncFunc(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
        try {
            conecta.rs.first();
            conhecTec=(conecta.rs.getInt("conhecimento_tecnico")*(0.02/4));
            usoFerramenta=(conecta.rs.getInt("uso_ferramentas")*(0.02/4));
            conhecLegisl=(conecta.rs.getInt("conhecimento_legislacao")*(0.02/4));
            conhecNormas=(conecta.rs.getInt("conhecimentos_normas")*(0.02/4));
            melhoriaContinua=(conecta.rs.getInt("melhoria_continua")*(0.02/4));
            produtividade=(conecta.rs.getInt("produtividade")*(0.02/4));
            garantiaQualidade=(conecta.rs.getInt("garantia_qualidade")*(0.02/4));
            organizacao=(conecta.rs.getInt("organizacao")*(0.02/4));
            analiseRiscos=(conecta.rs.getInt("analise_riscos")*(0.02/4));
            satisfacaoUsuario=(conecta.rs.getInt("satisfacao_usuario")*(0.02/4));
            sensoUrgencia=(conecta.rs.getInt("senso_urgencia")*(0.02/4));
            resolucaoProblemas=(conecta.rs.getInt("resolucao_problemas")*(0.02/4));
            resultadoTrabalho=(conecta.rs.getInt("resultado_trabalho")*(0.02/4));
            comprometimento=(conecta.rs.getInt("comprometimento")*(0.02/4));
            flexibilidade=(conecta.rs.getInt("flexibilidade")*(0.02/4));
            eficienciaComunicao=(conecta.rs.getInt("eficiencia_comunicacao")*(0.02/4));
            cordialidadeRespeito=(conecta.rs.getInt("cordialidade_respeito")*(0.02/4));
            espiritoEquipe=(conecta.rs.getInt("espirito_equipe")*(0.02/4));
            admConflito=(conecta.rs.getInt("administracao_conflitos")*(0.02/4));
            respeitoIndividualidade=(conecta.rs.getInt("respeito_individualidade")*(0.02/4));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=conhecTec+usoFerramenta+conhecLegisl+conhecNormas+melhoriaContinua+
                produtividade+ garantiaQualidade+ organizacao+ analiseRiscos+ satisfacaoUsuario+
                sensoUrgencia+ resolucaoProblemas+ resultadoTrabalho+ comprometimento+ flexibilidade+
                 eficienciaComunicao+ cordialidadeRespeito+ espiritoEquipe+ admConflito+ respeitoIndividualidade;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update nota_corrigida set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, total_corrigida=? WHERE nota_corrigida.Mat_Avaliador = ? "
                    + "AND nota_corrigida.Mat_Avaliado = ?");
            pst.setDouble(1, conhecTec);
            pst.setDouble(2, usoFerramenta);
            pst.setDouble(3, conhecNormas);
            pst.setDouble(4, melhoriaContinua);
            pst.setDouble(5, produtividade);
            pst.setDouble(6, garantiaQualidade);
            pst.setDouble(7, organizacao);
            pst.setDouble(8, analiseRiscos);
            pst.setDouble(9, satisfacaoUsuario);
            pst.setDouble(10, sensoUrgencia);
            pst.setDouble(11, resolucaoProblemas);
            pst.setDouble(12, resultadoTrabalho);
            pst.setDouble(13, comprometimento);
            pst.setDouble(14, flexibilidade);
            pst.setDouble(15, eficienciaComunicao);
            pst.setDouble(16, cordialidadeRespeito);
            pst.setDouble(17, espiritoEquipe);
            pst.setDouble(18, admConflito);
            pst.setDouble(19, respeitoIndividualidade);
            pst.setDouble(20, conhecLegisl);
            pst.setDouble(21, total);
            pst.setDouble(22, ador);
            pst.setDouble(23, ado);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
        
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaAutoTF(ado, total);
        
        
        return total;
    
    }
     
     public double calculaNotaCorrigidaMaturidadeFunc(AvaliacaoModel avaliacaoModelo, int ado){
        conecta.conexao();
        double pontualidade=0, tempo=0, atualizacao=0, confianca=0, cumprimento=0;
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado+"");
                
        try {
            conecta.rs.first();
            pontualidade=(conecta.rs.getInt("pontualidade_assiduidade")*0.1);
            tempo=(conecta.rs.getInt("tempo_experiencia")*0.05);
            atualizacao=(conecta.rs.getInt("atualizacao_profissional")*0.05);
            confianca=(conecta.rs.getInt("confianca")*0.05);
            cumprimento=(conecta.rs.getInt("cumprimento_normas")*0.05);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=pontualidade+tempo+atualizacao+confianca+cumprimento;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update maturidadeprofissional set nota_corrigida=?"
                    + " where mat_avaliado=?");
            pst.setDouble(1, total);
            pst.setInt(2, ado);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
          
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaMaturidadeTF(ado, total);
        return total;
    
    }
     
     public double calculaNotaCorrigidaMaturidadeGestor(AvaliacaoModel avaliacaoModelo, int ado){
        conecta.conexao();
        double pontualidade=0, tempo=0, atualizacao=0, confianca=0, cumprimento=0;
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado+"");
                
        try {
            conecta.rs.first();
            pontualidade=(conecta.rs.getInt("pontualidade_assiduidade")*0.0666666667);
            
            tempo=(conecta.rs.getInt("tempo_experiencia")*0.033333333);
           
            atualizacao=(conecta.rs.getInt("atualizacao_profissional")*0.033333333);
           
            confianca=(conecta.rs.getInt("confianca")*0.033333333);
            
            cumprimento=(conecta.rs.getInt("cumprimento_normas")*0.033333333);
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=pontualidade+tempo+atualizacao+confianca+cumprimento;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update maturidadeprofissional set nota_corrigida=?"
                    + " where mat_avaliado=?");
            pst.setDouble(1, total);
            pst.setInt(2, ado);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
           
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaMaturidadeTF(ado, total);
        return total;
    
    }
     
     public double calculaNotaCorrigidaMaturidadeDEPLAN_ASPRE(AvaliacaoModel avaliacaoModelo, int ado){
        conecta.conexao();
        double pontualidade=0, tempo=0, atualizacao=0, confianca=0, cumprimento=0;
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado+"");
                
        try {
            conecta.rs.first();
            pontualidade=(conecta.rs.getInt("pontualidade_assiduidade")*0.1);
            
            tempo=(conecta.rs.getInt("tempo_experiencia")*0.05);
             
            atualizacao=(conecta.rs.getInt("atualizacao_profissional")*0.05);
           
            confianca=(conecta.rs.getInt("confianca")*0.05);
          
            cumprimento=(conecta.rs.getInt("cumprimento_normas")*0.05);
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=pontualidade+tempo+atualizacao+confianca+cumprimento;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update maturidadeprofissional set nota_corrigida=?"
                    + " where mat_avaliado=?");
            pst.setDouble(1, total);
            pst.setInt(2, ado);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
           
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaMaturidadeTF(ado, total);
        return total;
    
    }
     
     
     
    public void insereNotaCorrigida (int ador, int ado){
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Insert into nota_corrigida (Conhecimento_tecnico,"
                    + " Uso_ferramentas, Conhecimentos_normas, Melhoria_Continua,"
                    + " Produtividade, Garantia_qualidade, Organizacao,"
                    + " Analise_Riscos, Satisfacao_Usuario, Senso_Urgencia,"
                    + " Resolucao_problemas, Resultado_Trabalho, Comprometimento,"
                    + " Flexibilidade, Eficiencia_Comunicacao, Cordialidade_Respeito,"
                    + " Espirito_Equipe, Administracao_conflitos, Respeito_Individualidade,"
                    + " Conhecimento_legislacao, mat_avaliador, mat_avaliado, total_corrigida,"
                    + " coerencia, gerencia_objetivos, desenvolvimento_pessoas, lideranca, gerencia_participativa) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pst.setDouble(1, 0);
            pst.setDouble(2, 0);
            pst.setDouble(3, 0);
            pst.setDouble(4, 0);
            pst.setDouble(5, 0);
            pst.setDouble(6, 0);
            pst.setDouble(7, 0);
            pst.setDouble(8, 0);
            pst.setDouble(9, 0);
            pst.setDouble(10, 0);
            pst.setDouble(11,0);
            pst.setDouble(12, 0);
            pst.setDouble(13, 0);
            pst.setDouble(14, 0);
            pst.setDouble(15, 0);
            pst.setDouble(16, 0);
            pst.setDouble(17, 0);
            pst.setDouble(18, 0);
            pst.setDouble(19, 0);
            pst.setDouble(20, 0);
            
            pst.setDouble(21, ador);
            pst.setDouble(22, ado);
            pst.setDouble(23, 0);
            pst.setDouble(24, 0);
            pst.setDouble(25, 0);
            pst.setDouble(26, 0);
            pst.setDouble(27, 0);
            pst.setDouble(28, 0);
            pst.execute();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }
    
    public String getTotalAtual(int ador, int ado){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from nota_corrigida where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
        double total=0;
        try {
            conecta.rs.first();
            total=conecta.rs.getDouble("total_corrigida");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar total corrigida, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
               
               
        String resultado = String.format("%.2f", total);
        return resultado;
    }
    
    public String getTotal(int ado){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from nota_corrigida where mat_avaliado="+ado);
        double total=0;
        try {
            conecta.rs.first();
            do{
            total=total+conecta.rs.getDouble("total_corrigida");
            }while (conecta.rs.next());
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao buscar total corrigida, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado);
        try {
            conecta.rs.first();
            total=total+conecta.rs.getDouble("nota_corrigida");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar a corrigida de maturidade");
        } finally {
            conecta.desconecta();
        }
        
               
        String resultado = String.format("%.2f", total);
        return resultado;
    }
    
    public void insereMaturidade (int ado){
        conecta.conexao();
        PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into maturidadeprofissional (pontualidade_assiduidade,"
                    + " tempo_experiencia, atualizacao_profissional, confianca, cumprimento_normas, mat_avaliado)"
                    + " VALUES (?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setInt(2, 0);
            pst.setInt(3, 0);
            pst.setInt(4, 0);
            pst.setInt(5, 0);
            pst.setInt(6, ado);
            pst.execute();
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro em maturidade profissional, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
        }
    
    public void editaMaturidade(AvaliacaoModel avaliacaoModelo, int ado){
            conecta.conexao();
            PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update maturidadeprofissional set Pontualidade_assiduidade=?,"
                    + " tempo_experiencia=?, atualizacao_profissional=?, confianca=?, cumprimento_normas=? "
                    + "where mat_avaliado=?");
            pst.setDouble(1, avaliacaoModelo.getPontualidadeAssiduidade());
            pst.setDouble(2, avaliacaoModelo.getTempoExperiencia());
            pst.setDouble(3, avaliacaoModelo.getAtualizacaoProfissional());
            pst.setDouble(4, avaliacaoModelo.getConfianca());
            pst.setDouble(5, avaliacaoModelo.getCumprimentoNormas());
            pst.setDouble(6, ado);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Maturidade profissional gravada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, ao editar maturidade, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
        
               
    }
    
    public void alteraBoolAvaliacaoMaturidade(int ado){
      conecta.conexao();
      PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update maturidadeprofissional set avaliacaoconcluida=? where "
                    + "mat_avaliado=?");
            pst.setBoolean(1, true);
            pst.setInt(2, ado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo altera bool: "+ex);
        } finally {
            conecta.desconecta();
        }
    }
        
    public String getNotaCorrigidaTotal (int ado){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from nota_corrigida where mat_avaliado="+ado);
        double total=0;
        try {
            conecta.rs.first();
            do{
                total=total+(conecta.rs.getDouble("total_corrigida"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pegar total e nota corrigida."+ex);
        } finally {
            conecta.desconecta();
        }
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado);
        try {
            conecta.rs.first();
            total = total+conecta.rs.getDouble("nota_corrigida");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao buscar o valor de maturidade, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
        
        String resultado = String.format("%.2f", total);
        return resultado;
    }
    
    public double getNotaCorrigidaTotalDouble (int ado){
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from nota_corrigida where mat_avaliado="+ado);
        double total=0;
        try {
            conecta.rs.first();
            do{
                total=total+(conecta.rs.getDouble("total_corrigida"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao pegar total e nota corrigida."+ex);
        } finally {
            conecta.desconecta();
        }
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from maturidadeprofissional where mat_avaliado="+ado);
        try {
            conecta.rs.first();
            total = total+conecta.rs.getDouble("nota_corrigida");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao buscar o valor de maturidade, motivo: "+ex);
        } finally{
            conecta.desconecta();
        }
        
        return total;
    }
   
    public void InsereCorrigidaTotal(int ado){
        conecta2.conexao();
        PreparedStatement pst2;
        try {
            pst2=conecta2.conn.prepareStatement ("Insert into nota_corrigida_total (funcionario_matricula_func_nc,"
                    + " nota_corrigida_total_nc) VALUES (?,?)");
       
        pst2.setInt(1, ado);
            pst2.setDouble(2, 0);
           pst2.execute();
         
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Erro ao inserir em corrigida total, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       
    }
    
    public void InsereMedias(int ado){// tem que ver pois esta fazendo essa função 02 vezes com nome diferente
        conecta2.conexao();
        PreparedStatement pst2;
        try {
            pst2=conecta2.conn.prepareStatement ("Insert into nota_corrigida_total (funcionario_matricula_func_nc,"
                    + " nota_corrigida_total_nc) VALUES (?,?)");
       
        pst2.setInt(1, ado);
            pst2.setDouble(2, 0);
           pst2.execute();
         
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Erro ao inserir em corrigida total, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
       
    }
    
   public void geraCorrigidaTotal(){
        
        conecta2.conexao();
        PreparedStatement pst2;
       
        int mat=0; 
        conecta2.executaPesquisaSQL("Select * from funcionario");
        try {
            conecta2.rs.first();
        do{
        mat=conecta2.rs.getInt("matricula_func");
            pst2=conecta2.conn.prepareStatement ("Insert into nota_corrigida_total (funcionario_matricula_func_nc,"
                    + " nota_corrigida_total_nc) VALUES (?,?)");
            pst2.setInt(1, mat);
            pst2.setDouble(2, 0);
           pst2.execute();
        }while (conecta2.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo: "+ex);
        } finally {
            conecta2.desconecta();
        }
        
    }
   
   public void atualizaCorrigidaTotal(int mat, double nota){
       conecta.conexao();
       PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Update nota_corrigida_total set nota_corrigida_total_nc=?"
                    + " where Funcionario_matricula_func_nc=?");
            pst.setDouble(1, nota);
            pst.setInt(2, mat);
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motio: "+ex);
        } finally {
            conecta.desconecta();
        }
       
   }
   
   public void inserePercentual (int ador, int ado){
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Insert into percentual (Conhecimento_tecnico,"
                    + " Uso_ferramentas, Conhecimentos_normas, Melhoria_Continua,"
                    + " Produtividade, Garantia_qualidade, Organizacao,"
                    + " Analise_Riscos, Satisfacao_Usuario, Senso_Urgencia,"
                    + " Resolucao_problemas, Resultado_Trabalho, Comprometimento,"
                    + " Flexibilidade, Eficiencia_Comunicacao, Cordialidade_Respeito,"
                    + " Espirito_Equipe, Administracao_conflitos, Respeito_Individualidade,"
                    + " Conhecimento_legislacao, mat_avaliador, mat_avaliado,"
                    + " coerencia, gerencia_objetivos, desenvolvimento_pessoas, lideranca, gerencia_participativa) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            pst.setDouble(1, 0);
            pst.setDouble(2, 0);
            pst.setDouble(3, 0);
            pst.setDouble(4, 0);
            pst.setDouble(5, 0);
            pst.setDouble(6, 0);
            pst.setDouble(7, 0);
            pst.setDouble(8, 0);
            pst.setDouble(9, 0);
            pst.setDouble(10, 0);
            pst.setDouble(11,0);
            pst.setDouble(12, 0);
            pst.setDouble(13, 0);
            pst.setDouble(14, 0);
            pst.setDouble(15, 0);
            pst.setDouble(16, 0);
            pst.setDouble(17, 0);
            pst.setDouble(18, 0);
            pst.setDouble(19, 0);
            pst.setDouble(20, 0);
            
            pst.setDouble(21, ador);
            pst.setDouble(22, ado);
            
            pst.setDouble(23, 0);
            pst.setDouble(24, 0);
            pst.setDouble(25, 0);
            pst.setDouble(26, 0);
            pst.setDouble(27, 0);
            pst.execute();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
    }
     
   public void calculaGravaPercentual(AvaliacaoModel avaliacao, int ado, int ador){
        double conhecimentoTecnico=0, usoFerrantentasTI=0,conhecimentoLegislacao=0,
   conhecimentoNormas=0, melhoriaContinua=0, produtividade=0, garantiaQualidade=0,
   organizacao=0, analiseRiscos=0, satisfacaoUsuario=0, sensoUrgencia=0, resolucaoProblema=0,
   resultadoTrabalho=0, compromentimento=0, flexibilidade=0, eficienciaComunicacao=0,
   cordialidadeRespeito=0, espiritoEquipe=0, administracaoConflitos=0, respeitoIndividualidade=0,
   coerencia=0, gerenciaObjetivos=0, desenvolvimentoPessoas=0, lideranca=0, gerenciaParticipativa=0;
        double totalCorrigida=0;
        
        //pega o total corrigida para usar como dividendo
        conecta.conexao();
        conecta.executaPesquisaSQL("Select * from nota_corrigida_total "
                + "where funcionario_matricula_func_nc="+ado);
        try {
            conecta.rs.first();
            totalCorrigida=conecta.rs.getDouble("nota_corrigida_total_nc");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, ao buscar nota_corrigida_total, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
              
        //pega o valor da nota_corrigida de cada item de cada avaliação
        conecta.conexao();
   
        conecta.executaPesquisaSQL("Select * from nota_corrigida where mat_avaliado="+ado+
           " and mat_avaliador="+ador);
        try {
            conecta.rs.first();
            desenvolvimentoPessoas=conecta.rs.getDouble("Desenvolvimento_Pessoas");
            lideranca=conecta.rs.getDouble("lideranca");
            gerenciaParticipativa=conecta.rs.getDouble("gerencia_participativa");
          
            conhecimentoTecnico=conecta.rs.getDouble("conhecimento_tecnico");
            usoFerrantentasTI=conecta.rs.getDouble("uso_ferramentas");
            conhecimentoLegislacao=conecta.rs.getDouble("conhecimento_legislacao");
            conhecimentoNormas=conecta.rs.getDouble("conhecimentos_normas");
            melhoriaContinua=conecta.rs.getDouble("melhoria_continua");
            produtividade=conecta.rs.getDouble("produtividade");
            garantiaQualidade=conecta.rs.getDouble("garantia_qualidade");
            organizacao=conecta.rs.getDouble("organizacao");
            analiseRiscos=conecta.rs.getDouble("analise_riscos");
            satisfacaoUsuario=conecta.rs.getDouble("satisfacao_usuario");
            sensoUrgencia=conecta.rs.getDouble("Senso_urgencia");
            resolucaoProblema=conecta.rs.getDouble("Resolucao_problemas");
            resultadoTrabalho=conecta.rs.getDouble("resultado_trabalho");
            compromentimento=conecta.rs.getDouble("comprometimento");
            flexibilidade=conecta.rs.getDouble("flexibilidade");
            eficienciaComunicacao=conecta.rs.getDouble("eficiencia_comunicacao");
            cordialidadeRespeito=conecta.rs.getDouble("cordialidade_respeito");
            espiritoEquipe=conecta.rs.getDouble("espirito_equipe");
            administracaoConflitos=conecta.rs.getDouble("administracao_conflitos");
            respeitoIndividualidade=conecta.rs.getDouble("respeito_individualidade");
            coerencia=conecta.rs.getDouble("coerencia");
            gerenciaObjetivos=conecta.rs.getDouble("gerencia_objetivos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro calculaGrava 01"+ex);
        } finally {
            conecta.desconecta();
        }
        
        //insere na tabela percentual ja calculando
        PreparedStatement pst2;
        conecta.conexao();
        try { 
            pst2=conecta.conn.prepareStatement("Update percentual set Conhecimento_tecnico = ?,"
                    + " Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?,"
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?,"
                    + " Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, coerencia=?, gerencia_objetivos=?,"
                    + " desenvolvimento_pessoas=?, lideranca=?, gerencia_participativa=?"
                    + " WHERE Mat_Avaliador=?"
                    + " AND Mat_Avaliado=?");
            
            pst2.setDouble(1, conhecimentoTecnico/totalCorrigida);
            
            pst2.setDouble(2, usoFerrantentasTI/totalCorrigida);
            pst2.setDouble(3, conhecimentoNormas/totalCorrigida);
            pst2.setDouble(4, melhoriaContinua/totalCorrigida);
            pst2.setDouble(5, produtividade/totalCorrigida);
            pst2.setDouble(6, garantiaQualidade/totalCorrigida);
            pst2.setDouble(7, organizacao/totalCorrigida);
            pst2.setDouble(8, analiseRiscos/totalCorrigida);
            pst2.setDouble(9, satisfacaoUsuario/totalCorrigida);
            pst2.setDouble(10, sensoUrgencia/totalCorrigida);
            pst2.setDouble(11, resolucaoProblema/totalCorrigida);
            pst2.setDouble(12, resultadoTrabalho/totalCorrigida);
            pst2.setDouble(13, compromentimento/totalCorrigida);
            pst2.setDouble(14, flexibilidade/totalCorrigida);
            pst2.setDouble(15, eficienciaComunicacao/totalCorrigida);
            pst2.setDouble(16, cordialidadeRespeito/totalCorrigida);
            pst2.setDouble(17, espiritoEquipe/totalCorrigida);
            pst2.setDouble(18, administracaoConflitos/totalCorrigida);
            pst2.setDouble(19, respeitoIndividualidade/totalCorrigida);
            pst2.setDouble(20, conhecimentoLegislacao/totalCorrigida);
            pst2.setDouble(21, coerencia/totalCorrigida);
            pst2.setDouble(22, gerenciaObjetivos/totalCorrigida);
            pst2.setDouble(23, desenvolvimentoPessoas/totalCorrigida);
            pst2.setDouble(24, lideranca/totalCorrigida);
            pst2.setDouble(25, gerenciaParticipativa/totalCorrigida);
            pst2.setInt(26, ador);
            pst2.setInt(27, ado);
           
            pst2.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir na tabela percentual. "+ex);
        } finally {
            conecta.desconecta();
        }
   }

   public void InsereTabelaPercentualFinal(int ado){
       conecta.conexao();
       PreparedStatement pst;
        try {
            pst=conecta.conn.prepareStatement("Insert into nota_percentual_total "
                    + "(Funcionario_matricula_func_pt, percentual_total) VALUES (?,?) ");
            pst.setInt(1, ado);
            pst.setDouble(2, 0);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir tabela Percentual Final"+ex);
        } finally {
            conecta.desconecta();
        }
   }
   
   public String calculaPercentualFinal(int ado){
      
       double corrigidatotal = getNotaCorrigidaTotalDouble(ado);
       double percentualFinal = (corrigidatotal/5)*100;
       PreparedStatement pst;
        try {
            conecta.conexao();
            pst=conecta.conn.prepareStatement("Update nota_percentual_total set percentual_total=?"
                    + " where funcionario_matricula_func_pt=?");
            pst.setDouble(1, percentualFinal/100);
            pst.setInt(2, ado);
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar tabela percentual, motivo: "+ex);
        } finally {
            conecta.desconecta();
        }
       
//        String resultado = (String.format("%.2f",percentualFinal));
         String resultado = (String.format("%.2f",percentualFinal));
//        resultado += "%";     //PERCENTUAL RETIRADO EM 11/06/19
        
        TabelaFinalControl tabela = new TabelaFinalControl(bancoOf);
        tabela.editaNotaFinalTF(ado, resultado);
        return resultado;
   }
   
   public void calculaMediaGerenteChefe (int ado){
       conecta.conexao();
       double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
               coerencia=0, gerencia_objetivos=0, desenvPessoas=0, lideranca=0, gerencia_part=0  ;  
            int cont=0;
       FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
       int idDpto = funcionario.getIdDpto(ado);
       
       conecta.executaPesquisaSQL("Select * from calculamediavisao where mat_avaliado="+ado+
               " and departamento_iddepartamento_ger="+idDpto); //+ and cargo_func='gerente'");
        try {
            conecta.rs.first();
            cont=0;
            
            
            do{
                int func=0;
                func=conecta.rs.getInt("mat_avaliador");
                
                if ((func!=888)&&(func!=78659)){
            conhecTec=conhecTec+(conecta.rs.getDouble("conhecimento_tecnico"));
            
            usoFerramenta=usoFerramenta+(conecta.rs.getDouble("uso_ferramentas"));
            conhecLegisl=conhecLegisl+(conecta.rs.getDouble("conhecimento_legislacao"));
            conhecNormas=conhecNormas+(conecta.rs.getDouble("conhecimentos_normas"));
            melhoriaContinua=melhoriaContinua+(conecta.rs.getDouble("melhoria_continua"));
            produtividade=produtividade+(conecta.rs.getDouble("produtividade"));
            garantiaQualidade=garantiaQualidade+(conecta.rs.getDouble("garantia_qualidade"));
            organizacao=organizacao+(conecta.rs.getDouble("organizacao"));
            analiseRiscos=analiseRiscos+(conecta.rs.getDouble("analise_riscos"));
            satisfacaoUsuario=satisfacaoUsuario+(conecta.rs.getDouble("satisfacao_usuario"));
            sensoUrgencia=sensoUrgencia+(conecta.rs.getDouble("senso_urgencia"));
            resolucaoProblemas=resolucaoProblemas+(conecta.rs.getDouble("resolucao_problemas"));
            resultadoTrabalho=resultadoTrabalho+(conecta.rs.getDouble("resultado_trabalho"));
            comprometimento=comprometimento+(conecta.rs.getDouble("comprometimento"));
            flexibilidade=flexibilidade+(conecta.rs.getDouble("flexibilidade"));
            eficienciaComunicao=eficienciaComunicao+(conecta.rs.getDouble("eficiencia_comunicacao"));
            cordialidadeRespeito=cordialidadeRespeito+(conecta.rs.getDouble("cordialidade_respeito"));
            espiritoEquipe=espiritoEquipe+(conecta.rs.getDouble("espirito_equipe"));
            admConflito=admConflito+(conecta.rs.getDouble("administracao_conflitos"));
            respeitoIndividualidade=respeitoIndividualidade+(conecta.rs.getDouble("respeito_individualidade"));
            coerencia=coerencia+(conecta.rs.getDouble("coerencia"));
            gerencia_objetivos=gerencia_objetivos+(conecta.rs.getDouble("gerencia_objetivos"));
            desenvPessoas=desenvPessoas+(conecta.rs.getDouble("desenvolvimento_pessoas"));
            lideranca=lideranca+(conecta.rs.getDouble("lideranca"));
            gerencia_part=gerencia_part+(conecta.rs.getDouble("gerencia_participativa"));
                
                } 
                
                cont++;
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar os valores iniciais "+ex);
        } finally {
            conecta.desconecta();
        }


    PreparedStatement pst;
    conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update Media set Conhecimento_tecnicoM = ?,"
                    + "Uso_ferramentasM = ?, Conhecimentos_normasM = ?, Melhoria_ContinuaM = ?,"
                    + " ProdutividadeM = ?, Garantia_qualidadeM = ?, OrganizacaoM = ?, "
                    + " Analise_RiscosM = ?, Satisfacao_UsuarioM = ?, Senso_UrgenciaM = ?, "
                    + "Resolucao_problemasM = ?, Resultado_TrabalhoM = ?, ComprometimentoM = ?,"
                    + " FlexibilidadeM = ?, Eficiencia_ComunicacaoM = ?, Cordialidade_RespeitoM = ?,"
                    + " Espirito_EquipeM = ?, Administracao_conflitosM = ?, Respeito_IndividualidadeM = ?,"
                    + " Conhecimento_legislacaoM = ?, coerenciaM=?, gerencia_objetivosM=?,"
                    + " desenvolvimento_pessoasM=?, liderancaM=?, gerencia_participativaM=?"
                    + " WHERE Mat_Avaliado = ?");
//            cont--;
//            cont--;//esses dois cont-- desconta 02 usuarios do banco admin999 e média 888
           
            pst.setDouble(1, (conhecTec/cont));
           
            pst.setDouble(2, usoFerramenta/cont);
            pst.setDouble(3, conhecNormas/cont);
            pst.setDouble(4, melhoriaContinua/cont);
            pst.setDouble(5, produtividade/cont);
            pst.setDouble(6, garantiaQualidade/cont);
            pst.setDouble(7, organizacao/cont);
            pst.setDouble(8, analiseRiscos/cont);
            pst.setDouble(9, satisfacaoUsuario/cont);
            pst.setDouble(10, sensoUrgencia/cont);
            pst.setDouble(11, resolucaoProblemas/cont);
            pst.setDouble(12, resultadoTrabalho/cont);
            pst.setDouble(13, comprometimento/cont);
            pst.setDouble(14, flexibilidade/cont);
            pst.setDouble(15, eficienciaComunicao/cont);
            pst.setDouble(16, cordialidadeRespeito/cont);
            pst.setDouble(17, espiritoEquipe/cont);
            pst.setDouble(18, admConflito/cont);
            pst.setDouble(19, respeitoIndividualidade/cont);
            pst.setDouble(20, conhecLegisl/cont);
            pst.setDouble(21, coerencia/cont);
            pst.setDouble(22, gerencia_objetivos/cont);
            pst.setDouble(23, desenvPessoas/cont);
            pst.setDouble(24, lideranca/cont);
            pst.setDouble(25, gerencia_part/cont);
            pst.setInt(26, ado);
            
            pst.executeUpdate();    
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir a média: "+ex);
        } finally {
            conecta.desconecta();
        }
       
         AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
         avaliacaoModelo.setAdministracaoConflitos(admConflito/cont);
            avaliacaoModelo.setAnaliseRiscos(analiseRiscos/cont);
            avaliacaoModelo.setCompromentimento(comprometimento/cont);
            avaliacaoModelo.setConhecimentoLegislacao(conhecLegisl/cont);
            avaliacaoModelo.setConhecimentoNormas(conhecNormas/cont);
            avaliacaoModelo.setConhecimentoTecnico(conhecTec/cont);
            avaliacaoModelo.setCordialidadeRespeito(cordialidadeRespeito/cont);
            avaliacaoModelo.setEficienciaComunicacao(eficienciaComunicao/cont);
            avaliacaoModelo.setEspiritoEquipe(espiritoEquipe/cont);
            avaliacaoModelo.setFlexibilidade(flexibilidade/cont);
            avaliacaoModelo.setGarantiaQualidade(garantiaQualidade/cont);
            avaliacaoModelo.setMelhoriaContinua(melhoriaContinua/cont);
            avaliacaoModelo.setOrganizacao(organizacao/cont);
            avaliacaoModelo.setProdutividade(produtividade/cont);
            avaliacaoModelo.setResolucaoProblema(resolucaoProblemas/cont);
            avaliacaoModelo.setRespeitoIndividualidade(respeitoIndividualidade/cont);
            avaliacaoModelo.setResultadoTrabalho(resultadoTrabalho/cont);
            avaliacaoModelo.setSatisfacaoUsuario(satisfacaoUsuario/cont);
            avaliacaoModelo.setSensoUrgencia(sensoUrgencia/cont);
            avaliacaoModelo.setUsoFerrantentasTI(usoFerramenta/cont);
            avaliacaoModelo.setCoerencia(coerencia/cont);
            avaliacaoModelo.setGerenciaObjetivos(gerencia_objetivos/cont);
            avaliacaoModelo.setDesenvolvimentoPessoas(desenvPessoas/cont);
            avaliacaoModelo.setLideranca(lideranca/cont);
            avaliacaoModelo.setGerenciaParticipativa(gerencia_part/cont);
            gravaEditaAvaliacao(avaliacaoModelo, 888, ado);
        
   }
   
   public void calculaMediaFuncionarioGerente (int ado){// fazer esse método
       conecta.conexao();
       double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
               coerencia=0, gerencia_objetivos=0, desenvPessoas=0, lideranca=0, gerencia_part=0  ;  
            int cont=0;
       FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
       int idGerencia = funcionario.getIdGerecia(ado); //PAREI AQUI
       
       conecta.executaPesquisaSQL("Select * from calculamediavisao where mat_avaliado="+ado+
               " and gerencia_idgerencias_func="+idGerencia+" and cargo_func='funcionário'");
        try {
            conecta.rs.first();
            cont=0;
            
            
            do{
                int func=0;
                func=conecta.rs.getInt("mat_avaliador");
                
                if ((func!=888)&&(func!=78659)){
            conhecTec=conhecTec+(conecta.rs.getDouble("conhecimento_tecnico"));
            
            usoFerramenta=usoFerramenta+(conecta.rs.getDouble("uso_ferramentas"));
            conhecLegisl=conhecLegisl+(conecta.rs.getDouble("conhecimento_legislacao"));
            conhecNormas=conhecNormas+(conecta.rs.getDouble("conhecimentos_normas"));
            melhoriaContinua=melhoriaContinua+(conecta.rs.getDouble("melhoria_continua"));
            produtividade=produtividade+(conecta.rs.getDouble("produtividade"));
            garantiaQualidade=garantiaQualidade+(conecta.rs.getDouble("garantia_qualidade"));
            organizacao=organizacao+(conecta.rs.getDouble("organizacao"));
            analiseRiscos=analiseRiscos+(conecta.rs.getDouble("analise_riscos"));
            satisfacaoUsuario=satisfacaoUsuario+(conecta.rs.getDouble("satisfacao_usuario"));
            sensoUrgencia=sensoUrgencia+(conecta.rs.getDouble("senso_urgencia"));
            resolucaoProblemas=resolucaoProblemas+(conecta.rs.getDouble("resolucao_problemas"));
            resultadoTrabalho=resultadoTrabalho+(conecta.rs.getDouble("resultado_trabalho"));
            comprometimento=comprometimento+(conecta.rs.getDouble("comprometimento"));
            flexibilidade=flexibilidade+(conecta.rs.getDouble("flexibilidade"));
            eficienciaComunicao=eficienciaComunicao+(conecta.rs.getDouble("eficiencia_comunicacao"));
            cordialidadeRespeito=cordialidadeRespeito+(conecta.rs.getDouble("cordialidade_respeito"));
            espiritoEquipe=espiritoEquipe+(conecta.rs.getDouble("espirito_equipe"));
            admConflito=admConflito+(conecta.rs.getDouble("administracao_conflitos"));
            respeitoIndividualidade=respeitoIndividualidade+(conecta.rs.getDouble("respeito_individualidade"));
            coerencia=coerencia+(conecta.rs.getDouble("coerencia"));
            gerencia_objetivos=gerencia_objetivos+(conecta.rs.getDouble("gerencia_objetivos"));
            desenvPessoas=desenvPessoas+(conecta.rs.getDouble("desenvolvimento_pessoas"));
            lideranca=lideranca+(conecta.rs.getDouble("lideranca"));
            gerencia_part=gerencia_part+(conecta.rs.getDouble("gerencia_participativa"));
                
                } 
                
                cont++;
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar os valores iniciais "+ex);
        } finally {
            conecta.desconecta();
        }


    PreparedStatement pst;
    conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update Media set Conhecimento_tecnicoM = ?,"
                    + "Uso_ferramentasM = ?, Conhecimentos_normasM = ?, Melhoria_ContinuaM = ?,"
                    + " ProdutividadeM = ?, Garantia_qualidadeM = ?, OrganizacaoM = ?, "
                    + " Analise_RiscosM = ?, Satisfacao_UsuarioM = ?, Senso_UrgenciaM = ?, "
                    + "Resolucao_problemasM = ?, Resultado_TrabalhoM = ?, ComprometimentoM = ?,"
                    + " FlexibilidadeM = ?, Eficiencia_ComunicacaoM = ?, Cordialidade_RespeitoM = ?,"
                    + " Espirito_EquipeM = ?, Administracao_conflitosM = ?, Respeito_IndividualidadeM = ?,"
                    + " Conhecimento_legislacaoM = ?, coerenciaM=?, gerencia_objetivosM=?,"
                    + " desenvolvimento_pessoasM=?, liderancaM=?, gerencia_participativaM=?"
                    + " WHERE Mat_Avaliado = ?");
//            cont--;
//            cont--;//esses dois cont-- desconta 02 usuarios do banco admin999 e média 888
           
            pst.setDouble(1, (conhecTec/cont));
           
            pst.setDouble(2, usoFerramenta/cont);
            pst.setDouble(3, conhecNormas/cont);
            pst.setDouble(4, melhoriaContinua/cont);
            pst.setDouble(5, produtividade/cont);
            pst.setDouble(6, garantiaQualidade/cont);
            pst.setDouble(7, organizacao/cont);
            pst.setDouble(8, analiseRiscos/cont);
            pst.setDouble(9, satisfacaoUsuario/cont);
            pst.setDouble(10, sensoUrgencia/cont);
            pst.setDouble(11, resolucaoProblemas/cont);
            pst.setDouble(12, resultadoTrabalho/cont);
            pst.setDouble(13, comprometimento/cont);
            pst.setDouble(14, flexibilidade/cont);
            pst.setDouble(15, eficienciaComunicao/cont);
            pst.setDouble(16, cordialidadeRespeito/cont);
            pst.setDouble(17, espiritoEquipe/cont);
            pst.setDouble(18, admConflito/cont);
            pst.setDouble(19, respeitoIndividualidade/cont);
            pst.setDouble(20, conhecLegisl/cont);
            pst.setDouble(21, coerencia/cont);
            pst.setDouble(22, gerencia_objetivos/cont);
            pst.setDouble(23, desenvPessoas/cont);
            pst.setDouble(24, lideranca/cont);
            pst.setDouble(25, gerencia_part/cont);
            pst.setInt(26, ado);
            
            pst.executeUpdate();    
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir a média: "+ex);
        } finally {
            conecta.desconecta();
        }
       
         AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
         avaliacaoModelo.setAdministracaoConflitos(admConflito/cont);
            avaliacaoModelo.setAnaliseRiscos(analiseRiscos/cont);
            avaliacaoModelo.setCompromentimento(comprometimento/cont);
            avaliacaoModelo.setConhecimentoLegislacao(conhecLegisl/cont);
            avaliacaoModelo.setConhecimentoNormas(conhecNormas/cont);
            avaliacaoModelo.setConhecimentoTecnico(conhecTec/cont);
            avaliacaoModelo.setCordialidadeRespeito(cordialidadeRespeito/cont);
            avaliacaoModelo.setEficienciaComunicacao(eficienciaComunicao/cont);
            avaliacaoModelo.setEspiritoEquipe(espiritoEquipe/cont);
            avaliacaoModelo.setFlexibilidade(flexibilidade/cont);
            avaliacaoModelo.setGarantiaQualidade(garantiaQualidade/cont);
            avaliacaoModelo.setMelhoriaContinua(melhoriaContinua/cont);
            avaliacaoModelo.setOrganizacao(organizacao/cont);
            avaliacaoModelo.setProdutividade(produtividade/cont);
            avaliacaoModelo.setResolucaoProblema(resolucaoProblemas/cont);
            avaliacaoModelo.setRespeitoIndividualidade(respeitoIndividualidade/cont);
            avaliacaoModelo.setResultadoTrabalho(resultadoTrabalho/cont);
            avaliacaoModelo.setSatisfacaoUsuario(satisfacaoUsuario/cont);
            avaliacaoModelo.setSensoUrgencia(sensoUrgencia/cont);
            avaliacaoModelo.setUsoFerrantentasTI(usoFerramenta/cont);
            avaliacaoModelo.setCoerencia(coerencia/cont);
            avaliacaoModelo.setGerenciaObjetivos(gerencia_objetivos/cont);
            avaliacaoModelo.setDesenvolvimentoPessoas(desenvPessoas/cont);
            avaliacaoModelo.setLideranca(lideranca/cont);
            avaliacaoModelo.setGerenciaParticipativa(gerencia_part/cont);
            gravaEditaAvaliacao(avaliacaoModelo, 888, ado);
        
   }
   
   public void calculaMediaFuncionarioChefe (int ado){// fazer esse método
       conecta.conexao();
       double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
               coerencia=0, gerencia_objetivos=0, desenvPessoas=0, lideranca=0, gerencia_part=0  ;  
            int cont=0;
       FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
       int idDpto = funcionario.getIdDpto(ado); //PAREI AQUI
       
       conecta.executaPesquisaSQL("Select * from calculamediavisaotodastabelas where mat_avaliado="+ado+
               " and idDepartamento="+idDpto+" and cargo_func='funcionário'");
        try {
            conecta.rs.first();
            cont=0;
            
            
            do{
                int func=0;
                func=conecta.rs.getInt("mat_avaliador");
                
                if ((func!=888)&&(func!=78659)){
            conhecTec=conhecTec+(conecta.rs.getDouble("conhecimento_tecnico"));
            
            usoFerramenta=usoFerramenta+(conecta.rs.getDouble("uso_ferramentas"));
            conhecLegisl=conhecLegisl+(conecta.rs.getDouble("conhecimento_legislacao"));
            conhecNormas=conhecNormas+(conecta.rs.getDouble("conhecimentos_normas"));
            melhoriaContinua=melhoriaContinua+(conecta.rs.getDouble("melhoria_continua"));
            produtividade=produtividade+(conecta.rs.getDouble("produtividade"));
            garantiaQualidade=garantiaQualidade+(conecta.rs.getDouble("garantia_qualidade"));
            organizacao=organizacao+(conecta.rs.getDouble("organizacao"));
            analiseRiscos=analiseRiscos+(conecta.rs.getDouble("analise_riscos"));
            satisfacaoUsuario=satisfacaoUsuario+(conecta.rs.getDouble("satisfacao_usuario"));
            sensoUrgencia=sensoUrgencia+(conecta.rs.getDouble("senso_urgencia"));
            resolucaoProblemas=resolucaoProblemas+(conecta.rs.getDouble("resolucao_problemas"));
            resultadoTrabalho=resultadoTrabalho+(conecta.rs.getDouble("resultado_trabalho"));
            comprometimento=comprometimento+(conecta.rs.getDouble("comprometimento"));
            flexibilidade=flexibilidade+(conecta.rs.getDouble("flexibilidade"));
            eficienciaComunicao=eficienciaComunicao+(conecta.rs.getDouble("eficiencia_comunicacao"));
            cordialidadeRespeito=cordialidadeRespeito+(conecta.rs.getDouble("cordialidade_respeito"));
            espiritoEquipe=espiritoEquipe+(conecta.rs.getDouble("espirito_equipe"));
            admConflito=admConflito+(conecta.rs.getDouble("administracao_conflitos"));
            respeitoIndividualidade=respeitoIndividualidade+(conecta.rs.getDouble("respeito_individualidade"));
            coerencia=coerencia+(conecta.rs.getDouble("coerencia"));
            gerencia_objetivos=gerencia_objetivos+(conecta.rs.getDouble("gerencia_objetivos"));
            desenvPessoas=desenvPessoas+(conecta.rs.getDouble("desenvolvimento_pessoas"));
            lideranca=lideranca+(conecta.rs.getDouble("lideranca"));
            gerencia_part=gerencia_part+(conecta.rs.getDouble("gerencia_participativa"));
                
                } 
                
                cont++;
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar os valores iniciais "+ex);
        } finally {
            conecta.desconecta();
        }


    PreparedStatement pst;
    conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update Media set Conhecimento_tecnicoM = ?,"
                    + "Uso_ferramentasM = ?, Conhecimentos_normasM = ?, Melhoria_ContinuaM = ?,"
                    + " ProdutividadeM = ?, Garantia_qualidadeM = ?, OrganizacaoM = ?, "
                    + " Analise_RiscosM = ?, Satisfacao_UsuarioM = ?, Senso_UrgenciaM = ?, "
                    + "Resolucao_problemasM = ?, Resultado_TrabalhoM = ?, ComprometimentoM = ?,"
                    + " FlexibilidadeM = ?, Eficiencia_ComunicacaoM = ?, Cordialidade_RespeitoM = ?,"
                    + " Espirito_EquipeM = ?, Administracao_conflitosM = ?, Respeito_IndividualidadeM = ?,"
                    + " Conhecimento_legislacaoM = ?, coerenciaM=?, gerencia_objetivosM=?,"
                    + " desenvolvimento_pessoasM=?, liderancaM=?, gerencia_participativaM=?"
                    + " WHERE Mat_Avaliado = ?");
//            cont--;
//            cont--;//esses dois cont-- desconta 02 usuarios do banco admin999 e média 888
           
            pst.setDouble(1, (conhecTec/cont));
           
            pst.setDouble(2, usoFerramenta/cont);
            pst.setDouble(3, conhecNormas/cont);
            pst.setDouble(4, melhoriaContinua/cont);
            pst.setDouble(5, produtividade/cont);
            pst.setDouble(6, garantiaQualidade/cont);
            pst.setDouble(7, organizacao/cont);
            pst.setDouble(8, analiseRiscos/cont);
            pst.setDouble(9, satisfacaoUsuario/cont);
            pst.setDouble(10, sensoUrgencia/cont);
            pst.setDouble(11, resolucaoProblemas/cont);
            pst.setDouble(12, resultadoTrabalho/cont);
            pst.setDouble(13, comprometimento/cont);
            pst.setDouble(14, flexibilidade/cont);
            pst.setDouble(15, eficienciaComunicao/cont);
            pst.setDouble(16, cordialidadeRespeito/cont);
            pst.setDouble(17, espiritoEquipe/cont);
            pst.setDouble(18, admConflito/cont);
            pst.setDouble(19, respeitoIndividualidade/cont);
            pst.setDouble(20, conhecLegisl/cont);
            pst.setDouble(21, coerencia/cont);
            pst.setDouble(22, gerencia_objetivos/cont);
            pst.setDouble(23, desenvPessoas/cont);
            pst.setDouble(24, lideranca/cont);
            pst.setDouble(25, gerencia_part/cont);
            pst.setInt(26, ado);
            
            pst.executeUpdate();    
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir a média: "+ex);
        } finally {
            conecta.desconecta();
        }
       
         AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
         avaliacaoModelo.setAdministracaoConflitos(admConflito/cont);
            avaliacaoModelo.setAnaliseRiscos(analiseRiscos/cont);
            avaliacaoModelo.setCompromentimento(comprometimento/cont);
            avaliacaoModelo.setConhecimentoLegislacao(conhecLegisl/cont);
            avaliacaoModelo.setConhecimentoNormas(conhecNormas/cont);
            avaliacaoModelo.setConhecimentoTecnico(conhecTec/cont);
            avaliacaoModelo.setCordialidadeRespeito(cordialidadeRespeito/cont);
            avaliacaoModelo.setEficienciaComunicacao(eficienciaComunicao/cont);
            avaliacaoModelo.setEspiritoEquipe(espiritoEquipe/cont);
            avaliacaoModelo.setFlexibilidade(flexibilidade/cont);
            avaliacaoModelo.setGarantiaQualidade(garantiaQualidade/cont);
            avaliacaoModelo.setMelhoriaContinua(melhoriaContinua/cont);
            avaliacaoModelo.setOrganizacao(organizacao/cont);
            avaliacaoModelo.setProdutividade(produtividade/cont);
            avaliacaoModelo.setResolucaoProblema(resolucaoProblemas/cont);
            avaliacaoModelo.setRespeitoIndividualidade(respeitoIndividualidade/cont);
            avaliacaoModelo.setResultadoTrabalho(resultadoTrabalho/cont);
            avaliacaoModelo.setSatisfacaoUsuario(satisfacaoUsuario/cont);
            avaliacaoModelo.setSensoUrgencia(sensoUrgencia/cont);
            avaliacaoModelo.setUsoFerrantentasTI(usoFerramenta/cont);
            avaliacaoModelo.setCoerencia(coerencia/cont);
            avaliacaoModelo.setGerenciaObjetivos(gerencia_objetivos/cont);
            avaliacaoModelo.setDesenvolvimentoPessoas(desenvPessoas/cont);
            avaliacaoModelo.setLideranca(lideranca/cont);
            avaliacaoModelo.setGerenciaParticipativa(gerencia_part/cont);
            gravaEditaAvaliacao(avaliacaoModelo, 888, ado);
        
   }
   
   public void calculaMediaChefeDiretor (int ado){
       conecta.conexao();
       double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
               coerencia=0, gerencia_objetivos=0, desenvPessoas=0, lideranca=0, gerencia_part=0  ;  
            int cont=0;
       FuncionarioControl funcionario = new FuncionarioControl(bancoOf);
       int idDiretoria = funcionario.getIdDiretoria(ado);
       
       conecta.executaPesquisaSQL("Select * from calculamediavisaotodastabelas where mat_avaliado="+ado+
               " and idDiretoria="+idDiretoria+" and mat_avaliador<>"+ado);//tirei o "and cargo_func=xxx" pois todos entram na invertida, até o alvaro
        try {
            conecta.rs.first();
            cont=0;
            
            
            do{
                int func=0;
                func=conecta.rs.getInt("mat_avaliador");
                
                if ((func!=888)&&(func!=78659)){
            conhecTec=conhecTec+(conecta.rs.getDouble("conhecimento_tecnico"));
            
            usoFerramenta=usoFerramenta+(conecta.rs.getDouble("uso_ferramentas"));
            conhecLegisl=conhecLegisl+(conecta.rs.getDouble("conhecimento_legislacao"));
            conhecNormas=conhecNormas+(conecta.rs.getDouble("conhecimentos_normas"));
            melhoriaContinua=melhoriaContinua+(conecta.rs.getDouble("melhoria_continua"));
            produtividade=produtividade+(conecta.rs.getDouble("produtividade"));
            garantiaQualidade=garantiaQualidade+(conecta.rs.getDouble("garantia_qualidade"));
            organizacao=organizacao+(conecta.rs.getDouble("organizacao"));
            analiseRiscos=analiseRiscos+(conecta.rs.getDouble("analise_riscos"));
            satisfacaoUsuario=satisfacaoUsuario+(conecta.rs.getDouble("satisfacao_usuario"));
            sensoUrgencia=sensoUrgencia+(conecta.rs.getDouble("senso_urgencia"));
            resolucaoProblemas=resolucaoProblemas+(conecta.rs.getDouble("resolucao_problemas"));
            resultadoTrabalho=resultadoTrabalho+(conecta.rs.getDouble("resultado_trabalho"));
            comprometimento=comprometimento+(conecta.rs.getDouble("comprometimento"));
            flexibilidade=flexibilidade+(conecta.rs.getDouble("flexibilidade"));
            eficienciaComunicao=eficienciaComunicao+(conecta.rs.getDouble("eficiencia_comunicacao"));
            cordialidadeRespeito=cordialidadeRespeito+(conecta.rs.getDouble("cordialidade_respeito"));
            espiritoEquipe=espiritoEquipe+(conecta.rs.getDouble("espirito_equipe"));
            admConflito=admConflito+(conecta.rs.getDouble("administracao_conflitos"));
            respeitoIndividualidade=respeitoIndividualidade+(conecta.rs.getDouble("respeito_individualidade"));
            coerencia=coerencia+(conecta.rs.getDouble("coerencia"));
            gerencia_objetivos=gerencia_objetivos+(conecta.rs.getDouble("gerencia_objetivos"));
            desenvPessoas=desenvPessoas+(conecta.rs.getDouble("desenvolvimento_pessoas"));
            lideranca=lideranca+(conecta.rs.getDouble("lideranca"));
            gerencia_part=gerencia_part+(conecta.rs.getDouble("gerencia_participativa"));
                
                } 
                
                cont++;
            }while (conecta.rs.next());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar os valores iniciais "+ex);
        } finally {
            conecta.desconecta();
        }


    PreparedStatement pst;
    conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update Media set Conhecimento_tecnicoM = ?,"
                    + "Uso_ferramentasM = ?, Conhecimentos_normasM = ?, Melhoria_ContinuaM = ?,"
                    + " ProdutividadeM = ?, Garantia_qualidadeM = ?, OrganizacaoM = ?, "
                    + " Analise_RiscosM = ?, Satisfacao_UsuarioM = ?, Senso_UrgenciaM = ?, "
                    + "Resolucao_problemasM = ?, Resultado_TrabalhoM = ?, ComprometimentoM = ?,"
                    + " FlexibilidadeM = ?, Eficiencia_ComunicacaoM = ?, Cordialidade_RespeitoM = ?,"
                    + " Espirito_EquipeM = ?, Administracao_conflitosM = ?, Respeito_IndividualidadeM = ?,"
                    + " Conhecimento_legislacaoM = ?, coerenciaM=?, gerencia_objetivosM=?,"
                    + " desenvolvimento_pessoasM=?, liderancaM=?, gerencia_participativaM=?"
                    + " WHERE Mat_Avaliado = ?");
//            cont--;
//            cont--;//esses dois cont-- desconta 02 usuarios do banco admin999 e média 888
            
            pst.setDouble(1, (conhecTec/cont));
           
            pst.setDouble(2, usoFerramenta/cont);
            pst.setDouble(3, conhecNormas/cont);
            pst.setDouble(4, melhoriaContinua/cont);
            pst.setDouble(5, produtividade/cont);
            pst.setDouble(6, garantiaQualidade/cont);
            pst.setDouble(7, organizacao/cont);
            pst.setDouble(8, analiseRiscos/cont);
            pst.setDouble(9, satisfacaoUsuario/cont);
            pst.setDouble(10, sensoUrgencia/cont);
            pst.setDouble(11, resolucaoProblemas/cont);
            pst.setDouble(12, resultadoTrabalho/cont);
            pst.setDouble(13, comprometimento/cont);
            pst.setDouble(14, flexibilidade/cont);
            pst.setDouble(15, eficienciaComunicao/cont);
            pst.setDouble(16, cordialidadeRespeito/cont);
            pst.setDouble(17, espiritoEquipe/cont);
            pst.setDouble(18, admConflito/cont);
            pst.setDouble(19, respeitoIndividualidade/cont);
            pst.setDouble(20, conhecLegisl/cont);
            pst.setDouble(21, coerencia/cont);
            pst.setDouble(22, gerencia_objetivos/cont);
            pst.setDouble(23, desenvPessoas/cont);
            pst.setDouble(24, lideranca/cont);
            pst.setDouble(25, gerencia_part/cont);
            pst.setInt(26, ado);
            
            pst.executeUpdate();    
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir a média: "+ex);
        } finally {
            conecta.desconecta();
        }
       
         AvaliacaoModel avaliacaoModelo = new AvaliacaoModel();
         avaliacaoModelo.setAdministracaoConflitos(admConflito/cont);
            avaliacaoModelo.setAnaliseRiscos(analiseRiscos/cont);
            avaliacaoModelo.setCompromentimento(comprometimento/cont);
            avaliacaoModelo.setConhecimentoLegislacao(conhecLegisl/cont);
            avaliacaoModelo.setConhecimentoNormas(conhecNormas/cont);
            avaliacaoModelo.setConhecimentoTecnico(conhecTec/cont);
            avaliacaoModelo.setCordialidadeRespeito(cordialidadeRespeito/cont);
            avaliacaoModelo.setEficienciaComunicacao(eficienciaComunicao/cont);
            avaliacaoModelo.setEspiritoEquipe(espiritoEquipe/cont);
            avaliacaoModelo.setFlexibilidade(flexibilidade/cont);
            avaliacaoModelo.setGarantiaQualidade(garantiaQualidade/cont);
            avaliacaoModelo.setMelhoriaContinua(melhoriaContinua/cont);
            avaliacaoModelo.setOrganizacao(organizacao/cont);
            avaliacaoModelo.setProdutividade(produtividade/cont);
            avaliacaoModelo.setResolucaoProblema(resolucaoProblemas/cont);
            avaliacaoModelo.setRespeitoIndividualidade(respeitoIndividualidade/cont);
            avaliacaoModelo.setResultadoTrabalho(resultadoTrabalho/cont);
            avaliacaoModelo.setSatisfacaoUsuario(satisfacaoUsuario/cont);
            avaliacaoModelo.setSensoUrgencia(sensoUrgencia/cont);
            avaliacaoModelo.setUsoFerrantentasTI(usoFerramenta/cont);
            avaliacaoModelo.setCoerencia(coerencia/cont);
            avaliacaoModelo.setGerenciaObjetivos(gerencia_objetivos/cont);
            avaliacaoModelo.setDesenvolvimentoPessoas(desenvPessoas/cont);
            avaliacaoModelo.setLideranca(lideranca/cont);
            avaliacaoModelo.setGerenciaParticipativa(gerencia_part/cont);
            gravaEditaAvaliacao(avaliacaoModelo, 888, ado);
        
   }
   
   public double calculaNotaCorrigidaGestorInvertido(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
                coerencia=0, ger_objetivos=0, desenv_pessoas=0, lideranca=0, ger_part=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador=888"+
                " and mat_avaliado="+ado);
        try {
            conecta.rs.first();
            conhecTec=(conecta.rs.getDouble("conhecimento_tecnico")*(0.01667/5));
            usoFerramenta=(conecta.rs.getDouble("uso_ferramentas")*(0.01667/5));
            conhecLegisl=(conecta.rs.getDouble("conhecimento_legislacao")*(0.01667/5));
            conhecNormas=(conecta.rs.getDouble("conhecimentos_normas")*(0.01667/5));
            melhoriaContinua=(conecta.rs.getDouble("melhoria_continua")*(0.01667/5));
            produtividade=(conecta.rs.getDouble("produtividade")*(0.01667/5));
            garantiaQualidade=(conecta.rs.getDouble("garantia_qualidade")*(0.01667/5));
            organizacao=(conecta.rs.getDouble("organizacao")*(0.01667/5));
            analiseRiscos=(conecta.rs.getDouble("analise_riscos")*(0.01667/5));
            satisfacaoUsuario=(conecta.rs.getDouble("satisfacao_usuario")*(0.01667/5));
            sensoUrgencia=(conecta.rs.getDouble("senso_urgencia")*(0.01667/5));
            resolucaoProblemas=(conecta.rs.getDouble("resolucao_problemas")*(0.01667/5));
            resultadoTrabalho=(conecta.rs.getDouble("resultado_trabalho")*(0.01667/5));
            comprometimento=(conecta.rs.getDouble("comprometimento")*(0.01667/5));
            flexibilidade=(conecta.rs.getDouble("flexibilidade")*(0.01667/5));
            eficienciaComunicao=(conecta.rs.getDouble("eficiencia_comunicacao")*(0.01667/5));
            cordialidadeRespeito=(conecta.rs.getDouble("cordialidade_respeito")*(0.01667/5));
            espiritoEquipe=(conecta.rs.getDouble("espirito_equipe")*(0.01667/5));
            admConflito=(conecta.rs.getDouble("administracao_conflitos")*(0.01667/5));
            respeitoIndividualidade=(conecta.rs.getDouble("respeito_individualidade")*(0.01667/5));
            coerencia=(conecta.rs.getDouble("coerencia")*(0.03333/5));
            ger_objetivos=(conecta.rs.getDouble("gerencia_objetivos")*(0.03335/5));
            desenv_pessoas=(conecta.rs.getDouble("desenvolvimento_pessoas")*(0.03335/5));
            lideranca=(conecta.rs.getDouble("lideranca")*(0.03335/5));
            ger_part=(conecta.rs.getDouble("gerencia_participativa")*(0.03335/5));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=conhecTec+usoFerramenta+conhecLegisl+conhecNormas+melhoriaContinua+
                produtividade+ garantiaQualidade+ organizacao+ analiseRiscos+ satisfacaoUsuario+
                sensoUrgencia+ resolucaoProblemas+ resultadoTrabalho+ comprometimento+ flexibilidade+
                 eficienciaComunicao+ cordialidadeRespeito+ espiritoEquipe+ admConflito+ respeitoIndividualidade+
                coerencia+ger_objetivos+desenv_pessoas+lideranca+ger_part;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update nota_corrigida set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, total_corrigida=?, coerencia=?, gerencia_objetivos=?,"
                    + " desenvolvimento_pessoas=?, lideranca=?, gerencia_participativa=? WHERE nota_corrigida.Mat_Avaliador = 888 "
                    + "AND nota_corrigida.Mat_Avaliado = ?");
            
            pst.setDouble(1, conhecTec);
            pst.setDouble(2, usoFerramenta);
            pst.setDouble(3, conhecNormas);
            pst.setDouble(4, melhoriaContinua);
            pst.setDouble(5, produtividade);
            pst.setDouble(6, garantiaQualidade);
            pst.setDouble(7, organizacao);
            pst.setDouble(8, analiseRiscos);
            pst.setDouble(9, satisfacaoUsuario);
            pst.setDouble(10, sensoUrgencia);
            pst.setDouble(11, resolucaoProblemas);
            pst.setDouble(12, resultadoTrabalho);
            pst.setDouble(13, comprometimento);
            pst.setDouble(14, flexibilidade);
            pst.setDouble(15, eficienciaComunicao);
            pst.setDouble(16, cordialidadeRespeito);
            pst.setDouble(17, espiritoEquipe);
            pst.setDouble(18, admConflito);
            pst.setDouble(19, respeitoIndividualidade);
            pst.setDouble(20, conhecLegisl);
            pst.setDouble(21, total);
            pst.setDouble(22, coerencia);
            pst.setDouble(23, ger_objetivos);
            pst.setDouble(24, desenv_pessoas);
            pst.setDouble(25, lideranca);
            
            pst.setDouble(26, ger_part);
            pst.setInt(27, ado);
            
            pst.executeLargeUpdate();
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaInvertidaTF(ado, total);
        
        return total;
    
    }
   
    public double calculaNotaCorrigidaGestorGestor(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
                coerencia=0, ger_objetivos=0, desenv_pessoas=0, lideranca=0, ger_part=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
        try {
            conecta.rs.first();
            conhecTec=(conecta.rs.getInt("conhecimento_tecnico")*(0.1/5));
            usoFerramenta=(conecta.rs.getInt("uso_ferramentas")*(0.1/5));
            conhecLegisl=(conecta.rs.getInt("conhecimento_legislacao")*(0.1/5));
            conhecNormas=(conecta.rs.getInt("conhecimentos_normas")*(0.1/5));
            melhoriaContinua=(conecta.rs.getInt("melhoria_continua")*(0.1/5));
            produtividade=(conecta.rs.getInt("produtividade")*(0.1/5));
            garantiaQualidade=(conecta.rs.getInt("garantia_qualidade")*(0.1/5));
            organizacao=(conecta.rs.getInt("organizacao")*(0.1/5));
            analiseRiscos=(conecta.rs.getInt("analise_riscos")*(0.1/5));
            satisfacaoUsuario=(conecta.rs.getInt("satisfacao_usuario")*(0.1/5));
            sensoUrgencia=(conecta.rs.getInt("senso_urgencia")*(0.1/5));
            resolucaoProblemas=(conecta.rs.getInt("resolucao_problemas")*(0.1/5));
            resultadoTrabalho=(conecta.rs.getInt("resultado_trabalho")*(0.1/5));
            comprometimento=(conecta.rs.getInt("comprometimento")*(0.1/5));
            flexibilidade=(conecta.rs.getInt("flexibilidade")*(0.1/5));
            eficienciaComunicao=(conecta.rs.getInt("eficiencia_comunicacao")*(0.1/5));
            cordialidadeRespeito=(conecta.rs.getInt("cordialidade_respeito")*(0.1/5));
            espiritoEquipe=(conecta.rs.getInt("espirito_equipe")*(0.1/5));
            admConflito=(conecta.rs.getInt("administracao_conflitos")*(0.1/5));
            respeitoIndividualidade=(conecta.rs.getInt("respeito_individualidade")*(0.1/5));
            coerencia=(conecta.rs.getInt("coerencia")*(0.2/5));
            ger_objetivos=(conecta.rs.getInt("gerencia_objetivos")*(0.2/5));
            desenv_pessoas=(conecta.rs.getInt("desenvolvimento_pessoas")*(0.2/5));
            lideranca=(conecta.rs.getInt("lideranca")*(0.2/5));
            ger_part=(conecta.rs.getInt("gerencia_participativa")*(0.2/5));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=conhecTec+usoFerramenta+conhecLegisl+conhecNormas+melhoriaContinua+
                produtividade+ garantiaQualidade+ organizacao+ analiseRiscos+ satisfacaoUsuario+
                sensoUrgencia+ resolucaoProblemas+ resultadoTrabalho+ comprometimento+ flexibilidade+
                 eficienciaComunicao+ cordialidadeRespeito+ espiritoEquipe+ admConflito+ respeitoIndividualidade+
                coerencia+ger_objetivos+desenv_pessoas+lideranca+ger_part;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update nota_corrigida set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, total_corrigida=?, coerencia=?, gerencia_objetivos=?,"
                    + " desenvolvimento_pessoas=?, lideranca=?, gerencia_participativa=? WHERE nota_corrigida.Mat_Avaliador =? "
                    + "AND nota_corrigida.Mat_Avaliado = ?");
            pst.setDouble(1, conhecTec);
            pst.setDouble(2, usoFerramenta);
            pst.setDouble(3, conhecNormas);
            pst.setDouble(4, melhoriaContinua);
            pst.setDouble(5, produtividade);
            pst.setDouble(6, garantiaQualidade);
            pst.setDouble(7, organizacao);
            pst.setDouble(8, analiseRiscos);
            pst.setDouble(9, satisfacaoUsuario);
            pst.setDouble(10, sensoUrgencia);
            pst.setDouble(11, resolucaoProblemas);
            pst.setDouble(12, resultadoTrabalho);
            pst.setDouble(13, comprometimento);
            pst.setDouble(14, flexibilidade);
            pst.setDouble(15, eficienciaComunicao);
            pst.setDouble(16, cordialidadeRespeito);
            pst.setDouble(17, espiritoEquipe);
            pst.setDouble(18, admConflito);
            pst.setDouble(19, respeitoIndividualidade);
            pst.setDouble(20, conhecLegisl);
            pst.setDouble(21, total);
            pst.setDouble(22, coerencia);
            pst.setDouble(23, ger_objetivos);
            pst.setDouble(24, desenv_pessoas);
            pst.setDouble(25, lideranca);
            
            pst.setDouble(26, ger_part);
            pst.setInt(27, ador);
            pst.setInt(28, ado);
            
            pst.executeUpdate();
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
        TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaGestorTF(ado, total);
        
        
        return total;
    
    }
  
   public double calculaNotaCorrigidaAutoGestor(AvaliacaoModel avaliacaoModelo, int ador, int ado){
        conecta.conexao();
        double conhecTec=0, usoFerramenta=0, conhecLegisl=0, conhecNormas=0, melhoriaContinua=0,
                produtividade=0, garantiaQualidade=0, organizacao=0, analiseRiscos=0, satisfacaoUsuario=0,
                sensoUrgencia=0, resolucaoProblemas=0, resultadoTrabalho=0, comprometimento=0, flexibilidade=0,
                 eficienciaComunicao=0, cordialidadeRespeito=0, espiritoEquipe=0, admConflito=0, respeitoIndividualidade=0,
                coerencia=0, ger_objetivos=0, desenv_pessoas=0, lideranca=0, ger_part=0;
        conecta.executaPesquisaSQL("Select * from avaliacao where mat_avaliador="+ador+
                " and mat_avaliado="+ado);
        try {
            conecta.rs.first();
            conhecTec=(conecta.rs.getInt("conhecimento_tecnico")*(0.01667/5));
            usoFerramenta=(conecta.rs.getInt("uso_ferramentas")*(0.01667/5));
            conhecLegisl=(conecta.rs.getInt("conhecimento_legislacao")*(0.01667/5));
            conhecNormas=(conecta.rs.getInt("conhecimentos_normas")*(0.01667/5));
            melhoriaContinua=(conecta.rs.getInt("melhoria_continua")*(0.01667/5));
            produtividade=(conecta.rs.getInt("produtividade")*(0.01667/5));
            garantiaQualidade=(conecta.rs.getInt("garantia_qualidade")*(0.01667/5));
            organizacao=(conecta.rs.getInt("organizacao")*(0.01667/5));
            analiseRiscos=(conecta.rs.getInt("analise_riscos")*(0.01667/5));
            satisfacaoUsuario=(conecta.rs.getInt("satisfacao_usuario")*(0.01667/5));
            sensoUrgencia=(conecta.rs.getInt("senso_urgencia")*(0.01667/5));
            resolucaoProblemas=(conecta.rs.getInt("resolucao_problemas")*(0.01667/5));
            resultadoTrabalho=(conecta.rs.getInt("resultado_trabalho")*(0.01667/5));
            comprometimento=(conecta.rs.getInt("comprometimento")*(0.01667/5));
            flexibilidade=(conecta.rs.getInt("flexibilidade")*(0.01667/5));
            eficienciaComunicao=(conecta.rs.getInt("eficiencia_comunicacao")*(0.01667/5));
            cordialidadeRespeito=(conecta.rs.getInt("cordialidade_respeito")*(0.01667/5));
            espiritoEquipe=(conecta.rs.getInt("espirito_equipe")*(0.01667/5));
            admConflito=(conecta.rs.getInt("administracao_conflitos")*(0.01667/5));
            respeitoIndividualidade=(conecta.rs.getInt("respeito_individualidade")*(0.01667/5));
            coerencia=(conecta.rs.getInt("coerencia")*(0.03333/5));
            ger_objetivos=(conecta.rs.getInt("gerencia_objetivos")*(0.03335/5));
            desenv_pessoas=(conecta.rs.getInt("desenvolvimento_pessoas")*(0.03335/5));
            lideranca=(conecta.rs.getInt("lideranca")*(0.03335/5));
            ger_part=(conecta.rs.getInt("gerencia_participativa")*(0.03335/5));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro, motivo:"+ex);
        } finally {
            conecta.desconecta();
        }
        
        double total=conhecTec+usoFerramenta+conhecLegisl+conhecNormas+melhoriaContinua+
                produtividade+ garantiaQualidade+ organizacao+ analiseRiscos+ satisfacaoUsuario+
                sensoUrgencia+ resolucaoProblemas+ resultadoTrabalho+ comprometimento+ flexibilidade+
                 eficienciaComunicao+ cordialidadeRespeito+ espiritoEquipe+ admConflito+ respeitoIndividualidade+
                coerencia+ger_objetivos+desenv_pessoas+lideranca+ger_part;
        
        PreparedStatement pst;
        conecta.conexao();
        try { 
            pst=conecta.conn.prepareStatement("Update nota_corrigida set Conhecimento_tecnico = ?," 
                    + "Uso_ferramentas = ?, Conhecimentos_normas = ?, Melhoria_Continua = ?,"
                    + " Produtividade = ?, Garantia_qualidade = ?, Organizacao = ?, "
                    + " Analise_Riscos = ?, Satisfacao_Usuario = ?, Senso_Urgencia = ?, "
                    + "Resolucao_problemas = ?, Resultado_Trabalho = ?, Comprometimento = ?,"
                    + " Flexibilidade = ?, Eficiencia_Comunicacao = ?, Cordialidade_Respeito = ?,"
                    + " Espirito_Equipe = ?, Administracao_conflitos = ?, Respeito_Individualidade = ?,"
                    + " Conhecimento_legislacao = ?, total_corrigida=?, coerencia=?, gerencia_objetivos=?,"
                    + " desenvolvimento_pessoas=?, lideranca=?, gerencia_participativa=? WHERE nota_corrigida.Mat_Avaliador ="+ador
                    + " AND nota_corrigida.Mat_Avaliado = ?");
            pst.setDouble(1, conhecTec);
            pst.setDouble(2, usoFerramenta);
            pst.setDouble(3, conhecNormas);
            pst.setDouble(4, melhoriaContinua);
            pst.setDouble(5, produtividade);
            pst.setDouble(6, garantiaQualidade);
            pst.setDouble(7, organizacao);
            pst.setDouble(8, analiseRiscos);
            pst.setDouble(9, satisfacaoUsuario);
            pst.setDouble(10, sensoUrgencia);
            pst.setDouble(11, resolucaoProblemas);
            pst.setDouble(12, resultadoTrabalho);
            pst.setDouble(13, comprometimento);
            pst.setDouble(14, flexibilidade);
            pst.setDouble(15, eficienciaComunicao);
            pst.setDouble(16, cordialidadeRespeito);
            pst.setDouble(17, espiritoEquipe);
            pst.setDouble(18, admConflito);
            pst.setDouble(19, respeitoIndividualidade);
            pst.setDouble(20, conhecLegisl);
            pst.setDouble(21, total);
            pst.setDouble(22, coerencia);
            pst.setDouble(23, ger_objetivos);
            pst.setDouble(24, desenv_pessoas);
            pst.setDouble(25, lideranca);
            
            pst.setDouble(26, ger_part);
            pst.setInt(27, ado);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro, ao incluir nota corrigida, motivo: \n"+ex);
        } finally {
            conecta.desconecta();
        }
         TabelaFinalControl tabelaFinal = new TabelaFinalControl(bancoOf);
        tabelaFinal.editaNotaCorrigidaAutoTF(ado, total);
                
        return total;
       
    
    }
    
}



