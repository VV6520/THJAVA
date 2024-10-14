package Tuan6;

import java.util.Scanner;

public class Main_SV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dshs = new DanhSachSinhVien();
        int luaChon;

        do {
            System.out.println("Menu------");
            System.out.println(
                    "1. Thêm\n" +
                    "2. In danh sách\n" +
                    "3. Xóa\n" +
                    "4. Tìm\n" +
                    "5. Sap xep theo diem tu cao den thap\n" +
                    "6. Thoát"
            );
            System.out.print("Vui long chon chuc nang: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.println("Nhap ma sinh vien: ");
                    String maSinhVien = sc.nextLine();
                    System.out.println("Nhap ho va ten: ");
                    String hoVaten = sc.nextLine();
                    System.out.println("Nhap vao diem trung binh: ");
                    float diemTB = sc.nextFloat();
                    SinhVien hs = new SinhVien(maSinhVien, hoVaten, diemTB);
                    dshs.themSinhVien(hs);
                    break;

                case 2:
                    dshs.inDanhSachSinhVien();
                    break;

                case 3:
                    System.out.println("Nhap ma sinh vien: ");
                    maSinhVien = sc.nextLine();
                    hs = new SinhVien(maSinhVien);
                    boolean result = dshs.xoaSinhVien(hs);
                    if (result)
                        System.out.println("Xoa sinh vien thanh cong.");
                    else
                        System.out.println("Khong tim thay sinh vien de xoa.");
                    break;

                case 4:
                    System.out.println("Nhap ma sinh vien: ");
                    maSinhVien = sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    dshs.timSinhVien(maSinhVien);
                    break;

                case 5:
                    dshs.sapXepDiemGiamDan();
                    System.out.println("Danh sach sinh vien sau khi duoc sap xep:");
                    dshs.inDanhSachSinhVien();
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } 
        while (luaChon != 6);
    }
}