import java.util.ArrayList;

public class Jugador {

    /**
     * Clase Jugador que contiene informácion significativa como el nombre
     * del jugador, su número de cartas y su mano/conjunto de cartas.
     *
     * @author Rubén Serrano Cano.
     * @version 0
     * @date 19/03/21 dd/mm/aa
     */

    //Atributos
    private String nombre;
    private int numeroCartas;
    private ArrayList<Carta> mano;

    //Métodos

    /**
     * Método constructor para Jugador que toma un paramétro de tipo String y que será asignado como su nombre
     * Se encarga de inicializar el arraylist mano,
     * @param nombre actúa como identificador del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new ArrayList<>();
    }



    /**
     * Getter que devuelve el nombre del jugador
     * @return devuelve el atributo nombre, que actúa como identificador del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter que devuelve el número de cartas del jugador.
     * @return devuelve el número de cartas que tiene el jugador.
     */
    public int getNumeroCartas(){
        return numeroCartas;
    }

    /**
     * Setter que establece el número de cartas del jugador.
     * @param numeroCartas entero que hace referencia al número de cartas.
     */
    public void setNumeroCartas(int numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    /**
     * Método que asigna al arraylist mano el último elemento carta del stack monton
     * mediante el método cogerCarta() de la clase Monton.
     * Además de incrementar el número de cartas del jugador.
     * @param monton objeto de la clase Montón que presenta un atributo stack con los elementos a asignar en mano.
     */
    public void robarCarta(Monton monton){
        mano.add(monton.cogerCarta());
        numeroCartas++;
    }

    /**
     * Método que devuelve una carta.
     * @param indice hace referencia a la posición del elemento en el arraylist mano
     * @return devuelve un objeto carta del arraylist mano.
     */
    public Carta usarCarta(int indice){
        return mano.get(indice);
    }

    /**
     * Método que elimina un elemento del arraylist mano.
     * @param indice hace referencia a la posición del elemento del arraylist a eliminar.
     * Además de decrementar el número de cartas del jugador.
     */
    public void quitarCarta(int indice){
        mano.remove(indice);
        numeroCartas--;
    }

    /**
     * Método que devuelve el arraylist como una String.
     * @return Devuelve una String con los elementos del arraylist mano.
     */
    public String mostrarMano(){
        return mano.toString();
    }

    /**
     * Método toString()
     * @return devuelve una String con el nombre, número de cartas y mano del jugador
     */
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", numeroCartas=" + numeroCartas +
                ", mano=" + mano +
                '}';
    }
}

