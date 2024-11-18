package JAVA_DTN3_QLDBDT;

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
            System.out.println("----------------------- MENU ---------------------------------");
            System.out.println("1. Thêm khách hàng Cá Nhân                                     ");
            System.out.println("2. Thêm khách hàng Doanh Nghiệp                                ");
            System.out.println("3. Hiển thị tất cả liên hệ                                     ");
            System.out.println("4. Tìm kiếm liên hệ                                            ");
            System.out.println("5. Nhắc nhở sinh nhật                                          ");
            System.out.println("6. Lên lịch cuộc gọi                                          ");
            System.out.println("7. Hiển thị cuộc gọi đã lên lịch                               ");
            System.out.println("8. Cập nhật thông tin liên hệ                                   ");
            System.out.println("9. Thoát chương trình                                         ");
            System.out.println("---------------------- MENU ----------------------------------");

            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    addPersonContact();
                    break;
                case 2:
                    addBusinessContact();
                    break;
                case 3:
                    phoneBook.displayAllContacts();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    phoneBook.remindBirthdays();
                    break;
                case 6:
                    scheduleCall();
                    break;
                case 7:
                    phoneBook.displayScheduledCalls();
                    break;
                case 8:
                    updateContact();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 9);
    }

    private static void addPersonContact() {
        System.out.println("Thêm khách hàng Cá Nhân:");
        PersonalContact person = new PersonalContact(); 
        person.EnterContact(scanner); 
        phoneBook.addContact(person);
    }

    private static void addBusinessContact() {
        System.out.println("Thêm khách hàng Doanh Nghiệp:");
        BusinessContact business = new BusinessContact(); 
        business.EnterContact(scanner); 
        phoneBook.addContact(business);
    }

    private static void searchContact() {
        System.out.print("Nhập vào tên hoặc số điện thoại cần tìm: ");
        String keyword = scanner.nextLine();
        phoneBook.searchContacts(keyword);
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
                contact.editContactInfo(name, phone, null, email, address); // Cập nhật thông tin
                System.out.println("Thông tin đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên hệ với tên: " + name);
    }
}