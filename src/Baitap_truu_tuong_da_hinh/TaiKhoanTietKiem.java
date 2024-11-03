package Baitap_truu_tuong_da_hinh;

import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan{
    private double laiXuat;
    private double kyHanGui;
    Scanner sc = new Scanner(System.in);
    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiXuat,
                            double kyHanGui){
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiXuat = laiXuat;
        this.kyHanGui = kyHanGui;
    }

    public double getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(double laiXuat) {
        this.laiXuat = laiXuat;
    }

    public double getKyHanGui() {
        return kyHanGui;
    }

    public void setKyHanGui(double kyHanGui) {
        this.kyHanGui = kyHanGui;
    }

    public void tienLai(String matKhau){
        double tienLai = this.soDu * this.laiXuat * (this.kyHanGui/365);
        System.out.println("Tiền lãi nhận được sau khi gửi "+this.kyHanGui+" ngày là: "+tienLai);
        guiTien(tienLai, matKhau);
    }
    @Override
    public void rutTien(String xacNhanMK){
        System.out.printf("Nhập vào số tiền cần rút: ");
        double soTien = sc.nextDouble();
        if (super.getMatKhau().equals(xacNhanMK)){
            if (soTien < this.soDu){
                this.soDu -= soTien;
                System.out.println("Rút thành công. Số dư còn lại "+ this.soDu);
            }
            else
                System.out.println("Số dư không đủ!!");
        }else
            System.out.println("Sai mật khẩu. Không thể rút tiền!!");
    }
}
