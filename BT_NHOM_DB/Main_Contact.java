package BT_NHOM_DB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main_Contact {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Chào mừng bạn đến với Quản lý Danh bạ!");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm Liên Hệ");
            System.out.println("2. Hiển Thị Tất Cả Liên Hệ");
            System.out.println("3. Tìm Kiếm Liên Hệ");
            System.out.println("4. Tạo Nhóm");
            System.out.println("5. Thêm Liên Hệ Vào Nhóm");
            System.out.println("6. Hiển Thị Danh Sách Nhóm");
            System.out.println("7. Thêm Lịch Gọi");
            System.out.println("8. Hiển Thị Lịch Gọi");
            System.out.println("9. Nhắc Nhở Sinh Nhật");
            System.out.println("10. Đọc Danh Bạ từ File");
            System.out.println("11. Ghi Danh Bạ ra File");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý dòng trống

            switch (choice) {
                case 1: // Thêm liên hệ
                    System.out.print("Nhập loại liên hệ (1. Doanh Nghiệp, 2. Cá Nhân): ");
                    int contactType = scanner.nextInt();
                    scanner.nextLine(); 

                    Infor_Contact contact = null;
                    if (contactType == 1) {
                        contact = new BusinessContact();
                    } else if (contactType == 2) {
                        contact = new PersonContact();
                    } else {
                        System.out.println("Loại liên hệ không hợp lệ!");
                        break;
                    }

                    contact.enterContact(scanner);
                    phoneBook.addContact(contact);
                    break;

                case 2: // Hiển thị tất cả liên hệ
                    phoneBook.displayAllContacts();
                    break;

                case 3: // Tìm kiếm liên hệ
                    System.out.print("Nhập từ khóa cần tìm: ");
                    String keyword = scanner.nextLine();
                    phoneBook.searchContacts(keyword);
                    break;

                case 4: // Tạo nhóm
                    System.out.print("Nhập tên nhóm: ");
                    String groupName = scanner.nextLine();
                    phoneBook.createGroup(groupName);
                    break;

                case 5: // Thêm liên hệ vào nhóm
                    System.out.print("Nhập tên liên hệ: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Nhập tên nhóm: ");
                    String groupNameToAdd = scanner.nextLine();
                    phoneBook.addContactToGroup(contactName, groupNameToAdd);
                    break;

                case 6: // Hiển thị danh sách nhóm
                    phoneBook.displayGroups();
                    break;

                case 7: // Thêm lịch gọi
                    System.out.print("Nhập tên liên hệ: ");
                    String scheduleContactName = scanner.nextLine();
                    System.out.print("Nhập thời gian gọi (yyyy-MM-dd HH:mm): ");
                    String callTimeInput = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    try {
                        LocalDateTime callTime = LocalDateTime.parse(callTimeInput, formatter);
                        // Thêm lịch gọi vào danh sách
                        phoneBook.getCallSchedules().add(new CallSchedule(scheduleContactName, callTime));
                        System.out.println("Đã thêm lịch gọi thành công!");
                    } catch (Exception e) {
                        System.out.println("Định dạng ngày không hợp lệ!");
                    }
                    break;

                case 8: // Hiển thị lịch gọi
                    for (CallSchedule schedule : phoneBook.getCallSchedules()) {
                        schedule.displaySchedule();
                    }
                    break;

                case 9: // Nhắc nhở sinh nhật
                    phoneBook.remindBirthdays();
                    break;
                case 10: // Đọc file
                    System.out.print("Nhập tên file: ");
                    String inputFile = scanner.nextLine();
                    phoneBook.DocFile(inputFile);
                    break;

                case 11: // Ghi file
                    System.out.print("Nhập tên file: ");
                    String outputFile = scanner.nextLine();
                    phoneBook.GhiFile(outputFile);
                    break;
                    
                case 0: // Thoát chương trình
                    exit = true;
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Tùy chọn không hợp lệ!");
            }
        }

        scanner.close();
    }
}
