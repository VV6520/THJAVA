import java.util.Scanner;

public class TH3_3 {
    public static void main(String[] args) {
        int a, b, c;
        double delta, x1, x2, x3, x4;
        //Nhập vào hệ số
        System.out.println("Nhập vào hệ số của phương trình bậc 2 ax^2+bx+c=0 ");
        System.out.printf("a= ");
        a = new Scanner(System.in).nextInt();
        System.out.printf("b= ");
        b = new Scanner(System.in).nextInt();
        System.out.printf("c= ");
        c = new Scanner(System.in).nextInt();

        if (a==0)
            if (b==0)
                if (c==0)
                    System.out.println("Phương trình có vô số nghiệm");
                else
                    System.out.println("Phương trình vô nghiệm");
            else{
                x1 = (double) -c/b;
                System.out.println("Phương trình có nghiệm duy nhất x = "+x1);
            }
         else{
             delta =  Math.pow(b,2) - (4*a*c);
             if (delta<0)
                 System.out.println("Phương trình vô nghiệm");
             else
                 if (delta==0){
                     x2 = (double) -b/(2*a);
                     System.out.println("Phương trình có nghiệm kép x1=x2= "+x2);
                 }
                 else{
                     x3 = -b-Math.sqrt(delta)/(2*a);
                     x4 = -b+Math.sqrt(delta)/(2*a);
                     System.out.println("Phương trình có hai nghiệm phân biệt");
                     System.out.println("x1= "+x3);
                     System.out.println("x2= "+x4);
                 }
        }


    }
}
