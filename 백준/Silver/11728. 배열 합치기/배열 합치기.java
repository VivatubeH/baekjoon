import java.io.*;
import java.util.*;

public class Main {
    public static int[] A;
    public static int[] B;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        service();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            A = new int[Integer.parseInt(firstLine.nextToken())];
            B = new int[Integer.parseInt(firstLine.nextToken())];
            StringTokenizer secondLine = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(secondLine.nextToken());
            }
            StringTokenizer thirdLine = new StringTokenizer(br.readLine());
            for (int j = 0; j < B.length; j++) {
                B[j] = Integer.parseInt(thirdLine.nextToken());
            }
        }
    }

    public static void service() {
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] < B[bIndex]) {
                list.add(A[aIndex]);
                aIndex++;
            } else if (A[aIndex] > B[bIndex]) {
                list.add(B[bIndex]);
                bIndex++;
            } else {
                list.add(A[aIndex]);
                list.add(B[bIndex]);
                aIndex++;
                bIndex++;
            }
        }

        for (int i = bIndex; i < B.length; i++) {
            list.add(B[i]);
        }
        for (int j = aIndex; j < A.length; j++) {
            list.add(A[j]);
        }
    }

    public static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.print(sb);
    }
}
