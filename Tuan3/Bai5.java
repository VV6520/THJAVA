import java.util.Scanner;
public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap canh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap canh c: ");
        double c = scanner.nextDouble();
        scanner.close();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Co the tao thanh tam giac.");
            if (a == b && b == c)
                System.out.println("Ba canh tao thanh tam giac deu");
            else 
                if (a == b || a == c || b == c)
                    System.out.println("Ba canh tao thanh tam giac can");
                else
                    if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a)
                        System.out.println("Ba canh tao thanh tam giac vuong");
                    else
                        System.out.println("Ba canh tao thanh tam giac thuong");
        }
        else
            System.out.println("Khong the tao thanh tam giac.");
    }
}
