import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class App {
    public static final int MAXF=4, MAXC=5, MAXVALOR=9, MINVALOR=0;
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[][] m = new int [4][5];
        cargar_matriz(m);
        mostrar(m);
        ordenar_creciente(m);
        System.out.println("Num a insertar");
        int userNum = Integer.valueOf(in.readLine());
        System.out.println("Fila: ");
        int userFila = Integer.valueOf(in.readLine());
        insertar(userNum, userFila, m);
        mostrar(m);
    }

    public static void insertar(int n, int f, int[][] m) {
        int j=1;
        while(j<=MAXF) {
            if(n<m[f][j]){
                m[f][j-1] = n;
                j=MAXF;
            }
            j++;
        }
        if(n>m[f][j-1])
            m[f][j-1] = n;
        
    }

    public static void ordenar_creciente(int[][] m) {
        int i=0, j=0, k=0;
        while(i < MAXF){
            while(j<MAXC){
                k=j;
                int aux=m[i][j];
                while((k>0) && (m[i][k-1]>aux)){
                    m[i][k] = m[i][k-1];
                    k--;
                }
                m[i][k]=aux;
                j++;
            }
            i++;
            j=0;
        }
        System.out.println();
        mostrar(m);
    }

    public static void cargar_matriz(int[][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < MAXF; fila++){
            for (int col = 0; col < MAXC; col++) {
                mat[fila][col] = (r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);   
            }
        }   
    }
    
    public static void mostrar(int[][] mat) {
        for (int i = 0; i < MAXF; i++) {
            System.out.println(" ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(mat[i][j] + "|");
            }
        }
    }
}
