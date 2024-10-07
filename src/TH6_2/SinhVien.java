package TH6_2;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>{
    private String maSV;
    private String hoTen;
    private String ngaySinh;
    private float diem;

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String maSV, String hoTen, String ngaySinh, float diem){
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diem = diem;
    }
    public String getMaSV(){
        return maSV;
    }
    public void setMaSV(){
        this.maSV = maSV;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(){
        this.hoTen = hoTen;
    }
    public String getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(){
        this.ngaySinh = ngaySinh;
    }
    public float getDiem(){
        return diem;
    }
    public void setDiem(float diem){
        this.diem = diem;
    }
    @Override
    public String toString() {
        return "HocSinh{" +
                "maSV= " + maSV +
                ", hoTen= " + hoTen +
                ", ngaySinh= " + ngaySinh +
                ", diem=" + diem +
                "}";
    }
    @Override
    public int compareTo(SinhVien o) {
        return this.maSV.compareTo(o.maSV);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        SinhVien other = (SinhVien) obj;
        return  Objects.equals(maSV, other.maSV);
    }
    @Override
    public int hashCode() {
        return Objects.hash(maSV, hoTen, ngaySinh, diem);
    }
}
