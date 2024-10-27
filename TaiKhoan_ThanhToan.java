package BT_KETHUA;

public class TaiKhoan_ThanhToan extends Tai_Khoan{

	public TaiKhoan_ThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
	}

	@Override
	public void rutTien(double soTien, String matKhau) {
		if(soTien<=getSoDu()) {
			super.rutTien(soTien, matKhau);
		}else {
			System.out.println("Số Dư Không Đủ."+soTien);
		}
	}

}
