import java.util.Scanner;

public class TH3_1 {
    public static void main(String[] args) {
        System.out.printf("Nhập vào số cần kiểm tra ");
        float n = new Scanner(System.in).nextFloat();
        if (n>0)
            System.out.println("Số "+n+ " là số dương");
        else
            if (n<0)
                System.out.println("Số "+n+ " là số âm");
            else
                System.out.println("Số "+n+ " là số 0");
    }
}
