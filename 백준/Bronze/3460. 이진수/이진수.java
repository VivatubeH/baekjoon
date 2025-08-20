import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(number);
            for (int j = binary.length() - 1; j >= 0; j--) {
                char ch = binary.charAt(j);
                if (ch == '1') System.out.print(binary.length() - 1 - j + " ");
            }
            System.out.println();
        }
    }
}

// 1101