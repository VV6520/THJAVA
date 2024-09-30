import java.util.Scanner;

public class Kiemtraso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số: ");
        float num = scanner.nextFloat();

        if (num > 0) {
            System.out.println("Số dương");
        } else if (num < 0) {
            System.out.println("Số âm");
        } else {
            System.out.println("Bằng 0");
        }
    }
}