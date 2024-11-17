package BT_NHOM;

import java.util.Scanner;

public class LienHeCaNhan extends LienHe {
	private String diaChi;
    public LienHeCaNhan(String maLienHe, String hoTen, String soDienThoai, String email,String diaChi) {
		super(maLienHe, hoTen, soDienThoai, email);
		this.diaChi=diaChi;
	}
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Loại liên hệ: Cá nhân");
        System.out.println("Mã liên hệ: " + maLienHe);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Email: " + email);
        System.out.println("Địa chỉ: " + diaChi);
    }
}
