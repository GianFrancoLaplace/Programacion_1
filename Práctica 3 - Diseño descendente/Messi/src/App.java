import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.io.Math
public class App {
    public static void main(String[] args) throws Exception {
        int numero = obtenerEntero();
        if (numero!=-1){
        System.out.println("Tabla del 5");
        imprimirTabla5();//declaración local
        int dado;
        dado = (int)(6*Math.random()+1);
        System.out.println(dado);
        }
    }// fin del main
// el código sigue al lado


    public static int obtenerEntero(){
        int entero = -1;
        BufferedReader entrada = new BufferedReader
        (new InputStreamReader(System.in));
        try{
        System.out.println("Ingrese nro entero: ");
        entero =  Integer.valueOf(entrada.readLine());
        }
        catch (Exception exc){
        System.out.println("error" + exc);
        }
        return entero;
    }// fin de la función

    public static void imprimirTabla5(){
        for (int i = 1 ; i <= 10; i++) {
        System.out.println(5*i);
        }
    }// fin del procedimiento
}// fin del class
