import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    public static void main(String[] args) throws Exception {
        int max, arraynum;
        max = 15;
        int [] arrDatos = new int[max-1];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arrDatos.length; i++) {
            System.out.println("Ingrese un número entre 1 y 12");
            arraynum = Integer.valueOf(in.readLine());  
            if(arraynum<1 || arraynum>12){
                System.out.println("Error");
                --i;
            }else{
                arrDatos[i] = arraynum;
            }
        }
        for (int i = 0; i < arrDatos.length; i++) {
            System.out.print(arrDatos[i] + " ");
        }
    }
}
