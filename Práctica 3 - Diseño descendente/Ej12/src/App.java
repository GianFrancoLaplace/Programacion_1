import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        int userNum;
        MiHelper h = new MiHelper();
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número de un dado");
            userNum = Integer.valueOf(entrada.readLine());
            h.validarNumElegido(userNum);
            System.out.println("El número elegido se repitió " + ObtenerNum(userNum) + " Veces en 1000 lanzamientos" );

        } catch (CustomException e) {
            System.out.println("Error, el número elegido no es valido.");
            // TODO: handle exception
        }
        

    }
    public static int ObtenerNum(int numElegido) {
        int count, dado;
        count = 0;
        for (int i = 0; i < 1000; i++) {
            dado = (int)(6*Math.random() + 1);
            if(dado==numElegido){
                count++;
            }
        }
        return count;
    }
}
