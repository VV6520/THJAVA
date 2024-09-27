import java.util.Scanner;

public class baitap1t3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("nhap so nguyen n = ");
		n=sc.nextInt();
		if(n>0) {
			System.out.println("day la so nguyen duong");
		}else if(n<0) {
			System.out.println("day la nguyen am ");
		}else {
			System.out.println("n = "+n);
		}
	}
}
