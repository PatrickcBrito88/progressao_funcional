
package control;

import java.util.ArrayList;


public class ListaBancoControl {
    
    public ArrayList<String> getListaBanco (){
        ArrayList<String> lista = new ArrayList();
        
        //lista.add("Avaliações realizadas em 2022 (Referentes a 2021)");
        lista.add("Avaliações realizadas em 2021 (Referentes a 2020)");
        lista.add("Avaliações realizadas em 2020 (Referentes a 2019)");
        lista.add("Avaliações realizadas em 2019 (Referentes a 2018)");
        
        return lista;
    }
}
