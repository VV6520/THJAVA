import java.util.Scanner;

public class baitap4t4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("nhap vo so nguyen duong n = ");
		n=sc.nextInt();
		if(kiemtra(n)) {
			System.out.println("\nday la so nguyen to");
		}else {
			System.out.println("\nday khong phai la so nguyen to ");
		}
	}
	public static boolean kiemtra(int n) {
		if(n<2) {
			return false;
		}for(int i=2;i<Math.sqrt(n);i++){
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
