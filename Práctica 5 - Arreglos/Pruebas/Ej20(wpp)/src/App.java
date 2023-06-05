import java.util.Random;
public class App {
    public static final int MAX = 20;
    public static   final int MAXVALOR = 9;
    public static    final int MINVALOR = 0;
    public static void main(String[] args) throws Exception {
        /*20. Hacer un programa que elimine de un arreglo todas las
        ocurrencias de una secuencia patrón dada por otro arreglo*/

        int[] arregloOriginal = {0,2,3,4,0,0,7,0,0,0,1,2,0,0,5,6,7,8,0,0};
        int [] arregloPatron =  {0,0,2,3,4,0,0,0,0,0,1,2,0,0,0,0,0,0,0,0};
        imprimir_arreglo_secuencias_int(arregloOriginal);
        imprimir_arreglo_secuencias_int(arregloPatron);
        int posincio,posiniciopatron;
        posiniciopatron = obtenerPosincio(arregloPatron,0);
        int pos=0;
        while(pos<MAX){
            posincio = obtenerPosincio(arregloOriginal,0);
            if(compararSecuencias(arregloOriginal,arregloPatron,posincio,posiniciopatron) == true) {
                eliminarsecuencia(arregloOriginal, posincio);
            }
            pos++;
        }
        imprimir_arreglo_secuencias_int(arregloOriginal);
    }
    

    public static void eliminarsecuencia(int [] arregloOriginal , int posinicio){
        while(arregloOriginal[posinicio]!=0){
            arregloOriginal[posinicio]=0;
            posinicio++;
        }
    }

    public static boolean compararSecuencias(int [] arrgloOrignal, int[]arregloPatron, int posinicio,int posiniciopatron){

        while((arrgloOrignal[posinicio] == arregloPatron[posiniciopatron]) && (arrgloOrignal[posinicio]!=0 && arregloPatron[posiniciopatron]!=0) ){
            posinicio++;
            posiniciopatron++;
        }
        if(arrgloOrignal[posinicio] == arregloPatron[posiniciopatron]){
            return true;
        }else{
            return false;
        }

    }
    public static int obtenerPosincio(int[] arr, int pos) {
        while (pos<MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static void imprimir_arreglo_secuencias_int(int [] arregloOriginal){
        for (int pos = 0; pos < MAX; pos++){
            System.out.print(arregloOriginal[pos]+"|");
        }
        System.out.print("\n");
    }
}

