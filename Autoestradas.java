package route;

public class Autoestradas extends Ligacoes
{
    public int precoPortagens;
    
    /**
     * Constructor Vazio
     */
    public Autoestradas(){
        super("","","",0,0,0,new Lestacao());
        this.precoPortagens=0; 
    }
    
    /**
     * Constructor Completo
     */
    
    public Autoestradas(String nome,String partida, String destino,int numeroKm,int tempoMedio,int consumoMedio,Lestacao lestacao,int precoPortagens){
        super(nome,partida,destino,numeroKm,tempoMedio,consumoMedio,lestacao);
        this.precoPortagens=precoPortagens;
    }
    
    /**
     * Define o pre?o da Portagem
     */
    public void setprecoPortagens(int precoPortagens){
        this.precoPortagens=precoPortagens;
    }
    
    /**
     * Da o pre?o da Portagem
     */
    public int getprecoPortagens() {
        return this.precoPortagens;
    }
    
    /**
     * Retorna sob a forma de String a Auto estrada
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Preco das Portagens: " + precoPortagens+"\n");
        return s.toString();
    }
    
    /**
     * Retorna uma copia da auto estrada
     */
    public Object clone(){
        return new Autoestradas(this.getNome(),this.getPartida(), this.getDestino(),this.getnumeroKm(),this.gettempoMedio(),this.getconsumoMedio(),this.getlestacao(),this.getprecoPortagens());
    }
}