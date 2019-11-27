package route;

import java.util.*;
public class Aldeia extends Localidade

{
    public String nomePresidenteJunta;
    public String facilidadeAccess;
    
    /**
     * Constructor Vazio
     */
    public Aldeia() {
        super("","",0,new ListaPOI());
        this.nomePresidenteJunta="";
        this.facilidadeAccess=""; 
    }
    
    /**
     * Constructor Completo
     */
    
    public Aldeia(String nomeLocalidade,String nomeDistrito,int numeroHabitantes,ListaPOI listaPOI,String nomePresidenteJunta,String facilidadeAccess) {
        super(nomeLocalidade,nomeDistrito,numeroHabitantes,listaPOI);
        this.nomePresidenteJunta=nomePresidenteJunta;
        this.facilidadeAccess=facilidadeAccess;
    }
    
    /**
     * Define o nome do Presidente da Junta da Aldeia
     */
    public void nomePresidenteJunta(String nomePresidenteJunta) {
        this.nomePresidenteJunta=nomePresidenteJunta;
    }
    
    /**
     * Da o nome do Presidente da Junta da Aldeia
     */
    public String getnomePresidenteJunta() {
        return this.nomePresidenteJunta;
    }
    
    /**
     * Define o tipo de acesso a aldeia
     */
    public void setfacilidadeAccess(String facilidadeAccess) {
        this.facilidadeAccess=facilidadeAccess;
    }
    
    /**
     * Da o tipo de acesso da aldeia
     */
    public String getfacilidadeAccess() {
        return this.facilidadeAccess;
    }
    
    /**
     * Passa para string a Aldeia
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Nome do Presidente da Junta:"+nomePresidenteJunta+"\n");
        s.append("Qualidade dos Acessos:"+facilidadeAccess+"\n");
        return s.toString();
    }
    
    /**
     * Retorna uma copia da Aldeia
     */
    public Object clone() {
        return new Aldeia(this.getnomeLocalidade(),this.getnomeDistrito(),this.getnumeroHabitantes(),this.getlistaPOI(),this.getnomePresidenteJunta(),this.getfacilidadeAccess());
    }
}