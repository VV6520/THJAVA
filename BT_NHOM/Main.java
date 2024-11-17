package BT_NHOM;

import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {
	        QuanLyDanhBa qldb = new QuanLyDanhBa();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        try {
	        	do {
	                System.out.println("\nQuản Lý Danh Bạ");
	                System.out.println("1. Thêm liên hệ cá nhân");
	                System.out.println("2. Thêm liên hệ công ty");
	                System.out.println("3. Hiển thị danh bạ");
	                System.out.println("4. Tìm kiếm liên hệ");
	                System.out.println("5. Cập nhật liên hệ");
	                System.out.println("6. Xóa liên hệ");
	                System.out.println("7. Sắp xếp danh bạ theo tên");
	                System.out.println("0. Thoát");
	                System.out.print("Chọn chức năng: ");
	                choice = scanner.nextInt();
	                scanner.nextLine();

	                switch (choice) {
	                    case 1 -> qldb.themLienHe(new LienHeCaNhan(null, null, null, null, null));
	                    case 2 -> qldb.themLienHe(new LienHeCongTy(null, null, null, null, null));
	                    case 3 -> qldb.hienThiDanhBa();
	                    case 4 -> {
	                        System.out.print("Nhập tên liên hệ hoặc số cần tìm kiếm: ");
	                        qldb.timKiemLienHe(scanner.nextLine());
	                    }
	                    case 5 -> {
	                        System.out.print("Nhập mã liên hệ cần cập nhật: ");
	                        qldb.capNhatLienHe(scanner.nextLine());
	                    }
	                    case 6 -> {
	                        System.out.print("Nhập mã liên hệ cần xóa: ");
	                        qldb.xoaLienHe(scanner.nextLine());
	                    }
	                    case 7 -> qldb.sapXepTheoTen();
	                    case 0 -> System.out.println("Thoát chương trình.");
	                    default -> System.out.println("Lựa chọn không hợp lệ!");
	                }
	            } while (choice != 0);
			} catch (Exception e) {
				System.out.println("Dữ liệu bạn nhập vào không hợp lệ !!  "+e.getMessage());
				scanner.nextLine();
			}
	    }
}
