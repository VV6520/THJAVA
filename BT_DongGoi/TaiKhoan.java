package BT_DongGoi;

public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public void guiTien(double soTien, String matKhau) {
        if (!this.matKhau.equals(matKhau)) {
            System.out.println("Mat khau khong dung. Khong the thuc hien thao tac gui tien.");
            return;
        }
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Da gui: " + soTien + ". So du hien tai: " + soDu);
        } 
        else
            System.out.println("So tien gui phai lon hon 0.");
    }

    public void rutTien(double soTien, String matKhau) {
        if (!this.matKhau.equals(matKhau)) {
            System.out.println("Mat khau khong dung. Khong the thuc hien thao tac rut tien.");
            return;
        }
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Da rut: " + soTien + ". So du hien tai: " + soDu);
        }
        else 
            if (soTien > soDu)
                System.out.println("Khong du so du de rut: " + soTien);
            else
                System.out.println("So tien rut phai lon hon 0.");
    }

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

    public double kiemTraSoDu(String matKhau) {
        if (!this.matKhau.equals(matKhau)) {
            System.out.println("Mau khau khong dung. Khong the kiem tra so du");
            return -1;
        }
        return soDu;
    }
}