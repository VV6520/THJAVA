package Tuan7;

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

    public void xeploai() {
        if (this.diemTB < 0 || this.diemTB > 10){
            System.out.println("Ban da nhap sai diem trung binh");
            return;
        }
    
        if (this.diemTB >= 9.0)
            System.out.println("Xep loai xuat sac");
        else 
            if (this.diemTB >= 8.0)
                System.out.println("Xep loai gioi");
            else 
                if (this.diemTB >= 7.0)
                    System.out.println("Xep loai kha");
                else  
                    if (this.diemTB >= 5.0)
                        System.out.println("Xep loai trung binh");
                    else 
                        if (this.diemTB >= 4.0)
                            System.out.println("Xep loai yeu");
                        else
                            System.out.println("Xep loai kem");
    }
}
