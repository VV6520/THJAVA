package JAVA_DTN3_PHONEBOOKMANAGER;

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

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    @Override
    public void enterContact(Scanner scanner, PhoneBook phoneBook) {
        super.enterContact(scanner, phoneBook);
    }
    
    public void enterNickname(Scanner scanner) {
        System.out.print("Bạn có muốn nhập biệt danh không? (Y/N): ");
        String value = scanner.nextLine();
        if (value.equalsIgnoreCase("Y")) {
            System.out.print("Nhập biệt danh: ");
            this.Nickname = scanner.nextLine();
        } else {
            this.Nickname = null; // Không nhập biệt danh
        }
    }
    
    @Override
    public void displayContactInfo() {
        super.displayContactInfo();
        System.out.println("Biệt danh: " + Nickname);
    }

    @Override
    public boolean validContactInfo() {
        if (phone == null || !phone.matches("\\d{10}")) 
        { // Giả sử số điện thoại phải có 10 chữ số
            System.out.println("Số điện thoại không đúng như định dạng 10 số.");
            return false;
        }
        return true;
    }


}