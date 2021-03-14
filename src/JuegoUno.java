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
        Carta carta;

        Scanner inputJugador = new Scanner(System.in);
        String inputColor;
        String inputLinea;
        int inputNumero;

        monton = new Monton();
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador1", 9);

        //Debe ser algo así en el juego, pero carta es la que escribe el usuario y debe estar en su mano?

        generarMonton(monton);

        System.out.println("Longitud del montón y el montón: ");
        System.out.println(monton.longitud());
        System.out.println(monton.toString());

        for (int contador = 0; contador<jugador1.getNumeroCartas(); contador++){
            jugador1.robarCarta(monton);
        }

        //Se debe hacer de modo que solo haya un objeto Jugador? O deben haber 2?

        System.out.println();
        System.out.println("La longitud de la mano y la mano de jugador1 es:");
        System.out.println(jugador1.getNumeroCartas());
        System.out.println(jugador1.mostrarMano());


        System.out.println();
        //carta es un único objeto que siempre rellena el usuario con los datos introducidos

        //while boolean jugada = true
        //Preguntamos al usuario por la carta a usar
        System.out.println("Color de la carta a usar: ");
        inputColor = inputJugador.next();
        System.out.println("Número de la carta a usar: ");

        inputLinea = inputJugador.next();
        inputNumero = Integer.parseInt(inputLinea);

        carta = new Carta(inputColor, inputNumero);

        //jugador1.mano.add(carta); //Si añado la carta manualmente sí que la encuentra

        if (jugador1.contieneCarta(carta)){ //La condición nunca se cumple pero sí debería
            tablero.ponerCarta(carta);
            System.out.println("Sí tenías la carta");
            System.out.println(jugador1.getNumeroCartas());
            //jugada = false;
        } else System.out.println("No tienes esa carta en la mano :(");
        //jugada sigue siendo true y repetimos

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
