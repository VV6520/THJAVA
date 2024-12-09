package JAVA_DTN3_QLDBDT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main_ContactManager {
    private static PhoneBook phoneBook = new PhoneBook();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choose = 0;
        do {
            System.out.println("---------------------------- MENU ------------------------------");
            System.out.println("1.  Thêm mới liên hệ                                            ");
            System.out.println("2.  Xóa thông tin liên hệ                                       ");             
            System.out.println("3.  Cập nhật thông tin liên hệ                                  ");  
            System.out.println("4.  Tìm kiếm thông tin liên hệ                                  ");            
            System.out.println("5.  Xem danh bạ                                                 ");
            System.out.println("6.  Tạo nhóm cho các liên hệ                                    ");
            System.out.println("7.  Thêm liên hệ vào nhóm đã tạo                                ");
            System.out.println("8.  Hiển thị nhóm liên hệ                                       ");
            System.out.println("9.  Nhắc nhở sinh nhật                                          ");
            System.out.println("10. Lên lịch cuộc gọi                                           ");
            System.out.println("11. Nhắc nhở cuộc gọi khi đã lên lịch                           ");
            System.out.println("12. Hiển thị cuộc gọi đã lên lịch                               ");
            System.out.println("13. Xuất danh bạ                                                ");
            System.out.println("14. Nhập danh bạ                                                ");
            System.out.println("15. Xóa danh bạ                                                 ");
            System.out.println("16. Chặn liên hệ                                                ");
            System.out.println("17. Xem danh sách các liên hệ bị chặn                           ");
            System.out.println("18. Mở chặn liên hệ                                             ");
            System.out.println("19. Thoát chương trình                                          ");
            System.out.println("---------------------------- MENU ------------------------------");

            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choose = scanner.nextInt();
                scanner.nextLine();

                switch (choose) {
                    case 1:
                        showAddContactMenu();
                        break;
                    case 2:
                        System.out.print("Nhập tên hoặc số điện thoại liên hệ cần xóa: ");
                        String inforToDelete = scanner.nextLine();
                        phoneBook.deleteContact(inforToDelete);
                        break;
                    case 3:
                        phoneBook.updateContact();
                        break;
                    case 4:
                        System.out.print("Nhập vào tên hoặc số điện thoại cần tìm: ");
                        String keyword = scanner.nextLine();
                        phoneBook.searchContacts(keyword);
                        break;
                    case 5:
                        phoneBook.displayAllContacts();
                        break;
                    case 6:
                        System.out.print("Nhập tên nhóm: ");
                        String groupName = scanner.nextLine();
                        phoneBook.createGroup(groupName);
                        break;
                    case 7:
                        phoneBook.addContactToExistingGroup();
                        break;
                    case 8:
                        phoneBook.displayGroups();
                        break;
                    case 9:
                        phoneBook.remindBirthdays();
                        break;
                    case 10: // Lên lịch cuộc gọi
                        phoneBook.scheduleCall(); // Gọi phương thức từ PhoneBook
                        break;
                    case 11:
                        List<String> callReminders = phoneBook.remindCalls(); // Gọi phương thức nhắc nhở cuộc gọi
                        for (String reminder : callReminders) {
                            System.out.println(reminder); // Hiển thị nhắc nhở
                        }
                        break;
                    case 12:
                        phoneBook.displayScheduledCallsForDate();
                        break;
                    case 13:
                        phoneBook.RFile();
                        break;
                    case 14:
                        phoneBook.WFile();
                        break;
                    case 15:
                        phoneBook.clearContacts();
                        break;
                    case 16:
                        System.out.print("Nhập tên hoặc số điện thoại liên hệ cần chặn: ");
                        String contactToBlock = scanner.nextLine();
                        phoneBook.blockContact(contactToBlock);
                        break;
                    case 17:
                        phoneBook.displayBlockedContacts();
                        break;   
                    case 18:
                        System.out.print("Nhập tên hoặc số điện thoại liên hệ cần mở chặn: ");
                        String contactToUnblock = scanner.nextLine();
                        phoneBook.unblockContact(contactToUnblock);
                        break;
                    case 19:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
                scanner.next(); // Xóa giá trị không hợp lệ
            }
        } 
        while (choose != 19);
    }
    
    // Phương thức hiển thị menu tính năng khác
    private static void showExtendedMenu(Scanner scanner, Infor_Contact contact) {
        int extendedChoice = 0;
        do {
            System.out.println("----------------------- TÍNH NĂNG KHÁC -------------------------");
            System.out.println("1. Tạo nhóm cho các liên hệ                                     ");
            System.out.println("2. Thêm liên hệ vào nhóm đã tạo                                 ");
            System.out.println("3. Hiển thị các nhóm liên hệ                                    ");
            System.out.println("4. Nhắc nhở sinh nhật                                           ");
            System.out.println("5. Lên lịch cuộc gọi                                            ");
            System.out.println("6. Hiển thị cuộc gọi đã lên lịch                                ");
            System.out.println("7. Thoát                                                        ");
            System.out.println("----------------------------------------------------------------");

            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                extendedChoice = scanner.nextInt();
                scanner.nextLine();

                switch (extendedChoice) {
                    case 1:
                        System.out.print("Nhập tên nhóm: ");
                        String groupName = scanner.nextLine();
                        phoneBook.createGroup(groupName);
                        break;
                    case 2: // Thêm liên hệ vào nhóm đã tạo
                        phoneBook.addContactToExistingGroup(); // Gọi phương thức từ PhoneBook
                        break;
                    case 3:
                        phoneBook.displayGroups();
                        break;
                    case 4:
                        phoneBook.remindBirthdays();
                        break;
                    case 5: // Lên lịch cuộc gọi
                        phoneBook.scheduleCall(); // Gọi phương thức từ PhoneBook
                        break;
                    case 6:
                        phoneBook.displayScheduledCallsForDate();
                        break;
                    case 7:
                        System.out.println("Đã thoát menu chức năng khác.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
                scanner.next(); // Xóa giá trị không hợp lệ
            }
        }
        while (extendedChoice != 7);
    }
    
    private static void showAddContactMenu() {
        int choiceContact = 0;
        do {
            System.out.println("----------------MENU----------------");
            System.out.println("1. Thêm Liên Hệ Cá Nhân             ");
            System.out.println("2. Thêm Liên Hệ Doanh Nghiệp        ");
            System.out.println("0. Thoát                            ");
            System.out.println("----------------MENU----------------");

            System.out.print("Nhập lựa chọn: ");
            try {
                choiceContact = scanner.nextInt();
                scanner.nextLine();

                switch (choiceContact) {
                    case 1:
                        PersonalContact person = new PersonalContact();
                        person.enterContact(scanner, phoneBook); // Truyền phoneBook vào phương thức

                        if (person.validContactInfo()) {
                            // Kiểm tra xem liên hệ đã tồn tại hay chưa
                            if (!phoneBook.isContactExists(person.getName(), person.getPhone())) {
                                phoneBook.addContact(person); // Thêm liên hệ vào danh bạ
                                System.out.print("Bạn có muốn thực hiện tính năng khác không? (Y/N): ");
                                String Q = scanner.nextLine();
                                if (Q.equalsIgnoreCase("Y")) {
                                    showExtendedMenu(scanner, person); // Hiển thị menu mở rộng với đối tượng cá nhân
                                } else {
                                    menu(); // Gọi lại menu chính
                                }
                            } else {
                                System.out.println("Liên hệ đã tồn tại trong danh bạ.");
                            }
                        } else {
                            System.out.println("Thông tin liên hệ không hợp lệ. Không thể thêm vào danh bạ.");
                        }   
                        break;

                    case 2:
                        BusinessContact business = new BusinessContact();
                        business.enterContact(scanner, phoneBook); // Truyền phoneBook vào phương thức

                        if (business.validContactInfo()) {
                            // Kiểm tra xem liên hệ đã tồn tại hay chưa
                            if (!phoneBook.isContactExists(business.getName(), business.getPhone())) {
                                phoneBook.addContact(business); // Thêm liên hệ vào danh bạ
                                System.out.print("Bạn có muốn thực hiện tính năng khác không? (Y/N): ");
                                String Q = scanner.nextLine();
                                if (Q.equalsIgnoreCase("Y")) {
                                    showExtendedMenu(scanner, business); // Hiển thị menu mở rộng với đối tượng doanh nghiệp
                                } else {
                                    menu(); // Gọi lại menu chính
                                }
                            } else {
                                System.out.println("Liên hệ đã tồn tại trong danh bạ.");
                            }
                        } else {
                            System.out.println("Thông tin liên hệ không hợp lệ. Không thể thêm vào danh bạ.");
                        }
                        break;

                    case 0:
                        System.out.println("Thoát chức năng thêm liên hệ.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
                scanner.next(); // Xóa giá trị không hợp lệ
            }
        } 
        while (choiceContact != 0);
    }
 
}
