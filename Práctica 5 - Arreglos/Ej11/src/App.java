import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array = {1,2,2,3,3,3,4,4,4,4};
        int search = Integer.valueOf(in.readLine());
        boolean found = false; 
        busquedaSecuencial(found,search,array);
        //El ejercicio esta resuelto pero no con la consigna indicada.
        
    }
    public static void busquedaSecuencial(boolean find, int searched,int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == searched){
                System.out.println(searched + " Fue encontrado en la posición " + (i+1));
                find = true;
                count++;
            }
        }
        if(!find){
            System.out.println("No se encontro a " + searched+ " En el array");
        }else{
            deleteAllNumbers(arr, searched, count);
        }
    }
    public static void deleteAllNumbers(int[] arr, int searched, int count) {
        int[] newArr = new int[arr.length-count];

        // int j=arr.length-1, first= arr[0];
        
        // for (int i = newArr.length-1; j > 0; i--) {
        //     if(arr[j] != searched){
        //         newArr[i] = arr[j];
        //         j--;
        //     }else{
        //         for (int k = i; k < newArr.length; k++) {
        //             newArr[i] = arr[j+1];
        //         }
        //     }
        // }
        int j = 0;
        for (int i = 0; i < newArr.length; i++) {
            if(arr[j] != searched){
                newArr[i] = arr[j];
                j++;
            }else{
                while(arr[j]== searched){
                    j++;
                }
                i--;
            }
        }

        System.out.println("Nuevo Arr ");
        for (int j2 = 0; j2 < newArr.length; j2++){
            System.out.print(newArr[j2]+ " ");
        }
    }
}
