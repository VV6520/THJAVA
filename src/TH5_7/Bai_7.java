package TH5_7;

import java.util.Scanner;

public class Bai_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachHocSinh dshs = new DanhSachHocSinh();
        int luaChon = 0;
        do{
            System.out.println("Menu------");
            System.out.println("Vui lòng chọn chức năng");
            System.out.println(
                    "1. Thêm.\n"
                    +"2. In danh sách\n"
                    +"3. Xóa\n"
                    +"4. Tìm\n"
                    +"5. Sắp xếp theo điểm từ cao đến thấp"
            );
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon){
                case 1:
                    System.out.println("Nhập mã học sinh: ");
                    String maHocSinh = sc.nextLine();
                    System.out.println("Nhập họ và tên: ");
                    String hoVaten = sc.nextLine();
                    System.out.println("Nhập vào điểm trung bình: ");
                    float diemTB = sc.nextFloat();
                    HocSinh hs = new HocSinh(maHocSinh, hoVaten, diemTB);
                    dshs.themHocSinh(hs);
                    break;
                case 2:
                    dshs.inDanhSachHocSinh();
                    break;
                case 3:
                    System.out.println("Nhập mã sinh viên: ");
                    maHocSinh = sc.nextLine();
                    hs = new HocSinh(maHocSinh);
                    System.out.println("Xóa sinh viên trong danh sách: "+dshs.xoaHocSinh(hs));
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên: ");
                    maHocSinh = sc.nextLine();
                    System.out.println("Kết quả tìm kiếm: ");
                    dshs.timHocSinh(maHocSinh);
                    break;
                case 5:
                    dshs.saXepDiemGiamDan();
                    dshs.inDanhSachHocSinh();
            }
        }while(luaChon!=0);
    }
}
