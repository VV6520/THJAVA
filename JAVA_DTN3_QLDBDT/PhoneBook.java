package JAVA_DTN3_QLDBDT;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class PhoneBook {
    // Danh sách các thông tin liên hệ
    protected ArrayList<Infor_Contact> phonebook;

    // Danh sách liên hệ thông thường
    private List<Infor_Contact> contacts = new ArrayList<>();
    private List<GroupContact> groups = new ArrayList<>();
    private List<CallSchedule> callSchedules = new ArrayList<>(); // Danh sách cuộc gọi đã lên lịch

    // Constructor khởi tạo
    public PhoneBook() {
        phonebook = new ArrayList<>();
    }

    public void addContact(Infor_Contact contact) {
        if (isNameExists(contact.getName())) {
            System.out.println("Cảnh báo: Tên liên hệ đã tồn tại. Vui lòng nhập tên khác.");
        } else {
            contacts.add(contact);
            System.out.println("Liên hệ đã được thêm thành công.");
        }
    }

    private boolean isNameExists(String name) {
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return true; // Tên đã tồn tại
            }
        }
        return false; // Tên không tồn tại
    }

    public List<Infor_Contact> getContacts() {
        return contacts;
    }
    
    public void displayAllContacts() {
        printtitle();
        for (Infor_Contact contact : contacts) {
            displayContactRow(contact);
        }
    }

    private void printtitle() {
        System.out.printf("%-15s %-20s %-25s %-20s %-20s %-25s\n",
                "Tên", "Số điện thoại", "Email", "Địa chỉ", "Nhóm", "Loại");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }
    
    private void displayContactRow(Infor_Contact contact) {
        String groupName = getContactGroup(contact);
        System.out.printf("%-15s %-20s %-25s %-20s %-20s %-25s\n",
                contact.getName(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getAddress(),
                groupName,
                contact instanceof PersonalContact ? "Cá nhân" : "Công việc");
    }

    private String getContactGroup(Infor_Contact contact) {
        for (GroupContact group : groups) {
            if (group.getInfor_Contact().contains(contact)) {
                return group.getGroupName();
            }
        }
        return "Chưa phân nhóm"; // Nếu liên hệ không thuộc nhóm nào
    }
    
    public void searchContacts(String keyword) {
        System.out.println("Kết quả tìm kiếm cho từ khóa: " + keyword);
        boolean found = false; // Biến cờ kiểm tra xem có liên hệ nào được tìm thấy không

        // In tiêu đề cho kết quả tìm kiếm
        printtitle();

        for (Infor_Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                contact.getPhone().contains(keyword)) {
                // Hiển thị thông tin liên hệ
                displayContactRow(contact);
                found = true; // Đã tìm thấy ít nhất một liên hệ
            }
        }

        // Nếu không tìm thấy liên hệ nào
        if (!found) {
            System.out.println("Không tồn tại liên hệ nào với từ khóa: " + keyword);
        }
    }

    public void createGroup(String groupName) {
        groups.add(new GroupContact(groupName));
        System.out.println("Nhóm " + groupName + " đã được tạo.");
    }

    public void addContactToGroup(String groupName, Infor_Contact contact) {
        for (GroupContact group : groups) {
            if (group.getGroupName().equals(groupName)) {
                group.addContact(contact);
                System.out.println("Liên hệ " + contact.getName() + " đã được thêm vào nhóm " + groupName);
                return;
            }
        }
        System.out.println("Nhóm không tồn tại.");
    }

    public void displayGroups() {
        for (GroupContact group : groups) {
            group.displayGroupContacts();
            System.out.println("=============================================");
        }
    }

    public void scheduleCall(String contactName, Date callTime) {
        boolean contactExists = false;
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                contactExists = true;
                break;
            }
        }

        if (!contactExists) {
            System.out.println("Liên hệ không tồn tại. Không thể lên lịch cuộc gọi.");
            return;
        }

        callSchedules.add(new CallSchedule(contactName, callTime));
        System.out.println("Cuộc gọi với " + contactName + " đã được lên lịch vào " + callTime);
    }

    public void displayScheduledCalls() {
        System.out.printf("%-20s %-25s\n", "Tên liên hệ", "Thời gian cuộc gọi");
        System.out.println("-----------------------------------------------------------------------------");
        for (CallSchedule schedule : callSchedules) {
            System.out.printf("%-20s %-25s\n", schedule.getContactName(), schedule.getCallTime());
        }
    }

    public void remindCalls() {
        Date now = new Date(); // Lấy thời gian hiện tại

        System.out.println("Nhắc nhở cuộc gọi:");
        boolean hasRemindCall = false;

        for (CallSchedule schedule : callSchedules) {
            if (schedule.getCallTime().before(now)) {
                System.out.println("Nhắc nhở: Đã đến thời gian cuộc gọi với " + schedule.getContactName());
                hasRemindCall = true;
            }
        }

        if (!hasRemindCall) {
            System.out.println("Không có cuộc gọi nào cần nhắc nhở.");
        }
    }
    
    public void remindBirthdays() {
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        System.out.println("Nhắc nhở sinh nhật hôm nay:");
        for (Infor_Contact contact : contacts) {
            if (contact.getdob() != null) {
                Calendar dobCalendar = Calendar.getInstance();
                dobCalendar.setTime(contact.getdob());
                int dobMonth = dobCalendar.get(Calendar.MONTH);
                int dobDay = dobCalendar.get(Calendar.DAY_OF_MONTH);

                if (dobMonth == currentMonth && dobDay == currentDay) {
                    System.out.println("Hôm nay là sinh nhật của " + contact.getName());
                }
            }
        }
    }
}