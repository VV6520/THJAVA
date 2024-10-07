import java.util.Arrays;
import java.util.Scanner;

public class Bai3_T5 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int i;
		// Nhập số lượng phần tử của mảng
        System.out.print("Nhap vao so luong phan tu trong mang: ");
        int n = sc.nextInt();
        
        // Khởi tạo mảng với kích thước n
        int[] mang = new int[n];
		for(i=0;i<mang.length;i++) {
			System.out.printf("nhap vao phan tu thu "+i+" : ");
			mang[i]=sc.nextInt();
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
