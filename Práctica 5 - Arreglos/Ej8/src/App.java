public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] arr = {1,2,3,4,5};
        corrimientoIzq(arr);
    }
    public static void corrimientoIzq(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = first;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
