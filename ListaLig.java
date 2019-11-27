
package route;

import java.util.*;
import java.io.*;

public class ListaLig implements Serializable
{
    private HashMap listaLig;
    
    public ListaLig()
    {
        this.listaLig = new HashMap();
    }
    
    public ListaLig(HashMap listaLig)
    {
        this.listaLig = (HashMap) listaLig.clone();
    }

    public HashMap getlistaLig()
    {
        return this.listaLig; 
    }
    
    public void inserir(Ligacoes lig)
    {   
        this.listaLig.put(lig.getNome(),lig);
    }
    
    /**
     * Remove a ligacao com um determinado nome dado com parametro
     */
     public void remover(String nome) {
         this.listaLig.remove(nome);
    }
    
    /**
     * Remove uma lista de ligacoes
     */
     public void remover(Collection candidatos){   
        ArrayList cand = new ArrayList();
        cand.addAll(candidatos);
        for (int i = 0 ; i < cand.size() ; i++)
            this.listaLig.remove(( (Ligacoes) cand.get(i)).getNome());
     }
    
     /**
      * Retorna todas as liga?oes
      */
     public Collection values(){
        return this.listaLig.values();
     }
    
    /**
     * Recebe o nome de uma localiza?ao e retorna essa mesma ligacao
     */
    public Ligacoes procurarNome(String nome) throws LigNaoExiste {
        if (!(listaLig.containsKey(nome)))
                throw new LigNaoExiste(nome);
    
        return (Ligacoes)this.listaLig.get(nome);
    }
    
    /**
     * Retorna o conjunto de chaves
     */
    
    public boolean contemChave(String key) {
        return this.listaLig.containsKey(key);
    }
    
    
    /**
     * Recebe o nome de uma localidade e d‡ a lista de liga?›es que partem daquela localidade
     */
    
    public Collection procuraPartidas(String partida) {
       Ligacoes lig;
       ArrayList ligOk = new ArrayList();
       for(Iterator it = listaLig.values().iterator(); it.hasNext();) {
          lig = (Ligacoes) it.next();
           if( (lig.getPartida()).equals(partida) )
                ligOk.add(lig.clone());
       }
       return ligOk;
     }
     
    /**
     * Recebe o nome de uma localidade e d‡ a lista de liga?›es que chegam  aquela localidade
     */
    
    public Collection procuraChegadas(String chegada) {
       Ligacoes lig;
       ArrayList ligOk = new ArrayList();
       for(Iterator it = listaLig.values().iterator(); it.hasNext();) {
          lig = (Ligacoes) it.next();
           if( (lig.getDestino()).equals(chegada) )
                ligOk.add(lig.clone());
       }
       return ligOk;
     }
     
     /**
      * Recebe o nome da localidade de destino e da localidade de partida e d‡ a  liga?ao directas
      */
     
     public String procuraLigDir(String partida, String destino) {
         Ligacoes lig;
         String ret = "";
         ArrayList ligOk = new ArrayList();
         for(Iterator it = listaLig.values().iterator(); it.hasNext();) {
          lig = (Ligacoes) it.next();
           if( (lig.getDestino()).equals(destino) && (lig.getPartida()).equals(partida))
               ret = ((Ligacoes) lig.clone()).getNome();
            }
         return ret;   
     }
    
     /**
      * Da o conjunto de localidades adjacentes
      */
     
     public Collection adjacentes(String localidade) {
       Ligacoes lig;
       ArrayList ligOk = new ArrayList();
       for(Iterator it = listaLig.values().iterator(); it.hasNext();) {
          lig = (Ligacoes) it.next();
           if( (lig.getPartida()).equals(localidade) )
                ligOk.add( ((Ligacoes) lig.clone()).getDestino());
       }
       return ligOk;
     }
     
     public Object clone()
     {
        return new ListaLig(this.getlistaLig());
     }
    
     public String toString()
    {   
        StringBuffer s = new StringBuffer();
        s.append("Lista de Ligacoes: \n");
        for(Iterator it = (this.listaLig.values()).iterator();it.hasNext(); )
        {
            Ligacoes item = (Ligacoes) it.next();
            s.append(((Ligacoes) item).toString());
        }
         return s.toString();
    }
}




