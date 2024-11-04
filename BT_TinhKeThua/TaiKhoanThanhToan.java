package BT_TinhKeThua;

import java.util.ArrayList;
import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
    private String loaiThanhToan; // Thuộc tính loại tài khoản
    private double phiDichVu;

    public TaiKhoanThanhToan() {
    }
    
    @Override
    public void Nhap() {
        super.Nhap(); // Gọi phương thức Nhap() của lớp cha
    }  
        
    public void thongTinTT(){    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập loại thanh toán : ");
        this.loaiThanhToan = scanner.nextLine();
        scanner.nextLine(); // Đọc dòng mới
        System.out.print("Nhập phí dịch vụ: ");
        this.phiDichVu = scanner.nextDouble();

    }

    @Override
    public void Xuat() {
        super.Xuat(); // Gọi phương thức Xuat() của lớp cha
        System.out.println("Loại thanh toán: " + this.loaiThanhToan);
        System.out.println("Phí dịch vụ: " + this.phiDichVu);
    }

    @Override
    public void guiTien(double soTien, String matKhau) {
        Scanner scanner = new Scanner(System.in);

        // Kiểm tra tính hợp lệ của số tiền gửi
        if (soTien <= 0) {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
            return;
        }

        // Nhập mật khẩu
        System.out.print("Nhập mật khẩu: ");
        String matKhauNhap = scanner.nextLine();

        if (isMatKhauDung(matKhauNhap)) {
            guiOTP(); // Gửi mã OTP
            if (xacMinhOTP()) {
                soDu += soTien;
                System.out.println("Đã gửi: " + soTien + ". Số dư hiện tại: " + soDu);
                xemlichSuGiaoDich.add("Gửi tiền: " + soTien + " VND"); // Lưu lịch sử giao dịch
            } else {
                System.out.println("Xác thực OTP không thành công. Không thể gửi tiền.");
            }
        } else {
            System.out.println("Mật khẩu không đúng. Không thể thực hiện thao tác gửi tiền.");
        }
    }

    public void rutTien(double soTien, String matKhau) {
        Scanner scanner = new Scanner(System.in);

        if (isMatKhauDung(matKhau)) {
            double thauChiLimit = getSoDu() + 1000000; // Hạn mức thấu chi

            if (soTien > 0 && soTien <= thauChiLimit) {
                if (soTien > getSoDu()) {
                    double phiPhatSinh = 30000; // Phí thấu chi
                    System.out.println("Bạn đang sử dụng thấu chi. Bạn sẽ phải trả " + phiPhatSinh + " VND.");
                }

                guiOTP(); 
                if (xacMinhOTP()) { 
                    super.rutTien(soTien); // Gọi phương thức rút tiền từ lớp cha
                    xemlichSuGiaoDich.add("Rút tiền: " + soTien + " VND"); // Ghi lại lịch sử giao dịch
                } else {
                    System.out.println("Xác thực OTP không thành công. Không thể rút tiền.");
                }
            } else {
                System.out.println("Số tiền rút không hợp lệ hoặc vượt quá hạn mức thấu chi.");
            }
        } else {
            System.out.println("Mật khẩu không đúng. Không thể thực hiện thao tác rút tiền.");
        }
    }

    public void chuyenTien(double soTien, String soTaiKhoanNhan, ArrayList<TaiKhoan> danhSachTaiKhoan) {
        if (soTien > 0 && soTien <= getSoDu()) {
            for (TaiKhoan tk : danhSachTaiKhoan) {
                if (tk.getSoTaiKhoan().equals(soTaiKhoanNhan)) {
                    guiOTP(); 
                    if (xacMinhOTP()) { 
                        this.rutTien(soTien, this.getMatKhau());
                        tk.guiTien(soTien, tk.getMatKhau());
                        xemlichSuGiaoDich.add("Chuyển tiền: " + soTien + " VND tới tài khoản " + soTaiKhoanNhan);
                        System.out.println("Chuyển tiền thành công!");
                        return;
                    } else {
                        System.out.println("Xác thực OTP không thành công. Không thể chuyển tiền.");
                        return;
                    }
                }
            }
            System.out.println("Số tài khoản nhận không tồn tại.");
        } else {
            System.out.println("Số tiền chuyển không hợp lệ hoặc vượt quá số dư.");
        }
    }

    public void thanhToanPhiDichVu(double phiDichVu) {
        if (phiDichVu > 0 && phiDichVu <= getSoDu()) {
            guiOTP(); 
            if (xacMinhOTP()) { 
                rutTien(phiDichVu, getMatKhau()); 
                xemlichSuGiaoDich.add("Thanh toán phí dịch vụ: " + phiDichVu + " VND");
                System.out.println("Thanh toán phí dịch vụ thành công. Số dư hiện tại: " + getSoDu());
            } else {
                System.out.println("Xác thực OTP không thành công. Không thể thanh toán phí dịch vụ.");
            }
        } else {
            System.out.println("Không đủ số dư để thanh toán phí dịch vụ.");
        }
    }

    public void napCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền muốn nạp card: ");
        double soTienNapCard = scanner.nextDouble();

        if (soTienNapCard > 0) {
            guiOTP(); 
            if (xacMinhOTP()) { 
                soDu += soTienNapCard; 
                xemlichSuGiaoDich.add("Nạp card: " + soTienNapCard + " VND");
                System.out.println("Nạp card thành công. Số tiền nạp: " + soTienNapCard + " VND");
                System.out.println("Số dư hiện tại: " + getSoDu());
            } else {
                System.out.println("Xác thực OTP không thành công. Không thể nạp card.");
            }
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void thanhToanHoaDon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền hóa đơn: ");
        double soTienHoaDon = scanner.nextDouble();

        if (soTienHoaDon > 0 && soTienHoaDon <= getSoDu()) {
            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.next(); 
            if (isMatKhauDung(matKhauNhap)) { 
                guiOTP(); 
                if (xacMinhOTP()) { 
                    rutTien(soTienHoaDon); 
                    xemlichSuGiaoDich.add("Thanh toán hóa đơn: " + soTienHoaDon + " VND");
                    System.out.println("Thanh toán hóa đơn thành công. Số dư hiện tại: " + getSoDu());
                } else {
                    System.out.println("Xác thực OTP không thành công. Không thể thanh toán hóa đơn.");
                }
            } else {
                System.out.println("Mật khẩu không đúng. Không thể thực hiện thanh toán.");
            }
        } else {
            System.out.println("Số tiền thanh toán không hợp lệ hoặc vượt quá số dư.");
        }
    }

    public void xemThongTinTaiKhoan() {
        super.Xuat(); // Gọi phương thức Xuat từ lớp cha
        System.out.println("Thông tin tài khoản thanh toán:");
        System.out.println("Loại thanh toán: " + this.loaiThanhToan);
        System.out.println("Phí dịch vụ: " + this.phiDichVu);
        System.out.println("Số dư hiện tại: " + getSoDu() + " VND");
    }

    @Override
    public void xemLichSuGiaoDich() {
        super.xemLichSuGiaoDich(); // Gọi phương thức từ lớp cha
    }

    // Getter và Setter
    public String getloaiThanhToan() {
        return loaiThanhToan;
    }

    public void setloaiThanhToan(String loaiTaiKhoan) {
        this.loaiThanhToan = loaiThanhToan;
    }

    public double getPhiDichVu() {
        return phiDichVu;
    }

    public void setPhiDichVu(double phiDichVu) {
        this.phiDichVu = phiDichVu;
    }
}