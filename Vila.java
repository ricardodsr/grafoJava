package route;

public class Vila extends Localidade
{
    public String nomePresidente;
    public String nomeCidadeProxima;
    
    /**
     * Constructor Vazio
     */
    public Vila() {
        super("","",0,new ListaPOI());
        this.nomePresidente="";
        this.nomeCidadeProxima=""; 
    
    }
    
    /**
     * Constructor Completo
     */
    public Vila(String nomeLocalidade,String nomeDistrito,int numeroHabitantes,String nomePresidente,String nomeCidadeProxima,ListaPOI lp) {
        super(nomeLocalidade,nomeDistrito,numeroHabitantes,lp);
        this.nomePresidente=nomePresidente;
        this.nomeCidadeProxima=nomeCidadeProxima;
    }
    
    /**
     * Define o nome do Presidente da Vila
     */
    public void setnomePresidente(String nomePresidente) {
        this.nomePresidente=nomePresidente;
    }
    
    /**
     * Devolve o nome do Presidente da Vila
     */
    public String getnomePresidente() {
        return this.nomePresidente;
    }
    
    /**
     * Define o nome da cidade mais proxima
     */
    public void setnomeCidadeProxima(String nomeCidadeProxima) {
        this.nomeCidadeProxima=nomeCidadeProxima;
    }
    
    /**
     * Da o nome da cidade mais proxima
     */
    public String getnomeCidadeProxima() {
        return this.nomeCidadeProxima;
    }
    
    /**
     * Passa a Vila sob a forma de string
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Nome do Presidente:"+nomePresidente+"\n");
        s.append("Nome da Cidade mais proxima:"+nomeCidadeProxima+"\n");
        return s.toString();
    }
    
    /**
     * Cria uma copia da Vila
     */
    public Object clone() {
        return new Vila(this.getnomeLocalidade(),this.getnomeDistrito(),this.getnumeroHabitantes(),this.getnomePresidente(),this.getnomeCidadeProxima(),this.getlistaPOI());
    }
}