import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        pedirNum();
    }
    public static void pedirNum(){
        int number;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Introduzca número");
            number = Integer.valueOf(entrada.readLine());
            System.out.println(number);
            System.out.println("Introduzca otro número,  Introduzca 0 en caso contrario.");
            number = Integer.valueOf(entrada.readLine());
            while(number != 0){
                System.out.println("Introduzca número");
                number = Integer.valueOf(entrada.readLine());
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
