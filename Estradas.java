package route;

public class Estradas extends Ligacoes
{
    public String tipoPavimento;
    
    /**
     * Constructor Vazio
     */
    public Estradas(){
        super("","","",0,0,0,new Lestacao());
        this.tipoPavimento=""; 
    }
    
    /**
     * Constructor Completo
     */
    public Estradas(String nome,String partida, String destino,int numeroKm,int tempoMedio,int consumoMedio,Lestacao lestacao,String tipoPavimento){
        super(nome,partida,destino,numeroKm,tempoMedio,consumoMedio,lestacao);
        this.tipoPavimento=tipoPavimento;
    }
    
    /**
     * Defino o tipo de Pavimento da estrada
     */
    public void settipoPavimento(String tipoPavimento){
        this.tipoPavimento=tipoPavimento;
    }
    
    /**
     * Retorna o tipo de pavimento da Estrada
     */
    public String gettipoPavimento(){
        return this.tipoPavimento;
    }
    
    /**
     * Devolve a estrada sob a forma de String
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Tipo de pavimento: "+tipoPavimento+"\n");
        return s.toString();
    }

    /**
     * Retorna uma c—pia da Estrada
     */
    public Object clone(){
        return new Estradas(this.getNome(),this.getPartida(),this.getDestino(),this.getnumeroKm(),this.gettempoMedio(),this.getconsumoMedio(),this.getlestacao(),this.gettipoPavimento());
    }
}