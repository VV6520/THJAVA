import java.util.Scanner;

public class Bai2_T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Moi nhap diem cua ban: ");
        float diem = scanner.nextFloat();
        scanner.close();
        if (diem >= 8.5)
            System.out.println("Gioi");
        else 
            if (diem >= 7.0) 
                System.out.println("Kha");
            else 
                if (diem >= 5.5)
                    System.out.println("Trung Binh");
                else
                    System.out.println("Yeu");
    }
}