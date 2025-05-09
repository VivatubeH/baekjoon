import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Student> frame = new ArrayList<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1~20 사이의 사진틀의 개수 N
        int rec = Integer.parseInt(br.readLine()); // 1000번 이하인 총 추천횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rec; i++) { // 추천 횟수만큼 입력을 받습니다.
            int current = Integer.parseInt(st.nextToken()); // 현재 숫자입니다.

            // 외부에 메서드를 생성해서 메서드를 통한 학생 추가
            insertNewStudent(current, i);
        }

        // 사진첩 학생을 학생 번호를 기준으로 정렬합니다.
        Collections.sort(frame, (s1, s2) -> {
           return s1.stuNo - s2.stuNo;
        });

        StringBuilder sb = new StringBuilder();
        for (Student stu : frame) {
            sb.append(stu.stuNo + " ");
        }

        System.out.print(sb);
    }

    /*
        학생 번호와 현재 입력 순서를 입력받아서, 내부적으로 판단 후 해당 학생을 frame에 추가하는 메서드
     */
    public static void insertNewStudent(int no, int order) {
        // 사진첩에 학생이 존재하는지 체크하기 위한 변수입니다.
        boolean isInFrame = false;

        // 가장 먼저, 사진첩에 자리가 있는지 확인합니다.
        if (frame.size() == N) { // 사진첩이 이미 다 찬 상태이면
            // 현재 학생이 사진첩에 없는 경우에만
            if (!isStudentInFrame(no)) {
                // 사진첩에 학생을 삭제합니다.
                deleteStudent();
            }
        }
        // 사진첩에 자리를 만든 상태이기 때문에, 여기서 학생을 추가하는 작업을 합니다.
        // 사진첩에 이미 존재하는 경우 -> 추천수만 증가
        // 사진첩에 존재하지 않는 경우 -> 학생 번호로 추천수 1로 추가

        // 사진첩에 존재하지 않는다면 새롭게 추가해야 합니다.
        if (!isStudentInFrame(no)) {
            frame.add(new Student(no, 1, order));
        } else { // 사진첩에 존재한다면 해당 학생의 추천수를 증가시켜야 합니다.
            for (Student std : frame) {
                if (std.stuNo == no) {
                    std.recCount++;
                }
            }
        }
    }

    /*
        정해진 조건에 따라 사진첩에서 학생을 1명 삭제하는 메서드입니다.
     */
    public static void deleteStudent() {
        // 추천수를 기준으로 오름차순 정렬합니다.
        // 추천수가 같다면 입력 순서 기준으로 오름차순 정렬합니다. ( 오래됐다는 건, 입력 순번이 빠르다는 뜻입니다. )
        Collections.sort(frame, (s1, s2) -> {
            if (s1.recCount == s2.recCount) return s1.inputOrder - s2.inputOrder;
            return s1.recCount - s2.recCount;
        });
        // 이렇게 정렬하면 0번째에 있는 게 제거 대상이 됩니다.
        frame.remove(0);
    }

    /*
        해당 번호를 가진 학생이 사진틀에 존재하는지 여부를 체크 후 반환하는 메서드
     */
    public static boolean isStudentInFrame(int no) {
        for (Student std : frame) {
            if (std.stuNo == no) {
                return true;
            }
        }
        return false;
    }
}

class Student {
    public int stuNo; // 학생번호
    public int recCount; // 추천 횟수
    public int inputOrder; // 추천된 순서

    public Student(int stuNo, int recCount, int inputOrder) {
        this.stuNo = stuNo;
        this.recCount = recCount;
        this.inputOrder = inputOrder;
    }
}
