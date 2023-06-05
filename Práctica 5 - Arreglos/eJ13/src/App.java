import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array = new int[10];
        // int insert = Integer.valueOf(in.readLine());
        int insert = 10;
        array = llenarArr(array, insert);
        // mostrar(array);
        
        ordenar(array);

        deleteOdd(array,countOdd(array));
        // mostrar(array);
    }

    public static int[] llenarArr(int[] arr, int userNum){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*5;
        }
        arr[0]=userNum;
        return arr;
    }

    public static void ordenar(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int aux = arr[i];
            while(pos>0 && (arr[pos-1] < aux)){
                arr[pos] = arr[pos-1];
                pos--;
                // mostrar(arr);
            }
            arr[pos] = aux;
        }
        mostrar(arr);
    }

    public static int countOdd(int[] arr) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            if(arr[pos] % 2 == 0){
                count++;
                pos++;
            }
        }
        if(count>1)
        System.out.println("Hay " + count +" Números pares en el array");
        else
        System.out.println("Hay un solo Número par en el array");
        return count;
    }

    public static int[] deleteOdd(int[] arr, int count) {
        int[] newArray = new int[(arr.length)-count];
        int j=0;
        for (int i = 0; i < newArray.length; i++) {
            if(arr[j] % 2 !=0){
                newArray[i] = arr[j];
                j++;
            }else{
                while(arr[j] % 2 == 0){
                    j++;
                }
                newArray[i] = arr[j];
                i--;
            }
        }
        System.out.println(" Sin pares:");
        mostrar(newArray);
        return newArray;
    }

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
