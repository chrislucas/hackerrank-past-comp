import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DONE
 * */

public class HelpDory {

    // josephus para k = 2
    private static long solver(int n) {
        long acc = 0;
        for (int p = 2; p <= n ; p++) {
            acc = (acc + 2)  % p;
        }
        return acc + 1;
    }

    private static void test() {
        for (int i = 1; i < 100 ; i++) {
            System.out.printf("%d, %d\n", i, solver(i));
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(reader.readLine());
            while (cases>0) {
                System.out.println(solver(Integer.parseInt(reader.readLine())));
                cases--;
            }
        } catch (IOException ignored) {}
    }
}
