import java.util.Scanner;

public class kiemtraso {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap vao n =");
		int n;
		n=sc.nextInt();
		if(n>0) {
			System.out.println(n+ " la so nguyen duong");
		}
		else if(n<0){
			System.out.println(n+ " la so nguyen am");
		}
		else{
			System.out.println("n = "+n);
		}
	}
}
