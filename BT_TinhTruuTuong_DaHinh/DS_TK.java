package BT_TinhTruuTuong_DaHinh;

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
            TaiKhoan tk = new TaiKhoan() {};
            
            // Gọi phương thức DangKy() để thực hiện đăng ký
            tk.DangKy(); // Không cần kiểm tra giá trị trả về

            // Kiểm tra xem tài khoản đã tồn tại chưa
            if (!isTaiKhoanTonTai(tk.getsoTaiKhoan())) {
                danhSachTaiKhoan.add(tk); // Thêm tài khoản vào danh sách
                System.out.println("Đăng ký thành công tài khoản: " + tk.getsoTaiKhoan());
            } else {
                System.out.println("Tài khoản đã tồn tại. Vui lòng thử lại.");
                i--; // Để không tăng chỉ số i nếu tài khoản đã tồn tại
            }
        }
    }

    public void Xuat() {
        System.out.println("Danh sách tài khoản:");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            tk.Xuat(); // Gọi phương thức Xuat() của lớp TaiKhoan
            System.out.println("-------------------------------------");
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
            if (tk.getsoTaiKhoan().equals(nhap) || tk.getcccd().equals(nhap)) {
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
            if (tk.getsoTaiKhoan().equals(soTaiKhoan)) {
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

    public void themTaiKhoanTK(TaiKhoan tk) {
        // Kiểm tra xem tài khoản có phải là TaiKhoanTietKiem không
        if (!(tk instanceof TaiKhoanTietKiem)) {
            System.out.println("Tài khoản không phải là tài khoản tiết kiệm, không thể mở.");
            return;
        }

        TaiKhoanTietKiem tkTietKiem = (TaiKhoanTietKiem) tk; // Ép kiểu về TaiKhoanTietKiem

        // Kiểm tra xem tài khoản có tồn tại trong danh sách không
        if (isTaiKhoanTonTai(tkTietKiem.getsoTaiKhoan())) {
            System.out.println("Tài khoản: " + tkTietKiem.getsoTaiKhoan() + " đã được mở tiết kiệm thành công.");
        } else {
            // Nếu tài khoản chưa tồn tại, thêm vào danh sách
            // Lấy thông tin từ tài khoản gốc
            TaiKhoan taiKhoanGoc = getTaiKhoan(tkTietKiem.getsoTaiKhoan());
            if (taiKhoanGoc != null) {
                // Sao chép thông tin cần thiết từ tài khoản gốc
                tkTietKiem.setcccd(taiKhoanGoc.getcccd());
                tkTietKiem.setchuTaiKhoan(taiKhoanGoc.getchuTaiKhoan());
                tkTietKiem.setsoDu(taiKhoanGoc.getSoDu()); // Sao chép số dư

                // Thêm tài khoản tiết kiệm vào danh sách
                danhSachTaiKhoan.add(tkTietKiem); // Thêm tài khoản tiết kiệm vào danh sách
                System.out.println("Đã mở tài khoản tiết kiệm thành công cho tài khoản: " + tkTietKiem.getsoTaiKhoan());
            } else {
                System.out.println("Không tìm thấy tài khoản gốc để mở tài khoản tiết kiệm.");
            }
        }
    }
    
    public void themTaiKhoanTT(TaiKhoan tk) {
        // Kiểm tra xem tài khoản có phải là TaiKhoanThanhToan không
        if (!(tk instanceof TaiKhoanThanhToan)) {
            System.out.println("Tài khoản không phải là tài khoản thanh toán, không thể mở.");
            return;
        }

        TaiKhoanThanhToan tkThanhToan = (TaiKhoanThanhToan) tk; // Ép kiểu về TaiKhoanThanhToan
            // Kiểm tra xem tài khoản có tồn tại trong danh sách không
            if (isTaiKhoanTonTai(tkThanhToan.getsoTaiKhoan())) {
                System.out.println("Tài khoản: " + tkThanhToan.getsoTaiKhoan() + " sẵn sàng thực hiện thanh toán.");
            } else {
                // Nếu tài khoản chưa tồn tại, thêm vào danh sách
                // Lấy thông tin từ tài khoản gốc
                TaiKhoan taiKhoanGoc = getTaiKhoan(tkThanhToan.getsoTaiKhoan());
                if (taiKhoanGoc != null) {
                    // Sao chép thông tin cần thiết từ tài khoản gốc
                    tkThanhToan.setcccd(taiKhoanGoc.getcccd());
                    tkThanhToan.setchuTaiKhoan(taiKhoanGoc.getchuTaiKhoan());
                    tkThanhToan.setsoDu(taiKhoanGoc.getSoDu()); // Sao chép số dư

                    // Thêm tài khoản thanh toán vào danh sách
                    danhSachTaiKhoan.add(tkThanhToan); // Thêm tài khoản thanh toán vào danh sách
                    System.out.println("Đã mở tài khoản thanh toán thành công cho tài khoản: " + tkThanhToan.getsoTaiKhoan());
                } else {
                    System.out.println("Không tìm thấy tài khoản gốc để mở tài khoản thanh toán.");
                }
            }
        }
}