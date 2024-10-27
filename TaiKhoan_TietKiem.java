package BT_KETHUA;

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

    // Ghi đè phương thức rút tiền để kiểm tra số dư tối thiểu
    @Override
    public void rutTien(double soTien, String matKhau) {
        if (getSoDu() - soTien >= sodutoithieu) {
            super.rutTien(soTien, matKhau);
        } else {
            System.out.println("Không thể rút tiền. Cần duy trì số dư tối thiểu: " + sodutoithieu);
        }
    }
}
