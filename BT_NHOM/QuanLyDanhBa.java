package BT_NHOM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class QuanLyDanhBa {
	 private ArrayList<LienHe> danhBa = new ArrayList<>();
	    public void themLienHe(LienHe lienHe) {
	        lienHe.nhapThongTin();
	        danhBa.add(lienHe);
	    }
	    public void hienThiDanhBa() {
	        if (danhBa.isEmpty()) {
	            System.out.println("Danh bạ trống.");
	            return;
	        }
	        for (LienHe lienHe : danhBa) {
	            lienHe.hienThiThongTin();
	            System.out.println("-------------------");
	        }
	    }
	    public void timKiemLienHe(String variable) {
	        boolean found = false;
	        for (LienHe lienHe : danhBa) {
	            if (lienHe.hoTen.equalsIgnoreCase(variable) || lienHe.soDienThoai.equalsIgnoreCase(variable)) {
	                lienHe.hienThiThongTin();
	                found = true;
	            }
	        }
	        if (!found) System.out.println("Không tìm thấy liên hệ.");
	    }
	    public void capNhatLienHe(String maLienHe) {
	        for (LienHe lienHe : danhBa) {
	            if (lienHe.maLienHe.equalsIgnoreCase(maLienHe)) {
	                System.out.println("Cập nhật thông tin:");
	                lienHe.nhapThongTin();
	                return;
	            }
	        }
	        System.out.println("Không tìm thấy mã liên hệ.");
	    }

	    public void xoaLienHe(String maLienHe) {
	        Iterator<LienHe> iterator = danhBa.iterator();
	        while (iterator.hasNext()) {
	            LienHe lienHe = iterator.next();
	            if (lienHe.maLienHe.equalsIgnoreCase(maLienHe)) {
	                iterator.remove();
	                System.out.println("Đã xóa liên hệ.");
	                return;
	            }
	        }
	        System.out.println("Không tìm thấy mã liên hệ.");
	    }
	    public void sapXepTheoTen() {
	        danhBa.sort(Comparator.comparing(lh -> lh.hoTen.toLowerCase()));
	        System.out.println("Đã sắp xếp danh bạ theo tên.");
	        hienThiDanhBa();
	    }
}
