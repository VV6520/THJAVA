package JAVA_DTN3_QLDBDT;

import java.util.ArrayList;
import java.util.List;

public class GroupContact {
    private String groupName;
    private List<Infor_Contact> inforContact; // Danh sách liên hệ trong nhóm (Aggregation)

    public GroupContact(String groupName) {
        this.groupName = groupName;
        this.inforContact = new ArrayList<>(); // Khởi tạo danh sách liên hệ
    }

    public String getGroupName() {
        return groupName;
    }

    public void addContact(Infor_Contact contact) {
        inforContact.add(contact); // Thêm liên hệ vào danh sách
    }

    public void removeContact(Infor_Contact contact) {
        inforContact.remove(contact); // Xóa liên hệ khỏi danh sách
    }

    public void displayGroupContacts() {
        if (inforContact.isEmpty()) {
            System.out.println("Nhóm này hiện chưa có liên hệ nào.");
        } 
        else {
            for (Infor_Contact contact : inforContact) {
                contact.displayContactInfo(); // Hiển thị thông tin liên hệ
                // Hiển thị loại liên hệ
                String contactType = contact instanceof PersonalContact ? "Cá nhân" : "Doanh nghiệp";
                System.out.println("Loại: " + contactType);
                System.out.println("----------------------------------------");
            }
        }
    }

    public List<Infor_Contact> getInforContact() {
        return inforContact; // Trả về danh sách liên hệ trong nhóm
    }
}