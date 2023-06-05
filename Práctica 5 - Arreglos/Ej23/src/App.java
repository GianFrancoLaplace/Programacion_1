public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static void main(String[] args) throws Exception {
        int [] array = {0, 8, 5, 9, 3, 0, 5, 0, 0, 0, 5, 0, 0, 5, 7, 6, 3, 1, 0, 0};
        int contI;
        contI = buscar_inicio_ultima_secuencia(array);
        System.out.println("ORIGINAL: ");
        mostrar(array);
        Cambiar_orden_ultima_s(array, contI);
        System.out.println("INVERTIDO: ");
        mostrar(array);
    }

    public static void Cambiar_orden_ultima_s(int[] arr, int cont) {
        int i=cont, j=i;
        while(arr[j]!=0){
            j++;
        }
        j--;
        
        while(i<j) {
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j]=aux;
            j--;
            i++;
            mostrar(arr);
        }
    }

    public static int buscar_inicio_ultima_secuencia(int[] arr) {
        int inicio=0, fin=-1, cont=0;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if(inicio<MAX){
                fin=obtener_fin_secuencia(arr, inicio);
                cont=inicio;
                System.out.println(cont);
            }
        }
        return cont;
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

    public static void mostrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println(" ");
    }

}
