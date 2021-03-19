import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Monton {

    /**
     * Clase Monton, contiene el atributo monton,
     * un stack de elementos carta y métodos del montón/pila del JuegoUno.
     *
     * @author Rubén Serrano Cano.
     * @version 0
     * @date 19/03/21 dd/mm/aa
     */


    //Atributos
    private Stack<Carta> monton;

    //Métodos

    /**
     * Método constructor para Monton que inicializa el stack.
     */
    public Monton() {
        monton = new Stack<>();
    }

    /**
     * Método cogerCarta, que devuelve la última carta de la pila usando el método .pop()
     * @return devuelve un elemento carta.
     */
    public Carta cogerCarta() {
        return monton.pop();
    }

    /**
     * Método ponerCarta, que coloca una carta sobre la pila usando el método .push()
     * @param carta es objeto Carta introducido por el usuario.
     */
    public void ponerCarta(Carta carta){
        monton.push(carta);
    }

    /**
     * Método longitud que nos permite conocer el tamaño del stack
     * @return devuelve el tamaño del stack
     */
    public int longitud(){
        return monton.size();
    }

    /**
     * Método barajar, que coloca las cartas en posiciones aleatorias de la pila usando el método .shuffle()
     */
    public void barajar(){
        Collections.shuffle(monton);
    }

    /**
     * Método que comprueba si el stack tiene o no elementos.
     * @return devuelve un boolean en función de si está o no vacío.
     */
    public boolean estaVacio(){
        return monton.isEmpty();
    }

    /**
     * Muestra por pantalla el monton.
     * @return devuelve un String con formato y todos los elementos del monton.
     */
    @Override
    public String toString() {
        return "Monton: " + monton;
    }
}
