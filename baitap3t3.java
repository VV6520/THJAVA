import java.util.Scanner;

public class baitap3t3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// a^2+b+c=0
		//a,b,c,x1,x2,delta
		//b1 delta=b^2-4ac
		//b2 delta<0=>pt vô nghiệm
		/*
		 * delta==0=> pt có nghiệm kep x1=x2=-b/2a
		 * delta>0=> pt có 2 nghiệm phân biệt
		 * x1=(-b-sqtr(delta))/(2a)
		 * x2=(-b+sqrt(delta))/(2a)
		 */
		double a,b,c,x1,x2,delta;
		System.out.println("nhap vao a= ");
		a=sc.nextDouble();
		System.out.println("nhap vao b= ");
		b=sc.nextDouble();
		System.out.println("nhap vao c= ");
		c=sc.nextDouble();
		delta=Math.pow(b,2)-4*a*c;
		if(a==0) {
			System.out.println("nhap du lieu sai");
		}
		if(delta<0) {
			System.out.println("phuong trinh vo nghiem");
		}else if(delta==0) {
			x1=-b/(2*a);
			System.out.println("phuong trinh co nggiem kep x1=x2= "+x1);
		}else {
			x1=(-b-Math.sqrt(delta))/(2*a);
			x2=(-b+Math.sqrt(delta))/(2*a);
			System.out.println("phuong trin co 2 nhiem x1 = "+x1+" va x2 = "+x2);
		}
		
	}
}