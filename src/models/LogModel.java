
package models;


public class LogModel {
   private int avaliador;
   private int avaliado;
   private String data;
   private String ip;

    /**
     * @return the avaliador
     */
    public int getAvaliador() {
        return avaliador;
    }

    /**
     * @param avaliador the avaliador to set
     */
    public void setAvaliador(int avaliador) {
        this.avaliador = avaliador;
    }

    /**
     * @return the avaliado
     */
    public int getAvaliado() {
        return avaliado;
    }

    /**
     * @param avaliado the avaliado to set
     */
    public void setAvaliado(int avaliado) {
        this.avaliado = avaliado;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
   
    
    
}
