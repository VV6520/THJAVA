package Baitap_dong_goi_2;

public class TaiKhoanThanhToan extends TaiKhoan{
    private double phiGiaoDich;
    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double phiGiaoDich) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.phiGiaoDich = phiGiaoDich;
    }
    @Override
    public void rutTien(double soTien, String matKhau) {
        double tongSoTien = soTien + phiGiaoDich;
        if (this.kiemTraSoDu() >= tongSoTien) {
            super.rutTien(tongSoTien, matKhau);
            System.out.println("Đã rút " + soTien + " từ tài khoản với phí giao dịch " + phiGiaoDich + ". Số dư còn lại: " + this.kiemTraSoDu());
        } else {
            System.out.println("Số dư không đủ để rút tiền và trả phí.");
        }
    }


}
