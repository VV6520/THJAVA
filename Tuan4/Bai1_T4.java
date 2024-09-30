import java.util.Scanner;

public class Bai1_T4 {
    public static void main(String[] args) {
        int n, i, tong;
        tong = 0;
        System.out.printf("Nhap vao so n: ");
        n = new Scanner(System.in).nextInt();
        for (i=1; i<=n; i++)
            tong = tong + i;
        System.out.println("Tong cac so tu 1 den "+n+ " la: "+tong);
    }
}
