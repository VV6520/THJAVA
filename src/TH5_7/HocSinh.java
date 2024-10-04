package TH5_7;

import java.util.Objects;

public class HocSinh implements Comparable<HocSinh>{
    private String maHS;
    private String hoTen;
    private float diem;

    public HocSinh(String maHS) {
        this.maHS = maHS;
    }

    public HocSinh(String maHS, String hoTen, float diem){
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.diem = diem;
    }
    public String getMaSV(){
        return maHS;
    }
    public void setMaSV(){
        this.maHS = maHS;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(){
        this.hoTen = hoTen;
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
                "maHS='" + maHS + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diem=" + diem +
                '}';
    }
    @Override
    public int compareTo(HocSinh o) {
        return this.maHS.compareTo(o.maHS);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        HocSinh other = (HocSinh) obj;
        return  Objects.equals(maHS, other.maHS);
    }
    @Override
    public int hashCode() {
        return Objects.hash(maHS, hoTen, diem);
    }
}
