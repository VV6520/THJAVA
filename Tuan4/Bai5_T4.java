import java.util.Scanner;

public class Bai5_T4 {
    // Hàm tính UCLN sử dụng thuật toán Euclid
    public static int UCLN(int a, int b) {
        if (b == 0)
            return a; // Nếu b = 0, trả về a
        return UCLN(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen a: ");
        int a = scanner.nextInt();
        System.out.print("Nhap vao so nguyen b: ");
        int b = scanner.nextInt();
        scanner.close();
        if (a == 0 && b == 0)
            System.out.println("Khong co UCLN va BCNN.");
        else
            if (a == 0 || b == 0) {
                System.out.println("Khong co BCNN.");
                System.out.println("UCLN giua " +a+ " và " +b+ " là " + ((a == 0) ? b : a));
            } 
            else {
                int ucln = UCLN(a, b);
                System.out.println("UCLN giua " + a + " va " +b+ " la: " + ucln);
                int bc = a*b;
                float bcnn = (float) bc / ucln;
                System.out.println("BCNN giua " +a+ " va " +b+ " la: " + bcnn);
            }
    }
}
