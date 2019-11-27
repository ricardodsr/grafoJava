
package route;
import java.io.*;
import java.util.*;

public abstract class Ligacoes implements Serializable
{
    private String nome;
    private String partida;
    private String destino;
    private int numeroKm; //definido em temos de km.m ou seja 12 km
    private int tempoMedio; // definido em termos minutos
    private int consumoMedio;// definido em termos litros 
    private Lestacao lestacao;
    //private HashMap estacoesdeservico;// Hashmap ver api do java ja estao todas deitas
    //nao sei como colocar esta?oes de servi?o
    
    
    
    public Ligacoes()
    {
        this.nome = "";
        this.partida ="";
        this.destino ="";
        this.numeroKm=0;
        this.tempoMedio=0;
        this.consumoMedio=0;
        this.lestacao= new Lestacao();
    
    }
  
    public Ligacoes(String nome, String partida , String destino, int numeroKm, int tempoMedio, int consumoMedio,Lestacao lestacao)
    {
        this.nome = nome;
        this.partida = partida;
        this.destino = destino;
        this.numeroKm=numeroKm;
        this.tempoMedio=tempoMedio;
        this.consumoMedio=consumoMedio;
        this.lestacao = (Lestacao) lestacao.clone();
       
    }

      public void setNome(String Nome){
        this.nome=nome;
    }
   
    public String getNome()
    {
        return this.nome;
    }
    public void setPartida(String partida){
        this.partida=partida;
    }
   
    public String getPartida(){
        return this.partida;
    }
    
    public void setDestido(String destino){
        this.destino=destino;
    }
    public String getDestino(){
        return this.destino;
    }
    
    public void setnumeroKm(int numeroKm){
        this.numeroKm=numeroKm;
    }
    
    public int getnumeroKm(){
        return this.numeroKm;
    }
    
    public void settempoMedio(int tempoMedio){
        this.tempoMedio=tempoMedio;
    }
    
    public int gettempoMedio() {
        return this.tempoMedio;
    }
    
    public void setconsumoMedio(int consumoMedio){
        this.consumoMedio=consumoMedio;
    }
    
    public int getconsumoMedio(){
        return this.consumoMedio;
    }
    
    public Lestacao getlestacao()
    {
        return this.lestacao;
    } 
    
     public void setlestacao(Lestacao lestacao)
    {
        this.lestacao=lestacao;
    }
    
    public void inserirlestacao(Estacao estacao)
    {
        this.lestacao.inserir(estacao);
    }
    
    public void removerlestacao(String nomeEstacao) throws EstNaoExiste
    {
         this.lestacao.remover(nomeEstacao);
    }
    /**
     * Devolve a ligacao sob a forma de String
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Nome: "+nome+"\n");
        s.append("Numero de KM: "+numeroKm+"\n");
        s.append("Tempo MŽdio: "+tempoMedio+"\n");
        s.append("Consumo MŽdio: "+consumoMedio+"\n");
        s.append("Partida: "+partida+"\n");
        s.append("Destino: "+destino+"\n");
        return s.toString();
    }
    
      public abstract Object clone();
    
}
