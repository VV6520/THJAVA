import java.util.Scanner;

public class Nhap_in_SV {
    public String maSV;
    public String hoTen;
    public String ngaySinh;
    public double diemTB;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        maSV = sc.nextLine();
        System.out.println("Nhập họ và tên: ");
        hoTen = sc.nextLine();
        System.out.println("Nhập vào ngày sinh: ");
        ngaySinh = sc.nextLine();
        System.out.println("Nhập vào điểm trung bình: ");
    }
}
