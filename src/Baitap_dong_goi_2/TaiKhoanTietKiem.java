package Baitap_dong_goi_2;

public class TaiKhoanTietKiem extends TaiKhoan{
    private double laiXuat;
    private double kyHanGui;
    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiXuat, int kyHanGui){
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiXuat = laiXuat;
        this.kyHanGui = kyHanGui;
    }
    public void tienLai(String matKhau){
        double tienLai = this.kiemTraSoDu() * this.laiXuat * (this.kyHanGui/365);
        System.out.println("Tiền lãi nhận được sau khi gửi "+this.kyHanGui+" ngày là: "+tienLai);
        guiTien(tienLai, matKhau);
        System.out.println("Số dư hiện tại là: "+kiemTraSoDu());
    }


}
