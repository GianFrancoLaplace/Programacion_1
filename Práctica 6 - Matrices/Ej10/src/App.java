import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class App {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static final int MAXF=4, MAXC=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero = 0.5;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[][] m = new int[MAXF][MAXC];
        char[][] l = {
            {' ', 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g', ' ', 'h', 'i', 'j', 'k', ' ', 'l', 'm', 'n', 'o', ' '},
            {' ', 'p', 'q', 'r', ' ', 's', 't', 'u', 'v', ' ', 'w', 'x', 'y', 'z', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'a', 'b', ' ', 'c', 'd', 'e', ' ', 'f', 'g', 'h', ' ', 'i', 'j', ' ', 'k', 'l', ' ', 'm', ' '},
            {' ', 'o', 'p', ' ', 'q', 'r', ' ', 's', 't', ' ', 'u', 'v', 'w', ' ', 'x', 'y', 'z', ' ', ' ', ' '}
        };
        int fil, col;
        cargar_matriz_aleatorio_secuencias_int(m);
        mostrar(m);
        System.out.println(" Fila ");
        fil = Integer.valueOf(in.readLine());
        System.out.println(" Columna");
        col = Integer.valueOf(in.readLine());

        inicio_y_fin(m, col, fil);

    }

    public static void inicio_y_fin(int[][] m, int c, int f) {
        int inicio=c, fin=-1;
        if(m[f][c]!=0){
            while(m[f][c]!=0){
                c--;
            }
            c++;
            inicio=c;
            if (inicio<MAXC && m[f][c]!=0){
                if(inicio<MAXC){
                    System.out.println("Inicio " + inicio);
                    fin=obtener_fin_secuencia(m, f, inicio);
                    System.out.println("Fin " + fin);
                }
            }
        }else{
            System.out.println("No escxiste ninguna secuencia en la posicion indicada");
        }
            
    }

    public static int obtener_fin_secuencia(int[][] arrEnteros, int f, int ini) {
        while (ini<MAXC && arrEnteros[f][ini]!=0)
            ini++;
        return ini-1;
    }

    public static int obtener_inicio_secuencia(int[][] arrEnteros, int f, int ini) {
        while (ini<MAXC && arrEnteros[f][ini]==0)
            ini++;
        return ini;
    }

    public static void cargar_matriz_aleatorio_secuencias_int(int [][] m){
        Random r = new Random();
        
        for (int i = 0; i < MAXF; i++){
            for (int j = 0; j < MAXC; j++) {
                if (r.nextDouble()>probabilidad_numero){
                    m[i][j]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
                }else{
                    m[i][j]=0;
                }
                if(j==0 || j==MAXC-1){
                    m[i][j]=0;
                }
            }
        }
    }

    public static void mostrar(int[][] mat) {
        for (int i = 0; i < MAXF; i++) {
            System.out.println(" ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(mat[i][j] + "| ");
            }
        }
    }
}
