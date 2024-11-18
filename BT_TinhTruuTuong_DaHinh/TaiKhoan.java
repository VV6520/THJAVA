package BT_TinhTruuTuong_DaHinh;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;
    private int failedLoginAttempts; // Biến lưu số lần nhập sai
    private boolean khoaTaiKhoan; // Biến trạng thái khóa tài khoản
    private long thoiGianKhoa; // Thời gian tài khoản bị khóa
    protected static final int MAX_NHAP = 3; // Số lần nhập tối đa cho mật khẩu
    private static final long maxLockTime = 20000; // Thời gian khóa tài khoản (20 giây)
    private String otp; // Biến lưu mã OTP
    protected long otpCreationTime; // Thời gian tạo OTP
    static final Scanner scanner = new Scanner(System.in); // Khai báo một lần
    protected List<String> lichSuGiaoDich; // Lưu trữ lịch sử giao dịch
    
    public TaiKhoan() {
        lichSuGiaoDich = new ArrayList<>(); // Khởi tạo danh sách giao dịch
    }
    
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {

        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
        this.lichSuGiaoDich = new ArrayList<>();
    }
    
        public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    
    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    // Phương thức đăng ký tài khoản
    public void DangKy() {
        
        try {
            System.out.print("Nhập số tài khoản: ");
            this.soTaiKhoan = scanner.nextLine();

            System.out.print("Nhập chủ tài khoản: ");
            this.chuTaiKhoan = scanner.nextLine();

            double soDu;
            while (true) {
                try {
                    System.out.print("Nhập số dư: ");
                    soDu = scanner.nextDouble();
                    if (soDu < 0) {
                        System.out.println("Số dư không thể âm. Vui lòng nhập lại:");
                        continue;
                    }
                    this.soDu = soDu;
                    break;
                } catch (Exception e) {
                    System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại số dư:");
                    scanner.next(); // Xóa bỏ giá trị sai
                }
            }
            scanner.nextLine(); // Đọc bỏ dòng mới

            String matKhauMoi;
            while (true) {
                System.out.print("Mời nhập mật khẩu: ");
                matKhauMoi = scanner.nextLine();

                if (!KiemTraMatKhauCC(matKhauMoi)) {
                    System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại.");
                } else {
                    this.matKhau = matKhauMoi;
                    break; // Thoát vòng lặp nếu mật khẩu hợp lệ
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại số dư:");
            scanner.next(); // Xóa bỏ giá trị sai
        }
    }
    // Phương thức đăng nhập tài khoản trừu tượng
    public void DangNhap() {
        if (khoaTaiKhoan) {
            if (System.currentTimeMillis() - thoiGianKhoa < maxLockTime) {
                System.out.println("Tài khoản đang bị tạm khóa. Vui lòng thử lại sau.");
                return; // Kết thúc phương thức nếu tài khoản bị khóa
            } else {
                khoaTaiKhoan = false; // Mở khóa tài khoản nếu thời gian đã hết
                failedLoginAttempts = 0; // Đặt lại số lần nhập sai
            }
        }

        // Gọi phương thức kiểm tra số lần nhập mật khẩu
        boolean isSuccess = kiemTraSLMatKhau(scanner, MAX_NHAP);

        if (isSuccess) {
            System.out.println("Đăng nhập thành công.");
        } else {
            khoaTaiKhoan = true; // Khóa tài khoản sau số lần nhập sai tối đa
            thoiGianKhoa = System.currentTimeMillis(); // Ghi lại thời gian khóa
            System.out.println("Tài khoản đã bị khóa do nhập sai quá nhiều lần.");
        }
    }

    // Phương thức kiểm tra mật khẩu cấp cao
    public boolean KiemTraMatKhauCC(String matKhau) {
        if (matKhau.length() < 8) {
            System.out.println("Mật khẩu phải có ít nhất 8 ký tự.");
            return false;
        }
        
        boolean coChuHoa = false;
        boolean coChuThuong = false;
        boolean coSo = false;
        boolean coKyTuDB = false;

        for (char c : matKhau.toCharArray()) {
            if (Character.isUpperCase(c)) coChuHoa = true;
            else if (Character.isLowerCase(c)) coChuThuong = true;
            else if (Character.isDigit(c)) coSo = true;
            else if ("!@#$%^&*()-_=+[]{};:'\",.<>?/|\\`~".indexOf(c) >= 0) coKyTuDB = true;
        }

        if (!coChuHoa) System.out.println("Mật khẩu phải có ít nhất một chữ hoa.");
        if (!coChuThuong) System.out.println("Mật khẩu phải có ít nhất một chữ thường.");
        if (!coSo) System.out.println("Mật khẩu phải có ít nhất một chữ số.");
        if (!coKyTuDB) System.out.println("Mật khẩu phải có ít nhất một ký tự đặc biệt.");

        return coChuHoa && coChuThuong && coSo && coKyTuDB;
    }
    
    public void Xuat() {
        System.out.println("Số tài khoản: " + getSoTaiKhoan());
        System.out.println("Chủ tài khoản: " + getChuTaiKhoan());
        System.out.println("Số dư: " + getSoDu());
    }
    
    //Phương thức gửi tiền trừu tượng 
    public abstract void guiTien(double soTienGui);
    
    //Phương thức rút tiền trừu tượng
    public abstract void rutTien(double soTienRut);
    
    //Phương thức kiểm tra số dư
    public double kiemTraSoDu(String matKhau) {
        if (!isMatKhauDung(matKhau)) {
            System.out.println("Mật khẩu không đúng. Không thể kiểm tra số dư.");
            return -1;
        }
        return soDu;
    }
    
    // Phương thức kiểm tra mật khẩu thường
    public boolean KiemTraMatKhau(String matKhau) {
        if (matKhau.length() < 8) {
            return false; 
        }
        return true; 
    }

    // Phương thức gửi OTP và xác minh
    protected boolean xacThucOTP() {
        guiOTP();
        return xacMinhOTP();
    }
    
    // Phương thức kiểm tra số lần nhập mật khẩu
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

    // Phương thức quên mật khẩu
    public void QuenMatKhau() {
        
        int t = 0;
        while (t < MAX_NHAP) {
            System.out.print("Nhập mật khẩu cũ: ");
            String matKhauCu = scanner.nextLine();

            if (!this.matKhau.equals(matKhauCu)) {
                System.out.println("Mật khẩu cũ không chính xác.");
                t++;
                // Kiểm tra số lần nhập sai
                if (t >= 2) {
                    khoaTaiKhoan = true; // Khóa tài khoản
                    thoiGianKhoa = System.currentTimeMillis(); // Ghi lại thời gian khóa
                    System.out.println("Tài khoản đã bị tạm khóa trong 20 giây do nhập sai mật khẩu quá nhiều lần.");
                    return; // Kết thúc phương thức
                }
                continue;
            }

            // Nếu mật khẩu cũ đúng, reset số lần nhập sai
            t = 0;

            // Nhập mật khẩu mới
            int thuMoi = 0;
            System.out.println("Bạn muốn tạo mật khẩu mới (1: Bình thường, 2: Cấp cao)?");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            while (thuMoi < 2) {
                System.out.print("Nhập mật khẩu mới: ");
                String matKhauMoi = scanner.nextLine();
                if ((luaChon == 1 && KiemTraMatKhau(matKhauMoi)) || 
                    (luaChon == 2 && KiemTraMatKhauCC(matKhauMoi))) {
                    // Gửi OTP trước khi thay đổi mật khẩu
                    guiOTP(); // Gửi mã OTP
                    if (xacMinhOTP()) {
                        this.matKhau = matKhauMoi; // Chỉ thay đổi mật khẩu sau khi xác thực OTP thành công
                        System.out.println("Đổi mật khẩu thành công!");
                        return; // Kết thúc phương thức
                    } 
                    else {
                        System.out.println("Xác thực OTP không thành công. Đổi mật khẩu thất bại.");
                        return; // Kết thúc nếu xác minh OTP không thành công
                    }
                } 
                else {
                    System.out.println("Lựa chọn thay đổi mật khẩu không hợp lệ. Mời bạn thử lại sau.");
                    thuMoi++;
                }
            }
            System.out.println("Bạn đã lựa chọn đổi mật khẩu mới quá nhiều lần!");
            return; // Kết thúc phương thức
        }
        System.out.println("Quá nhiều lần thử!");
    }
    
    // Phương thức kiểm tra mật khẩu cũ có đúng với mật khẩu nhập
    public boolean isMatKhauDung(String matKhauNhap) {
        return this.matKhau.equals(matKhauNhap);
    }
    
    public boolean isKhoaTaiKhoan() {
        return khoaTaiKhoan;
    }

    public void setKhoaTaiKhoan(boolean accountLocked) {
        this.khoaTaiKhoan = accountLocked;
    }

    // Phương thức gửi mã OTP
    public void guiOTP() {
        Random random = new Random();
        this.otp = String.valueOf(random.nextInt(900000) + 100000);
        this.otpCreationTime = System.currentTimeMillis();
        System.out.println("Mã OTP dùng để xác thực là: " + otp);
    }

    public boolean xacMinhOTP() {
        if (System.currentTimeMillis() - otpCreationTime > 15000) { // 15 giây
            System.out.println("Mã OTP đã hết hạn.");
            return false;
        }
        // Tiếp tục xác minh OTP
        for (int solanthu = 0; solanthu < 2; solanthu++) {
            System.out.print("Vui lòng nhập mã OTP: ");
            String otpNhap = scanner.nextLine();
            if (this.otp.equals(otpNhap))
                return true; 
            System.out.println("Mã OTP không chính xác. Bạn còn " + (2 - solanthu) + " lần thử.");
        }
        return false;
    }
    
    public void themGiaoDich(String giaoDich) {
        lichSuGiaoDich.add(giaoDich);
    }

    public List<String> getLichSuGiaoDich() {
        return lichSuGiaoDich;
    }

}