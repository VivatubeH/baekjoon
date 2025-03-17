import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        // 100만개를 오름차순 정렬...
        // 중복이 주어지지 않는 게 보장된다면 ArrayList가 속도에서 더 효율적이다.
        ArrayList<Integer> integers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            integers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(integers);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int integer : integers) {
            bw.write(integer + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
