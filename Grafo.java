
package route;

import java.io.*;
import java.util.*;

public class Grafo implements Serializable{

private ListaLoc vertex;
private ListaLig edges;
    
    /**
     * Constructor GRAFO Vazio
     */
    public Grafo(){
        this.vertex = new ListaLoc();
        this.edges = new ListaLig();
    }

    
    /**
     * Constructor Grafo Completo
     */
    public Grafo(ListaLoc vertex, ListaLig edges) {
        this.vertex=vertex;
        this.edges=edges;
    }
    
    public ListaLoc getVertex() {
        return this.vertex;
    }
    
    public ListaLig getEdges() {
        return this.edges;
    }
    
    /**
     * Insere uma Localidade
     */
    public void insertvertex(Localidade loc) {
        vertex.inserir(loc);
    }

    /** 
     * Insere uma liga?ao
     */
    public void insertedges(Ligacoes lig) {
        edges.inserir(lig);
    }
    

    /**
     * Remove uma localidade pelo nome
     */

    public void removevertex (String nomeloc) throws LocNaoExiste {
        vertex.remover(nomeloc);
        edges.remover(edges.procuraPartidas(nomeloc));
        edges.remover(edges.procuraChegadas(nomeloc));
    }


    /**
     * Remove uma ligacao pelo nome
     */

    public void removeedge (String nome) {
    edges.remover(nome); 
    }

