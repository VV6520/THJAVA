package JAVA_DTN3_QLDBDT;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public abstract class Infor_Contact implements IContact_Manager {
    protected String name;
    protected String phone;
    protected Date dob; // Thêm thuộc tính sinh nhật
    protected String email;
    protected String address;

    public Infor_Contact() {
    }

    public Infor_Contact(String name, String phone, Date dob, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    
    public Date getdob() {
        return dob;
    }
    
    // Phương thức để nhập thông tin
    public void EnterContact(Scanner scanner) {
        System.out.print("Nhập tên: ");
        this.name = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.phone = scanner.nextLine();

        // Hỏi có muốn nhập ngày sinh không
        System.out.print("Bạn có muốn nhập ngày sinh không? (Y/N): ");
        String value = scanner.nextLine();
        if (value.equalsIgnoreCase("Y"))
            nhapNgaySinh(scanner); // Gọi phương thức nhập ngày sinh
        else
            this.dob = null; // Không nhập ngày sinh

        // Hỏi có muốn nhập email không
        System.out.print("Bạn có muốn nhập email không? (Y/N): ");
        value = scanner.nextLine();
        if (value.equalsIgnoreCase("Y")) {
            System.out.print("Nhập email: ");
            this.email = scanner.nextLine();
        } 
        else
            this.email = null; // Không nhập email

        // Hỏi có muốn nhập địa chỉ không
        System.out.print("Bạn có muốn nhập địa chỉ không? (Y/N): ");
        value = scanner.nextLine();
        if (value.equalsIgnoreCase("Y")) {
            System.out.print("Nhập địa chỉ: ");
            this.address = scanner.nextLine();
        } 
        else 
            this.address = null; // Không nhập địa chỉ
    }

    // Phương thức để nhập ngày sinh
    protected void nhapNgaySinh(Scanner scanner) {
        System.out.println("Nhập ngày sinh (ngày/tháng/năm): ");
        String ngaySinhStr = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dob = dateFormat.parse(ngaySinhStr);
        } catch (ParseException e) {
            System.out.println("Nhập định dạng sai. Nhập lại");
            nhapNgaySinh(scanner);
        }
    }

    @Override
    public void displayContactInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Ngày sinh: " + dob);
        System.out.println("Email: " + email);
        System.out.println("Địa chỉ: " + address);
    }
    
    @Override
    public abstract boolean validateContactInfo();
    
}
