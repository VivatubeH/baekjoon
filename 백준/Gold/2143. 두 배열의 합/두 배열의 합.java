import java.io.*;
import java.util.*;

public class Main {
    public static int[] A;
    public static int[] B;
    public static List<Integer> sumListOfA = new ArrayList<>();
    public static List<Integer> sumListOfB = new ArrayList<>();
    public static int T;
    public static int N;
    public static int M;
    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        service();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            A = new int[N];
            StringTokenizer firstToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(firstToken.nextToken());
                A[i] = current;
            }
            M = Integer.parseInt(br.readLine());
            B = new int[M];
            StringTokenizer secondToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(secondToken.nextToken());
            }
        }
    }

    public static void service() {
        makeSumListOfA();
        makeSumListOfB();
        Collections.sort(sumListOfA);
        binarySearch();
    }

    public static void makeSumListOfA() {
        // i = 0부터 N-1까지
        // j = i부터 N-1까지
        // i == j인 경우 단일 원소이므로 2로 나눠주기
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                sumListOfA.add(sum);
            }
        }
    }

    public static void makeSumListOfB() {
        // i = 0부터 M-1까지
        // j = i부터 M-1까지
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                sumListOfB.add(sum);
            }
        }
    }

    public static void binarySearch() {
        int target = T;
        long count = 0;

        // 이진탐색을 쓰기 위해 sumListOfB를 정렬한다.
        Collections.sort(sumListOfB);

        for (Integer integer : sumListOfA) {
            int pairOfA = T - integer;

            int lowerBound = getLowerBound(pairOfA);
            int upperBound = getUpperBound(pairOfA);

            answer += (upperBound - lowerBound);
        }
    }

    public static int getLowerBound(int target) {
        int left = 0;
        int right = sumListOfB.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (sumListOfB.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int getUpperBound(int target) {
        int left = 0;
        int right = sumListOfB.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (sumListOfB.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void output() {
        System.out.print(answer);
    }
}
