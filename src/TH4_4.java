import java.util.Scanner;
public class TH4_4 {
    public static int ktrsonguyento(int x){
        int i;
        if (x<=1)
            return 0;

        for (i=2; i<=x-1; i++){
            if (x%i==0)
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        int n, kt;
        do{
            System.out.printf("Nhập vào số nguyên n: ");
            n = new Scanner(System.in).nextInt();
        }while (n < 0);
        kt = ktrsonguyento(n);
        if (kt==0)
            System.out.println(n+" không phải là số nguyên tố");
        else
            System.out.println(n+" là số nguyên tố");
    }
}
