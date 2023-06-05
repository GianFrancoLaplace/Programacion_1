import java.util.Random;

public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static void main(String[] args) throws Exception {
       
        int [] array = new int [MAX], arrSumas;
        cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);
        arrSumas = contador_de_secuencias(array);
        // imprimir_suma_cada_secuencia(array);
        llenar_sumas(array, arrSumas);
        imprimir_suma_mas_alta(arrSumas);

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

    public static int[] contador_de_secuencias(int[] arr){
        int inicio=0,fin=-1,suma, cont=0;
        int[] arrSumas;
        while ((inicio < MAX)){
            inicio = obtener_inicio_secuencia(arr,fin+1);
            if (inicio < MAX){
                fin = obtener_fin_secuencia(arr,inicio);
                cont++;
                System.out.println(cont);
            }
        }
        return arrSumas = new int[cont];
    }

    public static void llenar_sumas(int[] arr, int[] arrSumas) {
        int inicio=0, fin=-1, suma, cont=0;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if(inicio<MAX){
                fin = obtener_fin_secuencia(arr,inicio);
                suma = obtener_suma_secuencia(arr,inicio,fin);
                arrSumas[cont] =suma;
                cont++;
                System.out.println("La suma de la secuencia de "+inicio+" a "+fin+" es "+suma);
            }
        }
        mostrar(arrSumas);
    }

    public static void imprimir_suma_mas_alta(int[] arr){
        int suma=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(suma<arr[i])
                suma=arr[i];
            }
        System.out.println(suma + " Suma + alta");
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
        
    public static int obtener_suma_secuencia(int[] arr, int inicio, int fin){
        int suma = 0;
        while (inicio <= fin){
            suma+=arr[inicio];
            inicio++;
        }
        return suma;
    }   

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println(" ");
    }
}
