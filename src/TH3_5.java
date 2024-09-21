import java.util.Scanner;

public class TH3_5 {
    public static void main(String[] args) {
        int a, b, c;
        System.out.println("Nhập vào ba cạnh của tam giác");
        System.out.printf("a= ");
        a = new Scanner(System.in).nextInt();
        System.out.printf("b= ");
        b = new Scanner(System.in).nextInt();
        System.out.printf("c= ");
        c = new Scanner(System.in).nextInt();
        if (a+b>c || a+c>b || b+c>a){
            System.out.println("Đây là ba cạnh của một tam giác");
            if (a==b && a==c && b==c)
                System.out.println("Và là tam giác đều");
            else
                if (a==b || a==c || b==c)
                    System.out.println("Và là tam giác cân");
                else
                    if((a*a)+(b*b)==c*c || (a*a)+(c*c)==b*b || (b*b)+(a*a)==c*c)
                        System.out.println("Và đây là tam giác vuông");
                    else
                        System.out.println("Và đây là tam giác thường");
        }
        else
            System.out.println("Đây không phải ba cạnh của một tam giác");
    }
}
