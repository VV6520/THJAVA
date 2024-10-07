import java.util.Scanner;
public class Bai6_T5 {
    static int[] M;
    static int N;
    static Scanner sc = new Scanner(System.in);

    // Hàm nhập mảng
    static void Nhap() {
        for (int i = 1; i <= N; i++) {
            System.out.printf("M[%d] = ", i);
            M[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhap so luong phan tu mong muon: ");
        N = sc.nextInt();
        
        // Khởi tạo mảng với kích thước N + 1 để sử dụng chỉ số từ 1
        M = new int[N + 1];
        Nhap(); // Gọi hàm nhập mảng
        
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Them phan tu");
            System.out.println("2. Xoa phan tu");
            System.out.println("3. In danh sach");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap gia tri can them: ");
                    int giaTriThem = sc.nextInt();
                    System.out.print("Nhap vi tri muon them: ");
                    int viTriThem = sc.nextInt();
                    
                    if (viTriThem >= 1 && viTriThem <= N + 1) 
                    { // cho phép thêm vào vị trí N + 1
                        // Tạo mảng mới có kích thước lớn hơn để thêm phần tử
                        int[] newM = new int[N + 2]; // Tăng thêm 1 cho mảng mới
                        for (int i = 1; i < viTriThem; i++) {
                            newM[i] = M[i]; // Sao chép các phần tử trước vị trí thêm
                        }
                        newM[viTriThem] = giaTriThem; // Thêm phần tử mới
                        for (int i = viTriThem; i <= N; i++) {
                            newM[i + 1] = M[i]; // Sao chép các phần tử sau vị trí thêm
                        }
                        M = newM; // Cập nhật mảng M
                        N++; // Tăng số lượng phần tử
                        System.out.println("Da them phan tu " + giaTriThem + " tai vi tri " + viTriThem);
                    } else {
                        System.out.println("Vi tri khong hop le.");
                    }
                    break;

                case 2:
                    System.out.print("Nhap vi tri muon xoa: ");
                    int viTriXoa = sc.nextInt();
                    if (viTriXoa >= 1 && viTriXoa <= N) {
                        // Tạo mảng mới có kích thước nhỏ hơn để xóa phần tử
                        int[] newM = new int[N]; // Kích thước mới
                        for (int i = 1; i < viTriXoa; i++)
                            newM[i] = M[i]; // Sao chép các phần tử trước vị trí xóa
                        for (int i = viTriXoa + 1; i <= N; i++)
                            newM[i - 1] = M[i]; // Sao chép các phần tử sau vị trí xóa
                        M = newM; // Cập nhật mảng M
                        N--; // Giảm số lượng phần tử
                        System.out.println("Da xoa phan tu tai vi tri " + viTriXoa);
                    } 
                    else
                        System.out.println("Vi tri khong hop le.");
                    break;

                case 3:
                    System.out.println("Danh sach duoc tao thanh");
                    for (int i = 1; i <= N; i++) {
                        System.out.print(M[i] + " ");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Moi thu lai.");
            }
        } 
        while (choice != 4);
        
        sc.close();
    }
}
