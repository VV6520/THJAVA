package TH6_2;

import TH5_7.DanhSachHocSinh;
import TH5_7.HocSinh;

import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon = 0;
        do{
            System.out.println("Vui lòng chọn chức năng");
            System.out.println(
                    "1. Thêm\n"
                            +"2. In danh sách\n"
                            +"3. Sắp xếp theo điểm từ cao đến thấp"
            );
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon){
                case 1:
                    System.out.println("Nhập mã sinh viên: ");
                    String maSinhVien = sc.nextLine();
                    System.out.println("Nhập họ và tên: ");
                    String hoVaten = sc.nextLine();
                    System.out.println("Nhập vào ngày sinh: ");
                    String ngaySinh = sc.nextLine();
                    System.out.println("Nhập vào điểm trung bình: ");
                    float diemTB = sc.nextFloat();
                    SinhVien sv = new SinhVien(maSinhVien, hoVaten, ngaySinh, diemTB);
                    dssv.themSinhVien(sv);
                    break;
                case 2:
                    dssv.inDanhSachSinhVien();
                    break;
                case 3:
                    dssv.saXepDiemSvGiamDan();
                    dssv.inDanhSachSinhVien();
                    break;
            }
        }while(luaChon!=0);
    }
}
