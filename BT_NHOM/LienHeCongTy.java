package BT_NHOM;

import java.util.Scanner;

public class LienHeCongTy extends LienHe {
	private String tenCongTy;
    public LienHeCongTy(String maLienHe, String hoTen, String soDienThoai, String email,String tenCongTy) {
		super(maLienHe, hoTen, soDienThoai, email);
		this.tenCongTy=tenCongTy;
	}
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên công ty: ");
        tenCongTy = scanner.nextLine();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Loại liên hệ: Công ty");
        System.out.println("Mã liên hệ: " + maLienHe);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Email: " + email);
        System.out.println("Tên công ty: " + tenCongTy);
    }
}
