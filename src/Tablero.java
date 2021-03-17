import java.util.Collections;
import java.util.Stack;

public class Tablero {

    /**
     * Clase Tablero con los atributos y métodos para el operar en JuegoUno
     *
     * @author Rubén Serrano Cano
     * @version 1
     */


    //Atributos
    private Stack<Carta> tablero;

    /**
     * Método constructor para Tablero que inicializa el stack
     *
     */
    public Tablero() {
        tablero = new Stack<>();
    }

    public void ponerCarta(Carta carta){
        tablero.push(carta);
    }

    /*
    public Carta rellenarMonton(){
        return tablero.pop();
    }
    */

    /*
    public void barajar(){
        Collections.shuffle(tablero);
    }
    */

    public boolean estaVacio(){
        return tablero.isEmpty();
    }

    public Carta ultimaCarta(){
        return tablero.peek();
    }


}
