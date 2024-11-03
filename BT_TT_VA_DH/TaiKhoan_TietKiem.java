package BT_TT_VA_DH;

public class TaiKhoan_TietKiem extends Tai_Khoan{
	private double laisuat;
	private double sodutoithieu;
	public TaiKhoan_TietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau,double laisuat,double sodutoithieu) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
		this.laisuat=laisuat;
		this.sodutoithieu=sodutoithieu;
	}
	// Tính lãi suất hàng tháng và cộng vào số dư
    public void tinhLai() {
        if (getSoDu() >= sodutoithieu) {
            double soTienLai = getSoDu() * (laisuat / 100);
            guiTien(soTienLai, getmatKhau());
            System.out.println("Lãi suất hàng tháng đã được tính. Số tiền lãi: " + soTienLai);
        } else {
            System.out.println("Số dư không đủ để tính lãi. Cần ít nhất: " + sodutoithieu);
        }
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
        	if (getSoDu() - soTien >= sodutoithieu) {
                soDu -= soTien;
                System.out.println("Da rut: " + soTien + ". So du hien tai: " + soDu);
            } else {
                System.out.println("Không thể rút tiền. Cần duy trì số dư tối thiểu: " + sodutoithieu);
            }
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
