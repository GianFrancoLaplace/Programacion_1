import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int[] array = new int[MAX];
        int userN;
        cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);
        System.out.println("Número ");
        userN = Integer.valueOf(in.readLine());
        secuencia_mas_cercana(array, userN);
    }

    public static void secuencia_mas_cercana(int[] arr, int userN) {
        int i=userN, j=userN;
        if(arr[i]!=0){
            /* while(arr[i]!=0){
                i--;
            }
            i++;
            System.out.println("La secuencia inicia en " + i);
            while(arr[j]!=0){
                j++;
            }
            j--;
            System.out.println("La secuencia termina en " + j); */
            while(arr[i]!=0 || arr[j]!=0){
                if(arr[i]!=0){
                    i--;
                }
                if(arr[j]!=0){
                    j++;
                }
            }
            i++;
            j--;
            System.out.println("La secuencia inicia en " + i);
            System.out.println("La secuencia termina en " + j); 
        }else{
            while(arr[i]==0){
                i++;
            }
            System.out.println("La posicion ingresada no esta dentro de una secuencia. La posición de inicio de la siguiente es: " + i );
            j=i;
            while(arr[j]!=0){
                j++;
            }
            j--;
            System.out.println("Y termina en la posición " + j);

        }
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]!=0)
            ini++;
        return ini-1;
    }
        
    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini){
        while (ini<MAX && arrEnteros[ini]==0)
            ini++;
        return ini;
    }

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_aleatorio_secuencias_int(int [] arr){
        Random r = new Random();
        arr[0] = 0;
        arr[MAX-1] = 0;
        for (int pos = 1; pos < MAX-1; pos++){
            if (r.nextDouble()>probabilidad_numero){
                arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
            }
            else{
            arr[pos]=0;
            }
        }
    }
}
