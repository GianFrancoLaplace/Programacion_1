/* 
Final libre programación 1 – Día 1 - TUDAI 11/09/2019 
    Se tiene una matriz MatA de NxM y de tipo caracter. En cada fila de MatA hay una o más secuencias de letras  distintas del caracter espacio, separadas por uno o más caracteres espacios al principio, entre secuencias, y al final. Se pide reagrupar (quitar y poner en otro lugar) las secuencias de la fila F en las filas que están entre 1 y F-1 mientras  sea posible o haya espacio. Considerar que al agregar una secuencia en una fila se está reemplazando caracteres  espacios consecutivos por una secuencia de letras distintas del carácter espacio, donde además la nueva secuencia  debe quedar separada de las ya existentes por uno o más espacios. 

    Observaciones generales: 
        _No utilizar estructuras auxiliares. 
        _Suponer que MatA está cargada, y F ya se cargó desde teclado.  
        _Realizar el programa completo bien modularizado. 
 */

// Anilizar secuencia a secuen, ver si entra en primer y F-1, == true,  reagrupar

public class App {
    public static int MaxF=4, MaxC=20, F=2, primer_f=0, SEPARADOR=0;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[][] matriz = {
            { 0, 23, 33, 0, 0, 53, 0, 0, 0, 7, 8, 0, 0, 0, 0, 0, 0, 11, 0, 0 },
            { 0, 0, 0, 14, 15, 0, 0, 0, 0, 0, 19, 0, 20, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 25, 6, 0, 0, 7, 0, 0, 0, 30, 0, 0, 0, 33, 34, 0, 0 },
            { 0, 0, 5, 3, 0, 0, 3, 0, 0, 0, 0, 38, 39, 40, 41, 0, 4, 3, 0, 0 }
        };
        mostrar_m(matriz, F);
        procesar_m(matriz);
        System.out.println();
        mostrar_m(matriz, F);
    }
    public static void procesar_m(int[][] m) {
        int ini =0, fin=-1;
        while(ini < MaxC-1){
            ini=obtener_ini(m, F, fin+1);
            // System.out.println(ini + " Ini.");
            if(ini<MaxC-1){
                fin = obtener_fin(m, F, ini);
                // System.out.println(fin + " Fin.");
                if(hay_espacio(m, F-1, ini, fin )){
                    // System.out.println(" Hay espacio");
                    reagrupar(m, F-1, ini, fin);
                }
            }
        }
    }

    public static int obtener_ini(int[][]m, int f, int ini) {
        while(m[f][ini]==SEPARADOR && ini<MaxC-1){
            ini++;
        }
        return ini;
    }
    
    public static int obtener_fin(int[][]m, int f, int ini) {
        while(m[f][ini]!=SEPARADOR){
            ini++;
        }
        return ini-1;
    }
    
    public static boolean hay_espacio(int[][] m, int f_actual, int ini, int fin) {
        int j=0, cont=0, tamSecuen=fin-ini+1;
        while(f_actual >= primer_f ){
            while(cont < tamSecuen+2 && j < MaxC - 1){
                if(m[f_actual][j]==SEPARADOR)
                    cont++;
                else
                    cont = 0;
                j++;
            }
            if(cont == tamSecuen+2)
                return cont==tamSecuen+2;
            j = 0;
            cont = 0;
            f_actual--;
        }
        return cont==tamSecuen+2;
    }
    
    public static void reagrupar(int[][] m, int f_actual , int ini, int fin) {
        int tamSecuen = fin - ini + 1 + 2, cont = 0, i = 0;
        while(f_actual >= primer_f){
            while(cont < tamSecuen + 2 && i < MaxC - 1){
                if(m[f_actual][i] == SEPARADOR)
                    cont++;
                else 
                    cont = 0;   // 0 0 0 0 0 
                i++;
            }
            if(cont == tamSecuen + 2){
                // Un -1 para que el pos sea axcorede y el segundo para que empiece con el cero como separador.
                for (int j = i - (cont - 1 - 1);
                    ini <= fin; j++) { // 
                    m[f_actual][j] = m[F][ini];
                    m[F][ini] = SEPARADOR;
                    ini++;
                }
            }
            f_actual--;
            i=0;
            cont=0;
        }
    }

    public static void mostrar_m(int[][] m, int f) {
        for (int i = f; i >= 0; i--) {
            for (int j = 0; j < MaxC-1; j++) {
                System.out.print(m[i][j] + "|");
            }
            System.out.println(" ");
        }
    }
}
