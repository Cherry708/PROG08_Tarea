import java.util.ArrayList;

public class Jugador {

    //Atributos
    private String nombre;
    private int numeroCartas;
    ArrayList<Carta> mano;

    /**
     * Método constructor para Jugador, asignará los atributos nombre y número de cartas a los valores suministrados
     *
     * @param nombre Nombre será el identificador del jugador
     * @param numeroCartas NumeroCartas será el número de cartas inicial del que dispondrá el jugador
     */
    public Jugador(String nombre, int numeroCartas) {
        this.nombre = nombre;
        this.numeroCartas = numeroCartas;
    }

    /**
     * Puede que solo sea necesario el getter de nombre ya que el setter no se utilizará y los getter y setter
     * de cartas no serán necesarios ya que en realidad se hará referencia al tamaño de la mano, que son las cartas
     */

    /**
     * Getter que devuelve el nombre del jugador
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    public int getNumeroCartas(){
        return numeroCartas;
    }

    //La carta a robar debe ser cogida del monton, así?
    public void robarCarta(Monton monton){
        //monton.cogerCarta usa el método .pop() que devuelve la última carta del montón
        mano.add(monton.cogerCarta());
    }

    public void usarCarta(Carta carta){
        if (!mano.contains(carta)){
            System.out.println("No tienes esa carta");
        } else mano.remove(carta); //HABRÁ QUE PONER ESA CARTA EN EL TABLERO, CÓMO?
    }

    public String mostrarMano(){
        return mano.toString();
    }


}
