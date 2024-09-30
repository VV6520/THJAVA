import java.util.Scanner;

public class FindMinimum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhập số b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhập số c: ");
        float c = scanner.nextFloat();

        float min = Math.min(a, Math.min(b, c));
        System.out.println("Số nhỏ nhất là: " + min);
    }
}