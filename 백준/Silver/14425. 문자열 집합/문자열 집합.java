import java.io.*;
import java.util.*;

public class Main {
    public static int answer = 0;
    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        inputAndService();
        output();
    }

    public static void inputAndService() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            for (int i = 0; i < M; i++) {
                String word = br.readLine();
                if (binarySearch(word)) {
                    answer++;
                }
            }
        }
    }

    public static void output() {
        System.out.print(answer);
    }

    public static boolean binarySearch(String target) {
        int L = 0;
        int R = list.size() - 1;

        while (L <= R) {
            int mid = (L + R) / 2;

            String current = list.get(mid);

            if (current.equals(target)) {
                return true;
            } else {
                if (current.compareTo(target) < 0) {
                    L = mid + 1;
                } else if (current.compareTo(target) > 0) {
                    R = mid - 1;
                }
            }
        }
        return false;
    }
}
