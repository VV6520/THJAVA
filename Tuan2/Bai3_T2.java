import java.util.Scanner;

public class Bai3_T2 {
    public static void main(String[] args) {
        //Nhập dữ liệu
        System.out.printf("Nhap vao so nguyen a = ");
        int a = new Scanner(System.in).nextInt();
        System.out.printf("Nhap vao so nguyen b = ");
        int b = new Scanner(System.in).nextInt();
        //Thực hiện phép tính
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        double thuong = (double) a/b;
        int du = a % b;
        //Xuất ra màn hình
        System.out.println("Tong a+b = " +tong);
        System.out.println("Hieu a-b = " +hieu);
        System.out.println("Tich a*b = " +tich);
        System.out.println("Thuong a/b = " +thuong);
        System.out.println("Chia lay du a%b = " +du);
    }
}