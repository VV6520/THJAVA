package JAVA_DTN3_QLDBDT;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public abstract class Infor_Contact {
    protected String name;
    protected String phone;
    protected Date dob;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // Phương thức để nhập thông tin
    public void enterContact(Scanner scanner, PhoneBook phoneBook) {
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Nhập tên liên hệ: ");
            this.name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Tên không được để trống.");
                continue;
            }

            // Nhập số điện thoại trong một vòng lặp
            while (true) {
                System.out.print("Nhập số điện thoại: ");
                this.phone = scanner.nextLine().trim();

                // Kiểm tra nếu liên hệ đã tồn tại
                if (phoneBook.isContactExists(this.name, this.phone)) {
                    System.out.println("Cảnh báo: Thông tin liên hệ đã tồn tại. Vui lòng thử lại.");
                    return; // Không cho phép nhập lại
                }

                // Kiểm tra tính hợp lệ của số điện thoại
                isValid = validContactInfo();
                if (isValid) {
                    break;
                }
            }

            isValid = true;
        }

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
            System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập lại.");
            nhapNgaySinh(scanner);
        }
    }

    public void displayContactInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Ngày sinh: " + dob);
        System.out.println("Email: " + email);
        System.out.println("Địa chỉ: " + address);
    }
    
    public abstract boolean validContactInfo();
    
}
