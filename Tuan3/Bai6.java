import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        float a = scanner.nextFloat();
        System.out.print("Nhập số b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhập phép toán (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        float result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("Không thể chia cho 0");
                    return;
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ");
                return;
        }
        System.out.println("Kết quả: " + result);
    }
}