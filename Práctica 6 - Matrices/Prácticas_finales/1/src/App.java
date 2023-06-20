/* Final libre Programación 1 – Día 1 - TUDAI 19/2/2020 Dada una matriz MatA de NxM de secuencias de caracteres separadas por uno o más espacios ‘ ’, realizar un  programa que ordene ascendentemente toda la matriz de secuencias considerando el orden alfabético entre  secuencias. En el caso de requerir corrimientos suponer que siempre hay espacio. 
Observaciones generales: 
_MatA está cargada inicialmente, donde las secuencias solo tienen caracteres letras.  
_No se pueden utilizar estructuras auxiliares. 
_Puede haber uno o más caracteres espacio al principio y al final de la fila. 
_Realizar el programa completo bien modularizado. 
 */

import java.io.File;

public class App {
    public static int MaxF=2, MaxC=21;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        char[][] MatA={ 
        { ' ', 'a', 'x', 'b', ' ', 'c', 'r', 'd', ' ', 'e', 'j', 'f', ' ', 'g', ' ', ' ', 'o', 'i', ' ', 'j', ' '},
        {' ', 'k', ' ', 'l', ' ', 'n', ' ', 'm', ' ', 'o', ' ', 'p', ' ', 'q', ' ', 's', ' ', 'r', ' ', 't', ' '},
        };
        int[] arr = {1,2,3,4,5};
        correrAIzquierda(arr, 3);
        mostrar_arr(arr);
        mostrar(MatA);
        System.out.println(" ");
        // ordenar_matriz(MatA);
        ordenar_matriz_secuencial(MatA);
        //mostrar(MatA);
        System.out.println();
        mostrar(MatA);
    }

    public static void ordenar_matriz(char[][] m) {
        char mayor= ' ', aux; 
        int col, fil;
        for (int i = 1; i >=0; i--) {
            for (int j = 20 ; j >= 0; j--) {
                if(m[i][j]!=' '){
                    mayor = buscar_mayor(m, i, j);
                    col = columna_mayor(m, i, j, mayor);
                    fil = fila_mayor(m, i, j, mayor);
                    if(m[i][j] < mayor){
                        aux= m[i][j];
                        m[i][j] = mayor;
                        m[fil][col] = aux;
                    }
                }
            }
        }
    }

    public static void ordenar_matriz_secuencial(char[][] m) {
        char mayor= ' ', aux; 
        for (int i = MaxF-1; i >=0; i--) {
            for (int j = MaxC-1 ; j >= 0; j--) {
                mayor = m[i][j];
                int j2=j;
                for (int k = i; k >= 0; k--) {
                    while(j2 >=0){
                        if(mayor < m[k][j2] && mayor!=' '){
                            aux = m[i][j];
                            mayor = m[k][j2];
                            m[i][j] = mayor;
                            m[k][j2] = aux;
                        }
                        j2--;
                    }
                    j2=MaxC-1;
                }
            }
        }
    }

    public static char buscar_mayor(char[][]m, int i, int j) {
        char mayor= ' ';
        int i2=0, j3=0;
        for (int j2 = 0 ; j2 <= i; j2++) { // k no se reinicia  cuando pasa de fila
            for (int k = 0; k <= j; k++) {
                if(m[j2][k]>mayor){
                    mayor = m[j2][k];
                }
            }
        }
        while(0<=i){
            while(1<=j){
                if(m[i][j]>mayor){
                    mayor = m[i][j];
                }
                j--;
            }
            j=20;
            i--;
        }
        return mayor;
    }

    public static int columna_mayor(char[][]m, int i, int j, char mayor) { 
        int col=j;
        for (int j2 = i; j2 >= 0; j2--) {
            for (int k = j; k >= 0; k--) {
                if(m[j2][k]==mayor){
                    col=k;
                }
            }
        }
        while(0<=i){
            while(1<=j){
                if(m[i][j]==mayor){
                    col=j;
                }
                j--;
            }
            j=20;
            i--;
        }
        
        return col;
    }

    public static int fila_mayor(char[][]m, int i, int j, char mayor) {
        int j3,fil=i;
        for (int j2 = i; j2 >= 0; j2--) {
            for (int k = j; k >= 0; k--) {
                if(m[j2][k]==mayor){
                    fil=j2;
                }
            }
        }
        while(0<=i){
            while(1<=j){
                if(m[i][j]==mayor){
                    fil=i;
                }
                j--;
            }
            j=20;
            i--;
        }
        return fil;
    }

    private static void mostrar(char[][] m) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(m[i][j] + "|");
            }
            System.out.println(" ");
        }
    }

    public void corrimiento_izq(int m[][], int f, int ini, int fin) {
        for (int i = f; i < MaxF; i++) {
            for (int j = ini; j < fin; j++) {
                m[i][j] = m[i][j+1];
            }
        }
    }

    public static void correrAIzquierda(int[] arr, int pos) {
        for (int i = pos; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
    }

    public static void mostrar_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+ ", ");
        }
    }
}   
