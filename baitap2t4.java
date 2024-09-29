import java.util.Scanner;

public class baitap2t4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=10;
		int s;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=10;j++) {
				s=i*j;
				System.out.println(i+" * "+j+" = "+s);
			}
			System.out.println("-----------------------------");
		}
	}
}
