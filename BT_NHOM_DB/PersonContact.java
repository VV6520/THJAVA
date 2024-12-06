package BT_NHOM_DB;

import java.util.Scanner;

public class PersonContact extends Infor_Contact {
    private String nickname; 

    
    public PersonContact() {
        super(); 
        this.nickname = "";
    }

   
    public PersonContact(String name, String phone, String email, String address, String nickname) {
        super(); 
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nickname = nickname;
    }

   
    public String getNickname() {
        return nickname;
    }

   
    @Override
    public void enterContact(Scanner scanner) {
        super.enterContact(scanner); 
        System.out.print("Biệt danh: ");
        this.nickname = scanner.nextLine();
    }

    
    @Override
    public void displayContactInfo() {
        super.displayContactInfo(); 
        System.out.println("Biệt danh: " + (nickname.isEmpty() ? "Chưa có" : nickname));
    }

    
    public void editContactInfor() {
        Scanner scanner = new Scanner(System.in);

       
        super.editContactInfor(scanner);

        System.out.print("Sửa biệt danh (Hiện tại: " + (nickname.isEmpty() ? "Chưa có" : nickname) + "): ");
        String newNickname = scanner.nextLine();
        if (!newNickname.isEmpty()) {
            this.nickname = newNickname;
        }
    }

    
    @Override
    public boolean validateContactInfo() {
        boolean parentValidation = super.validateContactInfo(); // Kiểm tra thông tin chung từ lớp cha
        if (!parentValidation) {
            return false; 
        }
        if (nickname == null || nickname.isEmpty()) {
            System.out.println("Xác thực thất bại: Biệt danh không được để trống.");
            return false;
        }
        return true;
    }
}
