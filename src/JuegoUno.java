public class JuegoUno {
    public static void main(String[] args){

        /*
        Necesitaré rellenar el monton de cartas haciendo un dos bucles para cada color
        con 9 cartas. El monton se rellenará al iniciar la partida.

        Entonces el jugador robará N cartas, 9 por ejemplo. Y empezará la partida.
        Para saltar de un jugador a otro usaremos un boolean, como en el tres en raya.

        Ganará el jugador que se quede antes sin cartas.
        Para una jugada hay tres opciones: robar carta si no puede poner una y poner una carta en el tablero si puede.
        La condición para poder poner una carta es que esta sea del mismo color que la que ya hay.

        Cuando se vaya poner una carta y sea posible, se ha de de eliminar esta de la mano del jugador y colocarla en
        el tablero, cómo? se debe usar mano.remove(), pero cómo, cuando y donde?
        Cuando vaya a poner una carta, como compruebo que son del mismo color?
        Una secuencia como jugador.usarCarta(carta) if tablero.vacio(){tablero.ponerCarta(carta)}
        else if tablero.¿peekCarta().getColor? == jugador.usarCarta().getColor(){tablero.ponerCarta(carta)} ??
         */

    }
}
