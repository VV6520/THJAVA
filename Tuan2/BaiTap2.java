import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ten;
        int tuoi;
        double chieuCao;
        boolean thichLapTrinh;

        System.out.print("Nhập tên của bạn: ");
        ten = scanner.nextLine();

        System.out.print("Nhập tuổi của bạn: ");
        tuoi = scanner.nextInt();

        System.out.print("Nhập chiều cao của bạn (m): ");
        chieuCao = scanner.nextDouble();

        System.out.print("Bạn có thích lập trình không? (true/false): ");
        thichLapTrinh = scanner.nextBoolean();

        System.out.println("\nThông tin cá nhân của bạn:");
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Chiều cao: " + chieuCao + "m");
        System.out.println("Thích lập trình: " + thichLapTrinh);
    }
}
