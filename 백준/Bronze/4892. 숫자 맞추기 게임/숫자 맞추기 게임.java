import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        StringBuilder answer = new StringBuilder();
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) break;

            answer.append(index++).append(". ");
            guessNumber(number, answer);
        }
        System.out.print(answer);
    }

    public static void guessNumber(int number, StringBuilder answer) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;

        n1 = 3 * number;

        if (n1 % 2 == 0) {
            n2 = n1 / 2;
        } else {
            n2 = (n1 + 1) / 2;
        }

        n3 = 3 * n2;
        n4 = n3 / 9;

        if (n1 % 2 == 0) number = 2 * n4;
        else number = 2 * n4 + 1;

        if (n1 % 2 == 0) answer.append("even ");
        else answer.append("odd ");

        answer.append(n4).append("\n");
    }
}

