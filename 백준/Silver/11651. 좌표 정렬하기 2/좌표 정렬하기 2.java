import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Coordinate(x, y));
        }

        Collections.sort(list, new Comparator<>() {
           public int compare(Coordinate c1, Coordinate c2) {
               if (c1.y == c2.y) return c1.x - c2.x; // y좌표가 같으면 x좌표 기준 오름차순 정렬
               return c1.y - c2.y; // 기본적으로는 y좌표 기준 오름차순 정렬
           }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).x + " " + list.get(i).y + "\n");
        }

        System.out.print(sb);
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
