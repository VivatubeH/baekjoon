import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Queue<Document> queue = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < N; index++) {
                int priority = Integer.parseInt(st.nextToken());
                Document document = new Document(index, priority);
                queue.offer(document);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                int currentPriority = current.priority;

                boolean isCanPrint = true;

                for (Document other : queue) {
                    if (other.priority > currentPriority) {
                        isCanPrint = false;
                        break;
                    }
                }

                if (isCanPrint) {
                    count++;
                    if (current.index == M) {
                        bw.write(count + "\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
            queue.clear();
        }
        bw.flush();
    }
}

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
