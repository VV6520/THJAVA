package BT_TinhKeThua;

import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private boolean kyHan; // true: có kỳ hạn, false: không kỳ hạn
    private int soThangGui; // Số tháng gửi nếu có kỳ hạn
    private int soNgayGui;  // Số ngày gửi nếu không có kỳ hạn
    private double soTien;
    static final Scanner sc = new Scanner(System.in); // Khai báo một lần

    public TaiKhoanTietKiem() {
        super();
    }
    
    public TaiKhoanTietKiem(double laiSuat, boolean kyHan, int soThangGui, int soNgayGui, String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.soThangGui = soThangGui;
        this.soNgayGui = soNgayGui;
    }
      
    // Phương thức nhập thông tin tài khoản
    @Override
    public void DangKy() {
        super.DangKy(); // Gọi phương thức Nhap() của lớp cha
        
        thietLapKyHan();
        laiSuat();
        // Gửi OTP và xác minh
        guiOTP(); // Gửi mã OTP
        if (!xacMinhOTP()) {
            System.out.println("Đăng ký thất bại do xác thực OTP không thành công.");
            return;
        }
    
        System.out.println("Xác minh đúng!");
    }    
    
    public void laiSuat() {
        if (kyHan) { // Kiểm tra nếu có kỳ hạn
            double laiSuatNhap;
            while (true) {
                System.out.print("Nhập lãi suất (phải lớn hơn 0): ");
                laiSuatNhap = sc.nextDouble();

                if (laiSuatNhap > 0) {
                    this.laiSuat = laiSuatNhap; // Gán giá trị lãi suất hợp lệ
                    break; // Thoát khỏi vòng lặp nếu lãi suất hợp lệ
                } else {
                    System.out.println("Lãi suất không hợp lệ. Vui lòng nhập lại."); // Thông báo lỗi
                }
            }
        } else {
            this.laiSuat = 1.0; // Gán lãi suất mặc định 1% cho không kỳ hạn
            System.out.println("Sử dụng lãi suất mặc định 1% cho không kỳ hạn.");
        }
    }

    public void thietLapKyHan() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Có kỳ hạn không? (Y/N): ");
        String choice = sc.nextLine();
        this.kyHan = choice.equalsIgnoreCase("Y");

        if (kyHan) {
            System.out.print("Nhập số tháng gửi: ");
            this.soThangGui = sc.nextInt();
            sc.nextLine();
        } 
        else {
            System.out.print("Nhập số ngày thực gửi: ");
            this.soNgayGui = sc.nextInt();
            sc.nextLine();
        }
    }

    public double tinhLai() {
        double laiSuatHienTai;

        if (kyHan) {
            // Tính lãi suất theo kỳ hạn
            laiSuatHienTai = laiSuat / 100; // Chuyển đổi lãi suất thành tỷ lệ phần trăm
            return getSoDu() * laiSuatHienTai * soThangGui / 12; // Tính lãi suất cho kỳ hạn
        } else {
            // Sử dụng lãi suất cố định 1% cho không kỳ hạn
            laiSuatHienTai = 1.0 / 100; // 1% lãi suất
            return getSoDu() * laiSuatHienTai * soNgayGui / 365; // Tính lãi suất cho không kỳ hạn
        }
    }

    public void rutLaiDungKyHan(Scanner scanner) {
        if (kyHan) {
            double soTienLai = tinhLai();
            System.out.println("Số tiền lãi có thể rút: " + soTienLai + " VND");
            System.out.print("Bạn có muốn rút lãi đúng kỳ hạn không? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                // Nhập mật khẩu
                int thu = 0;
                while (thu < 2) {
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauNhap = scanner.nextLine();

                    if (isMatKhauDung(matKhauNhap)) {
                        // Gửi OTP trước khi rút lãi
                        guiOTP(); // Gửi mã OTP
                        if (xacMinhOTP()) {
                            // Nếu OTP xác thực thành công, thực hiện rút lãi
                            System.out.println("Đã rút lãi: " + soTienLai + " VND");
                        } else {
                            System.out.println("Xác thực OTP không thành công. Không thể rút lãi.");
                        }
                        return; // Kết thúc phương thức
                    } else {
                        thu++;
                        System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - thu) + " lần thử.");
                    }
                }
                System.out.println("Không thể thực hiện thao tác rút lãi do nhập sai mật khẩu quá nhiều lần.");
            } else {
                System.out.println("Không rút lãi.");
            }
        } else {
            System.out.println("Tài khoản không có kỳ hạn, không áp dụng rút lãi đúng kỳ hạn.");
        }
    }
    
    public void rutLaiKhongKyHan(Scanner scanner) {
        if (!kyHan) {
            double soTienLai = getSoDu() * 0.01 / 365; // Tính lãi tối đa 1%/năm
            System.out.println("Số tiền lãi có thể rút: " + soTienLai + " VND");
            System.out.print("Bạn có muốn rút lãi không? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                // Nhập mật khẩu
                int test = 0;
                while (test < 2) {
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauNhap = scanner.nextLine();

                    if (isMatKhauDung(matKhauNhap)) {
                        // Gửi OTP trước khi rút lãi
                        guiOTP(); // Gửi mã OTP
                        if (xacMinhOTP()) {
                            // Nếu OTP xác thực thành công, thực hiện rút lãi
                            System.out.println("Đã rút lãi: " + soTienLai + " VND.");
                        } else {
                            System.out.println("Xác thực OTP không thành công. Không thể rút lãi.");
                        }
                        return; // Kết thúc phương thức
                    } else {
                        test++;
                        System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - test) + " lần thử.");
                    }
                }
                System.out.println("Không thể thực hiện thao tác rút lãi do nhập sai mật khẩu quá nhiều lần.");
            } else {
                System.out.println("Bạn đã chọn không rút lãi.");
            }
        } else {
            System.out.println("Tài khoản có kỳ hạn, không áp dụng rút lãi theo hình thức này.");
        }
    }

    @Override
    public void rutTien(double soTien) {
        // Kiểm tra số tiền rút
        if (soTien <= 0) {
            throw new IllegalArgumentException("Số tiền rút không hợp lệ.");
        }

        // Kiểm tra số dư
        if (soTien >= getSoDu()) {
            System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
            return;
        }

        // Kiểm tra mật khẩu trước khi rút tiền
        if (kiemTraSLMatKhau(sc, 3)) { // Gọi phương thức kiểm tra mật khẩu
            guiOTP(); // Gửi OTP
            if (xacMinhOTP()) { // Xác minh OTP
                soDu -= soTien; // Cập nhật số dư
                lichSuGiaoDich.add("Rút tiền: " + soTien + " VNĐ"); // Lưu giao dịch
                System.out.println("Đã rút " + soTien + " VND. Số dư hiện tại: " + soDu);
            } else {
                System.out.println("Xác thực OTP không thành công. Không thể rút tiền.");
            }
        } else {
            System.out.println("Không thể thực hiện thao tác do nhập sai mật khẩu quá nhiều lần.");
        }
    }

    @Override
    public void guiTien(double soTien) {
        // Kiểm tra số tiền gửi
        if (soTien <= 0) {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
            return;
        }

        // Kiểm tra mật khẩu trước khi gửi tiền
        if (kiemTraSLMatKhau(sc, 3)) { // Gọi phương thức kiểm tra mật khẩu
            soDu += soTien; // Cập nhật số dư
            lichSuGiaoDich.add("Gửi tiền: " + soTien + " VNĐ"); // Lưu giao dịch
            System.out.println("Đã gửi: " + soTien + ". Số dư hiện tại: " + soDu);
        } else {
            System.out.println("Không thể thực hiện thao tác do nhập sai mật khẩu quá nhiều lần.");
        }
    }

    // Phương thức kiểm tra số lần nhập mật khẩu
    @Override
    public boolean kiemTraSLMatKhau(Scanner scanner, int MAX_NHAP) {
        for (int test = 0; test < MAX_NHAP; test++) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.nextLine();
            if (this.matKhau.equals(matKhauNhap)) {
                return true;
            }
            System.out.println("Mật khẩu không đúng. Bạn còn " + (MAX_NHAP - test - 1) + " lần thử.");
        }
        return false;
    }

    @Override
    public void Xuat() {
        System.out.println("------------------------------------");
        super.Xuat(); // Gọi phương thức Xuat() của lớp cha
        System.out.println("Lãi suất: " + this.laiSuat);
        System.out.println("Có kỳ hạn: " + (this.kyHan ? "Có" : "Không"));
        if (kyHan) {
            System.out.println("Số tháng gửi: " + this.soThangGui);
        } else {
            System.out.println("Số ngày gửi: " + this.soNgayGui);
        }
    }

    public void capNhatLaiSuat(Scanner scanner) {
        System.out.print("Nhập lãi suất mới: ");
        this.laiSuat = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Lãi suất đã được cập nhật thành công!");
    }


    public void setlaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public void setkyHan(boolean kyHan) {
        this.kyHan = kyHan;
    }
    
    public double getlaiSuat() {
        return laiSuat;
    }

    public boolean iskyHan() {
        return kyHan;
    }

    public int getSoThangGui() {
        return soThangGui;
    }

    public int getSoNgayGui() {
        return soNgayGui;
    }
    
    public void LichSuGiaoDich() {
        if (lichSuGiaoDich.isEmpty()) {
            System.out.println("Lịch sử giao dịch hiện chưa có.");
        } else {
            System.out.println("Lịch sử giao dịch cho tài khoản: " + getSoTaiKhoan());
            for (String giaoDich : lichSuGiaoDich) {
                System.out.println(giaoDich);
            }
        }
    }
       
}