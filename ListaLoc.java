
package route;

import java.util.*;
import java.io.*;

public class ListaLoc implements Serializable, Cloneable{
    private HashMap listaLoc;
    
    /**
     * Constructor Vazio
     */
    public ListaLoc() {
        this.listaLoc = new HashMap();
    }
    
    /**
     * Constructor Completo
     */
    public ListaLoc(HashMap listaLoc) {
        this.listaLoc = (HashMap) listaLoc.clone();
    }
    
    /**
     * Devolve a lista de localizaceos sob a forma de HashMap
     */
    public HashMap getlistaLoc() {
        return this.listaLoc; 
    }
    
    /**
     * Insere uma localidade na lista de localidades
     */
    public void inserir(Localidade loc) {
        this.listaLoc.put(loc.getnomeLocalidade(),loc);
    }
    
    /**
     * Remove uma localidade da lista de localidades
     */
    public void remover(String nome) throws LocNaoExiste{
         if (!(listaLoc.containsKey(nome)))
                throw new LocNaoExiste(nome);
         this.listaLoc.remove(nome);
    }
    
    /**
     * Procura uma localidade na lista de localidades
     */
    public Localidade procurar(String nome) throws LocNaoExiste {
        if (!(listaLoc.containsKey(nome)))
                throw new LocNaoExiste(nome);
        return (Localidade) this.listaLoc.get(nome);
    }
    
    /**
     * Retorna todas as localidades
     */
    public Collection values(){
        return this.listaLoc.values();
    }
    
    /**
     * Cria uma nova lista de localidades igual
     */
    public Object clone(){
        return new ListaLoc(this.getlistaLoc());
    }
     
    /**
     * Passa a lista de localidades para String
     */
    public String toString() {   
        StringBuffer s = new StringBuffer();
        s.append("Lista de Localidades:\n");
        for(Iterator it = (this.listaLoc.values()).iterator();it.hasNext();) {
            Object item = it.next();
            s.append(((Localidade) item).toString());
        }
         return s.toString();
    }
}




