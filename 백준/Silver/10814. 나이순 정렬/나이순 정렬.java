import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();
            members.add(new Member(age, name, i));
        }
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                // 나이가 같으면 먼저 들어온 게 앞으로 가고
                // 나이가 다르면 나이순으로 정렬이 됩니다.
                return o1.getAge() == o2.getAge() ? o1.getOrder() - o2.getOrder() : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(members.get(i).getAge() + " "  + members.get(i).getName());
        }
    }
}

class Member {
    private int order;
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getOrder() {
        return order;
    }

    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}