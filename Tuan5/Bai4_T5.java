import java.util.Scanner;

public class Bai4_T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap vao so phan tu cua mang: ");
        int n = sc.nextInt();
        double mang[] = new double[n];
        int i, j;

        for (i = 0; i < mang.length; i++) {
            System.out.printf("Nhap phan tu thu " + i + ": ");
            mang[i] = sc.nextDouble();
        }

        System.out.println("\nMang vua nhap la:");
        for (i = 0; i < mang.length; i++) {
            System.out.println(mang[i]);
        }

        double max = mang[0];
        int solan = 1;
        boolean found = false;

        for (i = 0; i < mang.length; i++) {
            int dem = 1;
            for (j = i + 1; j < mang.length; j++) {
                if (mang[i] == mang[j]) {
                    dem++;
                }
            }
            if (dem > solan) {
                solan = dem;
                max = mang[i];
                found = true;
            }
        }
        if (solan == 1)
            System.out.println("Khong co phan tu nao xuat hien nhieu nhat.");
        else
            System.out.println("Phan tu xuat hien nhieu nhat la: " + max + " voi so lan xuat hien: " + solan);
    }
}