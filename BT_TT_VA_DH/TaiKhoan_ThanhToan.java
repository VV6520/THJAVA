package BT_TT_VA_DH;

public class TaiKhoan_ThanhToan extends Tai_Khoan{

	public TaiKhoan_ThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
	}
	
	@Override
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

	@Override
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

	@Override
	public double kiemTraSoDu(String matKhau) {
		if (!this.matKhau.equals(matKhau)) {
            System.out.println("Mau khau khong dung. Khong the kiem tra so du");
            return -1;
        }
        return soDu;
	}

}

