package Tuan8;

public class Cho extends DongVat {
    public Cho(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void tiengKeu() {
        System.out.println(ten + " kêu: Gâu Gâu!");
    }
}
