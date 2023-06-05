/* Final libre Programación 1 – Día 1 - TUDAI 19/2/2020 Dada una matriz MatA de NxM de secuencias de caracteres separadas por uno o más espacios ‘ ’, realizar un  programa que ordene ascendentemente toda la matriz de secuencias considerando el orden alfabético entre  secuencias. En el caso de requerir corrimientos suponer que siempre hay espacio. 
Observaciones generales: 
_MatA está cargada inicialmente, donde las secuencias solo tienen caracteres letras.  
_No se pueden utilizar estructuras auxiliares. 
_Puede haber uno o más caracteres espacio al principio y al final de la fila. 
_Realizar el programa completo bien modularizado. 
 */

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        char[][] MatA={ 
        { ' ', 'a', 'x', 'b', ' ', 'c', 'r', 'd', ' ', 'e', 'j', 'f', ' ', 'g', ' ', ' ', 'o', 'i', ' ', 'j', ' '},
        {' ', 'k', ' ', 'l', ' ', 'n', ' ', 'm', ' ', 'o', ' ', 'p', ' ', 'q', ' ', 's', ' ', 'r', ' ', 't', ' '},
        };
        mostrar(MatA);
        System.out.println(" ");
        ordenar_matriz(MatA);
        mostrar(MatA);
        System.out.println();
        // insercion_m(MatA);
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

   /*  public static void insercion_m(char[][] m) {
        int posC, posF;
        char aux;
        for (int i = 0; i < 2; i++) {
            posF=i;
            for (int j = 0; j < 21; j++) {
                posC=j;
                aux = m[i][j];
                while((posC>0) && (m[posF][posC-1] > aux && m[posF][posC]!=' ')){
                    m[posF][posC] = m[posF][posC-1];
                    posC--;
                }
                m[posF][posC] = aux;
            }
        }
    } */
}
