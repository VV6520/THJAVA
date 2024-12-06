package BT_NHOM_DB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallSchedule {
    private String contactName;
    private LocalDateTime callTime;

    public CallSchedule(String contactName, LocalDateTime callTime) {
        this.contactName = contactName;
        this.callTime = callTime;
    }

    public String getContactName() {
        return contactName;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public void displaySchedule() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Contact: " + contactName + ", Call Time: " + callTime.format(formatter));
    }
}
