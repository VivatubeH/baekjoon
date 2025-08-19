import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 120 - (9*1 + 4*3 + 8*1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());
        sum += (num1 + (num2 * 3) + num3);
        System.out.print("The 1-3-sum is " + sum);
    }
}
