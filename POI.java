package route;

import java.util.*;
import java.io.*;

public class POI implements Serializable {

    public String designacao;
    public String epocaremontao;
    public int datafund;
    
    /**
     * Constructor Vazio
     */
    
    public POI (){
        this.designacao="";
        this.epocaremontao="";
        this.datafund=0;
    }
    
    /**
     * Constructor Completo
     */
    public POI(String designacao,String epocaremontao,int datafund) {
        this.designacao=designacao;
        this.epocaremontao=epocaremontao;
        this.datafund=datafund;
    }
    
    
    /**
     * Define o nome do Ponto de Interesse
     */
    public void setdesignacao(String designacao) {
         this.designacao=designacao;
    }
    
    /**
     * Da o nome do Ponto de Interesse
     */
    public String getdesignacao() {
        return this.designacao;
    }
    
    /**
     * Define a epoca a que remonta
     */
    public void setepocaremontao(String epocaremontao) {
        this.epocaremontao=epocaremontao;
    }
    
    /**
     * Devolve a epoca a que o ponto de interesse remonta
     */
    public String getepocaremontao() {
        return this.epocaremontao;
    }
    
    /**
     * Define a data em que o POI foi fundada
     */
    public void setdatafund(int datafund) {
        this.datafund=datafund;
    }
    
    /**
     * Devolve a data de fundacao do POI
     */
    public int getdatafund() {
        return this.datafund;
    }
    
    /**
     * Passa para string o ponto de interesse
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Designacao: "+designacao+"\n");
        s.append("Epoca para que remonta: "+epocaremontao+"\n");
        s.append("Data de fundacao: "+ datafund+"\n");
        return s.toString();
    }

    /**
     * Devolve o clone do Ponto de Interesse
     */
    public Object clone() {
        return new POI(this.getdesignacao(),this.getepocaremontao(),this.getdatafund());
    }

}