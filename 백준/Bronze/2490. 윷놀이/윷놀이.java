import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in);
       String[] play = {"E", "A", "B", "C", "D"};
       for (int i = 0; i < 3; i++) {
           int zeroCount = 0;
           for (int j = 0; j < 4; j++) {
               int current = scanner.nextInt();
               if (current == 0) {
                   zeroCount++;
               }
           }
           System.out.println(play[zeroCount]);
       }
    }
}
