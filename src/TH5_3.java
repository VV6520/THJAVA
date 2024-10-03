import java.util.Arrays;
import java.util.Scanner;
public class TH5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số phần tử của mảng ");
        int n = sc.nextInt();
        //Khởi tạo mảng
        int[] M = new int[n];
        //Nhập dữ liệu cho mảng
        for (int i=0; i<n; i++){
            System.out.printf("M[ "+i+" ]= ");
            M[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(M));
        Arrays.sort(M);
        System.out.println("Mảng sau khi sắp xếp là: "+Arrays.toString(M));
    }
}
