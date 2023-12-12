import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
	    int b = in.nextInt();
	    int c = in.nextInt();
	    
	    if ( a==b &&b==c) System.out.println(10000+a*1000);
	    else if ( a==b || a==c ) System.out.println(1000+a*100);
	    else if ( b==c ) System.out.println(1000+b*100);
	    else { 
	    	if ( a > b && a>c) System.out.println(a*100);
	    	if ( b > c && b>a) System.out.println(b*100);
	    	if ( c > b && c>a) System.out.println(c*100);
	    }
	}
}
