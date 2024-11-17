package BT_NHOM;

import java.util.Scanner;

public abstract class LienHe {
	protected String maLienHe;
    protected String hoTen;
    protected String soDienThoai;
    protected String email;

    public LienHe(String maLienHe, String hoTen, String soDienThoai, String email) {

		this.maLienHe = maLienHe;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getMaLienHe() {
		return maLienHe;
	}

	public void setMaLienHe(String maLienHe) {
		this.maLienHe = maLienHe;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã liên hệ: ");
        maLienHe = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        hoTen = scanner.nextLine();
        while (true) {
            try {
                System.out.print("Nhập số điện thoại (10 chữ số): ");
                soDienThoai = scanner.nextLine();
                if (!soDienThoai.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Số điện thoại phải có 10 chữ số.Vui lòng nhập lại.");
                }
                break; 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nhập email: ");
        email = scanner.nextLine();
    }

    public abstract void hienThiThongTin();
}
