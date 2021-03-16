import java.util.Scanner;

public class JuegoUno {
    public static void main(String[] args) {

        //Declaración de objetos
        Monton monton;
        Tablero tablero;
        Jugador jugador1;
        Jugador jugador2;
        Scanner inputJugador;
        String inputLinea;

        //Declaración e inicialización de variables
        final int CARTAS_INICIALES = 4;
        final int NUM_COLOR = 2;
        final int NUM_CARTA = 10;
        int inputNumero;
        boolean turno = true;
        boolean partida = true;
        boolean jugada;

        //Instanciación de objetos
        monton = new Monton();
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador1");
        jugador2 = new Jugador("Jugador2");
        inputJugador = new Scanner(System.in);

        //Debe ser algo así en el juego, pero carta es la que escribe el usuario y debe estar en su mano?

        generarMonton(monton, NUM_COLOR, NUM_CARTA);

        /*
        System.out.println("Longitud del montón y el montón: ");
        System.out.println(monton.longitud());
        System.out.println(monton.toString());
         */


        //Rellenamos la carta de los jugadores
        for (int contador = 0; contador < CARTAS_INICIALES; contador++) {
            jugador1.robarCarta(monton);
            jugador2.robarCarta(monton);
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
        while (partida) {

            /*
            System.out.println("--- --- --- ---");
            System.out.println("Este es el tablero: ");
            System.out.println(tablero.ultimaCarta());
            System.out.println("--- --- --- ---");
            System.out.println();

             */

            if (turno) {
                jugada = true;

                mostrarTurno(jugador1);

                try {
                    System.out.println("Selecciona una opción: ");
                    System.out.println("0. Mostrar tablero");
                    System.out.println("1. Poner carta");
                    System.out.println("2. Robar carta");
                    System.out.println("3. Terminar partida");
                    inputLinea = inputJugador.next();
                    inputNumero = Integer.parseInt(inputLinea);

                    if (inputNumero == 0) {
                        if (!tablero.estaVacio()) {
                            mostrarTalbero(tablero);
                        } else {
                            System.out.println("El tablero está vacío. Prueba a poner una carta.");
                            System.out.println();
                        }
                    } else if (inputNumero == 1) { //Poner carta
                        while (jugada) {
                            try {
                                System.out.println("Escoge la carta indicando su posición en tu mano: ");

                                inputLinea = inputJugador.next();
                                inputNumero = Integer.parseInt(inputLinea);
                                inputNumero--;
                                if (tablero.estaVacio()) {
                                    tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                                    jugador1.usarCarta(inputNumero);
                                    System.out.println(jugador1.getNombre() + " ha colocado una carta.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                    turno = false;
                                } else if (jugador1.getMano().get(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                                        jugador1.getMano().get(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                                    tablero.ponerCarta(jugador1.getMano().get(inputNumero));
                                    jugador1.usarCarta(inputNumero);
                                    System.out.println(jugador1.getNombre() + " ha colocado una carta.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                    turno = false;
                                } else {
                                    System.out.println("Esa carta no es compatible, prueba con otra o roba.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                }

                                if (jugador1.getNumeroCartas() == 0) {
                                    System.out.println(jugador1.getNombre() + " se ha quedado sin cartas y ha ganado.");
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
                            //monton.ponerCarta(tablero.rellenarMonton());
                            generarMonton(monton, NUM_COLOR, NUM_CARTA);
                        } else {
                            jugador1.robarCarta(monton);
                            System.out.println("Has cogido una carta y esta es tu mano: ");
                            System.out.println(jugador1.mostrarMano());
                            System.out.println();
                        }

                    } else if (inputNumero == 3) {
                        System.out.println("Terminando la partida...");
                        partida = false;
                    } else System.out.println("Error. Selecciona una opción válida.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de entrada, introduce un número.");
                    System.out.println();
                }
            } else if (!turno) {
                jugada = true;

                mostrarTurno(jugador2);

                try {
                    System.out.println("Selecciona una opción: ");
                    System.out.println("0. Mostrar tablero");
                    System.out.println("1. Poner carta");
                    System.out.println("2. Robar carta");
                    System.out.println("3. Terminar partida");
                    inputLinea = inputJugador.next();
                    inputNumero = Integer.parseInt(inputLinea);

                    if (inputNumero == 0) {
                        if (!tablero.estaVacio()) {
                            mostrarTalbero(tablero);
                        } else {
                            System.out.println("El tablero está vacío. Prueba a poner una carta.");
                            System.out.println();
                        }
                    } else if (inputNumero == 1) { //Poner carta
                        while (jugada) {
                            try {
                                System.out.println("Escoge la carta indicando su posición en tu mano: ");

                                inputLinea = inputJugador.next();
                                inputNumero = Integer.parseInt(inputLinea);
                                inputNumero--;
                                if (tablero.estaVacio()) {
                                    tablero.ponerCarta(jugador2.getMano().get(inputNumero));
                                    jugador2.usarCarta(inputNumero);
                                    System.out.println(jugador2.getNombre() + " ha colocado una carta.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                    turno = true;
                                } else if (jugador2.getMano().get(inputNumero).getColor().equals(tablero.ultimaCarta().getColor()) |
                                        jugador2.getMano().get(inputNumero).getNumero() == (tablero.ultimaCarta().getNumero())) {
                                    tablero.ponerCarta(jugador2.getMano().get(inputNumero));
                                    jugador2.usarCarta(inputNumero);
                                    System.out.println(jugador2.getNombre() + " ha colocado una carta.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                    turno = true;
                                } else {
                                    System.out.println("Esa carta no es compatible, prueba con otra o roba.");
                                    System.out.println();
                                    mostrarTalbero(tablero);
                                    jugada = false;
                                }

                                if (jugador2.getNumeroCartas() == 0) {
                                    System.out.println(jugador2.getNombre() + " se ha quedado sin cartas y ha ganado.");
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
                            System.out.println("Has cogido una carta y esta es tu mano: ");
                            System.out.println(jugador2.mostrarMano());
                            System.out.println();
                        }

                    } else if (inputNumero == 3) {
                        System.out.println("Terminando la partida...");
                        partida = false;
                    } else System.out.println("Error. Selecciona una opción válida.");
                } catch (NumberFormatException e) {
                    System.out.println("Error de entrada, introduce un número.");
                    System.out.println();
                }
            }
        }
    }

    private static void mostrarTurno(Jugador jugador1) {
        System.out.println("Es el turno de: " + jugador1.getNombre());
        System.out.println("Esta es tu mano con " + jugador1.getNumeroCartas() + " carta(s): ");
        System.out.println(jugador1.mostrarMano());
        System.out.println();
    }

    private static void mostrarTalbero(Tablero tablero) {
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
