import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<AttendanceLog> lists = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            String name = tokenizer.nextToken();
            String attendance = tokenizer.nextToken();

            // 사용자가 출퇴근을 하면 출퇴근 기록을 AttendanceLog에 추가합니다.
            // 단 기존에 없으면 추가, 있으면 삭제해야 합니다.
            AttendanceLog log = new AttendanceLog(name, attendance);
            if (lists.contains(log)) { // contains는 이름을 보고 판단합니다.
                lists.remove(log);
            } else { // 없으면 추가합니다.
                lists.add(log);
            }
        }
        ArrayList<AttendanceLog> arraylist = new ArrayList<>(lists);
        Collections.sort(arraylist, new Comparator<AttendanceLog>() {
            @Override
            public int compare(AttendanceLog o1, AttendanceLog o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i).getName());
        }
    }
}

class AttendanceLog {
    private String name;
    private String attendance;

    public AttendanceLog(String name, String attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        // 주소값이 같으면 같은 객체입니다.
        if (this == obj) return true;
        // 형변환 할 수 없으면 다른 객체입니다.
        if (!(obj instanceof AttendanceLog)) {
            return false;
        }
        // 형변환이 가능하면 형변환해서 비교합니다.
        AttendanceLog log = (AttendanceLog) obj;
        return log.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
