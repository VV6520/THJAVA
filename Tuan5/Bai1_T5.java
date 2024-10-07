import java.util.Scanner;
public class Bai1_T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng");
        int n = sc.nextInt();
        //Cấp phát bộ nhớ cho mảng
        int[] M = new int[n];
        //Nhập vào các phần tử mảng
        for (int i=0; i<n; i++){
            System.out.printf("M[ "+i+" ]= ");
            M[i] = sc.nextInt();
        }
        int tong = 0;
        for (int i=0; i<n; i++)
            tong = tong + M[i];
        System.out.println("Tổng các phần tử của mảng là: "+tong);
    }
}