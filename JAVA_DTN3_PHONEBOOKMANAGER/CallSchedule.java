package JAVA_DTN3_PHONEBOOKMANAGER;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CallSchedule {
    private String contactName;
    private Date callTime;

    public CallSchedule(String contactName, Date callTime) {
        this.contactName = contactName;
        this.callTime = callTime;
    }

    public String getContactName() {
        return contactName;
    }

    public Date getCallTime() {
        return callTime;
    }
    
    public void displayScheduledCalls() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("Liên hệ: " + contactName + ", Thời gian: " + dateFormat.format(callTime));
    }
}