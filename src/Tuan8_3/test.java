package Tuan8_3;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //Sach
        System.out.println("Nhập vào mã tài liệu: ");
        String ma = new Scanner(System.in).nextLine();
        System.out.println("Nhập vào tên tài liệu: ");
        String ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập vào năm xuất bản: ");
        int nam = new Scanner(System.in).nextInt();
        Sach sach = new Sach(ma, ten, nam);
        System.out.println(""+sach.toString());
        sach.soTrang(100);
        sach.theLoai("Truyện dài");
    }
}
