package route;  

import java.util.*;
import java.io.*;

public class Lestacao implements Serializable
{
    
    HashMap lestacao;
    
    public Lestacao()
    {
        this.lestacao = new HashMap();
    }
    
    public Lestacao(HashMap lestacao)
    {
        this.lestacao = (HashMap)lestacao.clone();
    }

    public HashMap getLestacao()
    {
        return this.lestacao; 
    }
    
     public boolean vazia() {
        return this.lestacao.isEmpty();
    }
    public void inserir(Estacao estacao)
    {
        this.lestacao.put(estacao.getnomeEstacao().toLowerCase(),estacao);
    }
    
     public void remover(String nomeEstacao) throws EstNaoExiste{
            if (!(lestacao.containsKey(nomeEstacao)))
            throw new EstNaoExiste(nomeEstacao);

         this.lestacao.remove(nomeEstacao);
    }
 
    
    public Estacao procurar(String nomeEstacao) throws EstNaoExiste{
            if (!(lestacao.containsKey(nomeEstacao)))
            throw new EstNaoExiste(nomeEstacao);
        return(Estacao) lestacao.get(nomeEstacao.toLowerCase());
    }
        
        
    
     public Object clone()
     {
        return new Lestacao(this.getLestacao());
     }
    
     public String toString()
    {   
        StringBuffer s = new StringBuffer();
        s.append("\n");
        for(Iterator it = (this.lestacao.values()).iterator();it.hasNext(); )
        {
            Object item = it.next();
            s.append(((Estacao) item).toString());
        }
         return s.toString();
    }
}
