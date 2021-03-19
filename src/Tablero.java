import java.util.Collections;
import java.util.Stack;

public class Tablero {

    /**
     * Clase Tablero con el atributo tablero, un stack que contiene las cartas que
     * se han jugado durante la partida y métodos para el operar en JuegoUno.
     *
     * @author Rubén Serrano Cano.
     * @version 0
     * @date 19/03/21 dd/mm/aa
     */


    //Atributos
    private Stack<Carta> tablero;

    //Métodos

    /**
     * Método constructor para Tablero que inicializa el stack.
     *
     */
    public Tablero() {
        tablero = new Stack<>();
    }

    /**
     * Metodo que asigna al stack un elemento carta suministrado como parámetro de entrada.
     * @param carta elemento proporcionado como parámetro de entrada.
     */
    public void ponerCarta(Carta carta){
        tablero.push(carta);
    }

    /**
     * Método que comprueba el estado del tablero.
     * @return devuelve un boolean para indicar si el tablero tiene o no contenido.
     */
    public boolean estaVacio(){
        return tablero.isEmpty();
    }

    /**
     * Método que comprueba cual es la última carta del stack.
     * @return devuelve la última carta del stack tablero sin eliminarla de este.
     */
    public Carta ultimaCarta(){
        return tablero.peek();
    }

}
