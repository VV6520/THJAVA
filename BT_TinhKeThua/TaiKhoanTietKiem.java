package BT_TinhKeThua;

import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private boolean kyHan; // true: có kỳ hạn, false: không kỳ hạn
    private int soThangGui; // Số tháng gửi nếu có kỳ hạn
    private int soNgayGui;  // Số ngày gửi nếu không có kỳ hạn

    public TaiKhoanTietKiem() {
    }

    // Phương thức nhập thông tin tài khoản
    @Override
    public void Nhap() {
        super.Nhap(); // Gọi phương thức Nhap() của lớp cha
    }    
    
    public void laiSuat(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập lãi suất: ");
        this.laiSuat = scanner.nextDouble();
    }

    public void thietLapKyHan() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Có kỳ hạn không? (Y/N): ");
        String choice = scanner.nextLine();
        this.kyHan = choice.equalsIgnoreCase("Y");

        if (kyHan) {
            System.out.print("Nhập số tháng gửi: ");
            this.soThangGui = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.print("Nhập số ngày thực gửi: ");
            this.soNgayGui = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public double tinhLai() {
        if (kyHan) {
            return getSoDu() * (laiSuat / 12) * soThangGui / 100;
        } else {
            return getSoDu() * laiSuat * soNgayGui / 365 / 100;
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
                            super.rutTien(soTienLai); // Gọi phương thức rút tiền từ lớp cha
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
                            super.rutTien(soTienLai); // Gọi phương thức rút tiền từ lớp cha
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
        Scanner scanner = new Scanner(System.in);

        if (kyHan) {
            // Tài khoản có kỳ hạn
            System.out.println("Tài khoản gửi còn trong kỳ hạn. Bạn chỉ có thể rút tiền gốc.");
            System.out.print("Bạn có muốn rút tiền gốc không? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                if (soTien > 0 && soTien <= getSoDu()) {
                    int testt = 0;
                    while (testt < 2) {
                        System.out.print("Nhập mật khẩu: ");
                        String matKhauNhap = scanner.nextLine();

                        if (isMatKhauDung(matKhauNhap)) {
                            // Nếu mật khẩu đúng, gửi OTP
                            guiOTP(); // Gửi mã OTP
                            if (xacMinhOTP()) {
                                // Nếu OTP xác thực thành công, thực hiện rút tiền
                                super.rutTien(soTien); // Gọi phương thức rút tiền từ lớp cha
                                System.out.println("Đã rút " + soTien + " VND.");
                            } else {
                                System.out.println("Xác thực OTP không thành công. Không thể rút tiền.");
                            }
                            return; // Kết thúc phương thức
                        } else {
                            testt++;
                            System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - testt) + " lần thử.");
                        }
                    }
                    System.out.println("Không thể thực hiện thao tác rút tiền do nhập sai mật khẩu quá nhiều lần.");
                } else {
                    System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
                }
            } else {
                System.out.println("Bạn đã chọn tiếp tục duy trì kỳ hạn.");
            }
        } else {
            // Nếu không có kỳ hạn, cho phép rút tiền
            int numtest = 0;
            while (numtest < 2) {
                System.out.print("Nhập mật khẩu: ");
                String matKhauNhap = scanner.nextLine();

                if (isMatKhauDung(matKhauNhap)) {
                    // Gửi OTP trước khi rút tiền
                    guiOTP(); // Gửi mã OTP
                    if (xacMinhOTP()) {
                        // Nếu OTP xác thực thành công, thực hiện rút tiền
                        if (soTien > 0 && soTien <= getSoDu()) {
                            super.rutTien(soTien); // Gọi phương thức rút tiền từ lớp cha
                            System.out.println("Đã rút " + soTien + " VND.");
                        } else {
                            System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
                        }
                    } else {
                        System.out.println("Xác thực OTP không thành công. Không thể rút tiền.");
                    }
                    return; // Kết thúc phương thức
                } else {
                    numtest++;
                    System.out.println("Mật khẩu không đúng. Bạn còn " + (2 - numtest) + " lần thử.");
                }
            }
            System.out.println("Không thể thực hiện thao tác rút tiền do nhập sai mật khẩu quá nhiều lần.");
        }
    }

    public void xemThongTinTaiKhoan() {
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

    public void guiTien(double soTien) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mật khẩu để xác thực: ");
        String matKhau = scanner.nextLine();
        super.guiTien(soTien, matKhau); // Gọi phương thức guiTien từ lớp cha
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

    @Override
    public void xemLichSuGiaoDich() {
        super.xemLichSuGiaoDich(); // Gọi phương thức từ lớp cha
    }
}