import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer current = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(current.nextToken());
            int secondNum = Integer.parseInt(current.nextToken());

            if (firstNum == 0 && secondNum == 0) {
                break;
            }

            if (firstNum > secondNum) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
