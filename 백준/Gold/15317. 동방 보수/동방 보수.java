import java.io.*;
import java.util.*;

public class Main {
    public static int max = 0;
    public static int X = 0;
    public static int[] needMoneyArray;
    public static int[] haveMoneyArray;

    public static void main(String[] args) throws IOException {
        input();
        service();
        System.out.print(max);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            needMoneyArray = new int[N];
            haveMoneyArray = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                needMoneyArray[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                haveMoneyArray[i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void sort() {
        Arrays.sort(needMoneyArray);
        Arrays.sort(haveMoneyArray);
    }

    public static void service() {
        sort();
        binarySearch();
    }

    public static void binarySearch() {
        int lower = 0;
        int upper = Math.min(needMoneyArray.length, haveMoneyArray.length);
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (isAvailable(mid)) {
                max = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
    }

    // [1, 5, 7, 8, 9]
    // [2, 3, 5, 10]
    // k = 3일 때 3, 5, 10을 선택하도록
    public static boolean isAvailable(int k) {
        int budget = X;
        int cost = 0;
        int count = 0;
        int j = haveMoneyArray.length - k;
        for (int i = 0; i < k; i++) {
            int needMoney = needMoneyArray[i];
            int haveMoney = haveMoneyArray[j + i];
            if (needMoney <= haveMoney) {
                count++;
            } else {
                if (needMoney - haveMoney <= budget) {
                    count++;
                    budget -= (needMoney - haveMoney);
                } else {
                    break;
                }
            }
        }
        if (count >= k) {
            return true;
        }
        return false;
    }
}
