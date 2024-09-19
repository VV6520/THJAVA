import java.util.Scanner;

public class baitapnhom_3 {
    public static void main(String[] args) {
        //Nhập dữ liệu
        System.out.printf("Nhập vào số nguyên a = ");
        int a = new Scanner(System.in).nextInt();
        System.out.printf("Nhập vào số nguyên b = ");
        int b = new Scanner(System.in).nextInt();
        //Thực hiện phép tính
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        double thuong = (double) a/b;
        int du = a % b;
        //Xuất ra màn hình
        System.out.println("Tổng a+b = " +tong);
        System.out.println("Hiệu a-b = " +hieu);
        System.out.println("Tích a*b = " +tich);
        System.out.println("Thương a/b = " +thuong);
        System.out.println("Chia lây dư a%b = " +du);
    }
}
