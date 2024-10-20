
public class DongVat {
	protected String ten;
	protected int tuoi;
	public DongVat(String ten, int tuoi) {
		this.ten = ten;
		this.tuoi = tuoi;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public void inthongtin() {
		System.out.println("Ten "+ten+" tuoi "+tuoi);
	}
	public void tiengkeu() {
		System.out.println("dong vat khong ro tieng keu");
	}
	
}
