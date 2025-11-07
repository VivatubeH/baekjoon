import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] positive = new int[101];
        int zero = 0;
        int[] negative = new int[101];

        for (int i = 0; i < n; i++) {
            int current = scanner.nextInt();

            if (current > 0) {
                positive[current]++;
            } else if (current < 0) {
                negative[current * -1]++;
            } else {
                zero++;
            }
        }

        int v = scanner.nextInt();

        if (v > 0) System.out.print(positive[v]);
        else if (v < 0) System.out.print(negative[v * -1]);
        else System.out.print(zero);
    }
}