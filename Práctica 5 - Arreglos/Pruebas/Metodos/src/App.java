import java.util.Random;

public class App {
    public static int MAX=10, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] array, newArr;
        int cont_pares;
        array = new int[MAX];
        cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);
        cont_pares=contador_pares(array);
        newArr = new int[MAX-cont_pares];
        eliminar_pares(array, newArr);
        mostrar(newArr);

    }
    public static void transcribir_arr_diferente_long(int[] arr, int[] newArr) {
            for (int i = 0; i < newArr.length; i++) {
                
            }
    }

    public static int contador_pares(int[] arr) {
        int cont=0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]%2==0)
                cont++;
            }

        return cont;
    }

    public static void eliminar_pares(int[] arr, int[] newArr) {
        int j=0;
        for (int i = 0; i < newArr.length; i++) {
            if(arr[j]%2==0){
                while(arr[j]%2==0){
                    j++;
                }
            }
            newArr[i]=arr[j];
            j++;
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
