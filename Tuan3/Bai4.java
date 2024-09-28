import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so a: ");
        int a = sc.nextInt();
        System.out.print("Nhap so b: ");
        int b = sc.nextInt();
        System.out.print("Nhap so c: ");
        int c = sc.nextInt();
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        System.out.println("So nho nhat là: " + min);
        sc.close();
    }
}
