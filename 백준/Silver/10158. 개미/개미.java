import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        // 격자의 크기 w, h가 주어집니다.
        int w = in.nextInt();
        int h = in.nextInt();
        // 개미의 초기 좌표값 p, q를 입력받습니다.
        int p = in.nextInt();
        int q = in.nextInt();
        // 개미의 최초 좌표를 토대로 개미 객체를 생성합니다.
        Ant ant = new Ant(p, q);
        // 개미가 움직일 시간 t초를 부여합니다.
        int t = in.nextInt();
        ant.moveAntToX(t, w);
        ant.moveAntToY(t, h);
        System.out.println(ant.getxPosition() + " " + ant.getyPosition());
    }
}

class Ant { // 개미에 대해 정의하기 위한 클래스
    private int xPosition = 0; // 개미의 x 좌표
    private int yPosition = 0; // 개미의 y 좌표

    // 개미를 생성하고 위치 변수를 초기화합니다.
    public Ant(int x, int y) {
        xPosition = x;
        yPosition = y;
    }

    public void moveAntToX(int time, int squareX) { 
        // 최초에 우측 끝까지 이동할 수가 없다면 그냥 남은 시간만큼만 우측으로 이동하면 됩니다.
        // 즉 squareX - xPosition(우측 남은 거리)가 time(이동 가능한 거리) 보다 크면 그냥 이동만 하고 주기를 생각할 필요가 없습니다.
        if (squareX - xPosition > time) {
        	xPosition += time;
        }
        else {
        // 이동이 가능하면 우측 끝까지 이동해야 합니다.
        time -= (squareX - xPosition);
        // 위치는 우측 끝으로 이동됩니다.
        xPosition = squareX;
        // 우측 끝으로 이동했다면 여기서부터 주기를 계산합니다.
        // x축 격자 길이 x 2 만큼 이동하는 순간 원래 자리 그대로가 되어버린다. 즉 주기를 띕니다.
        time %= (2 * squareX);
        
        // 이 남은 거리를 토대로 좌표를 계산하면 2가지 경우가 나옵니다.
        // squareX - time이 0보다 크거나 같다면 그대로 좌표가 됩니다.
        // 0보다 작다면 반대방향이니 절댓값을 취해줍니다.
        xPosition = Math.abs(squareX - time);
        }
    }

    public void moveAntToY(int time, int squareY) {
        // x이동과 같은 논리로 구합니다.
    	if (squareY - yPosition > time) {
    		yPosition += time;
    		return;
    	}
    	else {
    	// 이동이 가능하면 위쪽으로 이동해야 합니다.
    	time -= (squareY - yPosition);
    	
    	yPosition = squareY;
    	
    	time %= (2 * squareY);
    	
    	yPosition = Math.abs(squareY - time);
    	}
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}