import java.util.Scanner;

public class TH3_2 {
    public static void main(String[] args) {
        float dtb;
        do{
            System.out.printf("Nhập vào điểm trung bình của bạn: ");
            dtb = new Scanner(System.in).nextFloat();
        }while(dtb>10);
        if (dtb<=10 && dtb>=8.0)
            System.out.println("Xếp loại giỏi");
        if (dtb<8.0 && dtb>=7.0)
            System.out.println("Xếp loại khá");
        if (dtb<7.0 && dtb>=5.0)
            System.out.println("Xếp loại trung bình");
        if (dtb<5.0 && dtb>=4)
            System.out.println("Xếp loại yếu");
    }
}
