package Tuan8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main_DV {
    public static void main(String[] args) {
        List<DongVat> danhSachDongVat = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String loaiDongVat;
        String tenDongVat;
        int tuoi;

        System.out.print("Nhap so luong dong vat: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhap loai dong vat (Meo/Cho/Chim): ");
            loaiDongVat = scanner.nextLine();

            System.out.print("Nhap ten dong vat: ");
            tenDongVat = scanner.nextLine();

            System.out.print("Nhap tuoi dong vat: ");
            tuoi = scanner.nextInt();
            scanner.nextLine();


            DongVat dv;
            switch (loaiDongVat.toLowerCase()) {
                case "meo":
                    dv = new Meo(tenDongVat, tuoi);
                    break;
                case "cho":
                    dv = new Cho(tenDongVat, tuoi);
                    break;
                case "chim":
                    dv = new Chim(tenDongVat, tuoi);
                    break;
                default:
                    dv = new DongVat(tenDongVat, tuoi);
                    break;
            }

            System.out.println("-----------------------");
            danhSachDongVat.add(dv);
        }

        for (DongVat dv : danhSachDongVat) {
            dv.tiengKeu();
        }

        scanner.close();
    }
}