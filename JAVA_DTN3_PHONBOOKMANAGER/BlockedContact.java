package JAVA_DTN3_PHONEBOOKMANAGER;

import java.util.ArrayList;
import java.util.List;

public class BlockedContact {
    private PhoneBook phoneBook; // Tham chiếu đến PhoneBook
    private List<Infor_Contact> blockedContacts;

    public BlockedContact(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        this.blockedContacts = new ArrayList<>();
    }
    
    public void blockContact(Infor_Contact contact) {
        if (!blockedContacts.contains(contact)) {
            blockedContacts.add(contact);
            System.out.println("Liên hệ " + contact.getName() + " đã bị chặn.");
        } 
        else {
            System.out.println("Liên hệ đã được chặn trước đó.");
        }
    }

    public void unblockContact(Infor_Contact contact) {
        if (blockedContacts.contains(contact)) {
            blockedContacts.remove(contact);
            System.out.println("Liên hệ " + contact.getName() + " đã được mở chặn.");
        } else {
            System.out.println("Liên hệ không nằm trong danh sách chặn.");
        }
    }

    // Phương thức kiểm tra xem một liên hệ có bị chặn không
    public boolean isBlocked(Infor_Contact contact) {
        return blockedContacts.contains(contact);
    }

    public List<Infor_Contact> getBlockedContacts() {
        return blockedContacts;
    }
    
}
