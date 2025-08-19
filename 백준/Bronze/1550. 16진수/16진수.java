import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int exponent = 0;
        int sum = 0;
        int num = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = ch - '0';
            } else {
                num = (ch - 'A') + 10;
            }
            sum += (num * (int)Math.pow(16, exponent++));
        }
        System.out.print(sum);
    }
}
