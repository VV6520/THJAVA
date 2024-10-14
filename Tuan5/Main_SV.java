package Tuan5;
import java.util.Scanner;
public class Main_SV{
    
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\nMenu:");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Xoa sinh vien");
        System.out.println("3. Tim kiem sinh vien theo ma");
        System.out.println("4. Sap xep sinh vien theo diem");
        System.out.println("5. Hien thi danh sach sinh vien");
        System.out.println("6. Thoat");
        System.out.print("Chon chuc nang: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhap ma sinh vien: ");
                String id = scanner.nextLine();
                System.out.print("Nhap ten sinh vien: ");
                String ten = scanner.nextLine();
                System.out.print("Nhap diem trung binh: ");
                double score = scanner.nextDouble();
                SinhVien.themSinhVien(id, ten, score);
                break;

            case 2:
                System.out.print("Nhap ma sinh vien can xoa: ");
                String maXoa = scanner.nextLine();
                SinhVien.xoaSinhVien(maXoa);
                break;

            case 3:
                System.out.print("Nhap ma sinh vien: ");
                String maTim = scanner.nextLine();
                SinhVien sinhVienTim = SinhVien.timSinhVien(maTim);
                if (sinhVienTim != null) {
                    System.out.println("Tim thay: " + sinhVienTim);
                } else {
                    System.out.println("Khong tim thay sinh vien voi ma: " + maTim);
                }
                break;

            case 4:
                SinhVien.sapXepSinhVien();
                break;

            case 5:
                SinhVien.hienThiDanhSachSinhVien();
                break;

            case 6:
                System.out.println("Thoat chuong trinh.");
                break;

            default:
                System.out.println("Chon khong hop le. Vui long thu lai!");
        }
    } 
    while (choice != 6);
}
}