package examen;

import java.util.Scanner;

public class clsPrincipal {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Declaramos las variables
        int opcion;             //Variable donde guardaremos la opcion del menu elegida por el usuario
        int fila, columna;      //Variables donde guardaremos la fila y la columna introducida por el usuario
        boolean salir = false;  //Variable que indicará cuando va a acabar el programa
        String password;        //Variable donde vamos a guardar la contraseña introducida por el usuario

        //Llamamos al metodo rellenar matriz para rellenar el array de cantidades que estaba previamente vacío
        clsUtilidades.rellenarMatriz(clsUtilidades.cantidadInicialGolosinas);

        do {        //Minetras la variable booleana salir sea false

            //Imprimo el menu de opciones por pantalla
            System.out.println("""
                ---MAQUINA EXPENDEDORA---
                [1] Mostrar golosinas
                [2] Pedir golosinas
                [3] Rellenar golosinas
                [4] Apagar maquina
                """);

            //Le pido al usuario que introduzca por consola la opción que quiera
            System.out.println("Indique la opcion que desee");
            opcion = sc.nextInt();

            switch (opcion) {
                //si elige 1, llamamos a la función mostrarGolosinas()
                case 1 -> clsUtilidades.mostrarGolosinas();

                //Si elige 2, le pedimos que introduzca la posicion de la golosina que desea comprar
                case 2 -> {
                    System.out.println("Indique la posicion de la golosina que desea consumir");
                    System.out.println("Fila: ");
                    fila = sc.nextInt();
                    System.out.println("Columna: ");
                    columna = sc.nextInt();

                    //Si la posicion que ha introducido existe
                    if (clsUtilidades.validarPos(fila, columna) == true) {

                        //Si la golosina tiene existencias
                        if (clsUtilidades.hayValorPosicion(fila, columna) == true) {

                            //Llamamos al metodo anyadirVenta() y reducirPosicion()
                            clsUtilidades.anyadirVenta(fila, columna);
                            clsUtilidades.reducirPosicion(fila, columna, clsUtilidades.CANTIDAD_ANYADIR_REDUCIR_GOLOSINA);

                            //Le indicamos al usuario que ha comprado con éxito su golosina
                            System.out.println("Aqui tiene su golosina");

                        } else {    //Si la golosina no tiene existencias, se lo decimos al usuario por consola
                            System.out.println("No quedan existencias");
                        }
                    } else {    //Si la posición introducida no existe, se lo notificamos al usuario por consola
                        System.out.println("Codigo inexistente");
                    }
                }

                //Si elige 3, le pedimos que introduzca la contraseña antes de seguir
                case 3 -> {
                    System.out.println("Debe introducir la password para poder realizar esta accion: ");
                    password = sc.next();

                    //Si la contraseña introducida es distinta de la que hemos indicado previamente en la clase Utilidades, entoces
                    // indicamos que la contraseña es incorrecta y volvemos a mostrar el menu
                    if (!password.equals(clsUtilidades.PASSWORD)) {
                        System.out.println("Password incorrecta");

                    } else {    //Si la contraseña es correcta, le pedimos que introduzca la posicion de la golosina que desea reponer

                        System.out.println("Indique que golosina desea reponer: ");
                        System.out.println("Fila: ");
                        fila = sc.nextInt();
                        System.out.println("Columna: ");
                        columna = sc.nextInt();

                        if (clsUtilidades.validarPos(fila, columna) == true) { //Si el codigo introducido existe

                            // Aumentamos la cantidad del producto seleccionado
                            clsUtilidades.aumentarPosicion(fila, columna, clsUtilidades.CANTIDAD_ANYADIR_REDUCIR_GOLOSINA);

                            //Le indicamos al usuario que la máquina ha sido rellenada conéxito
                            System.out.println("Golosina repuesta con exito");

                        } else{ //Si no existe, se lo indicamos al usuario por consola
                            System.out.println("Codigo inexistente");
                        }
                    }
                }
                //Si elige 4, llamamos a la clase imprimirVentasTotales(), e indicamos que la variable salir es true
                // por lo que se sale del bucle y termina el programa
                case 4 -> {
                    clsUtilidades.imprimirVentasTotales();
                    salir = true;
                }
                //Si elige algo distinto a las opciones anteriormente mostradas, le indicamos por consola que la
                // opción escogida no es válida
                default -> System.out.println("Opción no valida");
            }
        }while (!salir);
    }
}