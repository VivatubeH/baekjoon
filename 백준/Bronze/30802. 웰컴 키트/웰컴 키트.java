import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tShirts = new int[6];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int totalPen = 0;
        int countTShirtSet = 0;
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(token.nextToken());
            tShirts[i] = num;
            totalPen += tShirts[i];
        }
        token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        int P = Integer.parseInt(token.nextToken());

        for (int i = 0; i < 6; i++) {
            int num = tShirts[i];
            countTShirtSet += (num / T);
            if (num % T != 0) {
                countTShirtSet++;
            }
        }

        int countPenSet = totalPen / P;
        int individualPen = totalPen % P;

        System.out.println(countTShirtSet);
        System.out.print(countPenSet + " " + individualPen);
    }
}
