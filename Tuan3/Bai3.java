import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap c: ");
        double c = scanner.nextDouble();
        scanner.close();
        
        if (a == 0){
            if (b == 0){
                if (c==0)
                    System.out.println("Phuong trinh vo so nghiem");
                else
                    System.out.println("Phuong trinh vo nghiem");    
            }
            else {
                double x = -c / b;
                System.out.println("Phuong trinh co mot nghiem: x = " + x);
            }
        }
        else{
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phuong trinh co hai nghiem phan biet: x1 = " + x1 + ", x2 = " + x2);
            } 
            else 
                if (delta == 0) {
                    double x = -b / (2 * a);
                    System.out.println("Phuong trinh co nghiem kep: x = " + x);
                }
                else
                    System.out.println("Phuong trinh vo nghiem.");
        }
    }
}