    /**
     * Calculo do grafo (Shortest path), implementando o algoritmo de Dijkstra, dando o caminho mais curto em KM
     */
    public ArrayList sp(String partida, String chegada) throws LigNaoExiste {
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!(x.equals(chegada)) && !stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm()))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm())));
                 
                    }
                
                }
            }
        
            for(int i = 0; i< adjacentes.size();i++) {
                String aux = (String) adjacentes.get(i);
                if(!(orla.contains(aux))) {
                    if(!(caminho.contains(aux))) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        orla.add(aux);
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux,(((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm())));
                    }
                }
         
            }
            if(candidatos.isEmpty()) stuck = true;
            else {
                String aux2 = procuracand(candidatos,dist);
                String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                x=aux;
                if(!(caminho.contains(x))) caminho.add(x);
                if(!(T.contains(aux2))) T.add(aux2);
                for( int i = 0; i<orla.size(); i++) {
                    if(orla.get(i).equals(x)) orla.remove(x);
                }
            
            candidatos.remove(aux);
            }
        }
        return filtra(T);
    }

    private String procuracand (HashMap candidatos, HashMap dist) throws LigNaoExiste {
        String aux = "";
        Integer temp = Integer.MAX_VALUE;
        for(Iterator it=candidatos.values().iterator();it.hasNext();) {
            String aux1 = (String) it.next();
            String aux2 = (edges.procurarNome(aux1).getDestino());
            if(((Integer) dist.get(aux2))<temp) {
                temp=(Integer) dist.get(aux2); 
                aux = aux1;
            }
        }
    return aux;
    }

    /**
     *  Filtra o grafo apresentado, de modo a dar o caminho mais directo.
     */

    public ArrayList filtra(ArrayList caminho) throws LigNaoExiste{
        ArrayList invertido = reverte(caminho);
        ArrayList filtrados = new ArrayList();
    
        String destinoAux = (edges.procurarNome((String) invertido.get(0))).getDestino();

        for(int i = (((int) caminho.size()) - 1); i>=0; i--) {       
                if (destinoAux.equals(edges.procurarNome((String) caminho.get(i)).getDestino())) {
                    filtrados.add(caminho.get(i)); // adiciona a solucao
                    destinoAux = (edges.procurarNome((String) caminho.get(i))).getPartida(); // actualiza novo destino
                    
                }
                else { caminho.remove(i);  
                } 
                
        }
    
    return reverte(filtrados);
    }
    
    /**
     * Metodo auxiliar que permite inverter um array
     */

    public ArrayList reverte(ArrayList lista) {
        ArrayList revertida = new ArrayList();
        int j=0;
            for(int i = (((int) lista.size()) - 1); i>=0; i--) {
                revertida.add(j,lista.get(i));
                j++;
            }
            return revertida;
    }
            
    /**
     * Calculo do grafo (Shortest path), implementando o algoritmo de Dijkstra, dando o caminho mais rapido
     */

    public ArrayList spTempo(String partida, String chegada) throws LigNaoExiste {
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!(x.equals(chegada)) && !stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).gettempoMedio()))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).gettempoMedio())));
                 
                    }
                
                }
            }
        
            for(int i = 0; i< adjacentes.size();i++) {
                String aux = (String) adjacentes.get(i);
                if(!(orla.contains(aux))) {
                    if(!(caminho.contains(aux))) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        orla.add(aux);
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux,(((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).gettempoMedio())));
                    
                    }
                }
         
            }
            if(candidatos.isEmpty()) stuck = true;
            else {
                String aux2 = procuracand(candidatos,dist);
                String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                x=aux;
                if(!(caminho.contains(x))) caminho.add(x);
                if(!(T.contains(aux2))) T.add(aux2);
                for( int i = 0; i<orla.size(); i++) {
                    if(orla.get(i).equals(x)) orla.remove(x);
                }
            
                candidatos.remove(aux);
            }
        }
        return filtra(T);
    }
     
    
    /**
     * Ler de file objecto
     */
    
     public void lerDeObj(String fich) {
     try{
          StringBuffer s = new StringBuffer();
          s.append(fich+".vertex");
          StringBuffer s2 = new StringBuffer();
          s2.append(fich+".edges");   
          ObjectInputStream oin =
                        new ObjectInputStream( new FileInputStream(s.toString()));
           ObjectInputStream oin2 =
                        new ObjectInputStream( new FileInputStream(s2.toString()));
                        this.vertex = (ListaLoc) oin.readObject();
                        oin.close();
                        this.edges = (ListaLig) oin2.readObject();
                        oin2.close();
         
                    }
                 catch(IOException e) {
                     System.out.println(e.getMessage()); }
                 catch(ClassNotFoundException e) {
                     System.out.println(e.getMessage()); }
      }
      /**
       * Grava o grafo em ficheiro objecto
       */
    
      public void gravaEmObjStream(String fich) {
      try {
          StringBuffer s = new StringBuffer();
          s.append(fich+".vertex");
          StringBuffer s2 = new StringBuffer();
          s2.append(fich+".edges");
          ObjectOutputStream oout2 = 
            new ObjectOutputStream(new FileOutputStream(s2.toString()));
          ObjectOutputStream oout = 
            new ObjectOutputStream(new FileOutputStream(s.toString()));
          oout.writeObject(this.vertex);
          oout.flush(); oout.close();
          oout2.writeObject(this.edges);
          oout2.flush(); oout2.close();
            
        
        }
      catch(IOException e) {};
      }	
      
      /**
       * Grava o caminho resultante num ficheiro fich o resultado do caminho
       */
      public void gravaEmFichTxt(String fich,ArrayList lista) {
      try {
          FileWriter fout = new FileWriter(fich);
          for (int i=0; i<lista.size(); i++) {
              fout.write((String) lista.get(i));
              fout.write((String) "->");
            }
          fout.flush(); fout.close();
      }
      catch(IOException e) {};
      }   
  
      /**
       * Calculo do grafo (Shortest path), implementando o algoritmo de Dijkstra, dando o caminho mais economico
       */ 
    
    public ArrayList spEconomico(String partida, String chegada) throws LigNaoExiste{
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!(x.equals(chegada)) && !stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getconsumoMedio()))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getconsumoMedio())));
                 
                    }
                
                }
            }
        
        for(int i = 0; i< adjacentes.size();i++) {
                 String aux = (String) adjacentes.get(i);
                 if(!(orla.contains(aux))) {
                     if(!(caminho.contains(aux))) {
                         Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                         orla.add(aux);
                         candidatos.put(aux1.getDestino(),aux1.getNome());
                         dist.put(aux,(((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getconsumoMedio())));
                    
                        }
                    }
         
                }
                if(candidatos.isEmpty()) stuck = true;
                else {
                    String aux2 = procuracand(candidatos,dist);
                    String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                    x=aux;
                    if(!(caminho.contains(x))) caminho.add(x);
                    if(!(T.contains(aux2))) T.add(aux2);
                    for( int i = 0; i<orla.size(); i++) {
                        if(orla.get(i).equals(x)) orla.remove(x);
                    }      
                    candidatos.remove(aux);
                }
            }
            return filtra(T);
        }
                

