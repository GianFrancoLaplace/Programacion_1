import java.util.Random;

/* Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.
 */
public class App {
    public static final int MAX=20, MAXVALOR=9, MINVALOR=0;
    public static final double probabilidad_numero= 0.4;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int [] array = {0, 8, 5, 9, 3, 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 6, 3, 1, 0} 
                    //  0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0;
            , newArrN
                , newArrS, arrIS;
        int contN, contS=0, cont_S_Inis=0;
        // cargar_arreglo_aleatorio_secuencias_int(array);
        mostrar(array);

        contN = contar_numero_orden_decreciente(array);
        contS = contar_Secuencia_Orden_Decreciente(array, contS);
        cont_S_Inis=contar_inicios_de_secuencias_a_eliminar(array);

        System.out.println("Cont_S_Inis " + cont_S_Inis);
        arrIS=new int[cont_S_Inis];

        inicios_de_secuencias_a_eliminar(array, arrIS, cont_S_Inis);

        System.out.println("nums " + contN);
        System.out.println("sec " + contS);

        if(contN!=0){
            newArrN= new int[MAX-contN];
            newArrS= new int[MAX-contS];
            // eliminar_numeros_en_orden_decreciente(array, newArr);
            eliminar_secuencia_decreciente(array,newArrS,arrIS);
            mostrar(newArrS);
        }else{
            System.out.println("Las secuencias del array estan ordenadas.");
        }
        // Contar 
        // newArr
        // eliminar
    }

    public static int contar_numero_orden_decreciente(int[] arr) {
        int cont=0, j=1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0 && arr[j]!=0)
                if(arr[i] > arr[j]){
                    cont++;
                }
        j++;
        }
        return cont;
    }

    public static int contar_Secuencia_Orden_Decreciente(int[] arr, int cont) {
        int j=1, k, inicio=0, fin=-1;
        boolean decrece;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if (inicio<MAX) {
                fin=obtener_fin_secuencia(arr, inicio);
                j=inicio;
                k=j+1;
                decrece=false;
                while(j<fin && decrece==false){
                    if(arr[j]!=0 && arr[k]!=0){
                        if(arr[j] > arr[k]){
                            decrece=true;
                        }   
                    }
                    if(decrece==true){
                        cont+=(fin-inicio)+1;
                    }
                    j++;
                    k++;
                }
            }
        }
        return cont;
    }

    public static int contar_inicios_de_secuencias_a_eliminar(int[] arr) {
        int j=1, k, inicio=0, fin=-1, cont=0;
        boolean decrece;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if (inicio<MAX) {
                fin=obtener_fin_secuencia(arr, inicio);
                j=inicio;
                k=j+1;
                decrece=false;
                while(j<fin && decrece==false){
                    if(arr[j]!=0 && arr[k]!=0){
                        if(arr[j] > arr[k]){
                            decrece=true;
                        }   
                    }
                    if(decrece==true){
                        cont++;
                    }
                    j++;
                    k++;
                }
            }
        }
        return cont;
    }

    public static void inicios_de_secuencias_a_eliminar(int[] arr, int[] arrI, int contI) {
        int i=0,j=1, k, inicio=0, fin=-1;
        boolean decrece;
        while(inicio<MAX){
            inicio=obtener_inicio_secuencia(arr, fin+1);
            if (inicio<MAX) {
                fin=obtener_fin_secuencia(arr, inicio);
                j=inicio;
                k=j+1;
                decrece=false;
                while(j<fin && decrece==false){
                    if(arr[j]!=0 && arr[k]!=0){
                        if(arr[j] > arr[k]){
                            decrece=true;
                        }   
                    }
                    if(decrece==true){
                        arrI[i] = inicio;
                        i++;
                        mostrar(arrI);
                    }
                    j++;
                    k++;
                }
            }
        }
    }

    public static void eliminar_secuencia_decreciente(int[] arr, int[] newArr, int[] arrI) {
        int inicio=0, fin=-1, k=0, j=1;
        
        for (int i = 1; i < newArr.length-1; i++) { //
            if(arrI[k]==i){
                while(arr[j]!=0){
                    j++;
                }
                k++;
            }else{
                j++;
            }
            newArr[i]=arr[j];        
        }
        mostrar(newArr);
    }

    public static void eliminar_numeros_en_orden_decreciente(int[] arr, int[] newArr) {
        int j=1, k=0;
        boolean decreciente;
        for (int i = 0; i < arr.length; i++) {
            decreciente=false;
            
            if(arr[i]!=0 && arr[j]!=0)
                if(arr[i] > arr[j]){
                // No hagas nada
                decreciente=true;
                }
                /* }else{
                    newArr[k] = arr[i];
                } */
                if(decreciente!=true){
                newArr[k]=arr[i];
                k++;
                }else{

                }
        j++;
        }
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
