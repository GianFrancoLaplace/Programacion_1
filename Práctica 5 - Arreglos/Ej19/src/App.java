import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int [] array = new int [MAX], newarr, arrI;
        int userN, cont;
        cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);
        System.out.println("Tamaño de secuencia a boorar");
        userN = Integer.valueOf(in.readLine());
        cont = contador_de_secuencias_userN(array, userN);
        if(cont!=0){
            newarr = new int[MAX-cont*userN];
            arrI = new int [cont];
            cargarInicios(array, arrI, userN);
            EliminarSecuencias(array, arrI, newarr, userN);
        }else{
            System.out.println("No hay secuencias del tamaño pedido ");
        }
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

    public static int contador_de_secuencias_userN(int[] arr, int n) {
        int i=0, inicio=0, fin=-1;
        int[] arrI;
        while(inicio<MAX){
            inicio = obtener_inicio_secuencia(arr,fin+1);
            if (inicio < MAX){
                fin = obtener_fin_secuencia(arr,inicio);
                if(fin-inicio==n-1){
                    i++;
                }
            }
        }
        return i;
    }

    /* public static void EliminarSecuencias(int[] arr, int[] newArr, int n) {
        int i=0,j=0, inicio=0, fin=-1;
        while(inicio<MAX){
            inicio=obtener_fin_secuencia(arr, fin+1);
            if(inicio<MAX){
                fin=obtener_fin_secuencia(arr, inicio);
                while(fin-inicio==n-1){
                    j++;

                }
            }
        }
    } */
    public static void EliminarSecuencias(int[] arr, int[] arrI ,int[] newArr, int n) {
        int j=0, k=0;
        for (int i = 0; i < newArr.length; i++) {
            if(arrI[k]==j){
                while(arr[j]!=0){
                    j++;
                }
                k++;
                if(k==arrI.length){
                    k--;
                }
                
            }
            newArr[i] = arr[j];
            j++;
        }
        mostrar(newArr);
    }

    public static void cargarInicios(int[] arr, int[] arrI, int n) {
        int i=0, inicio=0, fin=-1;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if(inicio<MAX){
                fin=obtener_fin_secuencia(arr, inicio);
                if(fin-inicio==n-1){
                    arrI[i]=inicio;
                    i++;
                }
            }
        }
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]!=0)
            ini++;
        return ini-1;
    }
        
    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
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

    
    
}
