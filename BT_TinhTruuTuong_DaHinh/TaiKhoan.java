package BT_TinhTruuTuong_DaHinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    protected String matKhau;
    protected String cccd;
    private int soLanNhapSai; // Biến lưu số lần nhập sai
    private boolean khoaTaiKhoan; // Biến trạng thái khóa tài khoản
    private long thoiGianKhoa; // Thời gian tài khoản bị khóa
    private static final int MAX_NHAP = 3; // Số lần nhập tối đa cho mật khẩu
    private static final long maxTimeLock = 20000; // Thời gian khóa tài khoản (20 giây)
    protected String otp; // Biến lưu mã OTP
    protected List<String> xemlichSuGiaoDich = new ArrayList<>();

    public TaiKhoan() {}

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số tài khoản: ");
        this.soTaiKhoan = scanner.nextLine();

        System.out.print("Nhập chủ tài khoản: ");
        this.chuTaiKhoan = scanner.nextLine();

        System.out.print("Nhập số dư: ");
        this.soDu = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng mới

        System.out.print("Nhập số CCCD: ");
        this.cccd = scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("Số tài khoản: " + getsoTaiKhoan());
        System.out.println("Chủ tài khoản: " + getchuTaiKhoan());
        System.out.println("Số dư: " + getSoDu());
        System.out.println("Số CCCD: " + getcccd());
    }
    
    public boolean DangKy() {
        Nhap(); // Nhập thông tin tài khoản

        Scanner scanner = new Scanner(System.in);
        String matKhauMoi;

        System.out.println("Bạn muốn tạo mật khẩu (1: Bình thường, 2: Cấp cao)?");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            matKhauMoi = scanner.nextLine();

            if ((luaChon == 1 && !KiemTraMatKhau(matKhauMoi)) ||
                (luaChon == 2 && !KiemTraMatKhauCC(matKhauMoi))) {
                System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại.");
            } else {
                this.matKhau = matKhauMoi;
                break; // Thoát vòng lặp nếu mật khẩu hợp lệ
            }
        }

        // Gửi OTP và xác minh
        if (!thietLapMatKhauVaXacThucOTP()) {
            System.out.println("Đăng ký thất bại do xác thực OTP không thành công.");
            return false;
        }

        System.out.println("Đăng ký thành công!");
        return true; // Trả về true nếu đăng ký thành công
    }

    public boolean KiemTraMatKhau(String matKhau) {
        if (matKhau.length() < 8) {
            System.out.println("Mật khẩu phải có ít nhất 8 ký tự.");
            return false; // Không hợp lệ nếu độ dài dưới 8 ký tự
        }
        return true; // Hợp lệ nếu độ dài đủ
    }

    private boolean thietLapMatKhauVaXacThucOTP() {
        guiOTP(); // Gửi mã OTP
        return xacMinhOTP(); // Xác thực mã OTP
    }

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

    public boolean DangNhap() {
        if (khoaTaiKhoan) {
            if (System.currentTimeMillis() - thoiGianKhoa < maxTimeLock) {
                System.out.println("Tài khoản đang bị khóa. Vui lòng thử lại sau.");
                return false;
            } else {
                khoaTaiKhoan = false; // Mở khóa tài khoản nếu thời gian đã hết
                soLanNhapSai = 0; // Đặt lại số lần nhập sai
            }
        }
        return kiemTraMatKhau(new Scanner(System.in), MAX_NHAP); // Sử dụng số lần nhập tối đa
    }

    private boolean kiemTraMatKhau(Scanner scanner, int limitpass) {
        for (int test = 0; test < limitpass; test++) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.nextLine();
            if (this.matKhau.equals(matKhauNhap)) {
                return true;
            }
            System.out.println("Mật khẩu không đúng. Bạn còn " + (limitpass - test - 1) + " lần thử.");
        }
        return false;
    }

    public void QuenMatKhau() {
        Scanner scanner = new Scanner(System.in);
        int thu = 0;

        while (thu < MAX_NHAP) {
            System.out.print("Nhập mật khẩu cũ: ");
            String matKhauCu = scanner.nextLine();

            if (!this.matKhau.equals(matKhauCu)) {
                System.out.println("Mật khẩu cũ không chính xác.");
                thu++;
                // Kiểm tra số lần nhập sai
                if (thu >= 2) {
                    khoaTaiKhoan = true; // Khóa tài khoản
                    thoiGianKhoa = System.currentTimeMillis(); // Ghi lại thời gian khóa
                    System.out.println("Tài khoản đã bị tạm khóa trong 20 giây do nhập sai mật khẩu quá nhiều lần.");
                    return; // Kết thúc phương thức
                }
                continue;
            }

            // Nếu mật khẩu cũ đúng, reset số lần nhập sai
            thu = 0;

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
                    } else {
                        System.out.println("Xác thực OTP không thành công. Đổi mật khẩu thất bại.");
                        return; // Kết thúc nếu xác minh OTP không thành công
                    }
                } else {
                    System.out.println("Lựa chọn thay đổi mật khẩu không hợp lệ. Mời bạn thử lại sau.");
                    thuMoi++;
                }
            }
            System.out.println("Bạn đã lựa chọn đổi mật khẩu mới quá nhiều lần!");
            return; // Kết thúc phương thức
        }
        System.out.println("Quá nhiều lần thử!");
    }

    public void guiTien(double soTien, String matKhau) {
        if (isMatKhauDung(matKhau)) {
            if (soTien > 0) {
                soDu += soTien;
                xemlichSuGiaoDich.add("Gửi tiền: " + soTien + " VNĐ"); // Lưu giao dịch
                System.out.println("Đã gửi: " + soTien + ". Số dư hiện tại: " + soDu);
            } else {
                System.out.println("Số tiền gửi phải lớn hơn 0.");
            }
        } else {
            System.out.println("Mật khẩu không đúng. Không thể thực hiện thao tác gửi tiền.");
        }
    }

    public void rutTien(double soTienRut) {
        // Kiểm tra số tiền rút hợp lệ
        if (soTienRut <= 0 || soTienRut > soDu) {
            System.out.println("Không đủ số dư hoặc số tiền rút không hợp lệ.");
            return;
        }

        // Nhập mật khẩu
        Scanner scanner = new Scanner(System.in);
        int sothu = 0;
        while (sothu < 2) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.nextLine();

            if (isMatKhauDung(matKhauNhap)) {
                guiOTP(); // Gửi mã OTP
                if (xacMinhOTP()) {
                    soDu -= soTienRut;
                    xemlichSuGiaoDich.add("Rút tiền: " + soTienRut + " VNĐ"); // Lưu giao dịch
                    System.out.println("Đã rút: " + soTienRut + ". Số dư hiện tại: " + soDu);
                } else {
                    System.out.println("Xác thực OTP không thành công. Không thể rút tiền.");
                }
                return; // Kết thúc phương thức sau khi thực hiện rút tiền
            } else {
                sothu++;
                System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - sothu) + " lần thử.");
            }
        }
        System.out.println("Không thể thực hiện thao tác rút tiền do nhập sai mật khẩu quá nhiều lần.");
    }
    
    public void xemLichSuGiaoDich() {
        System.out.println("Lịch sử giao dịch:");
        for (String giaoDich : xemlichSuGiaoDich) {
            System.out.println(giaoDich);
        }
    }

    public double kiemTraSoDu(String matKhau) {
        if (!isMatKhauDung(matKhau)) {
            System.out.println("Mật khẩu không đúng. Không thể kiểm tra số dư.");
            return -1;
        }
        return soDu;
    }

    public boolean isMatKhauDung(String matKhauNhap) {
        return this.matKhau.equals(matKhauNhap);
    }

    public double getSoDu() {
        return soDu;
    }

    protected String getMatKhau() {
        return matKhau;
    }
    
    public String getchuTaiKhoan() {
        return chuTaiKhoan;
    }

    public String getsoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setsoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }
    
    protected String getcccd() {
        return cccd;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public void setsoDu(double soDu) {
        this.soDu = soDu;
    }

    public void setcccd(String cccd) {
        this.cccd = cccd;
    }
    
    public boolean isKhoaTaiKhoan() {
        return khoaTaiKhoan;
    }

    public void setKhoaTaiKhoan(boolean accountLocked) {
        this.khoaTaiKhoan = accountLocked;
    }
    

    protected void guiOTP() {
        Random random = new Random();
        this.otp = String.valueOf(random.nextInt(900000) + 100000); // Tạo OTP 6 chữ số
        System.out.println("Mã OTP dùng để xác thực là: " + otp); // Giả lập gửi OTP
    }

    protected boolean xacMinhOTP() {
        Scanner scanner = new Scanner(System.in);
        int solanthu = 0; // Biến lưu số lần thử nhập mã OTP

        while (solanthu < 2) { // Cho phép nhập lại tối đa 2 lần
            System.out.print("Vui lòng nhập mã OTP: ");
            String otpNhap = scanner.nextLine();
            if (this.otp.equals(otpNhap)) {
                return true; // Xác thực thành công
            } else {
                solanthu++;
                System.out.println("Mã OTP không chính xác. Bạn còn " + (2 - solanthu) + " lần thử.");
            }
        }
        return false;
    }

    public List<String> getxemlichSuGiaoDich() {
        return xemlichSuGiaoDich; // Trả về danh sách lịch sử giao dịch
    }
    
}