public class Carta {

    /**
     * Clase Carta, contiene los atributos y métodos de las cartas del JuegoUno
     *
     * @author Rubén Serrano Cano
     * @version 1
     */

    //Atributos
    private String color = "";
    private int numero;


    /**
     * Constructor para Carta, crea una carta con los parámetros de entrada suministrados
     *
     * @param color Color es el color que se le atribuye a la carta. Solo recibe uno de cuatro posibles
     * @param numero Número es el número que representa la carta. Solo recibe uno de nueve posibles
     */
    public Carta(String color, int numero){
        this.color = color;
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "{Carta: " +color+ ", "+numero+"}";
    }
}
