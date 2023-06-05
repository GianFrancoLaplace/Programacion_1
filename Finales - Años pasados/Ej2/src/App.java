public class App {
    public static final int M=10, N=8;
    public static void main(String[] args) throws Exception {
        int[][] m = new int[M] [N];
        int t,i,rep,mayor;
        t=buscar_max_tam(m);
    }
    public static int buscar_max_tam(int[][] m) {
        int ini=0, fin=-1, tam=0, f=0;
        while(f<M){
            while(ini<N){
                ini= obtener_inicio(m,f, fin+1);
                if(ini<N){
                    fin= obtener_fin(m,f,ini);
                    if((fin-ini)+1>tam){
                        tam=(fin-ini)+1;
                    }
                }
            }
            f++;
            ini=0;
            fin=-1;
        }
        return tam;
        
    }

}