/*
Possivel  caminho mais historico (falha em alguns casos)
public ArrayList maispois(String partida, String chegada) throws LocNaoExiste, LigNaoExiste
{
    String x = partida;
    ArrayList adjacentes = new ArrayList();

    HashMap qPois = new HashMap();
    ArrayList ret = new ArrayList();
    ArrayList ret1 = new ArrayList();
    HashMap candidatos = new HashMap();
    ret.add(partida);
    
    while(!(x.equals(chegada)))
    {
        Collection adj = edges.adjacentes(x);
        ArrayList aux = new ArrayList();
        aux.addAll(adj);
        for(int i = 0;i<aux.size();i++)
        {
            String aux1 = (String) aux.get(i);
            if(!(adjacentes.contains(aux1)))
            {
                if(!(ret.contains(aux1)))
                {
                    adjacentes.add(aux1);
                    candidatos.put(aux1,(edges.procuraLigDir(x,aux1)));
                    
                }
                                            
            }
                
        }
     
        String next = procuraMaior(adjacentes);
        x= next;
        for(int i= 0; i<adjacentes.size();i++)
        
        {   
            String aux1 = (String) adjacentes.get(i);
            if(aux1 == next)
            {
                adjacentes.remove(i);
                ret.add(x);
                ret1.add(candidatos.get(x));
            }
        }
    }
    
    return filtra(ret1);
       
}

private String procuraMaior (ArrayList qPois) throws LocNaoExiste
{   
    
    String aux = "";
    Integer temp = 0;
 
    for(int i = 0 ; i<qPois.size();i++)
    {
        Localidade aux3 = (Localidade) vertex.procurar((String) qPois.get(i));
        int aux1 = aux3.getlistaPOI().getlistaPOI().size();
        String aux2 = aux3.getnomeLocalidade();
        if(aux1>temp) 
        {
            temp=aux1; 
            aux = aux2;
        }
    }
    return aux;
}


 Possivel (Logest path) caminho mais longo (falha em alguns casos)



public ArrayList lp(String partida, String chegada) throws LigNaoExiste
{
    String x = partida;
    ArrayList adjacentes = new ArrayList();

    HashMap qPois = new HashMap();
    ArrayList ret = new ArrayList();
    ArrayList ret1 = new ArrayList();
    HashMap candidatos = new HashMap();
    ret.add(partida);
    
    while(!(x.equals(chegada)))
    {
        Collection adj = edges.adjacentes(x);
        ArrayList aux = new ArrayList();
        aux.addAll(adj);
        for(int i = 0;i<aux.size();i++)
        {
            String aux1 = (String) aux.get(i);
            if(!(adjacentes.contains(aux1)))
            {
                if(!(ret.contains(aux1)))
                {
                    adjacentes.add(aux1);
                    candidatos.put(aux1,(edges.procuraLigDir(x,aux1)));
                    
                }
                                            
            }
                
        }
     
        String next = procuraMaior2(candidatos);
        x= next;
        for(int i= 0; i<adjacentes.size();i++)
        
        {   
            String aux1 = (String) adjacentes.get(i);
            if(aux1 == next)
            {
                adjacentes.remove(i);
                ret.add(x);
                ret1.add(candidatos.get(x));
                System.out.println(next+"\n");
            }
        }
         System.out.println(next+"\n");
    }
    
    return (ret1);
       
}

private String procuraMaior2 (HashMap qPois) throws LigNaoExiste
{
    String aux = "";
    Integer temp = 0;
 
    for(Iterator it=qPois.values().iterator();it.hasNext();)
    {
        Ligacoes aux3 = edges.procurarNome((String) it.next());
        int aux1 = aux3.getnumeroKm();
        String aux2 = aux3.getDestino();
        if(aux1>temp) 
        {
            temp=aux1; 
            aux = aux2;
        }
    }
    return aux;
}

*/

 /**
     * Da as Localidades dentro de um determinado raio de Km em relacao a uma localidade
     */
public ArrayList isola(String partida,Integer raio) throws LigNaoExiste{
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm()))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm())));
                 
                    }
                
                }
            }
        
            for(int i = 0; i< adjacentes.size();i++) {
                String aux = (String) adjacentes.get(i);
                if(!(orla.contains(aux))) {
                    if(!(caminho.contains(aux))) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        orla.add(aux);
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux,(((Integer) dist.get(x)) + (((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))).getnumeroKm())));

                    }
                }
         
            }
            if(candidatos.isEmpty()) stuck = true;
            else {
                String aux2 = procuracand(candidatos,dist);
                String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                x=aux;
                if(!(caminho.contains(x))) caminho.add(x);
                if(!(T.contains(aux2))) T.add(aux2);
                for( int i = 0; i<orla.size(); i++) {
                    if(orla.get(i).equals(x)) orla.remove(x);
                }
            
            candidatos.remove(aux);
            }
        }
        
        ArrayList retorno = new ArrayList();
        for(Iterator it = vertex.values().iterator();it.hasNext();)
        {
            String loc = ((Localidade) it.next()).getnomeLocalidade();
            Integer distancia = (Integer) dist.get(loc);
            System.out.println(distancia);
            if(distancia<raio)
                {
                    retorno.add(loc);
                }
         
        }
        return retorno;
}


    private int filtraEst(Ligacoes lig)
    {   int i=0;
        if ((lig.getClass().getName()).equals("route.Estradas")) i = (lig.getnumeroKm())*100;
        else i = lig.getnumeroKm();
            
        return i;
    }


