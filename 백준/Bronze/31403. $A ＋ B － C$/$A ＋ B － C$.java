import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        System.out.println(calculateByNums(A, B, C));
        System.out.print(calculateByString(A, B, C));
    }

    public static int calculateByNums(int A, int B, int C) {
        return A + B - C;
    }

    public static int calculateByString(int A, int B, int C) {
        String a = String.valueOf(A);
        String b = String.valueOf(B);
        String aPlusB = a + b;
        int num = Integer.parseInt(aPlusB);
        return num - C;
    }
}