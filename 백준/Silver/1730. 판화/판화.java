import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사용자로부터 목판의 크기를 입력받습니다.
        int N = Integer.parseInt(br.readLine());
        // 목판은 최초에 모든 칸이 .으로 이루어집니다.
        // N 크기의 목판을 만들고 목판을 .으로 전부 채워넣습니다.

        char[][] woodBlock = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                woodBlock[i][j] = '.';
            }
        }

        // 목판을 이동하기 위한 명령을 한 줄로 입력받습니다.
        String moveInstructions = br.readLine();

        // 목판의 현재 위치를 활용하기 위해 목판을 생성합니다.
        WoodPlate plate = new WoodPlate();

        // 명령에 따라 이동을 진행합니다.
        for (int i = 0; i < moveInstructions.length(); i++) {
            // 순서대로 명령을 실행하기 위해 instruction 변수에 담습니다.
            char instruction = moveInstructions.charAt(i);

            plate.moveRobotArms(woodBlock, instruction);
        }

        // 이동을 완료했으면 목판을 출력합니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(woodBlock[i][j]);
            }
            System.out.println();
        }
    }
}

class WoodPlate {
    private static int currentRow = 0; // 현재 y 좌표를 구합니다.
    private static int currentCol = 0; // 현재 x 좌표를 구합니다.
    // 로봇팔을 이동시키는 명령을 입력받아서 로봇팔을 움직이면서 판자를 그립니다.
    // 로봇팔 이동을 위해서 목판의 상태, 현재 몇 행 몇 열인지, 명령이 무엇인지를 받습니다.
    public void moveRobotArms(char[][] woodBlock, char instruction) {
        // 로직1. 만약 밖으로 나가는 명령인 경우 실행하지 않고 해당 메서드를 종료합니다.
        if (currentCol == 0 && instruction == 'L') { // 왼쪽 끝인데 왼쪽으로 이동하는 명령
            return;
        } else if (currentCol == woodBlock.length - 1 && instruction == 'R') { // 오른쪽 끝인데 오른쪽으로 이동하는 명령
            return;
        } else if (currentRow == 0 && instruction == 'U') { // 위쪽 끝인데 위로 이동하는 명령
            return;
        } else if (currentRow == woodBlock.length - 1 && instruction == 'D') { // 아래쪽 끝인데 아래로 이동하는 명령
            return;
        }

        // 로직2. 실제 이동을 수행합니다. ( 이 때 이동 전 칸의 목판과 이동 후 칸의 목판을 찍어줘야 합니다. )

        // 이동전 목판을 찍습니다.
        if (instruction == 'U' || instruction == 'D') { // 수직 이동의 경우
            if (woodBlock[currentRow][currentCol] == '.') woodBlock[currentRow][currentCol] = '|';
            else if (woodBlock[currentRow][currentCol] == '-') woodBlock[currentRow][currentCol] = '+';
        } else if (instruction == 'R' || instruction == 'L') { // 수평 이동의 경우
            if (woodBlock[currentRow][currentCol] == '.') woodBlock[currentRow][currentCol] = '-';
            else if (woodBlock[currentRow][currentCol] == '|') woodBlock[currentRow][currentCol] = '+';
        }

        // 이동합니다.
        switch (instruction) {
            case 'U' :
                currentRow--;
                break;
            case 'D' :
                currentRow++;
                break;
            case 'L' :
                currentCol--;
                break;
            case 'R' :
                currentCol++;
                break;
        }

        // 이동 후 목판도 찍습니다.
        // 이동 전 목판 찍기와 당연히 코드는 동일합니다.
        if (instruction == 'U' || instruction == 'D') { // 수직 이동의 경우
            if (woodBlock[currentRow][currentCol] == '.') woodBlock[currentRow][currentCol] = '|';
            else if (woodBlock[currentRow][currentCol] == '-') woodBlock[currentRow][currentCol] = '+';
        } else if (instruction == 'R' || instruction == 'L') { // 수평 이동의 경우
            if (woodBlock[currentRow][currentCol] == '.') woodBlock[currentRow][currentCol] = '-';
            else if (woodBlock[currentRow][currentCol] == '|') woodBlock[currentRow][currentCol] = '+';
        }

    }
}
