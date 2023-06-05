import java.util.Random;

public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[][] matriz = new int [5][10];
        cargar_matriz(matriz);
        mostrar(matriz);
        intercambiar_orden(matriz);
        System.out.println(" ");
        System.out.println(matriz.length);
        mostrar(matriz);
    }

    // 1 2 3 4 5
    // 5 4 3 2 1

    public static void intercambiar_orden(int[][] mat) {
        int aux;
        for (int i = 0; i < mat.length; i++) {
            int k = 9;
            for (int j = 0; j < 10; j++) {
                if(k>j){
                    aux = mat[i][j];
                    mat[i][j] = mat[i][k];
                    mat[i][k] = aux;
                    k--;
                }
            }
        }
    }

    public static void cargar_matriz(int[][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < 5; fila++){
            for (int col = 0; col < 10; col++) {
                mat[fila][col] = (r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);   
            }
        }
        
    }

    public static void mostrar(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < 10; j++) {
                System.out.print(mat[i][j] + ", ");
            }
        }
    }
}
