package BT_NHOM_DB;


import java.util.Scanner;

public class BusinessContact extends Infor_Contact {
    private String companyName; 
    private String position;  

    public BusinessContact() {
        super();
        this.companyName = "";
        this.position = "";
    }
    public BusinessContact(String name, String phone, String email, String address, String companyName, String position) {
        super(); // Gọi constructor của lớp cha
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.companyName = companyName;
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    // Nhập thông tin liên hệ
    @Override
    public void enterContact(Scanner scanner) {
        super.enterContact(scanner); // Gọi phương thức nhập thông tin của lớp cha

        System.out.print("Tên công ty: ");
        this.companyName = scanner.nextLine();

        System.out.print("Chức vụ: ");
        this.position = scanner.nextLine();
    }

    // Hiển thị thông tin liên hệ
    @Override
    public void displayContactInfo() {
        super.displayContactInfo(); // Gọi phương thức hiển thị thông tin của lớp cha
        System.out.println("Tên công ty: " + (companyName.isEmpty() ? "Chưa có" : companyName));
        System.out.println("Chức vụ: " + (position.isEmpty() ? "Chưa có" : position));
    }

    // Chỉnh sửa thông tin liên hệ
    @Override
    public void editContactInfor() {
        Scanner scanner = new Scanner(System.in);

        // Gọi phương thức chỉnh sửa thông tin chung từ lớp cha
        super.editContactInfor();

        System.out.print("Sửa tên công ty (Hiện tại: " + (companyName.isEmpty() ? "Chưa có" : companyName) + "): ");
        String newCompanyName = scanner.nextLine();
        if (!newCompanyName.isEmpty()) {
            this.companyName = newCompanyName;
        }

        System.out.print("Sửa chức vụ (Hiện tại: " + (position.isEmpty() ? "Chưa có" : position) + "): ");
        String newPosition = scanner.nextLine();
        if (!newPosition.isEmpty()) {
            this.position = newPosition;
        }
    }
}
