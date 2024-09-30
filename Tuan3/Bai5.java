import java.util.Scanner;

public class TriangleType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cạnh a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhập cạnh b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhập cạnh c: ");
        float c = scanner.nextFloat();

        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } else if (a == b || b == c || a == c) {
                System.out.println("Tam giác cân");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Tam giác vuông");
            } else {
                System.out.println("Tam giác thường");
            }
        } else {
            System.out.println("Không phải là tam giác");
        }
    }
}