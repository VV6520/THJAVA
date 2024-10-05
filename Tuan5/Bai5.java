import java.util.Scanner;
public class Bai5 {
    // Hàm nhập mảng
    public static void nhapMang(int[] arr, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            System.out.printf("M[%d]= ", i);
            arr[i] = scanner.nextInt();
        }
    }
    // Hàm xuất mảng
    public static void xuatMang(int[] arr, int n) {
        System.out.println("Cac phan tu trong mang");
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        nhapMang(arr, n);
        xuatMang(arr, n);
    }
}
