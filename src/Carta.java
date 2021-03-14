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

    //CUANDO LE DAMOS NUMERO Y COLOR A LA CARTA? AL COGERLA DEL MONTON, AL DARSELA AL JUGADOR O AL RELLENAR EL MONTÓN?
    //EL MONTÓN EMPIEZA LLENO?
    //PARA ASIGNAR NUMERO Y COLOR A LA CARTA, BUCLE FOR POR CADA COLOR Y POR CADA COLOR 9*2 CARTAS PORQUE HAY DOS COLORES REPETIDOS A CADA NÚMERO

    /**
     * Carta carta;
     * Cartas azules1
     * for(int contador=0; contador<CARTAS_COLOR; contador++){
     *     carta = new Carta(azul, contador)
     * }
     * Cartas azules2
     * for(int contador=0; contador<CARTAS_COLOR; contador++){
     *      carta = new Carta(azul, contador)
     * }
     *
     * Pero aquí estoy sobreescribiendo carta, no pasará si la carta se asigna directamente al stack?
     * Es decir, si al rellenar el monton, hago la asignación de color y numero de la carta y entonces la guardo
     * dentro del montón sí debería poder tener todas las cartas asignadas y apiladas, no? Y cómo? Hago eso?
     * El mismo bucle pero como última línea, monton.ponerCarta(carta)?
     */

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
        return "{Carta: " + "color = " +color+ ", " + "número = " +numero+"}";
    }
}
