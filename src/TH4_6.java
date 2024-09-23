import java.util.Scanner;
public class TH4_6 {
    public static void main(String[] args) {
        int n;
        do{
            System.out.println("Nhập vào số nguyên n");
            n = new Scanner(System.in).nextInt();
        }while (n<0);

        int giatricd, daoso, socuoi;
        giatricd = n;
        daoso = 0;
        while (n!=0){
            socuoi = n % 10;
            daoso = (daoso * 10) + socuoi;
            n = n / 10;
        }
        if (giatricd == daoso)
            System.out.println(giatricd+ " là số đối xứng");
        else
            System.out.println(giatricd+ " không là số đối xứng");
    }
}
