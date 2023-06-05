import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int arreglo[], nElmentos;
        System.out.println("nElementos");
        nElmentos = Integer.valueOf(in.readLine());
        arreglo = new int[nElmentos];
        bucleDeElementos(arreglo);
        System.out.println("");
        // ordenamientoXInserción(arreglo);
        // busquedaSecuencial(arreglo);
        corrimientoDerecha(arreglo);
    }
    public static void bucleDeElementos(int[] arr){
        try{
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i + 1 + "° Elemento");
                arr[i] = Integer.valueOf(in.readLine());
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    public static void ordenamientoXInserción(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int aux = arr[i];

            while((pos>0) && (arr[pos-1] > aux)){
                arr[pos] = arr[pos-1];
                pos--;
            }
            arr[pos] = aux;
        } 
        System.out.println("Orden ascendente: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println("\nOrden descendente: ");
        for (int i = arr.length-2; i >= 0; i--) {
            System.out.print(arr[i] + " - "); 
        }
    }
    public static void busquedaSecuencial(int[] arr) {
        int i = 0, numSearch;
        boolean find = false;
        try {
            System.out.println("Número a buscar: ");
            numSearch = Integer.valueOf(in.readLine());
            while(find==false && i<arr.length){
                if(arr[i] == numSearch){
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
                System.out.println("El número " + numSearch + " Fue encontrado en la " + (i+1) + "° posición");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public static void corrimientoDerecha(int[] arr) {
        try {
            int ultimo = arr[arr.length-1];
            for (int i = arr.length-2; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = ultimo;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
        }
    }
    public static void corrimientoIzq(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = first;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
