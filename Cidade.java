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
     * Define se a Cidade � Sede de Distrito
     */
    public void setsedeDistrito(boolean sedeDistrito) {
        this.sedeDistrito=sedeDistrito;
    }
    
    
    /**
     * Verifica se a Cidade � Sede de Distrito
     */
    public boolean getsedeDistrito() {
        return this.sedeDistrito;
    }
    
/**
 * Returns the City as a String
 *
 * @return the City as a String
 */
@Override
public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(super.toString());
    s.append("Nome do Presidente: ").append(nomePresidente).append("\n");
    s.append("Universidade: ").append(universidade).append("\n");
    s.append("Sede do Distrito: ").append(sedeDistrito).append("\n");
    return s.toString();
}
    
/**
 * Create a copy of the City
 */
public Object clone() {
    return new City(
        this.getCityName(),
        this.getDistrictName(),
        this.getPopulation(),
        this.getPresidentName(),
        this.getUniversity(),
        this.getDistrictHeadquarters(),
        this.getPointsOfInterest()
    );
}
}