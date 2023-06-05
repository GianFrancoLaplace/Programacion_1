public class MiHelper {
    MiHelper(){

    }

    public void validarNumElegido(int userNum) throws CustomException{
        if(userNum <= 0 || userNum>6){
            throw new CustomException("El número seleccionado no es valido.");
        }
    }
}

