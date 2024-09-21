import java.util.Scanner;

public class vidu3 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("nhap vao so a:");
			int a=sc.nextInt();
			System.out.println("nhap vao so b:");
			int b=sc.nextInt();
			System.out.println("nhap vao so c:");
			int c=sc.nextInt();
			//
			int min;
			if(a<b) {
				min=a;
			}else {
				min=b;
			}
			if(c<min) {
				min=c;
			}
			System.out.println("So lon nhat trong ba so la :"+min);
		}
	}
}
