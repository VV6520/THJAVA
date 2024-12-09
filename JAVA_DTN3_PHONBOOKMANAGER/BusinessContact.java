package JAVA_DTN3_PHONEBOOKMANAGER;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BusinessContact extends Infor_Contact {
    private String companyName; // Tên công ty
    private String position; // Chức vụ

    public BusinessContact() {
    }

    public BusinessContact(String name, String phone, Date dob, String email, String address, String companyName, String position) {
        super(name, phone, dob, email, address);
        this.companyName = companyName;
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }    

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public void enterContact(Scanner scanner, PhoneBook phoneBook) {
        super.enterContact(scanner, phoneBook); // Gọi phương thức nhập thông tin từ lớp cha
        
    }
    
    public void enterInforBusiness(Scanner scanner) {
        // Hỏi có muốn nhập thêm thông tin khác không
        System.out.print("Bạn có muốn nhập thêm thông tin công ty và chức vụ không? (Y/N): ");
        String value = scanner.nextLine();

        if (value.equalsIgnoreCase("Y")) {
            // Nhập tên công ty
            while (true) {
                System.out.print("Nhập tên công ty: ");
                String companyNameInput = scanner.nextLine().trim(); // Trim để loại bỏ khoảng trắng

                if (!companyNameInput.isEmpty()) {
                    this.companyName = companyNameInput; // Gán giá trị hợp lệ cho companyName
                    break; // Thoát khỏi vòng lặp nếu tên công ty hợp lệ
                } else {
                    System.out.println("Tên công ty không được để trống.");
                }
            }

            // Nhập chức vụ
            while (true) {
                System.out.print("Nhập chức vụ: ");
                String positionInput = scanner.nextLine().trim(); // Trim để loại bỏ khoảng trắng

                if (!positionInput.isEmpty()) {
                    this.position = positionInput; // Gán giá trị hợp lệ cho position
                    break; // Thoát khỏi vòng lặp nếu chức vụ hợp lệ
                } else {
                    System.out.println("Chức vụ không được để trống.");
                }
            }
        } else {
            this.companyName = null; // Không nhập tên công ty
            this.position = null; // Không nhập chức vụ
        }
    }

    @Override
    public void displayContactInfo() {
        super.displayContactInfo();
        System.out.println("Tên công ty: " + companyName);
        System.out.println("Chức vụ: " + position);
    }

    
    public void editContactInfo(String name, String phone, String DoB, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;

        // Cập nhật ngày sinh
        if (DoB != null && !DoB.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.dob = dateFormat.parse(DoB);
            } catch (ParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
    
    @Override
    public boolean validateContactInfo() {

        // Kiểm tra số điện thoại
        if (phone == null || !phone.matches("\\d{10,11}")) {
            System.out.println("Số điện thoại không hợp lệ. Phải có 10 hoặc 11 chữ số.");
            return false; // Ngay lập tức trả về false nếu số điện thoại không hợp lệ
        }
        return true;
    }

    
}