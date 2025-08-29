import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        boolean[] isCheck = new boolean[1000001];
        boolean[] isExist = new boolean[1000001];

        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(st.nextToken());
            array[i] = currentNum;
            isExist[currentNum] = true;
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ai = array[i];
            int aj = x - ai;
            if (aj < 1 || aj > 1000000) continue;

            if (isExist[aj] && !isCheck[aj]) {
                if (ai == aj) continue;
                count++;
                isCheck[ai] = true;
                isCheck[aj] = true;
            }
        }
        System.out.print(count);
    }
}
