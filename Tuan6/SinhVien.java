package Tuan6;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien> {
    private String maSV;
    private String hoTen;
    private float diem;

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String maSV, String hoTen, float diem) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diem=" + diem +
                '}';
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSV.compareTo(o.maSV);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SinhVien other = (SinhVien) obj;
        return Objects.equals(maSV, other.maSV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSV);
    }
}