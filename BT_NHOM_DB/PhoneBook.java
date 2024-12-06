package BT_NHOM_DB;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class PhoneBook {
    // Thuộc tính
    private List<Infor_Contact> phonebook; // Danh sách các liên hệ
    private List<GroupContact> groups;    // Danh sách các nhóm liên hệ
    private List<CallSchedule> callSchedules; // Danh sách lịch gọi

    // Constructor
    public PhoneBook() {
        this.phonebook = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.callSchedules = new ArrayList<>();
    }

    // 1. Thêm liên hệ
    public void addContact(Infor_Contact contact) {
        if (contact == null || contact.getName() == null || contact.getName().isEmpty()) {
            System.out.println("Invalid contact. Cannot add to phonebook.");
            return;
        }
        phonebook.add(contact);
        System.out.println("Contact added successfully!");
    }

    // 2. Lấy danh sách liên hệ
    public List<Infor_Contact> getContact() {
        return phonebook;
    }

    // 3. Kiểm tra tên liên hệ đã tồn tại
    public boolean isNameExists(String name) {
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // 4. Hiển thị tất cả liên hệ
    public void displayAllContacts() {
        if (phonebook.isEmpty()) {
            System.out.println("The phonebook is empty!");
        } else {
            System.out.println("All Contacts:");
            for (Infor_Contact contact : phonebook) {
                contact.displayContactInfo();
                System.out.println("----------");
            }
        }
    }

    // 5. Hiển thị từng dòng liên hệ
    public void displayContactRow() {
        for (Infor_Contact contact : phonebook) {
            System.out.println(contact.getName() + " | " + contact.getPhone());
        }
    }

    // 6. Lấy nhóm của liên hệ
    public String getContactGroup(String contactName) {
        for (GroupContact group : groups) {
            for (Infor_Contact contact : group.getContacts()) {
                if (contact.getName().equalsIgnoreCase(contactName)) {
                    return group.getGroupName();
                }
            }
        }
        return "No group found for this contact.";
    }

    // 7. Tìm kiếm liên hệ
    public void searchContacts(String keyword) {
        boolean found = false;
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(keyword) || contact.getPhone().contains(keyword)) {
                contact.displayContactInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found matching: " + keyword);
        }
    }

    // 8. Tạo nhóm mới
    public void createGroup(String groupName) {
        if (groupName == null || groupName.isEmpty()) {
            System.out.println("Invalid group name!");
            return;
        }
        groups.add(new GroupContact(groupName));
        System.out.println("Group created successfully!");
    }

    // 9. Thêm liên hệ vào nhóm
    public void addContactToGroup(String contactName, String groupName) {
        GroupContact targetGroup = null;
        Infor_Contact targetContact = null;

        // Tìm nhóm
        for (GroupContact group : groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                targetGroup = group;
                break;
            }
        }

        if (targetGroup == null) {
            System.out.println("Group not found!");
            return;
        }

        // Tìm liên hệ
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                targetContact = contact;
                break;
            }
        }

        if (targetContact == null) {
            System.out.println("Contact not found!");
            return;
        }

        // Thêm liên hệ vào nhóm
        targetGroup.addContact(targetContact);
        System.out.println("Contact added to group successfully!");
    }

    // 10. Hiển thị các nhóm
    public void displayGroups() {
        if (groups.isEmpty()) {
            System.out.println("No groups found!");
        } else {
            System.out.println("Groups:");
            for (GroupContact group : groups) {
                System.out.println("Group Name: " + group.getGroupName());
            }
        }
    }

    // 11. Nhắc nhở sinh nhật
    public void remindBirthdays() {
        LocalDate today = LocalDate.now();
        for (Infor_Contact contact : phonebook) {
            if (contact.getDob() != null &&
                contact.getDob().getMonthValue() == today.getMonthValue() &&
                contact.getDob().getDayOfMonth() == today.getDayOfMonth()) {
                System.out.println("Today is " + contact.getName() + "'s birthday!");
            }
        }
    }


	public List<CallSchedule> getCallSchedules() {
	    return callSchedules;
	}
	public void DocFile(String fileName) {
	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] info = line.split(",");
	            int type = Integer.parseInt(info[0]); // Loại liên hệ: 1 = BusinessContact, 2 = PersonContact
	            Infor_Contact contact = null;

	            if (type == 1) { // BusinessContact
	                contact = new BusinessContact(info[1], info[2], info[3], info[4], info[5], line);
	            } else if (type == 2) { // PersonContact
	                contact = new PersonContact(info[1], info[2], info[3], info[4], info[5]);
	            }

	            if (contact != null) {
	                this.phonebook.add(contact);
	            }
	        }
	        System.out.println("File loaded successfully!");
	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	}
	public void GhiFile(String fileName) {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
	        for (Infor_Contact contact : this.phonebook) {
	            String type = (contact instanceof BusinessContact) ? "1" : "2";
	            String data = type + "," +
	                          contact.getName() + "," +
	                          contact.getPhone() + "," +
	                          contact.getEmail() + "," +
	                          contact.getAddress();

	            if (contact instanceof BusinessContact) {
	                data += "," + ((BusinessContact) contact).getCompanyName();
	            } else if (contact instanceof PersonContact) {
	                data += "," + ((PersonContact) contact).getNickname();
	            }

	            bw.write(data);
	            bw.newLine();
	        }
	        System.out.println("File saved successfully!");
	    } catch (IOException e) {
	        System.out.println("Error writing to file: " + e.getMessage());
	    }
	}

}
