package Baitap_dong_goi_2;

import java.util.Scanner;
//Nguyễn Hữu Phước - 23115053122132
public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau){
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }
    public void guiTien(double tienGui, String xacNhanMK){
        if (this.matKhau.equals(xacNhanMK)){
            System.out.println("Đã gửi thành công. Số tiền gửi thêm vào là: "+ tienGui);
            soDu = this.soDu + tienGui;
        }else
            System.out.println("Sai mật khẩu. Không thể gửi tiền");
    }
    public void rutTien(double tienRut, String xacNhanMK){
        if (this.matKhau.equals(xacNhanMK)){
            if (tienRut < this.soDu){
                System.out.println("Số tiền đã rút là: "+ tienRut);
                soDu = this.soDu - tienRut;
            }
            else
                System.out.println("Số dư không đủ!!");
        }else
            System.out.println("Sai mat khau. Không thể rút tiền!!");
    }
    public double kiemTraSoDu(){
        return soDu;
    }
    public String getMatKhau(){
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public void kiemTra(String xacNhanMK){
        if (this.matKhau.equals(xacNhanMK)){
            System.out.println("Nhập vào mật khẩu mới: ");
            String mk = new Scanner(System.in).nextLine();
            setMatKhau(mk);
        }
        else
            System.out.println("Mật khẩu không hợp lệ, mời nhập lại!");
    }
}
