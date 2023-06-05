import java.util.Random;

public class App {
    public static final int MAX = 20, MAXVALOR = 9, MINVALOR = 1;
    public static final double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int[] arr = new int[MAX], arrInicios;
        cargar_arreglo_aleatorio_secuencias_int(arr); //REUTILIZAMOS
        mostrar(arr);
        // imprimir_suma_cada_secuencia(arr);
        arrInicios=contadorSecuencia(arr);
        mostrar(arrInicios);
        cargar_arrIncios(arrInicios, arr);
        mostrar_Ante_Ultima_secuencia(arrInicios, arr);
    }

    public static int[] contadorSecuencia(int[] arr) {
        int inicio=0, fin=-1,  cont=0;
            while(inicio<MAX){
                inicio  = obtener_inicio_secuencia(arr, fin+1);     
                if(inicio<MAX){
                    fin=obtener_fin_secuencia(arr, inicio);
                    cont++;
                }
            }
        int[] arrInicios = new int [cont];
        return arrInicios;
    }

    public static void cargar_arrIncios(int[] arrIni, int[] arr) {
        int inicio=0, fin=-1, cont=0;
        while ((inicio < MAX)){
            inicio = obtener_inicio_secuencia(arr,fin+1);
            if (inicio < MAX){
                fin = obtener_fin_secuencia(arr,inicio);
                arrIni[cont]=inicio;
                cont++;
            }
        }
        mostrar(arrIni);
    }


    /* public static void imprimir_suma_cada_secuencia(int[] arr){
    int inicio=0,fin=-1,suma;
        while ((inicio < MAX)){
            inicio = obtener_inicio_secuencia(arr,fin+1);
            if (inicio < MAX){
                fin = obtener_fin_secuencia(arr,inicio);
                suma = obtener_suma_secuencia(arr,inicio,fin);
                System.out.println("La suma de la secuencia de "+inicio+" a "+fin+" es "+suma);
            }
        }
    } */

    public static void mostrar_Ante_Ultima_secuencia(int[] arrIni, int[]arr) {
        int i, j = arrIni[arrIni.length-2];
        i=j;
        while(arr[j]!=0){
            // System.out.print(arr[i] + " ");
            j++;
        }
        System.out.println(" Inicia con " + arr[i] + " Y termina con " + arr[j-1] );
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

    /* public static int obtener_suma_secuencia(int[] arr, int inicio, int fin){
        int suma = 0;
        while (inicio <= fin){
            suma+=arr[inicio];
            inicio++;
        }
        return suma;
    }    */

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

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println(" ");
    }
}
