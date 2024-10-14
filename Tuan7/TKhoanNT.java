package Tuan6;
public class TKhoanNT{
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;

    public TKhoanNT(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
    }

    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Da gui: " + soTien + ". So du hien tai: " + soDu);
        }
        else
            System.out.println("So tien gui phai lon hon 0.");
    }

    public void rutTien(double soTien) {
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

    public double kiemTraSoDu() {
        return soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
}
