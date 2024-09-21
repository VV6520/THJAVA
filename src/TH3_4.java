import java.util.Scanner;

public class TH3_4 {
    public static void main(String[] args) {
        int a, b, c;
        //Nhập dữ liệu
        System.out.printf("a= ");
        a = new Scanner(System.in).nextInt();
        System.out.printf("b= ");
        b = new Scanner(System.in).nextInt();
        System.out.printf("c= ");
        c = new Scanner(System.in).nextInt();

        //Tìm min
        if (a<b && a<c)
            System.out.println("Min= "+a);
        if (b<a && b<c)
            System.out.println("Min= "+b);
        if (c<b && c<a)
            System.out.println("Min= "+c);
    }
}
