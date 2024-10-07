import java.util.Scanner;

public class TaiKhoan {
    static Scanner sc = new Scanner(System.in);
    private int stk;
    private String chuTK;
    private long soDu;

    public int getStk() {
        return this.stk;
    }

    public String getChuTK() {
        return this.chuTK;
    }

    public long getSoDu() {
        return this.soDu;
    }

    public void nhap() {
        System.out.print("Nhap vao so tai khoan: ");
        this.stk = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap vao chu tai khoan: ");
        this.chuTK = sc.nextLine();
        System.out.print("Nhap vao so du: ");
        this.soDu = sc.nextLong();
    }

    public void xuat() {
        System.out.println("STK: " + stk + " - TENTK: " + chuTK + " - SODU: " + soDu);
    }

    public long guiTien() {
        long tienGui;
        System.out.print("Nhap vao so tien can gui: ");
        tienGui = sc.nextLong();
        if (tienGui < 0) {
            System.out.println("So tien gui khong hop le.");
            return this.soDu;
        }
        this.soDu += tienGui;
        return this.soDu;
    }

    public long rutTien() {
        long tienRut;
        System.out.print("Nhap vao so tien muon rut: ");
        tienRut = sc.nextLong();
        if (tienRut < 0) {
            System.out.println("So tien rut khong hop le.");
            return this.soDu;   
        }
        if (this.soDu >= tienRut) {
            this.soDu -= tienRut;
            return this.soDu;
        }
        System.out.println("So du khong du.");
        return this.soDu;   
    }

    public static void main(String[] args) {
        TaiKhoan tk = new TaiKhoan();
        tk.nhap();

        int choice;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Xem thong tin tai khoan");
            System.out.println("4. Thoat");
            System.out.print("Chon thao tac: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tk.guiTien();
                    break;
                case 2:
                    tk.rutTien();
                    break;
                case 3:
                    tk.xuat();
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

        } 
        while (choice != 4);

        sc.close();
    }
}
