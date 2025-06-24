import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] trees = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) max = trees[i];
        }

        long bottom = 0;
        long top = max;
        long sum = 0;
        long answer = 0;

        while (bottom <= top) {
            sum = 0;

            long middle = (bottom + top) / 2;

            for (int i = 0; i < N; i++) {
                if (trees[i] > middle) {
                    sum += trees[i] - middle;
                }
            }

            if (sum >= M) {
                answer = middle;
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }
        }

        System.out.print(answer);
    }
}
