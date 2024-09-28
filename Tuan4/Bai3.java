import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap mot so nguyen duong: ");
        int n = scanner.nextInt();
        long giaithua = 1;

        for (int i = 1; i <= n; i++)
            giaithua *= i;
        
            System.out.println("Giai thua cua " + n + " la: " + giaithua);
    }
}
