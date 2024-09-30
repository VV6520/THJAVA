import java.util.Scanner;

public class Bai2_T4 {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=10;
		int s;
		for(int i=2;i<n;i++) {
            System.out.println("Bang cuu chuong "+i);
			for(int j=1;j<=10;j++) {
				s=i*j;
				System.out.println(i+"*"+j+" = "+s);
			}
			System.out.println("-----------------------------");
		}
	}
}
