package JAVA_DTN3_QLDBDT_BS;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class PersonalContact extends Infor_Contact {
    private String Nickname; // Biệt danh

    public PersonalContact() {
    }
    
    public PersonalContact(String name, String phone, Date dob, String email, String address, String nickname) {
        super(name, phone, dob, email, address);
        this.Nickname = nickname;
    }

    public String getNickname() {
        return Nickname;
    }

    @Override
    public void EnterContact(Scanner scanner) {
        super.EnterContact(scanner);
        // Hỏi có muốn nhập biệt danh không
        System.out.print("Bạn có muốn nhập biệt danh không? (Y/N): ");
        String value = scanner.nextLine();
        if (value.equalsIgnoreCase("Y")) {
            System.out.print("Nhập biệt danh: ");
            this.Nickname = scanner.nextLine();
        } 
        else
            this.Nickname = null; // Không nhập biệt danh
    }

    @Override
    public void displayContactInfo() {
        super.displayContactInfo();
        System.out.println("Biệt danh: " + Nickname);
    }

    @Override
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
    public void deleteContact() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enterContact(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validateContactInfo() {
        if (name == null || name.isEmpty()) {
            System.out.println("Tên không được để trống.");
            return false;
        }
        if (phone == null || !phone.matches("\\d{10}")) { // Giả sử số điện thoại phải có 10 chữ số
            System.out.println("Số điện thoại không hợp lệ.");
            return false;
        }
        return true;
    }

}