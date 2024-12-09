package BT_TinhTruuTuong_DaHinh;

import java.util.ArrayList;
import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    private static final double THAU_CHI_LIMIT = 1000000; // Số tiền thấu chi tối đa
    private static ArrayList<String> danhSachBiPhat = new ArrayList<>(); // Danh sách tài khoản bị phạt
    static final Scanner scanner = new Scanner(System.in); // Khai báo một lần

    public TaiKhoanThanhToan() {
        super(); // Gọi constructor mặc định của lớp cha
    }

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau); // Gọi constructor của lớp cha
    }

    @Override
    public void DangKy() {
        super.DangKy(); // Gọi phương thức Nhap() của lớp cha
        
        // Gửi OTP và xác minh
        guiOTP(); // Gửi mã OTP
        if (!xacMinhOTP()) {
            System.out.println("Đăng ký thất bại do xác thực OTP không thành công.");
            return;
        }
        
        System.out.println("Xác minh đúng!");
    }

    @Override
    public void guiTien(double soTienGui) {
        
        // Khởi tạo số tiền thực tế sẽ được cộng vào số dư
        double soTienThucTeGui = soTienGui;

        // Kiểm tra xem tài khoản có bị phạt thấu chi không
        if (danhSachBiPhat.contains(getSoTaiKhoan())) {
            System.out.println("Tài khoản của bạn sử dụng đã thanh toán dịch vụ và vượt số tiền thấu chi cho phép.");
            System.out.println("Bạn sẽ bị trừ 50,000 VNĐ vào số dư.");

            // Trừ phí phạt vào số tiền thực tế gửi
            soTienThucTeGui = soTienGui - 50000;

            // Nếu số tiền thực tế gửi nhỏ hơn 0, thông báo không đủ
            if (soTienThucTeGui < 0) {
                System.out.println("Số tiền gửi sau khi trừ phí phạt không đủ. Giao dịch không thể thực hiện.");
                return;
            }

            // Cập nhật số dư sau khi trừ phí phạt
            setSoDu(getSoDu() - 50000);
            System.out.println("Đã trừ phí phạt. Số dư hiện tại: " + getSoDu());
        }

        // Gửi mã OTP
        guiOTP(); 

        // Xác minh mã OTP
        if (!xacMinhOTP()) {
            System.out.println("Xác thực OTP không thành công. Giao dịch không thể thực hiện.");
            return;
        }

        // Cập nhật số dư sau khi gửi tiền thực tế
        setSoDu(getSoDu() + soTienThucTeGui);
        System.out.println("Gửi tiền thành công: " + soTienGui + " VNĐ. Số dư hiện tại: " + getSoDu());
    }

    @Override
    public void rutTien(double soTien) {

        // Kiểm tra số tiền rút
        if (soTien > 0) {
            double soDuHienTai = getSoDu(); // Số dư hiện tại

            // Kiểm tra xem số tiền rút có vượt quá số dư cộng với hạn mức thấu chi không
            if (soTien <= soDuHienTai + THAU_CHI_LIMIT) {
                if (soTien > soDuHienTai) {
                    System.out.println("Bạn đang sử dụng thấu chi.");
                    danhSachBiPhat.add(getSoTaiKhoan()); // Thêm vào danh sách bị phạt
                }
                if (!xacThucOTP()) {
                    System.out.println("Xác thực OTP không thành công.");
                } else {
                    setSoDu(soDuHienTai - soTien); // Cập nhật số dư
                    lichSuGiaoDich.add("Rút tiền: " + soTien + " VNĐ"); // Lưu giao dịch
                    System.out.println("Rút tiền thành công: " + soTien);
                }
            } else {
                System.out.println("Số tiền rút không hợp lệ.");
            }
        } else {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        }
    }

    public void chuyenKhoan(double soTien, String soTaiKhoanNhan, DS_TK dsTK) {
        // Kiểm tra điều kiện số tiền chuyển
        if (soTien > 0) {
            double soDuHienTai = getSoDu(); // Số dư hiện tại

            // Kiểm tra xem số tiền chuyển có vượt quá số dư cộng với hạn mức thấu chi không
            if (soTien <= soDuHienTai + THAU_CHI_LIMIT) {
                // Sử dụng phương thức getTaiKhoan để tìm tài khoản nhận
                TaiKhoan tkNhan = dsTK.getTaiKhoan(soTaiKhoanNhan);

                // Kiểm tra xem tài khoản nhận có tồn tại
                if (tkNhan != null) {
                    // Gửi mã OTP
                    guiOTP(); 

                    // Xác minh mã OTP
                    if (xacMinhOTP()) { // Xác minh OTP
                        this.rutTien(soTien); // Rút tiền từ tài khoản hiện tại
                        tkNhan.guiTien(soTien); // Gửi tiền vào tài khoản nhận
                        lichSuGiaoDich.add("Đã chuyển tiền: " + soTien + " VND tới tài khoản " + soTaiKhoanNhan);
                        System.out.println("Chuyển tiền thành công!");
                    } else {
                        System.out.println("Xác thực OTP không thành công. Không thể chuyển tiền.");
                    }
                } else {
                    System.out.println("Số tài khoản nhận không tồn tại.");
                }
            } else {
                System.out.println("Số tiền chuyển không hợp lệ hoặc vượt quá số dư cộng với hạn mức thấu chi.");
            }
        } else {
            System.out.println("Số tiền chuyển phải lớn hơn 0.");
        }
    }

    public void thanhToanPhiDichVu(double phiDichVu, Scanner scanner) {
        // Kiểm tra số tiền phí dịch vụ
        if (phiDichVu > 0 && phiDichVu <= getSoDu()) {
            // Kiểm tra mật khẩu
            if (!nhapMatKhau(scanner)) {
                System.out.println("Mật khẩu không đúng. Không thể thực hiện thanh toán phí dịch vụ.");
                return;
            }

            // Gửi mã OTP
            guiOTP(); 

            // Xác minh mã OTP
            if (xacMinhOTP()) { 
                rutTien(phiDichVu); // Rút tiền từ tài khoản
                lichSuGiaoDich.add("Thanh toán phí dịch vụ: " + phiDichVu + " VND");
                System.out.println("Thanh toán phí dịch vụ thành công. Số dư hiện tại: " + getSoDu());
            } 
            else
                System.out.println("Xác thực OTP không thành công. Không thể thanh toán phí dịch vụ.");
        } 
        else
            System.out.println("Không đủ số dư để thanh toán phí dịch vụ hoặc số tiền không hợp lệ.");
    }

    public void napCard() {
        System.out.print("Nhập số tiền muốn nạp card: ");
        double soTienNapCard = scanner.nextDouble();

        if (soTienNapCard > 0) {
            guiOTP(); 
            if (xacMinhOTP()) { 
                setSoDu(getSoDu() - soTienNapCard); 
                lichSuGiaoDich.add("Nạp card: " + soTienNapCard + " VND");
                System.out.println("Nạp card thành công. Số tiền nạp: " + soTienNapCard + " VND");
                System.out.println("Số dư hiện tại: " + getSoDu());
            } 
            else
                System.out.println("Xác thực OTP không thành công. Không thể nạp card.");
        } 
        else
            System.out.println("Số tiền nạp không hợp lệ.");
    }

    public void thanhToanHoaDon() {
        System.out.print("Nhập số tiền khi thanh toán hóa đơn: ");
        double soTienHoaDon = scanner.nextDouble();

        // Kiểm tra số tiền thanh toán
        if (soTienHoaDon > 0) {
            double soDuHienTai = getSoDu(); // Lấy số dư hiện tại

            // Kiểm tra xem số tiền thanh toán có vượt quá số dư cộng với hạn mức thấu chi không
            if (soTienHoaDon <= soDuHienTai + THAU_CHI_LIMIT) {
                System.out.print("Nhập mật khẩu: ");
                String matKhauNhap = scanner.next(); 

                if (isMatKhauDung(matKhauNhap)) { 
                    guiOTP(); 
                    if (xacMinhOTP()) { 
                        rutTien(soTienHoaDon); // Rút tiền để thanh toán
                        lichSuGiaoDich.add("Thanh toán hóa đơn: " + soTienHoaDon + " VND");
                        System.out.println("Thanh toán hóa đơn thành công. Số dư hiện tại: " + getSoDu());
                    } else {
                        System.out.println("Xác thực OTP không thành công. Không thể thanh toán hóa đơn.");
                    }
                } else {
                    System.out.println("Mật khẩu không đúng. Không thể thực hiện thanh toán.");
                }
            } else {
                System.out.println("Số tiền thanh toán không hợp lệ hoặc vượt quá số dư cộng với hạn mức thấu chi.");
            }
        } else {
            System.out.println("Số tiền thanh toán phải lớn hơn 0.");
        }
    }

    private boolean nhapMatKhau(Scanner scanner) {
        int sothu = 0;
        while (sothu < 2) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.nextLine();

            if (!isMatKhauDung(matKhauNhap)) {
                sothu++;
                System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - sothu) + " lần thử.");
            } else {
                return true; // Mật khẩu đúng
            }
        }
        System.out.println("Không thể thực hiện thao tác rút tiền do nhập sai mật khẩu quá nhiều lần.");
        return false; // Mật khẩu sai sau 2 lần thử
    }

    public void xemThongTinTaiKhoan() {
        System.out.println("----------Thông tin tài khoản thanh toán:----------");
        super.Xuat(); // Gọi phương thức Xuat từ lớp cha
    }

    public void LichSuGiaoDich() {
        if (!lichSuGiaoDich.isEmpty()) {
            System.out.println("Lịch sử giao dịch cho tài khoản: " + getSoTaiKhoan());
            for (String giaoDich : lichSuGiaoDich) {
                System.out.println(giaoDich);
            }
        } else {
            System.out.println("Lịch sử giao dịch hiện chưa có.");
        }
    }
}