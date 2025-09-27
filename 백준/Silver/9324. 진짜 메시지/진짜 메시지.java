import java.io.*;
import java.util.*;

public class Main {
    public static int testCase;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                String sentence = br.readLine();
                int[] frequency = new int[26];
                boolean isValid = true;

                for (int j = 0; j < sentence.length(); j++) {
                    char ch = sentence.charAt(j);
                    frequency[ch - 'A']++;
                    if (frequency[ch - 'A'] == 3) {
                        if (j == sentence.length() - 1) {
                            isValid = false;
                            break;
                        }

                        char next = sentence.charAt(j + 1);
                        if (next != ch) {
                            isValid = false;
                            break;
                        }

                        frequency[ch - 'A'] = 0;
                        j++;
                    }
                }
                if (isValid) answer.append("OK").append("\n");
                else answer.append("FAKE").append("\n");
            }
        }
    }

    public static void output() {
        System.out.print(answer);
    }

}
