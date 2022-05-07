package tables;

import control_tables.ListaMenuRecursosHumanos;
import model_tables.ListaGerenciaModel;
import model_tables.ListaMenuGerhumModel;
import model_tables.TabelaControleModel;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

public class TabelaTelaControle extends AbstractTableModel {

    private final String[] nomescolunas = {
        "Matrícula",
        "Nome",
        "Cargo",
        "Status"
    };

    private final List<TabelaControleModel> mList;

    public TabelaTelaControle(List<TabelaControleModel> pList) {
        mList = pList;

    }

    public TabelaTelaControle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    @Override
    public int getColumnCount() {
        return nomescolunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {

            case 0:
                return mList.get(linha).getMat();
            case 1:
                return mList.get(linha).getNome();
            case 2:
                return mList.get(linha).getCargo();
            case 3:
                return mList.get(linha).getStatus();
        }
        return 0;
    }

    @Override
    public String getColumnName(int indice) {
        return nomescolunas[indice];
    }

    public Class getColClass(int coluna) {
        switch (coluna) {

            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;

        }
        return null;
    }

//    public VisaoTabelaAlteracaoModel getObjeto (int linha){
//        VisaoTabelaAlteracaoModel visaoLinha = new VisaoTabelaAlteracaoModel();
//        visaoLinha.setDataEvento(mList.get(linha).getDataEvento());
//        visaoLinha.setAprovacaoGerencia(mList.get(linha).());
//        visaoLinha.setAprovacaoDepartamento(mList.get(linha).isAprovacaoDepartamento());
//        visaoLinha.setAprovacaoDiretoria(mList.get(linha).isAprovacaoDiretoria());
//        visaoLinha.setRecebimentoRH(mList.get(linha).isRecebimentoRH());
//        visaoLinha.setAnexo(mList.get(linha).isAnexo());
//        
//        return visaoLinha;
//    }
    //FAZER METODOS PARA PERSONALIZAAR A TABLE
}
