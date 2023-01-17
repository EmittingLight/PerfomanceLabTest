public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int current = 1;

        do {
            System.out.print(current);
            current += m - 1;
            if (current > n) {
                current -= n;
            }
        } while (current > 1);
        System.out.println();
    }
}
