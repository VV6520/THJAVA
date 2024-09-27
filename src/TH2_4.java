import java.util.Scanner;
public class TH2_4 {
    public static void main(String[] args) {
        //Nhập dữ liệu
        System.out.printf("Số tiền gửi vào ngân hàng là  ");
        double tienGui = new Scanner(System.in).nextDouble();
        System.out.printf("Lãi xuất hàng năm của ngân hàng là  ");
        double laiXuat = new Scanner(System.in).nextDouble();
        System.out.printf("Số ngày gửi là  ");
        int ngay = new Scanner(System.in).nextInt();
        //Tính toán
        Double tienLai = tienGui*laiXuat*((float)ngay/360);
        Double tienGoc = tienLai + tienGui;
        //Xuất dữ liệu
        System.out.println("Số tiền lãi cuối kỳ là " +tienLai +" (đồng)");
        System.out.println("Số tiền gốc cuối kỳ là " +tienGoc +" (đồng)");
    }
}
