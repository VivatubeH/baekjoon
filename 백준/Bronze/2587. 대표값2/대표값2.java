import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in);
       int sum = 0;
       int[] array = new int[5];
       for (int i = 0; i < 5; i++) {
           int current = scanner.nextInt();
           sum += current;
           array[i] = current;
       }
       Arrays.sort(array);
       System.out.println(sum / 5);
       System.out.println(array[2]);
    }
}
