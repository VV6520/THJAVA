package BT_DongGoi;

import java.util.Scanner;

public class Main_TKNH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        String chuTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so du ban dau: ");
        double soDu = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        // Tạo đối tượng TaiKhoanNH
        TaiKhoanNH taiKhoan = new TaiKhoanNH(soTaiKhoan, chuTaiKhoan, soDu, matKhau);

        System.out.println("\n--Thong tin tai khoan--");
        System.out.println("So tai khoan: " + taiKhoan.getSoTaiKhoan());
        System.out.println("Chu tai khoan: " + taiKhoan.getChuTaiKhoan());
        System.out.println("So du: " + taiKhoan.getSoDu() + " VND");

        while (true) {
            System.out.println("\n==Menu==");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Thay doi mat khau");
            System.out.println("5. Thoat");
            System.out.print("Chon thao tac muon kiem tra: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap mat khau: ");
                    String matKhauGui = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Nhap so tien muon gui: ");
                    double soTienGui = scanner.nextDouble();
                    taiKhoan.guiTien(soTienGui, matKhauGui);
                    break;

                case 2:
                    System.out.print("Nhap so tien muon rut: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nhap mat khau: ");
                    String matKhauRut = scanner.nextLine();
                    taiKhoan.rutTien(soTienRut, matKhauRut);
                    break;

                case 3:
                    System.out.print("Nhap mat khau: ");
                    String matKhauKiemTra = scanner.nextLine();
                    double soDuHienTai = taiKhoan.kiemTraSoDu(matKhauKiemTra);
                    if (soDuHienTai != -1) {
                        System.out.println("So du hien tai: " + soDuHienTai);
                    }
                    break;

                case 4:
                    String matKhauCu;
                    String matKhauMoi;
                    while (true) {
                        System.out.print("Nhap mat khau cu de thay doi: ");
                        matKhauCu = scanner.nextLine();
                        if (matKhauCu.equals(taiKhoan.getmatKhau())) {
                            System.out.print("Nhap mat khau moi: ");
                            matKhauMoi = scanner.nextLine();
                            if (taiKhoan.doiMatKhau(matKhauCu, matKhauMoi))
                                break;
                        } 
                        else
                            System.out.println("Mat khau cu khong dung. Vui long thu lai.");
                    }
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lsi");
            }
        }
    }
}
