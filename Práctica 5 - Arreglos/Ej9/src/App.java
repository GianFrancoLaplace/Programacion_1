import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int newElement, deleteElement, numSearch;
        int []array = {1,2,3,4,5,6,7,8,9,10};
        int []array2 = new int[10];
        // System.out.println("Inserte número al principio del array");
        // newElement = Integer.valueOf(in.readLine());
        // corrimientoDerMasNumeroUsrFirst(array, newElement);
        System.out.println("NúmDelete");
        deleteElement = Integer.valueOf(in.readLine());
        System.out.println("");
        busquedaSecuencial(array, deleteElement);
        delete(array, deleteElement);


    }
    public static void corrimientoDerMasNumeroUsrFirst(int[] arr, int el) {
        try {
            for (int i = arr.length-2; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = el;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
        }
    }
    
    public static void busquedaSecuencial(int[] arr, int deleteElement) {
        int i = 0;
        boolean find = false;
        try {
            System.out.println("Número a buscar: ");
            while(find==false && i<arr.length){
                if(arr[i] == deleteElement){
                    find = true;
                }
                else{
                    i++;
                }
            }
            if(find == false){
                System.out.println("No se encontro el número en el arreglo");
            }
            else{
                System.out.println("El número " + deleteElement + " Fue encontrado en la " + (i+1) + "° posición");
            }   
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERR");
        }
    }
    public static void  delete(int[] arr, int numDelete) {
        int[] newArr = new int[arr.length-1];
        int j=0;
        for (int i = 0; i < newArr.length; i++) {
            if(arr[j] != numDelete){
                newArr[i] =arr[j];
                j++;
            }else{
                ++j;
                newArr[i] =arr[j];
                ++j;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]+ " ");
        }
    }
}
