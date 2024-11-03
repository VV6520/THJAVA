package Baitap_truu_tuong_da_hinh;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachTaiKhoan {
    private ArrayList<TaiKhoanTietKiem> DSTKTietKiem;
    private ArrayList<TaiKhoanThanhToan> DSTKThanhToan;
    Scanner sc = new Scanner(System.in);
    public DanhSachTaiKhoan(ArrayList<TaiKhoanTietKiem> DSTKTietKiem, ArrayList<TaiKhoanThanhToan> DSTKThanhToan) {
        this.DSTKTietKiem = DSTKTietKiem;
        this.DSTKThanhToan = DSTKThanhToan;
    }
    //Thêm tài khoản thanh toán
    public void themTaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, double laiXuat,
                                     double kyHanGui){
        System.out.printf("Nhập số tiền cần gửi tiết kiệm: ");
        double soTien = sc.nextDouble();
        TaiKhoanTietKiem tktk = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, soTien, matKhau, laiXuat, kyHanGui);
        DSTKTietKiem.add(tktk);
        System.out.println("Thêm tài khoản tiết kiệm thành công!");
    }
    //Thêm tài khoản tiết kiệm
    public void themTaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, String matKhau, double phiGiaoDich,
                                      double hanMucThauChi){
        System.out.printf("Nhập số dư ban đầu: ");
        double soDu = sc.nextDouble();
        TaiKhoanThanhToan tktt = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, soDu, matKhau,
                                                        phiGiaoDich, hanMucThauChi);
        DSTKThanhToan.add(tktt);
        System.out.println("Thêm tài khoản thanh toán thành công!");
    }
    //Hiển thị danh sách tài khoản
    public void hienThiDanhSachTaiKhoan(){
        System.out.println("Tài khoản tiết kiệm:");
        for (TaiKhoanTietKiem dstk : DSTKTietKiem){
            System.out.println(dstk.toString());
        }
        System.out.println("Tài khoản thanh toán:");
        for (TaiKhoanThanhToan dstt : DSTKThanhToan){
            System.out.println(dstt.toString());
        }
    }
    //Tìm tài khoản tiêt kiệm theo số tài khoản
    public TaiKhoanTietKiem timTaiKhoanTietKiem(String soTaiKhoan){
        for (TaiKhoanTietKiem tktk : DSTKTietKiem){
            if(tktk.getSoTaiKhoan().equals(soTaiKhoan)){
                return tktk;
            }
        }
        return null;
    }
    //Tìm tài khoản thanh toán theo số tài khoản
    public TaiKhoanThanhToan timTaiKhoanThanhToan(String soTaiKhoan){
        for (TaiKhoanThanhToan tktt: DSTKThanhToan){
            if(tktt.getSoTaiKhoan().equals(soTaiKhoan)){
                return tktt;
            }
        }
        return null;
    }
}
