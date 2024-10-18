public class TaiKhoan {
    // Thuộc tính
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    // Constructor
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
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

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Gửi tiền thành công! Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Số tiền gửi không hợp lệ!");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút tiền thành công! Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc không đủ số dư!");
        }
    }

    public double kiemTraSoDu() {
        return soDu;
    }

    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (this.matKhau.equals(matKhauCu)) {
            this.matKhau = matKhauMoi;
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Mật khẩu cũ không chính xác!");
        }
    }
}