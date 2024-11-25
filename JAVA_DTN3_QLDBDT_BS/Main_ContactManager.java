package JAVA_DTN3_QLDBDT_BS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        int choice;
        do {
            System.out.println("---------------------------- MENU ------------------------------");
            System.out.println("1.  Thêm mới liên hệ                                            ");
            System.out.println("2.  Xóa thông tin liên hệ                                       ");             
            System.out.println("3.  Cập nhật thông tin liên hệ                                  ");  
            System.out.println("4.  Tìm kiếm thông tin liên hệ                                  ");            
            System.out.println("5.  Hiển thị tất cả liên hệ                                     ");
            System.out.println("6.  Tạo nhóm cho các liên hệ                                    ");
            System.out.println("7.  Thêm liên hệ vào nhóm đã tạo                                ");
            System.out.println("8.  Hiển thị nhóm liên hệ                                       ");
            System.out.println("9.  Nhắc nhở sinh nhật                                          ");
            System.out.println("10. Nhắc nhở cuộc gọi khi đã lên lịch                           ");
            System.out.println("11. Hiển thị cuộc gọi đã lên lịch                               ");
            System.out.println("12. Thoát chương trình                                          ");
            System.out.println("---------------------------- MENU ------------------------------");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Thêm mới liên hệ
                    int choiceContact;
                    do
                    {
                        System.out.println("----------------MENU----------------");
                        System.out.println("1. Thêm Liên Hệ Cá Nhân             ");
                        System.out.println("2. Thêm Liên Hệ Doanh Nghiệp        ");
                        System.out.println("0. Thoát                            ");
                        System.out.println("----------------MENU----------------");

                        System.out.print("Nhập lựa chọn: ");
                        choiceContact = scanner.nextInt();
                        scanner.nextLine();

                        switch (choiceContact) 
                        {
                            case 1:
                                PersonalContact person = new PersonalContact();
                                person.enterContact(scanner);
                                if (person.validateContactInfo()) {
                                    phoneBook.addContact(person);
                                    showExtendedMenu(); // Hiển thị menu mở rộng
                                } 
                                else {
                                    System.out.println("Thông tin liên hệ không hợp lệ. Không thể thêm vào danh bạ.");
                                }
                                break;
                            case 2:
                                BusinessContact business = new BusinessContact(); 
                                business.enterContact(scanner); 
                                if (business.validateContactInfo()) {
                                    phoneBook.addContact(business);
                                    showExtendedMenu(); // Hiển thị menu mở rộng
                                } 
                                else {
                                    System.out.println("Thông tin liên hệ không hợp lệ. Không thể thêm vào danh bạ.");
                                }
                                break;
                            case 0:
                                System.out.println("Thoát chức năng thêm liên hệ.");
                                break;
                            default:
                                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                        }
                    } 
                    while (choiceContact != 0);
                    break;
                case 2: // Xóa thông tin liên hệ
                    System.out.print("Nhập tên hoặc số điện thoại liên hệ cần xóa: ");
                    String inforToDelete = scanner.nextLine();
                    phoneBook.deleteContact(inforToDelete);
                    break;
                case 3: // Cập nhật thông tin liên hệ
                    phoneBook.updateContact(); // Gọi phương thức từ PhoneBook
                    break;
                case 4: // Tìm kiếm liên hệ
                    System.out.print("Nhập vào tên hoặc số điện thoại cần tìm: ");
                    String keyword = scanner.nextLine();
                    phoneBook.searchContacts(keyword);
                    break;
                case 5: // Hiển thị tất cả liên hệ
                    phoneBook.displayAllContacts();
                    break;
                
                case 6: // Tạo nhóm liên hệ
                    System.out.print("Nhập tên nhóm: ");
                    String groupName = scanner.nextLine();
                    phoneBook.createGroup(groupName);
                    break;
                case 7: // Thêm liên hệ vào nhóm đã tạo
                    phoneBook.addContactToExistingGroup(); // Gọi phương thức từ PhoneBook
                    break;
                case 8: // Hiển thị nhóm liên hệ
                    phoneBook.displayGroups();
                    break;
                case 9: // Nhắc nhở sinh nhật
                    phoneBook.remindBirthdays();
                    break;
                case 10: // Nhắc nhở cuộc gọi
                    List<String> reminders = phoneBook.remindCalls(); // Gọi phương thức nhắc nhở cuộc gọi
                    for (String reminder : reminders) {
                        System.out.println(reminder); // Hiển thị từng nhắc nhở
                    }
                    break;
                case 11: // Hiển thị cuộc gọi đã lên lịch
                    phoneBook.displayScheduledCalls();
                    break;
                case 12: // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 12);
    }
    
    // Phương thức hiển thị menu tính năng khác
    private static void showExtendedMenu() {
        int extendedChoice;
        do {
            System.out.println("----------------------- TÍNH NĂNG KHÁC -------------------------");
            System.out.println("1. Tạo nhóm cho các liên hệ                                     ");
            System.out.println("2. Thêm liên hệ vào nhóm đã tạo                                 ");
            System.out.println("3. Hiển thị nhóm liên hệ                                        ");
            System.out.println("4. Nhắc nhở sinh nhật                                           ");
            System.out.println("5. Lên lịch cuộc gọi                                            ");
            System.out.println("6. Hiển thị cuộc gọi đã lên lịch                                ");
            System.out.println("0. Quay lại menu chính                                          ");
            System.out.println("----------------------------------------------------------------");

            System.out.print("Nhập lựa chọn của bạn: ");
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
                    phoneBook.displayScheduledCalls();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (extendedChoice != 0);
    }

}


