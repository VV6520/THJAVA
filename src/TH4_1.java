import java.util.Scanner;
public class TH4_1 {
    public static void main(String[] args) {
        int n, i, tong;
        tong = 0;
        System.out.printf("Nhập vào số n: ");
        n = new Scanner(System.in).nextInt();
        for (i=1; i<=n; i++){
            tong = tong + i;
        }
        System.out.println("Tổng các số từ 1 đến "+n+ " là: "+tong);
        }
    }
