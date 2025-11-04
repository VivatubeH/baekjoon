import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in);
       boolean haveOdd = false;
       int sum = 0;
       int min = 101;
       for (int i = 0; i < 7; i++) {
           int current = scanner.nextInt();

           if (current % 2 == 1) {
               sum += current;
               if (min > current) {
                   min = current;
               }
               haveOdd = true;
           }
       }
       if (haveOdd) {
           System.out.println(sum);
           System.out.print(min);
       } else {
           System.out.print(-1);
       }
    }
}
