public class App {
    public static final int MAXF=4, MAXC=20, MAXVALOR=9, MINVALOR=0;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        char[] vocales = {'a','e','i','o','u'};
        char[][] l = {
            {' ', 'a', 'b', 'c', ' ', 'd', 'e', 'f', 'g', ' ', 'h', 'i', 'j', 'k', ' ', 'l', 'm', 'n', 'o', ' '},
            {' ', 'p', 'q', 'r', ' ', 's', 't', 'u', 'v', ' ', 'w', 'x', 'y', 'z', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'a', 'b', ' ', 'c', 'd', 'e', ' ', 'f', 'g', 'h', ' ', 'i', 'j', ' ', 'k', 'l', ' ', 'm', ' '},
            {' ', 'o', 'p', ' ', 'q', 'r', ' ', 's', 't', ' ', 'u', 'v', 'w', ' ', 'x', 'y', 'z', ' ', ' ', ' '}
        };
        char[][] l2 = {
            {' ', 'x', 'y', 'z', ' ', 'a', 'b', 'c', 'd', ' ', 'e', 'f', 'g', 'h', ' ', 'i', 'j', 'k', 'l', ' '},
            {' ', 'm', 'n', 'o', ' ', 'p', 'q', 'r', 's', ' ', 't', 'u', 'v', 'w', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'a', 'b', ' ', 'c', 'd', 'e', ' ', 'f', 'g', 'h', ' ', 'i', 'j', ' ', 'k', 'l', ' ', 'm', ' '},
            {' ', 'o', 'p', ' ', 'q', 'r', ' ', 's', 't', ' ', 'u', 'v', 'w', ' ', 'x', 'y', 'z', ' ', ' ', ' '}
        };
        char_mostrar_m(l);
        char_mostrar_m(l2);
        int f=0;
        while(f<MAXF){
            Ej16(l, l2,f);
            f++;
        }
        char_mostrar_m(l);

    }
    public static void Ej16(char[][] m, char[][] m2, int f) { // Es un MAT DE caracteres
        int  mayor_tamano, inicio=0, fin=-1,
             mayor_tamano_p,  inicio_p=0, fin_p=-1;

        char[] vocales = {'a','e','i','o','u'};
        mayor_tamano = indice_ini_mayor_tam(m, f);
        mayor_tamano_p = indice_ini_mayor_tam(m2, f);
        char primer_caracter= buscar_primer_caracter(m, f, mayor_tamano);
        System.out.println(primer_caracter);
        System.out.println(" ");
        System.out.println("\nLa secuencia de mayor tamaño de la fila "+ f + " Es: "+mayor_tamano);
        // Para m
        comparar_primeras_secuencias(m, m2, f);
        // comparar_e_intercambiar_secuencias(m, m2, f, mayor_tamano);
        while(inicio<MAXC-1){
            inicio=char_obtener_inicio_secuencia_m(m, f, fin+1);
            if(inicio<MAXC-1){
                fin=char_obtener_fin_secuencia_m(m, f, inicio);
                eliminar_primer_vocal_x_secuen(m, f, vocales, inicio, fin);
                m[f][inicio] = primer_caracter;
            }
        }
        // para m2
        while(inicio_p<MAXC-1){
            inicio_p=char_obtener_inicio_secuencia_m(m2, f, fin_p+1);
            if(inicio_p<MAXC-1){
                fin_p=char_obtener_fin_secuencia_m(m2, f, inicio_p);
                eliminar_primer_vocal_x_secuen(m2, f, vocales, inicio_p, fin_p);
            }
        }
    }
    public static int indice_ini_mayor_tam(char[][] m, int f) { // EJ16
        int tamSecuen=0, inicio=0, fin=-1;
        while(inicio<MAXC-1){
            inicio=char_obtener_inicio_secuencia_m(m, f, fin+1);
            if(inicio<MAXC){
                fin=char_obtener_fin_secuencia_m(m, f ,inicio);
                if(((fin-inicio)+1) > tamSecuen){
                    tamSecuen=(fin-inicio)+1;
                }
            }
        }
        return tamSecuen;
    }
    public static int buscar_ini_secuen_mayor(char[][] m, int f, int tamSecuen) {    
        int inicio=0, fin=-1;
        while(inicio<MAXC-1 && ((fin-inicio)+1) != tamSecuen){
            inicio=char_obtener_inicio_secuencia_m(m, f, fin+1);
            if(inicio<MAXC){
                fin=char_obtener_fin_secuencia_m(m, f ,inicio);
            } 
        }
        return inicio;
    }
    public static char buscar_primer_caracter(char[][] m, int f, int tamSecuen) {
        int inicio=0, fin=-1;
        char primer_caracter='a';
        while(inicio<MAXC-1 && ((fin-inicio)+1) != tamSecuen){
            inicio=char_obtener_inicio_secuencia_m(m, f, fin+1);
            if(inicio<MAXC){
                fin=char_obtener_fin_secuencia_m(m, f ,inicio);
                if(((fin-inicio)+1) == tamSecuen){
                    primer_caracter = m[f][inicio];
                }
            }
        }
        return primer_caracter;
    }
    public static void comparar_e_intercambiar_secuencias(char[][] m, char[][] m2, int f, int tamSecuen) {
        int inicio=0, fin=-1, ini_tamSecuen;
        inicio= char_obtener_inicio_secuencia_m(m2, f, fin+1);
        fin= char_obtener_fin_secuencia_m(m2, f, inicio);
        if(tamSecuen>(fin-inicio)+1){
            ini_tamSecuen = buscar_ini_secuen_mayor(m, f, tamSecuen);
            int i=ini_tamSecuen, j=inicio;
            char aux;
            while(m[f][i]!=' '){
                aux=m[f][i];
                m[f][i]=m2[f][j];
                m2[f][j]= aux;
                i++;
                j++;
            }
            System.out.println(" ");
            char_mostrar_m(m);
            System.out.println(" ");
            char_mostrar_m(m2);
            System.out.println(" ");
        }
    }
    public static void comparar_primeras_secuencias(char[][] m, char[][] m2, int f) {
        int inicio=0, fin=-1,
            inicio_p=0, fin_p=-1,
            i, j;
    
        inicio=char_obtener_inicio_secuencia_m(m, f, fin+1);
        fin=char_obtener_fin_secuencia_m(m, f, inicio);
        inicio_p=char_obtener_inicio_secuencia_m(m2, f, fin_p+1);
        fin_p=char_obtener_fin_secuencia_m(m2, f, inicio_p);

        i=inicio;
        j=inicio_p;

        while(m[f][i] == m2[f][j] && i<MAXC-1){
            i++;
            j++;
        }
        if(i<fin){
            System.out.println("Las primeras secuencias son distintas");
        }else{
            System.out.println("Las primeras secuencias son iguales");
        }
    }
    public static void eliminar_primer_vocal_x_secuen(char[][] m, int f, char[] vocales, int inicio, int fin) { //EJ 16
        int k=0, i=inicio;
        while(i<=fin){
            while(k<5){
                if(m[f][i] == vocales[k]){
                    char_corrimiento_izquierda_m(m, f, i, fin);
                    k=5;
                    i=fin;
                    break;
                }
                k++;
            }
            i++;
            k=0;
        }
    }
    public static void char_corrimiento_izquierda_m(char[][] m, int f, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            m[f][i] = m[f][i+1];
        }
    }

    public static int char_obtener_fin_secuencia_m(char[][] m, int f, int ini) {
        while (ini<MAXC-1 && m[f][ini]!=' ')
            ini++;
        return ini-1;
    }
    public static int char_obtener_inicio_secuencia_m(char[][] m, int f, int ini) {
        while (ini<MAXC-1 && m[f][ini]==' ')
            ini++;
        return ini;
    }
    public static void char_mostrar_m(char[][] mat) {
        for (int i = 0; i < MAXF; i++) {
            System.out.println(" ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(mat[i][j] + ", ");
            }
        }
    }



}
