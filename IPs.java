package route;

public class IPs extends Ligacoes
{
    public int localAtravessam;
    
    /**
     * Constructor Vazio
     */
    public IPs() {
        super("","","",0,0,0,new Lestacao());
        this.localAtravessam=0; 
    }
    
    /**
     * Constructor Completo
     */
    public IPs(String nome,String partida, String destino, int numeroKm,int tempoMedio,int consumoMedio,Lestacao lestacao,int localAtravessam) {
        super(nome,partida,destino,numeroKm,tempoMedio,consumoMedio,lestacao);
        this.localAtravessam=localAtravessam;
    }
    
    /**
     * Define numeroLocais de Passagem
     */
    public void setlocalAtravessam(int localAtravessam) {
        this.localAtravessam=localAtravessam;
    }
    
    /**
     * Retorna o numero de locais de Passagem
     */
    public int getlocalAtravessam() {
        return this.localAtravessam;
    }
    
    /**
     * Retorna o IP sob a forma de String
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Numero de local de Passagem: " + localAtravessam+"\n");
        return s.toString();
    }
    
    /**
     * Retorna uma copia do IP
     */
    public Object clone() {
        return new IPs(this.getNome(),this.getPartida(),this.getDestino(),this.getnumeroKm(),this.gettempoMedio(),this.getconsumoMedio(),this.getlestacao(),this.getlocalAtravessam());
    }
}