import java.util.Scanner;
public class TH4_3 {
    public static void main(String[] args) {
        int n;
        do {
            System.out.printf("Nhập vào số nguyên dương n ");
            n = new Scanner(System.in).nextInt();
        } while (n<0);
        int giaithua = 1;
        if (n==0)
            System.out.println(n+"!= 1");
        else {
            for (int i=1; i<=n; i++){
                giaithua = giaithua * i;
            }
            System.out.println(n+"!= "+giaithua);
        }
    }
}
