package JAVA_DTN3_PHONEBOOKMANAGER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PhoneBook implements IContact_Manager {
    protected ArrayList<Infor_Contact> phonebook;
    private List<Infor_Contact> contacts = new ArrayList<>();
    private List<GroupContact> groups = new ArrayList<>(); // Composition: danh sách nhóm liên hệ
    private List<CallSchedule> callSchedules = new ArrayList<>();
    static final Scanner scanner = new Scanner(System.in);
    private BlockedContact blockedContactList = new BlockedContact(this);
    private static final String fileName = "D:\\PHONEBOOK.txt";

    public PhoneBook() {
        this.phonebook = new ArrayList<>();
    }
    
    // Phương thức thêm liên hệ
    public void addContact(Infor_Contact contact) {
        if (!isContactExists(contact.getName(), contact.getPhone())) {
            phonebook.add(contact);
            // Gọi phương thức nhập biệt danh nếu liên hệ là PersonalContact
            if (contact instanceof PersonalContact) {
                ((PersonalContact) contact).enterNickname(scanner); // Chỉ yêu cầu nhập biệt danh ở đây
            }
            else if (contact instanceof BusinessContact) {
                ((BusinessContact) contact).enterInforBusiness(scanner); // Chỉ yêu cầu nhập biệt danh ở đây
            }
            System.out.println("Liên hệ đã được thêm thành công.");
            
        } else {
            System.out.println("Cảnh báo: Thông tin liên hệ đã tồn tại. Vui lòng thử lại.");
        }
    }

    // Kiểm tra xem liên hệ đã tồn tại chưa
    public boolean isContactExists(String name, String phone) {
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(name) || contact.getPhone().equals(phone)) {
                return true; // Liên hệ đã tồn tại
            }
        }
        return false; // Liên hệ chưa tồn tại
    }
    
    // Phương thức để xóa tất cả liên hệ
    public void clearContacts() {
        phonebook.clear(); // Xóa tất cả liên hệ
        System.out.println("Tất cả liên hệ đã bị xóa.");
        
        // Ghi danh sách rỗng vào file
        WFile(); // Ghi lại vào file để cập nhật nội dung
    }

    // Phương thức để trả về danh sách liên hệ
    public ArrayList<Infor_Contact> getContacts() {
        return phonebook;
    }
    
    // Phương thức hiển thị tất cả liên hệ
    public void displayAllContacts() {
        if (phonebook.isEmpty()) {
            System.out.println("Không có liên hệ nào trong danh bạ");
        } 
        else {
            printTitle();
            for (Infor_Contact contact : phonebook) {
                displayContactRow(contact);
            }
        }
    }
    
    // In tiêu đề
    private void printTitle() {
        System.out.printf("%-20s %-20s %-30s %-25s %-20s %-15s %-30s\n",
                "Tên", "Số điện thoại", "Email", "Địa chỉ", "Nhóm", "Loại", "Thông tin khác");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Phương thức hiển thị các dòng liên hệ
    private void displayContactRow(Infor_Contact contact) {
        String groupName = getContactGroup(contact);
        String additionalInfo = ""; // Biến để lưu thông tin bổ sung

        if (contact instanceof PersonalContact) {
            String nickname = ((PersonalContact) contact).getNickname(); // Lấy biệt danh
            additionalInfo = String.format("Biệt danh: %s", nickname != null ? nickname : "Không có");
        } else if (contact instanceof BusinessContact) {
            BusinessContact businessContact = (BusinessContact) contact;
            additionalInfo = String.format("Công ty: %s, Chức vụ: %s", 
                            businessContact.getCompanyName() != null ? businessContact.getCompanyName() : "Không có", 
                            businessContact.getPosition() != null ? businessContact.getPosition() : "Không có");
        }

        System.out.printf("%-20s %-20s %-30s %-25s %-20s %-15s %-30s\n",
                contact.getName() != null ? contact.getName() : "Không có",
                contact.getPhone() != null ? contact.getPhone() : "Không có",
                contact.getEmail() != null ? contact.getEmail() : "Không có",
                contact.getAddress() != null ? contact.getAddress() : "Không có",
                groupName != null ? groupName : "Chưa phân nhóm",
                contact instanceof PersonalContact ? "Cá nhân" : "Công việc",
                additionalInfo);
    }
    
    // Phương thức xác định nhóm mà một liên hệ cụ thể thuộc về
    private String getContactGroup(Infor_Contact contact) {
        for (GroupContact group : groups) {
            if (group.getInforContact().contains(contact)) {
                return group.getGroupName();
            }
        }
        return "Chưa phân nhóm"; // Nếu liên hệ không thuộc nhóm nào
    }
    
    // Phương thức tìm kiếm liên hệ
    public void searchContacts(String keyword) {
        boolean found = false; // Biến cờ kiểm tra xem có liên hệ nào được tìm thấy không

        // Kiểm tra các liên hệ trong danh bạ
        for (Infor_Contact contact : phonebook) {
            // Kiểm tra xem liên hệ có bị chặn không
            if (blockedContactList.isBlocked(contact)) {
                System.out.println("Liên hệ " + contact.getName() + " đang bị chặn.");
                continue; // Bỏ qua những liên hệ bị chặn
            }

            // Kiểm tra nếu tên hoặc số điện thoại chứa từ khóa
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                contact.getPhone().contains(keyword)) {
                found = true; // Đã tìm thấy ít nhất một liên hệ
                break; // Thoát vòng lặp khi tìm thấy liên hệ
            }
        }

        // Hiển thị kết quả tìm kiếm
        if (found) {
            System.out.println("Kết quả tìm kiếm cho từ khóa: " + keyword);
            printTitle();
            for (Infor_Contact contact : phonebook) {
                // Hiển thị thông tin liên hệ
                if (!blockedContactList.isBlocked(contact) && 
                    (contact.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                     contact.getPhone().contains(keyword)) ) {
                    displayContactRow(contact);
                }
            }
        } else {
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

    // Phương thức thêm liên hệ vào nhóm mới
    private void addContactToNewGroup(GroupContact newGroup) {
        System.out.print("Bạn có muốn thêm liên hệ vào nhóm này không? (Y/N): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Bạn hãy nhập tên liên hệ hoặc số điện thoại để được thêm vào nhóm: ");
            String contactName = scanner.nextLine();

            for (Infor_Contact contact : phonebook) {
                if (contact.getName().equalsIgnoreCase(contactName) || contact.getPhone().equalsIgnoreCase(contactName)) {
                    // Kiểm tra xem liên hệ có bị chặn không
                    if (blockedContactList.isBlocked(contact)) {
                        System.out.println("Liên hệ " + contactName + " đang bị chặn, không thể thêm vào nhóm.");
                        return; // Ngừng thực hiện nếu liên hệ bị chặn
                    }

                    newGroup.addContact(contact);
                    System.out.println("Liên hệ " + contactName + " đã được thêm vào nhóm " + newGroup.getGroupName());
                    return; // Kết thúc phương thức
                }
            }
            System.out.println("Không tìm thấy liên hệ với tên: " + contactName);
        }
    }

    // Phương thức xóa liên hệ
    public void deleteContact(String identifier) {
        Infor_Contact contactToRemove = null;

        // Tìm liên hệ theo tên hoặc số điện thoại trong phonebook
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(identifier) || contact.getPhone().equals(identifier)) {
                contactToRemove = contact;
                break; // Tìm thấy liên hệ, dừng vòng lặp
            }
        }

        // Nếu tìm thấy liên hệ, thực hiện xóa
        if (contactToRemove != null) {
            phonebook.remove(contactToRemove); // Xóa khỏi danh sách phonebook
            System.out.println("Liên hệ " + contactToRemove.getName() + " đã được xóa.");

            // Ghi lại danh sách mới vào file
            WFile(); // Ghi lại danh bạ vào file
        } else {
            System.out.println("Không tìm thấy liên hệ với tên hoặc số điện thoại: " + identifier);
        }
    }

    // Phương thức hiển thị nhóm
    public void displayGroups() {
        if (groups.isEmpty()) {
            System.out.println("Chưa có nhóm nào được tạo.");
            return;
        }

        System.out.printf("%-20s %-25s\n", "Tên nhóm", "Số lượng liên hệ");
        System.out.println("-----------------------------------------------------------------");

        String lastDisplayedGroupName = ""; // Biến để theo dõi tên nhóm đã hiển thị

        for (GroupContact group : groups) {
            // Chỉ hiển thị nếu tên nhóm khác với tên nhóm đã hiển thị trước đó
            if (!group.getGroupName().equalsIgnoreCase(lastDisplayedGroupName)) {
                System.out.printf("%-20s %-25d\n", group.getGroupName(), group.getInforContact().size());
                lastDisplayedGroupName = group.getGroupName(); // Cập nhật tên nhóm đã hiển thị
            }
        }

        // Hỏi người dùng có muốn hiển thị thông tin chi tiết không
        System.out.print("Bạn có muốn hiển thị thông tin liên hệ chi tiết của nhóm không? (Y/N): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("\nThông tin chi tiết từng nhóm:");
            System.out.println("=============================================");
            lastDisplayedGroupName = ""; // Reset biến để sử dụng cho hiển thị chi tiết
            
            for (GroupContact group : groups) {
                // Hiển thị thông tin nhóm chi tiết một lần
                if (!group.getGroupName().equalsIgnoreCase(lastDisplayedGroupName)) {
                    System.out.println("Nhóm: " + group.getGroupName());
                    group.displayGroupContacts();
                    System.out.println("=============================================");
                    lastDisplayedGroupName = group.getGroupName(); // Cập nhật tên nhóm đã hiển thị
                }
            }
        } 
        else {
            System.out.println("Thông tin chi tiết đã bị bỏ qua.");
        }
    }

    // Phương thức nhắc nhở cuộc gọi
    public List<String> remindCalls() {
        Date now = new Date();
        List<String> reminders = new ArrayList<>();

        for (CallSchedule schedule : callSchedules) {
            // Kiểm tra nếu thời gian cuộc gọi lớn hơn hoặc bằng thời gian hiện tại
            if (!schedule.getCallTime().before(now)) {
                // Lấy thông tin liên hệ
                Infor_Contact contact = getContactByName(schedule.getContactName());
                if (contact != null) {
                    // Kiểm tra xem liên hệ có bị chặn không
                    if (blockedContactList.isBlocked(contact)) {
                        reminders.add("Liên hệ " + contact.getName() + " đang bị chặn, không có nhắc nhở.");
                    } else {
                        reminders.add("Nhắc nhở: Đã đến thời gian cuộc gọi với " + contact.getName() + " vào lúc " + schedule.getCallTime());
                    }
                } else {
                    reminders.add("Không tìm thấy thông tin liên hệ cho " + schedule.getContactName());
                }
            }
        }

        if (reminders.isEmpty()) {
            reminders.add("Không có cuộc gọi nào cần nhắc nhở.");
        }

        return reminders; // Trả về danh sách nhắc nhở
    }

    // Phương thức lấy thông tin liên hệ theo tên
    private Infor_Contact getContactByName(String name) {
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Không tìm thấy liên hệ
    }
    
    // Phương thức nhắc nhở sinh nhật
    public void remindBirthdays() {
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        List<Infor_Contact> birthdayContacts = new ArrayList<>();

        for (Infor_Contact contact : phonebook) {
            // Kiểm tra xem liên hệ có bị chặn không
            if (blockedContactList.isBlocked(contact)) {
                continue; // Bỏ qua những liên hệ bị chặn
            }

            if (contact.getdob() != null) {
                Calendar dobCalendar = Calendar.getInstance();
                dobCalendar.setTime(contact.getdob());
                int dobMonth = dobCalendar.get(Calendar.MONTH);
                int dobDay = dobCalendar.get(Calendar.DAY_OF_MONTH);

                if (dobMonth == currentMonth && dobDay == currentDay) {
                    birthdayContacts.add(contact);
                }
            }
        }

        if (!birthdayContacts.isEmpty()) {
            System.out.println("Nhắc nhở sinh nhật hôm nay (" + new SimpleDateFormat("dd/MM/yyyy").format(today.getTime()) + "):");
            System.out.printf("%-15s %-20s %-25s\n", "Tên", "Số điện thoại", "Ngày sinh");
            System.out.println("-------------------------------------------------------------");
            for (Infor_Contact contact : birthdayContacts) {
                System.out.printf("%-15s %-20s %-25s\n", contact.getName(), contact.getPhone(), new SimpleDateFormat("dd/MM/yyyy").format(contact.getdob()));
            }
        } else {
            System.out.println("Không có sinh nhật nào vào ngày " + new SimpleDateFormat("dd/MM/yyyy").format(today.getTime()) + ".");
        }
    }
    
    // Phương thức thêm liên hệ đã tồn tại vào nhóm
    public void addContactToExistingGroup() {
        System.out.print("Nhập tên nhóm mà bạn muốn thêm liên hệ vào: ");
        String groupName = scanner.nextLine();

        // Kiểm tra xem nhóm có tồn tại không
        GroupContact targetGroup = null;
        for (GroupContact group : groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                targetGroup = group;
                break; // Thoát vòng lặp nếu tìm thấy nhóm
            }
        }

        // Nếu nhóm không tồn tại, thông báo và kết thúc phương thức
        if (targetGroup == null) {
            System.out.println("Nhóm " + groupName + " chưa được tạo. Vui lòng tạo nhóm với tên này trước.");
        } else {
            // Nếu nhóm tồn tại, tiếp tục yêu cầu nhập tên hoặc số điện thoại của liên hệ
            System.out.print("Nhập tên hoặc số điện thoại của liên hệ cần thêm: ");
            String input = scanner.nextLine();

            // Kiểm tra xem liên hệ có tồn tại không
            Infor_Contact contactToAdd = null;
            for (Infor_Contact contact : phonebook) { // Duyệt qua danh sách liên hệ
                if (contact.getName().equalsIgnoreCase(input) || contact.getPhone().equals(input)) {
                    contactToAdd = contact;
                    break; // Thoát vòng lặp nếu tìm thấy liên hệ
                }
            }

            // Thêm liên hệ vào nhóm
            if (contactToAdd != null) {
                // Kiểm tra xem liên hệ có bị chặn không
                if (blockedContactList.isBlocked(contactToAdd)) {
                    System.out.println("Liên hệ " + contactToAdd.getName() + " đang bị chặn, không thể thêm vào nhóm.");
                } else {
                    targetGroup.addContact(contactToAdd); // Thêm liên hệ vào nhóm
                    System.out.println("Liên hệ " + contactToAdd.getName() + " đã được thêm vào nhóm " + groupName);
                }
            } else {
                System.out.println("Không tìm thấy liên hệ với tên hoặc số điện thoại: " + input);
            }
        }
    }
    
    // Phương thức lên lịch cuộc gọi
    public void scheduleCall() {
        System.out.print("Nhập tên liên hệ muốn lên lịch gọi: ");
        String contactName = scanner.nextLine();

        // Kiểm tra nếu liên hệ bị chặn ngay sau khi nhập tên
        Infor_Contact contactToSchedule = null;
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                contactToSchedule = contact;
                break;
            }
        }

        // Nếu không tìm thấy liên hệ
        if (contactToSchedule == null) {
            System.out.println("Liên hệ không tồn tại. Không thể lên lịch cuộc gọi.");
            return;
        }

        // Kiểm tra nếu liên hệ bị chặn
        if (blockedContactList.isBlocked(contactToSchedule)) {
            System.out.println("Liên hệ " + contactName + " đang bị chặn, không thể lên lịch cuộc gọi.");
            return;
        }

        // Nhập ngày và giờ nếu liên hệ không bị chặn
        System.out.print("Nhập ngày muốn lên lịch (ngày/tháng/năm): ");
        String dateInput = scanner.nextLine();
        System.out.print("Nhập vào giờ bạn muốn gọi (giờ:phút): ");
        String timeInput = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date callTime = dateFormat.parse(dateInput + " " + timeInput);

            // Thêm lịch gọi
            callSchedules.add(new CallSchedule(contactName, callTime));
            System.out.println("Cuộc gọi với " + contactName + " đã được bạn lên lịch vào " + callTime);
        } catch (ParseException e) {
            System.out.println("Định dạng thời gian không hợp lệ. Vui lòng sử dụng định dạng dd/MM/yyyy HH:mm.");
        }
    }
    
    // Phương thức hiển thị các cuộc gọi đã lên lịch
    public void displayScheduledCallsForDate() {
        // Nhập ngày cần xem lịch gọi
        System.out.print("Nhập ngày (ngày/tháng/năm) để xem lịch gọi: ");
        String dateInput = scanner.nextLine();

        try {
            // Phân tích ngày đã nhập
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date inputDate = dateFormat.parse(dateInput);

            // Tiêu đề cho danh sách cuộc gọi
            System.out.println("------------- Danh sách các cuộc gọi đã lên lịch ------------");
            System.out.printf("%-20s %-25s\n", "Tên liên hệ", "Thời gian cuộc gọi");
            System.out.println("-------------------------------------------------------------");

            // Lặp qua danh sách cuộc gọi đã lên lịch để tìm các cuộc gọi cho ngày đã nhập
            boolean hasCalls = false; // Biến để kiểm tra xem có cuộc gọi nào trong ngày không
            for (CallSchedule call : callSchedules) {
                // So sánh ngày (chỉ lấy ngày, tháng, năm) và kiểm tra xem liên hệ có bị chặn không
                if (isSameDay(call.getCallTime(), inputDate)) {
                    Infor_Contact contact = getContactByName(call.getContactName());
                    if (contact != null && !blockedContactList.isBlocked(contact)) {
                        System.out.printf("%-20s %-25s\n", contact.getName(), call.getCallTime());
                        hasCalls = true;
                    }
                }
            }

            // Nếu không có cuộc gọi nào
            if (!hasCalls) {
                System.out.println("Không có cuộc gọi nào đã lên lịch cho ngày này.");
            }
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng sử dụng định dạng dd/MM/yyyy.");
        }
    }

    // Phương thức kiểm tra xem hai ngày có cùng ngày, tháng, năm không
    private boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date1).equals(dateFormat.format(date2));
    }
    
    // Phương thức cập nhật lại liên hệ
    public void updateContact() {
        System.out.print("Nhập tên hoặc số điện thoại của liên hệ cần cập nhật: ");
        String identifier = scanner.nextLine();
        Infor_Contact contactToUpdate = null;

        // Tìm liên hệ theo tên hoặc số điện thoại
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(identifier) || contact.getPhone().equals(identifier)) {
                contactToUpdate = contact;
                break; // Tìm thấy liên hệ, dừng vòng lặp
            }
        }

        // Nếu tìm thấy liên hệ
        if (contactToUpdate != null) {
            // Kiểm tra xem liên hệ có bị chặn không
            if (blockedContactList.isBlocked(contactToUpdate)) {
                System.out.println("Liên hệ " + contactToUpdate.getName() + " đang bị chặn, không thể cập nhật.");
                return;
            }

            // Nhập tên mới
            System.out.print("Bạn có muốn cập nhật lại tên liên hệ không? (Y: Có, N: Giữ Nguyên): ");
            String updateInfo = scanner.nextLine();
            if (updateInfo.equalsIgnoreCase("Y")) {
                // Nhập tên mới (bắt buộc)
                System.out.print("Nhập tên mới: ");
                String newName = scanner.nextLine();
                contactToUpdate.setName(newName); // Cập nhật tên mới
            }

            // Nhập số điện thoại mới (bắt buộc)
            System.out.print("Bạn có muốn cập nhật lại số điện thoại không? (Y: Có, N: Giữ Nguyên): ");
            updateInfo = scanner.nextLine();
            if (updateInfo.equalsIgnoreCase("Y")) {
                // Cập nhật số điện thoại mới
                System.out.print("Nhập số điện thoại mới: ");
                String newPhone = scanner.nextLine();
                contactToUpdate.setPhone(newPhone); // Cập nhật số điện thoại mới
            }

            // Câu hỏi gộp về việc cập nhật email và địa chỉ
            System.out.print("Bạn có muốn cập nhật email và địa chỉ không? (Y: Có, N: Giữ Nguyên): ");
            updateInfo = scanner.nextLine();

            if (updateInfo.equalsIgnoreCase("Y")) {
                // Cập nhật email mới
                System.out.print("Nhập email mới: ");
                String newEmail = scanner.nextLine();
                contactToUpdate.setEmail(newEmail); // Cập nhật email

                // Cập nhật địa chỉ mới
                System.out.print("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                contactToUpdate.setAddress(newAddress); // Cập nhật địa chỉ
            }

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

    @Override
    public void RFile() {
        List<Infor_Contact> existingContacts = new ArrayList<>(); // Danh sách lưu trữ các liên hệ đã tồn tại

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isEmptyFile = true; // Biến kiểm tra xem file có rỗng hay không

            while ((line = br.readLine()) != null) {
                isEmptyFile = false; // Nếu có ít nhất một dòng, file không rỗng
                line = line.trim();
                if (line.isEmpty()) continue; // Bỏ qua dòng trống

                String[] info = line.split(","); // Tách các trường bằng dấu phẩy

                // Kiểm tra số lượng phần tử
                if (info.length < 7) { // Cần ít nhất 7 phần tử
                    System.out.println("Dòng không hợp lệ: " + line);
                    continue;
                }

                int type = Integer.parseInt(info[0].trim()); // Lấy loại liên hệ
                Infor_Contact contact = null;

                // Kiểm tra loại liên hệ
                if (type == 1) { // PersonalContact
                    String name = info[1].trim();
                    String phone = info[2].trim();
                    Date dob = info[3].trim().equals("null") ? null : new SimpleDateFormat("dd/MM/yyyy").parse(info[3].trim());
                    String email = info[4].trim().equals("null") ? null : info[4].trim();
                    String address = info[5].trim().equals("null") ? null : info[5].trim();
                    String nickname = info.length > 6 ? (info[6].trim().equals("null") ? null : info[6].trim()) : null;

                    contact = new PersonalContact(name, phone, dob, email, address, nickname);
                } else if (type == 2) { // BusinessContact
                    String name = info[1].trim();
                    String phone = info[2].trim();
                    Date dob = info[3].trim().equals("null") ? null : new SimpleDateFormat("dd/MM/yyyy").parse(info[3].trim());
                    String email = info[4].trim().equals("null") ? null : info[4].trim();
                    String address = info[5].trim().equals("null") ? null : info[5].trim();
                    String companyName = info[6].trim().equals("null") ? null : info[6].trim();
                    String position = info.length > 7 ? (info[7].trim().equals("null") ? null : info[7].trim()) : null;

                    contact = new BusinessContact(name, phone, dob, email, address, companyName, position);
                }

                // Thêm liên hệ vào danh sách nếu không null và chưa tồn tại
                if (contact != null && !isContactExists(contact.getName(), contact.getPhone())) {
                    this.phonebook.add(contact);
                    this.contacts.add(contact); // Thêm vào danh sách contacts
                } else {
                    // Lưu các liên hệ đã tồn tại vào danh sách
                    existingContacts.add(contact);
                }
            }

            // Kiểm tra xem file có rỗng không
            if (isEmptyFile) {
                System.out.println("Không có dữ liệu trong file để xuất.");
            } else {
                System.out.println("Đã xuất danh bạ thành công!");

                // In danh sách các liên hệ đã tồn tại nếu có
                if (!existingContacts.isEmpty()) {
                    System.out.println("Các liên hệ này đã tồn tại trong danh bạ:");
                    System.out.printf("%-15s %-20s\n", "Tên liên hệ", "Số điện thoại");
                    System.out.println("------------------------------");
                    for (Infor_Contact existingContact : existingContacts) {
                        System.out.printf("%-15s %-20s\n", existingContact.getName(), existingContact.getPhone());
                    }
                }
            }
        } 
        catch (IOException | ParseException e) {
            System.out.println("Lỗi khi xử lý thông tin: " + e.getMessage());
        }
    }

    @Override
    public void WFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (phonebook.isEmpty()) {
                System.out.println("Danh sách liên hệ rỗng, không có gì để ghi.");
                return;
            }
            for (Infor_Contact contact : phonebook) {
                StringBuilder line = new StringBuilder();
                line.append(contact instanceof BusinessContact ? 2 : 1).append(",") // Loại liên hệ
                    .append(contact.getName() != null ? contact.getName() : "null").append(",")
                    .append(contact.getPhone() != null ? contact.getPhone() : "null").append(",")
                    .append(contact.getdob() != null ? new SimpleDateFormat("dd/MM/yyyy").format(contact.getdob()) : "null").append(",")
                    .append(contact.getEmail() != null ? contact.getEmail() : "null").append(",")
                    .append(contact.getAddress() != null ? contact.getAddress() : "null").append(",");

                if (contact instanceof BusinessContact) {
                    BusinessContact businessContact = (BusinessContact) contact;
                    line.append(businessContact.getCompanyName() != null ? businessContact.getCompanyName() : "null").append(",")
                        .append(businessContact.getPosition() != null ? businessContact.getPosition() : "null");
                } else if (contact instanceof PersonalContact) {
                    PersonalContact personalContact = (PersonalContact) contact;
                    String nickname = personalContact.getNickname();
                    line.append(nickname != null ? nickname : "null");
                }

                writer.write(line.toString());
                writer.newLine(); // Thêm dòng mới
            }
            System.out.println("Ghi danh bạ thành công!");
        } 
        catch (IOException e) {
            System.out.println("Lỗi khi ghi danh bạ: " + e.getMessage());
        }
    }
    
    // Phương thức chặn liên hệ
    public void blockContact(String identifier) {
        // Gọi phương thức tìm kiếm và kiểm tra kết quả
        searchContacts(identifier); // Gọi phương thức tìm kiếm

        // Kiểm tra xem có liên hệ nào tồn tại không
        boolean found = false;
        for (Infor_Contact contact : phonebook) {
            if (contact.getName().toLowerCase().contains(identifier.toLowerCase()) || 
                contact.getPhone().contains(identifier)) {
                found = true; // Đánh dấu đã tìm thấy ít nhất một liên hệ
                blockedContactList.blockContact(contact); // Chặn liên hệ ngay lập tức
                break; // Thoát khỏi vòng lặp nếu đã tìm thấy
            }
        }
    }
        
    // Phương thức mở khóa liên hệ bị chặn
    public void unblockContact(String identifier) {
        // Kiểm tra nếu có liên hệ nào khớp với từ khóa
        List<Infor_Contact> matchingContacts = new ArrayList<>(); // Danh sách lưu trữ các liên hệ khớp

        for (Infor_Contact contact : phonebook) {
            if (contact.getName().toLowerCase().contains(identifier.toLowerCase()) || 
                contact.getPhone().contains(identifier)) {
                matchingContacts.add(contact); // Thêm vào danh sách nếu khớp
            }
        }

        // Nếu không có liên hệ nào khớp, thông báo
        if (matchingContacts.isEmpty()) {
            System.out.println("Không tìm thấy liên hệ nào với từ khóa: " + identifier);
            return; // Kết thúc phương thức
        }

        // Nếu có liên hệ khớp, in ra thông tin và mở khóa
        for (Infor_Contact contact : matchingContacts) {
            if (blockedContactList.isBlocked(contact)) { // Kiểm tra xem liên hệ có bị chặn không
                blockedContactList.unblockContact(contact); // Mở khóa liên hệ
            } 
            else {
                System.out.println("Liên hệ " + contact.getName() + " không bị chặn.");
            }
        }
    }

    // Phương thức xem danh sách các liên hệ bị chặn
    public void displayBlockedContacts() {
        List<Infor_Contact> blockedContacts = blockedContactList.getBlockedContacts();

        if (blockedContacts.isEmpty()) {
            System.out.println("Không có liên hệ nào trong danh sách chặn.");
            return;
        }
        
        System.out.println("Danh sách các liên hệ bị chặn:");
        System.out.printf("%-15s %-20s\n", "Tên", "Số điện thoại");
        System.out.println("-----------------------------");

        for (Infor_Contact contact : blockedContacts) {
            System.out.printf("%-15s %-20s\n", contact.getName(), contact.getPhone());
        }
    }
}
