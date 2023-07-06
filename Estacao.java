

package route;

import java.util.*;
import java.io.*;

public class Estacao implements Serializable{

    public String nomeEstacao;
    public int kilometro;
    
    public Estacao ()
    {
        this.nomeEstacao="";
        this.kilometro=0;
    }
    
    public Estacao(String nomeEstacao,int kilometro)
    {
        this.nomeEstacao=nomeEstacao;
        this.kilometro=kilometro;
    }
    
    /**
     * Sets the nomeEstacao property.
     *
     * @param  nomeEstacao  the new value for nomeEstacao
     */
    public void setnomeEstacao(String nomeEstacao)
    {
        this.nomeEstacao=nomeEstacao;
    }
    
    public String getnomeEstacao()
    {
        return this.nomeEstacao;
    }
    public void setkilometro(int kilometro)
    {
        this.kilometro=kilometro;
    }
    
    public int getkilometro()
    {
        return this.kilometro;
    }
    
    
     /**
      * Convert the object to a string representation.
      *
      * @return         	A string representation of the object.
      */
     public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Nome: "+nomeEstacao+"\n");
        s.append("KM em que se situa "+kilometro+"\n");
        
        return s.toString();
    }

    public Object clone()
    {
        return new Estacao(this.getnomeEstacao(),this.getkilometro());
    }
}
