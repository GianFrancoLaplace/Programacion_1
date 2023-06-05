import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array = {1,2,2,3,3,3,4,4,4,4};
        int search = Integer.valueOf(in.readLine());
        boolean found = false; 
        busquedaSecuencial(found,search,array);
        deleteAllNumbers(array, search);
        //El ejercicio esta resuelto pero no con la consigna indicada.
        // Este no lo termine.
        
    }
    public static void busquedaSecuencial(boolean find, int searched,int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == searched){
                System.out.println(searched + " Fue encontrado en la posición " + (i+1));
                find = true;   
            }
        }
        if(!find){
            System.out.println("No se encontro a " + searched+ " En el array");
        }else{
            deleteAllNumbers(arr, searched);
        }
    }
    public static void deleteAllNumbers(int[] arr, int searched) {
        int ultimo = arr[arr.length-1];
        
        for (int i = 0; i < arr.length; i++) {
            while(arr[i]==searched){
                arr[i] = arr[i+1];
            }
        }
        arr[0] = ultimo;

        System.out.println("Nuevo Arr ");
        for (int j2 = 0; j2 < arr.length; j2++){
            System.out.print(arr[j2]+ " ");
        }
    }

    
}
