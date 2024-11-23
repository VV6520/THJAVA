package JAVA_DTN3_QLDBDT_BS;

import java.util.ArrayList;
import java.util.List;

public class GroupContact {
    private String groupName;
    private List<Infor_Contact> Infor_Contact;

    public GroupContact(String groupName) {
        this.groupName = groupName;
        this.Infor_Contact = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void addContact(Infor_Contact contact) {
        Infor_Contact.add(contact);
    }

    public void removeContact(Infor_Contact contact) {
        Infor_Contact.remove(contact);
    }

    public void displayGroupContacts() {
        System.out.println("Nhóm: " + groupName);
        for (Infor_Contact contact : Infor_Contact) {
            contact.displayContactInfo(); // Hiển thị thông tin liên hệ
            // Hiển thị loại liên hệ
            String contactType = contact instanceof PersonalContact ? "Cá nhân" : "Doanh nghiệp";
            System.out.println("Loại: " + contactType);
            System.out.println("----------------------------------------");
        }
    }
    
    public List<Infor_Contact> getInfor_Contact() {
        return Infor_Contact;
    }
}