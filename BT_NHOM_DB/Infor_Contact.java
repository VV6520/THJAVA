package BT_NHOM_DB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class Infor_Contact {

    protected String name;
    protected String phone;
    protected LocalDate dob; 
    protected String email;
    protected String address;

    public Infor_Contact() {
        this.name = "";
        this.phone = "";
        this.dob = null;
        this.email = "";
        this.address = "";
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void enterContact(Scanner scanner) {
        System.out.println("Nhập thông tin liên hệ:");

        System.out.print("Tên: ");
        this.name = scanner.nextLine();

        System.out.print("Số điện thoại: ");
        this.phone = scanner.nextLine();

        System.out.print("Ngày sinh (yyyy-MM-dd): ");
        String dobInput = scanner.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dob = LocalDate.parse(dobInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày sinh không hợp lệ. Ngày sinh sẽ để trống.");
            this.dob = null;
        }

        System.out.print("Email: ");
        this.email = scanner.nextLine();

        System.out.print("Địa chỉ: ");
        this.address = scanner.nextLine();
    }

    public void displayContactInfo() {
        System.out.println("Thông tin liên hệ:");
        System.out.println("Tên: " + name);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Ngày sinh: " + (dob != null ? dob.toString() : "Không có"));
        System.out.println("Email: " + email);
        System.out.println("Địa chỉ: " + address);
    }

    public boolean validateContactInfo() {
        if (name == null || name.isEmpty()) {
            System.out.println("Xác thực thất bại: Tên không được để trống.");
            return false;
        }
        if (phone == null || phone.isEmpty()) {
            System.out.println("Xác thực thất bại: Số điện thoại không được để trống.");
            return false;
        }
        if (!phone.matches("\\d{10}")) {
            System.out.println("Xác thực thất bại: Số điện thoại phải gồm 10 chữ số.");
            return false;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Xác thực thất bại: Email không hợp lệ.");
            return false;
        }
        return true;
    }

    public void editContactInfor(Scanner scanner) {
        System.out.println("Chỉnh sửa thông tin liên hệ:");
        
        System.out.print("Tên hiện tại (" + name + "), nhập để sửa hoặc nhấn Enter để giữ nguyên: ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            this.name = newName;
        }

        System.out.print("Số điện thoại hiện tại (" + phone + "), nhập để sửa hoặc nhấn Enter để giữ nguyên: ");
        String newPhone = scanner.nextLine();
        if (!newPhone.isEmpty()) {
            this.phone = newPhone;
        }

        System.out.print("Ngày sinh hiện tại (" + (dob != null ? dob.toString() : "Không có") + "), nhập để sửa hoặc nhấn Enter để giữ nguyên: ");
        String dobInput = scanner.nextLine();
        if (!dobInput.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.dob = LocalDate.parse(dobInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ. Ngày sinh giữ nguyên.");
            }
        }

        System.out.print("Email hiện tại (" + email + "), nhập để sửa hoặc nhấn Enter để giữ nguyên: ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            this.email = newEmail;
        }

        System.out.print("Địa chỉ hiện tại (" + address + "), nhập để sửa hoặc nhấn Enter để giữ nguyên: ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            this.address = newAddress;
        }

        System.out.println("Chỉnh sửa hoàn tất.");
    }

	@Override
	public String toString() {
		return "Infor_Contact [name=" + name + ", phone=" + phone + ", dob=" + dob + ", email=" + email + ", address="
				+ address + "]";
	}

	public void editContactInfor() {
		// TODO Auto-generated method stub
		
	}
}
