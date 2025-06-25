public class ProvaWhile {
    public static void main(String[] args) {
        int count = 1;


        //esempio while loop
        while (count <= 5) {
            count++;
            System.out.println(count);
        }

        //esempio do-while
        do {
            count--;
            System.out.println(count);
        } while (count != 0);
    }
}