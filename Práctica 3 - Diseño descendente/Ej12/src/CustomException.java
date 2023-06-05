public class CustomException extends Exception {
    
    public static final long serialVesionUID = 700L;

    public CustomException(String mensaje){
        super(mensaje);
    }
}
