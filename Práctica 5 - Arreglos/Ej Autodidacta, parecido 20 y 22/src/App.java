public class App {
    public static int MAX=15;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int [] array  = {0,1,2,3,0,4,5,6,0,7,8,0,9,10,0};
        int [] patron = {0,1,2,3,0,0,0,0,0,7,8,0,9,10,0};
        int inicio=0, fin=-1, iniPatron=0, finPatron=-1;
        // Buscar posiciones de inicio y fin de cada arr
        // Usar bucle para buscar coincidencias e elimanr
        // inicio_Y_Fin_Arr(array, inicio, fin);
        // inicio_Y_Fin_Patron(patron, iniPatron, finPatron);
        System.out.println("array origial:");
        mostrar(array);
        while(inicio<MAX){
            iniPatron= obtener_inicio_secuencia(array, finPatron+1);
            inicio=obtener_inicio_secuencia(array, fin+1);
            finPatron=obtener_fin_secuencia(array, iniPatron);
            fin=obtener_fin_secuencia(array, inicio);
            BuscarCoincidencias(array, patron, inicio, fin, iniPatron, finPatron);

        }
    }
        

    private static void BuscarCoincidencias(int[] arr, int[] patron, int inicio, int fin, int iniPatron, int finPatron) {

        int j;

        // iniPatron= obtener_inicio_secuencia(arr, finPatron+1);
        // inicio=obtener_inicio_secuencia(arr, fin+1);
        
        if(inicio<MAX && iniPatron<MAX){
            // finPatron=obtener_fin_secuencia(arr, iniPatron);
            // fin=obtener_fin_secuencia(arr, inicio);
            j=iniPatron;
            for (int i = inicio; i <= fin; i++) {
                if(j<=finPatron){
                    if(arr[i] == patron[j]){
                        arr[i] = 0;
                    }
                
                    j++;
                }
            }
        }
        System.out.println("arr modificar: \n");
        mostrar(arr);
        System.out.println("Patron a eliminar: \n");
        mostrar(patron);
        System.out.println(" ");
        
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
