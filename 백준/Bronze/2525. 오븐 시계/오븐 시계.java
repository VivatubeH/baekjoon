import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int tot = a*60+b+c;
		if ( tot >= 1440 ) {
			tot -= 1440;
			a = tot/60;
			b = tot%60;
		}
		else {
			a = tot/60;
			b = tot%60;
		}
		System.out.println(a+" "+b);
		}
	}

