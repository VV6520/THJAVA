import java.util.Arrays;
import java.util.Scanner;

public class baitap3t5 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		double mang[];
		int i;
		mang = new double[5];
		for(i=0;i<mang.length;i++) {
			System.out.println("nhap vao phan tu thu "+i+" : ");
			mang[i]=sc.nextDouble();
		}
		System.out.println("\nmang vua nhap la :");
		for(i=0;i<mang.length;i++) {
			System.out.println(mang[i]);
		}
		Arrays.sort(mang);
		System.out.println("\nmang sau khi sap xep : ");
		for(i=0;i<mang.length;i++) {
			System.out.println(mang[i]);
		}
	}	
}
