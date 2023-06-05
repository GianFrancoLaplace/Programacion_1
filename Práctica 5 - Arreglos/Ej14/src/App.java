import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array = new int[20];

        array = llenarArr(array);
        firstsequence(array);

        // posIYF(array);
        // mostrar(array);
        
        // ordenar(array);

        // deleteOdd(array,countOdd(array));
        // mostrar(array);
    }
    public static int[] llenarArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int random = (int) (Math.random()*3+1);
            arr[i] = i*17;
            if(random == 3){
                arr[i]=0;
            }
        }
        mostrar(arr);
        return arr;
    }
    // public static void posIYF(int[] arr) {
    //     int i=0;
    //     while(arr[i] == 0) {
    //         i++;
    //     }
    //     System.out.println("El primer número es el " + arr[i]+ ", Se encuentra en la  " + i + "° posición del arreglo Del arreglo");
    //     i=arr.length-1;
    //     while(arr[i]==0){
    //         i--;
    //     }
    //     System.out.println("El ultimo número es el " + arr[i]+ ",Se encuentra la  " + i + "° posición Del arreglo");
    // }

    // private static int countZeros(int[] arr){
    //     int count=0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i]==0){
    //             count++;
    //         }
    //     }
    // }

    private static void firstsequence(int[] arr) {
        int firstPos, lastPos, j;
        j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                firstPos=i;   
                while(arr[j]!=0){
                    j++;
                }
                lastPos=j;
            System.out.println(firstPos+ ", " +lastPos);
            }
            j++;
                
        }   
    }

    // public static void ordenar(int[] arr){
    //     for (int i = 0; i < arr.length; i++) {
    //         int pos = i;
    //         int aux = arr[i];
    //         while(pos>0 && (arr[pos-1] < aux)){
    //             arr[pos] = arr[pos-1];
    //             pos--;
    //             // mostrar(arr);
    //         }
    //         arr[pos] = aux;
    //     }
    //     mostrar(arr);
    // }

    // public static int countOdd(int[] arr) {
    //     int count=0;
    //     for (int i = 0; i < arr.length; i++) {
    //         int pos = i;
    //         if(arr[pos] % 2 == 0){
    //             count++;
    //             pos++;
    //         }
    //     }
    //     if(count>1)
    //     System.out.println("Hay " + count +" Números pares en el array");
    //     else
    //     System.out.println("Hay un solo Número par en el array");
    //     return count;
    // }

    // public static int[] deleteOdd(int[] arr, int count) {
    //     int[] newArray = new int[(arr.length)-count];
    //     int j=0;
    //     for (int i = 0; i < newArray.length; i++) {
    //         if(arr[j] % 2 !=0){
    //             newArray[i] = arr[j];
    //             j++;
    //         }else{
    //             while(arr[j] % 2 == 0){
    //                 j++;
    //             }
    //             newArray[i] = arr[j];
    //             i--;
    //         }
    //     }
    //     System.out.println(" Sin pares:");
    //     mostrar(newArray);
    //     return newArray;
    // }

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
