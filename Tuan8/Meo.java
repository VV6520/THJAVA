package Tuan8;

public class Meo extends DongVat {
    public Meo(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void tiengKeu() {
        System.out.println(ten + " kêu: Meo Meo!");
    }
}
