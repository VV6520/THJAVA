package Baitap_truu_tuong_da_hinh;

import java.util.Scanner;
//Nguyễn Hữu Phước - 23115053122132
public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau){
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }
    public abstract void rutTien(String xacNhanMK);

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getMatKhau(){
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
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

    public void guiTien(double tienGui, String xacNhanMK){
        if (this.matKhau.equals(xacNhanMK)){
            System.out.println("Đã gửi thành công");
            soDu = this.soDu + tienGui;
            System.out.println("Số dư hiện tại"+this.soDu);
        }else
            System.out.println("Sai mật khẩu. Không thể gửi tiền");
    }
    public void doimatKhau(String matKhauCu){
        if(this.matKhau.equals(matKhauCu)){
            System.out.println("Nhập vào mật khẩu mới");
            String matKhauMoi = new Scanner(System.in).nextLine();
            setMatKhau(matKhauMoi);
        }else
            System.out.println("Mật khẩu không hợp lệ!");
    }

    @Override
    public String toString() {
        return "Tài khoản: "+soTaiKhoan+" soDu= " + soDu;
    }
}
