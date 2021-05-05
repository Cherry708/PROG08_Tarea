import java.util.Scanner;

public class JuegoUno {
    public static void main(String[] args) {

        //Declaración de objetos
        Monton monton;
        Tablero tablero;
        Jugador jugador1;
        Jugador jugador2;
        Scanner inputJugador;
        String inputLinea = "";

        //Declaración e inicialización de variables
        final int CARTAS_INICIALES = 4;
        final int NUM_COLOR = 2;
        final int NUM_CARTA = 9;
        int inputNumero = 0;
        boolean turno = true;
        boolean partida = true;
        boolean jugada;

        //Instanciación de objetos
        monton = new Monton();
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador1");
        jugador2 = new Jugador("Jugador2");
        inputJugador = new Scanner(System.in);


        //Generamos un montón con las cartas necesarias
        generarMonton(monton, NUM_COLOR, NUM_CARTA);

        //Damos las cartas a los jugadores
        asignarCartas(monton, jugador1, CARTAS_INICIALES);
        asignarCartas(monton, jugador2, CARTAS_INICIALES);


        while (partida) {

            if (turno) {
                jugada = true;

                mostrarTurno(jugador1);

                try {
                    inputNumero = escogerOpcion(inputLinea, inputNumero, inputJugador);

                    if (inputNumero == 0) {
                        if (!tablero.estaVacio()) {
                            mostrarTablero(tablero);
                        } else {
                            tableroVacio();
                        }

                    } else if (inputNumero == 1) { //Poner carta
                        while (jugada) {
                            try {
                                inputNumero = escogerCarta(inputLinea, inputNumero, inputJugador);

                                if (tablero.estaVacio()) {
                                    ponerCarta(tablero, jugador1, inputNumero);
                                    mostrarTablero(tablero);
                                    jugada = false;
                                    turno = false;

                                } else if (jugador1.usarCarta(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                                        jugador1.usarCarta(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                                    ponerCarta(tablero, jugador1, inputNumero);
                                    mostrarTablero(tablero);
                                    jugada = false;
                                    turno = false;

                                } else {
                                    cartaNoCompatible();
                                    mostrarTablero(tablero);
                                    jugada = false;
                                }
                                if (jugador1.getNumeroCartas() == 0) {
                                    haGanado(jugador1);
                                    partida = false;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Error de entrada. La posición introducida no es válida.");
                            } catch (NumberFormatException e) {
                                System.out.println("Error de entrada. Debes introducir un número.");
                            }
                        }
                    } else if (inputNumero == 2) {
                        if (monton.estaVacio()){
                            generarMonton(monton, NUM_COLOR, NUM_CARTA);

                        } else {
                            haCogidoCarta(jugador1, monton);
                        }

                    } else if (inputNumero == 3) {
                        partida = finalizarPartida();

                    } else System.out.println("Error. Selecciona una opción válida.");

                } catch (NumberFormatException e) {
                    System.out.println("Error de entrada, introduce un número.");
                    System.out.println();
                }

            } else if (!turno) {
                jugada = true;

                mostrarTurno(jugador2);

                try {

                    inputNumero = escogerOpcion(inputLinea, inputNumero, inputJugador);

                    if (inputNumero == 0) {
                        if (!tablero.estaVacio()) {
                            mostrarTablero(tablero);
                        } else {
                            tableroVacio();
                        }
                    } else if (inputNumero == 1) { //Poner carta
                        while (jugada) {
                            try {

                                inputNumero = escogerCarta(inputLinea, inputNumero, inputJugador);

                                if (tablero.estaVacio()) {
                                    ponerCarta(tablero, jugador2, inputNumero);
                                    jugada = false;
                                    turno = true;

                                } else if (jugador2.usarCarta(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                                        jugador2.usarCarta(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                                    ponerCarta(tablero, jugador2, inputNumero);
                                    mostrarTablero(tablero);
                                    jugada = false;
                                    turno = true;

                                } else {
                                    cartaNoCompatible();
                                    mostrarTablero(tablero);
                                    jugada = false;
                                }

                                if (jugador2.getNumeroCartas() == 0) {
                                    haGanado(jugador2);
                                    partida = false;
                                }

                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Error de entrada. La posición introducida no es válida.");
                            } catch (NumberFormatException e) {
                                System.out.println("Error de entrada. Debes introducir un número.");
                            }
                        }
                    } else if (inputNumero == 2) {

                        if (monton.estaVacio()){
                            generarMonton(monton, NUM_COLOR, NUM_CARTA);
                        } else {
                            haCogidoCarta(jugador2, monton);
                        }

                    } else if (inputNumero == 3) {
                        partida = finalizarPartida();
                    } else System.out.println("Error. Selecciona una opción válida.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de entrada, introduce un número.");
                    System.out.println();
                }
            }
        }
    }


    /**
     * Muestra por pantalla que la partida ha finalizado
     * @return devuelve boolean partida = false para terminar la partida.
     */
    private static boolean finalizarPartida() {
        boolean partida;
        System.out.println("Terminando la partida...");
        partida = false;
        return partida;
    }

    /**
     * Proporciona al jugador un numero determinado de cartas mediante el método robarCarta().
     * @param monton stack del que se obtienen las cartas
     * @param jugador objeto al que se le asignan las cartas
     * @param CARTAS_INICIALES numero de cartas con el que se juega la partida
     */
    private static void asignarCartas(Monton monton, Jugador jugador, int CARTAS_INICIALES) {
        for (int contador = 0; contador < CARTAS_INICIALES; contador++) {
            jugador.robarCarta(monton);
        }
    }

    /**
     * Jugador roba una carta del montón y muestra por pantalla que ha robado y su mano actual.
     * @param jugador objeto que con el método robarCarta() asgina el último elemento del stack monton al arraylist Mano
     * @param monton stack en el que se encuentran los elementos Carta.
     */
    private static void haCogidoCarta(Jugador jugador, Monton monton) {
        jugador.robarCarta(monton);
        System.out.println("Has cogido una carta y esta es tu mano: ");
        System.out.println(jugador.mostrarMano());
        System.out.println();
    }

    /**
     * Muestra por pantalla que el stack de tablero no tiene ningún elemento
     */
    private static void tableroVacio() {
        System.out.println("El tablero está vacío. Prueba a poner una carta.");
        System.out.println();
    }

    /**
     * Muestra por pantalla que el jugador ha ganado junto a un mensaje.
     * @param jugador objeto con atributo se mostrará mediante el método getNombre().
     */
    private static void haGanado(Jugador jugador) {
        System.out.println(jugador.getNombre() + " se ha quedado sin cartas y ha ganado.");
    }

    /**
     * Muestra por pantalla que la carta no es compatible.
     */
    private static void cartaNoCompatible() {
        System.out.println("Esa carta no es compatible, prueba con otra o roba.");
        System.out.println();
    }

    /**
     * Asigna al stack del tablero un elemento carta del arraylist mano del jugador, seleccionando
     * el elemento indicando su posición el la lista.
     * @param tablero objeto a cuyo stack se le asigna un elemento carta.
     * @param jugador objeto que poseé el arraylist mano del que se obiene el elemento carta
     * @param inputNumero entrada del usuario para escoger el elemento de la lista mano del objeto jugador
     */
    private static void ponerCarta(Tablero tablero, Jugador jugador, int inputNumero){
        tablero.ponerCarta(jugador.usarCarta(inputNumero));
        jugador.quitarCarta(inputNumero);
        System.out.println(jugador.getNombre() + " ha colocado una carta.");
        System.out.println();
    }

    /**
     * Pregunta al usuario por la carta a usar.
     * @param inputLinea almacena la entrada del jugador como una String.
     * @param inputNumero castea la String de inputLinea a un entero.
     * @param inputJugador objeto Scanner que permite introducir datos.
     * @return Devuelve un entero que hace refencia a la posición de la carta en la mano del jugador.
     */
    private static int escogerCarta(String inputLinea, int inputNumero, Scanner inputJugador){
        System.out.println("Escoge la carta indicando su posición en tu mano: ");
        inputLinea = inputJugador.next();
        inputNumero = Integer.parseInt(inputLinea);
        inputNumero--;
        return inputNumero;
    }

    /**
     * Pregunta al usuario que operación va a realizar.
     * @param inputLinea almacena la entrada del jugador como una String.
     * @param inputNumero castea la String de inputLinea a un entero.
     * @param inputJugador objeto Scanner que permite introducir datos.
     * @return Devuelve un entero que hace refencia a la opción que ha escogido el usuario.
     */
    private static int escogerOpcion(String inputLinea, int inputNumero, Scanner inputJugador){
        System.out.println("Selecciona una opción: ");
        System.out.println("0. Mostrar tablero");
        System.out.println("1. Poner carta");
        System.out.println("2. Robar carta");
        System.out.println("3. Terminar partida");
        inputLinea = inputJugador.next();
        inputNumero = Integer.parseInt(inputLinea);
        return inputNumero;
    }

    /**
     * Muestra un mensaje indicando a quien pertenece el turno junto con su mano
     * @param jugador objeto al que se hace referencia por pantalla
     */
    private static void mostrarTurno(Jugador jugador) {
        System.out.println("Es el turno de: " + jugador.getNombre());
        System.out.println("Esta es tu mano con " + jugador.getNumeroCartas() + " carta(s): ");
        System.out.println(jugador.mostrarMano());
        System.out.println();
    }

    /**
     * Muestra por pantalla el tablero y su última carta.
     * @param tablero objeto que contiene el stack al que se hace referencia
     */
    private static void mostrarTablero(Tablero tablero) {
        System.out.println("--- --- --- ---");
        System.out.println("Este es el tablero: ");
        System.out.println(tablero.ultimaCarta());
        System.out.println("--- --- --- ---");
        System.out.println();
    }

    /**
     * Se encarga de asignar todas las cartas del juego al montón y para luego barajarlas.
     * @param monton objeto que cuenta con el stack del que se obtienen los elementos
     * @param NUM_COLOR constante que hace refencia al número de colores en el juego Uno
     * @param NUM_CARTA constante que hace referencia a los números impresos en las cartas del juego Uno
     */
    private static void generarMonton(Monton monton, int NUM_COLOR, int NUM_CARTA) {

        //Rellenar monton con cartas azules, se rellena el stack con 18 cartas del 1 al 9 de color azul
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero <= NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("azul", numero));
            }
        }

        //Rellenar monton con cartas rojas
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero <= NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("rojo", numero));
            }
        }

        //Rellenar monton con cartas amarillas
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero <= NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("amarillo", numero));
            }
        }

        //Rellenar monton con cartas verdes
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero <= NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("verde", numero));
            }
        }
        monton.barajar();
    }
}
