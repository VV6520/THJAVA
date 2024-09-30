import java.util.Scanner;

public class Bai2_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ten;
        int tuoi;
        double chieuCao;
        boolean thichLapTrinh;

        System.out.print("Nhap ten cua ban: ");
        ten = scanner.nextLine();

        System.out.print("Nhap tuoi cua ban: ");
        tuoi = scanner.nextInt();

        System.out.print("Nhap chieu cao cua ban (m): ");
        chieuCao = scanner.nextDouble();

        System.out.print("Ban co thich lap trinh khong? (true/false): ");
        thichLapTrinh = scanner.nextBoolean();

        System.out.println("\nThong tin ca nhan cua ban:");
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Chieu cao: " + chieuCao + "m");
        System.out.println("Thich lap trinh: " + thichLapTrinh);
    }
}
