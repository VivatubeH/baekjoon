import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String sang = makeAnswerByPattern("ABC");
        String chang = makeAnswerByPattern("BABC");
        String hyeon = makeAnswerByPattern("CCAABB");

        String answer = br.readLine();

        int sangScore = 0;
        int changScore = 0;
        int hyeonScore = 0;

        for (int i = 0; i < n; i++) {
            char answerChar = answer.charAt(i);
            char sangChar = sang.charAt(i);
            char changChar = chang.charAt(i);
            char hyeonChar = hyeon.charAt(i);

            if (answerChar == sangChar) sangScore++;
            if (answerChar == changChar) changScore++;
            if (answerChar == hyeonChar) hyeonScore++;
        }

        int max = Math.max(sangScore, changScore);
        max = Math.max(max, hyeonScore);

        System.out.println(max);
        if (max == sangScore) System.out.println("Adrian");
        if (max == changScore) System.out.println("Bruno");
        if (max == hyeonScore) System.out.println("Goran");
    }

    public static String makeAnswerByPattern(String word) {
        int length = word.length();
        StringBuilder newString = new StringBuilder();
        while (length < 100) {
            newString.append(word);
            length = newString.length();
        }
        return newString.toString();
    }
}
