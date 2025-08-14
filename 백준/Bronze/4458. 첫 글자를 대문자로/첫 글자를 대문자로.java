import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String sentence = br.readLine();
            char firstLetter = sentence.charAt(0);
            if (firstLetter >= 'a' && firstLetter <= 'z') {
                firstLetter = (char)(firstLetter - ('a' - 'A'));
            }
            StringBuilder sb = new StringBuilder(sentence);
            sb.setCharAt(0, firstLetter);
            answer.append(sb.toString()).append("\n");
        }
        System.out.print(answer);
    }
}
