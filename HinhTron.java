import java.util.Scanner;

public class HinhTron {
	private double bankinh;
	public HinhTron() {
		nhapbankinh();
	}
	public double getBanKinh(){
		return bankinh;
	}
	public void setBanKinh(double bankinh) {
        if (bankinh > 0) {
            this.bankinh = bankinh;
        } else {
            System.out.println("Bán kính phải lớn hơn 0. Không thể đặt giá trị.");
        }
    }
	public void nhapbankinh() {
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("nhap vao bankinh hinh tron(ban kinh phai lon hon 0 : ");
			bankinh=sc.nextDouble();
			if(bankinh<=0) {
				System.out.println("vui long nhap lai ban kinh(ban kinh phai lon hon 0 !!!");
				bankinh=sc.nextDouble();
			}
		} while (bankinh<=0);
	}
	public double chuvi(){
		return 2* Math.PI * bankinh;
	}
	public double dientich(){
		return Math.PI*bankinh*bankinh;
	}
	public void inthongtin() {
		System.out.println("ban kinh cua hinh tron :"+bankinh);
		System.out.println("Dien tich hinh tron :"+dientich());
		System.out.println("Chu vi hinh tron :"+chuvi());
	}
}
