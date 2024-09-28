import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        double num1 = scanner.nextDouble();
        System.out.print("Nhap so thu hai: ");
        double num2 = scanner.nextDouble();
        System.out.println("Chon phep tinh: 1. Cong  2. Tru  3. Nhan  4. Chia");
        int choice = scanner.nextInt();
        if (choice == 1)
            System.out.println("Ket qua: " + (num1 + num2));
        else if (choice == 2)
            System.out.println("Ket qua: " + (num1 - num2));
        else if (choice == 3)
            System.out.println("Ket qua: " + (num1 * num2));
        else if (choice == 4) {
            if (num2 != 0)
                System.out.println("Ket qua: " + (num1 / num2));
            else
                System.out.println("Loi: Khong the chia cho 0.");
        } else
            System.out.println("Lua chon khong hop le.");
    }
}
