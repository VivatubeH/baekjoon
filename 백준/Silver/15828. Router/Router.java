import java.io.*;
import java.util.*;

public class Main {
    public static int maxSize = 0;
    public static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            maxSize = Integer.parseInt(br.readLine());
            int n;
            while ((n = Integer.parseInt(br.readLine())) != -1) {
                routing(n);
            }
        }
    }

    public static void routing(int n) {
        if (n == 0) {
            queue.poll();
            return;
        }
        if (queue.size() != maxSize) {
            queue.offer(n);
        }
    }

    public static void output() throws IOException {
        if (queue.isEmpty()) {
            System.out.print("empty");
        } else {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                for (Integer integer : queue) {
                    bw.write(integer + " ");
                }
                bw.flush();
            }
        }
    }
}
