package JAVA_DTN3_QLDBDT_BS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_ContactManager {
    private static PhoneBook phoneBook = new PhoneBook();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choice;
        do {
            System.out.println("---------------------------- MENU ------------------------------");
            System.out.println("1.  Thêm khách hàng Cá Nhân                                     ");
            System.out.println("2.  Thêm khách hàng Doanh Nghiệp                                ");
            System.out.println("3.  Hiển thị tất cả liên hệ                                     ");
            System.out.println("4.  Tìm kiếm liên hệ                                            ");
            System.out.println("5.  Tạo nhóm liên hệ                                            ");
            System.out.println("6.  Thêm liên hệ vào nhóm đã tạo                                ");
            System.out.println("7.  Hiển thị nhóm liên hệ                                       ");
            System.out.println("8.  Nhắc nhở sinh nhật                                          ");
            System.out.println("9.  Lên lịch cuộc gọi                                           ");
            System.out.println("10. Hiển thị cuộc gọi đã lên lịch                               ");
            System.out.println("11. Cập nhật thông tin liên hệ                                  ");
            System.out.println("12. Thoát chương trình                                          ");
            System.out.println("---------------------------- MENU ------------------------------");

            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1: // Thêm khách hàng Cá Nhân
                    PersonalContact person = new PersonalContact();
                    person.EnterContact(scanner);
                    if (person.validateContactInfo())
                        phoneBook.addContact(person);
                    else
                        System.out.println("Thông tin liên hệ không hợp lệ. Không thể thêm vào danh bạ.");
                    break;
                case 2: // Thêm khách hàng Doanh Nghiệp
                    BusinessContact business = new BusinessContact(); 
                    business.EnterContact(scanner); 
                    phoneBook.addContact(business);
                    break;
                case 3: // Hiển thị tất cả liên hệ
                    phoneBook.displayAllContacts();
                    break;
                case 4: // Tìm kiếm liên hệ
                    System.out.print("Nhập vào tên hoặc số điện thoại cần tìm: ");
                    String keyword = scanner.nextLine();
                    phoneBook.searchContacts(keyword);
                    break;
                case 5: // Tạo nhóm liên hệ
                    System.out.print("Nhập tên nhóm: ");
                    String groupName = scanner.nextLine();
                    phoneBook.createGroup(groupName);
                    break;
                case 6: // Thêm liên hệ vào nhóm đã tạo
                    addContactToExistingGroup();
                    break;
                case 7: // Hiển thị nhóm liên hệ
                    phoneBook.displayGroups();
                    break;
                case 8: // Nhắc nhở sinh nhật
                    phoneBook.remindBirthdays();
                    break;
                case 9: // Lên lịch cuộc gọi
                    scheduleCall();
                    break;
                case 10: // Hiển thị cuộc gọi đã lên lịch
                    phoneBook.displayScheduledCalls();
                    break;
                case 11: // Cập nhật thông tin liên hệ
                    updateContact();
                    break;
                case 12: // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 12);
    }

    private static void addContactToExistingGroup() {
        System.out.print("Nhập tên nhóm mà bạn muốn thêm liên hệ vào: ");
        String groupName = scanner.nextLine();
        System.out.print("Nhập tên liên hệ cần thêm: ");
        String contactName = scanner.nextLine();

        for (Infor_Contact contact : phoneBook.getContacts()) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                phoneBook.addContactToGroup(groupName, contact);
                System.out.println("Liên hệ " + contactName + " đã được thêm vào nhóm " + groupName);
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với tên: " + contactName);
    }

    private static void scheduleCall() {
        System.out.print("Nhập tên liên hệ: ");
        String contactName = scanner.nextLine();
        System.out.print("Nhập thời gian cuộc gọi (ngày/tháng/năm giờ:phút): ");
        String timeInput = scanner.nextLine();
        try {
            Date callTime = dateFormat.parse(timeInput);
            phoneBook.scheduleCall(contactName, callTime);
        } catch (ParseException e) {
            System.out.println("Định dạng thời gian không hợp lệ.");
        }
    }

    private static void updateContact() {
        System.out.print("Nhập tên liên hệ cần cập nhật: ");
        String name = scanner.nextLine();
        for (Infor_Contact contact : phoneBook.getContacts()) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Nhập số điện thoại mới: ");
                String phone = scanner.nextLine();
                System.out.print("Nhập email mới: ");
                String email = scanner.nextLine();
                System.out.print("Nhập địa chỉ mới: ");
                String address = scanner.nextLine();
                contact.editContactInfo(name, phone, null, email, address);
                System.out.println("Thông tin đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với tên: " + name);
    }
}