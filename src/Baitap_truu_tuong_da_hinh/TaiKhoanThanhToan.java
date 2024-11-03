package Baitap_truu_tuong_da_hinh;

import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan{
    private double phiGiaoDich;
    private double hanMucThauChi;
    Scanner sc = new Scanner(System.in);
    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau,
                             double phiGiaoDich, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.phiGiaoDich = phiGiaoDich;
        this.hanMucThauChi = hanMucThauChi;
    }

    public double getPhiGiaoDich() {
        return phiGiaoDich;
    }

    public void setPhiGiaoDich(double phiGiaoDich) {
        this.phiGiaoDich = phiGiaoDich;
    }

    public double getHanMucThauChi() {
        return hanMucThauChi;
    }

    public void setHanMucThauChi(double hanMucThauChi) {
        this.hanMucThauChi = hanMucThauChi;
    }

    @Override
    public void rutTien(String xacNhanMK) {
        System.out.printf("Nhập vào số tiền cần rút");
        double soTien = sc.nextDouble();
        double tongSoTien = soTien + phiGiaoDich;
        if (!this.matKhau.equals(xacNhanMK)){
            System.out.println("Sai mật khẩu. Không thể rút tiền");
        }else if (this.soDu >= tongSoTien) {
            this.soDu -= tongSoTien;
            System.out.println("Đã rút " + soTien + " từ tài khoản với phí giao dịch " + phiGiaoDich +
                    ". Số dư còn lại: " + this.soDu);
        }else{
            while(true) {
                System.out.println("Số dư không đủ. Bạn có muốn dùng hạn mức thấu chi không?" +
                        "\nNhấn Y: Có" +
                        "\nNhấn N: Không");
                String luaChon = new Scanner(System.in).nextLine();

                if (luaChon.equalsIgnoreCase("y")) {
                    if (this.soDu + hanMucThauChi >= tongSoTien) {
                        this.soDu -= tongSoTien;
                        System.out.println("Đã rút " + soTien + " từ tài khoản với phí giao dịch " + phiGiaoDich +
                                ". Số dư còn lại (bao gồm thấu chi): " + this.soDu);
                        hanMucThauChi = this.soDu + hanMucThauChi - tongSoTien;
                        System.out.println("Hạn mức thấu chi còn lại: " + hanMucThauChi);
                        break;
                    } else {
                        System.out.println("Số tiền rút vượt quá hạn mức thấu chi!");
                        break;
                    }
                } else if (luaChon.equalsIgnoreCase("n")) {
                    System.out.println("Giao dịch bị hủy.");
                    break;
                } else {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập Y hoặc N.");
                }
            }

        }
    }
}

