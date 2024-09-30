import java.util.Scanner;

public class StudentClassification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm trung bình: ");
        float score = scanner.nextFloat();

        if (score >=  {
            System.out.println("Giỏi");
        } else if (score >= 6.5) {
            System.out.println("Khá");
        } else if (score >= 5) {
            System.out.println("Trung bình");
        } else {
            System.out.println("Yếu");
        }
    }
}