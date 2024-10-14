class HinhTron {
    private double banKinh;
    public HinhTron(double banKinh) {
        setBanKinh(banKinh);
    }
    public double getBanKinh() {
        return banKinh;
    }
    public void setBanKinh(double banKinh) {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        } else {
            System.out.println("Bán kính phải lớn hơn 0. Thiết lập bán kính mặc định là 1.");
            this.banKinh = 1.0;
        }
    }
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
    public void inThongTin() {
        System.out.println("Bán kính: " + banKinh);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Diện tích: " + tinhDienTich());
    }
}

public class baitap1t7 {
	public static void main(String[] args) {
        HinhTron ht1 = new HinhTron(5.0);
        ht1.inThongTin();
        HinhTron ht2 = new HinhTron(-3.0);
        ht2.inThongTin();
    }
}
