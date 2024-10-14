package Tuan6;
import java.util.Scanner;
public class Main_TK {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        String chuTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so du ban dau: ");
        double soDu = scanner.nextDouble();
        TaiKhoan TaiKhoan = new TaiKhoan(soTaiKhoan, chuTaiKhoan, soDu);
        while (true) {
            System.out.println("\nChon thao tac:");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Thoat");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so tien muon gui: ");
                    double soTienGui = scanner.nextDouble();
                    TaiKhoan.guiTien(soTienGui);
                    break;

                case 2:
                    System.out.print("Nhap so tien muon rut: ");
                    double soTienRut = scanner.nextDouble();
                    TaiKhoan.rutTien(soTienRut);
                    break;

                case 3:
                    System.out.println("So du hien tai: " + TaiKhoan.kiemTraSoDu());
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }
}
