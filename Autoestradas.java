package route;

public class Autoestradas extends Ligacoes {
    public int precoPortagens;

    /**
     * Constructor Vazio
     */
    public Autoestradas() {
        super("", "", "", 0, 0, 0, new Lestacao());
        this.precoPortagens = 0;
    }

    /**
     * Constructor Completo
     * 
     * @param nome             - The name of the autoestrada
     * @param partida          - The starting point of the autoestrada
     * @param destino          - The destination of the autoestrada
     * @param numeroKm         - The length of the autoestrada in kilometers
     * @param tempoMedio       - The average time taken to travel the autoestrada in minutes
     * @param consumoMedio     - The average fuel consumption on the autoestrada
     * @param lestacao         - The Lestacao object representing the autoestrada's station
     * @param precoPortagens   - The toll price on the autoestrada
     */
    public Autoestradas(String nome, String partida, String destino, int numeroKm, int tempoMedio, int consumoMedio,
            Lestacao lestacao, int precoPortagens) {
        super(nome, partida, destino, numeroKm, tempoMedio, consumoMedio, lestacao);
        this.precoPortagens = precoPortagens;
    }

    /**
     * Set the toll price
     * 
     * @param precoPortagens - The toll price on the autoestrada
     */
    public void setprecoPortagens(int precoPortagens) {
        this.precoPortagens = precoPortagens;
    }

    /**
     * Get the toll price
     * 
     * @return - The toll price on the autoestrada
     */
    public int getprecoPortagens() {
        return this.precoPortagens;
    }

    /**
     * Return the autoestrada as a String
     * 
     * @return - The autoestrada as a String
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("Preco das Portagens: " + precoPortagens + "\n");
        return s.toString();
    }

    /**
     * Return a copy of the autoestrada
     * 
     * @return - A copy of the autoestrada
     */
    public Object clone() {
        return new Autoestradas(this.getNome(), this.getPartida(), this.getDestino(), this.getnumeroKm(),
                this.gettempoMedio(), this.getconsumoMedio(), this.getlestacao(), this.getprecoPortagens());
    }
}
