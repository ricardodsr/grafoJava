package route;

import java.util.*;
import java.io.*;
public class ListaPOI implements Serializable
{
    
    private HashMap listaPOI; 

/**
 * Constructor Vazio
 */
    public ListaPOI()
    {
        this.listaPOI = new HashMap();
    }

/**
 * Constructor Completo
 */
    public ListaPOI(HashMap listaPOI)
    {
        this.listaPOI = (HashMap) listaPOI.clone();
    }

/**
 * Retorno a lista de Pontos de Interesse 
 */    
    
    public HashMap getlistaPOI()
    {
        return this.listaPOI; 
    }
    
    public boolean vazia() {
        return this.listaPOI.isEmpty();
    }
    
/**
 * Insere um novo Ponto de Interesse na Lista
 */
    public void inserir(POI poi)
    {
        this.listaPOI.put(poi.getdesignacao().toLowerCase(),poi);
    }

/**
 * Remove da lista de Pontos de Interessa um ponto
 */    
     public void remover(String nomeLocalidade) throws POInaoExiste {
         if (!(listaPOI.containsKey(nomeLocalidade)))
                throw new POInaoExiste(nomeLocalidade);
         this.listaPOI.remove(nomeLocalidade);
     }

/**
 * Procura um Ponto de interesse recebendo a designacao
 */
     public POI procurar(String designacao) throws POInaoExiste {
         if (!(listaPOI.containsKey(designacao)))
                throw new POInaoExiste(designacao);
        return (POI) listaPOI.get(designacao.toLowerCase());
     }
        
/**
 * Cria um clone da Lista de Pontos de Interesse
 */
     public Object clone() {
        return new ListaPOI(this.getlistaPOI());
     }

/**
 * Passa para string a lista de Ponto de Interesse
 */
     public String toString() {   
        StringBuffer s = new StringBuffer();
        s.append("\n");
        for(Iterator it = (this.listaPOI.values()).iterator();it.hasNext(); ) {
            POI item = (POI) it.next();
            s.append(((POI) item).toString());
        }
        return s.toString();
     }
}
