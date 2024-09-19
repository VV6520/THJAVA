import java.util.Scanner;

public class vidu4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a,b,ketqua;
		System.out.println("nhap vao a = ");
		a=sc.nextDouble();
		System.out.println("nhap vao b = ");
		b=sc.nextDouble();
		String kitu;
		System.out.println("nhap vao phep tinh can tinh");
		kitu=sc.next();
		if(kitu.equals("+")){
			ketqua=a+b;
			System.out.println("a + b = "+ketqua);
		}else if(kitu.equals("-")) {
			ketqua=a-b;
			System.out.println("a - b = "+ketqua);
		}else if(kitu.equals("*")) {
			ketqua=a*b;
			System.out.println("a * b = "+ketqua);
		}else if(kitu.equals("/")) {
			if(a==0) {
				System.out.println("khong the thuc hien phep chia");
			}else {
				ketqua=a/b;
				System.out.println("a / b = "+ketqua);
			}
		}else {
			System.out.println("du lieu nhan duoc khoong hop le");
		}
	}
}
