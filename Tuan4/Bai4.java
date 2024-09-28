import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap mot so nguyen: ");
        int n = scanner.nextInt();
        boolean KTS = n > 1;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                KTS = false;
                break;
            }
        if (KTS)
            System.out.println(n + " la so nguyen to.");
        else
            System.out.println(n + " khong phai la so nguyen to.");
    }
}
