package Baitap_truu_tuong_da_hinh;

import java.util.ArrayList;
import java.util.Scanner;

public class test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TaiKhoanTietKiem> danhSachTietKiem = new ArrayList<>();
        ArrayList<TaiKhoanThanhToan> danhSachThanhToan = new ArrayList<>();
        DanhSachTaiKhoan danhSachTaiKhoan= new DanhSachTaiKhoan(danhSachTietKiem, danhSachThanhToan);
        System.out.printf("Nhập vào chủ tài khoản: ");
        String chuTaiKhoan = sc.nextLine();
        System.out.printf("Nhập vào mật khẩu: ");
        String matKhau = sc.nextLine();
        while (true){
           System.out.println("-----Menu-----");
           System.out.println("1. Thêm tài khoản tiết kiệm" +
                            "\n2. Thêm tài khoản thanh toán" +
                            "\n3. Chọn tài khoản để sử dụng" +
                            "\n4. Hiển thị danh sách tài khoản"+
                            "\n0. Thoát");
           int chon = 1;
           try{
               System.out.printf("Nhập vào lựa chọn: ");
               chon = sc.nextInt();
               sc.nextLine();
           }catch (Exception e){
               System.out.println("Nhập dữ liệu không đúng!. Mặc định chọn chức năng 1");
           }
           sc.nextLine();
           switch(chon){
               case 1:
                   System.out.printf("Nhập vào mã số tài khoản tiết kiệm: ");
                   String soTaiKhoanTK = sc.nextLine();
                   System.out.printf("Nhập vào lãi xuất: ");
                   double laiXuat = sc.nextDouble();
                   System.out.printf("Nhập vào kỳ hạn gửi(ngày): ");
                   double kyHanGui = sc.nextDouble();
                   danhSachTaiKhoan.themTaiKhoanTietKiem(soTaiKhoanTK, chuTaiKhoan, matKhau, laiXuat, kyHanGui);
                   break;
               case 2:
                   System.out.printf("Nhập vào mã số tài khoản thanh toán: ");
                   String soTaiKhoanTT = sc.nextLine();
                   System.out.printf("Nhập vào phí giao dịch: ");
                   double phiGiaoDich = sc.nextDouble();
                   System.out.printf("Nhập vào hạn mức giao dịch: ");
                   double hanMucThauChi = sc.nextDouble();
                   danhSachTaiKhoan.themTaiKhoanThanhToan(soTaiKhoanTT, chuTaiKhoan, matKhau, phiGiaoDich,
                           hanMucThauChi);
                   break;
               case 3:
                   System.out.printf("Nhập tài khoản muốn sử dụng:");
                   String soTaiKhoan = sc.nextLine();
                   TaiKhoanTietKiem tktk = danhSachTaiKhoan.timTaiKhoanTietKiem(soTaiKhoan);
                   TaiKhoanThanhToan tktt = danhSachTaiKhoan.timTaiKhoanThanhToan(soTaiKhoan);
                   if(tktk != null){
                       int chonTietKiem = 1;
                       do{
                           System.out.println("---Tài khoản tiết kiệm---");
                           System.out.println("-----MENU-----");
                           System.out.println("1. Gửi tiền"+
                                             "\n2. Tính tiền lãi"+
                                             "\n3. Rút tiền"+
                                             "\n4. Kiểm tra tiền tiết kiệm"+
                                             "\n0. Thoát");
                           try{
                               System.out.printf("Nhập vào lựa chọn: ");
                               chonTietKiem = sc.nextInt();
                               sc.nextLine();
                           }catch(Exception e){
                               System.out.println("Nhập dữ liệu không đúng!. Mặc định chọn chức năng 1");
                           }
                           sc.nextLine();
                           switch (chonTietKiem){
                               case 1:
                                   System.out.printf("Nhập mật khẩu xác nhận: ");
                                   String xacNhanMK = sc.nextLine();
                                   System.out.printf("Nhập số tiền cần gửi: ");
                                   double tienGui = sc.nextDouble();
                                   tktk.guiTien(tienGui, xacNhanMK);
                                   break;
                               case 2:
                                   tktk.tienLai(tktk.getMatKhau());
                                   break;
                               case 3:
                                   System.out.printf("Nhập mật khẩu xác nhận: ");
                                   xacNhanMK = sc.nextLine();
                                   tktk.rutTien(xacNhanMK);
                                   break;
                               case 4:
                                   System.out.println("Số tiền tiết kiệm: "+tktk.getSoDu());
                               default:
                                   System.out.println("Chức năng không hợp lệ!");
                           }
                       }while(chonTietKiem != 0);
                   }else if(tktt != null){
                       int chonThanhToan = 1;
                       do{
                           System.out.println("---Tài khoản thanh toán---");
                           System.out.println("-----MENU-----");
                           System.out.println("1. Gửi tiền"+
                                            "\n2. Rút tiền"+
                                            "\n3. Kiểm tra số dư"+
                                            "\n0. Thoát");
                           try{
                               System.out.printf("Nhập vào lựa chọn: ");
                               chonThanhToan = sc.nextInt();
                               sc.nextLine();
                           }catch(Exception e){
                               System.out.println("Nhập dữ liệu không đúng!. Mặc định chọn chức năng 1");
                           }
                           sc.nextLine();
                           switch(chonThanhToan){
                               case 1:
                                   System.out.printf("Nhập mật khẩu xác nhận: ");
                                   String xacNhanMK = sc.nextLine();
                                   System.out.printf("Nhập số tiền cần gửi: ");
                                   double tienGui = sc.nextDouble();
                                   tktt.guiTien(tienGui, xacNhanMK);
                                   break;
                               case 2:
                                   System.out.printf("Nhập mật khẩu xác nhận: ");
                                   xacNhanMK = sc.nextLine();
                                   tktt.rutTien(xacNhanMK);
                                   break;
                               case 3:
                                   System.out.printf("Số dư hiện tại: "+tktt.getSoDu());
                           }
                       }while(chonThanhToan != 0);
                   }else{
                       System.out.println("Không tìm thấy tài khoản!");
                   }
               break;
               case 4:
                   danhSachTaiKhoan.hienThiDanhSachTaiKhoan();
                   break;
               case 5:
                   System.out.println("Thoát chương trình: ");
                   sc.close();
               default:
                   System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
           }
       }
    }
}

