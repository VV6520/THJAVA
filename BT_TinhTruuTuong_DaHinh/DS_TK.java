package BT_TinhTruuTuong_DaHinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DS_TK {
    private ArrayList<TaiKhoan> danhSachTaiKhoan;
    static final Scanner scanner = new Scanner(System.in); // Khai báo một lần
    protected List<String> lichSuGiaoDich = new ArrayList<>(); // Khởi tạo danh sách

    public DS_TK() {
        this.danhSachTaiKhoan = new ArrayList<>();
    }

    public void DangKy() {
        System.out.print("Nhập số lượng tài khoản: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("Số lượng tài khoản phải lớn hơn 0.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            themTaiKhoan(); // Gọi phương thức thêm tài khoản
        }
    }

    public void themTaiKhoan() {
        System.out.println("Mời bạn chọn loại tài khoản để đăng ký:");
        System.out.println("1. Tài khoản tiết kiệm");
        System.out.println("2. Tài khoản thanh toán");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        TaiKhoan tk;
        switch (luaChon) {
            case 1:
                tk = new TaiKhoanTietKiem(); // Tạo tài khoản tiết kiệm
                break;
            case 2:
                tk = new TaiKhoanThanhToan(); // Tạo tài khoản thanh toán
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Đăng ký thất bại.");
                return;
        }

        tk.DangKy(); // Gọi phương thức đăng ký từ lớp cha
        if (!isTaiKhoanTonTai(tk.getSoTaiKhoan())) {
            danhSachTaiKhoan.add(tk); // Thêm tài khoản vào danh sách
            System.out.println("Đã đăng ký thành công tài khoản: " + tk.getSoTaiKhoan());
        } else {
            System.out.println("Tài khoản đã tồn tại. Không thể thêm.");
        }
    }

    public String DangNhapTK() {
        System.out.print("Nhập số tài khoản để đăng nhập: ");
        String soTaiKhoan = scanner.nextLine();
        TaiKhoan tk = getTaiKhoan(soTaiKhoan);

        if (tk != null) {
            tk.DangNhap(); // Gọi phương thức đăng nhập từ đối tượng tài khoản

            // Kiểm tra xem tài khoản có được mở khóa sau khi đăng nhập không
            if (!tk.isKhoaTaiKhoan()) {
                return soTaiKhoan; // Trả về số tài khoản nếu đăng nhập thành công
            } else {
                return null; // Tài khoản bị khóa
            }
        } else {
            System.out.println("Không tìm thấy tài khoản có số tài khoản: " + soTaiKhoan);
            return null; // Tài khoản không tồn tại
        }
    }

    public void hienThiDanhSachTaiKhoan() {
        if (danhSachTaiKhoan.isEmpty()) {
            System.out.println("==Danh sách tài khoản trống.==");
            return;
        }
        System.out.println("-----------Danh sách tài khoản:------------");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            tk.Xuat(); // Gọi phương thức Xuat() của lớp TaiKhoan
            System.out.println("-------------------------------------");
        }
    }

    public void hienThiLichSuGiaoDich(String soTaiKhoan) {
        TaiKhoan tk = getTaiKhoan(soTaiKhoan);
        if (tk != null) {
            List<String> lichSu = tk.getLichSuGiaoDich();
            if (lichSu.isEmpty()) {
                System.out.println("Hiện tại chưa có giao dịch nào.");
            } else {
                System.out.println("Lịch sử giao dịch cho tài khoản " + soTaiKhoan + ":");
                for (String giaoDich : lichSu) {
                    System.out.println(giaoDich);
                }
            }
        } else {
            System.out.println("Không tìm thấy tài khoản có số tài khoản: " + soTaiKhoan);
        }
    }
    
    public boolean isTaiKhoanTonTai(String soTaiKhoan) {
        return getTaiKhoan(soTaiKhoan) != null; // Sử dụng getTaiKhoan để kiểm tra
    }

    public TaiKhoan getTaiKhoan(String soTaiKhoan) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return tk; // Trả về tài khoản nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public void xoaTaiKhoan(String soTaiKhoan) {
        TaiKhoan taiKhoan = getTaiKhoan(soTaiKhoan);
        if (taiKhoan != null) {
            danhSachTaiKhoan.remove(taiKhoan);
            System.out.println("Đã xóa tài khoản: " + soTaiKhoan);
        } else {
            System.out.println("Không tìm thấy tài khoản có số tài khoản: " + soTaiKhoan);
        }
    }

    public void QuenMatKhau() {
        System.out.print("Nhập số tài khoản: ");
        String nhap = scanner.nextLine();
        
        TaiKhoan tk = getTaiKhoan(nhap);
        if (tk != null) {
            tk.QuenMatKhau(); // Gọi phương thức QuenMatKhau() trong lớp TaiKhoan
        } else {
            System.out.println("Số tài khoản không tồn tại.");
        }
    }
}