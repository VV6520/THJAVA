import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hệ số a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhập hệ số b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhập hệ số c: ");
        float c = scanner.nextFloat();

        float delta = b * b - 4 * a * c;

        if (delta > 0) {
            float x1 = (-b + Math.sqrt(delta)) / (2 * a);
            float x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Có hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            float x = -b / (2 * a);
            System.out.println("Có nghiệm kép: x = " + x);
        } else {
            System.out.println("Không có nghiệm thực");
        }
    }
}