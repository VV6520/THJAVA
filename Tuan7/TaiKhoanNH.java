package Tuan7;

public class TaiKhoanNH {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    public TaiKhoanNH(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    // Phương thức thay đổi mật khẩu
    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (!this.matKhau.equals(matKhauCu)) {
            System.out.println("Doi mat khau that bai. Mat khau cu khong dung.");
            return;
        }
        
        if (this.matKhau.equals(matKhauMoi)) {
            System.out.println("Mau khau moi giong mat khau cu: " + getMatKhau());
            return;
        }

        this.matKhau = matKhauMoi; // Đổi mật khẩu
        System.out.println("Doi mat khau thanh cong.");
    }

    // Phương thức lấy mật khẩu
    public String getMatKhau() {
        return this.matKhau;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }
}