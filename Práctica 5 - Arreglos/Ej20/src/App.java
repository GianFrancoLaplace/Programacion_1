/* Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo. */

import java.util.Random;

public class App {
    public static int MAX=20, MAXVALOR=9,MINVALOR=0;
    public static double probabilidad_numero=0.4;
    // contar coincidencias 
    // Hacer un nuevo arrray
    // Llenar el array pasando por alto coincidencias
    public static void main(String[] args) throws Exception {
        int[] array = new int[MAX], patron = {1,2,3}, newArr;
        cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);
        int cont;
        cont= contador_De_Coincidencias(array, patron);
        newArr= new int[MAX-cont];
        if(cont!=0){
            eliminar_Coincidencias(array, patron, newArr, cont);
            mostrar(newArr);
        }else{
            System.out.println("No hay coincidencias ");
        }
    }

    public static int contador_De_Coincidencias(int[] arr, int[] p){
        int cont=0, j=0;
        for (int i = 1; i < MAX-1; i++) {
            j=0;
            while(j<p.length){
                if(arr[i]==p[j]){ //Da vueltas de más
                    cont++;
                }
                j++;
            }
        }
        System.out.println("cont " + cont);
        return cont;
    }

    public static void eliminar_Coincidencias(int[] arr, int[] p, int[] newArr, int cont) {
        int j=0, k=0;
        boolean coincide=false;

        for (int i = 0; i <MAX; i++) {
            j=0;
            coincide=false;
            
            while(j<p.length){
                if(arr[i]==p[j] || coincide==true) //Da vueltas de más
                    coincide=true;
                j++;
            }
            if(coincide!=true){
                newArr[k]=arr[i];
                k++;
            }
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

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println(" ");
    }
}
