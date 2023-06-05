public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] A = {0,2,1,0,2,0,0,0,2,0}, P = {0,2,0}, R={0,1,0};
        remplazar(A,P,R);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+ ", ");
        }
    }
    public static void remplazar(int[] A ,int[] P,int[] R) {
        int j, k;
        boolean coincide;
        for (int i = 0; i < A.length-1; i++) {
            coincide=true; // true para conveniencia del Ej
            k=i;
            j=0;
            while(j<3 && coincide==true){ // 3==lenght de P
                if(A[k]!=P[j]){
                    coincide=false;
                }else{
                    k++;
                    j++;
                }
            } 
            if(coincide==true){
                j=0;
                k=i;
                while(j<3){
                    A[k]=R[j];
                    k++;
                    j++;
                }
            }
        }
    }
}
