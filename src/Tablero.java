import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Tablero {

    /**
     * Clase Tablero con los atributos y métodos para el operar en JuegoUno
     *
     * @author Rubén Serrano Cano
     * @version 1
     */

    //POR QUÉ HAY UN METODO RELLENAR MONTON? PARA MOVER LAS CARTAS DEL TABLERO AL MONTON O PARA RELLENAR EL TABLERO?
    //POR QUÉ HAY QUE BARAJAR EL TABLERO?

    //Atributos
    Stack<Carta> tablero;

    public Tablero() {
        tablero = new Stack<>();
    }

    public void ponerCarta(Carta carta){
        tablero.push(carta);
    }

    //Hay 72 cartas, 9 por 4 colores, pero los colores se repiten 2 veces
    public void rellenarMonton(Carta carta){
        tablero.push(carta);
    }

    public void barajar(){
        Collections.shuffle(tablero);
    }
}
