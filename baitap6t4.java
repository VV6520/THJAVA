import java.util.Scanner;

public class baitap6t4 {
    public static boolean kiemTraSoDoiXung(int so) {
        int sogoc = so;
        int soDaoNguoc = 0;
        
        while (so > 0) {
            int chuSo = so % 10;
            soDaoNguoc = soDaoNguoc * 10 + chuSo;
            so /= 10;
        }
        
        return sogoc == soDaoNguoc;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên: ");
        int so = sc.nextInt();
        
        if (kiemTraSoDoiXung(so)) {
            System.out.println(so + " là số đối xứng.");
        } else {
            System.out.println(so + " không phải là số đối xứng.");
        }
    }
}