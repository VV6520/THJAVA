import java.util.Scanner;
public class TH4_5 {
    public static int UCLN(int a, int b){
        if (a==b)
            return a;
        else
            if (a>b)
                return UCLN(a-b, b);
            else
                return UCLN(a, b-a);
    }
    public static void main(String[] args) {
        System.out.printf("Nhập vào số nguyên a ");
        int a = new Scanner(System.in).nextInt();
        System.out.printf("Nhập vào số nguyên b ");
        int b = new Scanner(System.in).nextInt();
        if (a==0 && b==0)
            System.out.println("Không có ƯCLN và BCNN");
        else
            if (a==0 || b==0){
                System.out.println("Không có BCNN");
                System.out.println("ƯCLN giữa "+a+" và "+b+" là "+((a==0)?b:a));
            }
            else{
                System.out.println("UCLN giua "+a+" và "+b+" là "+UCLN(a,b));
                int uc = UCLN(a,b);
                int bc = a*b;
                float BCNN = (float) bc/uc;
                System.out.println("BCNN giua "+a+" và "+b+" là "+BCNN);
            }
    }
}
