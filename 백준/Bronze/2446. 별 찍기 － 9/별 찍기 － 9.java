import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int N = in.nextInt();
	for(int y = 1; y <= 2*N-1; y++) {
		for(int x = 1; x <= 2*N-1; x++) {
			if(y < N) {
				if((y<=2*N-x) && (y<=x)) {
					System.out.print("*");
				} else if (x<y){
					System.out.print(" ");
				}
			}
			else if(y == N) {
				if(y==x) {
					System.out.print("*");
				} else if (x<N){
					System.out.print(" ");
				}
			}
			else if(y > N){
				if((y>=2*N-x) && (y>=x)) {
					System.out.print("*");
				} else if(y<2*N-x){
					System.out.print(" ");
				}
			}
		}
		System.out.println();
		}
	}
}