/**
* Calculo do grafo (Shortest path), implementando o algoritmo de Dijkstra, dando caminho contendo menos Km estradas logo paga menos portagens
*/ 
    public ArrayList spmenosEst(String partida, String chegada)throws LigNaoExiste {
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!(x.equals(chegada)) && !stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (filtraEst((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux)))))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (filtraEst((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))))));
                 
                    }
                
                }
            }
        
            for(int i = 0; i< adjacentes.size();i++) {
                String aux = (String) adjacentes.get(i);
                if(!(orla.contains(aux))) {
                    if(!(caminho.contains(aux))) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        orla.add(aux);
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux,(((Integer) dist.get(x)) + (filtraEst((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))))));
                    }
                }
         
            }
            if(candidatos.isEmpty()) stuck = true;
            else {
                String aux2 = procuracand(candidatos,dist);
                String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                x=aux;
                if(!(caminho.contains(x))) caminho.add(x);
                if(!(T.contains(aux2))) T.add(aux2);
                for( int i = 0; i<orla.size(); i++) {
                    if(orla.get(i).equals(x)) orla.remove(x);
                }
            
            candidatos.remove(aux);
            }
        }
        return fEst(filtra(T));
}


    
    private int filtraAutoestradas(Ligacoes lig)
    {   int i=0;
        if ((lig.getClass().getName()).equals("route.Autoestradas")) i = (lig.getnumeroKm())*100;
        else i = lig.getnumeroKm();
            
        return i;
}        
     /**
    * Retorna todas as estradas contidas num Array
    */ 
  
    private ArrayList fEst( ArrayList caminho) throws LigNaoExiste
    {   ArrayList ret = new ArrayList();
        for(int i = 0; i<caminho.size();i++)
        {
            String aux = (String) caminho.get(i);
            if ((((Ligacoes) edges.procurarNome(aux)).getClass().getName()).equals("route.Estradas"))
                ret.add(aux);
        }
        return ret;
    }
   /**
    * Retorna todas as Auto- estradas contidas num Array
    */ 
    private ArrayList fAE( ArrayList caminho) throws LigNaoExiste
    {   ArrayList ret = new ArrayList();
        for(int i = 0; i<caminho.size();i++)
        {
            String aux = (String) caminho.get(i);
            if ((((Ligacoes) edges.procurarNome(aux)).getClass().getName()).equals("route.Autoestradas"))
                ret.add(aux);
        }
        return ret;
    }
/**
* Calculo do grafo (Shortest path), implementando o algoritmo de Dijkstra, dando caminho contendo menos Autoestradas
*/ 
    public ArrayList spmenosAutoestradas(String partida, String chegada)throws LigNaoExiste {
        String x = partida;
        ArrayList caminho = new ArrayList();
        caminho.add(x);
        ArrayList T = new ArrayList();
        ArrayList orla = new ArrayList();
        HashMap candidatos = new HashMap();
        HashMap dist = new HashMap();
        boolean stuck = false;
        dist.put(partida,0);
    
        for(Iterator it=vertex.values().iterator();it.hasNext();) {
            dist.put(((Localidade) it.next()).getnomeLocalidade(),Integer.MAX_VALUE);
        }
    
        while(!(x.equals(chegada)) && !stuck) {
            ArrayList adjacentes = new ArrayList();
            adjacentes.addAll(edges.adjacentes(x));
            for (int i = 0; i<orla.size();i++) {
                String aux = (String) orla.get(i);
                if(adjacentes.contains(aux)) { 
                    if((((Integer) dist.get(x)) + (filtraAutoestradas((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux)))))< (Integer) dist.get(aux)) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux, (((Integer) dist.get(x)) + (filtraAutoestradas((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))))));
                 
                    }
                
                }
            }
        
            for(int i = 0; i< adjacentes.size();i++) {
                String aux = (String) adjacentes.get(i);
                if(!(orla.contains(aux))) {
                    if(!(caminho.contains(aux))) {
                        Ligacoes aux1 = edges.procurarNome(edges.procuraLigDir(x,aux));
                        orla.add(aux);
                        candidatos.put(aux1.getDestino(),aux1.getNome());
                        dist.put(aux,(((Integer) dist.get(x)) + (filtraAutoestradas((Ligacoes) edges.procurarNome(edges.procuraLigDir(x,aux))))));
                    }
                }
         
            }
            if(candidatos.isEmpty()) stuck = true;
            else {
                String aux2 = procuracand(candidatos,dist);
                String aux =((Ligacoes) edges.procurarNome(aux2)).getDestino();
                x=aux;
                if(!(caminho.contains(x))) caminho.add(x);
                if(!(T.contains(aux2))) T.add(aux2);
                for( int i = 0; i<orla.size(); i++) {
                    if(orla.get(i).equals(x)) orla.remove(x);
                }
            
            candidatos.remove(aux);
            }
        }
        return fAE(filtra(T));
    }
        
        
}       


