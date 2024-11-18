package JAVA_DTN3_QLDBDT;

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
    
    @Override
    public void EnterContact(Scanner scanner) {
        super.EnterContact(scanner);
        System.out.print("Nhập tên công ty: ");
        this.companyName = scanner.nextLine();

        System.out.print("Nhập chức vụ: ");
        this.position = scanner.nextLine();
    }

    @Override
    public void displayContactInfo() {
        super.displayContactInfo();
        System.out.println("Tên công ty: " + companyName);
        System.out.println("Chức vụ: " + position);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}