import java.util.Scanner;

public class Bai6 {
    public static boolean KTDoiXung(int n) {
        if (n < 0) 
            return false;
        int SoBD = n; // Lưu giữ giá trị gốc
        int SoDN = 0;  // Khởi tạo số đảo ngược
        // Đảo ngược số
        while (n > 0) {
            int ChuSo = n % 10; // Lấy chữ số cuối cùng
            SoDN = SoDN * 10 + ChuSo; // Thêm chữ số vào số đảo ngược
            n /= 10; // Xóa chữ số cuối cùng
        }
        // So sánh số ban đầu với số đảo ngược
        return SoBD == SoDN;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap mot so nguyen: ");
        int n = scanner.nextInt();
        if (KTDoiXung(n))
            System.out.println(n + " la so doi xung.");
        else
            System.out.println(n + " khong phai la so doi xung.");
    }
}
