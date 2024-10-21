package Tuan8;

import java.util.Scanner;

public class Main_TL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chon loai tai lieu (1: Sach, 2: Tap Chi, 3: Bao): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap vao ma tai lieu: ");
        String ma = scanner.nextLine();
        System.out.println("Nhap vao ten tai lieu: ");
        String ten = scanner.nextLine();
        System.out.println("Nhap vao nam xuat ban: ");
        int nam = scanner.nextInt();

        switch (choice) {
            case 1: // Sach
                Sach sach = new Sach(ma, ten, nam);
                System.out.println(sach.toString());
                System.out.println("Nhap so trang: ");
                int soTrang = scanner.nextInt();
                sach.soTrang(soTrang);
                System.out.println("Nhap the loai (1: Thieu nhi, 2: Tam ly, 3: Khoa hoc vien tuong 4: Lich su, 5: Van hoa xa hoi): ");
                int theLoaiChoice = scanner.nextInt();
                String theLoai = "";
                switch (theLoaiChoice) {
                    case 1: theLoai = "Thieu nhi"; break;
                    case 2: theLoai = "Tam ly"; break;
                    case 3: theLoai = "Khoa hoc vien tuong"; break;
                    case 4: theLoai = "Lich su"; break;
                    case 5: theLoai = "Van hoa xa hoi"; break;
                    default: System.out.println("Lua chon khong hop le"); return;
                }
                sach.theLoai(theLoai);
                break;

            case 2: // Tap Chi
                TapChi tapChi = new TapChi(ma, ten, nam);
                System.out.println(tapChi.toString());
                System.out.println("Nhap so phat hanh: ");
                int soPhatHanh = scanner.nextInt();
                tapChi.soPhatHanh(soPhatHanh);
                System.out.println("Nhap doi tuong: ");
                scanner.nextLine();
                String doiTuong = scanner.nextLine();
                tapChi.doiTuong(doiTuong);
                break;

            case 3: // Bao
                Bao bao = new Bao(ma, ten, nam);
                System.out.println(bao.toString());
                System.out.println("Nhap chuyen muc: ");
                scanner.nextLine();
                String chuyenMuc = scanner.nextLine();
                bao.chuyenMuc(chuyenMuc);
                break;

            default:
                System.out.println("Lua chon khong hop le");
        }

        scanner.close();
    }
}