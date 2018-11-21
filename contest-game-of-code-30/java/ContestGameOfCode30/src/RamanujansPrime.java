import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * DONE
 * */

public class RamanujansPrime {


    private static boolean isPrime(int number) {
        if (number < 2)
            return false;

        if ((number % 2 == 0 && number != 2) || (number % 3 == 0 && number != 3)
                || (number % 5 == 0 && number != 5)  || (number % 7 == 0 && number != 7))
            return false;
        int limit = (int) Math.round(Math.sqrt(number));
        for (int i = 11; i <= limit ; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static long solver(String number) {
        long acc = 0;
        boolean [] marked = new boolean[1000000];
        for (int s = 0; s < number.length(); s++) {
            for (int len = 1; len <= 6; len++) {
                if (len + s > number.length())
                    break;
                String subs = number.substring(s, len + s);
                if (subs.length() > 6)
                    break;
                int n = Integer.parseInt(subs);
                if (!marked[n] && isPrime(n)) {
                    acc++;
                }
                marked[n] = true;
            }
        }
        return acc;
    }

    private static void test() {
        for (int i = 0; i < 1024 ; i++) {
            if (isPrime(i))
                System.out.printf(" %d", i);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //test();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(reader.readLine());
            while (cases>0) {
                System.out.println(solver(reader.readLine()));
                cases--;
            }
        } catch (IOException ignored) {}
    }
}
