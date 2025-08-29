import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] hasRowGuard = new boolean[N];
        boolean[] hasColGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    hasRowGuard[i] = true;
                    hasColGuard[j] = true;
                }
            }
        }
        int noGuardRow = 0;
        int noGuardCol = 0;

        for (int i = 0; i < N; i++) {
            if (!hasRowGuard[i]) {
                noGuardRow++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (!hasColGuard[i]) {
                noGuardCol++;
            }
        }
        System.out.print(Math.max(noGuardRow, noGuardCol));
    }
}
