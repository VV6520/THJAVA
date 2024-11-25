package JAVA_DTN3_QLDBDT_BS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PhoneBook {
    protected ArrayList<Infor_Contact> phonebook;
    private List<Infor_Contact> contacts = new ArrayList<>();
    private List<GroupContact> groups = new ArrayList<>();
    private List<CallSchedule> callSchedules = new ArrayList<>();
    static final Scanner scanner = new Scanner(System.in);

    public PhoneBook() {
        phonebook = new ArrayList<>();
    }
    
    // Phương thức thêm liên hệ mới
    public void addContact(Infor_Contact contact) {
        if (isNameExists(contact.getName(), contact.getPhone())) {
            System.out.println("Cảnh báo: Tên liên hệ đã tồn tại. Vui lòng nhập tên khác.");
        } else {
            contacts.add(contact);
            System.out.println("Liên hệ đã được thêm thành công.");
        }
    }

    // Phương thức kiểm tra liên hệ tồn tại
    private boolean isNameExists(String name, String phone) {
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name) || contact.getPhone().equals(phone))
                return true; // Tên hoặc số điện thoại đã tồn tại
        }
        return false; // Tên hoặc số điện thoại đều không tồn tại
    }

    public List<Infor_Contact> getContacts() {
        return contacts;
    }
    
    // Phương thức hiển thị tất cả liên hệ
    public void displayAllContacts() {
        printTitle();
        for (Infor_Contact contact : contacts) {
            displayContactRow(contact);
        }
    }
    
    // In tiêu đề
    private void printTitle() {
        System.out.printf("%-15s %-20s %-25s %-20s %-20s %-25s\n",
                "Tên", "Số điện thoại", "Email", "Địa chỉ", "Nhóm", "Loại");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Phương thức hiển thị các dòng liên hệ
    private void displayContactRow(Infor_Contact contact) {
        String groupName = getContactGroup(contact);
        String additionalInfo = ""; // Biến để lưu thông tin bổ sung

        if (contact instanceof PersonalContact) {
            String nickname = ((PersonalContact) contact).getNickname(); // Lấy biệt danh
            additionalInfo = String.format("Biệt danh: %s", nickname);
        } else if (contact instanceof BusinessContact) {
            BusinessContact businessContact = (BusinessContact) contact;
            additionalInfo = String.format("Công ty: %s, Chức vụ: %s", 
                            businessContact.getCompanyName(), 
                            businessContact.getPosition());
        }

        System.out.printf("%-15s %-20s %-25s %-20s %-20s %-25s %s\n",
                contact.getName(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getAddress(),
                groupName,
                contact instanceof PersonalContact ? "Cá nhân" : "Công việc",
                additionalInfo);
    }
    
    // Phương thức xác định nhóm mà một liên hệ cụ thể thuộc về.
    private String getContactGroup(Infor_Contact contact) {
        for (GroupContact group : groups) {
            if (group.getInfor_Contact().contains(contact)) {
                return group.getGroupName();
            }
        }
        return "Chưa phân nhóm"; // Nếu liên hệ không thuộc nhóm nào
    }
    
    // Phương thức tìm kiếm liên hệ
    public void searchContacts(String keyword) {
        System.out.println("Kết quả tìm kiếm cho từ khóa: " + keyword);
        printTitle();
        boolean found = false; // Biến cờ kiểm tra xem có liên hệ nào được tìm thấy không

        for (Infor_Contact contact : contacts) {
            // Kiểm tra nếu tên hoặc số điện thoại chứa từ khóa
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                contact.getPhone().contains(keyword)) {
                displayContactRow(contact); // Hiển thị thông tin liên hệ
                found = true; // Đã tìm thấy ít nhất một liên hệ
            }
        }

        if (!found) {
            System.out.println("Không tồn tại liên hệ nào với từ khóa: " + keyword);
        }
    }
    
    // Phương thức tạo nhóm
    public void createGroup(String groupName) {
        if (!isGroupExists(groupName)) {
            GroupContact newGroup = new GroupContact(groupName);
            groups.add(newGroup);
            System.out.println("Nhóm " + groupName + " đã được tạo.");
            addContactToNewGroup(newGroup);
        } 
        else
            System.out.println("Nhóm " + groupName + " đã tồn tại. Không thể tạo nhóm mới.");
    }
    
    // Phương thức kiểm tra nhóm tồn tại
    private boolean isGroupExists(String groupName) {
        for (GroupContact group : groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName))
                return true; // Nhóm đã tồn tại
        }
        return false; // Nhóm không tồn tại
    }

    // Phương thức thêm liên hệ mới vào nhóm
    private void addContactToNewGroup(GroupContact newGroup) {
        System.out.print("Bạn có muốn thêm liên hệ vào nhóm này không? (Y/N): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Nhập từ khóa để tìm kiếm liên hệ: ");
            String keyword = scanner.nextLine();
            searchContacts(keyword);

            System.out.print("Nhập tên liên hệ cần thêm vào nhóm: ");
            String contactName = scanner.nextLine();

            for (Infor_Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(contactName)) {
                    newGroup.addContact(contact);
                    System.out.println("Liên hệ " + contactName + " đã được thêm vào nhóm " + newGroup.getGroupName());
                    return;
                }
            }
            System.out.println("Không tìm thấy liên hệ với tên: " + contactName);
        }
    }

    // Phương thức xóa liên hệ
    public void deleteContact(String identifier) {
        Infor_Contact contactToRemove = null;

        // Tìm liên hệ theo tên hoặc số điện thoại
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(identifier) || contact.getPhone().equals(identifier)) {
                contactToRemove = contact;
                break; // Tìm thấy liên hệ, dừng vòng lặp
            }
        }

        // Nếu tìm thấy liên hệ, thực hiện xóa
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
            System.out.println("Liên hệ " + contactToRemove.getName() + " đã được xóa.");

            // Xóa liên hệ khỏi các nhóm (nếu có)
            for (GroupContact group : groups) {
                group.removeContact(contactToRemove); // Giả định rằng GroupContact có phương thức removeContact
            }
        } else {
            System.out.println("Không tìm thấy liên hệ với tên hoặc số điện thoại: " + identifier);
        }
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

    // Phương thức hiển thị nhóm
    public void displayGroups() {
        if (groups.isEmpty()) {
            System.out.println("Chưa có nhóm nào được tạo.");
            return;
        }

        System.out.printf("%-20s %-25s\n", "Tên nhóm", "Số lượng liên hệ");
        System.out.println("-----------------------------------------------------");
        for (GroupContact group : groups) {
            System.out.printf("%-20s %-25d\n", group.getGroupName(), group.getInfor_Contact().size());
        }

        System.out.println("\nThông tin chi tiết từng nhóm:");
        for (GroupContact group : groups) {
            System.out.println("Nhóm: " + group.getGroupName());
            group.displayGroupContacts();
            System.out.println("=============================================");
        }
    }

    // Phương thức nhắc nhở cuộc gọi
    public List<String> remindCalls() {
        Date now = new Date(); // Lấy thời gian hiện tại
        List<String> reminders = new ArrayList<>(); // Danh sách nhắc nhở

        for (CallSchedule schedule : callSchedules) {
            if (schedule.getCallTime().before(now)) {
                reminders.add("Nhắc nhở: Đã đến thời gian cuộc gọi với " + schedule.getContactName());
            }
        }

        if (reminders.isEmpty()) {
            reminders.add("Không có cuộc gọi nào cần nhắc nhở.");
        }

        return reminders; // Trả về danh sách nhắc nhở
    }
    
    // Phương thức nhắc nhở sinh nhật
    public void remindBirthdays() {
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        System.out.printf("%-15s %-20s %-25s\n", "Tên", "Số điện thoại", "Ngày sinh");
        System.out.println("-------------------------------------------------------------");

        boolean hasBirthday = false; // Cờ để kiểm tra xem có sinh nhật nào không

        for (Infor_Contact contact : contacts) {
            if (contact.getdob() != null) {
                Calendar dobCalendar = Calendar.getInstance();
                dobCalendar.setTime(contact.getdob());
                int dobMonth = dobCalendar.get(Calendar.MONTH);
                int dobDay = dobCalendar.get(Calendar.DAY_OF_MONTH);

                if (dobMonth == currentMonth && dobDay == currentDay) {
                    System.out.printf("%-15s %-20s %-25s\n", contact.getName(), contact.getPhone(), contact.getdob());
                    hasBirthday = true; // Đã tìm thấy ít nhất một sinh nhật
                }
            }
        }

        if (!hasBirthday) {
            System.out.println("Hôm nay không có sinh nhật nào.");
        }
    }
    
    // Phương thức thêm liên hệ đã tồn tại vào nhóm
    public void addContactToExistingGroup() {
        System.out.print("Nhập tên nhóm mà bạn muốn thêm liên hệ vào: ");
        String groupName = scanner.nextLine();
        System.out.print("Nhập tên liên hệ cần thêm: ");
        String contactName = scanner.nextLine();

        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                addContactToGroup(groupName, contact);
                System.out.println("Liên hệ " + contactName + " đã được thêm vào nhóm " + groupName);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với tên: " + contactName);
    }
    
    // Phương thức lên lịch cuộc gọi
    public void scheduleCall() {
        System.out.print("Nhập tên liên hệ: ");
        String contactName = scanner.nextLine();

        // Nhập ngày và giờ muốn lên lịch
        System.out.print("Nhập ngày muốn lên lịch (ngày/tháng/năm): ");
        String dateInput = scanner.nextLine();
        System.out.print("Nhập giờ muốn gọi (giờ:phút): ");
        String timeInput = scanner.nextLine();

        try {
            // Phân tích ngày và giờ
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date callTime = dateFormat.parse(dateInput + " " + timeInput);

            // Kiểm tra nếu thời gian cuộc gọi hợp lệ
            if (callTime.before(new Date())) {
                System.out.println("Thời gian cuộc gọi không hợp lệ. Vui lòng chọn thời gian trong tương lai.");
                return;
            }

            // Kiểm tra xem liên hệ có tồn tại trong danh sách không
            boolean contactExists = false;
            for (Infor_Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(contactName)) {
                    contactExists = true; // Tìm thấy liên hệ
                    break;
                }
            }

            if (!contactExists) {
                System.out.println("Liên hệ không tồn tại. Không thể lên lịch cuộc gọi.");
                return;
            }

            // Lên lịch cuộc gọi
            callSchedules.add(new CallSchedule(contactName, callTime));
            System.out.println("Cuộc gọi với " + contactName + " đã được lên lịch vào " + callTime);

            // Gọi phương thức hiển thị danh sách cuộc gọi đã lên lịch
            displayScheduledCalls();
        } catch (ParseException e) {
            System.out.println("Định dạng thời gian không hợp lệ. Vui lòng sử dụng định dạng dd/MM/yyyy HH:mm.");
        }
    }
    
    // Phương thức hiển thị các cuộc gọi đã lên lịch
    public void displayScheduledCalls() {
        if (callSchedules.isEmpty()) {
            System.out.println("Chưa có cuộc gọi nào được lên lịch.");
            return;
        }

        System.out.printf("%-20s %-25s\n", "Tên liên hệ", "Thời gian cuộc gọi");
        System.out.println("-------------------------------------------------------------");

        for (CallSchedule schedule : callSchedules) {
            schedule.displayScheduledCalls(); // Gọi phương thức hiển thị từ đối tượng CallSchedule
        }
    }
    
    // Phương thức cập nhật lại liên hệ
    public void updateContact() {
        System.out.print("Nhập tên hoặc số điện thoại của liên hệ cần cập nhật: ");
        String identifier = scanner.nextLine();
        Infor_Contact contactToUpdate = null;

        // Tìm liên hệ theo tên hoặc số điện thoại
        for (Infor_Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(identifier) || contact.getPhone().equals(identifier)) {
                contactToUpdate = contact;
                break; // Tìm thấy liên hệ, dừng vòng lặp
            }
        }

        // Nếu tìm thấy liên hệ, thực hiện cập nhật
        if (contactToUpdate != null) {
            // Nhập tên mới (bắt buộc)
            System.out.print("Nhập tên mới: ");
            String newName = scanner.nextLine();
            contactToUpdate.setName(newName); // Cập nhật tên mới

            // Nhập số điện thoại mới (bắt buộc)
            System.out.print("Nhập số điện thoại mới: ");
            String newPhone = scanner.nextLine();
            contactToUpdate.setPhone(newPhone); // Cập nhật số điện thoại mới

            // Câu hỏi gộp về việc cập nhật email và địa chỉ
            System.out.print("Bạn có muốn cập nhật email và địa chỉ không? (Y/N): ");
            String updateInfo = scanner.nextLine();

            String newEmail = null; // Mặc định là null
            String newAddress = null; // Mặc định là null

            if (updateInfo.equalsIgnoreCase("Y")) {
                // Cập nhật email mới
                System.out.print("Nhập email mới: ");
                newEmail = scanner.nextLine();

                // Cập nhật địa chỉ mới
                System.out.print("Nhập địa chỉ mới: ");
                newAddress = scanner.nextLine();
            }

            // Cập nhật thông tin liên hệ
            contactToUpdate.editContactInfo(contactToUpdate.getName(), newPhone, null, newEmail, newAddress);

            // Kiểm tra loại liên hệ để cập nhật các thuộc tính riêng
            if (contactToUpdate instanceof PersonalContact) {
                System.out.print("Nhập nickname mới (hoặc nhấn Enter để giữ nguyên): ");
                String newNickname = scanner.nextLine();
                if (!newNickname.trim().isEmpty()) {
                    ((PersonalContact) contactToUpdate).setNickname(newNickname);
                }
            } else if (contactToUpdate instanceof BusinessContact) {
                System.out.print("Nhập tên công ty mới (hoặc nhấn Enter để giữ nguyên): ");
                String newCompanyName = scanner.nextLine();
                if (!newCompanyName.trim().isEmpty()) {
                    ((BusinessContact) contactToUpdate).setCompanyName(newCompanyName);
                }

                System.out.print("Nhập vị trí mới (hoặc nhấn Enter để giữ nguyên): ");
                String newPosition = scanner.nextLine();
                if (!newPosition.trim().isEmpty()) {
                    ((BusinessContact) contactToUpdate).setPosition(newPosition);
                }
            }

            System.out.println("Thông tin đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy liên hệ với tên hoặc số điện thoại: " + identifier);
        }
    }
}