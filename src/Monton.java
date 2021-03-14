import java.util.Collections;
import java.util.Stack;

public class Monton {

    /**
     * Clase Monton, contiene los atributos y métodos del montón o pila del JuegoUno
     *
     * @author Rubén Serrano Cano
     * @version 1
     */


    //Atributos
    private Stack<Carta> monton;

    //LAS CARTAS VAN DIRECTAS AL MONTON O EL MONTON EMPIEZA VACÍO? HABRÁ QUE RELLENAR EL MONTÓN Y MIENTRAS DAR COLOR Y NÚMERO A LAS CARTAS?

    /**
     * Método constructor para Monton que inicializa el stack
     *
     */
    public Monton() {
        monton = new Stack<>();
    }

    /**
     * Método cogerCarta, que devuelve la última carta de la pila usando el método .pop()
     * @return carta
     */
    public Carta cogerCarta(){
        return monton.pop();
    }

    /**
     * Método ponerCarta, que coloca una carta sobre la pila usando el método .push()
     * @param carta es objeto Carta introducido por el usuario
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


    @Override
    public String toString() {
        return "Monton: " + monton;
    }
}
