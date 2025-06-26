import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] colors = new int[M];
        int max = -1;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > max) max = num;
            colors[i] = num;
        }
        int answer = 0;

        int lowerBound = 1;
        int upperBound = max;

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            if (isPossible(mid, N, colors)) {
                answer = mid;
                upperBound = mid - 1;
            } else {
                lowerBound = mid + 1;
            }
        }

        System.out.print(answer);
    }

    public static boolean isPossible(int K, int N, int[] array) {
        int totalNeed = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNeed = array[i] / K;
            if (array[i] % K != 0) currentNeed++;
            totalNeed += currentNeed;
        }
        if (totalNeed > N) {
            return false;
        }
        return true;
    }
}
