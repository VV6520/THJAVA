import java.util.Scanner;

public class baitap {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("nhap vao so nguyen duong n = ");
		n=sc.nextInt();
		int s=0;
		int i;
		if(n<=0) {
			System.out.println("so nhap vao khong hop le");
		}else {
			for(i=1;i<=n;i++) {
				s=s+i;
			}
			System.out.println("tong tu 1 den n la "+s);
		}
	}
}
