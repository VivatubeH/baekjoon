import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        input();
        bw.flush();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());
                int[] A = new int[N];
                int[] B = new int[M];
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[j] = Integer.parseInt(tokenizer.nextToken());
                }
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    B[j] = Integer.parseInt(tokenizer.nextToken());
                }
                int count = getCountBiggerAThanB(A, B);
                bw.write(String.valueOf(count) + "\n");
            }
        }
    }

    public static int getCountBiggerAThanB(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int count = 0;
        int bIndex = 0;
        for (int aIndex = 0; aIndex < array1.length; aIndex++) {
            int a = array1[aIndex];
            while (bIndex < array2.length && a > array2[bIndex]) {
                bIndex++;
            }
            count += bIndex;
        }
        return count;
    }
}
