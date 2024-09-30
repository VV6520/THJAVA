import java.util.Scanner;

public class Bai6_T3 {
    public static void main(String[] args) {
        double a, b;
        char s;
        System.out.printf("Nhap vao a: ");
        a = new Scanner(System.in).nextDouble();
        System.out.printf("Nhap vao b: ");
        b = new Scanner(System.in).nextDouble();
        System.out.printf("Nhap vao phep tinh (+, -, *, /): ");
        s = new Scanner(System.in).nextLine().charAt(0);
        switch (s){
            case '+':
                System.out.println("a+b= "+(a+b));
                break;
            case '-':
                System.out.println("a-b= "+(a-b));
                break;
            case '*':
                System.out.println("a*b= "+(a*b));
                break;
            case '/':
                if(b==0)
                    System.out.println("Lỗi phép tính");
                else
                    System.out.println("a/b= "+(a/b));
                break;
            default:
                System.out.println("Không nhân diện được phép tính");
        }
    }
}
