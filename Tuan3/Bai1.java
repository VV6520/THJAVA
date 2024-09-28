import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nhap so: ");
        int number = sc.nextInt();
        scanner.close();
        if (number > 0)
            System.out.println(number + " la so duong.");
        else 
            if (number < 0)
                System.out.println(number + " la so am.");
            else
                System.out.println("la so 0.");
    }
}