import java.util.Scanner;

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

        Monton monton;
        Tablero tablero;
        Jugador jugador1;
        Jugador jugador2;
        Carta carta;

        Scanner inputJugador = new Scanner(System.in);
        String inputColor;
        String inputLinea;
        int inputNumero;
        boolean jugada = true;

        monton = new Monton();
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador1", 1);
        jugador2 = new Jugador("Jugador2", 9);

        //Debe ser algo así en el juego, pero carta es la que escribe el usuario y debe estar en su mano?

        generarMonton(monton);

        /*
        System.out.println("Longitud del montón y el montón: ");
        System.out.println(monton.longitud());
        System.out.println(monton.toString());
         */

        //Rellenamos la carta de los jugadores
        for (int contador = 0; contador<jugador1.getNumeroCartas(); contador++){
            jugador1.robarCarta(monton);
        }

        //Se debe hacer de modo que solo haya un objeto Jugador? O deben haber 2? Deben haber 2
        /*
        System.out.println();
        System.out.println("La longitud de la mano y la mano de jugador1 es:");
        System.out.println(jugador1.getNumeroCartas());
        System.out.println(jugador1.mostrarMano());
         */

        /*
        if(contador%2==0){
            jugar(jugador1)
        } else jugar(jugador2)
         */

        //System.out.println();

        //while boolean jugada = true
        //Preguntamos al usuario por la carta a usar
        while (jugada) {
            System.out.println("Es el turno de: " + jugador1.getNombre());
            System.out.println(jugador1.mostrarMano());
            System.out.println("Escoge la carta indicando su posición en tu mano: ");

            inputLinea = inputJugador.next();
            inputNumero = Integer.parseInt(inputLinea);
            inputNumero--;

            if (tablero.estaVacio()) {
                tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                jugador1.usarCarta(inputNumero);
                System.out.println("Has colocado la carta");
                System.out.println(jugador1.mostrarMano());
                System.out.println(jugador1.getNumeroCartas());
                jugada = false;
            } else if (jugador1.getMano().get(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                    jugador1.getMano().get(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                jugador1.usarCarta(inputNumero);
                System.out.println("Has colocado la carta");
                System.out.println(jugador1.mostrarMano());
                System.out.println(jugador1.getNumeroCartas());
                jugada = false;
            }
            if (jugador1.getNumeroCartas() == 0) {
                System.out.println(jugador1.getNombre() + " se ha quedado sin cartas y ha ganado");
            }
        }

        while (jugada == false){
            System.out.println("Es el turno de: " + jugador2.getNombre());
            System.out.println(jugador2.mostrarMano());
            System.out.println("Escoge la carta indicando su posición en tu mano: ");

            inputLinea = inputJugador.next();
            inputNumero = Integer.parseInt(inputLinea);
            inputNumero--;

            if (tablero.estaVacio()) {
                tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                jugador1.usarCarta(inputNumero);
                System.out.println("Has colocado la carta");
                System.out.println(jugador1.mostrarMano());
                System.out.println(jugador1.getNumeroCartas());
                jugada = false;
            } else if (jugador1.getMano().get(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                    jugador1.getMano().get(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                jugador1.usarCarta(inputNumero);
                System.out.println("Has colocado la carta");
                System.out.println(jugador1.mostrarMano());
                System.out.println(jugador1.getNumeroCartas());
                jugada = false;
            }
            if (jugador1.getNumeroCartas() == 0) {
                System.out.println(jugador1.getNombre() + " se ha quedado sin cartas y ha ganado");
            }
        }

        /*
        carta = new Carta(inputColor, inputNumero);

        //jugador1.mano.add(carta); //Si añado la carta manualmente sí que la encuentra

        if (jugador1.contieneCarta(carta)){ //La condición nunca se cumple pero sí debería
            tablero.ponerCarta(carta);
            jugador1.usarCarta(carta);
            System.out.println("Sí tenías la carta");
            System.out.println(jugador1.getNumeroCartas());
            //jugada = false;
        } else System.out.println("No tienes esa carta en la mano");
        //jugada sigue siendo true y repetimos

         */

        System.out.println(tablero.toString());

    }

    /*
    Función generarMonton, se encarga de asignar todas las cartas del juego al montón y barajarlas
    Requiere del parametro de entrada 'monton' porque el objeto ha sido declarado e instanciado en main
     */
    private static void generarMonton(Monton monton) {
    /*
    Con este bloque de código estamos introduciendo todas las cartas en el monton y
    barajándolo al inicio de la partida
     */
        //Rellenar monton con cartas azules, funciona, se rellena el stack con 18 cartas del 1 al 9 de color azul
        for (int color = 0; color<2; color++){
            for (int numero = 1; numero<10; numero++){
                monton.ponerCarta(new Carta("azul", numero));
            }
        }

        //Rellenar monton con cartas rojas
        for (int color = 0; color<2; color++){
            for (int numero = 1; numero<10; numero++){
                monton.ponerCarta(new Carta("rojo", numero));
            }
        }

        //Rellenar monton con cartas amarillas
        for (int color = 0; color<2; color++){
            for (int numero = 1; numero<10; numero++){
                monton.ponerCarta(new Carta("amarillo", numero));
            }
        }

        //Rellenar monton con cartas verdes
        for (int color = 0; color<2; color++){
            for (int numero = 1; numero<10; numero++){
                monton.ponerCarta(new Carta("verde", numero));
            }
        }
        monton.barajar();
    }
}
