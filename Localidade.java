package route;

import java.util.*;
import java.io.*;

public abstract class Localidade implements Serializable
{
    private String nomeLocalidade; 
    private String nomeDistrito; 
    private int numeroHabitantes;
    private ListaPOI listaPOI;
    
    /**
     * Constructor Vazio
     */
    public Localidade(){
        this.nomeLocalidade="";
        this.nomeDistrito="";
        this.numeroHabitantes=0;
        this.listaPOI=new ListaPOI();
    }
    
    /**
     * Constructor Completo
     */
    public Localidade(String nomeLocalidade,String nomeDistrito,int numeroHabitantes,ListaPOI listaPOI) {
        this.nomeLocalidade=nomeLocalidade;
        this.nomeDistrito=nomeDistrito;
        this.numeroHabitantes=numeroHabitantes;
        this.listaPOI = (ListaPOI) listaPOI.clone();
    }
    
    /**
     * Define o nome da Localidade
     */
    
    public void setnomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade=nomeLocalidade;
    }
    
    /**
     * Devolve o nome da Localidade
     */
    public String getnomeLocalidade() {
        return this.nomeLocalidade;
    }
    
    /**
     * Define o nome do Distrito
     */
    public void setnomeDistrito(String nomeDistrito) {
        this.nomeDistrito=nomeDistrito;
    }
    
    /**
     * Devolve o nome do Distrito
     */
    public String getnomeDistrito() {
        return this.nomeDistrito;
    }
    
    /**
     * Define o numero de Habitantes da localidade
     */
    public void setnumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes=numeroHabitantes;
    }
    
    /**
     * Devolve o numero de Habitantes da localidade
     */
    public int getnumeroHabitantes() {
        return this.numeroHabitantes;
    }
    
    /**
     * Devolve a Lista de Pontos de Interesse
     */
    public ListaPOI getlistaPOI() {
        return this.listaPOI;
    }
    
    /**
     * Define a Lista de Pontos de Interesse
     */
    public void setlistaPOI(ListaPOI listaPOI) {
        this.listaPOI=listaPOI;
    }
    
    /**
     * Inserir ponto de interesse na lista de pontos de interesse
     */
    public void inserirlistaPOI(POI poi) {
        this.listaPOI.inserir(poi);
    }
    
    /**
     * Remove um ponto de Interesse da Lista de Pontos de Interesse
     * Recebe como parametro o nome da Localidade
     */
    public void removerpoi(String nomeLocalidade) throws POInaoExiste{
         this.listaPOI.remover(nomeLocalidade);
    }

    /**
     * Passa para String a Localidade
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Nome da Localidade: "+nomeLocalidade+"\n");
        s.append("Nome do Distrito: "+nomeDistrito+"\n");
        s.append("Numero de Habitantes"+numeroHabitantes+"\n");
        s.append(listaPOI+"\n");
        return s.toString();
    }
    
}
