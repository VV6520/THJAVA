package Tuan_7;

public class SinhVien {
    private String maSV;
    private String ten;
    private String ngaySinh;
    private double diemTB;
    public SinhVien(String maSV, String ten, String ngaySinh, double diemTB){
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        if (diemTB >= 0 && diemTB <= 10)
            this.diemTB = diemTB;
        else
            this.diemTB = -1;
    }
    public void xeploai(){
        if (this.diemTB>=9.0 && this.diemTB <=10.0)
            System.out.println("Xếp loại xuất sắc");
        else if (this.diemTB<9.0 && this.diemTB>=8.0)
            System.out.println("Xếp loại giỏi");
        else if (this.diemTB<8.0 && this.diemTB>=7.0)
            System.out.println("Xếp loại khá");
        else if(this.diemTB<7.0 && this.diemTB>=5.0)
            System.out.println("Xếp loại trung bình");
        else if (this.diemTB<5.0 && this.diemTB>=4.0)
            System.out.println("Xếp loại yếu");
        else if (this.diemTB<4.0 && this.diemTB>=0)
            System.out.println("Xếp loại kém");
        else System.out.println("Bạn đã nhập sai điểm trung bình");
    }

}
