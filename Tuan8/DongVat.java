package Tuan8;

public class DongVat {
    protected String ten;
    protected int tuoi;

    public DongVat(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public void tiengKeu() {
        System.out.println(ten + " khong ro tieng keu.");
    }
}