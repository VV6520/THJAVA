package BT_TT_VA_DH;

public abstract class Tai_Khoan {
	private String soTaiKhoan;
    private String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;

    public Tai_Khoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public abstract void guiTien(double soTien, String matKhau);

    public abstract void rutTien(double soTien, String matKhau);
    
    public abstract double kiemTraSoDu(String matKhau);

    // Phương thức thay đổi mật khẩu với kiểu trả về boolean
    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (!this.matKhau.equals(matKhauCu)) {
            System.out.println("Doi mat khau that bai. Mat khau cu khong dung");
            return false;
        }
        if (this.matKhau.equals(matKhauMoi)) {
            System.out.println("Mat khau moi giong mat khau cu. Moi ban thuc hien lai.");
            return false;
        }
        this.matKhau = matKhauMoi;
        System.out.println("Doi mat khau thanh cong");
        return true;
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
    
    public String getmatKhau() {
        return matKhau;
    }
}

