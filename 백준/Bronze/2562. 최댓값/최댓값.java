import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int max = -1;
        int maxIndex = 0;
        for (int i = 1; i <= 9; i++) {
            int current = scanner.nextInt();
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}
