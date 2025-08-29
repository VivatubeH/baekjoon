import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] frequency = new int[10001];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            frequency[number]++;
        }
        for (int i = 1; i <= 10000; i++) {
            int count = frequency[i];
            for (int j = 0; j < count; j++) {
                answer.append(i);
                answer.append("\n");
            }
        }
        System.out.print(answer);
    }
}
