import java.util.Arrays;
import java.util.Scanner;

public class TH5_2 {
    public static void daoNguocMang(int[] M, int n){
        for (int i=0; i<n/2; i++){
            int tam = M[i];
            M[i] = M[n-i-1];
            M[n-i-1] = tam;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng ");
        int n = sc.nextInt();
        //Khởi tạo mảng
        int[] M = new int[n];
        //Nhập dữ liệu cho mảng
        for (int i=0; i<n; i++){
            System.out.println("M[ "+i+" ]= ");
            M[i] = sc.nextInt();
        }
        //Xuat mang nguoc
        System.out.println("Mảng sau khi đảo ngược là: ");
        daoNguocMang(M,n);
        System.out.println(Arrays.toString(M));
    }
}
