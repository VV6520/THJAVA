import java.util.Scanner;
public class Bai5_T5 {
    // Hàm nhập mảng
    public static void nhapMang(int[] mang, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            System.out.printf("M[%d]= ", i);
            mang[i] = scanner.nextInt();
        }
    }
    // Hàm xuất mảng
    public static void xuatMang(int[] mang, int n) {
        System.out.println("Cac phan tu trong mang:");
        for (int i = 1; i <= n; i++) {
            System.out.print(mang[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int[] mang = new int[n+1];
        nhapMang(mang, n);
        xuatMang(mang, n);
        scanner.close();
    }
}
