package JAVA_DTN3_QLDBDT_BS;

import java.util.Scanner;

public interface IContact_Manager {
    void displayContactInfo(); // Hiển thị thông tin liên hệ
    void editContactInfo(String name, String phone, String DoB, String email, String address); // Chỉnh sửa thông tin liên hệ
    void deleteContact(); // Xóa liên hệ
    void enterContact(Scanner scanner); // Nhập thông tin liên hệ
    
}