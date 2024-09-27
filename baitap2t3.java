import java.util.Scanner;

public class baitap2t3 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n;
		System.out.println("nhap vao so diem : ");
		n=sc.nextInt();
		if(n>=8) {
			System.out.println("hoc sinh xep loai tot");
		}else if(n>=6) {
			System.out.println("hoc sinh xep loai kha");
		}else if(n>=4) {
			System.out.println("hoc sinh xep loai trung binh");
		}else {
			System.out.println("hoc sinh xep loai yeu");
		}
	}
}