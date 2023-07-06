package route;

import java.util.*;

/**
 * This code defines a class called Aldeia that extends another class called
 * Localidade. The Aldeia class has two instance variables: nomePresidenteJunta
 * and facilidadeAccess, both of type String. It has two constructors: one empty
 * and one with parameters. The class also has getter and setter methods for the
 * instance variables, as well as a toString method that returns a string
 * representation of the Aldeia object. There is also a clone method that
 * creates a copy of the Aldeia object.
 */

public class Aldeia extends Localidade

{
    public String nomePresidenteJunta;
    public String facilidadeAccess;

    /**
     * Constructor Vazio
     */
    public Aldeia() {
        super("", "", 0, new ListaPOI());
        this.nomePresidenteJunta = "";
        this.facilidadeAccess = "";
    }

    /**
     * Initializes a new instance of the Aldeia class.
     *
     * @param nomeLocalidade      The name of the locality.
     * @param nomeDistrito        The name of the district.
     * @param numeroHabitantes    The number of inhabitants.
     * @param listaPOI            The list of points of interest.
     * @param nomePresidenteJunta The name of the village mayor.
     * @param facilidadeAccess    The accessibility of the village.
     */
    public Aldeia(String nomeLocalidade, String nomeDistrito, int numeroHabitantes, ListaPOI listaPOI,
            String nomePresidenteJunta, String facilidadeAccess) {
        super(nomeLocalidade, nomeDistrito, numeroHabitantes, listaPOI);
        this.nomePresidenteJunta = nomePresidenteJunta;
        this.facilidadeAccess = facilidadeAccess;
    }

    /**
 * This class represents a village and its properties.
 */
public class Village {
    private String nomePresidenteJunta;
    private String facilidadeAccess;

    /**
     * Sets the name of the President of the Village Council.
     * @param nomePresidenteJunta The name of the President.
     */
    public void setNomePresidenteJunta(String nomePresidenteJunta) {
        this.nomePresidenteJunta = nomePresidenteJunta;
    }

    /**
     * Gets the name of the President of the Village Council.
     * @return The name of the President.
     */
    public String getNomePresidenteJunta() {
        return this.nomePresidenteJunta;
    }

    /**
     * Sets the type of access to the village.
     * @param facilidadeAccess The type of access.
     */
    public void setFacilidadeAccess(String facilidadeAccess) {
        this.facilidadeAccess = facilidadeAccess;
    }

    /**
     * Gets the type of access to the village.
     * @return The type of access.
     */
    public String getFacilidadeAccess() {
        return this.facilidadeAccess;
    }
}


/**
 * Represents an Aldeia.
 */
public class Aldeia {

    /**
     * The name of the Presidente da Junta.
     */
    private String nomePresidenteJunta;

    /**
     * The quality of the access.
     */
    private String facilidadeAccess;

    /**
     * Initializes a new instance of the Aldeia class.
     *
     * @param nomeLocalidade        The name of the localidade.
     * @param nomeDistrito          The name of the distrito.
     * @param numeroHabitantes      The number of habitantes.
     * @param listaPOI              The list of POI.
     * @param nomePresidenteJunta   The name of the Presidente da Junta.
     * @param facilidadeAccess      The quality of the access.
     */
    public Aldeia(String nomeLocalidade, String nomeDistrito, int numeroHabitantes, List<String> listaPOI,
                  String nomePresidenteJunta, String facilidadeAccess) {
        // Code for initializing the Aldeia instance goes here...
    }

    /**
     * Returns the string representation of the Aldeia.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Nome do Presidente da Junta:" + nomePresidenteJunta + "\n");
        s.append("Qualidade dos Acessos:" + facilidadeAccess + "\n");
        return s.toString();
    }

    /**
     * Returns a copy of the Aldeia.
     *
     * @return The copy of the Aldeia.
     */
    @Override
    public Object clone() {
        return new Aldeia(this.getnomeLocalidade(), this.getnomeDistrito(), this.getnumeroHabitantes(),
                this.getlistaPOI(), this.getnomePresidenteJunta(), this.getfacilidadeAccess());
    }
}
}
