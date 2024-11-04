package BT_TinhKeThua;

import java.util.ArrayList;
import java.util.Scanner;

public class DS_TK {
    private ArrayList<TaiKhoan> danhSachTaiKhoan;

    public DS_TK() {
        this.danhSachTaiKhoan = new ArrayList<>();
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng tài khoản: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        for (int i = 1; i <= n; i++) {
            System.out.println("Đăng ký tài khoản thứ " + i + ":");
            TaiKhoan tk = new TaiKhoan(); // Giả sử bạn có một lớp TaiKhoan hợp lệ

            // Gọi phương thức DangKy() để thực hiện đăng ký
            if (tk.DangKy()) { // Nếu đăng ký thành công
                // Kiểm tra xem tài khoản đã tồn tại chưa
                if (!isTaiKhoanTonTai(tk.getSoTaiKhoan())) {
                    danhSachTaiKhoan.add(tk); // Thêm tài khoản vào danh sách
                    System.out.println("Đăng ký thành công tài khoản: " + tk.getSoTaiKhoan());
                } else {
                    System.out.println("Tài khoản đã tồn tại. Vui lòng thử lại.");
                    i--; // Để không tăng chỉ số i nếu tài khoản đã tồn tại
                }
            } else {
                System.out.println("Đăng ký tài khoản không thành công. Vui lòng thử lại.");
                i--; // Để không tăng chỉ số i nếu đăng ký không thành công
            }
        }
    }

    public void Xuat() {
        System.out.println("Danh sách tài khoản:");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            tk.Xuat(); // Gọi phương thức Xuat() của lớp TaiKhoan
            System.out.println("-------------------------");
        }
    }

    public boolean DangNhap(String soTaiKhoan) {
        TaiKhoan tk = getTaiKhoan(soTaiKhoan);
        if (tk != null) {
            return tk.DangNhap();
        } else {
            System.out.println("Tài khoản không tồn tại.");
            return false;
        }
    }

    public void QuenMatKhau() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tài khoản hoặc số CCCD: ");
        String nhap = scanner.nextLine();
        
        TaiKhoan tk = getTaiKhoan(nhap);
        if (tk != null) {
            tk.QuenMatKhau(); // Gọi phương thức QuenMatKhau() trong lớp TaiKhoan
        } else {
            System.out.println("Số tài khoản hoặc số CCCD không tồn tại.");
        }
    }

    protected TaiKhoan getTaiKhoan(String nhap) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getSoTaiKhoan().equals(nhap) || tk.getCccd().equals(nhap)) {
                return tk;
            }
        }
        return null; // Tài khoản không tồn tại
    }

    public Iterable<TaiKhoan> DanhSachTaiKhoan() {
        return danhSachTaiKhoan; // Trả về danh sách tài khoản
    }

    private boolean isTaiKhoanTonTai(String soTaiKhoan) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return true; // Tài khoản đã tồn tại
            }
        }
        return false; // Tài khoản không tồn tại
    }

    public void xemLichSuGiaoDich() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tài khoản để xem lịch sử giao dịch: ");
        String soTaiKhoan = scanner.nextLine();

        TaiKhoan tk = getTaiKhoan(soTaiKhoan);
        if (tk != null) {
            if (tk.getxemlichSuGiaoDich().isEmpty()) { // Kiểm tra xem danh sách giao dịch có rỗng không
                System.out.println("Hiện tại chưa có giao dịch nào.");
            } else {
                tk.xemLichSuGiaoDich(); // Gọi phương thức xem lịch sử giao dịch từ lớp TaiKhoan
            }
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }
    }

    public void themTaiKhoan(TaiKhoanTietKiem tkTietKiem) {
        // Kiểm tra xem tài khoản đã tồn tại chưa
        if (isTaiKhoanTonTai(tkTietKiem.getSoTaiKhoan())) {
            System.out.println("Tài khoản: " + tkTietKiem.getSoTaiKhoan() + " đã được mở tài khoản tiết kiệm");
        } else {
            danhSachTaiKhoan.add(tkTietKiem); // Thêm tài khoản tiết kiệm vào danh sách
            System.out.println("Tài khoản tiết kiệm đã được mở: " + tkTietKiem.getSoTaiKhoan());
        }
    }
}