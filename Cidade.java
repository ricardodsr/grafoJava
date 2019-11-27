package route;

public class Cidade extends Localidade
{
    public String nomePresidente;
    public boolean universidade;
    public boolean sedeDistrito;
    
    /**
     * Constructor Vazio
     */
    public Cidade() {
        super("","",0,new ListaPOI());
        this.nomePresidente="";
        this.universidade=false;
        this.sedeDistrito=false; 
    
    }
    
    /**
     * Constructor Completo
     */
    public Cidade(String nomeLocalidade,String nomeDistrito,int numeroHabitantes,String nomePresidente,boolean universidade,boolean sedeDistrito,ListaPOI lp) {
        super(nomeLocalidade,nomeDistrito,numeroHabitantes,lp);
        this.nomePresidente=nomePresidente;
        this.universidade=universidade;
        this.sedeDistrito=sedeDistrito;
    }
    
    
    /**
     * Define o nome do Presidente da Cidade
     */
    public void setnomePresidente(String nomePresidente) {
        this.nomePresidente=nomePresidente;
    }
    
    /**
     * Retorna o nome do Presidente da Cidade
     */
    public String getnomePresidente() {
        return this.nomePresidente;
    }
    
    /**
     * Define se a cidade tem Universidade tem universidade ou nao
     */
    public void setuniversidade(boolean universidade) {
        this.universidade=universidade;
    }
    
    /**
     * Verifica se a cidade tem universidade
     */
    public boolean getuniversidade() {
        return this.universidade;
    }
    
    /**
     * Define se a Cidade Ž Sede de Distrito
     */
    public void setsedeDistrito(boolean sedeDistrito) {
        this.sedeDistrito=sedeDistrito;
    }
    
    
    /**
     * Verifica se a Cidade Ž Sede de Distrito
     */
    public boolean getsedeDistrito() {
        return this.sedeDistrito;
    }
    
    /**
     * Devolve a Cidade sob a forma de String
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Nome do Presidente:" + nomePresidente+"\n");
        s.append("Universidade: " + universidade+"\n");
        s.append("Sede do Distrito: " + sedeDistrito+"\n");
        return s.toString();
    }
    
    /**
     * Cria uma copia da Cidade
     */
    public Object clone() {
        return new Cidade(this.getnomeLocalidade(),this.getnomeDistrito(),this.getnumeroHabitantes(),this.getnomePresidente(),this.getuniversidade(),this.getsedeDistrito(),this.getlistaPOI());
    }
}