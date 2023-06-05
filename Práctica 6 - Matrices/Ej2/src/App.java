import java.util.Random;

public class App {
    public static final int MAXCOL=10, MAXVALOR=100, MINVALOR=1;;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int [][] mat = new int [31][MAXCOL];
        int promedio;
        cargar_matriz(mat);
        mostrar(mat);
        promedio = promedio_tickets(mat);
        System.out.println(promedio);
    }
    public static void cargar_matriz(int[][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < 31; fila++){
            for (int col = 0; col < MAXCOL; col++) {
                mat[fila][col] = (r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);   

            }
        }
    }
    // CADA COLUMNA ES UNA VENTA(TICKET);
    // LA CUAL TIENE UN PRECIO;

    /* 
        1, 3, 6, 9
        6, 7, 8, 1 
        8 tickets
        promedio de ventas 
     */

    public static int promedio_tickets(int [][] mat) {
        int promedio=0;
        for (int i = 0; i < mat.length; i++) {
            for (int k = 0; k < MAXCOL; k++) {
                promedio+= mat[i][k];
            }
        }
        promedio = promedio/31;
        return promedio;
    }

    public static void mostrar(int[][] mat) {
        for (int i = 0; i < 31; i++) {
            System.out.println(" ");
            for (int j = 0; j < MAXCOL; j++) {
                System.out.print(mat[i][j] + ", ");
            }
        }
    }
}
