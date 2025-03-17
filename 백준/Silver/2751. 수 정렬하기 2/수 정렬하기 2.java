import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        // 100만개를 오름차순 정렬...
        // TreeSet은 중복 자동 제거 + 자동 오름차순 정렬이 지원됨.
        TreeSet<Integer> integers = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            integers.add(Integer.parseInt(br.readLine()));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int integer : integers) {
            bw.write(integer + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
