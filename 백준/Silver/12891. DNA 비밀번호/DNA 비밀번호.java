import java.io.*;
import java.util.*;

public class Main {
    public static int S;
    public static int P;
    public static String dna;
    public static int A;
    public static int C;
    public static int G;
    public static int T;

    public static int[] frequency = new int[4];

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            S = Integer.parseInt(firstLine.nextToken());
            P = Integer.parseInt(firstLine.nextToken());
            dna = br.readLine();
            StringTokenizer acgtLine = new StringTokenizer(br.readLine());
            A = Integer.parseInt(acgtLine.nextToken());
            C = Integer.parseInt(acgtLine.nextToken());
            G = Integer.parseInt(acgtLine.nextToken());
            T = Integer.parseInt(acgtLine.nextToken());
            output(binarySearch());
        }
    }

    public static int binarySearch() {
        int leftIndex = 0;
        int rightIndex = P - 1;
        int count = 0;

        for (int i = leftIndex; i <= rightIndex; i++) {
            char ch = dna.charAt(i);
            if (ch == 'A') frequency[0]++;
            else if (ch == 'C') frequency[1]++;
            else if (ch == 'G') frequency[2]++;
            else frequency[3]++;
        }

        // GATA
        // S = 4, P = 2
        // leftIndex = 0, rightIndex = 1 -> GA
        // leftIndex = 1, rightIndex = 2
        while (rightIndex < S) {
            if (frequency[0] >= A && frequency[1] >= C && frequency[2] >= G && frequency[3] >= T) {
                count++;
            }
            leftIndex++;
            rightIndex++;

            if (leftIndex >= S || rightIndex >= S) {
                break;
            }

            char leftCh = dna.charAt(leftIndex - 1);
            if (leftCh == 'A') frequency[0]--;
            else if (leftCh == 'C') frequency[1]--;
            else if (leftCh == 'G') frequency[2]--;
            else frequency[3]--;

            char rightCh = dna.charAt(rightIndex);
            rightCh = dna.charAt(rightIndex);
            if (rightCh == 'A') frequency[0]++;
            else if (rightCh == 'C') frequency[1]++;
            else if (rightCh == 'G') frequency[2]++;
            else frequency[3]++;
        }

        return count;
    }

    public static void output(int number) {
        System.out.print(number);
    }
}
