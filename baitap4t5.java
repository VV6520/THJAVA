import java.util.Scanner;

public class baitap4t5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nhap vao so phan tu cua mang ");
		int n;
		n=sc.nextInt();
		double mang[]= new double[(int) n];
		System.out.println("\nhap vao cac phan tu cua mang : ");
		int i,j;
		for(i=0;i<mang.length;i++) {
			System.out.println("\nphan tu thu "+i+" : ");
			mang[i]=sc.nextDouble();
		}
		System.out.println("\nmang vua nhap la :");
		for(i=0;i<mang.length;i++) {
			System.out.println(mang[i]);
		}
		double max=mang[0];
		int solan=1;
		for(i=0;i<mang.length;i++) {
			int dem =1;
			for(j=i+1;j<mang.length;j++) {
				if(mang[i]==mang[j]) {
					dem++;
				}
			}
			if(dem>solan) {
				solan=dem;
				max=mang[i];
			}
		}
		System.out.println("\nphan tu xuat hien nhieu nhat la : "+max+" voi so lan xuat hien "+solan);
	}
}
