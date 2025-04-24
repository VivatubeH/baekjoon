import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Axixs> axixs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            axixs.add(new Axixs(x, y));
        }

        Collections.sort(axixs, new Comparator<>() {
            @Override
            public int compare(Axixs o1, Axixs o2) {
                if (o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });

        StringBuilder result = new StringBuilder();
        for (Axixs temp : axixs) {
            result.append(temp.x + " " + temp.y + " ").append("\n");
        }

        System.out.print(result);
    }
}

class Axixs {
    public int x;
    public int y;

    Axixs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}