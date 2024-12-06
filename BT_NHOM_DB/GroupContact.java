package BT_NHOM_DB;

import java.util.ArrayList;
import java.util.List;
public class GroupContact {
    private String groupName; 
    private List<Infor_Contact> contacts; 

  
    public GroupContact(String groupName) {
        this.groupName = groupName;
        this.contacts = new ArrayList<>();
    }

   
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Infor_Contact> getContacts() {
        return contacts;
    }

   
    public void addContact(Infor_Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            System.out.println("Đã thêm liên hệ vào nhóm " + groupName);
        } else {
            System.out.println("Liên hệ đã tồn tại trong nhóm.");
        }
    }

    
    public void removeContact(Infor_Contact contact) {
        if (contacts.contains(contact)) {
            contacts.remove(contact);
            System.out.println("Đã xóa liên hệ khỏi nhóm " + groupName);
        } else {
            System.out.println("Liên hệ không tồn tại trong nhóm.");
        }
    }

   
    public void displayContactInfo() {
        System.out.println("Thông tin nhóm: " + groupName);
        if (contacts.isEmpty()) {
            System.out.println("Nhóm hiện tại không có liên hệ.");
        } else {
            for (Infor_Contact contact : contacts) {
                contact.displayContactInfo();
                System.out.println("----------");
            }
        }
    }
    public List<Infor_Contact> searchContactByName(String name) {
        List<Infor_Contact> matchedContacts = new ArrayList<>();
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                matchedContacts.add(contact);
            }
        }
        return matchedContacts;
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }
}
