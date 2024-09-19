import java.util.Scanner;
public class Bai4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap so tien gui (VND): ");
        double soTienGoc = sc.nextDouble();
        System.out.print("Nhap lai suat hang nam: ");
        double laiSuatHangNam = sc.nextDouble(); // Nhập trực tiếp với dấu %
        System.out.print("Nhap so thang gui: ");
        int soThangGui = sc.nextInt();
        sc.close();
        // Tính toán lãi suất đơn
        double laiSuatHN = laiSuatHangNam / 100; // Chuyển lãi suất hàng năm sang dạng số thập phân
        double soTienLai = soTienGoc * laiSuatHN * (soThangGui / 12.0); // Tính số tiền lãi
        double soTienGocCuoiKy = soTienGoc + soTienLai; // Tính số tiền gốc cuối kỳ
        // In kết quả cho lãi suất đơn
        System.out.printf("So tien lai (lai suat don) la: %.1f VND\n", soTienLai);
        System.out.printf("So tien goc cuoi ky (lai suat don) la: %.1f VND\n", soTienGocCuoiKy);
        // Tính toán lãi suất kép
        double soTienCuoiKy = soTienGoc * Math.pow(1 + laiSuatHN, soThangGui / 12.0); // Công thức tính lãi suất kép
        double soTienLaiKep = soTienCuoiKy - soTienGoc; // Tính số tiền lãi kép
        // In kết quả cho lãi suất kép
        System.out.printf("So tien lai (lai suat kep) la: %.1f VND\n", soTienLaiKep);
        System.out.printf("So tien goc cuoi ky (lai suat kep) la: %.1f VND\n", soTienCuoiKy);
    }
}
