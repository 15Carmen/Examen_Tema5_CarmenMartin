package examen;

import java.util.Arrays;

public class clsUtilidades {

    //Declaramso los arrays globales
    static String[][] nombresGolosinas = {
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
    };
    static double[][] precio = {
            {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}
    };
    static int[][] cantidades = new int[4][4];
    static String[] ventas = new String[0];

    //Declaramos las variables globales
    static int cantidadInicialGolosinas = 5;
    static double precioTotalVentas = 0;

    //Declaramos las constantes globales
    static final int CANTIDAD_ANYADIR_REDUCIR_GOLOSINA = 1;
    static final String PASSWORD = "Maquina2023";
    static final int LONGITUD_TABLAS = 4;


    /**
     * Precondición: el array cantidades debe estar previamente vacío
     * Método que va a rellenar el array cantidades con
     * @param num, que introduceremos por parámetros.
     */
    static void rellenarMatriz(int num) {

        for (int fila = 0; fila < cantidades.length; fila++) {
            for (int col = 0; col < cantidades[1].length; col++) {
                cantidades[fila][col] = num;
            }
        }
    }

    /**
     * Método que imprimirá por consola el código de la golosina, el nombre de la misma y su precio
     */
    public static void mostrarGolosinas() {
        for (int fila = 0; fila < nombresGolosinas.length; fila++) {
            for (int col = 0; col < nombresGolosinas[0].length; col++) {
                System.out.print("Code: [" + fila + col + "]\t");
                System.out.print("Product: " + nombresGolosinas[fila][col] + "\t");
                System.out.println("Price: " + precio[fila][col] + "\n");
            }

        }
    }

    /**
     * Método que comprobará si la
     * @param fila y la
     * @param col introducidos por parámetro son menores que la longitud máxima de las tablas (4)
     * @return una variable booleana true si son menores que la longitud  y false si son mayores
     */
    public static boolean validarPos(int fila, int col) {
        boolean posValida = false;

        if (fila < LONGITUD_TABLAS && col < LONGITUD_TABLAS) {
            posValida = true;
        }
        return posValida;
    }

    /**
     * Método que indica si en la posición indicada por el usuario (que sabemos por
     * @param fila y por
     * @param columna), hay un valor mayor que 0 en la tabla de cantidades, es decir,
     * quedan existencias de la golosina en cuestión.
     * @return un booleano que indica si quedan o no existencias
     */
    public static boolean hayValorPosicion(int fila, int columna) {

        boolean hayExistencias = false;
        if (cantidades[fila][columna]>0){
            hayExistencias = true;
        }
        return hayExistencias;
    }

    /**
     * Método que a la posición indicada por
     * @param fila y por
     * @param columna se le suma la
     * @param cantidad introducida por parámetro a la tabla de cantidades.
     */
    public static void aumentarPosicion(int fila, int columna, int cantidad){
        cantidades[fila][columna] += cantidad;
    }

    /**
     * Método que a la posición indicada por
     * @param fila y por
     * @param columna se le resta la
     * @param cantidad introducida por parámetro a la tabla de cantidades.
     */
    public static void reducirPosicion(int fila, int columna, int cantidad){
        cantidades[fila][columna] -= cantidad;
    }

    /**
     *  Método que añade a la tabla de ventas el nombre de la golosina seleccionada introduciendo por parámetrod
     * @param fila y
     * @param columna  y le suma a la variable precioTotalVentas el precio de la golosina seleccionada.
     */
    public static void anyadirVenta(int fila, int columna){
        //aumentamos el tamaño del array de ventas
        ventas = Arrays.copyOf(ventas, ventas.length+1);

        //introducimos en la última posicion del array el nombre de la golosina comprada
        ventas[ventas.length-1] = nombresGolosinas[fila][columna];

        //Le sumamos a la variable de precio total de las ventas, lo que cuesta el producto seleccionado
        precioTotalVentas += precio[fila][columna];
    }

    /**
     *  Método que imprime por pantalla tanto los nombres de las golosinas pedidas como el precio total de la venta.
     */
    public static void imprimirVentasTotales(){
        System.out.println("Estas son todas las golosinas que se han comprado: \n"+ Arrays.toString(ventas));
        System.out.println("Se ha recaudado en total: " + precioTotalVentas + "€ con las ventas.");
    }


}
