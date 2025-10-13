import java.io.*;
import java.util.*;

public class Main {
    public static int maxLength = 0;
    public static int[] frequency = new int[26];
    public static int N;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            String word = br.readLine();
            service(word);
        }
    }

    public static void service(String word) {
        int left = 0;
        int kind = 0;

        for (int right = 0; right < word.length(); right++) {
            char ch = word.charAt(right);
            int index = ch - 'a';

            if (frequency[index] == 0) {
                frequency[index]++;
                kind++;
            } else {
                frequency[index]++;
            }

            while (kind > N) {
                char leftCh = word.charAt(left);
                int newIndex = leftCh - 'a';
                frequency[newIndex]--;
                if (frequency[newIndex] == 0) kind--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
    }

    public static void output() {
        System.out.print(maxLength);
    }
}
