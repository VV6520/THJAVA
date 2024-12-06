package BT_NHOM_DB;

import java.util.Scanner;


public interface IContact_Manager {
    void displayContactInfo();
    void editContactInfo();
    void deleteContact();
    void enterContact(Scanner scanner);
    boolean validateContactInfor();
}
