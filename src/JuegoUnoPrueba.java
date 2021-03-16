import java.util.Scanner;

public class JuegoUnoPrueba {
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
        final int NUM_CARTA = 10;
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
                //De aquí hasta el final del turno debe ser una función
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
                            jugador1.robarCarta(monton);
                            haCogidoCarta(jugador1);
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
                            jugador2.robarCarta(monton);
                            haCogidoCarta(jugador2);
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

    private static boolean finalizarPartida() {
        boolean partida;
        System.out.println("Terminando la partida...");
        partida = false;
        return partida;
    }

    private static void asignarCartas(Monton monton, Jugador jugador, int CARTAS_INICIALES) {
        for (int contador = 0; contador < CARTAS_INICIALES; contador++) {
            jugador.robarCarta(monton);
        }
    }

    private static void haCogidoCarta(Jugador jugador) {
        System.out.println("Has cogido una carta y esta es tu mano: ");
        System.out.println(jugador.mostrarMano());
        System.out.println();
    }

    private static void tableroVacio() {
        System.out.println("El tablero está vacío. Prueba a poner una carta.");
        System.out.println();
    }

    private static void haGanado(Jugador jugador) {
        System.out.println(jugador.getNombre() + " se ha quedado sin cartas y ha ganado.");
    }

    private static void cartaNoCompatible() {
        System.out.println("Esa carta no es compatible, prueba con otra o roba.");
        System.out.println();
    }

    private static void ponerCarta(Tablero tablero, Jugador jugador, int inputNumero){
        tablero.ponerCarta(jugador.usarCarta(inputNumero));
        jugador.quitarCarta(inputNumero);
        System.out.println(jugador.getNombre() + " ha colocado una carta.");
        System.out.println();
    }

    private static int escogerCarta(String inputLinea, int inputNumero, Scanner inputJugador){
        System.out.println("Escoge la carta indicando su posición en tu mano: ");
        inputLinea = inputJugador.next();
        inputNumero = Integer.parseInt(inputLinea);
        inputNumero--;
        return inputNumero;
    }

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

    private static void mostrarTurno(Jugador jugador) {
        System.out.println("Es el turno de: " + jugador.getNombre());
        System.out.println("Esta es tu mano con " + jugador.getNumeroCartas() + " carta(s): ");
        System.out.println(jugador.mostrarMano());
        System.out.println();
    }

    private static void mostrarTablero(Tablero tablero) {
        System.out.println("--- --- --- ---");
        System.out.println("Este es el tablero: ");
        System.out.println(tablero.ultimaCarta());
        System.out.println("--- --- --- ---");
        System.out.println();
    }

    /*
    Función generarMonton, se encarga de asignar todas las cartas del juego al montón y barajarlas
    Requiere del parametro de entrada 'monton' porque el objeto ha sido declarado e instanciado en main
     */
    private static void generarMonton(Monton monton, int NUM_COLOR, int NUM_CARTA) {

        //Rellenar monton con cartas azules, se rellena el stack con 18 cartas del 1 al 9 de color azul
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero < NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("azul", numero));
            }
        }

        //Rellenar monton con cartas rojas
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero < NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("rojo", numero));
            }
        }

        //Rellenar monton con cartas amarillas
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero < NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("amarillo", numero));
            }
        }

        //Rellenar monton con cartas verdes
        for (int color = 0; color < NUM_COLOR; color++) {
            for (int numero = 1; numero < NUM_CARTA; numero++) {
                monton.ponerCarta(new Carta("verde", numero));
            }
        }
        monton.barajar();
    }
}
