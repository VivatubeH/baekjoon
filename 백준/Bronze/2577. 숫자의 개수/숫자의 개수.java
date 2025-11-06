import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int total = A * B * C;
        String totalString = String.valueOf(total);
        int[] frequency = new int[10];
        for (int i = 0; i < totalString.length(); i++) {
            char ch = totalString.charAt(i);
            frequency[ch - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(frequency[i]);
        }
    }
}
